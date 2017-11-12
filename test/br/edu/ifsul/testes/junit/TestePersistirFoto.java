/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Foto;
import br.edu.ifsul.modelo.Produto;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Gustavo
 */
public class TestePersistirFoto {
    
    EntityManager em;
    
    
    public TestePersistirFoto() {
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
           
            Produto p = em.find(Produto.class, 2);
            Foto f = new Foto();
            f.setNome("jaqueta.jpg");
            f.setDescricao("Foto da jaqueta");
            Path path = Paths.get("/home/gustavo/Pictures/jaqueta.jpg");
            f.setArquivo(Files.readAllBytes(path));
            p.adicionarFoto(f);

            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
