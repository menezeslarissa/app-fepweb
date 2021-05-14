# fepweb-demo-app

Um app de registro de empresas utilizando [Spring Boot](https://spring.io/quickstart) e [Angular](https://angular.io/)

## Requerimentos

Para buildar e rodar esta aplicação, você irá precisar de:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [Node.js](https://nodejs.org/en/)
- [MySQL](https://www.mysql.com/downloads/)

## Rodando a aplicação spring-boot localmente:

Acesse seu bash ou prompt de comando dentro da pasta /demo e digite o comando abaixo:

```shell
mvn spring-boot:run
```

Obs: Antes de executar, abra o script .sql que está na pasta -> fepweb\demo\src\main\resources\sql_scripts, e execute-o no sql editor do [MySQL Workbench](https://www.mysql.com/products/workbench/) para que seja criado o banco de dados usado na aplicação.

## Rodando a aplicação angular localmente:

Acesse seu bash ou prompt de comando dentro da pasta /frontend e digite o comando abaixo:

```shell
npm install
```
e logo em seguida:

```shell
npm start
```



