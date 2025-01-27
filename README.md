# Lista de Jogos

Este projeto foi desenvolvido durante o Intensivão Java da DevSuperior. O objetivo do sistema é exibir uma coleção de jogos organizados em diferentes categorias. Inicialmente, foram criadas duas listas principais para cada lista há ao todo 5 jogos: 

1. Jogos de Plataforma
2. Jogos de Aventura/RPG

## Descrição Técnica

O projeto foi implementado utilizando as seguintes tecnologias e práticas:

 - Linguagem de programação: Java
 - Framework: Spring Boot (desenvolvido no ambiente Spring Tool Suite - STS)
  
Banco de dados:
 - H2 (usado em ambiente de testes, com armazenamento em memória)
 - PostgreSQL (usado na produção para persistência dos dados)

___

### Estrutura do Projeto

___

O desenvolvimento seguiu uma arquitetura bem definida, com a separação das responsabilidades em camadas:

##### Camada de Controladores REST:

- Responsável por gerenciar as entradas e saídas da aplicação, fornecendo endpoints para o consumo da API. Segue os princípios RESTful.
  
##### Camada de Serviço:

- Contém a lógica de negócio da aplicação, como regras específicas relacionadas ao gerenciamento dos jogos.

#### Camada de Acesso a Dados:

- Realiza operações no banco de dados por meio de repositórios, que abstraem e organizam as consultas e comandos SQL necessários.

#### DTO (Data Transfer Object):

- Criado para transferir dados de maneira segura e eficiente entre as camadas da aplicação, evitando o vazamento direto das entidades do banco de dados.

___

### Entidades do Projeto

___

No contexto deste projeto, as entidades representam os principais elementos do sistema e seus relacionamentos. Abaixo, segue a explicação de cada uma delas:

#### Game

- Representa um jogo no sistema, contendo atributos como título, gênero, data de lançamento, entre outros.
- Essa entidade está diretamente associada às listas de jogos e é gerenciada por meio de um ORM para facilitar o mapeamento no banco de dados.

#### GameList

- Representa uma lista de jogos, como "Jogos de Plataforma" ou "Jogos de Aventura/RPG".
- Cada lista agrupa uma coleção de jogos, permitindo organizar os dados de forma categorizada.
  
#### Belonging

- É uma entidade intermediária que define o relacionamento entre um jogo (Game) e uma lista de jogos (GameList).
- Contém informações adicionais, como a ordem em que os jogos aparecem dentro de uma lista específica.

#### BelongingPK

- Representa a chave primária composta da entidade Belonging.
- É composta pelas chaves primárias de Game e GameList, garantindo que cada jogo pertença a uma única lista de forma única.
- Essa estrutura de entidades reflete a relação "muitos para muitos" entre jogos e listas, com a entidade Belonging funcionando como um intermediário para gerir essa associação de forma eficiente e escalável.

___

### Funcionalidades

___

O projeto oferece funcionalidades simples e eficientes para gerenciar jogos e listas. Entre as principais funcionalidades, temos:

1. **Exibir todos os jogos ou um jogo específico**: Permite visualizar todos os jogos cadastrados ou buscar por um jogo específico através de seus dados.

2. **Exibir uma lista e seus jogos**: Permite visualizar os jogos associados a uma lista específica, mostrando a organização e os detalhes dos jogos presentes nela.

3. **Exibir as duas listas**: Permite visualizar as duas listas principais de jogos, como "Jogos de Plataforma" e "Jogos de Aventura/RPG".

4. **Mover um jogo de posição dentro de uma lista**: Esta funcionalidade permite reorganizar os jogos dentro de uma lista. O sistema solicita os seguintes parâmetros para realizar a alteração:

 - Qual lista será utilizada.
 - Qual jogo deve ter a posição alterada.
- Qual será a nova posição do jogo dentro da lista.

___

### Instruções SQL

___

O projeto também utilizou instruções SQL personalizadas para realizar projeções e trazer dados específicos do banco de dados, otimizando a consulta e apresentação das informações. Abaixo estão dois exemplos dessas instruções:

#### *Search for List*: 
Essa funcionalidade retorna os jogos associados a uma lista específica, ordenados por uma posição definida dentro da lista.

Descrição:
 - Selecionar informações específicas de jogos, como ID, título, ano de lançamento, URL da imagem e uma breve descrição.
 - Associar esses jogos a uma lista específica (list_id) usando um INNER JOIN.
 - Ordenar os jogos pela posição definida na lista (position).

#### *Update Belonging Position*:
Essa funcionalidade permite atualizar a posição de um jogo dentro de uma lista específica no banco de dados.

Descrição:
 - Alterar o valor da posição (position) de um jogo específico (game_id) dentro de uma lista específica (list_id).
 - Garantir que apenas o registro correto seja atualizado, utilizando as condições list_id = :listId e game_id = :gameId.

