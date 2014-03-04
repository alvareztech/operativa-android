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
import com.danyalvarez.operationsresearch.queuingtheory.models.MM1CModel;
import com.danyalvarez.operationsresearch.queuingtheory.models.MMSCModel;
import com.danyalvarez.operationsresearch.util.Format;

import java.util.ArrayList;

/**
 * Created by daniel on 21/02/14.
 */
public class MMSCFragment extends Fragment {

    private Context mContext;

    private EditText mTasaLlegadasEditText;
    private EditText mTasaServicioEditText;
    private EditText mCanalesServicioEditText;
    private EditText mTamanoPoblacionEditText;

    public MMSCFragment(Context context) {
        this.mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_queuingtheory_mmsc, container, false);
        mTasaLlegadasEditText = (EditText) view.findViewById(R.id.tasaLlegadasEditText);
        mTasaServicioEditText = (EditText) view.findViewById(R.id.tasaServicioEditText);
        mCanalesServicioEditText = (EditText) view.findViewById(R.id.canalesServicioEditText);
        mTamanoPoblacionEditText = (EditText) view.findViewById(R.id.tamanoPoblacionEditText);
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
        String tamanoPoblacionStr = mTamanoPoblacionEditText.getText().toString().trim();

        if (tasaLlegadasStr.length() == 0 || tasaServicioStr.length() == 0 || tamanoPoblacionStr.length() == 0 || canalesServicioStr.length() == 0) {
            mTasaLlegadasEditText.setError(getString(R.string.requested));
            mTasaServicioEditText.setError(getString(R.string.requested));
            mCanalesServicioEditText.setError(getString(R.string.requested));
            mTamanoPoblacionEditText.setError(getString(R.string.requested));
            return;
        }

        double tasaLlegadas = Double.parseDouble(tasaLlegadasStr);
        double tasaServicio = Double.parseDouble(tasaServicioStr);
        int canalesServicio = Integer.parseInt(canalesServicioStr);
        int tamanoPoblacion = Integer.parseInt(tamanoPoblacionStr);

        MMSCModel mmsc = new MMSCModel(tasaLlegadas, tasaServicio, canalesServicio, tamanoPoblacion);
        mmsc.calculate();

        ArrayList<ResultItem> data = new ArrayList<ResultItem>();
        data.add(new ResultItem(R.drawable.lamda, getString(R.string.tasa_de_llegadas), Format.numberTwoDecimals(tasaLlegadas)));
        data.add(new ResultItem(R.drawable.mu, getString(R.string.tasa_de_servicio), Format.numberTwoDecimals(tasaServicio)));
        data.add(new ResultItem(R.drawable.s, getString(R.string.numero_de_canales_de_servicio), Format.numberWithoutDecimals(canalesServicio)));
        data.add(new ResultItem(R.drawable.c, getString(R.string.tamano_de_la_poblacion), Format.numberWithoutDecimals(tamanoPoblacion)));


//        data.add(new ResultItem(getString(R.string.numero_esperado_unidades),
//                R.drawable.l, getString(R.string.en_sistema), Format.numberTwoDecimals(mmsc.getL()), R.drawable.mm1c_l));
//        data.add(new ResultItem(
//                R.drawable.lq, getString(R.string.en_cola), Format.numberTwoDecimals(mmsc.getLq()), R.drawable.mm1c_lq));
//
//        data.add(new ResultItem(getString(R.string.tiempo_medio_espera),
//                R.drawable.w, getString(R.string.en_sistema), Format.numberTwoDecimals(mmsc.getW()), R.drawable.mm1c_w));
//        data.add(new ResultItem(
//                R.drawable.wq, getString(R.string.en_cola), Format.numberTwoDecimals(mmsc.getWq()), R.drawable.mm1c_wq));


        data.add(new ResultItem(getString(R.string.probabilidades),
                R.drawable.rho, getString(R.string.encontrar_sistema_ocupado), Format.numberFourDecimals(mmsc.getRho()), R.drawable.mmsc_rho));
        data.add(new ResultItem(
                R.drawable.p0, getString(R.string.sistema_vacio_oscioso), Format.numberFourDecimals(mmsc.getPn(0)), R.drawable.mmsc_p0));
        data.add(new ResultItem(
                R.drawable.p1, getString(R.string.encontrar_) + 1 + getString(R.string._unidad_en_sistema), Format.numberFourDecimals(mmsc.getPn(1)), R.drawable.mmsc_pn));
        data.add(new ResultItem(
                R.drawable.p2, getString(R.string.encontrar_) + 2 + getString(R.string._unidades_en_sistema), Format.numberFourDecimals(mmsc.getPn(2)), R.drawable.mmsc_pn));
        data.add(new ResultItem(
                R.drawable.p3, getString(R.string.encontrar_) + 3 + getString(R.string._unidades_en_sistema), Format.numberFourDecimals(mmsc.getPn(3)), R.drawable.mmsc_pn));
        data.add(new ResultItem(
                R.drawable.p4, getString(R.string.encontrar_) + 4 + getString(R.string._unidades_en_sistema), Format.numberFourDecimals(mmsc.getPn(4)), R.drawable.mmsc_pn));
        data.add(new ResultItem(
                R.drawable.p5, getString(R.string.encontrar_) + 5 + getString(R.string._unidades_en_sistema), Format.numberFourDecimals(mmsc.getPn(5)), R.drawable.mmsc_pn));
        data.add(new ResultItem(
                R.drawable.p6, getString(R.string.encontrar_) + 6 + getString(R.string._unidades_en_sistema), Format.numberFourDecimals(mmsc.getPn(6)), R.drawable.mmsc_pn));
        data.add(new ResultItem(
                R.drawable.p7, getString(R.string.encontrar_) + 7 + getString(R.string._unidades_en_sistema), Format.numberFourDecimals(mmsc.getPn(7)), R.drawable.mmsc_pn));


        Intent intent = new Intent(getActivity(), ResultsActivity.class);
        intent.putExtra("model", QueuingTheory.MODEL_MMSC);
        intent.putParcelableArrayListExtra("data", data);
        startActivity(intent);
    }

}
