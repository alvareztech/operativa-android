package com.danyalvarez.operationsresearch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class CreditsFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_credits, container, false);

        Button webButton = rootView.findViewById(R.id.webButton);
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeb("https://alvarez.tech/projects/operativa/");
            }
        });
        TextView version = rootView.findViewById(R.id.versionTextView);
        version.setText(getString(R.string.version, BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE));

        return rootView;
    }

    private void openWeb(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
