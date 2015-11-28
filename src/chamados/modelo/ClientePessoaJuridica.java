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
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author patricio
 */
@Entity
@Table(name = "cliente_pessoa_juridica")
public class ClientePessoaJuridica extends Cliente implements Serializable{
    
    @NotBlank(message = "A razão social deve ser informada")
    @Length(max = 40, message = "A razão social deve ter no máximo {max} caracteres")
    @Column(name = "razao_social", length = 40, nullable = false, unique = true)
    private String razaoSocial;
    
    @CNPJ(message = "Informe um cnpj válido")
    @NotBlank(message = "O cnpj deve ser informado")
    @Length(min = 18, max = 18, message = "O cnpj deve ter {max} caracteres")
    @Column(name = "cnpj", length = 18, nullable = false, unique = true)
    private String cnpj;

    public ClientePessoaJuridica() {
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
