# WorldBeauty
## Feito por Victor Gabriel Andrade de Melo - 4° ADS B

## Projeto criado para a obtenção de nota no Curso de ADS pelo 4° Semestre na matéria de Engenharia de Software 3 em 2021-12

## Requisitos:
 - Banco de dados Mysql 8.0
 - Java 8 ou superior
 
## Localhost:

- Antes de iniciar o projeto, vá em seu Mysql e crie um Schema no seu banco de dados local com o nome de "wb";

- Vá até o diretório do projeto e rode o arquivo "WorldBeautyApplication.java" e espere o servidor subir;

- Volte ao Banco de dados criado anteriorente e digite a seguinte query:

use wb;

INSERT INTO role(nome_role) values('ROLE_ADMIN');

INSERT INTO role(nome_role) values('ROLE_USER');


## Reinicie o servidor e utilize o projeto.
