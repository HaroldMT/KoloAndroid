package fr.cyberix.kolo.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.adapters.EneoBillDetailsAdapter;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.SerializationHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.model.EneoBillDetails;
import fr.cyberix.kolo.model.EneoBillDetailsList;
import fr.cyberix.kolo.services.KolOPartVice;

public class KoloEneoPayBillActivity extends AppCompatActivity {
	@BindView(R.id.eneo_pay_bill_recycler_view)
	RecyclerView recyclerView;
	@BindView(R.id.eneo_pay_bill_swipe_container)
	SwipeRefreshLayout swipeContainer;
	String eneoCode;
	boolean isContractSearch = true;
	private List<EneoBillDetails> billList = new ArrayList<>();
	private EneoBillDetailsAdapter eneoAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kolo_eneo_pay_bill);
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
		KoloHelper.setActivity(this);
		readParameters();
		
		eneoAdapter = new EneoBillDetailsAdapter(billList);
		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
		recyclerView.setLayoutManager(mLayoutManager);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		recyclerView.setAdapter(eneoAdapter);
		
		swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				// Refresh items
				refreshItems();
			}
		});
		
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
		KoloEneoPayBillActivity.RefreshEneoAsync refreshEneoAsync = new KoloEneoPayBillActivity.RefreshEneoAsync(eneoCode, isContractSearch);
		refreshEneoAsync.execute();
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
		Toast.makeText(KoloHelper.getMyContext(), nb + " factures trouvées", Toast.LENGTH_LONG);
	}
	
	public class RefreshEneoAsync extends AsyncTask<Void, Void, EneoBillDetailsList> {
		String eneoCode;
		boolean isContractNo;
		String result;
		
		public RefreshEneoAsync(String code, boolean isContractNumber) {
			eneoCode = code;
			isContractNo = isContractNumber;
		}
		
		@Override
		protected EneoBillDetailsList doInBackground(Void... voids) {
			KolOPartVice service = ServiceHelper.getKolOPartVice();
			if (isContractNo)
				result = service.GetEneoBillsByBillAccount(eneoCode);
			else
				result = service.GetEneoBillByBillNumber(eneoCode);
			EneoBillDetailsList resultList = SerializationHelper.fromKoloJson(result, EneoBillDetailsList.class);
			return resultList;
		}
		
		@Override
		protected void onPostExecute(EneoBillDetailsList eneoBillDetailsList) {
			super.onPostExecute(eneoBillDetailsList);
			setBillList(eneoBillDetailsList);
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		KoloHelper.setActivity(this);
	}
}
