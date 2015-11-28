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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author patricio
 */
@Entity
@Table(name = "tecnico")
public class Tecnico implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_tecnico", sequenceName = "seq_tecnico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_tecnico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotEmpty(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ter mais de {max} letras")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @NotEmpty(message = "O telefone deve ser informado")
    @Length(max = 13, message = "O telefone não deve ter mais de {max} letras")
    @Column(name = "uf", nullable = false, length = 13)
    private String telefone;
    
    @NotEmpty(message = "A categoria deve ser informada")
    @Length(max = 20, message = "A categoria não deve ter mais de {max} letras")
    @Column(name = "categoria", nullable = true, length = 20)
    private String categoria;
    
    @NotNull(message = "O salário deve ser informado")
    @Column(name = "salario", nullable = false, columnDefinition = "decimal(12,2)")
    private Double salario;
       

    public Tecnico() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Tecnico other = (Tecnico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tecnico{" + "nome=" + nome + '}';
    }

    
}
