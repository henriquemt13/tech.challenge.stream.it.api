# tech.challenge.stream.it.api
Tech Challenge FIAP Fase 4 - Stream It


## Relatório Técnico

---
- [Introdução - Desenvolvimento, Arquitetura e Entidades](#introdução---desenvolvimento-arquitetura-e-entidades)
- [Bibliotecas em Destaque](#bibliotecas-em-destaque)
- [Testes Unitários](#testes-unitários)
- [Plugins da IDE](#plugins-da-ide)
- [Minhas Percepções](#minhas-percepções)

### Introdução - Desenvolvimento, Arquitetura e Entidades

Seguindo os requisitos do Tech Challenge Fase 4, o projeto foi desenvolvido
com o intuito mostrar o conhecimento aprendido a respeito do desenvolvimento
reativo, da implementação de testes unitários e principalmente o uso de 
arquitetura limpa. Vale ressaltar que o projeto foi totalmente desenvolvido
em inglês.

#### Desenvolvimento e Arquitetura

Falando sobre arquitetura, para a concepção desse sistema foram criadas
três camadas de código, a **Aplication**, o **Domain** e a **Infrastructure**.
Cada uma das camadas tem seu uso e suas responsabilidades.

- Application:
  - Faz a comunicação com os consumidores da API, seja uma aplicação ou usuário,
  é através dela que o sistema é acessado. Esta camada é responsável por manter
  os pacotes **Controller** e **dto** por exemplo, onde essa segunda mantém as 
  classes de **request** e **response**, fazendo validações simples e que não
  envolvem diretamente regras de negócio nas mesmas.

- Domain:
  - Mantém as regras de negócio da aplicação. Seguindo os ideais do DDD, 
  é na domain que se encontram todas as regras e validações referentes ao
  domínio do código. A Domain nesse projeto funciona de forma independente,
  sem precisar saber da existência das outras duas camadas. Ela mantém pacotes
  como **Service**, **UseCases**, **Model** e **Exceptions**.

- Infrastructure:
  - Por fim, a camada de infraestrutura é a responsável por fazer a comunicação
  com todas as dependências externas, como bancos de dados ou aplicações terceiras,
  por exemplo. Além disso, ela implementa as diversas interfaces encontradas na camada
  de domínio na aplicação. Dessa forma, enquanto o domínio mantém as regras de negócio
  da aplicação, ele também permite que a infraestrutura as implemente de qualquer forma,
  para qualquer provedor ou storage na nuvem, ou qualquer aplicação terceira provedora
  dos dados necessários, por exemplo. Nesta camada, é possível encontrar os pacotes
  **Entity**, **Adapter** e **Repository**, por exemplo.

Para tudo isso funcionar de forma real, foi utilizado o recurso do Spring Multi-Modules,
onde cada camada da aplicação foi separada em três modulos específicos, com suas próprias
bibliotecas e dependências, onde as camadas **Application** e **Infrastructure**
tinham a dependencia da camada **Domain**, enquanto a camada de domínio, por não ter
ter a denepndência das outras duas, existe "como se não soubesse de sua existência".


#### Entidades

Para conceber o projeto, foram pensadas em algumas entidades básicas:
- User
- Video
- Like
- Category

Como o sistema foi desenvolvido utilizando um banco de dados relacional 
(**PostgreSQL**), foram criadas outras entidades que serviram para
simplesmente fazer a relação com as principais:
- UserCategories
- VideoCategories
- ViewingHistory


## Bibliotecas Em Destaque

---

Impossível não ressaltar novamente a importancia do MapStruct, que foi
muito utilizado para fazer a comunicação entre os objetos das camadas,
transformando objetos de requests em objetos de Model, ou objetos de Model
para objetos de Entity, por exemplo.

Outra biblioteca mega importante foi o Flyway, para o uso de Migrations no
banco de dados. Isso possibilitou o desenvolvimento ágil e muito tempo de
configuração de banco de dados economizada.

Por fim, o Spring WebFlux, juntamente com o ProjectReactor forma essências
para o desenvolvimento da parte reativa do projeto, lidando com o Streaming
de arquivos em tempo real.

## Testes Unitários

---

Utilizando o JUnit 5, forma feitos os testes unitários na aplicação, com
foco nos testes de regras de negócio, e o conceito de TDD foi utilizado
para a aplicação deles na camada de Domínio do projeto. A ideia desses testes
foi mapear exatamente todos os cenários de cada método, seja sucesso, erros
e tipos de erros de forma independente.

Já em seguida foram testadas as Controllers da aplicação, agora com um foco maior
em verificar sua implementação em si, não os cenários de sucesso e erros possíveis.


Não houveram testes unitários na camada de infraestrutura, pois em sumo, as lógicas
implementadas pela camada já foram testadas na camada de domínio, e por fim, seria apenas
repetição de código para chegar nos mesmos resultados.


## Plugins da IDE

---

O SonarLint foi um ótimo companheiro de desenvolvimento para esse projeto,
sendo muito utilizado para identificar lógicas que poderiam ser refatoradas para
uma forma mais simples, importações não utilizadas e nomenclaturas incorretas.


## Minhas Percepções

---

Por fim, acredito que tenha sido um projeto bem desafiador de ser construído,
foi a minha primeira aplicação com o uso de WebFlux e optei por tocar todo
o desenvolvimento sozinho, com tempo reduzido, pois tenho uma viagem marcada para
durante os útlimos dias até a data de entrega do projeto.

Apesar de ser uma adaptação da arquitetura que atualmente utilizo em meu emprego, 
acredito que a maior dificuldade do projeto tenha sido a configuração das camadas,
além de chegar as soluções de relacionamento entre as entidades.

Acredito que o interessante desse projeto, no final das contas, foi que da forma que
ele foi desnevolvido, ainda há um espaço muito amigável para novas implementações,
melhorias e até mesmo correções.

*Nota: é possível encontrar no vídeo de relatório do projeto neste mesmo repositório, 
clicando aqui. O Vídeo, por sua vez, foi gravado durante os últimos ajustes de código, antes
de sua finalização, então é possível que um ou outro endpoint esteja mínimamente diferente
de sua demonstração. Mas em sumo, o vídeo passa o conceito completo por trás da aplicação*


*Nota 2: Ao subir a aplicação, é possível acessar seu Swagger, através deste link:* http://localhost:8080/swagger-ui/index.html#/
