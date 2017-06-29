package MetodoNewton;

import Funcoes.Funcoes;

public class Newton {

    public double newton(double a, double b, double tolerancia) {
        //onde A é o início do intervalo e B o final do intervalo a ser avaliado

        if (a == b) {
            throw new IllegalArgumentException("\nArgumento de Intervalo Incorreto:"
                    + "\nA não pode ser igual a B"
                    + "\nIntervalo não pode ser nulo!");
        }

        Funcoes funcao = new Funcoes();

        int iteracoes = 0;
        double xn = 0;
        double xnmais1 = 0;
        double fxn;
        double fa;
        double fb;
        double c = 0;

        double erro = Double.NaN;

        fa = funcao.funcaoExemploNewton(a);
        fb = funcao.funcaoExemploNewton(b);

        if (fa * funcao.derivadaSegundaExemploNewton(a) > 0) {
            c = a;
        } else if (fb * funcao.derivadaSegundaExemploNewton(b) > 0) {
            c = b;
        } else {
            System.out.println("Erro ao estabelecer C");
        }

        xn = c;

        do {

            iteracoes++;

            if (iteracoes > 1) {
                erro = Math.abs((xnmais1) - (xn));
                xn = xnmais1;
            } else {
                erro = Double.POSITIVE_INFINITY;
            }

            xnmais1
                    = xn - (funcao.funcaoExemploNewton(xn) / funcao.derivadaPrimeiraExemploNewton(xn));

            fxn = funcao.funcaoExemploNewton(xn);

            System.out.println("\nIteração: " + iteracoes + "\nXn: " + xn + "\nF(Xn): " + fxn + "\nErro: " + erro);

        } while (erro >= tolerancia && iteracoes < 100);

        return xn;

    }

}
