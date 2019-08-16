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
public class TesteAlterarCategoria {

    public static void main(String[] args) {
        /** 
         * A instância do objeto EntityManager factory deve ser criado com o método createEntityManagerFactory
         * da classe Persistence. O Valor informado neste método se encontra na propriedade name 
         * do elemento persistence persistence-unit, do arquivo persistence.xml.
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CadastrosJPAPU");
        // Instanciando um objeto EntityManager
        EntityManager em = emf.createEntityManager();
        /*
        O método da entityManager chamado find, recebe dois parâmetros:
        o primeiro é a classe que vai recuperada do banco de dados
        o segundo a chave primária do registro no banco de dados
        */
        Categoria c = em.find(Categoria.class, 1);
        c.setNome("Eletrônicos");
        // Iniciando uma transação com o banco de dados
        em.getTransaction().begin();
        // Chamando o método para alterar e gravar no banco o objeto categoria criado.
        em.merge(c);
        // Finalizando a transação com o banco de dados. 
        em.getTransaction().commit();        
    }
}
