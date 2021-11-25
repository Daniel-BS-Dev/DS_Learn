# DsLearn
## Ferramentas utilizadas

   * JDK 11
   * STS
   * Postman
   * Git
   * Versão do maven 2.4.4

## Sobre o projeto

Aqui você verá a implementar um modelo conceitual complexo com ORM e seed de banco de dados. Você também vai aprender a criar autorizações customizadas: em nível de serviço, conteúdo customizado para o usuário logado, refresh token, pré-autorização de métodos.
   
## Modelo Conceitual
![imagem_conceitual](https://user-images.githubusercontent.com/81425846/143425399-6787a4f0-2cd9-4bb3-85b3-2f4fbb7ccc5b.png)

## Dependências maven:

```java
    <dependency>
	      <groupId>org.springframework.boot</groupId>
	      <artifactId>spring-boot-starter-web</artifactId>
   </dependency>

   <dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>

  <dependency>
	   <groupId>com.h2database</groupId>
	   <artifactId>h2</artifactId>
	   <scope>runtime</scope>
  </dependency>

  <dependency>
	   <groupId>org.postgresql</groupId>
	   <artifactId>postgresql</artifactId>
	   <scope>runtime</scope>
  </dependency>

  <dependency>
	  <groupId>org.springframework.boot</groupId>
	  <artifactId>spring-boot-starter-validation</artifactId>
  </dependency>

  <dependency>
	  <groupId>org.springframework.boot</groupId>
	  <artifactId>spring-boot-starter-security</artifactId>
  </dependency>
  
  
   ``````````
  
## Arquivos de configuração:

   ### application.properties
   
          spring.profiles.active=test

          spring.jpa.open-in-view=false
   
   ### application-test.properties
   
         spring.datasource.url=jdbc:h2:mem:testdb
         spring.datasource.username=sa
         spring.datasource.password=

         spring.h2.console.enabled=true
         spring.h2.console.path=/h2-console
	 
	 
### Endpoint /records

```java
{{host}}/records?min=2020-01-01T00:00:00Z&max=2020-07-31T00:00:00Z&page=0&linesPerPage=20&orderBy=moment&direction=DESC


@RequestParam(value = "page", defaultValue = "0") Integer page,
@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
@RequestParam(value = "direction", defaultValue = "DESC") String direction)
  
 ````
 
 ## SQL para seed da base de dados de teste
 
 ```java
 INSERT INTO tb_category (name, created_At) VALUES ('Livros', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Eletrônicos', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Computadores', NOW());

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('The Lord of the Rings', 90.5, TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Smart TV', 2190.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Macbook Pro', 1250.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/3-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer', 1200.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/4-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Rails for Dummies', 100.99, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/5-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Ex', 1350.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/6-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer X', 1350.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/7-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Alfa', 1850.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/8-big.jpg');

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (6, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (7, 3);

INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Alex', 'Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
 
 ```
 
 ## Configuração provisória para liberar todos endpoints, bloqueados pelo security
 ```java
 @Configuration
 @EnableWebSecurity
 public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**");
	}
}

 ````
 
 ## Validação de Email
 
 ### Annotation
 ```java
 import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UserInsertValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface UserInsertValid {
	String message() default "Validation error";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
 ``````
 
 ### Validator
 
```java
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.devsuperior.dscatalog.dto.UserInsertDTO;
import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.repositories.UserRepository;
import com.devsuperior.dscatalog.resources.exceptions.FieldMessage;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {
	
	@Override
	public void initialize(UserInsertValid ann) {
	}

	@Override
	public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		// Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}

````

## Passo a Passo para implementar o token
 ### Spring Security
 #### 1. interface que devem ser implementadas
 - UserDetails
 - UserDetailsService

#### 2. Classe para cofiguração de segurança web
- WebSecurityConfigurerAdapter

#### 3. Bean Para efetuar autenticação
- AuthenticationManager

### Spring Cloud OAuth2

#### 1. Beans para implementar o padrão Jwt

- JwtAccesTokenConverter
- JwtTokenStore

#### 2. Classe de cofiguração para Authorization Server
- AuthozizationServerConfigurerAdapter

#### 3. Classe de configuração para Resource Server
- ResourceServerConfigurerAdapter


## Dependências Maven

````java
        <properties>
		<java.version>11</java.version>
		<spring-cloud.version>Hoxton.SR8</spring-cloud.version>
	</properties>
	<dependencies>
		<dependency>
	         <groupId>org.springframework.boot</groupId>
	         <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
	          <groupId>org.springframework.boot</groupId>
	          <artifactId>spring-boot-starter-data-jpa</artifactId>
         </dependency>

        <dependency>
	         <groupId>com.h2database</groupId>
	         <artifactId>h2</artifactId>
	         <scope>runtime</scope>
         </dependency>

        <dependency>
	        <groupId>org.postgresql</groupId>
	        <artifactId>postgresql</artifactId>
	        <scope>runtime</scope>
        </dependency>

        <dependency>
	        <groupId>org.springframework.boot</groupId>
	        <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <dependency>
	        <groupId>org.springframework.boot</groupId>
	        <artifactId>spring-boot-starter-test</artifactId>
	        <scope>test</scope>
        </dependency>
        <dependency>
		<groupId>org.springframework.security</groupId>
		<artifactId>spring-security-test</artifactId>
		<scope>test</scope>
	</dependency>

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-security</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.security.oauth.boot</groupId>
		<artifactId>spring-security-oauth2-autoconfigure</artifactId>
	</dependency>
	</dependencies>
	
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
	<dependencyManagement>
	   <dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

````

## Beans para token JWT, Spring Cloud OAuth2
````java
@Bean
public JwtAccessTokenConverter accessTokenConverter() {
	JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
	tokenConverter.setSigningKey("MY-JWT-SECRET");
	return tokenConverter;
}

@Bean
public JwtTokenStore tokenStore() {
	return new JwtTokenStore(accessTokenConverter());
}

````

## Variáveis de ambiente básicas depois de adicionar segurança

### application.properties
````
spring.profiles.active=${APP_PROFILE:test}

spring.jpa.open-in-view=false

security.oauth2.client.client-id=${CLIENT_ID:dscatalog}
security.oauth2.client.client-secret=${CLIENT_SECRET:dscatalog123}

jwt.secret=${JWT_SECRET:MY-JWT-SECRET}
jwt.duration=${JWT_DURATION:86400}

````

## Deixando o Postman top

### Variáveis:

- host: http://localhost:8080
- client-id: dscatalog
- client-secret: dscatalog123
- username: leia@gmail.com
- password: 123456
- token:

### Script para atribuir token à variável de ambiente do Postman:

#### test

````java
if (responseCode.code >= 200 && responseCode.code < 300) {
    var json = JSON.parse(responseBody);
    postman.setEnvironmentVariable('token', json.access_token);
}

````


 
      
Daniel Benedito da Silva

Email: danielbenedito263@gmail.com
