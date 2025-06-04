-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `banco_sa` DEFAULT CHARACTER SET utf8 ;
USE `banco_sa` ;

-- -----------------------------------------------------
-- Table `mydb`.`Professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_sa`.`Professor` (
  `idprofessor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(120) NOT NULL,
  `email` VARCHAR(120) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idprofessor`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_sa`.`Turma` (
  `idturma` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(120) NOT NULL,
  `Professor_idprofessor` INT NOT NULL,
  PRIMARY KEY (`idturma`, `Professor_idprofessor`),
  INDEX `fk_Turma_Professor_idx` (`Professor_idprofessor` ASC),
  CONSTRAINT `fk_Turma_Professor`
    FOREIGN KEY (`Professor_idprofessor`)
    REFERENCES `banco_sa`.`Professor` (`idprofessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Atividade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_sa`.`Atividade` (
  `idatividade` INT NOT NULL,
  `nome` VARCHAR(120) NOT NULL,
  `descricao` VARCHAR(120) NOT NULL,
  `Turma_idturma` INT NOT NULL,
  `Turma_Professor_idprofessor` INT NOT NULL,
  PRIMARY KEY (`idatividade`, `Turma_idturma`, `Turma_Professor_idprofessor`),
  INDEX `fk_Atividade_Turma1_idx` (`Turma_idturma` ASC, `Turma_Professor_idprofessor` ASC),
  CONSTRAINT `fk_Atividade_Turma1`
    FOREIGN KEY (`Turma_idturma` , `Turma_Professor_idprofessor`)
    REFERENCES `banco_sa`.`Turma` (`idturma` , `Professor_idprofessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- INSERT

INSERT INTO Professor(nome , email , senha)
VALUES ("Bruna" , "bruna@gmail.com" , "12345");

INSERT INTO Professor (nome , email , senha)
VALUES ("Vitor" , "vitor@gmail.com" , "54321");


ALTER TABLE `Atividade`
DROP PRIMARY KEY,
ADD PRIMARY KEY (`idatividade`),
MODIFY `idatividade` INT NOT NULL AUTO_INCREMENT;

SHOW CREATE TABLE Atividade;