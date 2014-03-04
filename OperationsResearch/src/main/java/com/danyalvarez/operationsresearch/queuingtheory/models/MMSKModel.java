package com.danyalvarez.operationsresearch.queuingtheory.models;

import com.danyalvarez.operationsresearch.util.C;

/**
 * Created by daniel on 03/03/14.
 */
public class MMSKModel {

    private double lamda;
    private double mu;
    private int S;
    private int K;

    private double rho;

    private double L;
    private double Lq;

    private double W;
    private double Wq;

    private double[] Pn;

    private double lamdax;

    public MMSKModel(double tasaLlegadas, double tasaServicio, int canalesServicio, int limiteSistema) {
        this.lamda = tasaLlegadas;
        this.mu = tasaServicio;
        this.S = canalesServicio;
        this.K = limiteSistema;
        this.Pn = new double[8];
    }

    public void calculate() {
        rho = lamda / (mu * S);

        Pn[0] = P0();

//        for (int i = 0; i < Pn.length; i++) {
//            Pn[i] = Pn(i);
//        }
//
//        L = L();
//        Lq = L - (1 - Pn[0]);
//
//        lamdax = lamda * (1.0D - Pn[K]);
//
//        W = L / lamdax;
//        Wq = W - 1.0D / mu;
    }

    public double P0() {
        double d;
        if ((int) rho != 1) {
            d = Math.pow(S, S) * Math.pow(rho, S + 1) * (1.0D - Math.pow(rho, K - S)) / (C.fact[S] * (1.0D - rho));
            for (int j = 0; j <= S; j++) {
                d += Math.pow(rho * S, j) / C.fact[j];
            }
        } else {
            d = Math.pow(S, S) * (K - S) / C.fact[S];
            for (int i = 0; i <= S; i++) {
                d += Math.pow(S, i) / C.fact[i];
            }
        }
        return 1.0D / d;
    }

    public double Pn(int n) {
        double d;
        if ((int) rho != 1) {
            d = Math.pow(rho, n) * (1.0D - rho) / (1.0D - Math.pow(rho, K + 1));
            return d;
        } else {
            return 1 / (K + 1);
        }
    }

    public double L() {
        double d;
        if ((int) rho != 1) {
            d = rho / (1.0D - rho) - (K + 1) * Math.pow(rho, K + 1) / (1.0D - Math.pow(rho, K + 1));
            return d;
        } else {
            return K / 2;
        }
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

    public double getLamdax() {
        return lamdax;
    }

    public void setLamdax(double lamdax) {
        this.lamdax = lamdax;
    }
}
