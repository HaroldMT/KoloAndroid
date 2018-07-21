package fr.cyberix.kolo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.ViewGroup;

import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

import java.util.List;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.adapters.diffCallBacks.NotificationDiffCallback;
import fr.cyberix.kolo.adapters.viewHolders.KoloNotificationViewHolder;
import fr.cyberix.kolo.model.entities.KoloNotification;

public class KoloNotificationAdapter extends GenericRecyclerViewAdapter<KoloNotification, OnRecyclerItemClickListener, KoloNotificationViewHolder> {
	
	public KoloNotificationAdapter(Context context, OnRecyclerItemClickListener listener) {
		super(context, listener);
	}
	
	@NonNull
	@Override
	public KoloNotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new KoloNotificationViewHolder(inflate(R.layout.notification_row, parent), getListener());
	}
	
	@Override
	public void updateItems(List<KoloNotification> newItems) {
		DiffUtil.Callback diffCallback = new NotificationDiffCallback(getItems(), newItems);
		super.updateItems(newItems, diffCallback);
	}
}
