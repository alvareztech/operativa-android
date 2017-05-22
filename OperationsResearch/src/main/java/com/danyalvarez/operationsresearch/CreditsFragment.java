package com.danyalvarez.operationsresearch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.danyalvarez.operationsresearch.adapters.lists.OptionListAdapter;

public class CreditsFragment extends Fragment {

    private OptionListAdapter mListAdapter;

    private Button mEnviarCorreoButton;
    private Button mIrWebButton;
    private Button mIrGitHubButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_credits, container, false);

        mEnviarCorreoButton = (Button) rootView.findViewById(R.id.enviarCorreoButton);
        mIrWebButton = (Button) rootView.findViewById(R.id.irWebButton);
        mIrGitHubButton = (Button) rootView.findViewById(R.id.irGitHubButton);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mEnviarCorreoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentCorreo = new Intent(Intent.ACTION_SEND);
                intentCorreo.setType("text/plain");
                intentCorreo.putExtra(Intent.EXTRA_EMAIL, new String[]{"i@danyalvarez.com"});
                intentCorreo.putExtra(Intent.EXTRA_SUBJECT, R.string.app_name);
                intentCorreo.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(intentCorreo);

            }
        });

        mIrWebButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri paginaWeb = Uri.parse("http://www.danyalvarez.com");
                Intent intentPaginaWeb = new Intent(Intent.ACTION_VIEW, paginaWeb);
                startActivity(intentPaginaWeb);
            }
        });

        mIrGitHubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri paginaWeb = Uri.parse("https://github.com/danyalvarez/OperationsResearch-Android");
                Intent intentPaginaWeb = new Intent(Intent.ACTION_VIEW, paginaWeb);
                startActivity(intentPaginaWeb);
            }
        });

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(2);
    }


}
