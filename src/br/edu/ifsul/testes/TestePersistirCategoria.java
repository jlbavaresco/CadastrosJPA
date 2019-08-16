package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Categoria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirCategoria {

    public static void main(String[] args) {
        /** 
         * A instância do objeto EntityManager factory deve ser criado com o método createEntityManagerFactory
         * da classe Persistence. O Valor informado neste método se encontra na propriedade name 
         * do elemento persistence persistence-unit, do arquivo persistence.xml.
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CadastrosJPAPU");
        // Instanciando um objeto EntityManager
        EntityManager em = emf.createEntityManager();
        // Criando um objeto do tipo Categoria
        Categoria c = new Categoria();
        c.setNome("Eletrônicos");
        // Iniciando uma transação com o banco de dados
        em.getTransaction().begin();
        // Chamando o método para persistir o objeto categoria criado. Similar a um insert
        em.persist(c);
        // Finalizando a transação com o banco de dados. 
        em.getTransaction().commit();        
    }
}
