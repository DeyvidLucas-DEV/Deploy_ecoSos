BEGIN

    EXECUTE IMMEDIATE 'DROP TABLE ' || 'COMENTARIO';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN
            RAISE;
        END IF;
END;

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE ' || 'OCORRENCIA';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN
            RAISE;
        END IF;
END;

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE ' || 'USUARIO_CARGO';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN
            RAISE;
        END IF;
END;

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE ' || 'USUARIO';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN
            RAISE;
        END IF;
END;

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE ' || 'CARGO';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN
            RAISE;
        END IF;
END;

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE ' || 'ENDERECO';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN
            RAISE;
        END IF;
END;

BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'SEQ_COMENTARIO';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -2289 THEN
            RAISE;
        END IF;
END;

BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'SEQ_OCORRENCIA';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -2289 THEN
            RAISE;
        END IF;
END;

BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'SEQ_USUARIO';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -2289 THEN
            RAISE;
        END IF;
END;

BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'SEQ_CARGO';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -2289 THEN
            RAISE;
        END IF;
END;

BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'SEQ_ENDERECO';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -2289 THEN
            RAISE;
        END IF;
END;


CREATE TABLE ENDERECO (
                          ID_ENDERECO NUMBER(38,0) NOT NULL,
                          ESTADO VARCHAR2(2) NOT NULL,
                          CIDADE VARCHAR2(50) NOT NULL,
                          BAIRRO VARCHAR2(50) NOT NULL,
                          CEP VARCHAR2(9) UNIQUE NOT NULL,
                          PRIMARY KEY (ID_ENDERECO)
);

CREATE SEQUENCE SEQ_ENDERECO
    START WITH     1
    INCREMENT BY   1
    NOCACHE
    NOCYCLE;

INSERT INTO ENDERECO (ID_ENDERECO, ESTADO, CIDADE, BAIRRO, CEP) VALUES (
                                                                           SEQ_ENDERECO.nextval, 'SC', 'Urussanga', 'Centro', '88840-000');

INSERT INTO ENDERECO (ID_ENDERECO, ESTADO, CIDADE, BAIRRO, CEP) VALUES (
                                                                           SEQ_ENDERECO.nextval, 'PR', 'Curitiba', 'Centro', '58413-000');

INSERT INTO ENDERECO (ID_ENDERECO, ESTADO, CIDADE, BAIRRO, CEP) VALUES (
                                                                           SEQ_ENDERECO.nextval, 'RS', 'Porto Alegre', 'Bairro 2', '69851-000');

INSERT INTO ENDERECO (ID_ENDERECO, ESTADO, CIDADE, BAIRRO, CEP) VALUES (
                                                                           SEQ_ENDERECO.nextval, 'SC', 'Criciúma', 'Centro', '88800-000');

INSERT INTO ENDERECO (ID_ENDERECO, ESTADO, CIDADE, BAIRRO, CEP) VALUES (
                                                                           SEQ_ENDERECO.nextval, 'PR', 'Londrina', 'Bairro 3', '58000-000');


CREATE TABLE USUARIO (
                         ID_USUARIO NUMBER(38, 0) NOT NULL,
                         ID_ENDERECO NUMBER(38, 0) NOT NULL,
                         NOME VARCHAR2(100) NOT NULL,
                         TELEFONE VARCHAR2(11) UNIQUE NOT NULL,
                         EMAIL VARCHAR2(100) UNIQUE NOT NULL,
                         SENHA VARCHAR2(200) NOT NULL,
                         CRIADO_EM TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL,
                         ATUALIZADO_EM TIMESTAMP,
                         PRIMARY KEY (ID_USUARIO),
                         CONSTRAINT FK_ENDERECO_USUARIO FOREIGN KEY (ID_ENDERECO) REFERENCES ENDERECO (ID_ENDERECO)
);

CREATE SEQUENCE seq_usuario
    START WITH     1
    INCREMENT BY   1
    NOCACHE
    NOCYCLE;

CREATE TABLE CARGO (
                       ID_CARGO NUMBER NOT NULL,
                       NOME varchar2(512) UNIQUE NOT NULL,
                       PRIMARY KEY(ID_CARGO)
);

CREATE SEQUENCE seq_cargo
    START WITH     1
    INCREMENT BY   1
    NOCACHE
    NOCYCLE;

INSERT INTO CARGO (ID_CARGO, NOME)
VALUES (seq_cargo.nextval, 'ROLE_ADMIN'); -- 1

INSERT INTO CARGO (ID_CARGO, NOME)
VALUES (seq_cargo.nextval, 'ROLE_USUARIO'); -- 2


