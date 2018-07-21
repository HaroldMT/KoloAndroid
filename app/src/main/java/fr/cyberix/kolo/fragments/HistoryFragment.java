package fr.cyberix.kolo.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.adapters.CustomerHistoryAdapter;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.interfaces.ServiceOperationInterface;
import fr.cyberix.kolo.model.CustomerBalanceHistoryList;
import fr.cyberix.kolo.model.KoloWsObject;
import fr.cyberix.kolo.model.entities.Customer;
import fr.cyberix.kolo.model.entities.CustomerBalanceHistory;

public class HistoryFragment extends Fragment implements OnRecyclerItemClickListener {
	@BindView(R.id.history_recycler)
	RecyclerView recyclerView;
	@BindView(R.id.history_swipe_container)
	SwipeRefreshLayout swipeContainer;
	View historyView;
	private CustomerHistoryAdapter historyAdapter;
	private OnFragmentInteractionListener mListener;
	ServiceOperationInterface<Customer, KoloWsObject<CustomerBalanceHistoryList>> refreshHistory = new ServiceOperationInterface<Customer,
			KoloWsObject<CustomerBalanceHistoryList>>() {
		
		
		@Override
		public void onOperationSuccess(String message, KoloWsObject<CustomerBalanceHistoryList> data) {
			CustomerBalanceHistoryList notifications = data.getDataObject();
			setHistoryList(notifications);
		}
		
		@Override
		public void onOperationFailure(String errorMessage) {
			KoloHelper.ShowSimpleAlert("Failure", errorMessage);
		}
		
		@Override
		public void onPreExecute() {
		
		}
		
		@Override
		public KoloWsObject<CustomerBalanceHistoryList> doInBackground(Customer parameter) {
			return ServiceHelper.getHistory(parameter);
		}
	};
	private Customer customer = ConfigHelper.getAccountInfo().getCustomer();
	
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
	
	@NonNull
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		historyView = inflater.inflate(R.layout.fragment_history, container, false);
		ButterKnife.bind(this, historyView);
		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
		recyclerView.setLayoutManager(mLayoutManager);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		historyAdapter = new CustomerHistoryAdapter(getActivity(), this);
		recyclerView.setAdapter(historyAdapter);
		swipeContainer.setOnRefreshListener(this::refreshItems);
		refreshItems();
		return historyView;
	}
	
	private void refreshItems() {
		swipeContainer.setRefreshing(true);
		ServiceHelper.doInBackground(ConfigHelper.getCustomer(), refreshHistory);
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}
	
	private void setHistoryList(CustomerBalanceHistoryList transferList) {
		historyAdapter.updateItems(transferList);
		swipeContainer.setRefreshing(false);
		if (historyAdapter.getItemCount() == 0)
			Toast.makeText(KoloHelper.getMyContext(), "Aucun résultat", Toast.LENGTH_LONG).show();
	}
	
	@Override
	public void onItemClick(int position) {
		CustomerBalanceHistory selectedHistory = historyAdapter.getItem(position);
	}
	
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		void onFragmentInteraction(Uri uri);
	}
}