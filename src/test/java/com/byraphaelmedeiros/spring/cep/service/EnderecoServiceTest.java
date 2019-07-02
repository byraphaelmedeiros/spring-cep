package com.byraphaelmedeiros.spring.cep.service;

import com.byraphaelmedeiros.spring.cep.model.Endereco;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Classe responsavel por executar os testes unitarios na classe {@link EnderecoService}
 *
 * @author Raphael Medeiros (raphael.medeiros@gmail.com)
 * @since 29/06/2019
 */
@RunWith(SpringRunner.class)
@RestClientTest(EnderecoService.class)
@SpringBootTest(classes = {EnderecoService.class}, properties = {"com.byraphaelmedeiros.spring.cep.url=http://api.postmon.com.br/v1/cep/%s, http://viacep.com.br/ws/%s/json/unicode/"})
public class EnderecoServiceTest {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ObjectMapper objectMapper;

    String enderecoString;

    /**
     * Prepara objetos basicos para utilizacao nos testes desta classe.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        enderecoString = objectMapper.writeValueAsString(new Endereco("59075380",
                "Rua Engenheiro Nelson Matos", "até 1873/1874", "Nova Descoberta",
                "Natal", "RN"));
    }

    /**
     * Testa o metodo {@link EnderecoService#getEnderecoByCep(String)} para um CEP valido.
     *
     * @throws Exception
     */
    @Test
    public void getEnderecoByCepValid() throws Exception {
        Endereco enderecoByCep = enderecoService.getEnderecoByCep("59075380");

        String enderecoByCepString = objectMapper.writeValueAsString(enderecoByCep);

        Assert.assertEquals(enderecoString, enderecoByCepString);
    }

    /**
     * Testa o metodo {@link EnderecoService#getEnderecoByCep(String)} para um CEP invalido.
     *
     * @throws EnderecoServiceException
     */
    @Test(expected = EnderecoServiceException.class)
    public void getEnderecoByCepNotValid() throws EnderecoServiceException {
        enderecoService.getEnderecoByCep("59075300");
    }
}