# todo-list
		TODO List
https://www.linkedin.com/in/deivid-zioto-6735b9289/ Desafio

API para gerenciar tarefas (CRUD) que faz parte desse desafio para pessoas desenvolvedoras backend júnior, que se candidatam para a Simplify.

Tecnologias
Spring Boot
Spring MVC
Spring Data JPA
SpringDoc OpenAPI 3
Mysql
Práticas adotadas
SOLID, DRY, YAGNI, KISS
API REST
Consultas com Spring Data JPA
Injeção de Dependências
Tratamento de respostas de erro
Como Executar
Clonar repositório git
Construir o projeto:
$ ./mvnw clean package
Executar a aplicação:
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
A API poderá ser acessada em localhost:8080.

API Endpoints
Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta httpie:

Criar Tarefa
$ http POST :8080/tasks nome="task 1" descricao="Desc task 1" prioridade=1

[
  {
    "descricao": "Desc task 1",
    "id": 1,
    "nome": "task 1",
    "prioridade": 1,
  }
]
Listar Tarefas
$ http GET :8080/tasks

[
  {
    "descricao": "Desc Todo 1",
    "id": 1,
    "nome": "tak 1",
    "prioridade": 1,
  }
]
Atualizar Tarefa
$ http PUT :8080/tasks/1 nome="task 1 Up" descricao="Desc task 1 Up" prioridade=2

[
  {
    "descricao": "Desc task 1 Up",
    "id": 1,
    "nome": "task 1 Up",
    "prioridade": 2,
  }
]
Remover Tarefa
http DELETE :8080/tasks/1

[ ]
