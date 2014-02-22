package com.danyalvarez.operationsresearch.fragments.queuingtheory;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.danyalvarez.operationsresearch.R;
import com.danyalvarez.operationsresearch.util.Util;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by daniel on 21/02/14.
 */
public class MMSCFragment extends Fragment {

    private Context mContext;

    private ImageView mTasaLlegadasImage;
    private ImageView mTasaServicioImage;
    private ImageView mNumeroCanalesServicioImage;
    private ImageView mTamanoPoblacionImage;

    public MMSCFragment(Context context) {
        this.mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_queuingtheory_mmsc, container, false);

        mTasaLlegadasImage = (ImageView) view.findViewById(R.id.tasaLlegadasImage);
        mTasaServicioImage = (ImageView) view.findViewById(R.id.tasaServicioImage);
        mNumeroCanalesServicioImage = (ImageView) view.findViewById(R.id.numeroCanalesServicioImage);
        mTamanoPoblacionImage = (ImageView) view.findViewById(R.id.tamanoPoblacionImage);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTasaLlegadasImage.setImageBitmap(Util.getPngBitmapFromAssets(mContext, "lamda"));

        mTasaServicioImage.setImageBitmap(Util.getPngBitmapFromAssets(mContext, "mu"));

        mNumeroCanalesServicioImage.setImageBitmap(Util.getPngBitmapFromAssets(mContext, "s"));

        mTamanoPoblacionImage.setImageBitmap(Util.getPngBitmapFromAssets(mContext, "c"));
    }

}
