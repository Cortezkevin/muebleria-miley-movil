package com.dswjp.muebleria_miley_movil.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.databinding.ActivityLoginBinding;
import com.dswjp.muebleria_miley_movil.dto.LoginUserDTO;
import com.dswjp.muebleria_miley_movil.dto.security.JwtTokenDTO;
import com.dswjp.muebleria_miley_movil.utils.DateSerializer;
import com.dswjp.muebleria_miley_movil.utils.TimeSerializer;
import com.dswjp.muebleria_miley_movil.viewmodel.AuthViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.sql.Date;
import java.sql.Time;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.initViewModel();
        this.init();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            ImageView imageView = findViewById(R.id.imgFondo);
            imageView.setRenderEffect(RenderEffect.createBlurEffect(50, 50, Shader.TileMode.MIRROR));
        }
    }

    private void initViewModel() {
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
    }
    private void init() {
        binding.btnLogin.setOnClickListener(v -> {
            try {
                if (validate()) {
                    String email = binding.edtMail.getText().toString().trim();
                    String password = binding.edtPassword.getText().toString().trim();
                    LoginUserDTO loginUserDTO = new LoginUserDTO(email, password);
                    authViewModel.login(loginUserDTO).observe(this, response -> {
                        if (response != null) {
                            toastOk(response.getMessage());

                            JwtTokenDTO jwtTokenDTO = response.getContent();
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                            SharedPreferences.Editor editor = preferences.edit();
                            final Gson gson = new GsonBuilder()
                                    .registerTypeAdapter(Date.class, new DateSerializer())
                                    .registerTypeAdapter(Time.class, new TimeSerializer())
                                    .create();
                            editor.putString("jwttokendto", gson.toJson(jwtTokenDTO, new TypeToken<JwtTokenDTO>(){

                            }.getType()));
                            editor.apply();
                            binding.edtMail.setText("");
                            binding.edtPassword.setText("");
                            startActivity(new Intent(this, MainActivity.class));
                        } else {
                            toastError("credenciales inválidas");
                        }
                    });

                } else {
                    toastError("por favor complete los campos");
                }
            } catch (Exception e) {
                toastError("se ha producido un error al intentar loguearte: " + e.getMessage());
            }
        });

        binding.txtNewUser.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterUserActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.left_in, R.anim.left_out);
        });

        binding.edtMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.txtInputUsuario.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.txtInputPassword.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String pref = preferences.getString("jwttokendto", "");
        if (!pref.equals("")) {
            toastOk("se detecto una sesión activa, el login será omitido");
            this.startActivity(new Intent(this, MainActivity.class));
            this.overridePendingTransition(R.anim.left_in, R.anim.left_out);
        }
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
    private void toastError(String message) {
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
    private boolean validate() {
        boolean retorno = true;
        String usuario, password;
        usuario = binding.edtMail.getText().toString();
        password = binding.edtPassword.getText().toString();

        if (usuario.isEmpty()) {
            binding.txtInputUsuario.setError("ingrese su usuario y/o correo electrónico");
            retorno = false;
        } else {
            binding.txtInputUsuario.setErrorEnabled(false);
        }

        if (password.isEmpty()) {
            binding.txtInputPassword.setError("ingrese su contraseña");
            retorno = false;
        } else {
            binding.txtInputPassword.setErrorEnabled(false);
        }
        return retorno;
    }


}