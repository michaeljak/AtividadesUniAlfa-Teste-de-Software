
import br.com.gilmarioarantes.validacpf.model.ValidaCPF;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author Michael jakcon
 */
public class TesteSoftwhare {
    
    private ValidaCPF validacaoCpf;
    
    public Teste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        validacaoCpf = new ValidaCPF();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testaCPFValido() 
     {
         try
         {
             Boolean resultado = validacaoCpf.isCPF("03932956133");
             Assert.assertTrue(resultado.equals(false));
         } catch (Exception e)
         {
             Assert.fail(e.getMessage());
         }
     }
     
     @Test
     public void testaDigitoInvalido() 
     {
         try
         {
             Boolean resultado = validacaoCpf.isCPF("03932956125");
             Assert.assertTrue(resultado.equals(false));
         } catch (Exception e)
         {
             Assert.fail(e.getMessage());
         }
     }
     
     @Test
     public void testaQuantidadeDigitosMaior()
     {
         try
         {
             Boolean resultado = validacaoCpf.isCPF("0398568954225888888884");
             Assert.assertTrue(resultado.equals(false));
         } catch (Exception e)
         {
             Assert.fail(e.getMessage());
         }
     }

     @Test
    public void testaQuantidadeDigitosMenor()
     {
         try {
             Boolean resultado = validacaoCpf.isCPF("03568");
             Assert.assertTrue(resultado.equals(false));

         }
         catch (Exception e)
         {
             Assert.fail(e.getMassage());
         }
     }
}
