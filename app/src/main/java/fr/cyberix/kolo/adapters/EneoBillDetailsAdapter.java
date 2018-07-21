package fr.cyberix.kolo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.ViewGroup;

import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

import java.util.List;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.adapters.diffCallBacks.EneoDiffCallback;
import fr.cyberix.kolo.adapters.viewHolders.EneoBillViewHolder;
import fr.cyberix.kolo.model.EneoBillDetails;

public class EneoBillDetailsAdapter extends GenericRecyclerViewAdapter<EneoBillDetails, OnRecyclerItemClickListener, EneoBillViewHolder> {
	
	public EneoBillDetailsAdapter(Context context, OnRecyclerItemClickListener listener) {
		super(context, listener);
	}
	
	@NonNull
	@Override
	public EneoBillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new EneoBillViewHolder(inflate(R.layout.kolo_eneo_bill_detail_row, parent), getListener());
	}
	
	@Override
	public void updateItems(List<EneoBillDetails> newItems) {
		DiffUtil.Callback diffCallback = new EneoDiffCallback(getItems(), newItems);
		super.updateItems(newItems, diffCallback);
	}
}