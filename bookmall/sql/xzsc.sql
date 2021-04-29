/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17 : Database - xzsc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xzsc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xzsc`;

/*Table structure for table `tb_address` */

DROP TABLE IF EXISTS `tb_address`;

CREATE TABLE `tb_address` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `user_id` char(11) NOT NULL COMMENT '用户编号（用户手机号）',
  `address` varchar(50) NOT NULL COMMENT '地址',
  `added` datetime NOT NULL COMMENT '添加日期/时间',
  `receiver` varchar(30) NOT NULL COMMENT '收件人（姓名）',
  `receiver_phone` char(11) NOT NULL COMMENT '收件人电话',
  PRIMARY KEY (`rid`),
  KEY `fk_address_user` (`user_id`),
  CONSTRAINT `fk_address_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='用户地址表';

/*Data for the table `tb_address` */

insert  into `tb_address`(`rid`,`user_id`,`address`,`added`,`receiver`,`receiver_phone`) values (1,'12345678901','北京市海淀区北三环西路甲18号中鼎大厦B座3楼331室','2017-06-27 22:50:18','刘铁蛋','12345678901'),(2,'12345678901','北京市海淀区北三环西路甲18号中坤广场E座10层10017室','2017-08-15 17:15:37','王翠花','12345678901'),(3,'12345678901','上海市杨浦区南京东路66号余庆里2弄6号','2017-08-15 23:59:36','陈二狗','12345678801'),(4,'12345678900','广东理工职业学院','2020-12-20 22:56:07','李浩','13822968044'),(5,'12345678900','广东省中山市广东理工职业学院','2020-12-22 10:13:20','李浩','13822968044'),(6,'12345678900','德国的风格和大风和广东富豪','2020-12-22 20:47:24','李解决','13822968044'),(7,'12345678900','撒旦发射点','2020-12-22 20:48:02','啦啦啦','13822968044'),(8,'13822968043','阿斯弗萨芬我发顺丰给','2020-12-29 19:01:15','李速度','13822968044'),(9,'13822968066','阿斯弗萨芬','2020-12-29 21:34:56','李的','13822968044');

/*Table structure for table `tb_banner` */

DROP TABLE IF EXISTS `tb_banner`;

CREATE TABLE `tb_banner` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `product` char(13) NOT NULL COMMENT '商品（商品编号）',
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `fk_banner_book` (`product`),
  CONSTRAINT `fk_banner_book` FOREIGN KEY (`product`) REFERENCES `tb_book` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='banner记录表';

/*Data for the table `tb_banner` */

insert  into `tb_banner`(`rid`,`product`,`url`) values (2,'9787111563891','/images/banner/banner2.png'),(3,'9787111564805','/images/banner/banner3.png'),(4,'9787115353528','/images/banner/banner4.png'),(5,'9787111526285','/images/banner/banner5.png');

/*Table structure for table `tb_book` */

DROP TABLE IF EXISTS `tb_book`;

