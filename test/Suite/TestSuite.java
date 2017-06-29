package Suite;

import MetodoBisseccao.BisseccaoTest;
import MetodoCordas.CordasTest;
import MetodoNewton.NewtonTest;
import MetodoPontoFixo.PontoFixoTest;
import MetodoRegulaFalsi.RegulaFalsiTest;
import MetodoSecante.SecanteTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Passig
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({BisseccaoTest.class, CordasTest.class, NewtonTest.class, PontoFixoTest.class, RegulaFalsiTest.class, SecanteTest.class})
public class TestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("\n========================="
                + "\nIniciando Suite de Testes"
                + "\n=========================");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("\n=========================="
                + "\nEncerrando Suite de Testes"
                + "\n==========================");
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}