package com.dswjp.muebleria_miley_movil.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dswjp.muebleria_miley_movil.databinding.ActivityGetStartedBinding;

public class GetStartedActivity extends AppCompatActivity {
    private ActivityGetStartedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetStartedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.init();
    }

    private void init() {

        binding.btnStart.setOnClickListener(v -> {
            Toast.makeText(this, "toast init getstarted", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}