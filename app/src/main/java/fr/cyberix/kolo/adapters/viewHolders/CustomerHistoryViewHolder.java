package fr.cyberix.kolo.adapters.viewHolders;

import android.view.View;
import android.widget.TextView;

import com.leodroidcoder.genericadapter.BaseViewHolder;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.model.entities.CustomerBalanceHistory;

public class CustomerHistoryViewHolder extends BaseViewHolder<CustomerBalanceHistory, OnRecyclerItemClickListener> {
	public TextView txtOptype, txtAmount, txtOldBalance, txtNewBalance, txtHistoryDate;
	public CustomerBalanceHistory data;
	
	public CustomerHistoryViewHolder(View itemView, OnRecyclerItemClickListener listener) {
		super(itemView, listener);
		txtOptype = itemView.findViewById(R.id.history_op_type);
		txtAmount = itemView.findViewById(R.id.history_amount);
		txtOldBalance = itemView.findViewById(R.id.history_old_balance);
		txtNewBalance = itemView.findViewById(R.id.history_new_balance);
		txtHistoryDate = itemView.findViewById(R.id.history_date);
		if (listener != null) {
			itemView.setOnClickListener(v -> listener.onItemClick(getAdapterPosition()));
		}
	}
	
	@Override
	public void onBind(CustomerBalanceHistory item) {
		data = item;
		txtOptype.setText(data.getOperationTypeCode());
		txtAmount.setText(data.getAmount());
		txtOldBalance.setText(data.getOldBalance());
		txtNewBalance.setText(data.getNewBalance());
		txtHistoryDate.setText(data.getHistoryDate());
	}
}