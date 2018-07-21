package fr.cyberix.kolo.adapters.viewHolders;

import android.view.View;
import android.widget.TextView;

import com.leodroidcoder.genericadapter.BaseViewHolder;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.model.EneoBillDetails;

public class EneoBillViewHolder extends BaseViewHolder<EneoBillDetails, OnRecyclerItemClickListener> {
	public View eneoView;
	public TextView contract_no, amount, bill_no, due_date;
	public EneoBillDetails data;
	
	public EneoBillViewHolder(View view, OnRecyclerItemClickListener listener) {
		super(view, listener);
		this.eneoView = view;
		contract_no = view.findViewById(R.id.eneo_detail_contract_no);
		amount = view.findViewById(R.id.eneo_detail_amount);
		bill_no = view.findViewById(R.id.eneo_detail_bill_no);
		due_date = view.findViewById(R.id.eneo_detail_due_date);
		if (listener != null) {
			itemView.setOnClickListener(v -> listener.onItemClick(getAdapterPosition()));
		}
	}
	
	@Override
	public void onBind(EneoBillDetails item) {
		data = item;
		String mtn = String.format("%s XAF", String.valueOf(data.getAmount()));
		amount.setText(mtn);
		bill_no.setText(data.getBillNumber());
		contract_no.setText(data.getContractNumber());
		due_date.setText(data.getDueDate().toString());
	}
}
