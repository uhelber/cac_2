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
-- Table structure for table `cidades`
--

DROP TABLE IF EXISTS `cidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cidades` (
  `idcidades` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idcidades`)
) ENGINE=InnoDB AUTO_INCREMENT=224 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidades`
--

LOCK TABLES `cidades` WRITE;
/*!40000 ALTER TABLE `cidades` DISABLE KEYS */;
INSERT INTO `cidades` VALUES (1,'Agua Branca'),(2,'Aguiar'),(3,'Alagoa Grande'),(4,'Alagoa Nova'),(5,'Alagoinha'),(6,'Alcantil'),(7,'Algodao de Jandaira'),(8,'Alhandra'),(9,'Amparo'),(10,'Aparecida'),(11,'Aracagi'),(12,'Arara'),(13,'Araruna'),(14,'Areia de Baraunas'),(15,'Areia'),(16,'Areial'),(17,'Aroeiras'),(18,'Assuncao'),(19,'Baia da Traicao'),(20,'Bananeiras'),(21,'Barauna'),(22,'Barra de Santa Rosa'),(23,'Barra de Santana'),(24,'Barra de Sao Miguel'),(25,'Bayeux'),(26,'Belem do Brejo do Cruz'),(27,'Belem'),(28,'Bernardino Batista'),(29,'Boa Ventura'),(30,'Boa Vista'),(31,'Bom Jesus'),(32,'Bom Sucesso'),(33,'Bonito de Santa Fe'),(34,'Boqueirao'),(35,'Borborema'),(36,'Brejo do Cruz'),(37,'Brejo dos Santos'),(38,'Caapora'),(39,'Cabaceiras'),(40,'Cabedelo'),(41,'Cachoeira dos ?ndios'),(42,'Cacimba de Areia'),(43,'Cacimba de Dentro'),(44,'Cacimbas'),(45,'Caicara'),(46,'Cajazeiras'),(47,'Cajazeirinhas'),(48,'Caldas Brandao'),(49,'Camalau'),(50,'Campina Grande'),(51,'Capim'),(52,'Caraubas'),(53,'Carrapateira'),(54,'Casserengue'),(55,'Catingueira'),(56,'Catole do Rocha'),(57,'Caturite'),(58,'Conceicao'),(59,'Condado'),(60,'Conde'),(61,'Congo'),(62,'Coremas'),(63,'Coxixola'),(64,'Cruz do Espirito Santo'),(65,'Cubati'),(66,'Cuite de Mamanguape'),(67,'Cuite'),(68,'Cuitegi'),(69,'Curral Velho'),(70,'Curral de Cima'),(71,'Damiao'),(72,'Desterro'),(73,'Diamante'),(74,'Dona Ines'),(75,'Duas Estradas'),(76,'Emas'),(77,'Esperanca'),(78,'Fagundes'),(79,'Frei Martinho'),(80,'Gado Bravo'),(81,'Guarabira'),(82,'Gurinhem'),(83,'Gurjao'),(84,'Ibiara'),(85,'Igaracy'),(86,'Imaculada'),(87,'Inga'),(88,'Itabaiana'),(89,'Itaporanga'),(90,'Itapororoca'),(91,'Itatuba'),(92,'Jacarau'),(93,'Jerico'),(94,'Joao Pessoa'),(95,'Juarez Tavora'),(96,'Juazeirinho'),(97,'Junco do Serido'),(98,'Juripiranga'),(99,'Juru'),(100,'Lagoa Seca'),(101,'Lagoa de Dentro'),(102,'Lagoa'),(103,'Lastro'),(104,'Livramento'),(105,'Logradouro'),(106,'Lucena'),(107,'Mae d\'Agua'),(108,'Malta'),(109,'Mamanguape'),(110,'Manaira'),(111,'Marcacao'),(112,'Mari'),(113,'Marizopolis'),(114,'Massaranduba'),(115,'Mataraca'),(116,'Matinhas'),(117,'Mato Grosso'),(118,'Matureia'),(119,'Mogeiro'),(120,'Montadas'),(121,'Monte Horebe'),(122,'Monteiro'),(123,'Mulungu'),(124,'Natuba'),(125,'Nazarezinho'),(126,'Nova Floresta'),(127,'Nova Olinda'),(128,'Nova Palmeira'),(129,'Olho d\'Agua'),(130,'Olivedos'),(131,'Ouro Velho'),(132,'Parari'),(133,'Passagem'),(134,'Patos'),(135,'Paulista'),(136,'Pedra Branca'),(137,'Pedra Lavrada'),(138,'Pedras de Fogo'),(139,'Pedro Regio'),(140,'Pianco'),(141,'Picui'),(142,'Pilar'),(143,'Piloes'),(144,'Piloezinhos'),(145,'Pirpirituba'),(146,'Pitimbu'),(147,'Pocinhos'),(148,'Poco Dantas'),(149,'Poco de Jose de Moura'),(150,'Pombal'),(151,'Prata'),(152,'Princesa Isabel'),(153,'Puxinana'),(154,'Queimadas'),(155,'Quixaba'),(156,'Remigio'),(157,'Riachao do Bacamarte'),(158,'Riachao do Poco'),(159,'Riachao'),(160,'Riacho de Santo Antonio'),(161,'Riacho dos Cavalos'),(162,'Rio Tinto'),(163,'Salgadinho'),(164,'Salgado de Sao Felix'),(165,'Santa Cecilia'),(166,'Santa Cruz'),(167,'Santa Helena'),(168,'Santa Ines'),(169,'Santa Luzia'),(170,'Santa Rita'),(171,'Santa Teresinha'),(172,'Santana de Mangueira'),(173,'Santana dos Garrotes'),(174,'Joca Claudino'),(175,'Santo Andre'),(176,'Sao Bentinho'),(177,'Sao Bento'),(178,'Sao Domingos de Pombal'),(179,'Sao Domingos do Cariri'),(180,'Sao Francisco'),(181,'Sao Joao do Cariri'),(182,'Sao Joao do Rio do Peixe'),(183,'Sao Joao do Tigre'),(184,'Sao Jose da Lagoa Tapada'),(185,'Sao Jose de Caiana'),(186,'Sao Jose de Espinharas'),(187,'Sao Jose de Piranhas'),(188,'Sao Jose de Princesa'),(189,'Sao Jose do Bonfim'),(190,'Sao Jose do Brejo do Cruz'),(191,'Sao Jose do Sabugi'),(192,'Sao Jose dos Cordeiros'),(193,'Sao Jose dos Ramos'),(194,'Sao Mamede'),(195,'Sao Miguel de Taipu'),(196,'Sao Sebastiao de Lagoa de Roca'),(197,'Sao Sebastiao do Umbuzeiro'),(198,'Sape'),(199,'São Vicente do Serido'),(200,'Serra Branca'),(201,'Serra Grande'),(202,'Serra Redonda'),(203,'Serra da Raiz'),(204,'Serraria'),(205,'Sertaozinho'),(206,'Sobrado'),(207,'Solanea'),(208,'Soledade'),(209,'Sossego'),(210,'Sousa'),(211,'Sume'),(212,'Tacima'),(213,'Taperoa'),(214,'Tavares'),(215,'Teixeira'),(216,'Tenorio'),(217,'Triunfo'),(218,'Uirauna'),(219,'Umbuzeiro'),(220,'Varzea'),(221,'Vieiropolis'),(222,'Vista Serrana'),(223,'Zabele');
/*!40000 ALTER TABLE `cidades` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-19 10:25:42
