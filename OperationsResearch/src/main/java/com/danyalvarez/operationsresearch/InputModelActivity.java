package com.danyalvarez.operationsresearch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;

import com.danyalvarez.operationsresearch.queuingtheory.QueuingTheory;
import com.danyalvarez.operationsresearch.queuingtheory.models.fragments.*;

public class InputModelActivity extends AppCompatActivity {

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
        actionBar.setTitle(getTitleOfModel(mModel));
        actionBar.setSubtitle(R.string.queuing_theory);
        actionBar.setDisplayUseLogoEnabled(false);
    }

    private int getTitleOfModel(int model) {
        if (model == QueuingTheory.MODEL_MM1) {
            return R.string.mm1;
        } else if (model == QueuingTheory.MODEL_MMS) {
            return R.string.mms;
        } else if (model == QueuingTheory.MODEL_MM1C) {
            return R.string.mm1c;
        } else if (model == QueuingTheory.MODEL_MMSC) {
            return R.string.mmsc;
        } else if (model == QueuingTheory.MODEL_MM1K) {
            return R.string.mm1k;
        } else if (model == QueuingTheory.MODEL_MMSK) {
            return R.string.mmsk;
        }
        return 0;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.input_model, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_calculate) {
            switch (mModel) {
                case QueuingTheory.MODEL_MM1:
                    MM1Fragment mm1Fragment = (MM1Fragment) getSupportFragmentManager().findFragmentById(R.id.container);
                    mm1Fragment.calculate();
                    break;

                case QueuingTheory.MODEL_MMS:
                    MMSFragment mmsFragment = (MMSFragment) getSupportFragmentManager().findFragmentById(R.id.container);
                    mmsFragment.calculate();
                    break;

                case QueuingTheory.MODEL_MM1C:
                    MM1CFragment mm1CFragment = (MM1CFragment) getSupportFragmentManager().findFragmentById(R.id.container);
                    mm1CFragment.calculate();
                    break;

                case QueuingTheory.MODEL_MMSC:
                    MMSCFragment mmscFragment = (MMSCFragment) getSupportFragmentManager().findFragmentById(R.id.container);
                    mmscFragment.calculate();
                    break;

                case QueuingTheory.MODEL_MM1K:
                    MM1KFragment mm1KFragment = (MM1KFragment) getSupportFragmentManager().findFragmentById(R.id.container);
                    mm1KFragment.calculate();
                    break;

                case QueuingTheory.MODEL_MMSK:
                    MMSKFragment mmskFragment = (MMSKFragment) getSupportFragmentManager().findFragmentById(R.id.container);
                    mmskFragment.calculate();
                    break;
            }


            return true;
        } else if (id == android.R.id.home) {
            finish();
        }
        return true;
    }


    public Fragment getFragmentFromModel(int model) {
        if (model == QueuingTheory.MODEL_MM1) {
            return new MM1Fragment();
        } else if (model == QueuingTheory.MODEL_MMS) {
            return new MMSFragment();
        } else if (model == QueuingTheory.MODEL_MM1C) {
            return new MM1CFragment();
        } else if (model == QueuingTheory.MODEL_MMSC) {
            return new MMSCFragment();
        } else if (model == QueuingTheory.MODEL_MM1K) {
            return new MM1KFragment();
        } else if (model == QueuingTheory.MODEL_MMSK) {
            return new MMSKFragment();
        }
        return null;
    }

}
