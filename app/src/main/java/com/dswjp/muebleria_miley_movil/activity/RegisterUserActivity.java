package com.dswjp.muebleria_miley_movil.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.databinding.ActivityRegisterUserBinding;
import com.dswjp.muebleria_miley_movil.dto.NewUserDTO;
import com.dswjp.muebleria_miley_movil.viewmodel.AuthViewModel;

import org.jetbrains.annotations.NotNull;

import java.io.File;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class RegisterUserActivity extends AppCompatActivity {

    private ActivityRegisterUserBinding binding;
    private File foto;
    private final static int LOCATION_REQUEST_CODE = 23;
    private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.initViewModel();
        binding.btnRegisterUser.setOnClickListener(v -> {
            this.guardarDatos();
        });
    }

    private void initViewModel() {
        final ViewModelProvider vmp = new ViewModelProvider(this);
        this.authViewModel = vmp.get(AuthViewModel.class);
    }

    private void guardarDatos() {
        if (validar()) {
            NewUserDTO newUserDTO = new NewUserDTO();
            try {
                newUserDTO.setFirstName(binding.edtFirstName.getText().toString());
                newUserDTO.setLastName(binding.edtLastName.getText().toString());
                newUserDTO.setEmail(binding.edtEmailUser.getText().toString());
                newUserDTO.setPassword(binding.edtPasswordUser.getText().toString());
                ;
                authViewModel.register(newUserDTO).observe(this, response -> {
                    if (response != null) {
                        toastOk("datos registrados");
                        new Handler(Looper.getMainLooper()).postDelayed(() -> {
                            Intent intent = new Intent(this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }, 3000);

                    } else {
                        toastError("no se pudo guardar datos");
                    }
                });
            } catch (Exception exception) {
                warningMessage("error al registrar usuario");
            }
        } else {
            errorMessage("por favor complete todos los campos");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    LOCATION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case LOCATION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Gracias por conceder los permisos para " +
                            "leer el almacenamiento, estos permisos son necesarios para poder " +
                            "escoger tu foto de perfil", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "No podemos realizar el registro si no nos concedes los permisos para leer el almacenamiento.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private boolean validar() {
        boolean retorno = true;
        /*if (this.foto == null) {
            toastIncorrecto("debe selecionar una foto de perfil");
            retorno = false;
        }
        if (binding.edtNameUser.getText().toString().isEmpty()) {
            binding.txtInputNameUser.setError("Ingresar nombres");
            retorno = false;
        } else {
            binding.txtInputNameUser.setErrorEnabled(false);
        }
        if (apellidoPaterno.isEmpty()) {
            txtInputApellidoPaternoU.setError("Ingresar apellido paterno");
            retorno = false;
        } else {
            txtInputApellidoPaternoU.setErrorEnabled(false);
        }
        if (apellidoMaterno.isEmpty()) {
            txtInputApellidoMaternoU.setError("Ingresar apellido materno");
            retorno = false;
        } else {
            txtInputApellidoMaternoU.setErrorEnabled(false);
        }
        if (numDoc.isEmpty()) {
            txtInputNumeroDocU.setError("Ingresar número documento");
            retorno = false;
        } else {
            txtInputNumeroDocU.setErrorEnabled(false);
        }
        if (telefono.isEmpty()) {
            txtInputTelefonoU.setError("Ingresar número telefónico");
            retorno = false;
        } else {
            txtInputTelefonoU.setErrorEnabled(false);
        }
        if (direccion.isEmpty()) {
            txtInputDireccionU.setError("Ingresar dirección de su casa");
            retorno = false;
        } else {
            txtInputDireccionU.setErrorEnabled(false);
        }
        if (dropTipoDoc.isEmpty()) {
            txtInputTipoDoc.setError("Seleccionar Tipo Doc");
            retorno = false;
        } else {
            txtInputTipoDoc.setErrorEnabled(false);
        }
        if (dropDepartamento.isEmpty()) {
            txtInputDepartamento.setError("Seleccionar Departamento");
            retorno = false;
        } else {
            txtInputDepartamento.setErrorEnabled(false);
        }
        if (dropProvincia.isEmpty()) {
            txtInputProvincia.setError("Seleccionar Provincia");
            retorno = false;
        } else {
            txtInputProvincia.setErrorEnabled(false);
        }
        if (dropDistrito.isEmpty()) {
            txtInputDistrito.setError("Seleccionar Distrito");
            retorno = false;
        } else {
            txtInputDistrito.setErrorEnabled(false);
        }*/

        if (binding.edtEmailUser.getText().toString().isEmpty()) {
            binding.txtInputEmailUser.setError("Ingresar correo electrónico");
            retorno = false;
        } else {
            binding.txtInputEmailUser.setErrorEnabled(false);
        }
        if (binding.edtPasswordUser.getText().toString().isEmpty()) {
            binding.txtInputPasswordUser.setError("Ingresar clave para el inicio de sesión");
            retorno = false;
        } else {
            binding.txtInputPasswordUser.setErrorEnabled(false);
        }
        return retorno;
    }

    private void toastOk(String message) {
        LayoutInflater layoutInflater = getLayoutInflater();
        ViewGroup root = findViewById(R.id.ll_custom_ok);
        View view = layoutInflater.inflate(R.layout.custom_toast_ok, root, false);
        TextView txtMensajeToastOk = view.findViewById(R.id.txtMensajeToastOk);
        txtMensajeToastOk.setText(message);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }
    public void toastError(String message) {
        LayoutInflater layoutInflater = getLayoutInflater();
        ViewGroup root = findViewById(R.id.ll_custom_ok);
        View view = layoutInflater.inflate(R.layout.custom_toast_error, root, false);
        TextView txtMensajeToastOk = view.findViewById(R.id.txtMensajeToastError);
        txtMensajeToastOk.setText(message);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }
    public void warningMessage(String message) {
        new SweetAlertDialog(this,
                SweetAlertDialog.WARNING_TYPE).setTitleText("Notificación del Sistema")
                .setContentText(message).setConfirmText("Ok").show();
    }
    public void errorMessage(String message) {
        new SweetAlertDialog(this,
                SweetAlertDialog.ERROR_TYPE).setTitleText("Oops...").setContentText(message).show();
    }
}