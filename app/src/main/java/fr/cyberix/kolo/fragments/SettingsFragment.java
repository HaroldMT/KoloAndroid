package fr.cyberix.kolo.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

import fr.cyberix.kolo.R;

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
	
	}
	
	@Override
	public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
		// Add 'general' preferences, defined in the XML file
		addPreferencesFromResource(R.xml.pref_general);
		
		SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
		
		PreferenceScreen preferenceScreen = getPreferenceScreen();
		
		int count = preferenceScreen.getPreferenceCount();
		
		for (int i = 0; i < count; i++) {
			Preference p = preferenceScreen.getPreference(i);
			if (!(p instanceof CheckBoxPreference)) {
				String value = sharedPreferences.getString(p.getKey(), "");
				setPreferenceSummery(p, value);
			}
		}
	}
	
	private void setPreferenceSummery(Preference preference, Object value) {
		
		String stringValue = value.toString();
		
		if (preference instanceof ListPreference) {
			// For list preferences, look up the correct display value in
			// the preference's 'entries' list (since they have separate labels/values).
			ListPreference listPreference = (ListPreference) preference;
			int prefIndex = listPreference.findIndexOfValue(stringValue);
			//same code in one line
			//int prefIndex = ((ListPreference) preference).findIndexOfValue(value);
			
			//prefIndex must be is equal or garter than zero because
			//array count as 0 to ....
			if (prefIndex >= 0) {
				listPreference.setSummary(listPreference.getEntries()[prefIndex]);
			}
		} else {
			// For other preferences, set the summary to the value's simple string representation.
			preference.setSummary(stringValue);
		}
	}
//	// TODO: Rename parameter arguments, choose names that match
//	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//	private static final String ARG_PARAM1 = "param1";
//	private static final String ARG_PARAM2 = "param2";
//
//	// TODO: Rename and change types of parameters
//	private String mParam1;
//	private String mParam2;
//
//	private OnFragmentInteractionListener mListener;
//
//	public SettingsFragment() {
//		// Required empty public constructor
//	}
//
//	/**
//	 * Use this factory method to create a new instance of
//	 * this fragment using the provided parameters.
//	 *
//	 * @param param1 Parameter 1.
//	 * @param param2 Parameter 2.
//	 * @return A new instance of fragment SettingsFragment.
//	 */
//	// TODO: Rename and change types and number of parameters
//	public static SettingsFragment newInstance(String param1, String param2) {
//		SettingsFragment fragment = new SettingsFragment();
//		Bundle args = new Bundle();
//		args.putString(ARG_PARAM1, param1);
//		args.putString(ARG_PARAM2, param2);
//		fragment.setArguments(args);
//		return fragment;
//	}
//
//	// TODO: Rename method, update argument and hook method into UI event
//	public void onButtonPressed(Uri uri) {
//		if (mListener != null) {
//			mListener.onFragmentInteraction(uri);
//		}
//	}
//
//	@Override
//	public void onAttach(Context context) {
//		super.onAttach(context);
//		if (context instanceof OnFragmentInteractionListener) {
//			mListener = (OnFragmentInteractionListener) context;
//		} else {
//			throw new RuntimeException(context.toString()
//					                           + " must implement OnFragmentInteractionListener");
//		}
//	}
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		if (getArguments() != null) {
//			mParam1 = getArguments().getString(ARG_PARAM1);
//			mParam2 = getArguments().getString(ARG_PARAM2);
//		}
//	}
//
//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//	                         Bundle savedInstanceState) {
//		// Inflate the layout for this fragment
//		return inflater.inflate(R.layout.fragment_settings, container, false);
//	}
//
//	@Override
//	public void onDetach() {
//		super.onDetach();
//		mListener = null;
//	}
//
//	/**
//	 * This interface must be implemented by activities that contain this
//	 * fragment to allow an interaction in this fragment to be communicated
//	 * to the activity and potentially other fragments contained in that
//	 * activity.
//	 * <p>
//	 * See the Android Training lesson <a href=
//	 * "http://developer.android.com/training/basics/fragments/communicating.html"
//	 * >Communicating with Other Fragments</a> for more information.
//	 */
//	public interface OnFragmentInteractionListener {
//		// TODO: Update argument type and name
//		void onFragmentInteraction(Uri uri);
//	}
}
