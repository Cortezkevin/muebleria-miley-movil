package com.dswjp.muebleria_miley_movil.activity.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.databinding.FragmentFavoriteBinding;

public class FavoriteFragment extends Fragment {

    private FragmentFavoriteBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }
}