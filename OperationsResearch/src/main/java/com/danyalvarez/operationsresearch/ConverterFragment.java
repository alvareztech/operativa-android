package com.danyalvarez.operationsresearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.danyalvarez.operationsresearch.adapters.lists.OptionListAdapter;

/**
 * Created by daniel on 20/02/14.
 */

public class ConverterFragment extends Fragment {

    private Context mContext;
    private OptionListAdapter mListAdapter;

    public ConverterFragment(Context mContext) {
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

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(3);
    }

}
