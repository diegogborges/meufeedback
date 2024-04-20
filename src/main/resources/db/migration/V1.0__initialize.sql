SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema meufeedback
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `meufeedback` DEFAULT CHARACTER SET utf8 ;
USE `meufeedback` ;

-- -----------------------------------------------------
-- Table `meufeedback`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meufeedback`.`user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meufeedback`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meufeedback`.`company` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meufeedback`.`feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meufeedback`.`feedback` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `company_id` bigint NOT NULL,
  `name` VARCHAR(255) NULL,
  `description` VARCHAR(255) NULL,
  `slug` VARCHAR(15) NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`, `company_id`),
  INDEX `fk_feedback_company_idx` (`company_id` ASC) VISIBLE,
  CONSTRAINT `fk_feedback_company`
    FOREIGN KEY (`company_id`)
    REFERENCES `meufeedback`.`company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meufeedback`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meufeedback`.`question` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `feedback_id` bigint NOT NULL,
  `description` VARCHAR(255) NULL,
  `help` VARCHAR(255) NULL,
  `status` int(1) DEFAULT 1 NOT NULL,
  `sequence` INT NOT NULL,
  `open_response` int(1) DEFAULT 1 NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`, `feedback_id`),
  INDEX `fk_question_feedback_idx` (`feedback_id` ASC) VISIBLE,
  CONSTRAINT `fk_question_feedback`
    FOREIGN KEY (`feedback_id`)
    REFERENCES `meufeedback`.`feedback` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meufeedback`.`response`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meufeedback`.`response` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `question_id` bigint NOT NULL,
  `description` VARCHAR(255) NULL,
  `help` VARCHAR(255) NULL,
  `status` int(1) DEFAULT 1 NOT NULL,
  `sequence` INT NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`, `question_id`),
  INDEX `fk_response_question_idx` (`question_id` ASC) VISIBLE,
  CONSTRAINT `fk_response_question`
    FOREIGN KEY (`question_id`)
    REFERENCES `meufeedback`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meufeedback`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meufeedback`.`customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meufeedback`.`assessment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meufeedback`.`assessment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `feedback_id` bigint NOT NULL,
  `customer_id` bigint NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`, `feedback_id`, `customer_id`),
  INDEX `fk_assessment_feedback_idx` (`feedback_id` ASC) VISIBLE,
  INDEX `fk_assessment_customer_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_assessment_feedback`
    FOREIGN KEY (`feedback_id`)
    REFERENCES `meufeedback`.`feedback` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_assessment_customer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `meufeedback`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meufeedback`.`company_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meufeedback`.`company_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `company_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`, `company_id`, `user_id`),
  INDEX `fk_company_has_user_user_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_company_has_user_company_idx` (`company_id` ASC) VISIBLE,
  CONSTRAINT `fk_company_has_user_company`
    FOREIGN KEY (`company_id`)
    REFERENCES `meufeedback`.`company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_company_has_user_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `meufeedback`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `meufeedback`.`marked_response`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meufeedback`.`marked_response` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `question_id` bigint NOT NULL,
  `assessment_id` bigint NOT NULL,
  `open_response` VARCHAR(255) NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`, `question_id`, `assessment_id`),
  INDEX `fk_markedResponse_assessment_idx` (`assessment_id` ASC) VISIBLE,
  CONSTRAINT `fk_markedResponse_question`
    FOREIGN KEY (`question_id`)
    REFERENCES `meufeedback`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_markedResponse_assessment`
    FOREIGN KEY (`assessment_id`)
    REFERENCES `meufeedback`.`assessment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
