package fr.cyberix.kolo.adapters.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.cyberix.kolo.R;

public class TransferP2pReceiveViewHolder extends RecyclerView.ViewHolder {
	public TextView fullname, amount, number, status;
	
	public TransferP2pReceiveViewHolder(View view) {
		super(view);
		fullname = view.findViewById(R.id.contact_name);
		amount = view.findViewById(R.id.eneo_detail_amount);
		number = view.findViewById(R.id.eneo_detail_contract_no);
		status = view.findViewById(R.id.trans_status);
	}
}
