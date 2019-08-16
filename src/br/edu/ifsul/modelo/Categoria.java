package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_categoria", sequenceName = "seq_categoria_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_categoria", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    public Categoria(){
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
