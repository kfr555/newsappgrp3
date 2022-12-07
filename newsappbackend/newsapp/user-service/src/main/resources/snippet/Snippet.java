package snippet;

public class Snippet {
	spring:
	  datasource:
	    url: ${MYSQL_CI_URL}
	    username: ${MYSQL_USER}
	    password: ${MYSQL_PASSWORD}
	    driver-class-name: com.mysql.jdbc.Driver
	  jpa:
	    hibernate:
	      ddl-auto: update
	    show-sql: true
	server:
	  port: 8080
}

