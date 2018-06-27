package fr.cyberix.kolo.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.adapters.viewHolders.EneoBillViewHolder;
import fr.cyberix.kolo.model.EneoBillDetails;

public class EneoBillDetailsAdapter extends RecyclerView.Adapter<EneoBillViewHolder> {
	private final List<EneoBillDetails> billDetailsList;
	public View eneoBillDetailsView;
	
	public EneoBillDetailsAdapter(List<EneoBillDetails> items) {
		billDetailsList = items;
	}
	
	@NonNull
	@Override
	public EneoBillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		eneoBillDetailsView = LayoutInflater.from(parent.getContext())
		                                    .inflate(R.layout.kolo_eneo_bill_detail_row, parent, false);
		return new EneoBillViewHolder(eneoBillDetailsView);
	}
	
	@Override
	public void onBindViewHolder(final EneoBillViewHolder holder, int position) {
		holder.billDetails = billDetailsList.get(position);
		String amount = String.format("%s XAF", String.valueOf(holder.billDetails.getAmount()));
		holder.amount.setText(amount);
		holder.bill_no.setText(holder.billDetails.getBillNumber());
		holder.contract_no.setText(holder.billDetails.getContractNumber());
		holder.due_date.setText(holder.billDetails.getDueDate().toString());
		holder.EneoView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			
			}
		});
	}
	
	@Override
	public int getItemCount() {
		return billDetailsList.size();
	}
	
	public void clear() {
		billDetailsList.clear();
		notifyDataSetChanged();
	}
	
	public void addAll(List<EneoBillDetails> list) {
		if (list == null || list.size() == 0)
			return;
		billDetailsList.addAll(list);
		notifyDataSetChanged();
	}
}
