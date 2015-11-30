package chamados.teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import chamados.modelo.Cidade;
import chamados.modelo.ClientePessoaFisica;
import java.util.Calendar;
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
public class TestePersistirPessoaFisica {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPessoaFisica() {
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
            ClientePessoaFisica pf = new ClientePessoaFisica();
            pf.setCidade(em.find(Cidade.class, 1));
            pf.setNome("Beto Albuquerque");
            pf.setTipo("F");
            pf.setEndereco("Rua L, 15, Centro");
            pf.setDataCadastro(Calendar.getInstance());
            pf.setCategoria("com contrato");
            pf.setSituacao("ativo");
            pf.setEmail("beto@a.com");
            pf.setCpf("443.883.765-07");
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
