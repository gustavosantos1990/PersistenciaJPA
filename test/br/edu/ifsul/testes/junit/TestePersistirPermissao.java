
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Permissao;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirPermissao {
    
    EntityManager em;
    
    
    public TestePersistirPermissao() {
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
            Permissao p1 = new Permissao();
            p1.setNome("Administrador");
            p1.setDescricao("Administrador do sistema");
            
            Permissao p2 = new Permissao();
            p2.setNome("Usuario");
            p2.setDescricao("Usuários do sistema");
            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
