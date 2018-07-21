package fr.cyberix.kolo.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.adapters.EneoBillDetailsAdapter;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.interfaces.ServiceOperationInterface;
import fr.cyberix.kolo.model.EneoBillDetails;
import fr.cyberix.kolo.model.EneoBillDetailsList;
import fr.cyberix.kolo.model.KoloWsObject;

public class KoloEneoPayBillActivity extends AppCompatActivity implements OnRecyclerItemClickListener {
	@BindView(R.id.eneo_pay_bill_recycler_view)
	RecyclerView recyclerView;
	@BindView(R.id.eneo_pay_bill_swipe_container)
	SwipeRefreshLayout swipeContainer;
	String eneoCode;
	boolean isContractSearch = true;
	private EneoBillDetailsAdapter eneoAdapter;
	ServiceOperationInterface<String, KoloWsObject<EneoBillDetailsList>> getBillByNumber = new ServiceOperationInterface<String,
			KoloWsObject<EneoBillDetailsList>>() {
		@Override
		public void onOperationSuccess(String message, KoloWsObject<EneoBillDetailsList> data) {
			EneoBillDetailsList eneoBillDetailsList = data.getDataObject();
			setBillList(eneoBillDetailsList);
		}
		
		@Override
		public void onOperationFailure(String errorMessage) {
			KoloHelper.ShowSimpleAlert("Failure", errorMessage);
		}
		
		@Override
		public void onPreExecute() {
			swipeContainer.setRefreshing(true);
		}
		
		@Override
		public KoloWsObject<EneoBillDetailsList> doInBackground(String parameter) {
			return ServiceHelper.getEneoBill(parameter);
		}
	};
	
	ServiceOperationInterface<String, KoloWsObject<EneoBillDetailsList>> getBillByAccount = new ServiceOperationInterface<String,
			KoloWsObject<EneoBillDetailsList>>() {
		@Override
		public void onOperationSuccess(String message, KoloWsObject<EneoBillDetailsList> data) {
			EneoBillDetailsList eneoBillDetailsList = data.getDataObject();
			setBillList(eneoBillDetailsList);
		}
		
		@Override
		public void onOperationFailure(String errorMessage) {
			KoloHelper.ShowSimpleAlert("Failure", errorMessage);
		}
		
		@Override
		public void onPreExecute() {
			swipeContainer.setRefreshing(true);
		}
		
		@Override
		public KoloWsObject<EneoBillDetailsList> doInBackground(String parameter) {
			return ServiceHelper.getEneoBills(parameter);
		}
	};
	
	ServiceOperationInterface<EneoBillDetails, KoloWsObject<String>> payBill = new ServiceOperationInterface<EneoBillDetails, KoloWsObject<String>>() {
		@Override
		public void onOperationSuccess(String message, KoloWsObject<String> data) {
			String userMessage = data.getErrorMessage();
			KoloHelper.ShowSimpleAlert("Bill paid succesfully", userMessage);
		}
		
		@Override
		public void onOperationFailure(String errorMessage) {
			KoloHelper.ShowSimpleAlert("Failure", errorMessage);
		}
		
		@Override
		public void onPreExecute() {
		
		}
		
		@Override
		public KoloWsObject<String> doInBackground(EneoBillDetails parameter) {
			return ServiceHelper.payEneoBill(parameter);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kolo_eneo_pay_bill);
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
		KoloHelper.setActivity(this);
		readParameters();
		
		eneoAdapter = new EneoBillDetailsAdapter(this, this);
		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
		recyclerView.setLayoutManager(mLayoutManager);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		recyclerView.setAdapter(eneoAdapter);
		
		swipeContainer.setOnRefreshListener(this::refreshItems);
		refreshItems();
	}
	
	void readParameters() {
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			eneoCode = getIntent().getStringExtra("ENEO_CODE");
			isContractSearch = getIntent().getBooleanExtra("IS_CONTRACT_SEARCH", true);
		} else {
			eneoCode = "";
			isContractSearch = true;
		}
	}
	
	void refreshItems() {
		swipeContainer.setRefreshing(true);
		prepareEneoData();
	}
	
	private void prepareEneoData() {
		if (isContractSearch)
			ServiceHelper.doInBackground(eneoCode, getBillByNumber);
		else
			ServiceHelper.doInBackground(eneoCode, getBillByAccount);
	}
	
	void setBillList(EneoBillDetailsList eneoList) {
		eneoAdapter.clear();
		eneoAdapter.addAll(eneoList);
		onItemsLoadComplete();
	}
	
	void onItemsLoadComplete() {
		eneoAdapter.notifyDataSetChanged();
		swipeContainer.setRefreshing(false);
		int nb = eneoAdapter.getItemCount();
		Toast.makeText(KoloHelper.getMyContext(), nb + " factures trouvées", Toast.LENGTH_LONG).show();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		KoloHelper.setActivity(this);
	}
	
	@Override
	public void onItemClick(int position) {
		EneoBillDetails eneoBillDetails = eneoAdapter.getItem(position);
		alertView(eneoBillDetails);
	}
	
	private void alertView(final EneoBillDetails eneoBillDetails) {
		String message = eneoBillDetails.toReceptionString();
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("Pay eneo bill #" + eneoBillDetails.getBillNumber() + "?")
		      .setIcon(R.drawable.ic_launcher_background_kolo)
		      .setMessage(message)
		      .setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.cancel())
		      .setPositiveButton("Accept", (dialogInterface, i) -> {
			      Toast.makeText(KoloHelper.getMyActivity(), "Veuillez patienter", Toast.LENGTH_LONG).show();
			      ServiceHelper.doInBackground(eneoBillDetails, payBill);
		      }).show();
	}
}