CREATE TABLE USUARIO_CARGO (
                               ID_USUARIO NUMBER NOT NULL,
                               ID_CARGO NUMBER NOT NULL,
                               PRIMARY KEY(ID_USUARIO, ID_CARGO),
                               CONSTRAINT FK_USUARIO_CARGO_CARGO FOREIGN KEY (ID_CARGO) REFERENCES CARGO (ID_CARGO),
                               CONSTRAINT FK_USUARIO_CARGO_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO (ID_USUARIO)
);

INSERT INTO USUARIO (ID_USUARIO, ID_ENDERECO, NOME,
                     TELEFONE, EMAIL, SENHA)
VALUES (SEQ_USUARIO.nextval, 1, 'Bulma', '987654321', 'bulma@dbccompany.com.br',
        '{vyToxGAQb3kjDmuXgYgX/juoX1Lpf69z0gVQ8aMjk3k=}f06a2f6245e4f25805d8b0ad1596c0dc');

INSERT INTO USUARIO (ID_USUARIO, ID_ENDERECO, NOME,
                     TELEFONE, EMAIL, SENHA)
VALUES (SEQ_USUARIO.nextval, 2, 'Gohan', '987123456', 'gohan@dbccompany.com.br',
        '{vyToxGAQb3kjDmuXgYgX/juoX1Lpf69z0gVQ8aMjk3k=}f06a2f6245e4f25805d8b0ad1596c0dc');

INSERT INTO USUARIO (ID_USUARIO, ID_ENDERECO, NOME,
                     TELEFONE, EMAIL, SENHA)
VALUES (SEQ_USUARIO.nextval, 2, 'Goku', '987789456', 'goku@dbccompany.com.br',
        '{vyToxGAQb3kjDmuXgYgX/juoX1Lpf69z0gVQ8aMjk3k=}f06a2f6245e4f25805d8b0ad1596c0dc');

INSERT INTO USUARIO (ID_USUARIO, ID_ENDERECO, NOME,
                     TELEFONE, EMAIL, SENHA)
VALUES (SEQ_USUARIO.nextval, 3, 'Krillin', '987456123', 'krillin@dbccompany.com.br',
        '{vyToxGAQb3kjDmuXgYgX/juoX1Lpf69z0gVQ8aMjk3k=}f06a2f6245e4f25805d8b0ad1596c0dc');

INSERT INTO USUARIO (ID_USUARIO, ID_ENDERECO, NOME,
                     TELEFONE, EMAIL, SENHA)
VALUES (SEQ_USUARIO.nextval, 1, 'Vegeta', '987123789', 'vegeta@dbccompany.com.br',
        '{vyToxGAQb3kjDmuXgYgX/juoX1Lpf69z0gVQ8aMjk3k=}f06a2f6245e4f25805d8b0ad1596c0dc');


-- BULMA / ADMIN
INSERT INTO USUARIO_CARGO (ID_USUARIO, ID_CARGO)
VALUES (1,1);

-- GOHAN / USUARIO
INSERT INTO USUARIO_CARGO (ID_USUARIO, ID_CARGO)
VALUES (2,2);

-- GOKU / ADMIN
INSERT INTO USUARIO_CARGO (ID_USUARIO, ID_CARGO)
VALUES (3,1);

-- KRILLIN / USUARIO
INSERT INTO USUARIO_CARGO (ID_USUARIO, ID_CARGO)
VALUES (4,2);

-- VEGETA / USUARIO
INSERT INTO USUARIO_CARGO (ID_USUARIO, ID_CARGO)
VALUES (5,2);

CREATE TABLE OCORRENCIA (
                            ID_OCORRENCIA NUMBER(38, 0) NOT NULL,
                            ID_ENDERECO NUMBER(38, 0) NOT NULL,
                            ID_USUARIO NUMBER(38, 0) NOT NULL,
                            NOME VARCHAR2(50) NOT NULL,
                            GRAVIDADE NUMBER(38, 0) NOT NULL,
                            DESCRICAO VARCHAR2(255) NOT NULL,
                            TIPO NUMBER(38, 0) NOT NULL,
                            STATUS CHAR(1) DEFAULT '1' CHECK(STATUS IN('0','1')) NOT NULL,
                            CRIADO_EM TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL,
                            ATUALIZADO_EM TIMESTAMP,
                            CONSTRAINT PK_OCORRENCIA PRIMARY KEY (ID_OCORRENCIA),
                            FOREIGN KEY (ID_ENDERECO) REFERENCES ENDERECO (ID_ENDERECO),
                            FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO (ID_USUARIO)
);

