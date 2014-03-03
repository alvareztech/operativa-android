package com.danyalvarez.operationsresearch.queuingtheory.models;

/**
 * Created by daniel on 03/03/14.
 */
public class MM1Model {

    private double lamda; // lamda
    private double mu; // mu

    private double rho;

    private double L;
    private double Lq;

    private double W;
    private double Wq;

    private double[] Pn;


    public MM1Model(double tasaLlegadas, double tasaServicio) {
        this.lamda = tasaLlegadas;
        this.mu = tasaServicio;
        this.Pn = new double[8];
    }

    public void calculate() {
        rho = lamda / mu;

        L = rho / (1.0 - rho);
        Lq = rho * rho / (1 - rho);

        W = 1.0 / (mu - lamda);
        Wq = rho / (mu - lamda);

        for (int i = 0; i < Pn.length; i++) {
            Pn[i] = Pn(rho, i);
        }
    }

    public double Pn(double rho, int n) {
        if (n == 0) {
            return 1.0 - rho;
        } else if (n == 1) {
            return rho * (1.0 - rho);
        } else {
            return Math.pow(rho, n) * (1.0 - rho);
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
}
