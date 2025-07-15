package com.dswjp.muebleria_miley_movil.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.adapter.OrderDetailsAdapter;
import com.dswjp.muebleria_miley_movil.databinding.ActivityDetailOrderBinding;
import com.dswjp.muebleria_miley_movil.databinding.ActivityMainBinding;
import com.dswjp.muebleria_miley_movil.sales.dto.order.DetailedOrderDTO;
import com.dswjp.muebleria_miley_movil.utils.DateSerializer;
import com.dswjp.muebleria_miley_movil.utils.TimeSerializer;
import com.dswjp.muebleria_miley_movil.viewmodel.OrderViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Locale;

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
        final String orderId = this.getIntent().getStringExtra("detailOrders");

        orderViewModel.getOrderById(orderId).observe(this, response -> {
            if (response != null && response.getContent() != null) {
                detailedOrderDTO = response.getContent();

                TextView txtOrderCreatedDate = binding.orderCompletedDate;
                TextView txtOrderCompletedDate = binding.orderCompletedDate;
                TextView txtPaymentMethod = binding.paymentMethod;
                TextView txtShippingAddress = binding.shippingAddress;
                TextView txtTax = binding.tax;
                TextView txtOrderTotal = binding.total;

                txtOrderCreatedDate.setText(detailedOrderDTO.getCreatedDate() != null ? new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.getDefault()).format(detailedOrderDTO.getCreatedDate()) : "No completado");
                txtOrderCompletedDate.setText(detailedOrderDTO.getCompletedDate() != null ? new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.getDefault()).format(detailedOrderDTO.getCompletedDate()) : "No completado");
                txtPaymentMethod.setText(detailedOrderDTO.getPaymentMethod().ordinal());
                txtShippingAddress.setText(detailedOrderDTO.getShippingAddress());
                txtTax.setText(String.format(Locale.getDefault(), "%.2f", detailedOrderDTO.getTax()));
                txtOrderTotal.setText(String.format(Locale.getDefault(), "%.2f", detailedOrderDTO.getTotal()));

                RecyclerView recyclerView = binding.recyclerOrderDetails;
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                OrderDetailsAdapter adapter = new OrderDetailsAdapter(detailedOrderDTO.getOrderDetails());
                recyclerView.setAdapter(adapter);

            } else {
                Toast.makeText(this, "no se pudo cargar la orden", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        Toolbar toolbar = this.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> {//Reemplazo con lamba
            this.finish();
            this.overridePendingTransition(R.anim.rigth_in, R.anim.rigth_out);
        });
    }

}