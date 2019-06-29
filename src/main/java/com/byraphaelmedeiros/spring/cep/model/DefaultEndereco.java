package com.byraphaelmedeiros.spring.cep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Raphael Medeiros (raphael.medeiros@gmail.com)
 * @since 23/05/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultEndereco implements Endereco {

    public DefaultEndereco() {
        // default construct
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
    }

    public String getLocalidade() {
        return localidade != null ? localidade : null;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getEstado() {
        return (estado != null ? estado : getUf());
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf != null ? uf : null;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean isValid() {
        return (StringUtils.isAnyBlank(getCep(), getLogradouro(), getBairro(), getCidade(), getEstado()));
    }
}