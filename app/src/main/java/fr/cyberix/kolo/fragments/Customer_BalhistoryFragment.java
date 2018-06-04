package fr.cyberix.kolo.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.cyberix.kolo.adapters.CustBalHistoryRowItemsAdapter;
import fr.cyberix.kolo.model.entities.CustomerBalanceHistory;
import fr.cyberix.kolo.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Customer_BalhistoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Customer_BalhistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Customer_BalhistoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //Notification list view parameters
    private RecyclerView recyclerview;
    private List<CustomerBalanceHistory> custitems;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Customer_BalhistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Customer_BalhistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Customer_BalhistoryFragment newInstance(String param1, String param2) {
        Customer_BalhistoryFragment fragment = new Customer_BalhistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //notification recycler view code here
        View view = inflater.inflate(fr.cyberix.kolo.R.layout.fragment_customer__balhistory, container, false);
        recyclerview = view.findViewById(R.id.rylv_custbal_rowitems);
        recyclerview.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        CustBalHistoryRowItemsAdapter adapter = new CustBalHistoryRowItemsAdapter(this.getActivity(), custitems);
        recyclerview.setAdapter(adapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
