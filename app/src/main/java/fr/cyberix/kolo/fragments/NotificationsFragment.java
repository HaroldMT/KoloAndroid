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
import fr.cyberix.kolo.adapters.KoloNotificationAdapter;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.interfaces.ServiceOperationInterface;
import fr.cyberix.kolo.model.KoloNotificationList;
import fr.cyberix.kolo.model.KoloWsObject;
import fr.cyberix.kolo.model.entities.Customer;
import fr.cyberix.kolo.model.entities.KoloNotification;

public class NotificationsFragment extends Fragment implements OnRecyclerItemClickListener {
	@BindView(R.id.notification_recycler)
	RecyclerView recyclerView;
	@BindView(R.id.notification_swipe_container)
	SwipeRefreshLayout swipeContainer;
	View notificationView;
	ServiceOperationInterface<Customer, KoloWsObject<KoloNotificationList>> refreshNotifications = new ServiceOperationInterface<Customer,
			KoloWsObject<KoloNotificationList>>() {
		
		
		@Override
		public void onOperationSuccess(String message, KoloWsObject<KoloNotificationList> data) {
			KoloNotificationList notifications = data.getDataObject();
			setNotificationList(notifications);
		}
		
		@Override
		public void onOperationFailure(String errorMessage) {
			KoloHelper.ShowSimpleAlert("Failure", errorMessage);
		}
		
		@Override
		public void onPreExecute() {
		
		}
		
		@Override
		public KoloWsObject<KoloNotificationList> doInBackground(Customer parameter) {
			return ServiceHelper.getNotifications(parameter);
		}
	};
	private KoloNotificationAdapter notificationAdapter;
	private OnFragmentInteractionListener mListener;
	
	public NotificationsFragment() {
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
		notificationView = inflater.inflate(R.layout.fragment_notifications, container, false);
		ButterKnife.bind(this, notificationView);
		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
		recyclerView.setLayoutManager(mLayoutManager);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		notificationAdapter = new KoloNotificationAdapter(getActivity(), this);
		recyclerView.setAdapter(notificationAdapter);
		swipeContainer.setOnRefreshListener(this::refreshItems);
		refreshItems();
		return notificationView;
	}
	
	private void refreshItems() {
		swipeContainer.setRefreshing(true);
		ServiceHelper.doInBackground(ConfigHelper.getCustomer(), refreshNotifications);
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}
	
	private void setNotificationList(KoloNotificationList notifications) {
		notificationAdapter.updateItems(notifications);
		swipeContainer.setRefreshing(false);
		if (notificationAdapter.getItemCount() == 0)
			Toast.makeText(KoloHelper.getMyContext(), "Aucun résultat", Toast.LENGTH_LONG).show();
	}
	
	@Override
	public void onItemClick(int position) {
		KoloNotification selectedNotification = notificationAdapter.getItem(position);
	}
	
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		void onFragmentInteraction(Uri uri);
	}
}