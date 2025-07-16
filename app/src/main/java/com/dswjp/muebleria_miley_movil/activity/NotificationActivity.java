package com.dswjp.muebleria_miley_movil.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.adapter.NotificationAdapter;
import com.dswjp.muebleria_miley_movil.databinding.ActivityNotificationBinding;
import com.dswjp.muebleria_miley_movil.profile.dto.NotificationDTO;
import com.dswjp.muebleria_miley_movil.viewmodel.NotificationViewModel;

import java.util.ArrayList;
import java.util.List;


public class NotificationActivity extends AppCompatActivity {
    private ActivityNotificationBinding binding;
    private NotificationViewModel notificationViewModel;
    private NotificationAdapter notificationAdapter;
    private List<NotificationDTO> notificationDTO = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        initViewModel();
        initAdapter();
    }

    private void init() {
        Toolbar toolbar = this.binding.toolbar;
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> {
            this.finish();
            this.overridePendingTransition(R.anim.rigth_in, R.anim.rigth_out);
        });
    }

    private void initViewModel() {
        final ViewModelProvider vmp = new ViewModelProvider(this);
        this.notificationViewModel = vmp.get(NotificationViewModel.class);
    }

    private void initAdapter() {
        notificationAdapter = new NotificationAdapter(notificationDTO);
        notificationViewModel.getAllFromSession().observe(this, notifications -> {
            notificationAdapter.updateItems(notifications.getContent());
        });
        binding.rvNotifications.setLayoutManager(new LinearLayoutManager(this));
        binding.rvNotifications.setAdapter(notificationAdapter);
    }
}