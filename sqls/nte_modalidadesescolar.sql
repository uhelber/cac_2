CREATE DATABASE  IF NOT EXISTS `nte` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `nte`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: nte
-- ------------------------------------------------------
-- Server version	5.5.28-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `modalidadesescolar`
--

DROP TABLE IF EXISTS `modalidadesescolar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modalidadesescolar` (
  `idmodalidadeescolar` int(11) NOT NULL AUTO_INCREMENT,
  `escola` int(11) DEFAULT NULL,
  `modalidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmodalidadeescolar`),
  KEY `fk_modalidadesescolare_escola_idx` (`escola`),
  KEY `fk_modalidadesescolar_modalidades_idx` (`modalidade`),
  CONSTRAINT `fk_modalidadesescolare_escola` FOREIGN KEY (`escola`) REFERENCES `escola` (`idescola`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_modalidadesescolar_modalidades` FOREIGN KEY (`modalidade`) REFERENCES `modalidades` (`idmodalidades`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalidadesescolar`
--

LOCK TABLES `modalidadesescolar` WRITE;
/*!40000 ALTER TABLE `modalidadesescolar` DISABLE KEYS */;
/*!40000 ALTER TABLE `modalidadesescolar` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-19 10:25:44
