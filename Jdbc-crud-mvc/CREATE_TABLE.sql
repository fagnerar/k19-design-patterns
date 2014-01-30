-- DROP
DROP SEQUENCE w_sq_aluno;
DROP TABLE w_tb_aluno cascade constraints;

-- CREATE
CREATE TABLE w_tb_aluno 
(
  id_aluno INTEGER        NOT NULL,
  rm       INTEGER        NOT NULL,
  nome     VARCHAR2(100)  NOT NULL,
  turma    VARCHAR2(5)    NOT NULL,
  ano      INTEGER        NOT NULL,
  ativo    NUMBER(1)      DEFAULT 0 NOT NULL,
  CONSTRAINT pk_aluno PRIMARY KEY (id_aluno)
) SEGMENT CREATION IMMEDIATE;

CREATE SEQUENCE w_sq_aluno INCREMENT BY 1 START WITH 1 NOCYCLE ORDER;

SELECT * FROM w_tb_aluno; 
SELECT nome FROM W_TB_ALUNO WHERE ID_ALUNO = 1;
INSERT INTO W_TB_ALUNO (id_aluno, rm, nome, turma, ano, ativo) values (w_sq_aluno.nextval, 69699, 'FagnerR', 'TDS-U', 2014, 0);
