/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chamados.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author patricio
 */
@Entity
@Table(name = "cliente_pessoa_fisica")
public class ClientePessoaFisica extends Cliente implements Serializable{
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ter mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @CPF(message = "Informe um cpf válido")
    @NotBlank(message = "O cpf deve ser informado")
    @Length(min = 14, max = 14, message = "O cpf deve ter {max} caracteres")
    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;

    public ClientePessoaFisica() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
