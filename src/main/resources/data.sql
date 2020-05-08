INSERT INTO tbl_cliente (id_cliente,email,nome) VALUES (cliente_id_sequence.nextval,'samuelmvf@gmail.com', 'Samuel Maia');
INSERT INTO tbl_cliente (id_cliente,email,nome) VALUES (cliente_id_sequence.nextval,'gabriel-eduardo@ultracar.com.br', 'Gabriel Eduardo');
INSERT INTO tbl_cliente (id_cliente,email,nome) VALUES (cliente_id_sequence.nextval,'deanwinchester@supernatural.com', 'Dean Winchester');

INSERT INTO tbl_veiculo (id_veiculo,modelo,montadora,versao,id_cliente) VALUES (veiculo_id_sequence.nextval,'Impala','Chevrolet',1967,3);
INSERT INTO tbl_veiculo (id_veiculo,modelo,montadora,versao,id_cliente) VALUES (veiculo_id_sequence.nextval,'Celica','Toyota',2000,2);
INSERT INTO tbl_veiculo (id_veiculo,modelo,montadora,versao,id_cliente) VALUES (veiculo_id_sequence.nextval,'Supra','Toyota',2000,1);
INSERT INTO tbl_veiculo (id_veiculo,modelo,montadora,versao,id_cliente) VALUES (veiculo_id_sequence.nextval,'Skyline GT-R','Nissan', 2002,2);
INSERT INTO tbl_veiculo (id_veiculo,modelo,montadora,versao,id_cliente) VALUES (veiculo_id_sequence.nextval,'Carrera GT','Porsche',2004,1);
INSERT INTO tbl_veiculo (id_veiculo,modelo,montadora,versao,id_cliente) VALUES (veiculo_id_sequence.nextval,'Murciélago','Lamborghini',2004,2);