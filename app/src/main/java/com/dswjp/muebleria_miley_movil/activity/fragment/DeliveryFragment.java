package com.dswjp.muebleria_miley_movil.activity.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dswjp.muebleria_miley_movil.adapter.PreparedOrderAdapter;
import com.dswjp.muebleria_miley_movil.databinding.FragmentDeliveryBinding;
import com.dswjp.muebleria_miley_movil.dto.sales.OrderDTO;
import com.dswjp.muebleria_miley_movil.viewmodel.OrderViewModel;
import com.dswjp.muebleria_miley_movil.viewmodel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

public class DeliveryFragment extends Fragment {

    private OrderViewModel orderViewModel;
    private RecyclerView recyclerView;
    private PreparedOrderAdapter adapter;
    private List<OrderDTO> preparedOrders = new ArrayList<>();
    private FragmentDeliveryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDeliveryBinding.inflate(inflater, container, false);

        ViewModelProvider vmp = new ViewModelProvider(this);

        recyclerView = binding.rvOrders;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        orderViewModel = vmp.get(OrderViewModel.class);

        return binding.getRoot();
    }


    private void loadData() {
        orderViewModel.getAllReadyToSend().observe(getViewLifecycleOwner(), response -> {
            adapter.updateItems(response.getContent());
        });
    }

    private void initAdapter() {
        adapter = new PreparedOrderAdapter(preparedOrders);
        recyclerView.setAdapter(adapter);
    }
}