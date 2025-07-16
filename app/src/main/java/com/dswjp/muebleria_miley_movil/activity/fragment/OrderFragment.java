package com.dswjp.muebleria_miley_movil.activity.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.adapter.OrderAdapter;
import com.dswjp.muebleria_miley_movil.databinding.FragmentOrderBinding;
import com.dswjp.muebleria_miley_movil.utils.GridSpacingItemDecoration;
import com.dswjp.muebleria_miley_movil.utils.helpers.SharedPreferencesHelpers;
import com.dswjp.muebleria_miley_movil.viewmodel.OrderViewModel;

import java.util.ArrayList;

public class OrderFragment extends Fragment {

    private FragmentOrderBinding binding;
    private OrderAdapter orderAdapter;
    private OrderViewModel orderViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOrderBinding.inflate(inflater, container, false);

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

        binding.llOrders.setOnClickListener(v -> {
            Log.d("OrderFragment","Click LinearLayout");
        });

        return binding.getRoot();
    }

    private void initViewModel() {
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
    }
}