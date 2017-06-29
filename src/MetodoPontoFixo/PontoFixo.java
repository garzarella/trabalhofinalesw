package MetodoPontoFixo;

import Funcoes.Funcoes;

public class PontoFixo {

    public double pontoFixo(double pf, double tolerancia) {

        //onde pf é o Ponto Fixo, de início do algoritmo.
        //Para usar deve-se mudar o sinal da segunda derivada (sinal_f2lxn)

        Funcoes funcoes = new Funcoes();

        int iteracoes = 0;
        double xn = pf;
        double xnmais1 = 0;
        double fxn;

        double erro = Double.NaN;

        do {

            iteracoes++;

            fxn = funcoes.funcaoDeIteracaoExemplo(xn);
            xnmais1 = fxn;

            if (iteracoes > 1) {
                erro = Math.abs((xnmais1 - xn) / 2);
            } else {
                erro = Double.POSITIVE_INFINITY;
            }

            xn = xnmais1;

            System.out.println("\nIteração: " + iteracoes + "\nXn: " + xn + "\nF(Xn): " + fxn + "\nErro: " + erro);

        } while (erro >= tolerancia && iteracoes < 100);

        return xn;

    }

}