package fr.cyberix.kolo.adapters.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.cyberix.kolo.R;

public class KoloNotificationViewHolder extends RecyclerView.ViewHolder {
	public TextView txtnotiftitle, txtnotifmessage, txtnotifcreationdate;
	
	public KoloNotificationViewHolder(View itemView) {
		super(itemView);
		txtnotiftitle = itemView.findViewById(R.id.txt_notif_title);
		txtnotifmessage = itemView.findViewById(R.id.txt_notif_message);
		txtnotifcreationdate = itemView.findViewById(R.id.txt_notif_creationdate);
	}
}
