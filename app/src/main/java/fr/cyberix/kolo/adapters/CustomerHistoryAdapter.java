package fr.cyberix.kolo.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.adapters.viewHolders.CustomerHistoryViewHolder;
import fr.cyberix.kolo.model.entities.CustomerBalanceHistory;

public class CustomerHistoryAdapter extends RecyclerView.Adapter<CustomerHistoryViewHolder> {
	
	private View historyView;
	private List<CustomerBalanceHistory> historyList;
	
	public CustomerHistoryAdapter(List<CustomerBalanceHistory> custData) {
		this.historyList = custData;
	}
	
	@NonNull
	@Override
	public CustomerHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		/*Customer customer = ConfigHelper.getAccountInfo().getCustomer();
		CustomerBalanceHistory c = new CustomerBalanceHistory();
		c.setAmount(1000);
		c.setCustomer(ConfigHelper.getAccountInfo().getCustomer());
		c.setHistoryDate(Calendar.getInstance().getTime().toString());
		c.setIdCustomerAccount(customer.getIdCustomer());
		c.setIdCustomerHistory(1);
		c.setNewBalance(10000);
		c.setOldBalance(11000);
		c.setOperationTypeCode("OpTest");
		custData = new ArrayList<CustomerBalanceHistory>();
		custData.add(c);*/
		historyView = LayoutInflater.from(parent.getContext())
		                            .inflate(R.layout.history_row, parent, false);
		return new CustomerHistoryViewHolder(historyView);
	}
	
	@Override
	public void onBindViewHolder(@NonNull CustomerHistoryViewHolder holder, int position) {
		CustomerBalanceHistory customerBalanceHistory = historyList.get(position);
		holder.txtoptype.setText(customerBalanceHistory.getOperationTypeCode());
		holder.txtamount.setText(customerBalanceHistory.getAmount());
		holder.txtoldbalance.setText(customerBalanceHistory.getOldBalance());
		holder.txtnewbalance.setText(customerBalanceHistory.getNewBalance());
		holder.txthistorydate.setText(customerBalanceHistory.getHistoryDate());
	}
	
	@Override
	public int getItemCount() {
		if (historyList == null) return 0;
		return historyList.size();
	}
	
	public void clear() {
		historyList.clear();
		notifyDataSetChanged();
	}
	
	public void addAll(List<CustomerBalanceHistory> list) {
		if (list == null || list.size() == 0)
			return;
		historyList.addAll(list);
		notifyDataSetChanged();
	}
}
