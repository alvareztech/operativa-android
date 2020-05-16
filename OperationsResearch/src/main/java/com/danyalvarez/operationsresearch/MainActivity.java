package com.danyalvarez.operationsresearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.danyalvarez.operationsresearch.queuingtheory.Model;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void open(View view) {
        Intent intent = new Intent(this, InputModelActivity.class);
        if (view.getId() == R.id.mm1CardView) {
            intent.putExtra("model", Model.MM1.ordinal());
        } else if (view.getId() == R.id.mmsCardView) {
            intent.putExtra("model", Model.MMS.ordinal());
        } else if (view.getId() == R.id.mm1cCardView) {
            intent.putExtra("model", Model.MM1C.ordinal());
        } else if (view.getId() == R.id.mmscCardView) {
            intent.putExtra("model", Model.MMSC.ordinal());
        } else if (view.getId() == R.id.mm1kCardView) {
            intent.putExtra("model", Model.MM1K.ordinal());
        } else if (view.getId() == R.id.mmskCardView) {
            intent.putExtra("model", Model.MMSK.ordinal());
        }
        startActivity(intent);
    }
}
