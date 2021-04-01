/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.10-MariaDB : Database - sporify
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sporify` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sporify`;

/*Table structure for table `abonnement` */

DROP TABLE IF EXISTS `abonnement`;

CREATE TABLE `abonnement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `date_debut` datetime NOT NULL,
  `duree` int(11) NOT NULL,
  `prix` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `abonnement` */

insert  into `abonnement`(`id`,`type`,`date_debut`,`duree`,`prix`) values (1,'gold1','2021-04-01 00:00:00',2,34),(3,'gold','2021-04-03 15:27:24',2,54),(4,'primium','2021-04-18 15:27:26',2,12),(6,'sadf','2021-04-09 00:00:00',3,234),(7,'gold','2021-04-16 00:00:00',3,234);

/*Table structure for table `coach` */

DROP TABLE IF EXISTS `coach`;

CREATE TABLE `coach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE utf8_bin NOT NULL,
  `prenom` varchar(50) COLLATE utf8_bin NOT NULL,
  `prix` float NOT NULL,
  `region` varchar(50) COLLATE utf8_bin NOT NULL,
  `tel` int(50) NOT NULL,
  `adressemail` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `coach` */

/*Table structure for table `cours` */

DROP TABLE IF EXISTS `cours`;

CREATE TABLE `cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE utf8_bin NOT NULL,
  `categorie` varchar(50) COLLATE utf8_bin NOT NULL,
  `niveau` varchar(50) COLLATE utf8_bin NOT NULL,
  `image` varchar(250) COLLATE utf8_bin NOT NULL,
  `duree` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `cours` */

/*Table structure for table `evenement` */

DROP TABLE IF EXISTS `evenement`;

CREATE TABLE `evenement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(50) COLLATE utf8_bin NOT NULL,
  `description` varchar(250) COLLATE utf8_bin NOT NULL,
  `date_debut` datetime NOT NULL,
  `date_fin` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `evenement` */

insert  into `evenement`(`id`,`titre`,`description`,`date_debut`,`date_fin`) values (4,'Test','tet','2021-03-10 00:00:00','2021-03-26 00:00:00'),(10,'lucky','I am lucky man','2021-04-07 00:00:00','2021-05-07 00:00:00');

/*Table structure for table `exercice` */

DROP TABLE IF EXISTS `exercice`;

CREATE TABLE `exercice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `duree` int(11) NOT NULL,
  `repos` int(11) NOT NULL,
  `reps` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `exercice` */

/*Table structure for table `nutritionniste` */

DROP TABLE IF EXISTS `nutritionniste`;

CREATE TABLE `nutritionniste` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE utf8_bin NOT NULL,
  `prenom` varchar(50) COLLATE utf8_bin NOT NULL,
  `adresse` varchar(50) COLLATE utf8_bin NOT NULL,
  `experience` varchar(50) COLLATE utf8_bin NOT NULL,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `nutritionniste` */

/*Table structure for table `produit` */

DROP TABLE IF EXISTS `produit`;

CREATE TABLE `produit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `prix` float NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `produit` */

/*Table structure for table `promotion` */

DROP TABLE IF EXISTS `promotion`;

CREATE TABLE `promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(50) COLLATE utf8_bin NOT NULL,
  `pourcentage` float NOT NULL,
  `description` varchar(250) COLLATE utf8_bin NOT NULL,
  `date_debut` datetime NOT NULL,
  `date_fin` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `promotion` */

/*Table structure for table `utilisateur` */

DROP TABLE IF EXISTS `utilisateur`;

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE utf8_bin NOT NULL,
  `prenom` varchar(50) COLLATE utf8_bin NOT NULL,
  `status` varchar(50) COLLATE utf8_bin NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `utilisateur` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
