package fr.cyberix.kolo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.adapters.viewHolders.EneoBillViewHolder;
import fr.cyberix.kolo.fragments.EneoBillDetailsFragment.OnListFragmentInteractionListener;
import fr.cyberix.kolo.fragments.dummy.DummyContent.DummyItem;
import fr.cyberix.kolo.model.EneoBillDetails;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class EneoBillDetailsAdapter extends RecyclerView.Adapter<EneoBillViewHolder> {
	private final List<EneoBillDetails> billDetailsList;
	private final OnListFragmentInteractionListener billFragmentListener;
	public View eneoBillDetailsView;
	
	public EneoBillDetailsAdapter(List<EneoBillDetails> items, OnListFragmentInteractionListener listener) {
		billDetailsList = items;
		billFragmentListener = listener;
	}
	
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
				if (null != billFragmentListener) {
					// Notify the active callbacks interface (the activity, if the
					// fragment is attached to one) that an item has been selected.
					billFragmentListener.onListFragmentInteraction(holder.billDetails);
				}
			}
		});
	}
	
	@Override
	public int getItemCount() {
		return billDetailsList.size();
	}
}
