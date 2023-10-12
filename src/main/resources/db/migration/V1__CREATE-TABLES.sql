CREATE TABLE IF NOT EXISTS tb_veiculo(

    idVeiculo BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    placa VARCHAR(20) NOT NULL,
    ufPlaca VARCHAR(2) NOT NULL,
    renavan INT(20) NOT NULL,
    dataAqusicao DATE,

    PRIMARY KEY(idVeiculo));

CREATE TABLE IF NOT EXISTS tb_condutor(

    idCondutor BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    idVeiculo BIGINT NOT NULL,

    PRIMARY KEY(idCondutor),
    FOREIGN KEY(idVeiculo) REFERENCES tb_veiculo(idVeiculo));