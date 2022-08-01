
# Academia - Spring / JPA

O projeto consiste em um CRUD, permitindo cadastrar alunos e relacionar estes com avaliações físicas, o projeto tem fim acadêmico está em andamento e temos duas entidades ainda a conversar -> matrícula e plano.

## Requisitos

- PostgreSQL -> Driver
- Spring Data JPA
- Hibernate Validator
- Spring Web


## Documentação da API

#### Retorna todos os Alunos

```http
  GET -> /aluno/todos
```
#### Retorna um Aluno

```http
  GET -> /aluno/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `Long` | **Obrigatório** Id do aluno |

#### Deleta um aluno

```http
  GET /aluno/excluir/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `Long` | **Obrigatório** Id do aluno |

#### Novo aluno

```http
  POST /aluno/novo
```
Os dados serão recebidos via @RequestBody onde o objeto AlunoDTO fará a validação e salvará com o repository.

#### Editar aluno

```http
  POST /aluno/editar/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `Long` | **Obrigatório** Id do aluno |

Aqui iremos receber o id do aluno e instanciar seu objeto substituindo os parâmetros recebidos via @RequestBody, utilizaremos AlunoDTO para esse fim e salvaremos depois com o repository instanciado.

#### Nova Avaliação Física

```http
  POST /exame/novo
```

Aqui usaremos @RequestBody para receber a altura e peso do usuário e também o ID do aluno referenciado os demais dados serão recebidos direto na criação do registro.

#### Buscar AvaliaçãoFísica

```http
  GET /exame/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `Long` | **Obrigatório** Id da AvaliaçãoFísica |

Retornará a avaliação referida e seu aluno associado.
## Melhorias

O UPDATE que não tinha sido implementado agora está funcional, porém é interessante substituir as instâncias das entidades por views nos endpoints.

## Dio - Digital Inovation One #Campus Expert - Turma4

- [linkedin @carlossfb](https://www.linkedin.com/in/carlossfb/)

