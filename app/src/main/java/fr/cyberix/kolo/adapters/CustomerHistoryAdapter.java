package fr.cyberix.kolo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.ViewGroup;

import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

import java.util.List;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.adapters.diffCallBacks.CustomerHistoryDiffCallback;
import fr.cyberix.kolo.adapters.viewHolders.CustomerHistoryViewHolder;
import fr.cyberix.kolo.model.entities.CustomerBalanceHistory;

public class CustomerHistoryAdapter extends GenericRecyclerViewAdapter<CustomerBalanceHistory, OnRecyclerItemClickListener, CustomerHistoryViewHolder> {
	
	public CustomerHistoryAdapter(Context context, OnRecyclerItemClickListener listener) {
		super(context, listener);
	}
	
	@NonNull
	@Override
	public CustomerHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new CustomerHistoryViewHolder(inflate(R.layout.history_row, parent), getListener());
	}
	
	@Override
	public void updateItems(List<CustomerBalanceHistory> newItems) {
		DiffUtil.Callback diffCallback = new CustomerHistoryDiffCallback(getItems(), newItems);
		super.updateItems(newItems, diffCallback);
	}
}