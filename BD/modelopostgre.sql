-- MySQL Script generated by MySQL Workbench
-- 05/16/16 23:11:04
-- Model: New Model    Version: 1.0


-- -----------------------------------------------------
-- Table lolaccount
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS lolaccount (
  idlolaccount SERIAL NOT NULL,
  idingame VARCHAR(45) NULL,
  avaliacao INT NULL,
  idTitulo INT NULL,
  PRIMARY KEY (idlolaccount));


-- -----------------------------------------------------
-- Table usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuario (
  idusuario SERIAL NOT NULL,
  lolaccount_idlolaccount INT NOT NULL,
  nome VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  senha VARCHAR(45) NULL,
  PRIMARY KEY (idusuario),
  CONSTRAINT fk_usuario_lolaccount1
    FOREIGN KEY (lolaccount_idlolaccount)
    REFERENCES lolaccount (idlolaccount)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table carteira
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS carteira (
  idcarteira SERIAL NOT NULL,
  valor INT NULL,
  usuario_idusuario INT NOT NULL,
  PRIMARY KEY (idcarteira),
  CONSTRAINT fk_carteira_usuario1
    FOREIGN KEY (usuario_idusuario)
    REFERENCES usuario (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table chat
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS chat (
  idmsg SERIAL NOT NULL,
  message TEXT NULL,
  read INT NULL,
  usuario_idusuario_sender INT NOT NULL,
  usuario_idusuario_receiver INT NOT NULL,
  PRIMARY KEY (idmsg),
  CONSTRAINT fk_chat_usuario
    FOREIGN KEY (usuario_idusuario_sender)
    REFERENCES usuario (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_chat_usuario1
    FOREIGN KEY (usuario_idusuario_receiver)
    REFERENCES usuario (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table titulo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS titulo (
  idtitulo SERIAL NOT NULL,
  nome VARCHAR(45) NULL,
  valor INT NULL,
  PRIMARY KEY (idtitulo));


-- -----------------------------------------------------
-- Table itens
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS itens (
  iditens SERIAL NOT NULL,
  nome VARCHAR(45) NULL,
  efeito VARCHAR(45) NULL,
  valor INT NULL,
  PRIMARY KEY (iditens));


-- -----------------------------------------------------
-- Table contratos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS contratos (
  idcontratos SERIAL NOT NULL,
  valor INT NULL,
  data DATE NULL,
  usuario_idusuario_contratante INT NOT NULL,
  usuario_idusuario_contratado INT NOT NULL,
  PRIMARY KEY (idcontratos),
  CONSTRAINT fk_contratos_usuario1
    FOREIGN KEY (usuario_idusuario_contratante)
    REFERENCES usuario (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_contratos_usuario2
    FOREIGN KEY (usuario_idusuario_contratado)
    REFERENCES usuario (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table itenscomprados
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS itenscomprados (
  iditenscomprados SERIAL NOT NULL,
  quantidade INT NULL,
  carteira_idcarteira INT NOT NULL,
  itens_iditens INT NOT NULL,
  PRIMARY KEY (iditenscomprados),
  CONSTRAINT fk_itenscomprados_carteira1
    FOREIGN KEY (carteira_idcarteira)
    REFERENCES carteira (idcarteira)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_itenscomprados_itens1
    FOREIGN KEY (itens_iditens)
    REFERENCES itens (iditens)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table tituloscomprados
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tituloscomprados (
  idtituloscomprados SERIAL NOT NULL,
  carteira_idcarteira INT NOT NULL,
  titulo_idtitulo INT NOT NULL,
  PRIMARY KEY (idtituloscomprados),
  CONSTRAINT fk_tituloscomprados_carteira1
    FOREIGN KEY (carteira_idcarteira)
    REFERENCES carteira (idcarteira)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tituloscomprados_titulo1
    FOREIGN KEY (titulo_idtitulo)
    REFERENCES titulo (idtitulo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table matchs
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS matchs (
  idmatchs SERIAL NOT NULL,
  data DATE NULL,
  verifyed INT NULL,
  usuario_idusuario_convidado INT NOT NULL,
  usuario_idusuario_convidante INT NOT NULL,
  PRIMARY KEY (idmatchs),
  CONSTRAINT fk_matchs_usuario1
    FOREIGN KEY (usuario_idusuario_convidado)
    REFERENCES usuario (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_matchs_usuario2
    FOREIGN KEY (usuario_idusuario_convidante)
    REFERENCES usuario (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table: message
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS message
(
  idmessage serial NOT NULL,
  message text,
  send integer,
  receive integer,
  idchat integer,
  CONSTRAINT primarykey PRIMARY KEY (idmessage),
  CONSTRAINT idchat FOREIGN KEY (idchat)
      REFERENCES chat (idmsg) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- -----------------------------------------------------
-- Function combo_insert
-- -----------------------------------------------------

CREATE FUNCTION combo_insert (idingame VARCHAR, nome VARCHAR, email VARCHAR, senha VARCHAR)
RETURNS bigint AS $$
  INSERT INTO lolaccount (idingame, avaliacao, idTitulo) VALUES (
    idingame ,
    NULL ,
    NULL
  );

  INSERT INTO usuario (lolaccount_idlolaccount, nome, email, senha) VALUES (
    currval(pg_get_serial_sequence('lolaccount','idlolaccount')),
    nome ,
    email ,
    senha
  );

  INSERT INTO carteira (valor, usuario_idusuario) VALUES (
    NULL,
    currval(pg_get_serial_sequence('usuario','idusuario'))
  );

  SELECT currval(pg_get_serial_sequence('usuario','idusuario'));
$$ LANGUAGE SQL;