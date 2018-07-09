package fr.cyberix.kolo.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.adapters.viewHolders.KoloNotificationViewHolder;
import fr.cyberix.kolo.model.entities.KoloNotification;

public class KoloNotificationAdapter extends RecyclerView.Adapter<KoloNotificationViewHolder> {
	
	private View notificationView;
	private List<KoloNotification> notificationList;
	
	public KoloNotificationAdapter(List<KoloNotification> notifData) {
		this.notificationList = notifData;
	}
	
	@NonNull
	@Override
	public KoloNotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		notificationView = LayoutInflater.from(parent.getContext())
		                                 .inflate(R.layout.notification_row, parent, false);
		return new KoloNotificationViewHolder(notificationView);
	}
	
	@Override
	public void onBindViewHolder(@NonNull KoloNotificationViewHolder holder, int position) {
		KoloNotification notification = notificationList.get(position);
		holder.txtnotiftitle.setText(notification.getTitle());
		holder.txtnotifmessage.setText(notification.getMessage());
		holder.txtnotifcreationdate.setText(notification.getCreationDate());
	}
	
	@Override
	public int getItemCount() {
		if (notificationList == null) return 0;
		return notificationList.size();
	}
	
	public void clear() {
		notificationList.clear();
		notifyDataSetChanged();
	}
	
	public void addAll(List<KoloNotification> list) {
		if (list == null || list.size() == 0)
			return;
		notificationList.addAll(list);
		notifyDataSetChanged();
	}
}
