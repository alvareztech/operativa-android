package com.danyalvarez.operationsresearch.queuingtheory.models.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.danyalvarez.operationsresearch.R;
import com.danyalvarez.operationsresearch.ResultsActivity;
import com.danyalvarez.operationsresearch.classes.ResultItem;
import com.danyalvarez.operationsresearch.queuingtheory.QueuingTheory;
import com.danyalvarez.operationsresearch.queuingtheory.models.MMSModel;
import com.danyalvarez.operationsresearch.util.Format;
import com.danyalvarez.operationsresearch.util.Util;

import java.util.ArrayList;

public class MMSFragment extends Fragment {

    private EditText mTasaLlegadasEditText;
    private EditText mTasaServicioEditText;
    private EditText mCanalesServicioEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_queuingtheory_mms, container, false);

        mTasaLlegadasEditText = (EditText) view.findViewById(R.id.tasaLlegadasEditText);
        mTasaServicioEditText = (EditText) view.findViewById(R.id.tasaServicioEditText);
        mCanalesServicioEditText = (EditText) view.findViewById(R.id.canalesServicioEditText);

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

        if (tasaLlegadasStr.length() == 0 || tasaServicioStr.length() == 0 || canalesServicioStr.length() == 0) {
            mTasaLlegadasEditText.setError(getString(R.string.requested));
            mTasaServicioEditText.setError(getString(R.string.requested));
            mCanalesServicioEditText.setError(getString(R.string.requested));
            return;
        }

        double tasaLlegadas = Double.parseDouble(tasaLlegadasStr);
        double tasaServicio = Double.parseDouble(tasaServicioStr);
        int canalesServicio = Integer.parseInt(canalesServicioStr);

        MMSModel mms = new MMSModel(tasaLlegadas, tasaServicio, canalesServicio);
        int response = mms.calculate();
        if (response != QueuingTheory.SUCCESSFUL_CALCULATION) {
            if (response == QueuingTheory.ERROR_SERVICE_CHANNELS) {
                Util.showErrorMessage(getActivity(), R.string.error_service_channels);
            }
            return;
        }

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        int decimalNumber = Integer.parseInt(sharedPrefs.getString(getString(R.string.settings_decimals_key),
                getString(R.string.settings_decimals_default)));
        int probabilitiesDecimalNumber = Integer.parseInt(sharedPrefs.getString(getString(R.string.settings_probabilities_decimals_key),
                getString(R.string.settings_probabilities_decimals_default)));

        ArrayList<ResultItem> data = new ArrayList<ResultItem>();
        data.add(new ResultItem(R.drawable.lamda, getString(R.string.tasa_de_llegadas), Format.number(tasaLlegadas, decimalNumber)));
        data.add(new ResultItem(R.drawable.mu, getString(R.string.tasa_de_servicio), Format.number(tasaServicio, decimalNumber)));
        data.add(new ResultItem(R.drawable.s, getString(R.string.numero_de_canales_de_servicio), Format.number(canalesServicio, 0)));


        data.add(new ResultItem(getString(R.string.numero_esperado_unidades),
                R.drawable.l, getString(R.string.en_sistema), Format.number(mms.getL(), decimalNumber), R.drawable.mms_l));
        data.add(new ResultItem(
                R.drawable.lq, getString(R.string.en_cola), Format.number(mms.getLq(), decimalNumber), R.drawable.mms_lq));
        data.add(new ResultItem(
                R.drawable.lo, getString(R.string.estaciones_ocupadas), Format.number(mms.getLO(), decimalNumber), R.drawable.mms_lo));
        data.add(new ResultItem(
                R.drawable.ld, getString(R.string.estaciones_desocupadas), Format.number(mms.getLD(), decimalNumber), R.drawable.mms_ld));

        data.add(new ResultItem(getString(R.string.tiempo_medio_espera),
                R.drawable.w, getString(R.string.en_sistema), Format.number(mms.getW(), decimalNumber), R.drawable.mms_w));
        data.add(new ResultItem(
                R.drawable.wq, getString(R.string.en_cola), Format.number(mms.getWq(), decimalNumber), R.drawable.mms_wq));


        data.add(new ResultItem(getString(R.string.probabilidades),
                R.drawable.rho, getString(R.string.encontrar_sistema_ocupado), Format.number(mms.getRho(), probabilitiesDecimalNumber), R.drawable.mms_rho));
        data.add(new ResultItem(
                R.drawable.p0, getString(R.string.sistema_vacio_oscioso), Format.number(mms.getPn(0), probabilitiesDecimalNumber), R.drawable.mms_p0));
        data.add(new ResultItem(
                R.drawable.p1, getString(R.string.encontrar_) + 1 + getString(R.string._unidad_en_sistema), Format.number(mms.getPn(1), probabilitiesDecimalNumber), R.drawable.mms_pn));
        data.add(new ResultItem(
                R.drawable.p2, getString(R.string.encontrar_) + 2 + getString(R.string._unidades_en_sistema), Format.number(mms.getPn(2), probabilitiesDecimalNumber), R.drawable.mms_pn));
        data.add(new ResultItem(
                R.drawable.p3, getString(R.string.encontrar_) + 3 + getString(R.string._unidades_en_sistema), Format.number(mms.getPn(3), probabilitiesDecimalNumber), R.drawable.mms_pn));
        data.add(new ResultItem(
                R.drawable.p4, getString(R.string.encontrar_) + 4 + getString(R.string._unidades_en_sistema), Format.number(mms.getPn(4), probabilitiesDecimalNumber), R.drawable.mms_pn));
        data.add(new ResultItem(
                R.drawable.p5, getString(R.string.encontrar_) + 5 + getString(R.string._unidades_en_sistema), Format.number(mms.getPn(5), probabilitiesDecimalNumber), R.drawable.mms_pn));
        data.add(new ResultItem(
                R.drawable.p6, getString(R.string.encontrar_) + 6 + getString(R.string._unidades_en_sistema), Format.number(mms.getPn(6), probabilitiesDecimalNumber), R.drawable.mms_pn));
        data.add(new ResultItem(
                R.drawable.p7, getString(R.string.encontrar_) + 7 + getString(R.string._unidades_en_sistema), Format.number(mms.getPn(7), probabilitiesDecimalNumber), R.drawable.mms_pn));


        Intent intent = new Intent(getActivity(), ResultsActivity.class);
        intent.putExtra("model", QueuingTheory.MODEL_MMS);
        intent.putParcelableArrayListExtra("data", data);
        startActivity(intent);
    }
}
