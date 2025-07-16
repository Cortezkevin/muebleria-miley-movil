package com.dswjp.muebleria_miley_movil.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.api.ConfigApi;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class ProductPopularAdapter extends RecyclerView.Adapter<ProductPopularAdapter.ViewHolder> {
    private List<ProductDTO> producstPopular;

    public ProductPopularAdapter(List<ProductDTO> productsPopular) {
        this.producstPopular = productsPopular;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popularproduct, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(this.producstPopular.get(position));
    }

    @Override
    public int getItemCount() {
        return this.producstPopular.size();
    }

    public void updateItems(List<ProductDTO> products) {
        this.producstPopular.clear();
        this.producstPopular.addAll(products);
        this.notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setItem(final ProductDTO productDTO) {
            ImageView imgProductPopular = itemView.findViewById(R.id.imgProductPopular);
            TextView nameProductPopular = itemView.findViewById(R.id.txtNamePopular);
            TextView priceProductPopular = itemView.findViewById(R.id.txtPricePopular);
            CardView cardViewProductPopular = itemView.findViewById(R.id.cardViewProductPopular);

            Picasso picasso = new Picasso.Builder(itemView.getContext())
                    .downloader(new OkHttp3Downloader(ConfigApi.getClient()))
                    .build();

            picasso.load(productDTO.getImages().get(0))
                    .error(R.drawable.image_not_found)
                    .into(imgProductPopular);
            nameProductPopular.setText(productDTO.getName());
            priceProductPopular.setText(String.format(Locale.getDefault(), "S/ %.2f", productDTO.getPrice()));

            cardViewProductPopular.setOnClickListener(v -> {
                Toast.makeText(itemView.getContext(), "click en cardview", Toast.LENGTH_SHORT).show();
            });
        }
    }
}
