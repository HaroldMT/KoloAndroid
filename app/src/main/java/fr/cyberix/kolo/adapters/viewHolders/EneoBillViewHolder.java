package fr.cyberix.kolo.adapters.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.model.EneoBillDetails;

public class EneoBillViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
	
	@Override
	public void onClick(View view) {
		Toast.makeText(KoloHelper.getMyActivity(), billDetails.toString(), Toast.LENGTH_LONG);
		KoloHelper.ShowSimpleAlert("Facture", billDetails.toString());
	}
}
