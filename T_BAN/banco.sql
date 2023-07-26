CREATE TABLE cliente (
	cpf varchar(11) NOT NULL,
	nome varchar(60),
	rua varchar(20),
	bairro varchar(20),
	numero integer,
	telefone varchar(20),
	PRIMARY KEY (cpf)
);


CREATE TABLE conta (
	numConta SERIAL NOT NULL,
	saldo float,
	cpf varchar(11),
	PRIMARY KEY (numConta),
	FOREIGN KEY (cpf) REFERENCES cliente(cpf)
	-- FOREIGN KEY idAgencia REFERENCES agencia
);

-- Uma opção para inserir novas tuplas da primeira tabela
INSERT INTO cliente (cpf, nome, rua, bairro, numero, telefone) VALUES ('13389598091','debora','Paulo M','Bom Retiro',120,99775522);
INSERT INTO cliente (cpf, nome, rua, bairro, numero, telefone) VALUES ('12260007960','monique','123','Bom Retiro',900,99445527);

-- Uma opção para inserir novas tuplas da segunda tabela
INSERT INTO conta (saldo, cpf) VALUES (1000,'12789507961');
INSERT INTO conta (saldo, cpf) VALUES (1000,'12260007960');

SELECT * from cliente
SELECT * FROM conta
  
DELETE FROM conta WHERE numConta = 1;
UPDATE conta SET saldo = 2000 where numConta = 1;

SELECT nome FROM cliente JOIN conta ON cliente.cpf = conta.cpf WHERE saldo > 1500;
SELECT COUNT(*) FROM conta;

DROP TABLE conta;
DROP TABLE cliente;
DROP SEQUENCE numConta;
