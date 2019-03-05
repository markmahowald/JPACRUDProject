-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tripdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tripdb` ;

-- -----------------------------------------------------
-- Schema tripdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tripdb` DEFAULT CHARACTER SET utf8 ;
USE `tripdb` ;

-- -----------------------------------------------------
-- Table `trip`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trip` ;

CREATE TABLE IF NOT EXISTS `trip` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `miles` INT NOT NULL,
  `driver` VARCHAR(100) NOT NULL,
  `gas_added` DOUBLE NULL DEFAULT 0,
  `stops` INT NULL DEFAULT 1,
  `passengers` TINYINT UNSIGNED NOT NULL DEFAULT 0,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS tripuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'tripuser'@'localhost' IDENTIFIED BY 'tripuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'tripuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `trip`
-- -----------------------------------------------------
START TRANSACTION;
USE `tripdb`;
INSERT INTO `trip` (`id`, `date`, `miles`, `driver`, `gas_added`, `stops`, `passengers`, `description`) VALUES (1, '2019-3-3', 25, 'mark', 1.5, 2, 1, 'crusing around');
INSERT INTO `trip` (`id`, `date`, `miles`, `driver`, `gas_added`, `stops`, `passengers`, `description`) VALUES (2, '2019-3-5', 35, 'sara', 0, 0, 0, 'commute to work');
INSERT INTO `trip` (`id`, `date`, `miles`, `driver`, `gas_added`, `stops`, `passengers`, `description`) VALUES (3, '2019-3-7', 7, 'mark', 0, 1, 0, 'store');
INSERT INTO `trip` (`id`, `date`, `miles`, `driver`, `gas_added`, `stops`, `passengers`, `description`) VALUES (4, '2019-3-7', 60, 'matt', 10, 4, 8, 'PARTY!!!');
INSERT INTO `trip` (`id`, `date`, `miles`, `driver`, `gas_added`, `stops`, `passengers`, `description`) VALUES (5, '2019-4-1', 5, 'sara', 0, 0, 0, 'picking car up from impound');

COMMIT;

