CREATE TABLE db_address.tb_address (
  cep VARCHAR(255) NOT NULL,
   logradouro VARCHAR(255) NOT NULL,
   complemento VARCHAR(255),
   bairro VARCHAR(255),
   localidade VARCHAR(255) NOT NULL,
   uf VARCHAR(255) NOT NULL,
   ibge VARCHAR(255),
   gia VARCHAR(255),
   ddd VARCHAR(255) NOT NULL,
   siafi VARCHAR(255),
   CONSTRAINT pk_tb_address PRIMARY KEY (cep)
);