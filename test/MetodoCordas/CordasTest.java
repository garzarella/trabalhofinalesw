/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodoCordas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FELIPE
 */
public class CordasTest {

    private static Cordas cordas = new Cordas();

    public CordasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("\n====================================="
                + "\nIniciando Testes do Método das Cordas"
                + "\n=====================================");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("\n======================================"
                + "\nEncerrando Testes do Método das Cordas"
                + "\n======================================");
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
    public void testCordasIntervaloNulo() {
        cordas.cordas(1, 1, 0.005);
    }

    @org.junit.Test
    public void testCordasFalso() {
        assertNotEquals(23, cordas.cordas(3, 7, 0.01), 0.1);

    }

    @org.junit.Test
    public void testCordasVerdadeiro() {
        assertEquals(4.70930917924899, cordas.cordas(3, 7, 0.01), 0.00000000000001);

    }

    @org.junit.Test
    public void testCordasNaN() {
        assertEquals(Double.NaN, cordas.cordas(4, 2, 0.01), 0.001);
    }

    /*
    Testando valores corretos porém com valor de tolerância mais baixo (exigente demais)
     */
    @Test
    public void testCordasToleranciaBaixa() {
        /*
    A expressão abaixo deve ser diferente do valor obtido no testVerdadeiro devido a tolerância 
        menor do double (uma vez que mais valores após o final do expected são encontradas 
        no software)
         */
        assertNotEquals(4.7093091792489, cordas.cordas(3, 7, 0.01), 0.00000000000001);

    }

    /*
    Testando saída do programa caso aconteçam muitas iterações
     */
    @Test(timeout = 1000)
    public void testCordasSaida() {
        cordas.cordas(3, 7, 0.00000000000000000000000001);
    }

}
