
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cidade;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteListarCidade {
    
    EntityManager em;
    
    
    public TesteListarCidade() {
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
            String jpql = "from Cidade order by nome";
            List<Cidade> lista = em.createQuery(jpql).getResultList();
            
            for (Cidade c : lista) {
                System.out.println( "ID: " +c.getId() +
                                    " Nome: " + c.getNome() + 
                                    " Estado: " + c.getEstado().getNome());
            }

        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
