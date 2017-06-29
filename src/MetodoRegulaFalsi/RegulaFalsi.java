package MetodoRegulaFalsi;

import Funcoes.Funcoes;

public class RegulaFalsi {

    public double regulaFalsi(double a, double b, double tolerancia) {
        //onde A é o início do intervalo e B o final do intervalo a ser avaliado

        if (a == b) {
            throw new IllegalArgumentException("\nArgumento de Intervalo Incorreto:"
                    + "\nA não pode ser igual a B"
                    + "\nIntervalo não pode ser nulo!");
        }

        Funcoes funcao = new Funcoes();

        int iteracoes = 0;
        double xn = 0;
        double xnmenos1 = 0;
        double fxn;
        double fa;
        double fb;
        double erro = Double.NaN;

        do {

            iteracoes++;

            if (iteracoes > 1) {
                xnmenos1 = xn;
            }

            fa = funcao.funcaoL2Q1(a);
            fb = funcao.funcaoL2Q1(b);

            xn
                    = (a * fb - b * fa)
                    / (fb - fa);

            fxn = funcao.funcaoL2Q1(xn);

            if (iteracoes > 1) {
                erro = Math.abs((xn) - (xnmenos1));
            } else {
                erro = Double.POSITIVE_INFINITY;
            }

            System.out.println("\nIteração: " + iteracoes + "\nA: " + a + "\nB: " + b + "\nXn: " + xn + "\nF(Xn): " + fxn + "\nErro: " + erro);

            if (fxn * fa > 0) {
                a = xn;
            } else {
                b = xn;
            }

        } while (erro >= tolerancia);

        return xn;

    }

}
