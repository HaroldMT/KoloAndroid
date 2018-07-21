package fr.cyberix.kolo.adapters.viewHolders;

import android.view.View;
import android.widget.TextView;

import com.leodroidcoder.genericadapter.BaseViewHolder;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.model.TransferP2pDetails;

public class P2pTransferViewHolder extends BaseViewHolder<TransferP2pDetails, OnRecyclerItemClickListener> {
	public TextView fullname, amount, number, status;
	public TransferP2pDetails data;
	
	public P2pTransferViewHolder(View view, OnRecyclerItemClickListener listener) {
		super(view, listener);
		fullname = view.findViewById(R.id.contact_name);
		amount = view.findViewById(R.id.eneo_detail_amount);
		number = view.findViewById(R.id.eneo_detail_contract_no);
		status = view.findViewById(R.id.trans_status);
	}
	
	@Override
	public void onBind(TransferP2pDetails item) {
		data = item;
		String mtn = String.format("%s XAF", String.valueOf(data.getAmount()));
		amount.setText(mtn);
		fullname.setText(data.getSenderFullname());
		number.setText(data.getSenderTelephone());
		status.setText(data.getStatus());
	}
}
