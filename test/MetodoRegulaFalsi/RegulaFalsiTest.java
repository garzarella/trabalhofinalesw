package MetodoRegulaFalsi;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegulaFalsiTest {

    private static RegulaFalsi regulaFalsi = new RegulaFalsi();

    public RegulaFalsiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("\n==========================================="
                + "\nIniciando Testes do Método da Falsa Posição"
                + "\n===========================================");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("\n============================================"
                + "\nEncerrando Testes do Método da Falsa Posição"
                + "\n============================================");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /*
    Testando intervalo nulo (quando a é igual a b)
     */
    @Test(expected = IllegalArgumentException.class)
    public void testRegulaFalsiIntervaloNulo() {
        regulaFalsi.regulaFalsi(1, 1, 0.005);
        regulaFalsi.regulaFalsi(4, 4, 0.0001);
    }

    @Test
    public void testRegulaFalsiVerdadeiro() {
        assertEquals(1.4473570678, regulaFalsi.regulaFalsi(1, 2, 0.001), 0.0000000001);
    }

    @Test
    public void testRegulaFalsiFalso() {
        //A expressão abaixo deverá retornar um valor expected diferente
        assertNotEquals(2, regulaFalsi.regulaFalsi(1, 2, 0.1), 0.01);
    }

    /*
    Testando valores corretos porém com valor de tolerância mais baixo (exigente demais)
     */
    @Test
    public void testRegulaFalsiToleranciaBaixa() {
        /*
    A expressão abaixo deve ser diferente do valor obtido no testVerdadeiro devido a tolerância 
        menor do double (uma vez que mais valores após o final do expected são encontradas 
        no software)
         */
        assertNotEquals(1.4473570678, regulaFalsi.regulaFalsi(1, 2, 0.001), 0.00000000000001);

    }

    /*
    Testando saída do programa caso aconteçam muitas iterações
     */
    @Test(timeout = 1000)
    public void testRegulaFalsiSaida() {
        regulaFalsi.regulaFalsi(1, 2, 0.0000000000000000000000001);
    }
}
