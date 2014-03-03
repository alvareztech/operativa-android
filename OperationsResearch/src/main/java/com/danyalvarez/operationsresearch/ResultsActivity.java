package com.danyalvarez.operationsresearch;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.danyalvarez.operationsresearch.adapters.lists.ResultsListAdapter;
import com.danyalvarez.operationsresearch.classes.ResultItem;
import com.danyalvarez.operationsresearch.queuingtheory.QueuingTheory;

import java.util.ArrayList;

public class ResultsActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private ListView mList;
    private ResultsListAdapter mListAdapter;

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
        actionBar.setTitle("Resultados");
    }

    private void addItems() {

        ArrayList<ResultItem> data = getIntent().getParcelableArrayListExtra("data");
        mListAdapter.setData(data);

//        mListAdapter.addItem(R.drawable.lamda, "Tasa de llegadas", 2.321);
//        mListAdapter.addItem(R.drawable.mu, "Tasa de servicio", 2.321);
//        mListAdapter.addItem("Probabilidad", R.drawable.rho, "De encontrar el sistema ocupado", 0.000000006);
//        mListAdapter.addItem(R.drawable.p0, "De que el sistema este vacio u oscioso", 987123);
//
//        mListAdapter.addItem("Número promedio o esperado", R.drawable.l, "De unidades en el sistema", 2.321);
//        mListAdapter.addItem(R.drawable.lq, "De unidades en cola", 2.321);
//
//        mListAdapter.addItem("Tiempo medio de espera", R.drawable.w, "En el sistema", 2.321);
//        mListAdapter.addItem(R.drawable.wq, "En la cola", 2.321);
//
//        mListAdapter.addItem("Probabilidad de encontrar", R.drawable.p1, "1 unidades en el sistema", 2342.234234);
//        mListAdapter.addItem(R.drawable.p2, "2 unidades en el sistema", 2.321);
//        mListAdapter.addItem(R.drawable.p3, "3 unidades en el sistema", 2.321);
//        mListAdapter.addItem(R.drawable.p4, "4 unidades en el sistema", 2.321);
//        mListAdapter.addItem(R.drawable.p5, "5 unidades en el sistema", 2.321);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialog_equation, null))
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
