/*
SQLyog Community v8.3 
MySQL - 5.1.41-3ubuntu12.7 : Database - inmobiliaria
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`inmobiliaria` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `inmobiliaria`;

/*Table structure for table `barrios` */

DROP TABLE IF EXISTS `barrios`;

CREATE TABLE `barrios` (
  `idBarrios` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `Localidades_idLocalidades` int(11) DEFAULT NULL,
  PRIMARY KEY (`idBarrios`),
  KEY `fk_Barrios_Localidades` (`Localidades_idLocalidades`),
  CONSTRAINT `fk_Barrios_Localidades` FOREIGN KEY (`Localidades_idLocalidades`) REFERENCES `localidades` (`idLocalidades`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

/*Data for the table `barrios` */

insert  into `barrios`(`idBarrios`,`nombre`,`Localidades_idLocalidades`) values (1,'Pueyrredón',1),(2,'Yofre (Sur)',1),(3,'Yofre (Norte)',1),(4,'General Paz',1),(5,'Talleres (Este)',1),(6,'Talleres (Oeste)',1),(7,'Palmar',1),(8,'Junior',1),(9,'Nueva Córdoba',1),(10,'Patricios',1),(11,'Villa Corina',1),(12,'Santa Clara',1),(13,'Nueva Italia',1),(14,'San Jorge',1),(15,'Alta Córdoba',1),(16,'Ampliación América',1),(17,'Empalme',1),(18,'Los Olmos',1),(19,'Parque Capital',1),(20,'Parque Horizonte',1),(21,'Parque Latino',1),(22,'Centro',1),(23,'Los Pinos',1),(24,'Arenales',1),(25,'Parque Monte Cristo',1),(26,'Nueva Italia',1),(27,'Belgrano',14),(28,'Caballito',14),(29,'Núñez',14),(30,'La Boca',14),(31,'Centro',14);

/*Table structure for table `citas` */

DROP TABLE IF EXISTS `citas`;

CREATE TABLE `citas` (
  `idcita` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `Direccion` int(11) DEFAULT NULL,
  `Motivo_Cita` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcita`),
  KEY `fk_Citas_Direccion` (`Direccion`),
  KEY `fk_Citas_Motivo_Cita` (`Motivo_Cita`),
  CONSTRAINT `fk_Citas_Direccion` FOREIGN KEY (`Direccion`) REFERENCES `direccion` (`idDireccion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Citas_Motivo_Cita` FOREIGN KEY (`Motivo_Cita`) REFERENCES `motivo_cita` (`idMotivo_Cita`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `citas` */

insert  into `citas`(`idcita`,`fecha`,`hora`,`Direccion`,`Motivo_Cita`) values (1,'2008-12-18','00:00:55',8,NULL),(2,'2008-12-03','00:00:56',9,NULL),(3,'2008-12-04','11:11:16',11,NULL),(4,'2008-12-12','12:12:59',14,NULL),(5,'2008-12-10','12:30:55',15,NULL),(6,'2008-01-17','12:00:17',18,NULL),(7,'2008-01-17','12:30:22',19,NULL),(8,'2010-08-28','18:05:34',55,NULL),(9,'2010-08-23','18:05:57',56,NULL),(10,'2010-08-24','15:15:55',57,NULL),(11,'2010-08-24','13:23:10',60,1);

/*Table structure for table `clausulas` */

DROP TABLE IF EXISTS `clausulas`;

CREATE TABLE `clausulas` (
  `idClausulas` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text,
  `descripcion` longtext,
  `numero` int(11) DEFAULT NULL,
  PRIMARY KEY (`idClausulas`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `clausulas` */

insert  into `clausulas`(`idClausulas`,`nombre`,`descripcion`,`numero`) values (1,'PRIMERA',NULL,NULL),(2,'SEGUNDA',NULL,NULL),(3,'TERCERA',NULL,NULL);

/*Table structure for table `clausulas_x_contrato` */

DROP TABLE IF EXISTS `clausulas_x_contrato`;

CREATE TABLE `clausulas_x_contrato` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_contrato` int(11) DEFAULT NULL,
  `id_clausula` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_clausulas_x_contrato_1` (`id_clausula`),
  KEY `FK_clausulas_x_contrato_2` (`id_contrato`),
  CONSTRAINT `FK_clausulas_x_contrato_1` FOREIGN KEY (`id_clausula`) REFERENCES `clausulas` (`idClausulas`),
  CONSTRAINT `FK_clausulas_x_contrato_2` FOREIGN KEY (`id_contrato`) REFERENCES `contratos` (`idContratos`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `clausulas_x_contrato` */

insert  into `clausulas_x_contrato`(`id`,`id_contrato`,`id_clausula`) values (1,1,1),(2,1,3),(3,2,2),(4,2,3);

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `Persona_idPersona` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `fk_Cliente_Persona` (`Persona_idPersona`),
  CONSTRAINT `fk_Cliente_Persona` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

insert  into `cliente`(`idCliente`,`Persona_idPersona`) values (1,1),(2,3),(3,7),(4,17),(5,20);

/*Table structure for table `cobro_alquileres` */

DROP TABLE IF EXISTS `cobro_alquileres`;

CREATE TABLE `cobro_alquileres` (
  `idCobro_Alquileres` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_Cobro` date DEFAULT NULL,
  `fecha_Vencimiento` date DEFAULT NULL,
  `monto` float DEFAULT NULL,
  `interes` float DEFAULT NULL,
  `Estado_Cobro` int(11) DEFAULT NULL,
  `Contrato` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCobro_Alquileres`),
  KEY `fk_Cobro_Alquileres_Estado_Cobro` (`Estado_Cobro`),
  KEY `fk_Cobro_Alquileres_Contratos` (`Contrato`),
  CONSTRAINT `fk_Cobro_Alquileres_Contratos` FOREIGN KEY (`Contrato`) REFERENCES `contratos` (`idContratos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cobro_Alquileres_Estado_Cobro` FOREIGN KEY (`Estado_Cobro`) REFERENCES `estado_cobro` (`idEstado_Cobro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

/*Data for the table `cobro_alquileres` */

insert  into `cobro_alquileres`(`idCobro_Alquileres`,`fecha_Cobro`,`fecha_Vencimiento`,`monto`,`interes`,`Estado_Cobro`,`Contrato`) values (1,'2008-09-05','2008-09-05',1000,NULL,2,1),(2,'2008-10-05','2008-10-05',1000,NULL,2,1),(3,'2008-12-01','2008-11-05',1000,NULL,2,1),(4,'2008-12-01','2008-12-05',1000,NULL,2,1),(5,'2009-03-20','2009-01-05',1000,NULL,2,1),(6,'2009-04-16','2009-02-05',1000,NULL,2,1),(7,'2009-04-16','2009-03-05',1000,NULL,2,1),(8,'2009-04-17','2009-04-05',1000,NULL,1,1),(9,'2010-07-28','2009-05-05',1000,NULL,1,1),(10,'2010-07-31','2009-06-05',1000,NULL,1,1),(11,'1900-01-01','2009-07-05',1000,NULL,1,1),(12,'2010-07-31','2010-08-05',1000,NULL,2,1),(13,'2008-09-05','2008-09-05',1000,NULL,2,2),(14,'2008-10-05','2008-10-05',1000,NULL,2,2),(15,'2009-04-07','2008-11-05',1000,NULL,2,2),(16,'2009-04-07','2008-12-05',1000,NULL,1,2),(17,'2009-04-16','2009-02-05',1000,NULL,1,2),(18,'2009-04-16','2009-03-05',1000,NULL,1,2),(19,'2009-04-17','2009-04-05',1000,NULL,1,2),(20,'1900-01-01','2009-05-05',1000,NULL,1,2),(21,'2010-04-13','2009-06-05',1000,NULL,2,2),(22,'2010-07-31','2009-07-05',1000,NULL,2,2),(23,'2010-04-13','2009-08-05',1000,NULL,2,2),(24,'2009-04-16','2009-01-05',1000,NULL,2,2);

/*Table structure for table `contacto` */

DROP TABLE IF EXISTS `contacto`;

CREATE TABLE `contacto` (
  `idContacto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `Tipo_Contacto` int(11) DEFAULT NULL,
  `Persona` int(11) DEFAULT NULL,
  `organizacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idContacto`),
  KEY `fk_Contacto_Tipo_Contacto` (`Tipo_Contacto`),
  KEY `fk_Contacto_Persona` (`Persona`),
  CONSTRAINT `fk_Contacto_Persona` FOREIGN KEY (`Persona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contacto_Tipo_Contacto` FOREIGN KEY (`Tipo_Contacto`) REFERENCES `tipo_contacto` (`idTipo_Contacto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

/*Data for the table `contacto` */

insert  into `contacto`(`idContacto`,`nombre`,`Tipo_Contacto`,`Persona`,`organizacion`) values (3,'4512503',1,7,NULL),(4,'156714600',1,12,NULL),(5,'',1,13,NULL),(6,'',3,14,NULL),(7,'',1,15,NULL),(8,'',1,16,NULL),(9,'',1,17,NULL),(10,'',1,18,NULL),(11,'',1,19,NULL),(12,'',1,20,NULL),(13,'',1,21,NULL),(14,'',1,22,NULL),(15,'',1,23,NULL),(16,'',1,24,NULL),(17,'',1,25,NULL),(18,'',1,26,NULL),(19,'',1,27,NULL),(20,'',1,28,NULL),(21,'Teléfono ParticularTeléfono LaboraleMail',1,29,NULL),(22,'4519764',1,NULL,1);

/*Table structure for table `contratos` */

DROP TABLE IF EXISTS `contratos`;

CREATE TABLE `contratos` (
  `idContratos` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `Tipo_Contrato` int(11) DEFAULT NULL,
  `idPropiedades` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idContratos`),
  KEY `fk_Contratos_Tipo_Contrato` (`Tipo_Contrato`),
  CONSTRAINT `fk_Contratos_Tipo_Contrato` FOREIGN KEY (`Tipo_Contrato`) REFERENCES `tipo_contrato` (`idTipo_Contrato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `contratos` */

insert  into `contratos`(`idContratos`,`fecha`,`Tipo_Contrato`,`idPropiedades`) values (1,'2008-10-28',1,1),(2,'2008-10-28',1,3);

/*Table structure for table `contratos_x_cliente` */

DROP TABLE IF EXISTS `contratos_x_cliente`;

CREATE TABLE `contratos_x_cliente` (
  `Cliente` int(11) NOT NULL,
  `Contratos` int(11) NOT NULL,
  PRIMARY KEY (`Cliente`,`Contratos`),
  KEY `fk_Contratos_x_Cliente_Cliente` (`Cliente`),
  KEY `fk_Contratos_x_Cliente_Contratos` (`Contratos`),
  CONSTRAINT `fk_Contratos_x_Cliente_Cliente` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contratos_x_Cliente_Contratos` FOREIGN KEY (`Contratos`) REFERENCES `contratos` (`idContratos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contratos_x_cliente` */

insert  into `contratos_x_cliente`(`Cliente`,`Contratos`) values (1,1),(2,2),(4,1);

/*Table structure for table `contratos_x_organizacion` */

DROP TABLE IF EXISTS `contratos_x_organizacion`;

CREATE TABLE `contratos_x_organizacion` (
  `idOrganizacion` int(11) NOT NULL,
  `idContrato` int(11) NOT NULL,
  PRIMARY KEY (`idOrganizacion`,`idContrato`),
  KEY `contrato_fk_constraint` (`idContrato`),
  CONSTRAINT `contrato_fk_constraint` FOREIGN KEY (`idContrato`) REFERENCES `contratos` (`idContratos`),
  CONSTRAINT `organizacion_fk_constraint` FOREIGN KEY (`idOrganizacion`) REFERENCES `organizacion` (`idOrganizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contratos_x_organizacion` */

/*Table structure for table `direccion` */

DROP TABLE IF EXISTS `direccion`;

CREATE TABLE `direccion` (
  `idDireccion` int(11) NOT NULL AUTO_INCREMENT,
  `calle` varchar(45) DEFAULT NULL,
  `nro` int(11) DEFAULT NULL,
  `piso` int(11) DEFAULT NULL,
  `departamento` varchar(3) DEFAULT NULL,
  `cpp` varchar(10) DEFAULT NULL,
  `Tipo_Ubicacion` int(11) DEFAULT NULL,
  `Barrios` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDireccion`),
  KEY `fk_Direccion_Tipo_Ubicacion` (`Tipo_Ubicacion`),
  KEY `fk_Direccion_Barrios` (`Barrios`),
  CONSTRAINT `fk_Direccion_Barrios` FOREIGN KEY (`Barrios`) REFERENCES `barrios` (`idBarrios`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Direccion_Tipo_Ubicacion` FOREIGN KEY (`Tipo_Ubicacion`) REFERENCES `tipo_ubicacion` (`idTipo_Ubicacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;

/*Data for the table `direccion` */

insert  into `direccion`(`idDireccion`,`calle`,`nro`,`piso`,`departamento`,`cpp`,`Tipo_Ubicacion`,`Barrios`) values (1,'Suipacha',1727,NULL,NULL,'5000',1,1),(2,'Severo Vaccaro',1369,NULL,NULL,'X5013CCC',1,2),(4,'Severo Vaccaro',1369,NULL,NULL,'X5013CCC',1,2),(5,'Homero Manzi',1566,NULL,NULL,'5012',1,1),(6,'Esta',1234,1,'AA','5000',NULL,1),(7,'Esta',1234,1,'AA','5000',NULL,1),(8,'Severo Vaccaro',1369,1,'A|','5012',NULL,1),(9,'Severo Vaccaro',1369,1,'A|','5012',NULL,1),(10,'Esta calle',123,1,'a','5000',NULL,1),(11,'Suipacha',2334,1,'A','5000',NULL,1),(12,'Pascual Contursi',1325,0,'','5000',NULL,1),(13,'Suipacha',1500,1,'A','5000',NULL,1),(14,'Suipacha',1234,NULL,'','',NULL,1),(15,'Severo Vaccaro',123,NULL,'','5000',NULL,2),(16,'Suipacha',2221,NULL,'','X5000ABC',NULL,1),(17,'Severo Vaccaro',1369,NULL,NULL,'X5013CCC',1,2),(18,'Homero Manzi',1566,NULL,'','5000',NULL,1),(19,'Severo Vaccaro',1369,NULL,'','5000',NULL,3),(23,'Ituzaingó',123,123,'A','5000',1,4),(24,'Cochambamaba',4202,4202,'','',1,2),(25,'9 de Julio',12,12,'','5000',1,22),(26,'Duarte Quiroz',1234,1234,'','',1,22),(27,'Zabalia',1367,1367,'','5000',1,2),(28,'San Lorenzo',250,4,'B','5000',NULL,9),(29,'Severo Vaccaro',1234,NULL,'','5000',NULL,27),(30,'Severo Vaccaro',1243,NULL,'','xsax',NULL,2),(31,'San Ignacio',3789,NULL,'','',1,23),(32,'Severo Vaccaro',1234,NULL,'','5012',2,2),(33,'Zavalia',1205,NULL,'','5000',2,17),(34,'Homero',1678,NULL,'','5000',1,17),(35,'9 de Julio',1567,1,'C','1000',2,31),(36,'Caminito',234,NULL,'','1000',2,30),(37,'Suipacha',1347,NULL,'','5012',2,1),(38,'Bulnes',4356,NULL,'','5000',2,2),(39,'Suipacha',2369,NULL,'','5012',2,1),(40,'Colón',1890,NULL,'','5000',2,15),(41,'Velez Sarzfield',6546,NULL,'','5000',2,21),(42,'Sarmiento',789,NULL,'','',1,4),(43,'Roma',1235,NULL,'','5000',2,4),(44,'Viamonte',1234,NULL,'','5000',2,4),(45,'Charcas',3302,NULL,'','',2,23),(46,'Colón',1389,NULL,'','',2,22),(47,'Charcas',1909,0,'','5012',NULL,1),(48,'Charcas',1909,0,'','5012',NULL,1),(49,'Suipacha',1711,0,'','',NULL,1),(50,'Charcas',1909,0,'','5012',NULL,1),(51,'Viamonte',520,8,'C','5012',NULL,4),(52,'Alsina',1428,0,'','5000',NULL,2),(53,'Suipacha',3343,0,'','5012',NULL,2),(54,'Belgrano',5019,4,'A','1000',1,27),(55,'Severo',1234,6,'B','5000',NULL,4),(56,'Severo',1234,6,'B','5000',NULL,17),(57,'Severo Vaccaro',1369,0,'','5012',NULL,2),(58,'Rio Cuarto',123,0,'','5012',NULL,8),(59,'Padre Luis Monti',1348,4,'D','5000',NULL,4),(60,'Bulnes',4090,0,'','5000',NULL,2),(61,'Homero',145,6,'6','5000',NULL,22),(62,'Humberto 1°',650,3,'','5000',1,1);

/*Table structure for table `direccion_x_persona` */

DROP TABLE IF EXISTS `direccion_x_persona`;

CREATE TABLE `direccion_x_persona` (
  `Persona` int(11) NOT NULL,
  `Direccion` int(11) NOT NULL,
  `fecha_desde` date DEFAULT NULL,
  `fecha_hasta` date DEFAULT NULL,
  PRIMARY KEY (`Persona`,`Direccion`),
  KEY `fk_Direccion_x_Persona_Persona` (`Persona`),
  KEY `fk_Direccion_x_Persona_Direccion` (`Direccion`),
  CONSTRAINT `fk_Direccion_x_Persona_Direccion` FOREIGN KEY (`Direccion`) REFERENCES `direccion` (`idDireccion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Direccion_x_Persona_Persona` FOREIGN KEY (`Persona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `direccion_x_persona` */

insert  into `direccion_x_persona`(`Persona`,`Direccion`,`fecha_desde`,`fecha_hasta`) values (1,1,'2008-11-04',NULL),(2,2,'2008-11-03',NULL),(3,4,'2008-11-11',NULL),(4,5,'2008-11-11',NULL),(5,17,'2008-11-11',NULL),(6,23,'2009-04-03',NULL),(7,24,'2009-04-04',NULL),(8,25,'2009-04-04',NULL),(9,26,'2009-04-04',NULL),(12,27,'2009-04-04',NULL),(13,31,'2010-05-01',NULL),(14,32,'2010-07-05',NULL),(15,33,'2010-07-05',NULL),(16,34,'2010-07-05',NULL),(17,35,'2010-07-05',NULL),(18,36,'2010-07-05',NULL),(19,37,'2010-07-05',NULL),(20,38,'2010-07-05',NULL),(21,39,'2010-07-05',NULL),(22,40,'2010-07-05',NULL),(23,41,'2010-07-05',NULL),(24,42,'2010-07-05',NULL),(25,43,'2010-07-05',NULL),(26,44,'2010-07-05',NULL),(27,45,'2010-07-05',NULL),(28,46,'2010-07-06',NULL),(29,54,'2010-07-31',NULL);

/*Table structure for table `disponibilidad` */

DROP TABLE IF EXISTS `disponibilidad`;

CREATE TABLE `disponibilidad` (
  `idDisponibilidad` int(11) NOT NULL AUTO_INCREMENT,
  `fechaDesde` date DEFAULT NULL,
  `fechaHasta` date DEFAULT NULL,
  `monto` float DEFAULT NULL,
  `Propiedades_idPropiedades` int(11) DEFAULT NULL,
  `Moneda_idMoneda` int(11) DEFAULT NULL,
  `Tipo_Disponibilidad_idTipo_Disponibilidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDisponibilidad`),
  KEY `fk_Disponibilidad_Propiedades` (`Propiedades_idPropiedades`),
  KEY `fk_Disponibilidad_Moneda` (`Moneda_idMoneda`),
  KEY `fk_Disponibilidad_Tipo_Disponibilidad` (`Tipo_Disponibilidad_idTipo_Disponibilidad`),
  CONSTRAINT `fk_Disponibilidad_Moneda` FOREIGN KEY (`Moneda_idMoneda`) REFERENCES `moneda` (`idMoneda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Disponibilidad_Propiedades` FOREIGN KEY (`Propiedades_idPropiedades`) REFERENCES `propiedades` (`idPropiedades`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Disponibilidad_Tipo_Disponibilidad` FOREIGN KEY (`Tipo_Disponibilidad_idTipo_Disponibilidad`) REFERENCES `tipo_disponibilidad` (`idTipo_Disponibilidad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `disponibilidad` */

insert  into `disponibilidad`(`idDisponibilidad`,`fechaDesde`,`fechaHasta`,`monto`,`Propiedades_idPropiedades`,`Moneda_idMoneda`,`Tipo_Disponibilidad_idTipo_Disponibilidad`) values (1,'2008-05-26',NULL,100,1,1,1),(2,'2008-11-26',NULL,900,2,1,2),(3,'2008-05-26',NULL,1100,3,1,1),(4,'2008-11-27',NULL,300,4,2,1),(5,'2009-04-07',NULL,1100,5,1,1),(6,'2009-04-07',NULL,950,6,1,1),(7,'2009-04-09',NULL,700,7,2,1),(8,'2010-07-08',NULL,1100,9,1,1),(9,'2010-07-08',NULL,1200,10,1,1),(10,'2010-07-22',NULL,45000,11,2,1);

/*Table structure for table `egreso` */

DROP TABLE IF EXISTS `egreso`;

CREATE TABLE `egreso` (
  `idEgreso` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `monto` float DEFAULT NULL,
  `numero_comprobante` varchar(45) DEFAULT NULL,
  `Moneda` int(11) DEFAULT NULL,
  `Tipo_Comprobante` int(11) DEFAULT NULL,
  `Tipo_Egreso_idTipo_Egreso` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEgreso`),
  KEY `fk_Egreso_Moneda` (`Moneda`),
  KEY `fk_Egreso_Tipo_Comprobante` (`Tipo_Comprobante`),
  KEY `fk_Egreso_Tipo_Egreso` (`Tipo_Egreso_idTipo_Egreso`),
  CONSTRAINT `fk_Egreso_Moneda` FOREIGN KEY (`Moneda`) REFERENCES `moneda` (`idMoneda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Egreso_Tipo_Comprobante` FOREIGN KEY (`Tipo_Comprobante`) REFERENCES `tipo_comprobante` (`idTipo_Comprobante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Egreso_Tipo_Egreso` FOREIGN KEY (`Tipo_Egreso_idTipo_Egreso`) REFERENCES `tipo_egreso` (`idTipo_Egreso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `egreso` */

insert  into `egreso`(`idEgreso`,`fecha`,`monto`,`numero_comprobante`,`Moneda`,`Tipo_Comprobante`,`Tipo_Egreso_idTipo_Egreso`) values (1,'2008-12-04',423,'3243242',1,1,1),(2,'2008-12-11',333,'rwerw',1,1,1),(3,'2008-12-17',445,'ad344edc1',1,1,1),(4,'2008-12-05',324,'21334454',1,4,2),(5,'2008-12-28',25.34,'1223344',1,1,2),(6,'2009-04-16',40,'125667533',1,1,3),(7,'2009-04-21',12.9,'A-98777993-2',1,1,2);

/*Table structure for table `empleado` */

DROP TABLE IF EXISTS `empleado`;

CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `Persona` int(11) DEFAULT NULL,
  `Tipo_Empleado` int(11) DEFAULT NULL,
  `usuario` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `clave` char(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `fk_Empleado_Persona` (`Persona`),
  KEY `fk_Empleado_Tipo_Empleado` (`Tipo_Empleado`),
  CONSTRAINT `fk_Empleado_Persona` FOREIGN KEY (`Persona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Tipo_Empleado` FOREIGN KEY (`Tipo_Empleado`) REFERENCES `tipo_empleado` (`idTipo_Empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `empleado` */

insert  into `empleado`(`idEmpleado`,`Persona`,`Tipo_Empleado`,`usuario`,`clave`) values (1,12,1,'roge','roge'),(2,6,1,'nara','nara'),(3,13,1,'user','pass'),(4,29,1,'user2','pass');

/*Table structure for table `estado_cobro` */

DROP TABLE IF EXISTS `estado_cobro`;

CREATE TABLE `estado_cobro` (
  `idEstado_Cobro` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEstado_Cobro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `estado_cobro` */

insert  into `estado_cobro`(`idEstado_Cobro`,`nombre`,`descripcion`) values (1,'Pendiente',NULL),(2,'Pagado',NULL);

/*Table structure for table `estado_propiedad` */

DROP TABLE IF EXISTS `estado_propiedad`;

CREATE TABLE `estado_propiedad` (
  `idEstado_Propiedad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descipcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEstado_Propiedad`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `estado_propiedad` */

insert  into `estado_propiedad`(`idEstado_Propiedad`,`nombre`,`descipcion`) values (1,'A estrenar','Nunca fue usada.'),(2,'Nueva','Es una casa muy nueva, con muy poco uso.'),(3,'Restaurada','Propiedad restaurado, como nueva.'),(4,'Excelente',NULL),(5,'Muy bueno',NULL),(6,'Bueno',NULL),(7,'Regular',NULL),(8,'Malo',NULL);

/*Table structure for table `eventos` */

DROP TABLE IF EXISTS `eventos`;

CREATE TABLE `eventos` (
  `idEventos` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `Tipo_Evento_idTipo_Evento` int(11) DEFAULT NULL,
  `Direccion_idDireccion` int(11) DEFAULT NULL,
  `Descripcion` text,
  `hora` time DEFAULT NULL,
  PRIMARY KEY (`idEventos`),
  KEY `fk_Eventos_Tipo_Evento` (`Tipo_Evento_idTipo_Evento`),
  KEY `fk_Eventos_Direccion` (`Direccion_idDireccion`),
  CONSTRAINT `fk_Eventos_Direccion` FOREIGN KEY (`Direccion_idDireccion`) REFERENCES `direccion` (`idDireccion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Eventos_Tipo_Evento` FOREIGN KEY (`Tipo_Evento_idTipo_Evento`) REFERENCES `tipo_evento` (`idTipo_Evento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `eventos` */

insert  into `eventos`(`idEventos`,`fecha`,`Tipo_Evento_idTipo_Evento`,`Direccion_idDireccion`,`Descripcion`,`hora`) values (1,'2008-12-05',1,10,'Esta es la descripcion del Evento este che...',NULL),(2,'2008-12-04',1,16,'',NULL),(3,'2010-09-15',1,58,'Se inaugura un nuevo complejo de departamentos en Barrio Juniors. Hay que ir, habrá potenciales clientes.\n\nNico.-','10:00:08'),(4,'2010-08-24',1,59,'Esto es para la inauguracion de algo que no me acuerdo que es','22:05:46'),(5,'2010-08-28',3,61,'Pagar las boletas de la Luz','12:45:53');

/*Table structure for table `garantias` */

DROP TABLE IF EXISTS `garantias`;

CREATE TABLE `garantias` (
  `Contratos_idContratos` int(11) NOT NULL,
  `Propiedades_idPropiedades` int(11) NOT NULL,
  PRIMARY KEY (`Contratos_idContratos`,`Propiedades_idPropiedades`),
  KEY `fk_Garantias_Contratos` (`Contratos_idContratos`),
  KEY `fk_Garantias_Propiedades` (`Propiedades_idPropiedades`),
  CONSTRAINT `fk_Garantias_Contratos` FOREIGN KEY (`Contratos_idContratos`) REFERENCES `contratos` (`idContratos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Garantias_Propiedades` FOREIGN KEY (`Propiedades_idPropiedades`) REFERENCES `propiedades` (`idPropiedades`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `garantias` */

/*Table structure for table `informes` */

DROP TABLE IF EXISTS `informes`;

CREATE TABLE `informes` (
  `idInformes` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `generado_por` int(11) DEFAULT NULL,
  `Tipo_Informe` int(11) DEFAULT NULL,
  PRIMARY KEY (`idInformes`),
  KEY `fk_Informes_Empleado` (`generado_por`),
  KEY `fk_Informes_Tipo_Informe` (`Tipo_Informe`),
  CONSTRAINT `fk_Informes_Empleado` FOREIGN KEY (`generado_por`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Informes_Tipo_Informe` FOREIGN KEY (`Tipo_Informe`) REFERENCES `tipo_informe` (`idTipo_Informe`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `informes` */

/*Table structure for table `ingreso` */

DROP TABLE IF EXISTS `ingreso`;

CREATE TABLE `ingreso` (
  `idIngreso` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `monto` float DEFAULT NULL,
  `Liquidacion` int(11) DEFAULT NULL,
  `Tipo_Ingreso` int(11) DEFAULT NULL,
  `Moneda_idMoneda` int(11) DEFAULT NULL,
  `Contratos_idContratos` int(11) DEFAULT NULL,
  PRIMARY KEY (`idIngreso`),
  KEY `fk_Ingreso_Liquidaciones` (`Liquidacion`),
  KEY `fk_Ingreso_Tipo_Ingreso` (`Tipo_Ingreso`),
  KEY `fk_Ingreso_Moneda` (`Moneda_idMoneda`),
  KEY `fk_Ingreso_Contratos` (`Contratos_idContratos`),
  CONSTRAINT `fk_Ingreso_Contratos` FOREIGN KEY (`Contratos_idContratos`) REFERENCES `contratos` (`idContratos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ingreso_Liquidaciones` FOREIGN KEY (`Liquidacion`) REFERENCES `liquidaciones` (`idLiquidaciones`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ingreso_Moneda` FOREIGN KEY (`Moneda_idMoneda`) REFERENCES `moneda` (`idMoneda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ingreso_Tipo_Ingreso` FOREIGN KEY (`Tipo_Ingreso`) REFERENCES `tipo_ingreso` (`idTipo_Ingreso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ingreso` */

/*Table structure for table `liquidaciones` */

DROP TABLE IF EXISTS `liquidaciones`;

CREATE TABLE `liquidaciones` (
  `idLiquidaciones` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `Cobro_Alquileres` int(11) DEFAULT NULL,
  PRIMARY KEY (`idLiquidaciones`),
  KEY `fk_Liquidaciones_Cobro_Alquileres` (`Cobro_Alquileres`),
  CONSTRAINT `fk_Liquidaciones_Cobro_Alquileres` FOREIGN KEY (`Cobro_Alquileres`) REFERENCES `cobro_alquileres` (`idCobro_Alquileres`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `liquidaciones` */

/*Table structure for table `localidades` */

DROP TABLE IF EXISTS `localidades`;

CREATE TABLE `localidades` (
  `idLocalidades` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `Provincias` int(11) DEFAULT NULL,
  PRIMARY KEY (`idLocalidades`),
  KEY `fk_Localidades_Provincias` (`Provincias`),
  CONSTRAINT `fk_Localidades_Provincias` FOREIGN KEY (`Provincias`) REFERENCES `provincias` (`idProvincias`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `localidades` */

insert  into `localidades`(`idLocalidades`,`nombre`,`Provincias`) values (1,'Córdoba',1),(2,'Villa Allende',1),(3,'Unquillo',1),(4,'Río Ceballos',1),(5,'Carlos Paz',1),(6,'Cosquín',1),(7,'La Falda',1),(8,'Los Reartes',1),(9,'Avellaneda',2),(10,'Morón',2),(11,'San Nicolás',2),(12,'Mar del Plata',2),(13,'San Clemente',2),(14,'Capital Federal',2);

/*Table structure for table `moneda` */

DROP TABLE IF EXISTS `moneda`;

CREATE TABLE `moneda` (
  `idMoneda` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `cambio` float DEFAULT NULL,
  PRIMARY KEY (`idMoneda`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `moneda` */

insert  into `moneda`(`idMoneda`,`nombre`,`descripcion`,`cambio`) values (1,'$','Pesos',1),(2,'U$S','Dólares',3.2),(3,'Euro','Euros',4.4),(4,'Real','Reales',2.2),(5,'Libra','Libras',NULL),(6,'Yen','Yenes',NULL);

/*Table structure for table `motivo` */

DROP TABLE IF EXISTS `motivo`;

CREATE TABLE `motivo` (
  `idMotivo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `tiempo_soluciuon` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMotivo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `motivo` */

insert  into `motivo`(`idMotivo`,`nombre`,`descripcion`,`tiempo_soluciuon`) values (1,'Rajaduras',NULL,'2 Semanas'),(2,'Pozo Negro',NULL,'1 Semana'),(3,'Cañerías',NULL,'3 Semanas');

/*Table structure for table `motivo_cita` */

DROP TABLE IF EXISTS `motivo_cita`;

CREATE TABLE `motivo_cita` (
  `idMotivo_Cita` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMotivo_Cita`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `motivo_cita` */

insert  into `motivo_cita`(`idMotivo_Cita`,`nombre`,`descripcion`) values (1,'Mostrar Propiedad',NULL),(2,'Ver Propiedad',NULL),(3,'Tasación',NULL),(4,'Realizar Cobro',NULL);

/*Table structure for table `organizacion` */

DROP TABLE IF EXISTS `organizacion`;

CREATE TABLE `organizacion` (
  `idOrganizacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `direccion` int(11) DEFAULT NULL,
  `idTitular` int(11) NOT NULL,
  PRIMARY KEY (`idOrganizacion`),
  KEY `new_fk_constraint` (`direccion`),
  CONSTRAINT `new_fk_constraint` FOREIGN KEY (`direccion`) REFERENCES `direccion` (`idDireccion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `organizacion` */

insert  into `organizacion`(`idOrganizacion`,`nombre`,`direccion`,`idTitular`) values (1,'Globant',62,0);

/*Table structure for table `paises` */

DROP TABLE IF EXISTS `paises`;

CREATE TABLE `paises` (
  `idPaises` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPaises`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `paises` */

insert  into `paises`(`idPaises`,`nombre`) values (1,'Argentina'),(2,'Brasil'),(3,'Uruguay'),(4,'Paraguay'),(5,'Chile'),(6,'Bolivia'),(8,'Colombia'),(9,'Estados Unidos');

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) DEFAULT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `numero_documento` varchar(45) DEFAULT NULL,
  `Tipo_Documento` int(11) DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  KEY `fk_Persona_Tipo_Documento` (`Tipo_Documento`),
  CONSTRAINT `fk_Persona_Tipo_Documento` FOREIGN KEY (`Tipo_Documento`) REFERENCES `tipo_documento` (`idTipoDocumento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

/*Data for the table `persona` */

insert  into `persona`(`idPersona`,`apellido`,`nombres`,`numero_documento`,`Tipo_Documento`,`sexo`) values (1,'Garay','Joel','28199876',1,'m'),(2,'Pozo','Luciana','21098098',1,'f'),(3,'Pozo','Flavia Eliana','37123456',1,'f'),(4,'Gonzalez','Patricia','20119923',1,'f'),(5,'Pozo','Nicolás','20188888',1,'m'),(6,'Nara','Wanda','123456',1,'f'),(7,'Carreras','Andrea','22123987',1,'f'),(8,'Velardez','Juan Martin','90099876',1,'m'),(9,'Del Potro','Juan Martin','13988998',1,'m'),(12,'Argañaras','Rogelio','6789876',1,'m'),(13,'Sánchez','Hugo','30198473',1,'m'),(14,'Conti','Federico','30098890',1,'m'),(15,'Vineti','Carlos','30987543',1,'m'),(16,'Monti','Juan Carlos','1234567',1,'m'),(17,'Messi','Lionel','37876778',1,'m'),(18,'Tevez','Carlos','35665467',1,'m'),(19,'Salcedo','Carlos','13376098',1,'m'),(20,'Avon','Ivon','21234500',1,'f'),(21,'Gonzalez','Monica','21376598',1,'f'),(22,'Gallego','Carlos','12908567',1,'m'),(23,'Sánchez','Juan','19985645',1,'m'),(24,'Domingo','Carreras','7985672',1,'m'),(25,'Domingo','Placido','90490933',4,'m'),(26,'Kevin','Costner','10987002',1,'m'),(27,'Spielberg','Steven','90827789',4,'m'),(28,'Gates','Bill','29920022',4,'m'),(29,'Listorti','José María','21650101',1,'m');

/*Table structure for table `personas_citadas` */

DROP TABLE IF EXISTS `personas_citadas`;

CREATE TABLE `personas_citadas` (
  `Citas_idcita` int(11) NOT NULL,
  `Persona_idPersona` int(11) NOT NULL,
  PRIMARY KEY (`Citas_idcita`,`Persona_idPersona`),
  KEY `fk_Personas_Citadas_Citas` (`Citas_idcita`),
  KEY `fk_Personas_Citadas_Persona` (`Persona_idPersona`),
  CONSTRAINT `fk_Personas_Citadas_Citas` FOREIGN KEY (`Citas_idcita`) REFERENCES `citas` (`idcita`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Personas_Citadas_Persona` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `personas_citadas` */

/*Table structure for table `propiedades` */

DROP TABLE IF EXISTS `propiedades`;

CREATE TABLE `propiedades` (
  `idPropiedades` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_Construccion` date DEFAULT NULL,
  `ambientes` int(11) DEFAULT NULL,
  `dormitorios` int(11) DEFAULT NULL,
  `banios` int(11) DEFAULT NULL,
  `patio_m2` int(11) DEFAULT NULL,
  `parcela_m2` int(11) DEFAULT NULL,
  `cubierto_m2` int(11) DEFAULT NULL,
  `Direccion` int(11) DEFAULT NULL,
  `Estado_Propiedad` int(11) DEFAULT NULL,
  `Tipo_Propiedad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPropiedades`),
  KEY `fk_Propiedades_Direccion` (`Direccion`),
  KEY `fk_Propiedades_Estado_Propiedad` (`Estado_Propiedad`),
  KEY `fk_Propiedades_Tipo_Propiedad` (`Tipo_Propiedad`),
  CONSTRAINT `fk_Propiedades_Direccion` FOREIGN KEY (`Direccion`) REFERENCES `direccion` (`idDireccion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Propiedades_Estado_Propiedad` FOREIGN KEY (`Estado_Propiedad`) REFERENCES `estado_propiedad` (`idEstado_Propiedad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Propiedades_Tipo_Propiedad` FOREIGN KEY (`Tipo_Propiedad`) REFERENCES `tipo_propiedad` (`idTipo_Propiedad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `propiedades` */

insert  into `propiedades`(`idPropiedades`,`fecha_Construccion`,`ambientes`,`dormitorios`,`banios`,`patio_m2`,`parcela_m2`,`cubierto_m2`,`Direccion`,`Estado_Propiedad`,`Tipo_Propiedad`) values (1,'2008-12-04',2,2,3,555,555,555,6,1,1),(2,'2008-12-04',2,2,3,555,777,777,7,1,1),(3,'1990-06-10',5,5,2,360,500,120,12,4,1),(4,'2008-12-27',1,0,1,0,30,30,13,1,3),(5,'2005-04-07',3,1,1,0,0,40,28,4,3),(6,'2009-04-14',1,0,1,0,0,50,29,1,1),(7,'2009-04-15',1,0,1,0,300,300,30,1,4),(8,'2010-08-01',1,1,1,100,250,150,47,1,1),(9,'2010-08-08',1,1,1,0,0,100,51,1,3),(10,'1980-02-01',1,1,1,0,250,250,52,1,4),(11,'2010-07-22',0,0,0,0,300,0,53,1,4);

/*Table structure for table `propiedades_x_propietario` */

DROP TABLE IF EXISTS `propiedades_x_propietario`;

CREATE TABLE `propiedades_x_propietario` (
  `idPropiedades` int(11) NOT NULL,
  `idPropietario` int(11) NOT NULL,
  `fecha_desde` date NOT NULL,
  `fecha_hasta` date DEFAULT NULL,
  PRIMARY KEY (`idPropiedades`,`idPropietario`,`fecha_desde`) USING BTREE,
  KEY `fk_Propiedades_x_Propietario_Propiedades` (`idPropiedades`) USING BTREE,
  KEY `fk_Propiedades_x_Propietario_Propietario` (`idPropietario`) USING BTREE,
  CONSTRAINT `fk_Propiedades_x_Propietario_Propiedades` FOREIGN KEY (`idPropiedades`) REFERENCES `propiedades` (`idPropiedades`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Propiedades_x_Propietario_Propietario` FOREIGN KEY (`idPropietario`) REFERENCES `propietario` (`idPropietario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `propiedades_x_propietario` */

insert  into `propiedades_x_propietario`(`idPropiedades`,`idPropietario`,`fecha_desde`,`fecha_hasta`) values (1,1,'2008-11-22',NULL),(2,1,'2008-11-22',NULL),(3,1,'2008-11-26',NULL),(4,1,'2008-11-27',NULL),(5,1,'2009-04-07',NULL),(6,1,'2009-04-07',NULL),(7,2,'2009-04-09',NULL),(8,1,'2010-07-08',NULL),(9,3,'2010-07-08',NULL),(10,15,'2010-07-08',NULL),(11,9,'2010-07-22',NULL);

/*Table structure for table `propietario` */

DROP TABLE IF EXISTS `propietario`;

CREATE TABLE `propietario` (
  `idPropietario` int(11) NOT NULL AUTO_INCREMENT,
  `Persona_idPersona` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPropietario`),
  KEY `fk_Propietario_Persona` (`Persona_idPersona`),
  CONSTRAINT `fk_Propietario_Persona` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `propietario` */

insert  into `propietario`(`idPropietario`,`Persona_idPersona`) values (1,4),(2,5),(3,14),(4,15),(5,16),(6,18),(7,19),(8,21),(9,22),(10,23),(11,24),(12,25),(13,26),(14,27),(15,28);

/*Table structure for table `provincias` */

DROP TABLE IF EXISTS `provincias`;

CREATE TABLE `provincias` (
  `idProvincias` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `Paises` int(11) NOT NULL,
  PRIMARY KEY (`idProvincias`),
  KEY `fk_Provincias_Paises` (`Paises`),
  CONSTRAINT `fk_Provincias_Paises` FOREIGN KEY (`Paises`) REFERENCES `paises` (`idPaises`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `provincias` */

insert  into `provincias`(`idProvincias`,`nombre`,`Paises`) values (1,'Córdoba',1),(2,'Buenos Aires',1),(3,'Catamarca',1),(4,'San Juan',1),(5,'Corrientes',1),(6,'Misiones',1),(7,'Santiago del Estero',1),(8,'Tierra del Fuego',1),(9,'Santa Cruz',1),(10,'Río Negro',1),(11,'Chubut',1),(12,'Neuquén',1),(13,'Mendoza',1),(14,'San Luis',1),(15,'Santa Fé',1),(16,'Formosa',1),(17,'El Chaco',1),(18,'Entre Ríos',1),(19,'Jujuy',1),(20,'Salta',1),(21,'Tucumán',1),(22,'La Pampa',1),(23,'La Rioja',1);

/*Table structure for table `quejas` */

DROP TABLE IF EXISTS `quejas`;

CREATE TABLE `quejas` (
  `idQuejas` int(11) NOT NULL AUTO_INCREMENT,
  `Receptor` int(11) DEFAULT NULL,
  `Contrato` int(11) DEFAULT NULL,
  `Motivo` int(11) DEFAULT NULL,
  `Responsable` int(11) DEFAULT NULL,
  `descripcion` text,
  `comentarios` text,
  PRIMARY KEY (`idQuejas`),
  KEY `fk_Quejas_Empleado` (`Receptor`),
  KEY `fk_Quejas_Contratos` (`Contrato`),
  KEY `fk_Quejas_Motivo` (`Motivo`),
  KEY `fk_Quejas_Persona` (`Responsable`),
  CONSTRAINT `fk_Quejas_Contratos` FOREIGN KEY (`Contrato`) REFERENCES `contratos` (`idContratos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Quejas_Empleado` FOREIGN KEY (`Receptor`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Quejas_Motivo` FOREIGN KEY (`Motivo`) REFERENCES `motivo` (`idMotivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Quejas_Persona` FOREIGN KEY (`Responsable`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `quejas` */

insert  into `quejas`(`idQuejas`,`Receptor`,`Contrato`,`Motivo`,`Responsable`,`descripcion`,`comentarios`) values (1,1,1,2,1,'Se llenó el Pozo negro. Mandar lo antes posible un desagote.','Que vayan un poco menos al baño estos tipos y no se va a llenar tan rapido.\n\nNico.-');

/*Table structure for table `tipo_comprobante` */

DROP TABLE IF EXISTS `tipo_comprobante`;

CREATE TABLE `tipo_comprobante` (
  `idTipo_Comprobante` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipo_Comprobante`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `tipo_comprobante` */

insert  into `tipo_comprobante`(`idTipo_Comprobante`,`nombre`,`descripcion`) values (1,'Factura',NULL),(2,'Nota de Crédito',NULL),(3,'Nota de Débito',NULL),(4,'Ticket',NULL),(5,'Remito',NULL);

/*Table structure for table `tipo_contacto` */

DROP TABLE IF EXISTS `tipo_contacto`;

CREATE TABLE `tipo_contacto` (
  `idTipo_Contacto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipo_Contacto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tipo_contacto` */

insert  into `tipo_contacto`(`idTipo_Contacto`,`nombre`,`descripcion`) values (1,'Teléfono Particular',NULL),(2,'Teléfono Laboral',NULL),(3,'eMail',NULL);

/*Table structure for table `tipo_contrato` */

DROP TABLE IF EXISTS `tipo_contrato`;

CREATE TABLE `tipo_contrato` (
  `idTipo_Contrato` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipo_Contrato`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tipo_contrato` */

insert  into `tipo_contrato`(`idTipo_Contrato`,`nombre`,`descripcion`) values (1,'Contrato de Alquiler','Contrato de Alquiler'),(2,'Acuerdo de venta',NULL);

/*Table structure for table `tipo_disponibilidad` */

DROP TABLE IF EXISTS `tipo_disponibilidad`;

CREATE TABLE `tipo_disponibilidad` (
  `idTipo_Disponibilidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipo_Disponibilidad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tipo_disponibilidad` */

insert  into `tipo_disponibilidad`(`idTipo_Disponibilidad`,`nombre`,`descripcion`) values (1,'Alquiler',NULL),(2,'Venta',NULL);

/*Table structure for table `tipo_documento` */

DROP TABLE IF EXISTS `tipo_documento`;

CREATE TABLE `tipo_documento` (
  `idTipoDocumento` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `tipo_documento` */

insert  into `tipo_documento`(`idTipoDocumento`,`tipo`,`descripcion`) values (1,'DNI','Documento Nacional de Identidad'),(2,'LC','Libreta Cívica'),(3,'LE','Libreta de Enrolamiento'),(4,'Pasaporte','Pasaporte');

/*Table structure for table `tipo_egreso` */

DROP TABLE IF EXISTS `tipo_egreso`;

CREATE TABLE `tipo_egreso` (
  `idTipo_Egreso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipo_Egreso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `tipo_egreso` */

insert  into `tipo_egreso`(`idTipo_Egreso`,`nombre`,`descripcion`) values (1,'Teléfono',NULL),(2,'Gas',NULL),(3,'Agua',NULL),(4,'Luz',NULL),(5,'Impuesto',NULL);

/*Table structure for table `tipo_empleado` */

DROP TABLE IF EXISTS `tipo_empleado`;

CREATE TABLE `tipo_empleado` (
  `idTipo_Empleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipo_Empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tipo_empleado` */

insert  into `tipo_empleado`(`idTipo_Empleado`,`nombre`,`descripcion`) values (1,'Administrativo',NULL),(2,'Atención al Público',NULL),(3,'Ventas',NULL);

/*Table structure for table `tipo_evento` */

DROP TABLE IF EXISTS `tipo_evento`;

CREATE TABLE `tipo_evento` (
  `idTipo_Evento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipo_Evento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `tipo_evento` */

insert  into `tipo_evento`(`idTipo_Evento`,`nombre`,`descripcion`) values (1,'Inauguración',NULL),(2,'Remate',NULL),(3,'Pago de Servicio',NULL),(4,'Pago de Impuestos','');

/*Table structure for table `tipo_informe` */

DROP TABLE IF EXISTS `tipo_informe`;

CREATE TABLE `tipo_informe` (
  `idTipo_Informe` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipo_Informe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_informe` */

/*Table structure for table `tipo_ingreso` */

DROP TABLE IF EXISTS `tipo_ingreso`;

CREATE TABLE `tipo_ingreso` (
  `idTipo_Ingreso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipo_Ingreso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_ingreso` */

/*Table structure for table `tipo_propiedad` */

DROP TABLE IF EXISTS `tipo_propiedad`;

CREATE TABLE `tipo_propiedad` (
  `idTipo_Propiedad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipo_Propiedad`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `tipo_propiedad` */

insert  into `tipo_propiedad`(`idTipo_Propiedad`,`nombre`,`descripcion`) values (1,'Casa','Casa'),(2,'Local Comercial','Local Comercial'),(3,'Departamento',NULL),(4,'Galpón',NULL),(5,'Terreno',NULL);

/*Table structure for table `tipo_ubicacion` */

DROP TABLE IF EXISTS `tipo_ubicacion`;

CREATE TABLE `tipo_ubicacion` (
  `idTipo_Ubicacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipo_Ubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tipo_ubicacion` */

insert  into `tipo_ubicacion`(`idTipo_Ubicacion`,`nombre`,`descripcion`) values (1,'Particular','Particular'),(2,'Laboral',NULL);

/*Table structure for table `titulo` */

DROP TABLE IF EXISTS `titulo`;

CREATE TABLE `titulo` (
  `idTitulo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTitulo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `titulo` */

insert  into `titulo`(`idTitulo`,`nombre`,`descripcion`) values (1,'Martillero Público',NULL),(2,'Contador Público',NULL),(3,'Abogado',NULL);

/*Table structure for table `titulo_x_empleado` */

DROP TABLE IF EXISTS `titulo_x_empleado`;

CREATE TABLE `titulo_x_empleado` (
  `Titulo` int(11) NOT NULL,
  `Empleado` int(11) NOT NULL,
  `fecha_desde` date DEFAULT NULL,
  PRIMARY KEY (`Titulo`,`Empleado`),
  KEY `fk_Titulo_X_Empleado_Titulo` (`Titulo`),
  KEY `fk_Titulo_X_Empleado_Empleado` (`Empleado`),
  CONSTRAINT `fk_Titulo_X_Empleado_Empleado` FOREIGN KEY (`Empleado`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Titulo_X_Empleado_Titulo` FOREIGN KEY (`Titulo`) REFERENCES `titulo` (`idTitulo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `titulo_x_empleado` */

insert  into `titulo_x_empleado`(`Titulo`,`Empleado`,`fecha_desde`) values (1,3,'2010-05-01'),(1,4,'2010-07-31'),(3,2,'2009-04-03'),(3,3,'2010-05-01'),(3,4,'2010-07-31');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
