/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chamados.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
/**
 *
 * @author patricio
 */
@Entity
@Table(name = "telefone")
public class Telefone implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_telefone", sequenceName = "seq_telefone_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_telefone", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O DDD deve ser informado")
    @Length(max = 4, message = "O DDD não deve ter mais de {max} caracteres")
    @Column(name = "ddd", length = 4, nullable = false)
    private String ddd;
    
    @NotBlank(message = "O numero deve ser informado")
    @Length(max = 50, message = "O numero não deve ter mais de {max} caracteres")
    @Column(name = "numero", length = 50, nullable = false)
    private String numero;
    
    @NotBlank(message = "O tipo deve ser informado")
    @Length(max = 20, message = "O numero não deve ter mais de {max} caracteres")
    @Column(name = "tipo", length = 20, nullable = false)
    private String tipo;
    
    @NotBlank(message = "O tipo deve ser informado")
    @Length(max = 40, message = "A descrição não deve ter mais de {max} caracteres")
    @Column(name = "descricao", length = 40, nullable = true)
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    public Telefone() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefone other = (Telefone) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telefone{" + "numero=" + numero + '}';
    }
}
