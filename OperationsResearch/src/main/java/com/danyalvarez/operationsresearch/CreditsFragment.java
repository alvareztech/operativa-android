package com.danyalvarez.operationsresearch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;

public class CreditsFragment extends DialogFragment {

    private Button mEnviarCorreoButton;
    private Button mIrWebButton;
    private Button mYoutubeButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_credits, container, false);

        mEnviarCorreoButton = rootView.findViewById(R.id.enviarCorreoButton);
        mIrWebButton = rootView.findViewById(R.id.irWebButton);
        mYoutubeButton = rootView.findViewById(R.id.youtubeButton);

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
                intentCorreo.putExtra(Intent.EXTRA_EMAIL, new String[]{"daniel@alvarez.tech"});
                intentCorreo.putExtra(Intent.EXTRA_SUBJECT, R.string.app_name);
                intentCorreo.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(intentCorreo);

            }
        });

        mIrWebButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri paginaWeb = Uri.parse("https://alvarez.tech");
                Intent intentPaginaWeb = new Intent(Intent.ACTION_VIEW, paginaWeb);
                startActivity(intentPaginaWeb);
            }
        });

        mYoutubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.youtube.com/channel/UCQBP46vtgU0OA91xL2tl-nQ");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
}
