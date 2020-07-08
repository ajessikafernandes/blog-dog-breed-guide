# Blog Sobre Guia de Raças de Cachorros

Blog sobre raças de cães, resultado do curso "Spring Boot e integração com Heroku"

Demo : [blog-dog-breed-guide](https://breed-guide-blog.herokuapp.com/)

# Pré-requisitos:

  - Java 1.8.
  - PostgreSQL
  - Maven

### Montando ambiente:

Baixar o projeto usando o comando git clone.

Executando pela linha de comando na pasta da raiz do projeto, crie o jar do projeto:

```
./mvnw clean install
```

Para executar o projeto via terminal, use o comando :

```
java -jar -Dspring.profiles.active=local target/blog-dog-breed-guide-0.0.1-SNAPSHOT.jar
```

