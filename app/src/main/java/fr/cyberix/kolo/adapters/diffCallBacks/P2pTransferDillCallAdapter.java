package fr.cyberix.kolo.adapters.diffCallBacks;

import com.leodroidcoder.genericadapter.BaseDiffCallback;

import java.util.List;

import fr.cyberix.kolo.model.TransferP2pDetails;

public class P2pTransferDillCallAdapter extends BaseDiffCallback<TransferP2pDetails> {
	public P2pTransferDillCallAdapter(List<TransferP2pDetails> oldItems, List<TransferP2pDetails> newItems) {
		super(oldItems, newItems);
	}
	
	@Override
	public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
		return getOldItems().get(oldItemPosition).getTransferId() == getNewItems().get(newItemPosition).getTransferId();
	}
	
	@Override
	public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
		TransferP2pDetails oldHistory = getOldItems().get(oldItemPosition);
		TransferP2pDetails newHistory = getNewItems().get(newItemPosition);
		return oldHistory.getReference().equals(newHistory.getReference())
				&& oldHistory.getAmount() == newHistory.getAmount();
	}
}
