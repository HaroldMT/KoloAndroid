package fr.cyberix.kolo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.model.entities.KoloNotification;

public class NotificationRowItemsAdapter extends RecyclerView.Adapter<NotificationRowItemsAdapter.KoloNotifViewHolder> {

    private Context context;
    private List<KoloNotification> notifData;

    public NotificationRowItemsAdapter(Context context, List<KoloNotification> notifData) {
        this.context = context;
        this.notifData = notifData;
    }

    @NonNull
    @Override
    public KoloNotifViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kolonotification_rowitems, parent, false);
        return new KoloNotifViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KoloNotifViewHolder holder, int position) {
        holder.txtnotiftitle.setText(notifData.get(position).getTitle());
        holder.txtnotifmessage.setText(notifData.get(position).getMessage());
        holder.txtnotifcreationdate.setText(notifData.get(position).getCreationDate());
    }

    @Override
    public int getItemCount() {
        return notifData.size();
    }

    public static class KoloNotifViewHolder extends RecyclerView.ViewHolder {

        TextView txtnotiftitle, txtnotifmessage, txtnotifcreationdate;

        public KoloNotifViewHolder(View itemView) {
            super(itemView);

            txtnotiftitle = itemView.findViewById(R.id.txt_notif_title);
            txtnotifmessage = itemView.findViewById(R.id.txt_notif_message);
            txtnotifcreationdate = itemView.findViewById(R.id.txt_notif_creationdate);
        }
    }


}
