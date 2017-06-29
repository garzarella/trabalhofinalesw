package MetodoSecante;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aluno
 */
public class SecanteTest {

    private static Secante secante = new Secante();

    public SecanteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("\n=================================="
                + "\nIniciando Testes do Método Secante"
                + "\n==================================");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("\n==================================="
                + "\nEncerrando Testes do Método Secante"
                + "\n===================================");
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
    public void testSecanteIntervaloNulo() {
        secante.secante(1, 1, 0.01);
        secante.secante(0, 0, 0.1);
    }

    @Test
    public void testSecanteVerdadeiro() {
        assertEquals(0.3604217029, secante.secante(0, 1, 0.00001), 0.0000000001);
    }

    @Test
    public void testSecanteFalso() {
        assertNotEquals(1, secante.secante(0, 1, 0.00001), 0.1);
    }

    /*
    Testando valores corretos porém com valor de tolerância mais baixo (exigente demais)
     */
    @Test
    public void testSecanteToleranciaBaixa() {
        /*
    A expressão abaixo deve ser diferente do valor obtido no testVerdadeiro devido a tolerância 
        menor do double (uma vez que mais valores após o final do expected são encontradas 
        no software)
         */
        assertNotEquals(0.3604217029, secante.secante(0, 1, 0.00001), 0.00000000001);
    }

    /*
    Testando saída do programa caso aconteçam muitas iterações
     */
    @Test(timeout = 1000)
    public void testRegulaFalsiSaida() {
        secante.secante(0, 1, 0.0000000000000000000000001);
    }

}
