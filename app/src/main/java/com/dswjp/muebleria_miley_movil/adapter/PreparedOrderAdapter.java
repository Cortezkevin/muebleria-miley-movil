package com.dswjp.muebleria_miley_movil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.dto.sales.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class PreparedOrderAdapter extends RecyclerView.Adapter<PreparedOrderAdapter.OrderViewHolder> {

    private List<OrderDTO> orderList;

    public PreparedOrderAdapter(List<OrderDTO> orders) {
        this.orderList = orders;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prepared_order, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.setItem(this.orderList.get(position));

    }

    @Override
    public int getItemCount() {
        return this.orderList.size();
    }

    public void updateItems(List<OrderDTO> orders) {
        this.orderList.clear();
        this.orderList.addAll(orders);
        this.notifyDataSetChanged();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView txtOrderId, txtOrderDate, txtOrderStatus;
        Button btnViewDetails;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setItem(final OrderDTO orderDTO) {
            txtOrderId = itemView.findViewById(R.id.txtOrderId);
            txtOrderDate = itemView.findViewById(R.id.txtOrderDate);
            txtOrderStatus = itemView.findViewById(R.id.txtOrderStatus);
            btnViewDetails = itemView.findViewById(R.id.btnViewDetails);

            txtOrderId.setText(orderDTO.getId());
            txtOrderDate.setText(orderDTO.getCompletedDate().toString());
            txtOrderStatus.setText(orderDTO.getPreparationStatus().name());

            btnViewDetails.setOnClickListener(v -> {
                Toast.makeText(itemView.getContext(), "al detalle maps activity", Toast.LENGTH_SHORT).show();
            });
        }
    }
}
