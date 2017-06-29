/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodoPontoFixo;

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
public class PontoFixoTest {

    private static PontoFixo pontofixo = new PontoFixo();

    public PontoFixoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("\n========================================"
                + "\nIniciando Testes do Método do Ponto Fixo"
                + "\n========================================");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("\n========================================="
                + "\nEncerrando Testes do Método do Ponto Fixo"
                + "\n=========================================");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testPontoFixoFalso() {
        assertNotEquals(3, pontofixo.pontoFixo(3, 0.01), 0.1);

    }

    @org.junit.Test
    public void testPontoFixoVerdadeiro() {
        assertEquals(1.998966811894708, pontofixo.pontoFixo(3, 0.01), 0.000000000000001);
    }

    /*
    Testando valores corretos porém com valor de tolerância mais baixo (exigente demais)
     */
    @Test
    public void testPontoFixoToleranciaBaixa() {
        /*
    A expressão abaixo deve ser diferente do valor obtido no testVerdadeiro devido a tolerância 
        menor do double (uma vez que mais valores após o final do expected são encontradas 
        no software)
         */
        assertNotEquals(1.99896681189470, pontofixo.pontoFixo(3, 0.01), 0.000000000000001);

    }

    /*
    Testando saída do programa caso aconteçam muitas iterações
     */
    @Test(timeout = 1000)
    public void testPontoFixoSaida() {
        pontofixo.pontoFixo(3, 0.00000000000000000000000001);
    }

}
