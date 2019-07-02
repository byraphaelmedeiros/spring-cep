# Spring-CEP

Componente Spring que permite buscar por enderecos a partir de um CEP em uma serie de servicos REST disponiveis.

Com este componente e possivel tambem customizar a lista de servicos REST que fazem a busca por um endereco a partir 
de um CEP informado.

### Configuracoes

Nas propriedades de sua aplicacao, re-defina o valor de 'com.byraphaelmedeiros.spring.cep.url' com a lista de URLs de 
servicos REST, separados por virgula, os quais podem efetuar busca por um determinado CEP, este indicado como '%s' na 
URL indicada. Exemplo:

`com.byraphaelmedeiros.spring.cep.url=http://api.rest.com/cep/%s, http://api.rest.com/cep/%s/unicode/, http://api.rest.com/cep.php?cep=%s&output=json, http://api.rest.com/%s.json`