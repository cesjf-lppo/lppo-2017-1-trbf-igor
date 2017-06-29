
package br.cesjf.lppo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Tarefa implements Serializable { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_concluir;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_conclusao;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the data_concluir
     */
    public Date getData_concluir() {
        return data_concluir;
    }

    /**
     * @param data_concluir the data_concluir to set
     */
    public void setData_concluir(Date data_concluir) {
        this.data_concluir = data_concluir;
    }

    /**
     * @return the data_conclusao
     */
    public Date getData_conclusao() {
        return data_conclusao;
    }

    /**
     * @param data_conclusao the data_conclusao to set
     */
    public void setData_conclusao(Date data_conclusao) {
        this.data_conclusao = data_conclusao;
    }
    
}