CREATE TABLE `tb_book` (
  `isbn` char(13) NOT NULL COMMENT '图书编号',
  `title` varchar(80) NOT NULL COMMENT '标题（书名）',
  `author` varchar(80) NOT NULL COMMENT '作者',
  `price` double(9,2) NOT NULL COMMENT '价格',
  `press` varchar(50) NOT NULL COMMENT '出版社',
  `edition` int(11) NOT NULL DEFAULT '1' COMMENT '版次',
  `published` datetime NOT NULL COMMENT '出版日期/时间',
  `pages` int(11) NOT NULL DEFAULT '0' COMMENT '页数',
  `words` int(11) NOT NULL DEFAULT '0' COMMENT '字数',
  `packaging` varchar(10) NOT NULL DEFAULT '平装' COMMENT '包装',
  `format` varchar(6) NOT NULL DEFAULT '16开' COMMENT '开本',
  `form` varchar(10) NOT NULL DEFAULT '胶版纸' COMMENT '用纸',
  PRIMARY KEY (`isbn`),
  KEY `idx_book_title_author` (`title`,`author`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图书信息表';

/*Data for the table `tb_book` */

insert  into `tb_book`(`isbn`,`title`,`author`,`price`,`press`,`edition`,`published`,`pages`,`words`,`packaging`,`format`,`form`) values ('1234567890123','Java基础','李浩',21.30,'水水水',21,'2020-12-22 22:46:51',122,22121,'平装','32开','胶版纸'),('1234567890142','萨芬','阿萨',28.00,'调度',1,'2020-12-29 17:35:21',212,1234,'平装','32开','铜版纸'),('1234567890211','userInfo','dffsd',233.00,'sdgfsdg',5,'2020-12-29 21:41:49',123,12,'平装','32开','用纸'),('1234567891111','test','人人',23.70,'速度',3,'2020-12-29 17:15:35',222,1122,'平装','32开','胶版纸'),('2134567890000','test','人人',23.70,'速度',3,'2020-12-29 17:14:41',222,1122,'平装','32开','胶版纸'),('9787111213826','Java编程思想','[美] 埃克尔，译者：陈昊鹏 编',86.40,'机械工业出版社',4,'2007-06-01 00:00:00',880,0,'平装','16开','胶版纸'),('9787111526285','Go程序设计语言（英文版）','[美] 艾伦A.A.多诺万 等 著',64.70,'机械工业出版社 ',1,'2016-01-01 00:00:00',366,0,'平装','16开','胶版纸'),('9787111532644','架构即未来','[美] 马丁L.阿伯特（MartinL.Abbott），迈克尔T.费舍尔（MichaelT.Fisher） 著；陈斌 译',81.00,'机械工业出版社',1,'2016-04-01 00:00:00',660,0,'平装','32开','胶版纸'),('9787111545682','Linux运维最佳实践','胥峰，杨俊俊 著',62.70,'机械工业出版社',1,'2016-09-01 00:00:00',325,0,'平装','16开','胶版纸'),('9787111563891','面向机器智能的TensorFlow实践','[美] 山姆·亚伯拉罕（Sam Abrahams），丹尼亚尔·哈夫纳（Danijar Hafner），埃里克·厄威特，阿里尔·斯卡尔皮内里 著；段菲，陈澎 译',56.50,'机械工业出版社',1,'2017-05-01 00:00:00',212,0,'平装','16开','胶版纸'),('9787111564805','企业IT架构转型之道','钟华 著',53.80,'机械工业出版社',1,'2017-05-01 00:00:00',229,0,'平装','16开','胶版纸'),('9787115130228','C Primer Plus','[美] 普拉塔（Prata S.） 著；云巅工作室 编 ',49.80,'人民邮电出版社',5,'2017-06-27 22:44:28',626,1298000,'平装','16开','胶版纸'),('9787115335500','深入浅出Node.js','朴灵 著',57.30,'人民邮电出版社',1,'2013-12-01 00:00:00',348,0,'平装','16开','胶版纸'),('9787115353528','Python基础教程','[挪] Magnus Lie Hetland 著；司维，曾军崴，谭颖华 译',65.60,'人民邮电出版社',2,'2014-06-01 00:00:00',470,727000,'平装','16开','胶版纸'),('9787115386397','Spring MVC学习指南','[美] 戴克（Paul Deck） 著；林仪明，崔毅 译',40.70,'人民邮电出版社 ',1,'2015-05-01 00:00:00',274,0,'平装','16开','胶版纸'),('9787115388025','图解机器学习 ','[日] 杉山将 著；许永伟 译',40.70,'人民邮电出版社',1,'2015-04-01 00:00:00',226,0,'平装','32开','胶版纸'),('9787115435101','Python数据科学指南','印度，Gopi，Subramanian，萨伯拉曼尼安 著；方延风，刘丹 译',66.20,'人民邮电出版社',1,'2016-11-01 00:00:00',380,0,'平装','16开','胶版纸'),('9787121281556','Hadoop 2.X HDFS源码剖析','徐鹏 著',86.40,'电子工业出版社',1,'2016-03-01 00:00:00',554,0,'平装','16开','胶版纸'),('9787121291609','Go语言学习笔记 ','雨痕　 著',73.90,'电子工业出版社',1,'2016-07-01 00:00:00',468,552000,'平装','16开','胶版纸'),('9787302383666','MongoDB大数据处理权威指南','[美] David Hows，Eelco Plugge，Peter Mem 著；王肖峰 译',42.00,'清华大学出版社',2,'2014-11-01 00:00:00',269,0,'平装','16开','胶版纸'),('9787302435167','大数据架构师指南','朱进云 著',38.30,'清华大学出版社',1,'2016-06-01 00:00:00',271,0,'平装','16开','胶版纸'),('9787302459873','数据挖掘与预测分析','[美] Daniel T.Larose，Chantal D.Larose 著',84.10,'清华大学出版社',2,'2017-03-01 00:00:00',725,1144000,'平装','16开','胶版纸'),('9787508344980','Head First Java（涵盖Java5.0）','[美] 塞若（Sierra K.），[美] 贝茨（Bates B.） 著',53.90,'中国电力出版社',2,'2007-02-01 00:00:00',689,983000,'平装','16开','胶版纸');

/*Table structure for table `tb_book_image` */

DROP TABLE IF EXISTS `tb_book_image`;

CREATE TABLE `tb_book_image` (
  `img_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` tinyint(4) DEFAULT NULL,
  `url` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `book_isbn` char(13) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`img_id`),
  KEY `idx_book_img_isbn` (`book_isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=197 DEFAULT CHARSET=utf8;

/*Data for the table `tb_book_image` */

insert  into `tb_book_image`(`img_id`,`type`,`url`,`book_isbn`) values (6,2,'/images/goods/9787111213826/collect.jpg','9787111213826'),(7,3,'/images/goods/9787111213826/detail1.jpg','9787111213826'),(8,6,'/images/goods/9787111213826/detail1big.jpg','9787111213826'),(9,0,'/images/goods/9787111213826/index.jpg','9787111213826'),(10,1,'/images/goods/9787111213826/intro.jpg','9787111213826'),(11,1,'/images/goods/9787111526285/intro.jpg','9787111526285'),(12,0,'/images/goods/9787111526285/index.jpg','9787111526285'),(13,6,'/images/goods/9787111526285/detail1big.jpg','9787111526285'),(14,3,'/images/goods/9787111526285/detail1.jpg','9787111526285'),(15,2,'/images/goods/9787111526285/collect.jpg','9787111526285'),(16,2,'/images/goods/9787111532644/collect.jpg','9787111532644'),(17,0,'/images/goods/9787111532644/index.jpg','9787111532644'),(18,1,'/images/goods/9787111532644/intro.jpg','9787111532644'),(19,3,'/images/goods/9787111532644/detail1.jpg','9787111532644'),(20,6,'/images/goods/9787111532644/detail1big.jpg','9787111532644'),(21,4,'/images/goods/9787111532644/detail2.jpg','9787111532644'),(22,7,'/images/goods/9787111532644/detail2big.jpg','9787111532644'),(23,8,'/images/goods/9787111532644/detail3big.jpg','9787111532644'),(24,5,'/images/goods/9787111532644/detail3.jpg','9787111532644'),(25,0,'/images/goods/9787111545682/index.jpg','9787111545682'),(26,1,'/images/goods/9787111545682/intro.jpg','9787111545682'),(27,2,'/images/goods/9787111545682/collect.jpg','9787111545682'),(28,3,'/images/goods/9787111545682/detail1.jpg','9787111545682'),(29,4,'/images/goods/9787111545682/detail2.jpg','9787111545682'),(30,5,'/images/goods/9787111545682/detail3.jpg','9787111545682'),(31,6,'/images/goods/9787111545682/detail1big.jpg','9787111545682'),(32,7,'/images/goods/9787111545682/detail2big.jpg','9787111545682'),(33,8,'/images/goods/9787111545682/detail3big.jpg','9787111545682'),(34,0,'/images/goods/9787111563891/index.jpg','9787111563891'),(35,1,'/images/goods/9787111563891/intro.jpg','9787111563891'),(36,2,'/images/goods/9787111563891/collect.jpg','9787111563891'),(37,3,'/images/goods/9787111563891/detail1.jpg','9787111563891'),(38,4,'/images/goods/9787111563891/detail2.jpg','9787111563891'),(39,5,'/images/goods/9787111563891/detail3.jpg','9787111563891'),(40,6,'/images/goods/9787111563891/detail1big.jpg','9787111563891'),(41,7,'/images/goods/9787111563891/detail2big.jpg','9787111563891'),(42,8,'/images/goods/9787111563891/detail3big.jpg','9787111563891'),(43,0,'/images/goods/9787111564805/index.jpg','9787111564805'),(44,1,'/images/goods/9787111564805/intro.jpg','9787111564805'),(45,2,'/images/goods/9787111564805/collect.jpg','9787111564805'),(46,3,'/images/goods/9787111564805/detail1.jpg','9787111564805'),(47,6,'/images/goods/9787111564805/detail1big.jpg','9787111564805'),(48,0,'/images/goods/9787115130228/index.jpg','9787115130228'),(49,1,'/images/goods/9787115130228/intro.jpg','9787115130228'),(50,2,'/images/goods/9787115130228/collect.jpg','9787115130228'),(51,3,'/images/goods/9787115130228/detail1.jpg','9787115130228'),(52,6,'/images/goods/9787115130228/detail1big.jpg','9787115130228'),(53,0,'/images/goods/9787115335500/index.jpg','9787115335500'),(54,1,'/images/goods/9787115335500/intro.jpg','9787115335500'),(55,2,'/images/goods/9787115335500/collect.jpg','9787115335500'),(56,3,'/images/goods/9787115335500/detail1.jpg','9787115335500'),(57,6,'/images/goods/9787115335500/detail1big.jpg','9787115335500'),(58,7,'/images/goods/9787115335500/detail2big.jpg','9787115335500'),(59,8,'/images/goods/9787115335500/detail3big.jpg','9787115335500'),(60,4,'/images/goods/9787115335500/detail2.jpg','9787115335500'),(61,5,'/images/goods/9787115335500/detail3.jpg','9787115335500'),(62,0,'/images/goods/9787115353528/index.jpg','9787115353528'),(63,1,'/images/goods/9787115353528/intro.jpg','9787115353528'),(64,2,'/images/goods/9787115353528/collect.jpg','9787115353528'),(65,3,'/images/goods/9787115353528/detail1.jpg','9787115353528'),(66,6,'/images/goods/9787115353528/detail1big.jpg','9787115353528'),(67,7,'/images/goods/9787115353528/detail2big.jpg','9787115353528'),(68,8,'/images/goods/9787115353528/detail3big.jpg','9787115353528'),(69,4,'/images/goods/9787115353528/detail2.jpg','9787115353528'),(70,5,'/images/goods/9787115353528/detail3.jpg','9787115353528'),(71,0,'/images/goods/9787115386397/index.jpg','9787115386397'),(72,1,'/images/goods/9787115386397/intro.jpg','9787115386397'),(73,2,'/images/goods/9787115386397/collect.jpg','9787115386397'),(74,3,'/images/goods/9787115386397/detail1.jpg','9787115386397'),(75,6,'/images/goods/9787115386397/detail1big.jpg','9787115386397'),(76,7,'/images/goods/9787115386397/detail2big.jpg','9787115386397'),(77,8,'/images/goods/9787115386397/detail3big.jpg','9787115386397'),(78,4,'/images/goods/9787115386397/detail2.jpg','9787115386397'),(79,5,'/images/goods/9787115386397/detail3.jpg','9787115386397'),(80,0,'/images/goods/9787115388025/index.jpg','9787115388025'),(81,1,'/images/goods/9787115388025/intro.jpg','9787115388025'),(82,2,'/images/goods/9787115388025/collect.jpg','9787115388025'),(83,3,'/images/goods/9787115388025/detail1.jpg','9787115388025'),(84,6,'/images/goods/9787115388025/detail1big.jpg','9787115388025'),(85,0,'/images/goods/9787115435101/index.jpg','9787115435101'),(86,1,'/images/goods/9787115435101/intro.jpg','9787115435101'),(87,2,'/images/goods/9787115435101/collect.jpg','9787115435101'),(88,3,'/images/goods/9787115435101/detail1.jpg','9787115435101'),(89,6,'/images/goods/9787115435101/detail1big.jpg','9787115435101'),(90,0,'/images/goods/9787121281556/index.jpg','9787121281556'),(91,1,'/images/goods/9787121281556/intro.jpg','9787121281556'),(92,2,'/images/goods/9787121281556/collect.jpg','9787121281556'),(93,3,'/images/goods/9787121281556/detail1.jpg','9787121281556'),(94,6,'/images/goods/9787121281556/detail1big.jpg','9787121281556'),(95,0,'/images/goods/9787121291609/index.jpg','9787121291609'),(96,1,'/images/goods/9787121291609/intro.jpg','9787121291609'),(97,2,'/images/goods/9787121291609/collect.jpg','9787121291609'),(98,3,'/images/goods/9787121291609/detail1.jpg','9787121291609'),(99,6,'/images/goods/9787121291609/detail1big.jpg','9787121291609'),(100,0,'/images/goods/9787302383666/index.jpg','9787302383666'),(101,1,'/images/goods/9787302383666/intro.jpg','9787302383666'),(102,2,'/images/goods/9787302383666/collect.jpg','9787302383666'),(103,3,'/images/goods/9787302383666/detail1.jpg','9787302383666'),(104,6,'/images/goods/9787302383666/detail1big.jpg','9787302383666'),(105,0,'/images/goods/9787302435167/index.jpg','9787302435167'),(106,1,'/images/goods/9787302435167/intro.jpg','9787302435167'),(107,2,'/images/goods/9787302435167/collect.jpg','9787302435167'),(108,3,'/images/goods/9787302435167/detail1.jpg','9787302435167'),(109,6,'/images/goods/9787302435167/detail1big.jpg','9787302435167'),(110,0,'/images/goods/9787302459873/index.jpg','9787302459873'),(111,1,'/images/goods/9787302459873/intro.jpg','9787302459873'),(112,2,'/images/goods/9787302459873/collect.jpg','9787302459873'),(113,3,'/images/goods/9787302459873/detail1.jpg','9787302459873'),(114,6,'/images/goods/9787302459873/detail1big.jpg','9787302459873'),(115,7,'/images/goods/9787302459873/detail2big.jpg','9787302459873'),(116,8,'/images/goods/9787302459873/detail3big.jpg','9787302459873'),(117,4,'/images/goods/9787302459873/detail2.jpg','9787302459873'),(118,5,'/images/goods/9787302459873/detail3.jpg','9787302459873'),(119,0,'/images/goods/9787508344980/index.jpg','9787508344980'),(120,1,'/images/goods/9787508344980/intro.jpg','9787508344980'),(121,2,'/images/goods/9787508344980/collect.jpg','9787508344980'),(122,3,'/images/goods/9787508344980/detail1.jpg','9787508344980'),(123,6,'/images/goods/9787508344980/detail1big.jpg','9787508344980'),(124,7,'/images/goods/9787508344980/detail2big.jpg','9787508344980'),(125,4,'/images/goods/9787508344980/detail2.jpg','9787508344980'),(152,0,'/images/goods/1234567890123/index.jpg','1234567890123'),(153,1,'/images/goods/1234567890123/intro.jpg','1234567890123'),(154,2,'/images/goods/1234567890123/collect.jpg','1234567890123'),(155,3,'/images/goods/1234567890123/detail1.jpg','1234567890123'),(156,4,'/images/goods/1234567890123/detail2.jpg','1234567890123'),(157,5,'/images/goods/1234567890123/detail3.jpg','1234567890123'),(158,6,'/images/goods/1234567890123/detail1big.jpg','1234567890123'),(159,7,'/images/goods/1234567890123/detail2big.jpg','1234567890123'),(160,8,'/images/goods/1234567890123/detail3big.jpg','1234567890123'),(161,0,'/images/goods/2134567890000/index.jpg','2134567890000'),(162,1,'/images/goods/2134567890000/intro.jpg','2134567890000'),(163,2,'/images/goods/2134567890000/collect.jpg','2134567890000'),(164,3,'/images/goods/2134567890000/detail1.jpg','2134567890000'),(165,4,'/images/goods/2134567890000/detail2.jpg','2134567890000'),(166,5,'/images/goods/2134567890000/detail3.jpg','2134567890000'),(167,6,'/images/goods/2134567890000/detail1big.jpg','2134567890000'),(168,7,'/images/goods/2134567890000/detail2big.jpg','2134567890000'),(169,8,'/images/goods/2134567890000/detail3big.jpg','2134567890000'),(170,0,'/images/goods/1234567891111/index.jpg','1234567891111'),(171,1,'/images/goods/1234567891111/intro.jpg','1234567891111'),(172,2,'/images/goods/1234567891111/collect.jpg','1234567891111'),(173,3,'/images/goods/1234567891111/detail1.jpg','1234567891111'),(174,4,'/images/goods/1234567891111/detail2.jpg','1234567891111'),(175,5,'/images/goods/1234567891111/detail3.jpg','1234567891111'),(176,6,'/images/goods/1234567891111/detail1big.jpg','1234567891111'),(177,7,'/images/goods/1234567891111/detail2big.jpg','1234567891111'),(178,8,'/images/goods/1234567891111/detail3big.jpg','1234567891111'),(179,0,'/images/goods/1234567890142/index.jpg','1234567890142'),(180,1,'/images/goods/1234567890142/intro.jpg','1234567890142'),(181,2,'/images/goods/1234567890142/collect.jpg','1234567890142'),(182,3,'/images/goods/1234567890142/detail1.jpg','1234567890142'),(183,4,'/images/goods/1234567890142/detail2.jpg','1234567890142'),(184,5,'/images/goods/1234567890142/detail3.jpg','1234567890142'),(185,6,'/images/goods/1234567890142/detail1big.jpg','1234567890142'),(186,7,'/images/goods/1234567890142/detail2big.jpg','1234567890142'),(187,8,'/images/goods/1234567890142/detail3big.jpg','1234567890142'),(188,0,'/images/goods/1234567890211/index.jpg','1234567890211'),(189,1,'/images/goods/1234567890211/intro.jpg','1234567890211'),(190,2,'/images/goods/1234567890211/collect.jpg','1234567890211'),(191,3,'/images/goods/1234567890211/detail1.jpg','1234567890211'),(192,4,'/images/goods/1234567890211/detail2.jpg','1234567890211'),(193,5,'/images/goods/1234567890211/detail3.jpg','1234567890211'),(194,6,'/images/goods/1234567890211/detail1big.jpg','1234567890211'),(195,7,'/images/goods/1234567890211/detail2big.jpg','1234567890211'),(196,8,'/images/goods/1234567890211/detail3big.jpg','1234567890211');

/*Table structure for table `tb_cart_item` */

DROP TABLE IF EXISTS `tb_cart_item`;

CREATE TABLE `tb_cart_item` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `user_id` char(11) NOT NULL COMMENT '用户编号（用户手机号）',
  `product` char(13) NOT NULL COMMENT '商品（商品编号）',
  `count` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`rid`),
  KEY `fk_cart_item_book` (`product`),
  KEY `fk_cart_item_user` (`user_id`),
  CONSTRAINT `fk_cart_item_book` FOREIGN KEY (`product`) REFERENCES `tb_book` (`isbn`),
  CONSTRAINT `fk_cart_item_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='购物车信息表';

/*Data for the table `tb_cart_item` */

insert  into `tb_cart_item`(`rid`,`user_id`,`product`,`count`) values (1,'12345678901','9787302383666',3),(2,'12345678901','9787111213826',2),(3,'12345678901','9787115130228',1),(13,'12345678900','9787302383666',2),(16,'13822968044','9787111213826',2),(17,'13822968044','9787115386397',2),(20,'12345678900','9787115130228',1),(21,'13822968043','9787111532644',2),(22,'13822968043','9787115353528',2),(23,'13822968066','9787115388025',3),(24,'13822968066','9787111526285',1),(25,'13822968066','9787111545682',1);

/*Table structure for table `tb_collect` */

DROP TABLE IF EXISTS `tb_collect`;

CREATE TABLE `tb_collect` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `user_id` char(11) NOT NULL COMMENT '用户编号（用户手机号）',
  `product` char(13) NOT NULL COMMENT '商品（商品编号）',
  PRIMARY KEY (`rid`),
  KEY `fk_collect_user` (`user_id`),
  KEY `fk_collect_book` (`product`),
  CONSTRAINT `fk_collect_book` FOREIGN KEY (`product`) REFERENCES `tb_book` (`isbn`),
  CONSTRAINT `fk_collect_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='用户收藏表';

/*Data for the table `tb_collect` */

insert  into `tb_collect`(`rid`,`user_id`,`product`) values (1,'12345678901','9787302383666'),(2,'12345678901','9787115130228'),(3,'12345678901','9787111532644'),(4,'12345678901','9787111545682'),(5,'12345678901','9787115335500'),(6,'12345678901','9787302435167'),(9,'12345678900','9787115353528'),(10,'12345678900','9787111563891'),(11,'12345678900','9787115388025'),(12,'12345678900','9787115435101'),(18,'13822968044','9787115130228'),(19,'12345678900','9787115386397'),(20,'13822968043','9787111532644'),(23,'13822968066','9787115388025');

/*Table structure for table `tb_order` */

DROP TABLE IF EXISTS `tb_order`;

CREATE TABLE `tb_order` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `user_id` char(11) NOT NULL COMMENT '用户编号（用户手机号）',
  `order_id` char(15) NOT NULL COMMENT '订单编号（手机号后3位+yyyyMMddHHmm）',
  `sta` varchar(10) NOT NULL COMMENT '订单状态（待处理；处理中；已发货；已交付）',
  `address_id` int(11) DEFAULT NULL COMMENT '收货地址',
  `payment` double(9,2) DEFAULT NULL COMMENT '支付金额',
  `placed` datetime DEFAULT NULL COMMENT '下单时间',
  `receipt` datetime DEFAULT NULL COMMENT '接单时间',
  `deliver` datetime DEFAULT NULL COMMENT '发货时间',
  `handover` datetime DEFAULT NULL COMMENT '交付时间',
  PRIMARY KEY (`rid`),
  UNIQUE KEY `uni_order` (`order_id`),
  KEY `fk_order_user` (`user_id`),
  KEY `fk_order_address` (`address_id`),
  CONSTRAINT `fk_order_address` FOREIGN KEY (`address_id`) REFERENCES `tb_address` (`rid`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='订单信息表';

/*Data for the table `tb_order` */

insert  into `tb_order`(`rid`,`user_id`,`order_id`,`sta`,`address_id`,`payment`,`placed`,`receipt`,`deliver`,`handover`) values (4,'12345678900','900202012221014','已交付',5,147.60,'2020-12-22 10:14:15','2020-12-22 10:48:03','2020-12-22 13:48:03','2020-12-22 18:58:40'),(5,'12345678900','900202012221630','已发货',5,40.70,'2020-12-22 16:30:28','2020-12-22 16:30:44','2020-12-22 22:31:54',NULL),(6,'12345678900','900202012221929','已发货',4,252.30,'2020-12-22 19:29:11','2020-12-22 19:29:47','2020-12-22 22:51:09',NULL),(7,'12345678900','900202012222109','处理中',5,107.80,'2020-12-22 21:09:23','2020-12-22 21:09:36',NULL,NULL),(8,'12345678900','900202012231430','处理中',5,228.80,'2020-12-23 14:30:50','2020-12-23 14:31:05',NULL,NULL),(9,'12345678900','900202012231621','处理中',5,231.00,'2020-12-23 16:21:36','2020-12-23 16:21:43',NULL,NULL),(10,'12345678900','900202012241951','处理中',5,84.00,'2020-12-24 19:51:06','2020-12-24 19:51:32',NULL,NULL),(11,'12345678900','900202012241955','待处理',NULL,133.80,'2020-12-24 19:55:45',NULL,NULL,NULL),(12,'13822968043','043202012291900','已交付',8,293.20,'2020-12-29 19:00:44','2020-12-29 19:01:39','2020-12-29 19:07:15','2020-12-29 19:07:56'),(13,'13822968066','066202012292134','已交付',9,186.80,'2020-12-29 21:34:25','2020-12-29 21:36:11','2020-12-29 21:36:55','2020-12-29 21:37:49'),(14,'13822968066','066202012292138','处理中',9,249.50,'2020-12-29 21:38:49','2020-12-29 21:38:56',NULL,NULL),(15,'12345678900','900202012292143','处理中',4,233.00,'2020-12-29 21:43:02','2020-12-29 21:43:12',NULL,NULL);

/*Table structure for table `tb_order_item` */

DROP TABLE IF EXISTS `tb_order_item`;

CREATE TABLE `tb_order_item` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `product` char(13) NOT NULL COMMENT '商品（商品编号）',
  `price` double(9,2) NOT NULL COMMENT '价格',
  `count` int(11) NOT NULL COMMENT '数量',
  `order_id` char(15) NOT NULL COMMENT '订单编号',
  PRIMARY KEY (`rid`),
  KEY `fk_order_item_order` (`order_id`),
  KEY `fk_order_item_book` (`product`),
  CONSTRAINT `fk_order_item_book` FOREIGN KEY (`product`) REFERENCES `tb_book` (`isbn`),
  CONSTRAINT `fk_order_item_order` FOREIGN KEY (`order_id`) REFERENCES `tb_order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='订单项目表';

/*Data for the table `tb_order_item` */

insert  into `tb_order_item`(`rid`,`product`,`price`,`count`,`order_id`) values (6,'9787115386397',40.70,2,'900202012221014'),(7,'9787115435101',66.20,1,'900202012221014'),(8,'9787115388025',40.70,1,'900202012221630'),(9,'9787111545682',62.70,1,'900202012221929'),(10,'9787115386397',40.70,2,'900202012221929'),(11,'9787115435101',66.20,1,'900202012221929'),(12,'9787302383666',42.00,1,'900202012221929'),(13,'9787508344980',53.90,2,'900202012222109'),(14,'9787111526285',64.70,1,'900202012231430'),(15,'9787115386397',40.70,3,'900202012231430'),(16,'9787302383666',42.00,1,'900202012231430'),(17,'9787115386397',40.70,2,'900202012231621'),(18,'9787302383666',42.00,1,'900202012231621'),(19,'9787111564805',53.80,2,'900202012231621'),(20,'9787302383666',42.00,2,'900202012241951'),(21,'9787115130228',49.80,1,'900202012241955'),(22,'9787302383666',42.00,2,'900202012241955'),(23,'9787111532644',81.00,2,'043202012291900'),(24,'9787115353528',65.60,2,'043202012291900'),(25,'9787111526285',64.70,1,'066202012292134'),(26,'9787115388025',40.70,3,'066202012292134'),(27,'9787111526285',64.70,1,'066202012292138'),(28,'9787111545682',62.70,1,'066202012292138'),(29,'9787115388025',40.70,3,'066202012292138'),(30,'1234567890211',233.00,1,'900202012292143');

/*Table structure for table `tb_recommended` */

DROP TABLE IF EXISTS `tb_recommended`;

CREATE TABLE `tb_recommended` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `product` char(13) NOT NULL COMMENT '商品（商品编号）',
  PRIMARY KEY (`rid`),
  KEY `fk_recommended_book` (`product`),
  CONSTRAINT `fk_recommended_book` FOREIGN KEY (`product`) REFERENCES `tb_book` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商品推荐表';

/*Data for the table `tb_recommended` */

insert  into `tb_recommended`(`rid`,`product`) values (4,'9787111213826'),(3,'9787111545682'),(2,'9787115335500'),(1,'9787302435167');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `phone` char(11) NOT NULL COMMENT '电话（手机号）',
  `uname` varchar(30) NOT NULL COMMENT '用户名',
  `upwd` varchar(30) NOT NULL DEFAULT '000000' COMMENT '密码',
  `email` varchar(30) NOT NULL COMMENT '邮箱',
  `role` int(1) NOT NULL DEFAULT '0' COMMENT '角色（1表示管理员）',
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `tb_user` */

insert  into `tb_user`(`phone`,`uname`,`upwd`,`email`,`role`) values ('11112111221','lsdfs','123456','121121221@qq.com',0),('123','hahah','123','dsada',0),('12345678900','admin1','12345678','admin1@abc',1),('12345678901','user01','000000','user01@abc',0),('12345678902','user02','000000','user02@abc',0),('13822968022','SDFSDG','DSSDFGSDDDD','1799573106@qq.com',0),('13822968043','HHHSF','12345678','1799573108@qq.co',0),('13822968044','hello999','123456','1799573106@qq.com',0),('13822968066','jjjjjjj','123456789','1799573106@qq.com',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
