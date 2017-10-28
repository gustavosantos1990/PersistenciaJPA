/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Pais;
import br.edu.ifsul.modelo.PessoaFisica;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Gustavo
 */
public class TestePersistirPessoaFisica {
    
    EntityManager em;
    
    
    public TestePersistirPessoaFisica() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void test(){
        boolean exception = false;
        try{
            PessoaFisica pf = new PessoaFisica();
            pf.setCpf("07989487609");
            pf.setEmail("gustavosisinfo2015@gmail.com");
            pf.setNascimento(Calendar.getInstance());
            pf.setNome("Gustavo de Almeida Santos");
            pf.setNomeUsuario("gustavo.santos");
            pf.setRg("15118657");
            pf.setSenha("usuario");
            pf.setTelefone("(31)98597-1976");
            
           
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
