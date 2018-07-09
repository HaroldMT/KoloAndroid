package fr.cyberix.kolo.activities;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
import fr.cyberix.kolo.interfaces.KoloRecyclerViewClickListener;
import fr.cyberix.kolo.model.TransferP2pDetails;
import fr.cyberix.kolo.model.TransferP2pDetailsList;
import fr.cyberix.kolo.model.entities.TransfertP2p;
import fr.cyberix.kolo.services.KolOSphere;

public class KoloTransferP2pReceiveActivity extends AppCompatActivity implements KoloRecyclerViewClickListener {
	
	@BindView(R.id.trans_receive_p2p_recycler_view)
	RecyclerView recyclerView;
	@BindView(R.id.receive_p2p_swipe_container)
	SwipeRefreshLayout swipeContainer;
	
	private List<TransferP2pDetails> transferList = new ArrayList<>();
	private TransferP2pReceiveAdapter transferAdapter;

//	private View.OnClickListener myClickListener = new View.OnClickListener()
//	{
//		@Override
//		public void onClick(View view)
//		{
//			int position = (int)view.getTag();
//			//Do something...
//		}
//	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kolo_transfer_p2p_receive);
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
		KoloHelper.setActivity(this);
		
		transferAdapter = new TransferP2pReceiveAdapter(transferList, this);
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
		
		refreshItems();
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
	
	@Override
	public void recyclerViewListClicked(View v, int position, Object data) {
		TransferP2pDetails transferP2pDetails = (TransferP2pDetails) data;
		KoloHelper.ShowSimpleAlert("Receive P2P", transferP2pDetails.getAmount() + "XAF from" + transferP2pDetails.getSenderFullname() + ", Position " +
				position);
		alertView(transferP2pDetails.toReceptionString());
	}
	
	private void alertView(String message) {
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("Accept payment")
		      .setIcon(R.drawable.ic_launcher_background_kolo)
		      .setMessage(message)
		      .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			      public void onClick(DialogInterface dialogInterface, int i) {
				      dialogInterface.cancel();
			      }
		      })
		      .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
			      public void onClick(DialogInterface dialogInterface, int i) {
				      Toast.makeText(KoloHelper.getMyActivity(), "Succes", Toast.LENGTH_LONG);
			      }
		      }).show();
	}
	
	@SuppressLint("StaticFieldLeak")
	private void receiveInBackground(final TransferP2pDetails myTransfer) {
		Boolean saved;
		new AsyncTask<Void, Void, TransferP2pDetails>() {
			
			@Override
			protected TransferP2pDetails doInBackground(Void... voids) {
				try {
					String transJson = SerializationHelper.toJson(myTransfer, TransfertP2p.class);
					KolOSphere service = ServiceHelper.getSphereService();
					String transResult = service.DoReceiveA2A(transJson);
					TransferP2pDetails transferResult = SerializationHelper.fromJson(transResult, TransferP2pDetails.class);
					return transferResult;
				} catch (Exception ex) {
				
				}
				return null;
			}
			
			@Override
			protected void onPostExecute(TransferP2pDetails result) {
				Boolean succes = false;
				String message = "La transaction n'a pas aboutit, veuillez essayer plus tard";
				if (result != null) {
					if (result.isNeedsConfirmation()) {
						if (result.getStatus() == "CONFIRM_PENDING") {
							succes = true;
							message = "Vous recevrez " + result.getAmount() + "XAF dans votre compte après la confirmation de l'émetteur";
						}
					} else {
						if (result.getStatus() == "COMPLETED") {
							succes = true;
							message = "Vous avez reçu " + result.getAmount() + "XAF dans votre compte";
						}
					}
				}
				if (succes == true) onReceiveSucces(result, message);
				else onReceiveFailure(message);
			}
		}.execute();
	}
	
	private void onReceiveSucces(TransferP2pDetails transferP2p, String message) {
		Toast.makeText(this, message, Toast.LENGTH_LONG);
	}
	
	private void onReceiveFailure(String message) {
		KoloHelper.ShowSimpleAlert("Failure", message);
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
			TransferP2pDetailsList transferP2pDetailsList = SerializationHelper.fromKoloJson(transResult, TransferP2pDetailsList.class);
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