package fr.cyberix.kolo.adapters.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.cyberix.kolo.R;

public class CustomerHistoryViewHolder extends RecyclerView.ViewHolder {
	public TextView txtoptype, txtamount, txtoldbalance, txtnewbalance, txthistorydate;
	
	public CustomerHistoryViewHolder(View itemView) {
		super(itemView);
		txtoptype = itemView.findViewById(R.id.history_op_type);
		txtamount = itemView.findViewById(R.id.history_amount);
		txtoldbalance = itemView.findViewById(R.id.history_old_balance);
		txtnewbalance = itemView.findViewById(R.id.history_new_balance);
		txthistorydate = itemView.findViewById(R.id.history_date);
	}
}