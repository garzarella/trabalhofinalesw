package MetodoBisseccao;

import Funcoes.Funcoes;

public class Bisseccao {

    public double bisseccao(double a, double b, double tolerancia) {
        //onde A é o início do intervalo e B o final do intervalo a ser avaliado

        if (a == b) {
            throw new IllegalArgumentException("\nArgumento de Intervalo Incorreto:"
                    + "\nA não pode ser igual a B"
                    + "\nIntervalo não pode ser nulo!");
        }

        Funcoes funcoes = new Funcoes();

        int iteracoes = 0;
        double xn;
        double fxn;
        double fa;
        double erro = Math.abs((b - a) / 2);

        do {

            iteracoes++;

            if (iteracoes > 1) {
                erro = Math.abs((b - a) / 2);
            }

            xn = (a + b) / 2;
            fxn = funcoes.funcaoL2Q1(xn);
            fa = funcoes.funcaoL2Q1(a);

            System.out.println("\nIteração: " + iteracoes + "\nA: " + a + "\nB: " + b + "\nXn: " + xn + "\nF(Xn): " + fxn + "\nErro: " + erro);

            if (fxn * fa > 0) {
                a = xn;
            } else {
                b = xn;
            }

        } while (erro >= tolerancia && iteracoes < 100);

        return xn;

    }

}
