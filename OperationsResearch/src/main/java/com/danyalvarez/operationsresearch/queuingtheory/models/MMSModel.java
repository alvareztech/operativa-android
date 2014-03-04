package com.danyalvarez.operationsresearch.queuingtheory.models;

import com.danyalvarez.operationsresearch.util.C;

/**
 * Created by daniel on 03/03/14.
 */
public class MMSModel {

    private double lamda;
    private double mu;
    private int S;

    private double rho;

    private double LO;
    private double LD;
    private double L;
    private double Lq;

    private double W;
    private double Wq;

    private double[] Pn;


    public MMSModel(double tasaLlegadas, double tasaServicio, int tamanoPoblacion) {
        this.lamda = tasaLlegadas;
        this.mu = tasaServicio;
        this.S = tamanoPoblacion;
        this.Pn = new double[8];
    }

    public void calculate() {
        rho = lamda / (mu * S);

        LO = S * rho;
        LD = S - LO;

        Pn[0] = P0();
        for (int i = 1; i < Pn.length; i++) {
            Pn[i] = Pn(i);
        }

        Lq = rho * (Pn[0] * Math.pow(lamda / mu, S)) / (C.fact[S] * (1.0D - rho) * (1.0D - rho));

        L = Lq + LO;

        W = L / lamda;
        Wq = Lq / lamda;


    }

    public double P0() {
        double d = Math.pow(lamda / mu, S) / (C.fact[S] * (1.0D - rho));
        for (int i = 0; i <= S - 1; i++) {
            d += Math.pow(rho * S, i) / C.fact[i];
        }
        return 1.0D / d;
    }

    public double Pn(int i) {
        double d = 0;
        if ((i > 0) && (i < S)) {
            d = Pn[0] * Math.pow(lamda / mu, i) / C.fact[i];
        } else if (i >= S){
            d = Pn[0] * Math.pow(lamda / mu, i) / (C.fact[S] * Math.pow(S, i - S));
        }
        return d;
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

    public int getS() {
        return S;
    }

    public void setS(int s) {
        S = s;
    }

    public double getLO() {
        return LO;
    }

    public void setLO(double LO) {
        this.LO = LO;
    }

    public double getLD() {
        return LD;
    }

    public void setLD(double LD) {
        this.LD = LD;
    }
}
