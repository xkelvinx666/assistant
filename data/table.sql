-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: d_assistant
-- ------------------------------------------------------
-- Server version	5.7.22

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
-- Table structure for table `t_habit`
--

DROP TABLE IF EXISTS `t_habit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_habit` (
  `f_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `f_translate` bigint(20) NOT NULL,
  `f_user` bigint(20) NOT NULL,
  `f_count` int(11) DEFAULT '0',
  `f_is_delete` tinyint(4) NOT NULL DEFAULT '0',
  `f_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`f_id`),
  KEY `fk_user_idx` (`f_user`),
  KEY `fk_translate_idx` (`f_translate`),
  CONSTRAINT `fk_translate` FOREIGN KEY (`f_translate`) REFERENCES `t_translate` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user` FOREIGN KEY (`f_user`) REFERENCES `t_user` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_habit`
--

LOCK TABLES `t_habit` WRITE;
/*!40000 ALTER TABLE `t_habit` DISABLE KEYS */;
INSERT INTO `t_habit` VALUES (7,1,1,4,0,NULL),(14,24,2,1,0,NULL),(15,24,2,0,0,NULL),(16,25,2,1,0,NULL),(17,26,2,2,0,NULL),(19,26,1,1,0,NULL),(22,30,1,2,0,NULL),(23,31,2,1,0,NULL),(24,32,2,1,0,NULL),(25,33,2,1,0,NULL),(26,30,2,1,0,NULL),(27,34,2,1,0,NULL),(28,35,2,1,0,NULL),(29,36,2,1,0,NULL),(30,37,2,1,0,NULL),(31,38,2,1,0,NULL);
/*!40000 ALTER TABLE `t_habit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_isp`
--

DROP TABLE IF EXISTS `t_isp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_isp` (
  `f_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(45) DEFAULT NULL,
  `f_is_delete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_isp`
--

LOCK TABLES `t_isp` WRITE;
/*!40000 ALTER TABLE `t_isp` DISABLE KEYS */;
INSERT INTO `t_isp` VALUES (1,'腾讯云api',0);
/*!40000 ALTER TABLE `t_isp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_translate`
--

DROP TABLE IF EXISTS `t_translate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_translate` (
  `f_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `f_source` text,
  `f_target` text,
  `f_type` bigint(20) NOT NULL,
  `f_isp` bigint(20) NOT NULL,
  `f_is_delete` tinyint(4) NOT NULL DEFAULT '0',
  `f_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`f_id`),
  KEY `fk_isp_idx` (`f_isp`),
  KEY `fk_type_idx` (`f_type`),
  CONSTRAINT `fk_isp` FOREIGN KEY (`f_isp`) REFERENCES `t_isp` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_type` FOREIGN KEY (`f_type`) REFERENCES `t_type` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_translate`
--

LOCK TABLES `t_translate` WRITE;
/*!40000 ALTER TABLE `t_translate` DISABLE KEYS */;
INSERT INTO `t_translate` VALUES (1,'Hello World!','你好，世界！',2,1,0,NULL),(2,'Hello World!','你好，世界！',2,1,0,NULL),(24,'http://mmbiz.qpic.cn/mmbiz_jpg/pq5dLyDEX4o3ajf2ficGkkcDjJTTuibHbMJmM8iaxrYguyROFCzmGeVAOrYScMVpJqLHcjOGJVdVkUcAiamwb9UJJA/0','诺尔',1,1,0,NULL),(25,'http://mmbiz.qpic.cn/mmbiz_jpg/pq5dLyDEX4o3ajf2ficGkkcDjJTTuibHbMURmCh7H2FevicVPBKrKnqoVz2j3rpiaiakkFfAtTVGd6WHbJRlgwZoKSA/0','源文字 :  助理Connor \n翻译文字 :Assistant Connor',1,1,0,NULL),(26,'http://mmbiz.qpic.cn/mmbiz_jpg/pq5dLyDEX4o3ajf2ficGkkcDjJTTuibHbMy1o6uGEY5rHoqxsjX9gwxAuCPEGUAqH22VwSwX5TiaQSjkr36w17TiaA/0','源文字 :  微信公众平台 \n翻译文字 :WeChat public platform',1,1,0,NULL),(30,'http://mmbiz.qpic.cn/mmbiz_jpg/pq5dLyDEX4o3ajf2ficGkkcDjJTTuibHbMIR4c0BibXS00vEbdAoTN1m9dwjVoQho23wYgzibiaWlP8sL8gn7coFsvA/0','',1,1,0,NULL),(31,'http://mmbiz.qpic.cn/mmbiz_jpg/pq5dLyDEX4o3ajf2ficGkkcDjJTTuibHbM6NrPevZOMIE4SyFX89NsqvN4muuZo9dMOKpLtk78eyWBs3wCHqRECg/0','源文字:  Local instance 3306 \n翻译文字: 本地实例3306\n',1,1,0,NULL),(32,'http://mmbiz.qpic.cn/mmbiz_jpg/pq5dLyDEX4o3ajf2ficGkkcDjJTTuibHbMjxbu2MKIia0s5crSfyzv7YVuxWiaCSHa9YKwLv5lXINu1ejt2hk6oJYA/0','源文字:  Hunk1 : Lines 54-64 \n翻译文字: Hunk 1：第54-64行\n源文字:  <artifactId>velocity</artifactId> \n翻译文字: <artifactId>速度</artifactId>\n源文字:  <version>1.7</version> \n翻译文字: <Version>1.7</version>\n源文字:  </ dependency> \n翻译文字: </依赖>\n源文字:  <dependency> \n翻译文字: <依赖>\n源文字:  <groupId>commons-iox/groupId> \n翻译文字: <groupId>Common-iox/groupId>\n源文字:  <artifactId>commons-io</artifactId> \n翻译文字: <artifactId>Common-io</artifactId>\n源文字:  <vers ion>2. 6</version> \n翻译文字: <VERS离子>2。6</Version>\n源文字:  </dependency> \n翻译文字: </依赖>\n源文字:  <dependency> \n翻译文字: <依赖>\n源文字:  <groupId>org. springf ramework. session</groupId> \n翻译文字: <groupId>org.sprframework.session</groupId>\n',1,1,0,NULL),(33,'http://mmbiz.qpic.cn/mmbiz_jpg/pq5dLyDEX4o3ajf2ficGkkcDjJTTuibHbMTTBaiay7EKZ8EC8jmwe9t9V9uuqFIMcewPSV3KKtGstLDUlNNXOQsJg/0','源文字:  Unstaged files\n ES\n 口■1ogs\n IDULES\n 口▼■src\n C\n main\n EES\n 口\n 口\n 口 cailinbiao\n 口\n assistant\n 口 controller\n 口\n service\n 口 )■util\n 口\n resources\n pom.xml\n\n翻译文字: 未分阶段的文件\n埃斯\n口1\n艾德莱(IDULES)\n口src\n丙\n主\nEES\n口\n口\n口cailinbiao\n口\n助教\n口控制器\n口\n服务\n(口)util\n口\n资源\n柚木\n',1,1,0,NULL),(34,'http://mmbiz.qpic.cn/mmbiz_jpg/pq5dLyDEX4o3ajf2ficGkkcDjJTTuibHbMsy9Uqianw8y52Iau4DWklticfvt41lLevCjke1icMgTrdibpbco63lsMJQ/0','源文字:  assistant\n\n翻译文字: 助教\n',1,1,0,NULL),(35,'http://mmbiz.qpic.cn/mmbiz_jpg/pq5dLyDEX4o3ajf2ficGkkcDjJTTuibHbMkTRWQkoWJlGQTGG2CicUW5VZPafPdFFvxZguJF1HeFUFcvibSWWq3LWA/0','源文字:  <artifactId>velocity</artifactId>\n <version>1.7</version>\n </ dependency>\n <dependency>\n <g roupId>commons- io</groupId>\n <artifactId>commons-io</artifactId>\n <vers ion>2.6</version>\n </dependency>\n <dependency>\n <groupId>org. springf ramework. session</groupId>\n\n翻译文字: <artifactId>速度</artifactId>\n<Version>1.7</version>\n</依赖>\n<依赖>\n<g roupId>Common-io</groupId>\n<artifactId>Common-io</artifactId>\n<VERS离子>2.6</Version>\n</依赖>\n<依赖>\n<groupId>org.sprframework.session</groupId>\n',1,1,0,NULL),(36,'http://mmbiz.qpic.cn/mmbiz_jpg/pq5dLyDEX4o3ajf2ficGkkcDjJTTuibHbMCyibWI8icuGhV1lGyKYianxKCxbhZjiaFpH6PHHmXZjoEHy5cSKsE9fzbQ/0','源文字:  安装Java SDK前，先获取安全凭证。在第一次使用云API之前，用户首先需要在腾讯云控制台，上申请安全凭证，安全凭证包括\n SecretID和SecretKey, SecretID 是用于标识API调用者的身份，SecretKey是 用于加密签名字符串和服务器端验证签名字符串的密\n 钥。SecretKey必须严格保管,避免泄露。\n\n翻译文字: 安装JavaSDK前，先获取安全凭证。在第一次使用云api之前，用户首先需要在腾讯云控制台，上申请安全凭证，安全凭证包括\n和秘书、秘书是用于标识API调用者的身份、秘书Key是用于加密签名字符串和服务器端验证签名字符串的密\n钥.必须严格保管，避免泄露.\n',1,1,0,NULL),(37,'Google','谷歌',2,1,0,NULL),(38,'Alpha','阿尔法',2,1,0,NULL);
/*!40000 ALTER TABLE `t_translate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_type`
--

DROP TABLE IF EXISTS `t_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_type` (
  `f_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(45) DEFAULT NULL,
  `f_is_delete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_type`
--

LOCK TABLES `t_type` WRITE;
/*!40000 ALTER TABLE `t_type` DISABLE KEYS */;
INSERT INTO `t_type` VALUES (1,'image',0),(2,'text',0);
/*!40000 ALTER TABLE `t_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `f_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(45) DEFAULT NULL,
  `f_is_delete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'fromUser',0),(2,'oV9ko0rab2delmwdoRIjxkKhyshI',0);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-24 23:42:10
