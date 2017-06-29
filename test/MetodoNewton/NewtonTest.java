/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodoNewton;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Passig
 */
public class NewtonTest {

    private static Newton newton = new Newton();

    public NewtonTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("\n===================================="
                + "\nIniciando Testes do Método de Newton"
                + "\n====================================");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("\n====================================="
                + "\nEncerrando Testes do Método de Newton"
                + "\n=====================================");
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
    public void testNewtonIntervaloNulo() {
        newton.newton(1, 1, 0.005);
    }

    @org.junit.Test
    public void testNewtonFalso() {
        assertNotEquals(10, newton.newton(1, 2, 0.0000001), 0.1);

    }

    @org.junit.Test
    public void testNewtonVerdadeiro() {
        assertEquals(1.3308395421, newton.newton(1, 2, 0.0000001), 0.0000000001);

    }

    @org.junit.Test
    public void testNewtonNaN() {
        assertEquals(Double.NaN, newton.newton(1, 1.1, 0.0000001), 0.01);
    }

    /*
    Testando valores corretos porém com valor de tolerância mais baixo (exigente demais)
     */
    @Test
    public void testNewtonToleranciaBaixa() {
        /*
    A expressão abaixo deve ser diferente do valor obtido no testVerdadeiro devido a tolerância 
        menor do double (uma vez que mais valores após o final do expected são encontradas 
        no software)
         */
        assertNotEquals(1.330839542, newton.newton(1, 2, 0.0000001), 0.00000000001);

    }

    /*
    Testando saída do programa caso aconteçam muitas iterações
     */
    @Test(timeout = 1000)
    public void testNewtonSaida() {
        newton.newton(1, 2, 0.00000000000000000000000001);
    }

}
