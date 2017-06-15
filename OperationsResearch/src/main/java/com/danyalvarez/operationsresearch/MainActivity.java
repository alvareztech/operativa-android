package com.danyalvarez.operationsresearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.danyalvarez.operationsresearch.adapters.lists.OptionListAdapter;

public class MainActivity extends AppCompatActivity {

    private OptionListAdapter mListAdapter;
    private ListView cardsListView;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardsListView = (ListView) findViewById(R.id.cardsListView);
        cardsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, InputModelActivity.class);
                intent.putExtra("title", titles[position]);
                intent.putExtra("model", (int) (id + 1));

                startActivity(intent);
            }
        });

        mListAdapter = new OptionListAdapter(this);
        for (int i = 0; i < titles.length; i++) {
            if (i == 0) {
                mListAdapter.addItem(getString(R.string.models), titles[i], getString(descriptions[i]));
            } else {
                mListAdapter.addItem(titles[i], getString(descriptions[i]));
            }
        }
        cardsListView.setAdapter(mListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_info) {
            DialogFragment newFragment = new CreditsFragment();
            newFragment.show(getSupportFragmentManager(), "dialog");
        } else if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
