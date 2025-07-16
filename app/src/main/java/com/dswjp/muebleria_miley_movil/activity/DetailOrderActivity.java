package com.dswjp.muebleria_miley_movil.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.adapter.OrderDetailsAdapter;
import com.dswjp.muebleria_miley_movil.databinding.ActivityDetailOrderBinding;
import com.dswjp.muebleria_miley_movil.sales.dto.order.DetailedOrderDTO;
import com.dswjp.muebleria_miley_movil.viewmodel.OrderViewModel;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import lombok.SneakyThrows;

public class DetailOrderActivity extends AppCompatActivity {

    private ActivityDetailOrderBinding binding;
    private OrderViewModel orderViewModel;

    DetailedOrderDTO detailedOrderDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
        final String orderId = this.getIntent().getStringExtra("orderId");

        Log.d("DetailOrderActivity", "Order Id " + orderId);
        orderViewModel.getOrderById(orderId).observe(this, response -> {
            if (response != null && response.getContent() != null) {
                detailedOrderDTO = response.getContent();

                TextView txtOrderCreatedDate = binding.orderCreatedDate;
                TextView txtOrderCompletedDate = binding.orderCompletedDate;
                TextView txtPaymentMethod = binding.paymentMethod;
                TextView txtShippingAddress = binding.shippingAddress;
                TextView txtTax = binding.tax;
                TextView txtOrderTotal = binding.total;
                Button btnMap = binding.btnMap;

                txtOrderCreatedDate.setText(formatDate(detailedOrderDTO.getCreatedDate().toString()));
                txtOrderCompletedDate.setText(detailedOrderDTO.getCompletedDate() != null ? formatDate(detailedOrderDTO.getCompletedDate().toString()) : "No completado");
                binding.orderId.setText(detailedOrderDTO.getId());
                txtPaymentMethod.setText(detailedOrderDTO.getPaymentMethod().name());
                txtShippingAddress.setText(detailedOrderDTO.getShippingAddress());
                txtTax.setText(String.format(Locale.getDefault(), "%.2f", detailedOrderDTO.getTax()));
                txtOrderTotal.setText(String.format(Locale.getDefault(), "%.2f", detailedOrderDTO.getTotal()));

                if (detailedOrderDTO.getShipping().getStatus().name().equalsIgnoreCase("EN_TRANSITO")) {
                    btnMap.setVisibility(View.VISIBLE);
                    btnMap.setOnClickListener(v -> {
                        Toast.makeText(this, "Ir al mapa con dirección: " + detailedOrderDTO.getShippingAddress(), Toast.LENGTH_SHORT).show();
                    });
                }

                RecyclerView recyclerView = binding.recyclerOrderDetails;
                recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                OrderDetailsAdapter adapter = new OrderDetailsAdapter(detailedOrderDTO.getOrderDetails());
                recyclerView.setAdapter(adapter);

            } else {
                Toast.makeText(this, "no se pudo cargar la orden", Toast.LENGTH_SHORT).show();
            }
        });

        init();
    }



    @SneakyThrows
    private String formatDate(String date) {
        SimpleDateFormat formatIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat formatOut = new SimpleDateFormat("dd/MM/yyyy");
        Date formatedDate = (Date) formatIn.parse(date);
        return formatOut.format(formatedDate);
    }

    private void init() {
        Toolbar toolbar = this.findViewById(R.id.order_detail_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> {//Reemplazo con lamba
            this.finish();
            this.overridePendingTransition(R.anim.rigth_in, R.anim.rigth_out);
        });
    }

}