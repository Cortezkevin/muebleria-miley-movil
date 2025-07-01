package com.dswjp.muebleria_miley_movil.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.adapter.ProductsByCategoryAdapter;
import com.dswjp.muebleria_miley_movil.databinding.ActivityProductsByCategoryBinding;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;
import com.dswjp.muebleria_miley_movil.viewmodel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProductsByCategoryActivity extends AppCompatActivity {

    private ProductViewModel productViewModel;
    private ActivityProductsByCategoryBinding binding;
    private ProductsByCategoryAdapter productsByCategoryAdapter;
    private List<ProductDTO> products = new ArrayList<>();
    private RecyclerView rcvProductByCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityProductsByCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        initViewModel();
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
        this.productViewModel = vmp.get(ProductViewModel.class);
    }

    private void initAdapter() {
        int idCategory = getIntent().getIntExtra("idCategory", 0);
        productViewModel.getByCategoryId(idCategory).observe(this, response -> {
            productsByCategoryAdapter.updateItems(response.getContent());
        });
    }
}