/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.53 : Database - teach
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`teach` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `teach`;

/*Table structure for table `db_user` */

DROP TABLE IF EXISTS `db_user`;

CREATE TABLE `db_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `head_pic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `db_user` */

insert  into `db_user`(`id`,`username`,`password`,`head_pic`) values (1,'张三','123456','HAHA'),(2,'李四','1234565','a安徽'),(3,'王五','1234564','警方立刻'),(4,'赵六','123456','阀手动阀'),(5,'李白','123456','j\'f解放东路卡机'),(20,'zhangsan','gsq','hahaha'),(21,'zhangsan','gsq','hahaha'),(22,'zhangsan','gsq','hahaha'),(23,'zhangsan','gsq','hahaha'),(24,'zhangsan','gsq','hahaha'),(25,'zhangsan','gsq','hahaha');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
