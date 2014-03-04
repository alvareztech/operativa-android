package com.danyalvarez.operationsresearch.queuingtheory.models;

import com.danyalvarez.operationsresearch.util.C;

/**
 * Created by daniel on 03/03/14.
 */
public class MMSCModel {

    private double lamda;
    private double mu;
    private int S;
    private int m;

    private double rho;

    private double L;
    private double Lq;

    private double W;
    private double Wq;

    private double[] Pn;


    public MMSCModel(double tasaLlegadas, double tasaServicio, int canalesServicio, int tamanoPoblacion) {
        this.lamda = tasaLlegadas;
        this.mu = tasaServicio;
        this.S = canalesServicio;
        this.m = tamanoPoblacion;
        this.Pn = new double[8];
    }

    public void calculate() {
        rho = lamda / (mu * S);

        Pn[0] = P0();

//        L = m - mu / lamda * (1.0D - Pn[0]);
//        Lq = m - ((lamda + mu) / lamda) * (1.0D - Pn[0]);
//
//        W = L / (lamda * (m - L));
//        Wq = Lq / (mu * (1.0D - Pn[0]));

        for (int i = 1; i < Pn.length; i++) {
            Pn[i] = Pn(i);
        }
    }

    public double P0() {
        double d = 0.0D;
        for (int i = 0; i <= S - 1; i++) {
            d += C.fact[m] / (C.fact[(m - i)] * C.fact[i]) * Math.pow(lamda / mu, i);
        }
        for (int j = S; j <= m; j++) {
            d += C.fact[m] / (C.fact[(m - j)] * C.fact[j]) * (Math.pow(lamda / mu, j) / (C.fact[S] * Math.pow(S, j - S)));
        }
        return 1.0D / d;
    }

    public double Pn(int n) {
        double d;
        if ((n > 0) && (n < S)) {
            d = Pn[0] * (C.fact[m] / (C.fact[(m - n)] * C.fact[n]) * Math.pow(lamda / mu, n));
            return d;
        } else if ((n >= S) && (n <= m)) {
            d = Pn[0] * (C.fact[m] / (C.fact[(m - n)] * C.fact[S] * Math.pow(S, n - S)) * Math.pow(lamda / mu, n));
            return d;
        }
        return 0;
    }

    public double getLamda() {
        return lamda;
    }

    public void setLamda(double lamda) {
        this.lamda = lamda;
    }

    public double getMu() {
        return mu;
    }

    public void setMu(double mu) {
        this.mu = mu;
    }

    public double getRho() {
        return rho;
    }

    public void setRho(double rho) {
        this.rho = rho;
    }

    public double getL() {
        return L;
    }

    public void setL(double l) {
        L = l;
    }

    public double getLq() {
        return Lq;
    }

    public void setLq(double lq) {
        Lq = lq;
    }

    public double getW() {
        return W;
    }

    public void setW(double w) {
        W = w;
    }

    public double getWq() {
        return Wq;
    }

    public void setWq(double wq) {
        Wq = wq;
    }

    public double getPn(int i) {
        return Pn[i];
    }
}
