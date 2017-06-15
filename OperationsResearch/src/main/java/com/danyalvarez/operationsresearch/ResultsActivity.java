package com.danyalvarez.operationsresearch;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.danyalvarez.operationsresearch.adapters.lists.ResultsListAdapter;
import com.danyalvarez.operationsresearch.classes.ResultItem;
import com.danyalvarez.operationsresearch.queuingtheory.QueuingTheory;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mList;
    private ResultsListAdapter mListAdapter;
    private ArrayList<ResultItem> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mList = (ListView) findViewById(android.R.id.list);
        mList.setOnItemClickListener(this);
        mListAdapter = new ResultsListAdapter(this);
        mList.setAdapter(mListAdapter);


        configActionBar();

        addItems();
    }

    private void configActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(true);

        actionBar.setDisplayUseLogoEnabled(false);

        int model = getIntent().getIntExtra("model", 0);
        String title = "";
        switch (model) {
            case QueuingTheory.MODEL_MM1:
                title = "M/M/1";
                break;
            case QueuingTheory.MODEL_MMS:
                title = "M/M/S";
                break;
            case QueuingTheory.MODEL_MM1C:
                title = "M/M/1/C";
                break;
            case QueuingTheory.MODEL_MMSC:
                title = "M/M/S/C";
                break;
            case QueuingTheory.MODEL_MM1K:
                title = "M/M/1/K";
                break;
            case QueuingTheory.MODEL_MMSK:
                title = "M/M/S/K";
                break;
        }

        actionBar.setSubtitle(title);
        actionBar.setTitle(R.string.results);
    }

    private void addItems() {
        mData = getIntent().getParcelableArrayListExtra("data");
        mListAdapter.setData(mData);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
//            case R.id.action_settings:
//                return true;
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ResultItem resultItem = mData.get(position);

        int idEquationImage = resultItem.getIdEquationImage();

        if (idEquationImage != 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = getLayoutInflater();

            View dialogView = inflater.inflate(R.layout.dialog_equation, null);

            ((ImageView) dialogView.findViewById(R.id.equationImage)).setImageResource(idEquationImage);

            builder.setView(dialogView)
//                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        // sign in the user ...
//                    }
//                })
                    .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            Dialog dialog = builder.create();
            dialog.show();
        }
    }
}
