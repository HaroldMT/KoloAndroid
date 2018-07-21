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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.adapters.TransferP2pAdapter;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.interfaces.ServiceOperationInterface;
import fr.cyberix.kolo.model.KoloWsObject;
import fr.cyberix.kolo.model.TransferP2pDetails;
import fr.cyberix.kolo.model.TransferP2pDetailsList;

public class KoloTransferP2pReceiveActivity extends AppCompatActivity implements OnRecyclerItemClickListener {
	
	@BindView(R.id.trans_receive_p2p_recycler_view)
	RecyclerView recyclerView;
	@BindView(R.id.receive_p2p_swipe_container)
	SwipeRefreshLayout swipeContainer;
	
	ServiceOperationInterface<TransferP2pDetails, KoloWsObject<TransferP2pDetails>> acceptP2pTransferServiceInterface = new
			ServiceOperationInterface<TransferP2pDetails,
					KoloWsObject<TransferP2pDetails>>() {
				@Override
				public void onOperationSuccess(String message, KoloWsObject<TransferP2pDetails> data) {
					Toast.makeText(KoloHelper.getMyActivity(), message, Toast.LENGTH_LONG).show();
				}
				
				@Override
				public void onOperationFailure(String errorMessage) {
					KoloHelper.ShowSimpleAlert("Failure", errorMessage);
				}
				
				@Override
				public void onPreExecute() {
				}
				
				@Override
				public KoloWsObject<TransferP2pDetails> doInBackground(TransferP2pDetails parameter) {
					return ServiceHelper.acceptP2pTransfer(parameter);
				}
			};
	private TransferP2pAdapter transferAdapter;
	ServiceOperationInterface<TransferP2pDetailsList, KoloWsObject<TransferP2pDetailsList>> getP2pTransferServiceInterface = new
			ServiceOperationInterface<TransferP2pDetailsList,
					KoloWsObject<TransferP2pDetailsList>>() {
				@Override
				public void onOperationSuccess(String message, KoloWsObject<TransferP2pDetailsList> data) {
					TransferP2pDetailsList transferP2pDetailsList = data.getDataObject();
					setTransferList(transferP2pDetailsList);
				}
				
				@Override
				public void onOperationFailure(String errorMessage) {
					KoloHelper.ShowSimpleAlert("Failure", errorMessage);
				}
				
				@Override
				public void onPreExecute() {
				
				}
				
				@Override
				public KoloWsObject<TransferP2pDetailsList> doInBackground(TransferP2pDetailsList parameter) {
					return ServiceHelper.getP2pTransfers(parameter);
				}
			};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kolo_transfer_p2p_receive);
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
		KoloHelper.setActivity(this);
		
		transferAdapter = new TransferP2pAdapter(this, this);
		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
		recyclerView.setLayoutManager(mLayoutManager);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		recyclerView.setAdapter(transferAdapter);
		
		swipeContainer.setOnRefreshListener(this::refreshItems);
		refreshItems();
	}
	
	private void refreshItems() {
		swipeContainer.setRefreshing(true);
		ServiceHelper.doInBackground(null, getP2pTransferServiceInterface);
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
		Toast.makeText(KoloHelper.getMyContext(), nb + " opérations trouvées", Toast.LENGTH_LONG).show();
	}
	
	@Override
	public void onItemClick(int position) {
		TransferP2pDetails selectedTransfer = transferAdapter.getItem(position);
		alertView(selectedTransfer);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		KoloHelper.setActivity(this);
	}
	
	private void alertView(final TransferP2pDetails transferP2pDetails) {
		String message = transferP2pDetails.toReceptionString();
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("Accept payment")
		      .setIcon(R.drawable.ic_launcher_background_kolo)
		      .setMessage(message)
		      .setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.cancel())
		      .setPositiveButton("Accept", (dialogInterface, i) -> {
			      Toast.makeText(KoloHelper.getMyActivity(), "Veuillez patienter", Toast.LENGTH_LONG).show();
			      ServiceHelper.doInBackground(transferP2pDetails, acceptP2pTransferServiceInterface);
		      }).show();
	}
}