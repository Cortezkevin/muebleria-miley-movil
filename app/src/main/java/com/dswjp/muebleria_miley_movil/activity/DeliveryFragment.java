package com.dswjp.muebleria_miley_movil.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.databinding.FragmentDeliveryBinding;
import com.dswjp.muebleria_miley_movil.databinding.FragmentHomeBinding;


public class DeliveryFragment extends Fragment {

    private FragmentDeliveryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDeliveryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}