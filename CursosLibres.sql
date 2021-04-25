-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema CursosLibres
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CursosLibres
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CursosLibres` DEFAULT CHARACTER SET utf8 ;
USE `CursosLibres` ;

-- -----------------------------------------------------
-- Table `CursosLibres`.`Logins`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CursosLibres`.`Logins` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `clave` VARCHAR(15) NOT NULL,
  `tipo` INT NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CursosLibres`.`Administradores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CursosLibres`.`Administradores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL,
  `idLogin` INT NOT NULL,
  PRIMARY KEY (`id`, `idLogin`),
  INDEX `fk_Administradores_Usuarios1_idx` (`idLogin` ASC) VISIBLE,
  CONSTRAINT `fk_Administradores_Usuarios1`
    FOREIGN KEY (`idLogin`)
    REFERENCES `CursosLibres`.`Logins` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CursosLibres`.`Profesores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CursosLibres`.`Profesores` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `especialidad` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL,
  `idLogin` INT NOT NULL,
  PRIMARY KEY (`id`, `idLogin`),
  INDEX `fk_Profesores_Usuarios1_idx` (`idLogin` ASC) VISIBLE,
  CONSTRAINT `fk_Profesores_Usuarios1`
    FOREIGN KEY (`idLogin`)
    REFERENCES `CursosLibres`.`Logins` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CursosLibres`.`Estudiantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CursosLibres`.`Estudiantes` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL,
  `idLogin` INT NOT NULL,
  PRIMARY KEY (`id`, `idLogin`),
  INDEX `fk_Estudiantes_Usuarios1_idx` (`idLogin` ASC) VISIBLE,
  CONSTRAINT `fk_Estudiantes_Usuarios1`
    FOREIGN KEY (`idLogin`)
    REFERENCES `CursosLibres`.`Logins` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CursosLibres`.`Cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CursosLibres`.`Cursos` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `tematica` VARCHAR(45) NOT NULL,
  `costo` INT NOT NULL,
  `estado` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CursosLibres`.`Grupos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CursosLibres`.`Grupos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `horario` VARCHAR(45) NOT NULL,
  `idProfesor` INT NOT NULL,
  `codigoCurso` INT NOT NULL,
  PRIMARY KEY (`id`, `idProfesor`, `codigoCurso`),
  INDEX `fk_Grupos_Profesores1_idx` (`idProfesor` ASC) VISIBLE,
  INDEX `fk_Grupos_Cursos1_idx` (`codigoCurso` ASC) VISIBLE,
  CONSTRAINT `fk_Grupos_Profesores1`
    FOREIGN KEY (`idProfesor`)
    REFERENCES `CursosLibres`.`Profesores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Grupos_Cursos1`
    FOREIGN KEY (`codigoCurso`)
    REFERENCES `CursosLibres`.`Cursos` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CursosLibres`.`Matriculas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CursosLibres`.`Matriculas` (
  `idEstudiante` INT NOT NULL,
  `idGrupo` INT NOT NULL,
  `calificacion` INT NULL,
  PRIMARY KEY (`idEstudiante`, `idGrupo`),
  INDEX `fk_Matrículas_Grupos1_idx` (`idGrupo` ASC) VISIBLE,
  CONSTRAINT `fk_Matricula_Estudiantes1`
    FOREIGN KEY (`idEstudiante`)
    REFERENCES `CursosLibres`.`Estudiantes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Matrículas_Grupos1`
    FOREIGN KEY (`idGrupo`)
    REFERENCES `CursosLibres`.`Grupos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
