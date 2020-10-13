-- MySQL dump 10.13  Distrib 5.5.39, for Win32 (x86)
--
-- Host: localhost    Database: facturacion
-- ------------------------------------------------------
-- Server version	5.5.39

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (6,'Juan','Sanchez','juan@mail.com'),(7,'Sebastian','Pidoni','seba@mail.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle`
--

DROP TABLE IF EXISTS `detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL,
  `factura_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_producto` (`producto_id`),
  KEY `fk_factura` (`factura_id`),
  CONSTRAINT `fk_factura` FOREIGN KEY (`factura_id`) REFERENCES `factura` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle`
--

LOCK TABLES `detalle` WRITE;
/*!40000 ALTER TABLE `detalle` DISABLE KEYS */;
INSERT INTO `detalle` VALUES (6,2,6,6),(7,1,7,6),(8,1,8,7),(9,3,6,8),(10,4,7,8),(11,10,8,8),(12,20,6,9),(13,30,6,10),(14,40,7,10),(15,30,6,11),(16,40,7,11),(17,30,6,12),(18,40,7,12),(51,2,6,42),(52,1,7,42),(53,2,6,43),(54,1,6,44),(55,2,6,45),(56,6,6,46),(58,1,7,48),(59,1,7,49),(60,1,7,50),(61,1,7,51),(62,5,8,51),(63,9,7,53),(64,9,7,57),(65,9,7,58),(66,9,7,59),(67,9,7,60),(68,3,8,60),(69,30,6,61),(70,40,7,61),(71,30,6,62),(72,40,7,62),(73,30,6,63),(74,40,7,63),(75,30,6,64),(76,40,7,64);
/*!40000 ALTER TABLE `detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `folio` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `observacion` varchar(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `cliente_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cliente` (`cliente_id`),
  CONSTRAINT `fk_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (6,10001,'Ticket Factura A','Consumidor Final','2019-06-06',6),(7,10002,'Ticket Factura A','Consumidor Final','2019-06-06',7),(8,10003,'Ticket Factura','Consumidor Final','2019-06-06',6),(9,55001,'Fatura B','','2019-06-30',6),(10,55001,'Fatura B','','2019-06-30',6),(11,55001,'Fatura A','RI','2019-06-30',7),(12,55001,'Prueba clase','RI','2019-07-01',7),(42,10002,'Super Factura','Se observa que,...','2019-07-19',6),(43,2000,'Factura nueva','Se observa que,...','2019-07-27',6),(44,30000,'string','string','2019-07-28',6),(45,111110,'string','string','2019-07-29',7),(46,50000,'Super Factura','Se observa que,...','2019-07-31',6),(48,22222,'string','string','2019-09-12',7),(49,22222,'string','string','2019-09-12',7),(50,22223,'string','string','2019-09-12',7),(51,22223,'string','string','2019-09-12',7),(53,999,'string','string','2019-09-12',7),(57,999,'string','string','2019-09-12',7),(58,999,'string','string','2019-09-12',7),(59,999,'string','string','2019-09-12',7),(60,555,'string','string','2019-09-12',7),(61,55001,'Fatura B','Consumidor Final','2020-09-19',6),(62,55001,'Fatura B','Consumidor Final','2020-09-19',6),(63,55001,'Fatura B','Consumidor Final','2020-09-19',6),(64,55001,'Fatura B','Consumidor Final','2020-09-19',6),(65,55001,'Fatura B','Consumidor Final','2020-09-24',6),(66,55001,'Fatura B','Consumidor Final','2020-09-24',6);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (6,'Monitor Dell',3500),(7,'Teclado Logitech',1200),(8,'Notebook Dell',25000);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'facturacion'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-12 21:32:56
