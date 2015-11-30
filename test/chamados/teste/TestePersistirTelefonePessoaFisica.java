package chamados.teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import chamados.modelo.Cidade;
import chamados.modelo.ClientePessoaFisica;
import chamados.modelo.Telefone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author patricio
 */
public class TestePersistirTelefonePessoaFisica {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirTelefonePessoaFisica() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("SistChamados-ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try {
            // Aqui vai o teste
            // recupera uma cidade
            ClientePessoaFisica pf = em.find(ClientePessoaFisica.class, 2);
            Telefone t = new Telefone();
            t.setDdd("54");
            t.setNumero("9998-7856");
            t.setTipo("residencial");
            t.setDescricao("somente depois das 19:00");
            pf.adicionarTelefone(t);
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        // verificar se o resultado foi o esperado
        Assert.assertEquals(false, exception);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
