package com.danyalvarez.operationsresearch.queuingtheory.models.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.danyalvarez.operationsresearch.R;
import com.danyalvarez.operationsresearch.ResultsActivity;
import com.danyalvarez.operationsresearch.classes.ResultItem;
import com.danyalvarez.operationsresearch.queuingtheory.Model;
import com.danyalvarez.operationsresearch.queuingtheory.Result;
import com.danyalvarez.operationsresearch.queuingtheory.models.MM1KModel;
import com.danyalvarez.operationsresearch.util.Format;
import com.danyalvarez.operationsresearch.util.Util;

import java.util.ArrayList;

public class MM1KFragment extends Fragment {

    private EditText mTasaLlegadasEditText;
    private EditText mTasaServicioEditText;
    private EditText mLimiteSistemaEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_queuingtheory_mm1k, container, false);

        mTasaLlegadasEditText = (EditText) view.findViewById(R.id.tasaLlegadasEditText);
        mTasaServicioEditText = (EditText) view.findViewById(R.id.tasaServicioEditText);
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
        String limiteSistemaStr = mLimiteSistemaEditText.getText().toString().trim();

        if (tasaLlegadasStr.length() == 0 || tasaServicioStr.length() == 0 || limiteSistemaStr.length() == 0) {
            mTasaLlegadasEditText.setError(getString(R.string.requested));
            mTasaServicioEditText.setError(getString(R.string.requested));
            mLimiteSistemaEditText.setError(getString(R.string.requested));
            return;
        }

        double tasaLlegadas = Double.parseDouble(tasaLlegadasStr);
        double tasaServicio = Double.parseDouble(tasaServicioStr);
        int limiteSistema = Integer.parseInt(limiteSistemaStr);

        MM1KModel mm1k = new MM1KModel(tasaLlegadas, tasaServicio, limiteSistema);
        Result response = mm1k.calculate();
        if (response != Result.SUCCESSFUL_CALCULATION) {
            if (response == Result.ERROR_LIMIT_SYSTEM) {
                Util.showErrorMessage(getActivity(), R.string.error_limit_system);
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
        data.add(new ResultItem(R.drawable.k, getString(R.string.limite_del_sistema), Format.number(limiteSistema, 0)));
        data.add(new ResultItem(R.drawable.lamdax, getString(R.string.tasa_media_filtraje), Format.number(mm1k.getLamdax(), 0)));


        data.add(new ResultItem(getString(R.string.numero_esperado_unidades),
                R.drawable.l, getString(R.string.en_sistema), Format.number(mm1k.getL(), decimalNumber), R.drawable.mm1k_l));
        data.add(new ResultItem(
                R.drawable.lq, getString(R.string.en_cola), Format.number(mm1k.getLq(), decimalNumber), R.drawable.mm1k_lq));

        data.add(new ResultItem(getString(R.string.tiempo_medio_espera),
                R.drawable.w, getString(R.string.en_sistema), Format.number(mm1k.getW(), decimalNumber), R.drawable.mm1k_w));
        data.add(new ResultItem(
                R.drawable.wq, getString(R.string.en_cola), Format.number(mm1k.getWq(), decimalNumber), R.drawable.mm1k_wq));


        data.add(new ResultItem(getString(R.string.probabilidades),
                R.drawable.rho, getString(R.string.encontrar_sistema_ocupado), Format.number(mm1k.getRho(), probabilitiesDecimalNumber), R.drawable.mm1k_rho));
        data.add(new ResultItem(
                R.drawable.p0, getString(R.string.sistema_vacio_oscioso), Format.number(mm1k.getPn(0), probabilitiesDecimalNumber), R.drawable.mm1k_pn));
        data.add(new ResultItem(
                R.drawable.p1, getString(R.string.encontrar_) + 1 + getString(R.string._unidad_en_sistema), Format.number(mm1k.getPn(1), probabilitiesDecimalNumber), R.drawable.mm1k_pn));
        data.add(new ResultItem(
                R.drawable.p2, getString(R.string.encontrar_) + 2 + getString(R.string._unidades_en_sistema), Format.number(mm1k.getPn(2), probabilitiesDecimalNumber), R.drawable.mm1k_pn));
        data.add(new ResultItem(
                R.drawable.p3, getString(R.string.encontrar_) + 3 + getString(R.string._unidades_en_sistema), Format.number(mm1k.getPn(3), probabilitiesDecimalNumber), R.drawable.mm1k_pn));
        data.add(new ResultItem(
                R.drawable.p4, getString(R.string.encontrar_) + 4 + getString(R.string._unidades_en_sistema), Format.number(mm1k.getPn(4), probabilitiesDecimalNumber), R.drawable.mm1k_pn));
        data.add(new ResultItem(
                R.drawable.p5, getString(R.string.encontrar_) + 5 + getString(R.string._unidades_en_sistema), Format.number(mm1k.getPn(5), probabilitiesDecimalNumber), R.drawable.mm1k_pn));
        data.add(new ResultItem(
                R.drawable.p6, getString(R.string.encontrar_) + 6 + getString(R.string._unidades_en_sistema), Format.number(mm1k.getPn(6), probabilitiesDecimalNumber), R.drawable.mm1k_pn));
        data.add(new ResultItem(
                R.drawable.p7, getString(R.string.encontrar_) + 7 + getString(R.string._unidades_en_sistema), Format.number(mm1k.getPn(7), probabilitiesDecimalNumber), R.drawable.mm1k_pn));


        Intent intent = new Intent(getActivity(), ResultsActivity.class);
        intent.putExtra("model", Model.MM1K.ordinal());
        intent.putParcelableArrayListExtra("data", data);
        startActivity(intent);
    }


}
