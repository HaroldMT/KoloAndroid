package fr.cyberix.kolo.adapters.diffCallBacks;

import com.leodroidcoder.genericadapter.BaseDiffCallback;

import java.util.List;

import fr.cyberix.kolo.model.EneoBillDetails;

public class EneoDiffCallback extends BaseDiffCallback<EneoBillDetails> {
	public EneoDiffCallback(List<EneoBillDetails> oldItems, List<EneoBillDetails> newItems) {
		super(oldItems, newItems);
	}
	
	@Override
	public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
		return getOldItems().get(oldItemPosition).getBillNumber() == getNewItems().get(newItemPosition).getBillNumber();
	}
	
	@Override
	public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
		EneoBillDetails oldHistory = getOldItems().get(oldItemPosition);
		EneoBillDetails newHistory = getNewItems().get(newItemPosition);
		return oldHistory.getContractNumber().equals(newHistory.getContractNumber())
				&& oldHistory.getAmount() == newHistory.getAmount()
				&& oldHistory.getDueDate() == newHistory.getDueDate();
	}
}
