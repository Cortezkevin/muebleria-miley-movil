package com.dswjp.muebleria_miley_movil.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.activity.ProductsByCategoryActivity;
import com.dswjp.muebleria_miley_movil.api.ConfigApi;
import com.dswjp.muebleria_miley_movil.dto.catalog.CategoryDTO;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends ArrayAdapter<CategoryDTO> {
    public CategoryAdapter(@NonNull Context context, int resource, @NonNull List<CategoryDTO> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_categoria, parent, false);
        }
        CategoryDTO categoryDTO = this.getItem(position);
        ImageView imgCategory = convertView.findViewById(R.id.imgCategory);
        TextView txtNameCategory = convertView.findViewById(R.id.txtCategory);

        Picasso picasso = new Picasso.Builder(convertView.getContext())
                .downloader(new OkHttp3Downloader(ConfigApi.getClient()))
                .build();

        picasso.load(categoryDTO.getUrl_image())
                .error(R.drawable.image_not_found)
                .into(imgCategory);
        txtNameCategory.setText(categoryDTO.getName());

        convertView.setOnClickListener(view -> {
            Intent intent = new Intent(getContext(), ProductsByCategoryActivity.class);
            intent.putExtra("idCategory", categoryDTO.getId());
            getContext().startActivity(intent);
        });
        return convertView;
    }
}
