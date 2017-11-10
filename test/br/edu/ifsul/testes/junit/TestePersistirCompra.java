/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Compra;
import br.edu.ifsul.modelo.CompraID;
import br.edu.ifsul.modelo.CompraItem;
import br.edu.ifsul.modelo.PessoaJuridica;
import br.edu.ifsul.modelo.Produto;
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
public class TestePersistirCompra {
    
    EntityManager em;
    
    
    public TestePersistirCompra() {
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
            
            PessoaJuridica pj = em.find(PessoaJuridica.class, 5);
            
            Compra obj = new Compra();
            CompraID id = new CompraID();
            
            id.setPessoaJuridica(pj);
            id.setNumeroNota(123456);
            
            obj.setId(id);
            obj.setData(Calendar.getInstance());
            
            CompraItem item = new CompraItem();
            item.setProduto(p);
            item.setValorUnitario(p.getPreco());
            item.setQuantidade(5.0);
            item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
            
            obj.adicionarItem(item);
            
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