CREATE SEQUENCE SEQ_OCORRENCIA
    START WITH     1
    INCREMENT BY   1
    NOCACHE
    NOCYCLE;

INSERT INTO OCORRENCIA (ID_OCORRENCIA, ID_ENDERECO, ID_USUARIO, NOME, GRAVIDADE,
                        DESCRICAO, TIPO, STATUS)
VALUES (SEQ_OCORRENCIA.nextval, 1, 1, 'Incêndio em Urussanga', 2, 'Problema tecnológico na residência de Bulma gerando queimada', 0, '1');

INSERT INTO OCORRENCIA (ID_OCORRENCIA, ID_ENDERECO, ID_USUARIO, NOME, GRAVIDADE,
                        DESCRICAO, TIPO, STATUS)
VALUES (SEQ_OCORRENCIA.nextval, 2, 2, 'Enchente em Curitiba', 1, 'Risco de enchente no Centro de Curitiba', 2, '1');

INSERT INTO OCORRENCIA (ID_OCORRENCIA, ID_ENDERECO, ID_USUARIO, NOME, GRAVIDADE,
                        DESCRICAO, TIPO, STATUS)
VALUES (SEQ_OCORRENCIA.nextval, 3, 3, 'Deslizamento em Porto Alegre', 0, 'Deslizamento de terra no Bairro 2 de Porto Alegre', 3, '1');

INSERT INTO OCORRENCIA (ID_OCORRENCIA, ID_ENDERECO, ID_USUARIO, NOME, GRAVIDADE,
                        DESCRICAO, TIPO, STATUS)
VALUES (SEQ_OCORRENCIA.nextval, 4, 4, 'Incidente em Criciúma', 2, 'Terremoto', 1, '1');

INSERT INTO OCORRENCIA (ID_OCORRENCIA, ID_ENDERECO, ID_USUARIO, NOME, GRAVIDADE,
                        DESCRICAO, TIPO, STATUS)
VALUES (SEQ_OCORRENCIA.nextval, 5, 5, 'Inundação em Londrina', 1, 'Área inundada próximo à Centro da cidade', 2, '1');


CREATE TABLE COMENTARIO (
                            ID_COMENTARIO NUMBER(38, 0) NOT NULL,
                            ID_USUARIO NUMBER(38, 0) NOT NULL,
                            ID_OCORRENCIA NUMBER NOT NULL ,
                            CONTEUDO VARCHAR2(500) NOT NULL,
                            CRIADO_EM TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL,
                            ATUALIZADO_EM TIMESTAMP,
                            CONSTRAINT PK_COMENTARIO PRIMARY KEY (ID_COMENTARIO),
                            CONSTRAINT FK_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO),
                            CONSTRAINT FK_COMENTARIOS_OCORRENCIA FOREIGN KEY (ID_OCORRENCIA) REFERENCES OCORRENCIA(ID_OCORRENCIA)
);

CREATE SEQUENCE SEQ_COMENTARIO
    START WITH     1
    INCREMENT BY   1
    NOCACHE
    NOCYCLE;


INSERT INTO COMENTARIO (ID_COMENTARIO, ID_USUARIO, ID_OCORRENCIA, CONTEUDO) VALUES (
                                                                                       SEQ_COMENTARIO.nextval, 3, 1, 'Situação crítica, precisamos de ajuda!');

INSERT INTO COMENTARIO (ID_COMENTARIO, ID_USUARIO, ID_OCORRENCIA, CONTEUDO) VALUES (
                                                                                       SEQ_COMENTARIO.nextval, 5, 1, 'O príncipe dos Sayajins está a caminho kakaroto!');

INSERT INTO COMENTARIO (ID_COMENTARIO, ID_USUARIO, ID_OCORRENCIA, CONTEUDO) VALUES (
                                                                                       SEQ_COMENTARIO.nextval, 1, 2, 'Vou avaliar a situação e agir de acordo.');

INSERT INTO COMENTARIO (ID_COMENTARIO, ID_USUARIO, ID_OCORRENCIA, CONTEUDO) VALUES (
                                                                                       SEQ_COMENTARIO.nextval, 4, 3, 'Precisamos resolver isso logo!');

INSERT INTO COMENTARIO (ID_COMENTARIO, ID_USUARIO, ID_OCORRENCIA, CONTEUDO) VALUES (
                                                                                       SEQ_COMENTARIO.nextval, 2, 5, 'Estou tentando ajudar na evacuação.');


