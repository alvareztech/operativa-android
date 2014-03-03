package com.danyalvarez.operationsresearch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.danyalvarez.operationsresearch.queuingtheory.*;
import com.danyalvarez.operationsresearch.queuingtheory.models.fragments.*;

public class InputModelActivity extends ActionBarActivity {

    private int mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_model);

        mModel = getIntent().getIntExtra("model", 0);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, getFragmentFromModel(mModel)).commit();
        }


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(getIntent().getStringExtra("title"));
        actionBar.setSubtitle("Teoría de Colas");
        actionBar.setDisplayUseLogoEnabled(false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.input_model, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_calculate) {

            MM1Fragment fragment = (MM1Fragment) getSupportFragmentManager().findFragmentById(R.id.container);
            fragment.calculate();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public Fragment getFragmentFromModel(int model) {
        if (model == QueuingTheory.MODEL_MM1) {
            return new MM1Fragment(this);
        } else if (model == QueuingTheory.MODEL_MMS) {
            return new MMSFragment(this);
        } else if (model == QueuingTheory.MODEL_MM1C) {
            return new MM1CFragment(this);
        } else if (model == QueuingTheory.MODEL_MMSC) {
            return new MMSCFragment(this);
        } else if (model == QueuingTheory.MODEL_MM1K) {
            return new MM1KFragment(this);
        } else if (model == QueuingTheory.MODEL_MMSK) {
            return new MMSKFragment(this);
        }
        return null;
    }

}
