package com.danyalvarez.operationsresearch.queuingtheory.models;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.danyalvarez.operationsresearch.R;

/**
 * Created by daniel on 21/02/14.
 */
public class MMSCFragment extends Fragment {

    private Context mContext;

    public MMSCFragment(Context context) {
        this.mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_queuingtheory_mmsc, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

}
