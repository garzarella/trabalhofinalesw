package Funcoes;

public class Funcoes {

    public double funcaoL2Q1(double x) {

        double euler = Math.E;

        double fx = (Math.pow(euler, -(x * x))) - Math.cos(x);

        return fx;

    }

    public double funcaoExemplo(double x) {

        double fx;
        double euler = Math.E;

        return fx = Math.pow(euler, x) - Math.sin(x) - 2;

    }
    
    public double funcaoIitm(double x) {
        
        double fx;

        return fx = (3 * x) + Math.sin(x) - Math.exp(x);
        
    }
    
    public double funcaoExemploNewton(double x) {

        double fx;

        return fx = (2 * Math.pow(x, 3)) + Math.log(x) - 5;

    }
    
    public double derivadaPrimeiraExemploNewton(double x) {

        double fx;

        return fx = 6 * (x * x) + (1 / x);

    }

    public double derivadaSegundaExemploNewton(double x) {
        
        double fx;

        return fx = 12 * x - (1 / (x * x));
    }
    
    public double funcaoDeIteracaoExemplo(double x) {

        double fx;

        return fx = Math.sqrt((6 - x));

    }

}
