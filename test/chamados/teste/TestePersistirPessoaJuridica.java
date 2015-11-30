package chamados.teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import chamados.modelo.Cidade;
import chamados.modelo.ClientePessoaJuridica;
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
public class TestePersistirPessoaJuridica {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPessoaJuridica() {
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
            ClientePessoaJuridica pj = new ClientePessoaJuridica();
            pj.setCidade(em.find(Cidade.class, 1));
            pj.setCategoria("C/ contrato");
            pj.setTipo("J");
            pj.setCnpj("48.650.616/0001-34");
            pj.setDataCadastro(Calendar.getInstance());
            pj.setEmail("Empresa_a@a.com");
            pj.setEndereco("Rua J, 27, Centro");
            pj.setRazaoSocial("Empresa A");
            pj.setSituacao("Ativo");
           
            em.getTransaction().begin();
            em.persist(pj);
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
