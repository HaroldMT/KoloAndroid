package fr.cyberix.kolo.adapters.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.interfaces.KoloRecyclerViewClickListener;
import fr.cyberix.kolo.model.TransferP2pDetails;

public class TransferP2pReceiveViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
	public TextView fullname, amount, number, status;
	public TransferP2pDetails data;
	private KoloRecyclerViewClickListener koloItemListener;
	
	public TransferP2pReceiveViewHolder(View view, KoloRecyclerViewClickListener itemListener) {
		super(view);
		view.setOnClickListener(this);
		this.koloItemListener = itemListener;
		fullname = view.findViewById(R.id.contact_name);
		amount = view.findViewById(R.id.eneo_detail_amount);
		number = view.findViewById(R.id.eneo_detail_contract_no);
		status = view.findViewById(R.id.trans_status);
	}
	
	@Override
	public void onClick(View v) {
		koloItemListener.recyclerViewListClicked(v, this.getLayoutPosition(), data);
	}
}
