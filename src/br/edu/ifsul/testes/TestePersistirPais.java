/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gustavo
 */
public class TestePersistirPais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModelPU");
        EntityManager em = emf.createEntityManager();
        Pais p = new Pais();
        //p.setId((1));
        p.setNome("Brasil");
        p.setIso("BRA");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
