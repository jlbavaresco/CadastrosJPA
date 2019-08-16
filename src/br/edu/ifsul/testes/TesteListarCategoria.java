package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TesteListarCategoria {

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
        Com o comando createQuery pode-se executar uma consulta com a linguagem JPQL, 
        que é uma linguagem de consulta a objetos. Uma lista será recuperada do banco de dados
        */
        List<Categoria> lista = em.createQuery("select c from Categoria c order by c.nome").getResultList();
        /*
        Percorrendo a lista para exibir no banco de dados
        */
        for (Categoria c : lista){
            System.out.println("Código: " + c.getCodigo() + " Nome: " + c.getNome());
        }
    }
}
