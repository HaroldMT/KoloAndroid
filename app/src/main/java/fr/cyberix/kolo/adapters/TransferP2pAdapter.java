package fr.cyberix.kolo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.ViewGroup;

import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

import java.util.List;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.adapters.diffCallBacks.P2pTransferDillCallAdapter;
import fr.cyberix.kolo.adapters.viewHolders.P2pTransferViewHolder;
import fr.cyberix.kolo.model.TransferP2pDetails;

//public class TransferP2pAdapter extends RecyclerView.Adapter<TransferP2pViewHolder> {
public class TransferP2pAdapter extends GenericRecyclerViewAdapter<TransferP2pDetails, OnRecyclerItemClickListener, P2pTransferViewHolder> {
	
	public TransferP2pAdapter(Context context, OnRecyclerItemClickListener listener) {
		super(context, listener);
	}
	
	@NonNull
	@Override
	public P2pTransferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new P2pTransferViewHolder(inflate(R.layout.history_row, parent), getListener());
	}
	
	@Override
	public void updateItems(List<TransferP2pDetails> newItems) {
		DiffUtil.Callback diffCallback = new P2pTransferDillCallAdapter(getItems(), newItems);
		super.updateItems(newItems, diffCallback);
	}
}