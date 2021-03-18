<img alt="Java" src="https://img.shields.io/badge/java-%23ED8B00.svg?&style=for-the-badge&logo=java&logoColor=white"/> <img alt="Spring" src="https://img.shields.io/badge/spring%20-%236DB33F.svg?&style=for-the-badge&logo=spring&logoColor=white"/>
<img alt="MongoDB" src ="https://img.shields.io/badge/MongoDB-%234ea94b.svg?&style=for-the-badge&logo=mongodb&logoColor=white"/>


# Workshop Spring + MongoDB

---

## Objetivos gerais
- Compreender as principais diferenças entre paradigma orientado a documentos e relacional
- Implementar operações de CRUD
- Refletir sobre decisões de design para um banco de dados orientado a documentos
- Implementar associações entre objetos
    - Objetos aninhados
    - Referências
- Realizar consultas com Spring Data e MongoRepository

---

## Camadas da aplicação

![AppLayers](https://github.com/Wwillers/workshop-mongodb-springboot/blob/main/imgs/camadas.png)

---

## Diagrama de Objetos

![ObjetsDiagram](https://github.com/Wwillers/workshop-mongodb-springboot/blob/main/imgs/diagramaobjetos.png)

---

## Endpoints
---
### User

| Método | Path | Descrição |
| ----------- | ----------- | ----------- |
| Get | /users | Retorna todos Usuários |
| Get | /users/${id} | Retorna usuário por ID |
| Get | /users/${id}/posts | Retorna os Posts do usuário utilizando ID |
| Post | /users | Insere novo usuário, JSON com campo nome e email |
| Put | /users/${id} | Atualiza dados do Usuário |

---
### Posts

| Método | Path | Descrição |
| ----------- | ----------- | ----------- |
| Get | /posts/${id} | Retorna post por ID |
| Get | /posts/titlesearch?text=${string} | Pesquisa Post por título |
| Get | /posts/multiparamsearch?text=${string}?minDate=${date}?maxDate=${date} | Pesquisa Post por título, data mínima e máxima |
