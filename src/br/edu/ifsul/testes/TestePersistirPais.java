/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;


/**
 *
 * @author Gustavo
 */
public class TestePersistirPais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        Pais p = new Pais();
        p.setNome("Chile");
        p.setIso("CHI");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();

    }
    
}
