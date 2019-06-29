package com.byraphaelmedeiros.spring.cep.service;

import com.byraphaelmedeiros.spring.cep.model.DefaultEndereco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * @author Raphael Medeiros (raphael.medeiros@gmail.com)
 * @since 23/05/2016.
 */
@Service
public class EnderecoService {

    private Logger logger = LoggerFactory.getLogger(EnderecoService.class);

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${com.byraphaelmedeiros.spring.cep.url}")
    private String[] urls;

    public DefaultEndereco getByCep(String cep) {
        DefaultEndereco endereco = null;

        for (String url : urls) {
            try {
                endereco = restTemplate.getForObject(String.format(url, cep), DefaultEndereco.class);
            } catch (ResourceAccessException e) {
                logger.error("Serviço indisponível para: {}", url);
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
