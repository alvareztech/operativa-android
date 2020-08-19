package com.danyalvarez.operationsresearch;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.danyalvarez.operationsresearch.queuingtheory.Model;
import com.danyalvarez.operationsresearch.queuingtheory.models.fragments.MM1CFragment;
import com.danyalvarez.operationsresearch.queuingtheory.models.fragments.MM1Fragment;
import com.danyalvarez.operationsresearch.queuingtheory.models.fragments.MM1KFragment;
import com.danyalvarez.operationsresearch.queuingtheory.models.fragments.MMSCFragment;
import com.danyalvarez.operationsresearch.queuingtheory.models.fragments.MMSFragment;
import com.danyalvarez.operationsresearch.queuingtheory.models.fragments.MMSKFragment;
import com.danyalvarez.operationsresearch.util.Analytics;

public class InputModelActivity extends AppCompatActivity {

    private Model mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_model);

        mModel = Model.values()[getIntent().getIntExtra("model", 0)];

        Analytics.reportModel(mModel.name(), this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, mModel.getFragment()).commit();
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mModel.getTitle());
        actionBar.setSubtitle(R.string.queuing_theory);
        actionBar.setDisplayUseLogoEnabled(false);
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
                case MM1:
                    MM1Fragment mm1Fragment = (MM1Fragment) getSupportFragmentManager().findFragmentById(R.id.container);
                    mm1Fragment.calculate();
                    break;

                case MMS:
                    MMSFragment mmsFragment = (MMSFragment) getSupportFragmentManager().findFragmentById(R.id.container);
                    mmsFragment.calculate();
                    break;

                case MM1C:
                    MM1CFragment mm1CFragment = (MM1CFragment) getSupportFragmentManager().findFragmentById(R.id.container);
                    mm1CFragment.calculate();
                    break;

                case MMSC:
                    MMSCFragment mmscFragment = (MMSCFragment) getSupportFragmentManager().findFragmentById(R.id.container);
                    mmscFragment.calculate();
                    break;

                case MM1K:
                    MM1KFragment mm1KFragment = (MM1KFragment) getSupportFragmentManager().findFragmentById(R.id.container);
                    mm1KFragment.calculate();
                    break;

                case MMSK:
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
}
