package com.dswjp.muebleria_miley_movil.activity;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.dswjp.muebleria_miley_movil.App;
import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.api.ConfigApi;
import com.dswjp.muebleria_miley_movil.context.SessionManager.SessionManager;
import com.dswjp.muebleria_miley_movil.databinding.ActivityMainBinding;
import com.dswjp.muebleria_miley_movil.enums.AccessType;
import com.dswjp.muebleria_miley_movil.utils.helpers.SharedPreferencesHelpers;
import com.dswjp.muebleria_miley_movil.viewmodel.AuthViewModel;
import com.dswjp.muebleria_miley_movil.viewmodel.ProfileViewModel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private AuthViewModel authViewModel;
    private ProfileViewModel profileViewModel;
    private SessionManager sessionManager;


    private final ActivityResultLauncher<String> notificationPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    getDeviceToken();
                } else {
                    Log.w("FCM", "Permiso de notificación denegado");
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();

        /*SharedPreferencesHelpers.getToken(getApplicationContext())
                .ifPresent(ConfigApi::setToken);*/
        sessionManager = SessionManager.getInstance();


        GoogleApiAvailability.getInstance().makeGooglePlayServicesAvailable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarHome.toolbar);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        NavigationUI.setupWithNavController(binding.appBarHome.bottomNavigation, navController);

        SessionManager sessionManager = ((App) this.getApplicationContext()).getSessionManager();

        if(sessionManager.isAdmin() || !Objects.equals(sessionManager.getAccessType(), AccessType.CLIENT)){
            DrawerLayout drawer = binding.drawerLayout;
            NavigationView navigationView = binding.navView;
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                    .setOpenableLayout(drawer)
                    .build();
            //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        }
        NavigationUI.setupWithNavController(binding.navView, navController);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "default_channel",
                    "Notificaciones FCM",
                    NotificationManager.IMPORTANCE_HIGH
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        requestNotificationPermission();
        loadProfileData();
    }

    private void initViewModel() {
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
    }

    private void loadProfileData(){
        profileViewModel.getPersonalData().observe(this, response -> {
            sessionManager.loadPersonalData(response);
            View navHeader = binding.navView.getHeaderView(0);
            TextView txtNavUserFullName = navHeader.findViewById(R.id.txtNavUserFullName);
            TextView txtNavUserEmail = navHeader.findViewById(R.id.txtNavUserEmail);
            txtNavUserEmail.setText(sessionManager.getEmail());
            txtNavUserFullName.setText(response.getFullName());
        });

        profileViewModel.getAddress().observe(this, resposne -> {
            sessionManager.loadAddress(resposne);
        });
    }
    private void requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
                    PackageManager.PERMISSION_GRANTED) {
                getDeviceToken();
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                // TODO: CUADRO DE DIALOGO EXPLICANDO IMPORTANCIA DEL PERMISO Y BOTONES DE ACEPTAR O DENEGAR
                notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
            } else {
                notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
            }
        }
    }

    private void getDeviceToken() {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.e("FCM", "Error al obtener token", task.getException());
                        return;
                    }
                    String token = task.getResult();
                    Log.d("FCM", "Token del dispositivo: " + token);

                    SharedPreferencesHelpers.getUserId(getApplicationContext())
                            .ifPresent(userId -> {
                                // TODO: Guardando el token del dispositivo en la base de datos
                                authViewModel.saveDeviceToken(userId, token).observe(this, response -> {
                                    Log.d("FCM",response.toString());
                                });
                            });
                });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            this.logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        SharedPreferencesHelpers.removeToken(this);
        SharedPreferencesHelpers.removeUserId(this);
        SharedPreferencesHelpers.removeEmail(this);
        SharedPreferencesHelpers.removeRoles(this);
        this.finish();
        this.overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        MenuItem item = menu.findItem(R.id.logout);
        SpannableString spanString = new SpannableString(item.getTitle());
        spanString.setSpan(new ForegroundColorSpan(Color.WHITE), 0, spanString.length(), 0); // o usa un color de recurso
        item.setTitle(spanString);

        return true;
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        GoogleApiAvailability.getInstance().makeGooglePlayServicesAvailable(this);
    }
}