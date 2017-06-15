package com.danyalvarez.operationsresearch.queuingtheory.models.fragments;

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
import com.danyalvarez.operationsresearch.queuingtheory.models.MM1Model;
import com.danyalvarez.operationsresearch.util.Format;

import java.util.ArrayList;

public class MM1Fragment extends Fragment {

    private EditText mTasaLlegadasEditText;
    private EditText mTasaServicioEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_queuingtheory_mm1, container, false);

        mTasaLlegadasEditText = (EditText) view.findViewById(R.id.tasaLlegadasEditText);
        mTasaServicioEditText = (EditText) view.findViewById(R.id.tasaServicioEditText);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public void calculate() {
        String tasaLlegadasStr = mTasaLlegadasEditText.getText().toString().trim();
        String tasaServicioStr = mTasaServicioEditText.getText().toString().trim();

        if (tasaLlegadasStr.length() == 0 || tasaServicioStr.length() == 0) {
            mTasaLlegadasEditText.setError(getString(R.string.requested));
            mTasaServicioEditText.setError(getString(R.string.requested));
            return;
        }

        double tasaLlegadas = Double.parseDouble(tasaLlegadasStr);
        double tasaServicio = Double.parseDouble(tasaServicioStr);

        MM1Model mm1 = new MM1Model(tasaLlegadas, tasaServicio);
        mm1.calculate();

        int decimalNumber = 2;
        int probabilitiesDecimalNumber = 4;

        ArrayList<ResultItem> data = new ArrayList<ResultItem>();
        data.add(new ResultItem(R.drawable.lamda, getString(R.string.tasa_de_llegadas), Format.number(tasaLlegadas, decimalNumber)));
        data.add(new ResultItem(R.drawable.mu, getString(R.string.tasa_de_servicio), Format.number(tasaServicio, decimalNumber)));


        data.add(new ResultItem(getString(R.string.numero_esperado_unidades),
                R.drawable.l, getString(R.string.en_sistema), Format.number(mm1.getL(), decimalNumber), R.drawable.mm1_l));
        data.add(new ResultItem(
                R.drawable.lq, getString(R.string.en_cola), Format.number(mm1.getLq(), decimalNumber), R.drawable.mm1_lq));

        data.add(new ResultItem(getString(R.string.tiempo_medio_espera),
                R.drawable.w, getString(R.string.en_sistema), Format.number(mm1.getW(), decimalNumber), R.drawable.mm1_w));
        data.add(new ResultItem(
                R.drawable.wq, getString(R.string.en_cola), Format.number(mm1.getWq(), decimalNumber), R.drawable.mm1_wq));


        data.add(new ResultItem(getString(R.string.probabilidades),
                R.drawable.rho, getString(R.string.encontrar_sistema_ocupado), Format.number(mm1.getRho(), probabilitiesDecimalNumber), R.drawable.mm1_rho));
        data.add(new ResultItem(
                R.drawable.p0, getString(R.string.sistema_vacio_oscioso), Format.number(mm1.getPn(0), probabilitiesDecimalNumber), R.drawable.mm1_p0));
        data.add(new ResultItem(
                R.drawable.p1, getString(R.string.encontrar_) + 1 + getString(R.string._unidad_en_sistema), Format.number(mm1.getPn(1), probabilitiesDecimalNumber), R.drawable.mm1_pn));
        data.add(new ResultItem(
                R.drawable.p2, getString(R.string.encontrar_) + 2 + getString(R.string._unidades_en_sistema), Format.number(mm1.getPn(2), probabilitiesDecimalNumber), R.drawable.mm1_pn));
        data.add(new ResultItem(
                R.drawable.p3, getString(R.string.encontrar_) + 3 + getString(R.string._unidades_en_sistema), Format.number(mm1.getPn(3), probabilitiesDecimalNumber), R.drawable.mm1_pn));
        data.add(new ResultItem(
                R.drawable.p4, getString(R.string.encontrar_) + 4 + getString(R.string._unidades_en_sistema), Format.number(mm1.getPn(4), probabilitiesDecimalNumber), R.drawable.mm1_pn));
        data.add(new ResultItem(
                R.drawable.p5, getString(R.string.encontrar_) + 5 + getString(R.string._unidades_en_sistema), Format.number(mm1.getPn(5), probabilitiesDecimalNumber), R.drawable.mm1_pn));
        data.add(new ResultItem(
                R.drawable.p6, getString(R.string.encontrar_) + 6 + getString(R.string._unidades_en_sistema), Format.number(mm1.getPn(6), probabilitiesDecimalNumber), R.drawable.mm1_pn));
        data.add(new ResultItem(
                R.drawable.p7, getString(R.string.encontrar_) + 7 + getString(R.string._unidades_en_sistema), Format.number(mm1.getPn(7), probabilitiesDecimalNumber), R.drawable.mm1_pn));


        Intent intent = new Intent(getActivity(), ResultsActivity.class);
        intent.putExtra("model", QueuingTheory.MODEL_MM1);
        intent.putParcelableArrayListExtra("data", data);
        startActivity(intent);
    }
}
