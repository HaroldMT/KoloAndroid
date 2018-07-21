package fr.cyberix.kolo.adapters.diffCallBacks;

import com.leodroidcoder.genericadapter.BaseDiffCallback;

import java.util.List;

import fr.cyberix.kolo.model.entities.CustomerBalanceHistory;

public class CustomerHistoryDiffCallback extends BaseDiffCallback<CustomerBalanceHistory> {
	public CustomerHistoryDiffCallback(List<CustomerBalanceHistory> oldItems, List<CustomerBalanceHistory> newItems) {
		super(oldItems, newItems);
	}
	
	@Override
	public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
		return getOldItems().get(oldItemPosition).getIdCustomerHistory() == getNewItems().get(newItemPosition).getIdCustomerHistory();
	}
	
	@Override
	public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
		CustomerBalanceHistory oldHistory = getOldItems().get(oldItemPosition);
		CustomerBalanceHistory newHistory = getNewItems().get(newItemPosition);
		return oldHistory.getOperationTypeCode().equals(newHistory.getOperationTypeCode())
				&& oldHistory.getAmount() == newHistory.getAmount()
				&& oldHistory.getHistoryDate() == newHistory.getHistoryDate()
				&& oldHistory.getNewBalance() == newHistory.getNewBalance();
	}
}