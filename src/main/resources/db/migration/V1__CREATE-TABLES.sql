CREATE TABLE IF NOT EXISTS condutor(

    idCondutor BIGINT(20) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL

    PRIMARY KEY(idCondutor));

CREATE TABLE IF NOT EXISTS veiculo(

    idVeiculo BIGINT(20) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    placa VARCHAR(20) NOT NULL,
    ufPlaca VARCHAR(2) NOT NULL,
    renavan INT(20) NOT NULL,
    dataAqusicao DATE,

    PRIMARY KEY(idVeiculo),
    FOREIGN KEY(idCondutor) REFERENCES condutor(idCondutor));