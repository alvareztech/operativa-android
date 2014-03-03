package com.danyalvarez.operationsresearch;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import com.danyalvarez.operationsresearch.adapters.lists.ResultsListAdapter;

public class ResultsActivity extends ActionBarActivity {

    private ListView mList;
    private ResultsListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mList = (ListView) findViewById(android.R.id.list);
        mListAdapter = new ResultsListAdapter(this);
        mList.setAdapter(mListAdapter);

        addItems();
    }

    private void addItems() {
        mListAdapter.addItem(R.drawable.lamda, "Tasa de llegadas", 2.321);
        mListAdapter.addItem(R.drawable.mu, "Tasa de servicio", 2.321);
        mListAdapter.addItem("Probabilidad", R.drawable.rho, "De encontrar el sistema ocupado", 0.000000006);
        mListAdapter.addItem(R.drawable.p0, "De que el sistema este vacio u oscioso", 987123);

        mListAdapter.addItem("Número promedio o esperado", R.drawable.l, "De unidades en el sistema", 2.321);
        mListAdapter.addItem(R.drawable.lq, "De unidades en cola", 2.321);

        mListAdapter.addItem("Tiempo medio de espera", R.drawable.w, "En el sistema", 2.321);
        mListAdapter.addItem(R.drawable.wq, "En la cola", 2.321);

        mListAdapter.addItem("Probabilidad de encontrar", R.drawable.p1, "1 unidades en el sistema", 2342.234234);
        mListAdapter.addItem(R.drawable.p2, "2 unidades en el sistema", 2.321);
        mListAdapter.addItem(R.drawable.p3, "3 unidades en el sistema", 2.321);
        mListAdapter.addItem(R.drawable.p4, "4 unidades en el sistema", 2.321);
        mListAdapter.addItem(R.drawable.p5, "5 unidades en el sistema", 2.321);
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

}
