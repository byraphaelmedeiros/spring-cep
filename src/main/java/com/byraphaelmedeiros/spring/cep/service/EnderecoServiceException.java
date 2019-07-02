package com.byraphaelmedeiros.spring.cep.service;

/**
 * Excessao disparada quando ocorrer um erro em {@link EnderecoService}
 *
 * @author Raphael Medeiros (raphael.medeiros@gmail.com)
 * @since 01/07/2019
 */
public class EnderecoServiceException extends Exception {

    public EnderecoServiceException(Exception e) {
        super(e);
    }
}
