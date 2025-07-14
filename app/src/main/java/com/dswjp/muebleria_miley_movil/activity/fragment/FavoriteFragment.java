package com.dswjp.muebleria_miley_movil.activity.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.adapter.OrderAdapter;
import com.dswjp.muebleria_miley_movil.adapter.ProductPopularAdapter;
import com.dswjp.muebleria_miley_movil.databinding.FragmentFavoriteBinding;
import com.dswjp.muebleria_miley_movil.databinding.FragmentHomeBinding;
import com.dswjp.muebleria_miley_movil.utils.GridSpacingItemDecoration;
import com.dswjp.muebleria_miley_movil.utils.helpers.SharedPreferencesHelpers;
import com.dswjp.muebleria_miley_movil.viewmodel.AuthViewModel;
import com.dswjp.muebleria_miley_movil.viewmodel.OrderViewModel;
import com.dswjp.muebleria_miley_movil.viewmodel.ProductViewModel;

import java.util.ArrayList;

public class FavoriteFragment extends Fragment {

    private FragmentFavoriteBinding binding;
    private OrderAdapter orderAdapter;
    private OrderViewModel orderViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);

        initViewModel();

        orderAdapter = new OrderAdapter(new ArrayList<>());

        SharedPreferencesHelpers.getUserId(this.getContext())
                .ifPresent(userId -> {
                    orderViewModel.getAllByUser(userId).observe(this.getViewLifecycleOwner(), response -> {
                        orderAdapter.updateItems(response.getContent());
                    });
                });

        binding.rvOrders.setAdapter(orderAdapter);
        binding.rvOrders.setLayoutManager(new GridLayoutManager(getContext(), 1));

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.recycler_item_spacing);
        binding.rvOrders.addItemDecoration(new GridSpacingItemDecoration(1, spacingInPixels, true));

        return binding.getRoot();
    }

    private void initViewModel() {
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
    }
}