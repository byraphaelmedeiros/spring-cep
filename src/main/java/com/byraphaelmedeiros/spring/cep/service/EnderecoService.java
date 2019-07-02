package com.byraphaelmedeiros.spring.cep.service;

import com.byraphaelmedeiros.spring.cep.model.Endereco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * Componente responsavel por buscar enderecos nos servicos REST indicados na lista de URLs configurada.
 *
 * @author Raphael Medeiros (raphael.medeiros@gmail.com)
 * @since 23/05/2016.
 */
@Service
public class EnderecoService {

    private Logger logger = LoggerFactory.getLogger(EnderecoService.class);

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${com.byraphaelmedeiros.spring.cep.url}")
    private String[] urls;

    /**
     * Recupera um Endereco de acordo com o CEP informado no parametro.
     *
     * @param cep CEP que sera consultado.
     *
     * @return
     * @throws EnderecoServiceException
     */
    public Endereco getEnderecoByCep(String cep) throws EnderecoServiceException {
        Endereco endereco = null;

        for (String url : urls) {
            try {
                endereco = restTemplate.getForObject(String.format(url, cep), Endereco.class);
            } catch (ResourceAccessException e) {
                logger.error("Serviço indisponível para: {}", url);
            } catch (Exception e) {
                throw new EnderecoServiceException(e);
            }

            if (endereco != null && endereco.isValid()) {
                break;
            }
        }

        if (endereco != null && !endereco.isValid()) {
            endereco = null;
        }

        return endereco;
    }
}
