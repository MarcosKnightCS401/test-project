SET INITIAL SCHEMA candidateTest;
INSERT INTO customer (name) VALUES ('Joshua');
INSERT INTO customer (name) VALUES ('Julien');
INSERT INTO customer (name) VALUES ('Darshana');
INSERT INTO customer (name) VALUES ('Rajesh');

INSERT INTO account (customer_id, balance, createDate, updateDate) VALUES ('1', 20000, '2011-10-31 15:25:00', '2011-12-31 15:25:00');
INSERT INTO account (customer_id, balance, createDate, updateDate) VALUES ('2', 250, '2011-10-31 15:25:00', '2011-12-31 15:25:00');
INSERT INTO account (customer_id, balance, createDate, updateDate) VALUES ('3', 39322, '2011-10-31 15:25:00', '2011-12-31 15:25:00');
INSERT INTO account (customer_id, balance, createDate, updateDate) VALUES ('4', 293.23, '2011-10-31 15:25:00', '2011-12-31 15:25:00');
INSERT INTO account (customer_id, balance, createDate, updateDate) VALUES ('1', 293123.12, '2011-10-31 15:25:00', '2011-12-31 15:25:00');