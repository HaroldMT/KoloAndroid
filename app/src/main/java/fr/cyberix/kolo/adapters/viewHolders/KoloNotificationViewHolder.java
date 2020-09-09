package fr.cyberix.kolo.adapters.viewHolders;

import android.view.View;
import android.widget.TextView;

import com.leodroidcoder.genericadapter.BaseViewHolder;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.model.entities.KoloNotification;

public class KoloNotificationViewHolder extends BaseViewHolder<KoloNotification, OnRecyclerItemClickListener> {
	public View notificationView;
	public TextView txtnotiftitle, txtnotifmessage, txtnotifcreationdate;
	public KoloNotification data;
	
	public KoloNotificationViewHolder(View itemView, OnRecyclerItemClickListener listener) {
		super(itemView, listener);
		txtnotiftitle = itemView.findViewById(R.id.txt_notif_title);
		txtnotifmessage = itemView.findViewById(R.id.txt_notif_message);
		txtnotifcreationdate = itemView.findViewById(R.id.txt_notif_creationdate);
	}
	
	@Override
	public void onBind(KoloNotification item) {
		data = item;
		txtnotiftitle.setText(data.getTitle());
		txtnotifmessage.setText(data.getMessage());
		txtnotifcreationdate.setText((CharSequence) data.getCreationDate());
	}

}
