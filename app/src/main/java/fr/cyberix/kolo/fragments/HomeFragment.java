package fr.cyberix.kolo.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.SerializationHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.model.entities.Customer;
import fr.cyberix.kolo.model.entities.Person;
import fr.cyberix.kolo.services.MobileService;

public class HomeFragment extends Fragment {
	@BindView(R.id.home_available_balance)
	TextView availableBalance;
	@BindView(R.id.home_first_name)
	TextView firstName;
	@BindView(R.id.home_last_name)
	TextView lastName;
	@BindView(R.id.home_total_balance)
	TextView balance;
	@BindView(R.id.home_unavailable_balance)
	TextView unavailableBalance;
	@BindView(R.id.home_user_picture)
	ImageView userPicture;
	@BindView(R.id.home_swipe_container)
	SwipeRefreshLayout swipeContainer;
	View homeView;
	private OnFragmentInteractionListener mListener;
	
	public HomeFragment() {
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
		homeView = inflater.inflate(R.layout.fragment_home, container, false);
		ButterKnife.bind(this, homeView);
		swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				// Refresh items
				refreshItems();
			}
		});
		Customer customer = ConfigHelper.getAccountInfo().getCustomer();
		if (customer != null && customer.person != null) {
			showHomeData();
		} else {
			refreshItems();
		}
		return homeView;
	}
	
	private void refreshItems() {
		swipeContainer.setRefreshing(true);
		HomeFragment.RefreshHomeAsync refreshHomeAsync = new HomeFragment.RefreshHomeAsync(ConfigHelper.getAccountInfo().getCustomer
				().getIdCustomer());
		refreshHomeAsync.execute();
	}
	
	private void showHomeData() {
		Customer customer = ConfigHelper.getAccountInfo().getCustomer();
		if (customer != null) {
			this.balance.setText(String.valueOf(customer.getTotalBalance()));
			this.unavailableBalance.setText(String.valueOf(customer.getBalanceUnavailable()));
			this.availableBalance.setText(String.valueOf(customer.getBalance()));
			Person person = customer.getPerson();
			if (person != null) {
				this.firstName.setText(customer.person.getFirstname());
				this.lastName.setText(customer.person.getLastname());
			}
		}
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}
	
	private void setHomeData(Customer customer) {
		if (customer != null) {
			ConfigHelper.getAccountInfo().setCustomer(customer);
			ConfigHelper.saveConfig();
		}
		onItemsLoadComplete();
	}
	
	private void onItemsLoadComplete() {
		swipeContainer.setRefreshing(false);
		Toast.makeText(KoloHelper.getMyContext(), "Fin de la synchronisation de votre compte utilisateur", Toast.LENGTH_LONG);
		showHomeData();
	}
	
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		void onFragmentInteraction(Uri uri);
	}
	
	public class RefreshHomeAsync extends AsyncTask<Void, Void, Customer> {
		int customerId;
		
		public RefreshHomeAsync(int id) {
			customerId = id;
		}
		
		@Override
		protected Customer doInBackground(Void... voids) {
			MobileService service = ServiceHelper.getMobileService();
			String transResult = service.GetCustomerAccount(customerId);
			Customer mCustomer = SerializationHelper.fromJson(transResult, Customer.class);
			return mCustomer;
		}
		
		@Override
		protected void onPostExecute(Customer mCustomer) {
			super.onPostExecute(mCustomer);
			setHomeData(mCustomer);
		}
	}
}
