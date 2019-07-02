package com.byraphaelmedeiros.spring.cep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.StringUtils;

/**
 * Objeto que define o modelo padrão de um Endereco para o componente.
 *
 * @author Raphael Medeiros (raphael.medeiros@gmail.com)
 * @since 23/05/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Endereco {

    public Endereco() {
        // default construct
    }

    public Endereco(String cep, String logradouro, String complemento, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;

        this.cidade = cidade;
        this.localidade = cidade;

        this.estado = estado;
        this.uf = estado;
    }

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;


    private String cidade;

    private String localidade;


    private String estado;

    private String uf;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return (cidade != null ? cidade : getLocalidade());
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;

        if (localidade == null) {
            this.localidade = cidade;
        }
    }

    public String getLocalidade() {
        return localidade != null ? localidade : null;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;

        if (cidade == null) {
            this.cidade = localidade;
        }
    }

    public String getEstado() {
        return (estado != null ? estado : getUf());
    }

    public void setEstado(String estado) {
        this.estado = estado;

        if (uf == null) {
            this.uf = estado;
        }
    }

    public String getUf() {
        return uf != null ? uf : null;
    }

    public void setUf(String uf) {
        this.uf = uf;

        if (estado == null) {
            this.estado = uf;
        }
    }

    public boolean isValid() {
        return !(StringUtils.isAnyBlank(getCep(), getLogradouro(), getBairro(), getCidade(), getEstado()));
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}