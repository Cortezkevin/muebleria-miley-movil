package com.dswjp.muebleria_miley_movil.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.api.ConfigApi;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class ProductsByCategoryAdapter extends RecyclerView.Adapter<ProductsByCategoryAdapter.ViewHolder> {

    private List<ProductDTO> listProductsByCategory;

    public ProductsByCategoryAdapter(List<ProductDTO> listProductsByCategory) {
        this.listProductsByCategory = listProductsByCategory;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto_by_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(this.listProductsByCategory.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listProductsByCategory.size();
    }

    public void updateItems(List<ProductDTO> listProductsByCategory) {
        this.listProductsByCategory.clear();
        this.listProductsByCategory.addAll(listProductsByCategory);
        this.notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgProductByCategory;
        private final TextView txtNameProductByCategory;
        private final TextView txtPriceByCategory;
        private final Button btnOrderByCategory;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgProductByCategory = itemView.findViewById(R.id.imgProductByCategory);
            this.txtNameProductByCategory = itemView.findViewById(R.id.txtNameProductByCategory);
            this.txtPriceByCategory = itemView.findViewById(R.id.txtPriceByCategory);
            this.btnOrderByCategory = itemView.findViewById(R.id.btnOrderByCategory);
        }

        public void setItem(final ProductDTO productDTO) {
            Picasso picasso = new Picasso.Builder(itemView.getContext())
                    .downloader(new OkHttp3Downloader(ConfigApi.getClient()))
                    .build();

            picasso.load(productDTO.getImages().get(0))
                    .error(R.drawable.image_not_found)
                    .into(imgProductByCategory);
            txtNameProductByCategory.setText(productDTO.getName());
            txtPriceByCategory.setText(String.format(Locale.getDefault(), "S/ %.2f", productDTO.getPrice()));
            btnOrderByCategory.setOnClickListener(v -> {
                Toast.makeText(this.itemView.getContext(), "has presionao el boton ordenar", Toast.LENGTH_SHORT).show();
            });
        }


    }
}
