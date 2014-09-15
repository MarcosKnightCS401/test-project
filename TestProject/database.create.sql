DROP DATABASE candidateTest;

CREATE DATABASE candidateTest;

CREATE TABLE candidateTest.customer (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE candidateTest.account (
	id INT NOT NULL AUTO_INCREMENT,
	customer_id INT NOT NULL,
	balance DECIMAL(10,2) NOT NULL DEFAULT 0,
	createDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	PRIMARY KEY (id),
	INDEX c_id (customer_id),
	FOREIGN KEY (customer_id) REFERENCES candidateTest.customer(id)
		ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB;

INSERT INTO candidateTest.customer (name) VALUES ('Joshua');
INSERT INTO candidateTest.customer (name) VALUES ('Julien');
INSERT INTO candidateTest.customer (name) VALUES ('Darshana');
INSERT INTO candidateTest.customer (name) VALUES ('Rajesh');

INSERT INTO candidateTest.account (customer_id, balance, createDate, updateDate) VALUES ('1', 20000, '2011-10-31 15:25:00', '2011-12-31 15:25:00');
INSERT INTO candidateTest.account (customer_id, balance, createDate, updateDate) VALUES ('2', 250, '2011-10-31 15:25:00', '2011-12-31 15:25:00');
INSERT INTO candidateTest.account (customer_id, balance, createDate, updateDate) VALUES ('3', 39322, '2011-10-31 15:25:00', '2011-12-31 15:25:00');
INSERT INTO candidateTest.account (customer_id, balance, createDate, updateDate) VALUES ('4', 293.23, '2011-10-31 15:25:00', '2011-12-31 15:25:00');
INSERT INTO candidateTest.account (customer_id, balance, createDate, updateDate) VALUES ('1', 293123.12, '2011-10-31 15:25:00', '2011-12-31 15:25:00');
