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
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idusuarios` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sobrenome` varchar(45) DEFAULT NULL,
  `setor` int(11) DEFAULT NULL,
  `funcao` int(11) DEFAULT NULL,
  `datanascimento` date DEFAULT NULL,
  `datacadastro` datetime DEFAULT NULL,
  `cadastrador` int(11) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `matricula` varchar(45) DEFAULT NULL,
  `usuario` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `permissao` int(11) NOT NULL,
  `ativarconta` int(11) DEFAULT NULL,
  PRIMARY KEY (`idusuarios`),
  KEY `fk_idx` (`permissao`),
  KEY `fk_usuarios_usuarios_idx` (`cadastrador`),
  KEY `fk_usuarios_setor_idx` (`setor`),
  KEY `fk_usuarios_fncao_idx` (`funcao`),
  KEY `fk_usuarios_ativarconta_idx` (`ativarconta`),
  CONSTRAINT `fk_usuarios_ativarconta` FOREIGN KEY (`ativarconta`) REFERENCES `ativarconta` (`idativarconta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_fncao` FOREIGN KEY (`funcao`) REFERENCES `funcao` (`idfuncao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_permissoes` FOREIGN KEY (`permissao`) REFERENCES `permissoes` (`idpermissao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_setor` FOREIGN KEY (`setor`) REFERENCES `setor` (`idsetor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_usuarios` FOREIGN KEY (`cadastrador`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Administrador',NULL,1,4,NULL,NULL,1,NULL,NULL,'admim','admin',3,2),(2,'Uhelber','Lima da Costa',2,4,'1976-10-08',NULL,2,'(83)8878-4548','1234562','uhelber','lcosta',3,2);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-19 10:25:49
