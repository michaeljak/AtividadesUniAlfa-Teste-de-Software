package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.util.FormataData;
import br.com.gilmarioarantes.jdbccrudv1.util.GeraData;
import br.com.gilmarioarantes.jdbccrudv1.util.GeraListaAlunos;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class PersisteAlunoTeste {

    Logger logger = Logger.getLogger(PersisteAlunoTeste.class.getName());

    @Test
    public void persisteAlunoTest(){

        logger.info("Executando o metodo persisteAlunoTest() da classe: " + this.getClass().getSimpleName());

        List<Aluno> alunos = GeraListaAlunos.geraLista();

        boolean result = false;

        try{
            for(Aluno aluno : alunos){
                result = new PersisteAluno().persisteAluno(aluno);
            }
        }catch (Exception e){
            result = false;
            logger.error("Erro ao persistir o Aluno!", e);
        }
        Assert.assertTrue(result);
    }
    
    @Test
    public void persisteAlunoAlfaTest() {
    	
    	logger.info("Executando o metodo persisteAlunoAlfaTest() da classe: " + this.getClass().getSimpleName());
    	
    	// Novo aluno Michael
    	Aluno alunoAlfa1 = new Aluno((long) 1,"954875","Michael Jakson Fonsesa","M",new Timestamp(Calendar.getInstance().getTime().getTime()));    	
    	
    	// Novo aluno Roclesia
    	Aluno alunoAlfa2 = new Aluno((long) 2,"5874587","Roclesia Santos Fonseca","F",new Timestamp(Calendar.getInstance().getTime().getTime()));

    	// Lista de alunos
        List<Aluno> alunos = new ArrayList<>();
        
        // Aciniona os alunos na lista de alunos
        alunos.add(alunoAlfa1);
        alunos.add(alunoAlfa2);

        boolean result = false;

        // Roda a lista de alunos, persistindo-os
        try{
            for(Aluno aluno : alunos){
                result = new PersisteAluno().persisteAluno(aluno);
            }
        }catch (Exception e){
            result = false;
            logger.error("Erro ao persistir o Aluno!", e);
        }
        Assert.assertTrue(result);
    	
    }

}
