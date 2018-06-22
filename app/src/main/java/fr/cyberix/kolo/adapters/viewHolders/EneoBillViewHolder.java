package fr.cyberix.kolo.adapters.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.model.EneoBillDetails;

public class EneoBillViewHolder extends RecyclerView.ViewHolder {
	public View EneoView;
	public TextView contract_no, amount, bill_no, due_date;
	public EneoBillDetails billDetails;
	
	public EneoBillViewHolder(View view) {
		super(view);
		this.EneoView = view;
		contract_no = view.findViewById(R.id.eneo_detail_contract_no);
		amount = view.findViewById(R.id.eneo_detail_amount);
		bill_no = view.findViewById(R.id.eneo_detail_bill_no);
		due_date = view.findViewById(R.id.eneo_detail_due_date);
	}
}
