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
import fr.cyberix.kolo.adapters.KoloNotificationAdapter;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.SerializationHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.model.KoloNotificationList;
import fr.cyberix.kolo.model.entities.Customer;
import fr.cyberix.kolo.model.entities.KoloNotification;
import fr.cyberix.kolo.services.MobileService;

public class NotificationsFragment extends Fragment {
	@BindView(R.id.notification_recycler)
	RecyclerView recyclerView;
	@BindView(R.id.notification_swipe_container)
	SwipeRefreshLayout swipeContainer;
	View notificationView;
	private List<KoloNotification> notificationList = new ArrayList<>();
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
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		notificationView = inflater.inflate(R.layout.fragment_notifications, container, false);
		ButterKnife.bind(this, notificationView);
		Customer customer = ConfigHelper.getAccountInfo().getCustomer();
		swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				// Refresh items
				refreshItems();
			}
		});
		return notificationView;
	}
	
	private void refreshItems() {
		swipeContainer.setRefreshing(true);
		NotificationsFragment.RefreshNotificationAsync notificationAsync = new NotificationsFragment.RefreshNotificationAsync(ConfigHelper.getAccountInfo()
		                                                                                                                                  .getCustomer
				().getIdCustomer());
		notificationAsync.execute();
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}
	
	private void setHistoryList(KoloNotificationList notifications) {
		notificationAdapter.clear();
		notificationAdapter.addAll(notifications);
		onItemsLoadComplete();
	}
	
	private void onItemsLoadComplete() {
		notificationAdapter.notifyDataSetChanged();
		swipeContainer.setRefreshing(false);
		int nb = notificationAdapter.getItemCount();
		Toast.makeText(KoloHelper.getMyContext(), nb + " lignes trouvées", Toast.LENGTH_LONG);
	}
	
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		void onFragmentInteraction(Uri uri);
	}
	
	public class RefreshNotificationAsync extends AsyncTask<Void, Void, KoloNotificationList> {
		int customerId;
		
		public RefreshNotificationAsync(int id) {
			customerId = id;
		}
		
		@Override
		protected KoloNotificationList doInBackground(Void... voids) {
			MobileService service = ServiceHelper.getMobileService();
			String transResult = service.GetCustomerNotifications(customerId);
			KoloNotificationList koloNotifications = SerializationHelper.fromJson(transResult, KoloNotificationList.class);
			return koloNotifications;
		}
		
		@Override
		protected void onPostExecute(KoloNotificationList histList) {
			super.onPostExecute(histList);
			setHistoryList(histList);
		}
	}
}
