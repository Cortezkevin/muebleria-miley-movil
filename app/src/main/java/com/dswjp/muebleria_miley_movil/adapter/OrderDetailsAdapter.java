package com.dswjp.muebleria_miley_movil.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.sales.dto.order.OrderDetailDTO;

import java.util.List;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.OrderDetailViewHolder> {
    private final List<OrderDetailDTO> orderDetails;

    public OrderDetailsAdapter(List<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @NonNull
    @Override
    public OrderDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order_detail, parent, false);
        return new OrderDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailViewHolder holder, int position) {
        OrderDetailDTO detail = orderDetails.get(position);

        holder.txtProductName.setText(detail.getName());
        //holder.txtProductId.setText(detail.getId());
        holder.txtPrice.setText(String.format("Precio: S/. %.2f", detail.getPrice()));
        holder.txtAmount.setText("Cantidad: " + detail.getAmount().toString());
        holder.txtTotal.setText(String.format("Total: S/. %.2f", detail.getTotal()));

        Glide.with(holder.itemView.getContext())
                .load(detail.getImage())
                .placeholder(R.drawable.ic_launcher_background) // Asegúrate de tener este recurso
                .error(R.drawable.ic_launcher_foreground) // O algún otro drawable de error
                .into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return orderDetails.size();
    }

    public static class OrderDetailViewHolder extends RecyclerView.ViewHolder {
        TextView txtProductName, txtPrice, txtAmount, txtTotal;
        ImageView imgProduct;

        public OrderDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            txtProductName = itemView.findViewById(R.id.txtProductName);
            //txtProductId = itemView.findViewById(R.id.txtProductId);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtAmount = itemView.findViewById(R.id.txtAmount);
            txtTotal = itemView.findViewById(R.id.txtTotal);
            imgProduct = itemView.findViewById(R.id.imgProduct);
        }
    }
}
