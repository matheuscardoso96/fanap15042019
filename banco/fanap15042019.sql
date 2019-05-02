SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `Fanap15042019` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `Fanap15042019` ;

-- -----------------------------------------------------
-- Table `Fanap15042019`.`TipoPessoa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Fanap15042019`.`TipoPessoa` (
  `codigo_tpes` INT NOT NULL AUTO_INCREMENT ,
  `descricao_tpes` VARCHAR(8) NOT NULL ,
  PRIMARY KEY (`codigo_tpes`) ,
  UNIQUE INDEX `descricao_tpes_UNIQUE` (`descricao_tpes` ASC) )
ENGINE = InnoDB
COMMENT = 'Tipo de pessoa';


-- -----------------------------------------------------
-- Table `Fanap15042019`.`Cliente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Fanap15042019`.`Cliente` (
  `codigo_clie` INT NOT NULL AUTO_INCREMENT ,
  `codigo_tpes_clie` INT NOT NULL ,
  `registro_clie` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `nome_razaosocial_clie` VARCHAR(100) NOT NULL ,
  `sobrenome_nomefantasia_clie` VARCHAR(100) NOT NULL ,
  `rg_ie_clie` VARCHAR(25) NOT NULL ,
  `orgao_exp_clie` VARCHAR(8) NOT NULL ,
  `cpf_cnpj_clie` VARCHAR(18) NOT NULL ,
  PRIMARY KEY (`codigo_clie`) ,
  UNIQUE INDEX `cpf_cnpj_clie_UNIQUE` (`cpf_cnpj_clie` ASC) ,
  INDEX `fk_Cliente_TipoPessoa_idx` (`codigo_tpes_clie` ASC) ,
  CONSTRAINT `fk_Cliente_TipoPessoa`
    FOREIGN KEY (`codigo_tpes_clie` )
    REFERENCES `Fanap15042019`.`TipoPessoa` (`codigo_tpes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Cliente';


-- -----------------------------------------------------
-- Table `Fanap15042019`.`TipoEndereco`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Fanap15042019`.`TipoEndereco` (
  `codigo_tend` INT NOT NULL AUTO_INCREMENT ,
  `descricao_tend` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`codigo_tend`) ,
  UNIQUE INDEX `descricao_tend_UNIQUE` (`descricao_tend` ASC) )
ENGINE = InnoDB
COMMENT = 'Tipo de endereço';


-- -----------------------------------------------------
-- Table `Fanap15042019`.`Pais`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Fanap15042019`.`Pais` (
  `codigo_pais` INT NOT NULL ,
  `nome_pais` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`codigo_pais`) ,
  UNIQUE INDEX `nome_pais_UNIQUE` (`nome_pais` ASC) )
ENGINE = InnoDB
COMMENT = 'País';


-- -----------------------------------------------------
-- Table `Fanap15042019`.`Uf`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Fanap15042019`.`Uf` (
  `codigo_ufed` INT NOT NULL AUTO_INCREMENT ,
  `codigo_pais_ufed` INT NOT NULL ,
  `sigla_ufed` VARCHAR(2) NOT NULL ,
  `nome_ufed` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`codigo_ufed`) ,
  UNIQUE INDEX `sigla_ufed_UNIQUE` (`sigla_ufed` ASC) ,
  INDEX `fk_Uf_Pais1_idx` (`codigo_pais_ufed` ASC) ,
  CONSTRAINT `fk_Uf_Pais1`
    FOREIGN KEY (`codigo_pais_ufed` )
    REFERENCES `Fanap15042019`.`Pais` (`codigo_pais` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Unidade Federativa';


-- -----------------------------------------------------
-- Table `Fanap15042019`.`ClienteEndereco`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Fanap15042019`.`ClienteEndereco` (
  `codigo_cend` INT NOT NULL AUTO_INCREMENT ,
  `codigo_clie_cend` INT NOT NULL ,
  `codigo_tend_cend` INT NOT NULL ,
  `codigo_ufed_cend` INT NOT NULL ,
  `logradouro_cend` VARCHAR(50) NOT NULL ,
  `numero_cend` VARCHAR(8) NOT NULL ,
  `complemento_cend` VARCHAR(100) NULL ,
  `bairro_cend` VARCHAR(50) NOT NULL ,
  `cidade_cend` VARCHAR(50) NOT NULL ,
  `cep_cend` VARCHAR(9) NOT NULL ,
  `referencia_cend` TEXT NULL ,
  PRIMARY KEY (`codigo_cend`) ,
  INDEX `fk_ClienteEndereco_TipoEndereco1_idx` (`codigo_tend_cend` ASC) ,
  INDEX `fk_ClienteEndereco_Cliente1_idx` (`codigo_clie_cend` ASC) ,
  INDEX `fk_ClienteEndereco_Uf1_idx` (`codigo_ufed_cend` ASC) ,
  CONSTRAINT `fk_ClienteEndereco_TipoEndereco1`
    FOREIGN KEY (`codigo_tend_cend` )
    REFERENCES `Fanap15042019`.`TipoEndereco` (`codigo_tend` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ClienteEndereco_Cliente1`
    FOREIGN KEY (`codigo_clie_cend` )
    REFERENCES `Fanap15042019`.`Cliente` (`codigo_clie` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ClienteEndereco_Uf1`
    FOREIGN KEY (`codigo_ufed_cend` )
    REFERENCES `Fanap15042019`.`Uf` (`codigo_ufed` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Endereço do cliente';

USE `Fanap15042019` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Fanap15042019`.`TipoPessoa`
-- -----------------------------------------------------
START TRANSACTION;
USE `Fanap15042019`;
INSERT INTO `Fanap15042019`.`TipoPessoa` (`codigo_tpes`, `descricao_tpes`) VALUES (1, 'FÍSICA');
INSERT INTO `Fanap15042019`.`TipoPessoa` (`codigo_tpes`, `descricao_tpes`) VALUES (2, 'JURÍDICA');

COMMIT;

-- -----------------------------------------------------
-- Data for table `Fanap15042019`.`TipoEndereco`
-- -----------------------------------------------------
START TRANSACTION;
USE `Fanap15042019`;
INSERT INTO `Fanap15042019`.`TipoEndereco` (`codigo_tend`, `descricao_tend`) VALUES (1, 'RESIDENCIAL');
INSERT INTO `Fanap15042019`.`TipoEndereco` (`codigo_tend`, `descricao_tend`) VALUES (2, 'COMERCIAL');
INSERT INTO `Fanap15042019`.`TipoEndereco` (`codigo_tend`, `descricao_tend`) VALUES (3, 'CORRESPONDÊNCIA');
INSERT INTO `Fanap15042019`.`TipoEndereco` (`codigo_tend`, `descricao_tend`) VALUES (4, 'ENTREGA');
INSERT INTO `Fanap15042019`.`TipoEndereco` (`codigo_tend`, `descricao_tend`) VALUES (5, 'RECADO');
INSERT INTO `Fanap15042019`.`TipoEndereco` (`codigo_tend`, `descricao_tend`) VALUES (6, 'OUTRO (S)');

COMMIT;

-- -----------------------------------------------------
-- Data for table `Fanap15042019`.`Pais`
-- -----------------------------------------------------
START TRANSACTION;
USE `Fanap15042019`;
INSERT INTO `Fanap15042019`.`Pais` (`codigo_pais`, `nome_pais`) VALUES (55, 'BRASIL');

COMMIT;

-- -----------------------------------------------------
-- Data for table `Fanap15042019`.`Uf`
-- -----------------------------------------------------
START TRANSACTION;
USE `Fanap15042019`;
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (1, 55, 'AC', 'ACRE');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (2, 55, 'AL', 'ALAGOAS');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (3, 55, 'AP', 'AMAPÁ');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (4, 55, 'AM', 'AMAZONAS');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (5, 55, 'BA', 'BAHIA');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (6, 55, 'CE', 'CEARÁ');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (7, 55, 'DF', 'DISTRITO FEDERAL');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (8, 55, 'ES', 'ESPÍRITO SANTO');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (9, 55, 'GO', 'GOIÁS');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (10, 55, 'MA', 'MARANHÃO');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (11, 55, 'MT', 'MATO GROSSO');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (12, 55, 'MS', 'MATO GROSSO DO SUL');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (13, 55, 'MG', 'MINAS GERAIS');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (14, 55, 'PA', 'PARÁ');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (15, 55, 'PB', 'PARAÍBA');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (16, 55, 'PR', 'PARANÁ');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (17, 55, 'PE', 'PERNAMBUCO');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (18, 55, 'PI', 'PIAUÍ');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (19, 55, 'RJ', 'RIO DE JANEIRO');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (20, 55, 'RN', 'RIO GRANDE DO NORTE');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (21, 55, 'RS', 'RIO GRANDE DO SUL');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (22, 55, 'RO', 'RONDÔNIA');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (23, 55, 'RR', 'RORAIMA');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (24, 55, 'SC', 'SANTA CATARINA');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (25, 55, 'SP', 'SÃO PAULO');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (26, 55, 'SE', 'SERGIPE');
INSERT INTO `Fanap15042019`.`Uf` (`codigo_ufed`, `codigo_pais_ufed`, `sigla_ufed`, `nome_ufed`) VALUES (27, 55, 'TO', 'TOCANTINS');

COMMIT;
