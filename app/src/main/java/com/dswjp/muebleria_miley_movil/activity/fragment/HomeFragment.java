package com.dswjp.muebleria_miley_movil.activity.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.dswjp.muebleria_miley_movil.App;
import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.adapter.CategoryAdapter;
import com.dswjp.muebleria_miley_movil.adapter.ProductPopularAdapter;
import com.dswjp.muebleria_miley_movil.adapter.SliderAdapter;
import com.dswjp.muebleria_miley_movil.context.SessionManager.SessionManager;
import com.dswjp.muebleria_miley_movil.databinding.FragmentHomeBinding;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;
import com.dswjp.muebleria_miley_movil.entity.SliderItem;
import com.dswjp.muebleria_miley_movil.utils.GridSpacingItemDecoration;
import com.dswjp.muebleria_miley_movil.utils.helpers.SharedPreferencesHelpers;
import com.dswjp.muebleria_miley_movil.viewmodel.CategoryViewModel;
import com.dswjp.muebleria_miley_movil.viewmodel.ProductViewModel;
import com.dswjp.muebleria_miley_movil.viewmodel.ProfileViewModel;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private CategoryViewModel categoryViewModel;
    private CategoryAdapter categoryAdapter;
    private GridView gvCategories;
    private SliderAdapter sliderAdapter;
    private SliderView svCarrusel;
    private ProductViewModel productViewModel;
    private RecyclerView rcvProductsPopular;
    private ProductPopularAdapter productAdapter;
    private List<ProductDTO> productsPopular = new ArrayList<>();
    private SessionManager sessionManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        sessionManager = SessionManager.getInstance();//((App) this.getContext().getApplicationContext()).getSessionManager();
        Log.d("HomeFragment","Session Manager :"+ sessionManager.toString());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentHomeBinding.bind(view); // NO uses inflate
        init(view);
        initAdapter();
        loadData();
    }

    private void init(View view) {
        sessionManager.getPersonalData().observeForever(personalData -> {
            binding.txtHomeEmail.setText(personalData.getFullName());
        });

        svCarrusel = binding.svCarrusel;
        ViewModelProvider vmp = new ViewModelProvider(this);

        categoryViewModel = vmp.get(CategoryViewModel.class);
        gvCategories = binding.gvCategorias;

        rcvProductsPopular = view.findViewById(R.id.rcvProductPopular);
        rcvProductsPopular.setLayoutManager(new GridLayoutManager(getContext(), 2));

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.recycler_item_spacing);
        rcvProductsPopular.addItemDecoration(new GridSpacingItemDecoration(2, spacingInPixels, true));


        productViewModel = vmp.get(ProductViewModel.class);
        //profileViewModel = vmp.get(ProfileViewModel.class);
    }

    private void loadData() {
        List<SliderItem> lista = new ArrayList<>();
        lista.add(new SliderItem(R.drawable.photocarrusel1, "carusel 1"));
        lista.add(new SliderItem(R.drawable.photocarrusel2, "carusel 2"));
        lista.add(new SliderItem(R.drawable.photocarrusel3, "carusel 3"));
        lista.add(new SliderItem(R.drawable.photocarrusel4, "carusel 4"));
        sliderAdapter.updateItem(lista);

        categoryViewModel.getCategories().observe(getViewLifecycleOwner(), response -> {
            categoryAdapter.addAll(response);
        });

        productViewModel.getProducts().observe(getViewLifecycleOwner(), response -> {
            productAdapter.updateItems(response);
        });
    }

    private void initAdapter() {
        sliderAdapter = new SliderAdapter(getContext());
        svCarrusel.setSliderAdapter(sliderAdapter);
        svCarrusel.setIndicatorAnimation(IndicatorAnimationType.WORM);
        svCarrusel.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        svCarrusel.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        svCarrusel.setIndicatorSelectedColor(Color.WHITE);
        svCarrusel.setIndicatorUnselectedColor(Color.GRAY);
        svCarrusel.setScrollTimeInSec(4);
        svCarrusel.startAutoCycle();

        categoryAdapter = new CategoryAdapter(getContext(), R.layout.item_categoria, new ArrayList<>());
        gvCategories.setAdapter(categoryAdapter);

        productAdapter = new ProductPopularAdapter(productsPopular);
        rcvProductsPopular.setAdapter(productAdapter);
    }

}