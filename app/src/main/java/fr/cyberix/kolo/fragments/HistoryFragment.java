package fr.cyberix.kolo.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.adapters.CustomerHistoryAdapter;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.SerializationHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.model.CustomerBalanceHistoryList;
import fr.cyberix.kolo.model.entities.Customer;
import fr.cyberix.kolo.model.entities.CustomerBalanceHistory;
import fr.cyberix.kolo.services.MobileService;

public class HistoryFragment extends Fragment {
	@BindView(R.id.history_recycler)
	RecyclerView recyclerView;
	@BindView(R.id.history_swipe_container)
	SwipeRefreshLayout swipeContainer;
	View historyView;
	private List<CustomerBalanceHistory> historyList = new ArrayList<>();
	private CustomerHistoryAdapter historyAdapter;
	
	private OnFragmentInteractionListener mListener;
	
	public HistoryFragment() {
		// Required empty public constructor
	}
	
	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof OnFragmentInteractionListener) {
			mListener = (OnFragmentInteractionListener) context;
		} else {
			throw new RuntimeException(context.toString()
					                           + " must implement OnFragmentInteractionListener");
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		historyView = inflater.inflate(R.layout.fragment_history, container, false);
		ButterKnife.bind(this, historyView);
		Customer customer = ConfigHelper.getAccountInfo().getCustomer();
		swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				// Refresh items
				refreshItems();
			}
		});
		return historyView;
	}
	
	private void refreshItems() {
		swipeContainer.setRefreshing(true);
		HistoryFragment.RefreshHistoryAsync historyAsync = new HistoryFragment.RefreshHistoryAsync(ConfigHelper.getAccountInfo().getCustomer
				().getIdCustomer());
		historyAsync.execute();
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}
	
	private void setHistoryList(CustomerBalanceHistoryList transferList) {
		historyAdapter.clear();
		historyAdapter.addAll(transferList);
		onItemsLoadComplete();
	}
	
	private void onItemsLoadComplete() {
		historyAdapter.notifyDataSetChanged();
		swipeContainer.setRefreshing(false);
		int nb = historyAdapter.getItemCount();
		Toast.makeText(KoloHelper.getMyContext(), nb + " lignes trouvées", Toast.LENGTH_LONG);
	}
	
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		void onFragmentInteraction(Uri uri);
	}
	
	public class RefreshHistoryAsync extends AsyncTask<Void, Void, CustomerBalanceHistoryList> {
		int customerId;
		
		public RefreshHistoryAsync(int id) {
			customerId = id;
		}
		
		@Override
		protected CustomerBalanceHistoryList doInBackground(Void... voids) {
			MobileService service = ServiceHelper.getMobileService();
			String transResult = service.GetCustomerBalanceHistory(customerId);
			CustomerBalanceHistoryList customerBalanceHistories = SerializationHelper.fromJson(transResult, CustomerBalanceHistoryList.class);
			return customerBalanceHistories;
		}
		
		@Override
		protected void onPostExecute(CustomerBalanceHistoryList histList) {
			super.onPostExecute(histList);
			setHistoryList(histList);
		}
	}
}