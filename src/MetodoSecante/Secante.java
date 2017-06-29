package MetodoSecante;

import Funcoes.Funcoes;

public class Secante {

    public double secante(double a, double b, double tolerancia) {
        //onde A é o início do intervalo e B o final do intervalo a ser avaliado

        if (a == b) {
            throw new IllegalArgumentException("\nArgumento de Intervalo Incorreto:"
                    + "\nA não pode ser igual a B"
                    + "\nIntervalo não pode ser nulo!");
        }

        Funcoes funcao = new Funcoes();

        int n_iteracoes = -1;
        double xnmenos1;
        double xn = 0;
        double xnmais1 = 0;
        double fxn = 0;
        double fxnmenos1;

        double erro = Double.POSITIVE_INFINITY;

        do {

            if (n_iteracoes == -1) {

                xn = a;
                fxn = funcao.funcaoIitm(xn);
                xnmais1 = b;

            } else if (n_iteracoes >= 0) {

                xnmenos1 = xn;
                xn = xnmais1;
                fxn = funcao.funcaoIitm(xn);
                fxnmenos1 = funcao.funcaoIitm(xnmenos1);
                xnmais1 = xn - ((fxn * (xn - xnmenos1)) / (fxn - fxnmenos1));

                erro = Math.abs(xn - xnmenos1);

            }

            System.out.println("\nIteração: " + n_iteracoes + "\nXn: " + xn + "\nF(Xn): " + fxn + "\nErro: " + erro);

            n_iteracoes++;

        } while (erro >= tolerancia && n_iteracoes < 100);

        return xn;

    }

}
