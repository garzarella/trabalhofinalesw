/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodoBisseccao;

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
public class BisseccaoTest {

    private static Bisseccao bisseccao = new Bisseccao();

    public BisseccaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("\n===================================="
                + "\nIniciando Testes do Método Bissecção"
                + "\n====================================");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("\n====================================="
                + "\nEncerrando Testes do Método Bissecção"
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
    public void testBisseccaoIntervaloNulo() {
        bisseccao.bisseccao(1, 1, 0.005);
    }

    @org.junit.Test
    public void testBisseccaoFalso() {
        assertNotEquals(2.4309, bisseccao.bisseccao(1, 2, 0.01), 0.01);

    }

    @org.junit.Test
    public void testBisseccaoVerdadeiro() {
        assertEquals(1.445312, bisseccao.bisseccao(1, 2, 0.01), 0.000001);
    }

    /*
    Testando valores corretos porém com valor de tolerância mais baixo (exigente demais)
     */
    @Test
    public void testBisseccaoToleranciaBaixa() {
        /*
    A expressão abaixo deve ser diferente do valor obtido no testVerdadeiro devido a tolerância 
        menor do double (uma vez que mais valores após o final do expected são encontradas 
        no software)
         */
        assertNotEquals(1.445312, bisseccao.bisseccao(1, 2, 0.01), 0.0000001);

    }

    /*
    Testando saída do programa caso aconteçam muitas iterações
     */
    @Test(timeout = 1000)
    public void testBisseccaoSaida() {
        assertEquals(1.4453125, bisseccao.bisseccao(1, 2, 0.00000000000000000000000001), 0.01);
    }

}
