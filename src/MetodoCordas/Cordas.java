package MetodoCordas;

import Funcoes.Funcoes;

public class Cordas {

    public double cordas(double a, double b, double tolerancia) {
        //onde A é o início do intervalo e B o final do intervalo a ser avaliado

        //Para usar deve-se mudar o sinal da segunda derivada (sinal_f2lxn)
        
        if (a == b) {
            throw new IllegalArgumentException("\nArgumento de Intervalo Incorreto:"
                    + "\nA não pode ser igual a B"
                    + "\nIntervalo não pode ser nulo!");
        }

        Funcoes funcoes = new Funcoes();

        int iteracoes = 0;
        double xn = 0;
        double xnmais1 = 0;
        double fxn;
        double fa;
        double fb;
        double c = 0;

        double sinal_f2lxn = 1;

        double erro = Double.NaN;

        fa = funcoes.funcaoL2Q1(a);
        fb = funcoes.funcaoL2Q1(b);

        if (sinal_f2lxn > 0) {
            if (fa < 0 && fb > 0) {
                c = b;
                xn = a;
            } else if (fa > 0 && fb < 0) {
                c = a;
                xn = b;
            } else {
                System.out.println("\nErro.");
            }
        } else if (fa < 0 && fb > 0) {
            c = a;
            xn = b;
        } else if (fa > 0 && fb < 0) {
            c = b;
            xn = a;
        } else {
            System.out.println("\nErro.");
        }

        do {

            iteracoes++;

            if (iteracoes > 1) {
                erro = Math.abs((xnmais1) - (xn));
                xn = xnmais1;
            } else {
                erro = Double.POSITIVE_INFINITY;
            }

            xnmais1
                    = xn - (funcoes.funcaoL2Q1(xn) * (xn - c))
                    / (funcoes.funcaoL2Q1(xn) - funcoes.funcaoL2Q1(c));

            fxn = funcoes.funcaoL2Q1(xn);

            System.out.println("\nIteração: " + iteracoes + "\nXn: " + xn + "\nF(Xn): " + fxn + "\nErro: " + erro);

        } while (erro >= tolerancia && iteracoes < 100);

        return xn;

    }

}
