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

    private Context mContext;
    private OptionListAdapter mListAdapter;

    private String[] titles = {"M/M/1", "M/M/S", "M/M/1/C", "M/M/S/C", "M/M/1/K", "M/M/S/K"};
    private String[] descriptions = {
            "Población infinita, capacidad del sistema infinito, un canal de servicio",
            "Población infinita, capacidad del sistema infinito, S canales de servicio",
            "Población de tamaño C, capacidad del sistema infinito, un canal de servicio",
            "Población de tamaño C, capacidad del sistema infinito, S canales de servicio",
            "Población infinita, capacidad del sistema limitado a K, un canal de servicio",
            "Población infinita, capacidad del sistema limitado a K, S canales de servicio"
    };

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
        for (int i = 0; i < titles.length; i++) {
            if (i == 0) {
                mListAdapter.addItem("MODELOS", titles[i], descriptions[i]);
            } else {
                mListAdapter.addItem(titles[i], descriptions[i]);
            }
        }
        setListAdapter(mListAdapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(1);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(mContext, InputModelActivity.class);
        intent.putExtra("title", titles[position]);
        intent.putExtra("model", (int) (id + 1));
        startActivity(intent);
    }
}
