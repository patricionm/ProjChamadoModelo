/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chamados.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author patricio
 */
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "chamado")
public class Chamado implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_chamado", sequenceName = "seq_chamado_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_chamado", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "A descrição deve ser informada")
    @Length(max = 60, message = "A descrição não deve ter mais de {max} caracteres")
    @Column(name = "descricao", length = 60, nullable = false)
    private String descricao;
    
    @NotNull(message = "A data de abertura deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_abertura", nullable = false)
    private Calendar dtAbertura;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_fechamento", nullable = true)
    private Calendar dtFechamento;
    
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valor;
    
    @Length(max = 60, message = "O laudo não deve ter mais de {max} caracteres")
    @Column(name = "laudo", length = 60, nullable = true)
    private String laudo;
    
    @Column(name = "anexo", length = 60, nullable = true)
    private String anexo;
    
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "tecnico", referencedColumnName = "id", nullable = false)
    private Tecnico tecnico;
    
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;
    

    public Chamado() { 
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(Calendar dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public Calendar getDtFechamento() {
        return dtFechamento;
    }

    public void setDtFechamento(Calendar dtFechamento) {
        this.dtFechamento = dtFechamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Chamado other = (Chamado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chamado{" + "descricao=" + descricao + '}';
    }

    
}
