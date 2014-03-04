package com.danyalvarez.operationsresearch.queuingtheory.models.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.danyalvarez.operationsresearch.R;
import com.danyalvarez.operationsresearch.ResultsActivity;
import com.danyalvarez.operationsresearch.classes.ResultItem;
import com.danyalvarez.operationsresearch.queuingtheory.QueuingTheory;
import com.danyalvarez.operationsresearch.queuingtheory.models.MM1KModel;
import com.danyalvarez.operationsresearch.queuingtheory.models.MMSKModel;
import com.danyalvarez.operationsresearch.util.Format;

import java.util.ArrayList;

/**
 * Created by daniel on 21/02/14.
 */
public class MMSKFragment extends Fragment {

    private Context mContext;

    private EditText mTasaLlegadasEditText;
    private EditText mTasaServicioEditText;
    private EditText mCanalesServicioEditText;
    private EditText mLimiteSistemaEditText;

    public MMSKFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_queuingtheory_mmsk, container, false);

        mTasaLlegadasEditText = (EditText) view.findViewById(R.id.tasaLlegadasEditText);
        mTasaServicioEditText = (EditText) view.findViewById(R.id.tasaServicioEditText);
        mCanalesServicioEditText = (EditText) view.findViewById(R.id.canalesServicioEditText);
        mLimiteSistemaEditText = (EditText) view.findViewById(R.id.limiteSistemaEditText);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    public void calculate() {
        String tasaLlegadasStr = mTasaLlegadasEditText.getText().toString().trim();
        String tasaServicioStr = mTasaServicioEditText.getText().toString().trim();
        String canalesServicioStr = mCanalesServicioEditText.getText().toString().trim();
        String limiteSistemaStr = mLimiteSistemaEditText.getText().toString().trim();

        if (tasaLlegadasStr.length() == 0 || tasaServicioStr.length() == 0 || limiteSistemaStr.length() == 0 || canalesServicioStr.length() == 0) {
            mTasaLlegadasEditText.setError(getString(R.string.requested));
            mTasaServicioEditText.setError(getString(R.string.requested));
            mCanalesServicioEditText.setError(getString(R.string.requested));
            mLimiteSistemaEditText.setError(getString(R.string.requested));
            return;
        }

        double tasaLlegadas = Double.parseDouble(tasaLlegadasStr);
        double tasaServicio = Double.parseDouble(tasaServicioStr);
        int canalesServicio = Integer.parseInt(canalesServicioStr);
        int limiteSistema = Integer.parseInt(limiteSistemaStr);

        MMSKModel mmsk = new MMSKModel(tasaLlegadas, tasaServicio, canalesServicio, limiteSistema);
        mmsk.calculate();

        ArrayList<ResultItem> data = new ArrayList<ResultItem>();
        data.add(new ResultItem(R.drawable.lamda, getString(R.string.tasa_de_llegadas), Format.numberTwoDecimals(tasaLlegadas)));
        data.add(new ResultItem(R.drawable.mu, getString(R.string.tasa_de_servicio), Format.numberTwoDecimals(tasaServicio)));
        data.add(new ResultItem(R.drawable.s, getString(R.string.numero_de_canales_de_servicio), Format.numberWithoutDecimals(canalesServicio)));
        data.add(new ResultItem(R.drawable.k, getString(R.string.limite_del_sistema), Format.numberWithoutDecimals(limiteSistema)));
//        data.add(new ResultItem(R.drawable.lamdax, getString(R.string.tasa_media_filtraje), Format.numberWithoutDecimals(mmsk.getLamdax())));


//        data.add(new ResultItem(getString(R.string.numero_esperado_unidades),
//                R.drawable.l, getString(R.string.en_sistema), Format.numberTwoDecimals(mmsk.getL()), R.drawable.mm1k_l));
//        data.add(new ResultItem(
//                R.drawable.lq, getString(R.string.en_cola), Format.numberTwoDecimals(mmsk.getLq()), R.drawable.mm1k_lq));
//
//        data.add(new ResultItem(getString(R.string.tiempo_medio_espera),
//                R.drawable.w, getString(R.string.en_sistema), Format.numberTwoDecimals(mmsk.getW()), R.drawable.mm1k_w));
//        data.add(new ResultItem(
//                R.drawable.wq, getString(R.string.en_cola), Format.numberTwoDecimals(mmsk.getWq()), R.drawable.mm1k_wq));


        data.add(new ResultItem(getString(R.string.probabilidades),
                R.drawable.rho, getString(R.string.encontrar_sistema_ocupado), Format.numberFourDecimals(mmsk.getRho()), R.drawable.mmsk_rho));
        data.add(new ResultItem(
                R.drawable.p0, getString(R.string.sistema_vacio_oscioso), Format.numberFourDecimals(mmsk.getPn(0)), R.drawable.mmsk_p0));
//        data.add(new ResultItem(
//                R.drawable.p1, getString(R.string.encontrar_) + 1 + getString(R.string._unidad_en_sistema), Format.numberFourDecimals(mmsk.getPn(1)), R.drawable.mm1k_pn));
//        data.add(new ResultItem(
//                R.drawable.p2, getString(R.string.encontrar_) + 2 + getString(R.string._unidades_en_sistema), Format.numberFourDecimals(mmsk.getPn(2)), R.drawable.mm1k_pn));
//        data.add(new ResultItem(
//                R.drawable.p3, getString(R.string.encontrar_) + 3 + getString(R.string._unidades_en_sistema), Format.numberFourDecimals(mmsk.getPn(3)), R.drawable.mm1k_pn));
//        data.add(new ResultItem(
//                R.drawable.p4, getString(R.string.encontrar_) + 4 + getString(R.string._unidades_en_sistema), Format.numberFourDecimals(mmsk.getPn(4)), R.drawable.mm1k_pn));
//        data.add(new ResultItem(
//                R.drawable.p5, getString(R.string.encontrar_) + 5 + getString(R.string._unidades_en_sistema), Format.numberFourDecimals(mmsk.getPn(5)), R.drawable.mm1k_pn));
//        data.add(new ResultItem(
//                R.drawable.p6, getString(R.string.encontrar_) + 6 + getString(R.string._unidades_en_sistema), Format.numberFourDecimals(mmsk.getPn(6)), R.drawable.mm1k_pn));
//        data.add(new ResultItem(
//                R.drawable.p7, getString(R.string.encontrar_) + 7 + getString(R.string._unidades_en_sistema), Format.numberFourDecimals(mmsk.getPn(7)), R.drawable.mm1k_pn));


        Intent intent = new Intent(getActivity(), ResultsActivity.class);
        intent.putExtra("model", QueuingTheory.MODEL_MMSK);
        intent.putParcelableArrayListExtra("data", data);
        startActivity(intent);
    }
}
