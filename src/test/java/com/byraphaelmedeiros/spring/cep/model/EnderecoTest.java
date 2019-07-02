package com.byraphaelmedeiros.spring.cep.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe responsavel por executar os testes unitarios na classe {@link Endereco}
 *
 * @author Raphael Medeiros (raphael.medeiros@gmail.com)
 * @since 29/06/2019
 */
public class EnderecoTest {

    Endereco endereco;

    /**
     * Prepara um objeto {@link Endereco} basico para utilizacao nos testes desta classe.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        endereco = new Endereco("59075380","Rua Engenheiro Nelson Matos", "até 1873/1874",
                "Nova Descoberta", "Natal", "RN");
    }

    /**
     * Testa o metodo {@link Endereco#isValid()} para uma condicao valida.
     */
    @Test
    public void isValid() {
        Assert.assertTrue(endereco.isValid());
    }

    /**
     * Testa o metodo {@link Endereco#isValid()} para uma condicao invalida.
     */
    @Test
    public void isNotValid() {
        endereco.setCidade(null);
        endereco.setLocalidade(null);

        Assert.assertFalse(endereco.isValid());
    }
}