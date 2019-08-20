package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Categoria;
import br.edu.ifsul.modelo.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirProduto {

    public static void main(String[] args) {
        /** 
         * A instância do objeto EntityManager factory deve ser criado com o método createEntityManagerFactory
         * da classe Persistence. O Valor informado neste método se encontra na propriedade name 
         * do elemento persistence persistence-unit, do arquivo persistence.xml.
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CadastrosJPAPU");
        // Instanciando um objeto EntityManager
        EntityManager em = emf.createEntityManager();
        // Recuperando um objeto do tipo Categoria
        Categoria c = em.find(Categoria.class, 1);
        // Criando o objeto produto
        Produto p = new Produto();
        p.setNome("Mouse Laser sem fio");
        p.setPreco(100.00);
        // Setando a categoria do produto
        p.setCategoria(c);   
        // Iniciando uma transação com o banco de dados
        em.getTransaction().begin();
        // Chamando o método para persistir o objeto Produto criado. Similar a um insert
        em.persist(p);
        // Finalizando a transação com o banco de dados. 
        em.getTransaction().commit();        
    }
}
