package com.danyalvarez.operationsresearch.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.danyalvarez.operationsresearch.MainActivity;
import com.danyalvarez.operationsresearch.R;
import com.danyalvarez.operationsresearch.adapters.lists.OptionListAdapter;

/**
 * Created by daniel on 20/02/14.
 */

public class OptionsFragment extends ListFragment {

    private Context mContext;
    private OptionListAdapter mListAdapter;

    public OptionsFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_options, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mListAdapter = new OptionListAdapter(mContext);
        mListAdapter.addItem("Modelo M/M/1", "Población infinita, capacidad del sistema infinito, un canal de servicio");
        mListAdapter.addItem("Modelo M/M/S", "Población infinita, capacidad del sistema infinito, S canales de servicio");
        mListAdapter.addItem("Modelo M/M/1/C", "Población de tamaño C, capacidad del sistema infinito, un canal de servicio");
        mListAdapter.addItem("Modelo M/M/S/C", "Población de tamaño C, capacidad del sistema infinito, S canales de servicio");
        mListAdapter.addItem("Modelo M/M/1/K", "Población infinita, capacidad del sistema limitado a K, un canal de servicio");
        mListAdapter.addItem("Modelo M/M/S/K", "Población infinita, capacidad del sistema limitado a K, S canales de servicio");

        setListAdapter(mListAdapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        ((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
