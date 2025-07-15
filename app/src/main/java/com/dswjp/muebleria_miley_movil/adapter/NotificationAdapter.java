package com.dswjp.muebleria_miley_movil.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.profile.dto.NotificationDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private final List<NotificationDTO> notifications;

    public NotificationAdapter(List<NotificationDTO> notifications) {
        this.notifications = notifications;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(this.notifications.get(position));
    }

    @Override
    public int getItemCount() {
        return this.notifications.size();
    }

    public void updateItems(List<NotificationDTO> notifications) {
        this.notifications.clear();
        this.notifications.addAll(notifications);
        this.notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setItem(final NotificationDTO notificationDTO) {
            TextView txtNotificationId = itemView.findViewById(R.id.txtNotificationId),
                    txtNotificationTitle = itemView.findViewById(R.id.txtNotificationTitle),
                    txtNotificationBody = itemView.findViewById(R.id.txtNotificationBody),
                    txtNotificationDate = itemView.findViewById(R.id.txtNotificationDate);

            CardView cvNotification = itemView.findViewById(R.id.cvNotification);

            txtNotificationId.setText("Notificación ID: " + notificationDTO.getId());
            txtNotificationTitle.setText(notificationDTO.getTitle());
            txtNotificationBody.setText(notificationDTO.getBody());
            txtNotificationDate.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(notificationDTO.getDate().getDate()));

            /*cvNotification.setOnClickListener(v -> {

            });*/
        }
    }
}
