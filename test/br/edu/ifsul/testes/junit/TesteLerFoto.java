/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Foto;
import java.io.File;
import java.io.FileOutputStream;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Gustavo
 */
public class TesteLerFoto {
    
    EntityManager em;
    
    
    public TesteLerFoto() {
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
           
            Foto f = em.find(Foto.class, 1);
            File file = new File("/home/gustavo/Pictures/jaqueta_baixada.jpg");
            FileOutputStream out = new FileOutputStream(file);
            out.write(f.getArquivo());
            out.close();
            
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
