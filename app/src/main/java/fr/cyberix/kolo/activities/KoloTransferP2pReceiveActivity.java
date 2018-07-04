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
import fr.cyberix.kolo.adapters.TransferP2pReceiveAdapter;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.SerializationHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.model.TransferP2pDetails;
import fr.cyberix.kolo.model.TransferP2pDetailsList;
import fr.cyberix.kolo.services.KolOSphere;

public class KoloTransferP2pReceiveActivity extends AppCompatActivity {
	
	@BindView(R.id.trans_receive_p2p_recycler_view)
	RecyclerView recyclerView;
	@BindView(R.id.receive_p2p_swipe_container)
	SwipeRefreshLayout swipeContainer;
	
	private List<TransferP2pDetails> transferList = new ArrayList<>();
	private TransferP2pReceiveAdapter transferAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kolo_transfer_p2p_receive);
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
		KoloHelper.setActivity(this);
		
		transferAdapter = new TransferP2pReceiveAdapter(transferList);
		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
		recyclerView.setLayoutManager(mLayoutManager);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		recyclerView.setAdapter(transferAdapter);
		
		swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				// Refresh items
				refreshItems();
			}
		});
	}
	
	private void refreshItems() {
		swipeContainer.setRefreshing(true);
		RefreshReceiveAsync receiveAsync = new RefreshReceiveAsync(ConfigHelper.getAccountInfo().getCustomer().getIdCustomer());
		receiveAsync.execute();
	}
	
	private void setTransferList(List<TransferP2pDetails> transferList) {
		transferAdapter.clear();
		transferAdapter.addAll(transferList);
		onItemsLoadComplete();
	}
	
	private void onItemsLoadComplete() {
		transferAdapter.notifyDataSetChanged();
		swipeContainer.setRefreshing(false);
		int nb = transferAdapter.getItemCount();
		Toast.makeText(KoloHelper.getMyContext(), nb + " opérations trouvées", Toast.LENGTH_LONG);
	}
	
	public class RefreshReceiveAsync extends AsyncTask<Void, Void, TransferP2pDetailsList> {
		int customerId;
		
		public RefreshReceiveAsync(int id) {
			customerId = id;
		}
		
		@Override
		protected TransferP2pDetailsList doInBackground(Void... voids) {
			KolOSphere service = ServiceHelper.getSphereService();
			String transResult = service.GetTransfertP2pList(customerId);
			TransferP2pDetailsList transferP2pDetailsList = SerializationHelper.fromJson(transResult, TransferP2pDetailsList.class);
			return transferP2pDetailsList;
		}
		
		@Override
		protected void onPostExecute(TransferP2pDetailsList transferP2pDetailsList) {
			super.onPostExecute(transferP2pDetailsList);
			setTransferList(transferP2pDetailsList);
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		KoloHelper.setActivity(this);
	}
}