package com.byraphaelmedeiros.spring.cep.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Configuração básica, apenas para injetar valores padrão a serem utilizados na busca por endereços.
 *
 * @author Raphael Medeiros (raphael.medeiros@gmail.com)
 * @since 04/07/2019
 */
@Configuration
@PropertySource("classpath:/spring-cep.properties")
public class SpringCepConfiguration {
}
