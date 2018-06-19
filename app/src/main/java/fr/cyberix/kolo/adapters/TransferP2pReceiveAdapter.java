package fr.cyberix.kolo.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.adapters.viewHolders.TransferP2pReceiveViewHolder;
import fr.cyberix.kolo.model.TransferP2pDetails;

public class TransferP2pReceiveAdapter extends RecyclerView.Adapter<TransferP2pReceiveViewHolder> {
	
	public View transferView;
	
	//    public class TransferP2pReceiveViewHolder extends RecyclerView.ViewHolder {
//        public TextView fullname, amount, number, status;
//        public TransferP2pReceiveViewHolder(View view) {
//            super(view);
//            fullname = (TextView) view.findViewById(R.id.receiveP2pFullname);
//            amount = (TextView) view.findViewById(R.id.receiveP2pAmount);
//            number = (TextView) view.findViewById(R.id.receiveP2pNumber);
//            status = (TextView) view.findViewById(R.id.receiveP2pStatus);
//        }
//    }
	List<TransferP2pDetails> transferList;
	
	public TransferP2pReceiveAdapter(List<TransferP2pDetails> transfersDetails) {
		transferList = transfersDetails;
	}
	
	@NonNull
	@Override
	public TransferP2pReceiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		transferView = LayoutInflater.from(parent.getContext())
		                             .inflate(R.layout.kolo_transfer_p2p_receive_row, parent, false);
		return new TransferP2pReceiveViewHolder(transferView);
	}
	
	@Override
	public void onBindViewHolder(@NonNull TransferP2pReceiveViewHolder holder, int position) {
		TransferP2pDetails transferP2pDetails = transferList.get(position);
		holder.amount.setText(transferP2pDetails.getAmount() + "");
		holder.fullname.setText(transferP2pDetails.getSenderFullname());
		holder.number.setText(transferP2pDetails.getSenderTelephone());
		holder.status.setText(transferP2pDetails.getStatus());
	}
	
	@Override
	public int getItemCount() {
		return transferList.size();
	}
	
	// Clean all elements of the recycler
	public void clear() {
		transferList.clear();
		notifyDataSetChanged();
	}
	
	// Add a list of items -- change to type used
	public void addAll(List<TransferP2pDetails> list) {
		if (list == null || list.size() == 0)
			return;
		transferList.addAll(list);
		notifyDataSetChanged();
	}
}
