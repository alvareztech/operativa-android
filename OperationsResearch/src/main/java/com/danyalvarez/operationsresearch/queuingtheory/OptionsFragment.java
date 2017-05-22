package com.danyalvarez.operationsresearch.queuingtheory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.danyalvarez.operationsresearch.InputModelActivity;
import com.danyalvarez.operationsresearch.MainActivity;
import com.danyalvarez.operationsresearch.R;
import com.danyalvarez.operationsresearch.adapters.lists.OptionListAdapter;

/**
 * Created by daniel on 20/02/14.
 */

public class OptionsFragment extends ListFragment {

    private OptionListAdapter mListAdapter;

    private String[] titles = {"M/M/1", "M/M/S", "M/M/1/C", "M/M/S/C", "M/M/1/K", "M/M/S/K"};
    private int[] descriptions = {
            R.string.mm1_desc,
            R.string.mms_desc,
            R.string.mm1c_desc,
            R.string.mmsc_desc,
            R.string.mm1k_desc,
            R.string.mmsk_desc
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_options, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mListAdapter = new OptionListAdapter(getActivity());
        for (int i = 0; i < titles.length; i++) {
            if (i == 0) {
                mListAdapter.addItem(getString(R.string.models), titles[i], getString(descriptions[i]));
            } else {
                mListAdapter.addItem(titles[i], getString(descriptions[i]));
            }
        }
        setListAdapter(mListAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(getActivity(), InputModelActivity.class);
        intent.putExtra("title", titles[position]);
        intent.putExtra("model", (int) (id + 1));
        startActivity(intent);
    }
}
