package com.dswjp.muebleria_miley_movil;

import android.app.Application;
import android.content.Context;

import com.dswjp.muebleria_miley_movil.api.ConfigApi;
import com.dswjp.muebleria_miley_movil.context.SessionManager.SessionManager;
import com.dswjp.muebleria_miley_movil.dto.security.UserDTO;
import com.dswjp.muebleria_miley_movil.repository.AuthRepository;
import com.dswjp.muebleria_miley_movil.security.dto.SessionDTO;
import com.dswjp.muebleria_miley_movil.utils.helpers.SharedPreferencesHelpers;
import com.facebook.stetho.DumperPluginsProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.dumpapp.DumperPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;

public class App extends Application {
    private Context context;
    @Getter
    private SessionManager sessionManager;
    private AuthRepository authRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
        Stetho.initialize(
                Stetho.newInitializerBuilder(context)
                        .enableDumpapp((DumperPluginsProvider) new SampleDumperPluginsProvider(context))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(context))
                        .build()
        );

        SharedPreferencesHelpers.getToken(this).ifPresent(ConfigApi::setToken);

        sessionManager = SessionManager.getInstance();
        authRepository = AuthRepository.getInstance();

        authRepository.validateSession().observeForever(res -> {
            if(res.isSuccess()){
                UserDTO userSession = res.getContent();
                sessionManager.loadSession(new SessionDTO(
                        SharedPreferencesHelpers.getToken(this).get(),
                        userSession.getId(),
                        userSession.getEmail(),
                        userSession.getPhotoUrl(),
                        new ArrayList<>(userSession.getRoles())
                ));
            }
        });
    }

    public static class SampleDumperPluginsProvider implements DumperPluginsProvider {
        private Context context;

        public SampleDumperPluginsProvider(Context context) {
            this.context = context;
        }

        @Override
        public Iterable<DumperPlugin> get() {
            /*
            ArrayList<DumperPlugin> plugins = new ArrayList<>();
            for (DumperPlugin dp : Stetho.defaultDumperPluginsProvider(context).get()) {
                plugins.add(dp);
            }

            return plugins;*/
            return Stetho.defaultDumperPluginsProvider(context).get();
        }
    }
}
