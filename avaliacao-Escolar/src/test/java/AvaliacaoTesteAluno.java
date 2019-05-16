/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.gilmar.Avaliacao;
import br.com.gilmar.ValoresInvalidosException;
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
public class AvaliacaoTesteAluno {
    
    private Avaliacao avaliacao;
    
    public AvaliacaoTesteAluno() {
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
        avaliacao = new Avaliacao();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    //CT01
//    @Test
//    public void testarQuantidadeParametrosMenorQuatro()
//    {
//        String resultado = avaliacao.avalia(7.0, 6.0, 5);
//    }
//
//    //CT02
//    @Test
//    public void testarQuantidadeParametrosMaiorQuatro()
//    {
//        String resultado = avaliacao.avalia(7.0, 6.0, 5,96,48);
//    }

    //CT03
    @Test
    public void testarNota1MenorZero()
    {
        try 
        {
            String resultado = avaliacao.avalia(-7.0, 6.0, 5, 96);
        }
        catch (Exception e)
        {
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }
    
    //CT04
    @Test
    public void testaNota1MaiorDez()
    {
        try
        {
            String resultado = avaliacao.avalia(11.0, 6.0, 5, 96);
        }
        catch (Exception e)
        {
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }
    
    //CT05
    @Test
    public void testaNota2MenorZero()
    {
        try
        {
            String resultado = avaliacao.avalia(8.0, -1.0, 5, 96);
        }
        catch (Exception e)
        {
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }
    
    //CT06
    @Test
    public void testaNota2MaiorDez()
    {
        try
        {
            String resultado = avaliacao.avalia(8.0, 11.0, 5, 96);
        }
        catch (Exception e)
        {
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }
    
     //CT07
    @Test
    public void testaCargaHorariaMenorZero()
    {
        try
        {
            String resultado = avaliacao.avalia(8.0, 7.0, -3, 96);
        }
        catch (Exception e)
        {
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }
    
    //CT08
    @Test
    public void testaCargaHorariaMaiorNoventaSeis()
    {
        try
        {
            String resultado = avaliacao.avalia(8.0, 7.0, 97, 96);
        }
        catch (Exception e)
        {
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }
    
     //CT09
    @Test
    public void testaQuantidadeFaltasMenorZero()
    {
        try
        {
            String resultado = avaliacao.avalia(8.0, 7.0, 16, -1);
        }
        catch (Exception e)
        {
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }
    
    //CT010
    @Test
    public void testaQuantidadeFaltasMaiorNoventaSeis()
    {
        try
        {
            String resultado = avaliacao.avalia(8.0, 7.0, 16, 97);
        }
        catch (Exception e)
        {
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }
    
    //CT011
    @Test
    public void testaReprovadoPorFalta()
    {
        try
        {
            String resultado = avaliacao.avalia(8.0, 7.0, 28, 96);
            Assert.assertTrue(resultado.equals("Reprovado por Falta."));
        }
        catch (Exception e)
        {
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }
    
    //CT012
    @Test
    public void testaReprovadoPorMedia()
    {
        try
        {
            String resultado = avaliacao.avalia(2.0, 3.0, 15, 96);
            Assert.assertTrue(resultado.equals("Reprovado por Média."));
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }
    
    //CT013
    @Test
    public void testaSegundaChamada()
    {
        try
        {
            String resultado = avaliacao.avalia(4.0, 5.0, 15, 96);
            Assert.assertTrue(resultado.equals("Prova Extra."));
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }
    
    //CT014
    @Test
    public void testaAprovado()
    {
        try
        {
            String resultado = avaliacao.avalia(7.0, 8.0, 15, 97);
            Assert.assertTrue(resultado.equals("Aprovado."));
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }
    //CT015
    @Test
    public void testeNotasInvalidas ()
    {
        try
        {
            String resultado = avaliacao.avalia(-0.0, -8.0, 715, 8797);
            Assert.assertTrue(resultado.equals("Aprovado."));
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

}
