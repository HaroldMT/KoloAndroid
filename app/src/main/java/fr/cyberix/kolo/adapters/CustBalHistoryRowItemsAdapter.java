package fr.cyberix.kolo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.model.entities.CustomerBalanceHistory;

public class CustBalHistoryRowItemsAdapter extends RecyclerView.Adapter<CustBalHistoryRowItemsAdapter.CustBalHistViewHolder> {

    private Context context;
    private List<CustomerBalanceHistory> custData;

    public CustBalHistoryRowItemsAdapter(Context context, List<CustomerBalanceHistory> custData) {
        this.context = context;
        this.custData = custData;
    }

    @NonNull
    @Override
    public CustBalHistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kolocustbalhist_rowitems, parent, false);
        return new CustBalHistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustBalHistViewHolder holder, int position) {
        holder.txtoptype.setText(custData.get(position).getOperationTypeCode());
        holder.txtamount.setText(custData.get(position).getAmount());
        holder.txtoldbalance.setText(custData.get(position).getOldBalance());
        holder.txtnewbalance.setText(custData.get(position).getNewBalance());
        holder.txthistorydate.setText(custData.get(position).getHistoryDate());
    }

    @Override
    public int getItemCount() {
        return custData.size();
    }

    public static class CustBalHistViewHolder extends RecyclerView.ViewHolder {

        TextView txtoptype, txtamount, txtoldbalance, txtnewbalance, txthistorydate;

        public CustBalHistViewHolder(View itemView) {
            super(itemView);

            txtoptype = itemView.findViewById(R.id.txt_custbal_optype);
            txtamount = itemView.findViewById(R.id.txt_custbal_amount);
            txtoldbalance = itemView.findViewById(R.id.txt_custbal_oldbalance);
            txtnewbalance = itemView.findViewById(R.id.txt_custbal_newbalance);
            txthistorydate = itemView.findViewById(R.id.txt_custbal_historydate);
        }
    }
}
