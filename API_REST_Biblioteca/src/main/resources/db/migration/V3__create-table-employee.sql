CREATE TABLE employee(
	id BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	cpf VARCHAR(100) NOT NULL,
	specialty VARCHAR(100) NOT NULL,
	cep VARCHAR(100) NOT NULL,
	neighborhood VARCHAR(100) NOT NULL,
	city VARCHAR(100) NOT NULL,
	complement VARCHAR(100),
	number VARCHAR(100),
	
PRIMARY KEY(id)
);