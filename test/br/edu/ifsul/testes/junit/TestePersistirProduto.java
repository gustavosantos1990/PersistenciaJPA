/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Categoria;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Produto;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Gustavo
 */
public class TestePersistirProduto {
    
    EntityManager em;
    
    
    public TestePersistirProduto() {
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
            PessoaFisica pf = em.find(PessoaFisica.class, 1);
            Produto p = new Produto();
            p.setCategoria(em.find(Categoria.class, 1));
            p.setDescricao("Jaqueta Simples");
            p.setMarca(em.find(Marca.class, 1));
            p.setNome("Jaqueta Simples");
            p.setPreco(100.0);
            p.setQuantidadeEstoque(Double.parseDouble("200"));
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
