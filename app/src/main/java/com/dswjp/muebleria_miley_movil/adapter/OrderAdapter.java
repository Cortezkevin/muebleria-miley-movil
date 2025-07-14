package com.dswjp.muebleria_miley_movil.adapter;

import android.graphics.Color;
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
import com.dswjp.muebleria_miley_movil.dto.sales.OrderDTO;
import com.dswjp.muebleria_miley_movil.sales.enums.OrderStatus;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private List<OrderDTO> orders = new ArrayList<>();

    public OrderAdapter(List<OrderDTO> orders) {
        this.orders = orders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(this.orders.get(position));
    }

    @Override
    public int getItemCount() {
        return this.orders.size();
    }

    public void updateItems(List<OrderDTO> orders) {
        this.orders.clear();
        this.orders.addAll(orders);
        this.notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setItem(final OrderDTO orderDTO) {
            TextView txtOrderId = itemView.findViewById(R.id.txtOrderId);
            TextView txtOrderDate = itemView.findViewById(R.id.txtOrderDate);
            TextView txtOrderStatus = itemView.findViewById(R.id.txtOrderStatus);
            CardView cvOrder = itemView.findViewById(R.id.cvOrder);

            txtOrderId.setText("Order#: " + orderDTO.getId());
            txtOrderDate.setText(orderDTO.getCreatedDate().toString());
            txtOrderStatus.setText(orderDTO.getStatus().toString());
            if( orderDTO.getStatus().equals(OrderStatus.ANULADO)){
                txtOrderStatus.setTextColor(Color.RED );
            }else if(orderDTO.getStatus().equals(OrderStatus.ENTREGADO)){
                txtOrderStatus.setTextColor(Color.GREEN );
            }else {
                txtOrderStatus.setTextColor(Color.YELLOW );
            }
            /*cardViewProductPopular.setOnClickListener(v -> {
                Toast.makeText(itemView.getContext(), "click en cardview", Toast.LENGTH_SHORT).show();
            });*/
        }
    }
}
