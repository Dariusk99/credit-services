
SET PERSIST information_schema_stats_expiry = 0;

CREATE SCHEMA `creditdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci ;

CREATE TABLE `creditdb`.`credit` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `CreditName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_polish_ci;

CREATE SCHEMA `productdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci ;


CREATE TABLE `productdb`.`product` (
  `CreditID` INT NOT NULL,
  `ProductName` VARCHAR(45) NOT NULL,
  `Value` VARCHAR(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_polish_ci;

CREATE SCHEMA `customerdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci ;


CREATE TABLE `customerdb`.`customer` (
  `CreditID` INT NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `Pesel` VARCHAR(45) NOT NULL,
  `Surname` VARCHAR(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_polish_ci;

use creditdb;
