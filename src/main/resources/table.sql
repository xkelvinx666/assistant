-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 118.89.52.145    Database: d_assistant
-- ------------------------------------------------------
-- Server version	5.5.56-MariaDB

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
  PRIMARY KEY (`f_id`),
  KEY `fk_user_idx` (`f_user`),
  KEY `fk_translate_idx` (`f_translate`),
  CONSTRAINT `fk_translate` FOREIGN KEY (`f_translate`) REFERENCES `t_translate` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user` FOREIGN KEY (`f_user`) REFERENCES `t_user` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_habit`
--

LOCK TABLES `t_habit` WRITE;
/*!40000 ALTER TABLE `t_habit` DISABLE KEYS */;
INSERT INTO `t_habit` VALUES (4,1,2,2),(5,2,2,1);
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
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_isp`
--

LOCK TABLES `t_isp` WRITE;
/*!40000 ALTER TABLE `t_isp` DISABLE KEYS */;
INSERT INTO `t_isp` VALUES (1,'腾讯云api');
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
  `f_source` longtext,
  `f_target` longtext,
  `f_type` bigint(20) NOT NULL,
  `f_isp` bigint(20) NOT NULL,
  PRIMARY KEY (`f_id`),
  KEY `fk_isp_idx` (`f_isp`),
  KEY `fk_type_idx` (`f_type`),
  CONSTRAINT `fk_isp` FOREIGN KEY (`f_isp`) REFERENCES `t_isp` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_type` FOREIGN KEY (`f_type`) REFERENCES `t_type` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_translate`
--

LOCK TABLES `t_translate` WRITE;
/*!40000 ALTER TABLE `t_translate` DISABLE KEYS */;
INSERT INTO `t_translate` VALUES (1,'Hello World!','你好，世界！',2,1),(2,'Gareth Southgate\'s side recorded England\'s first win in the opening game of a major tournament since they beat Paraguay in the 2006 World Cup.\n\nEngland\'s captain gave them the reward they deserved for a brilliant start by turning in the opener in the 11th minute after Tunisia keeper Mouez Hassen, who went off injured in the first half, clawed out John Stones\' header.\n\nEngland ran Tunisia ragged in that spell but were punished for missing a host of chances when Tunisia\'s Ferjani Sassi equalised from the penalty spot against the run of play after Kyle Walker was penalised for an elbow on Fakhreddine Ben Youssef.\n\nTunisia dug in to frustrate England in the second half but Kane was the match-winner with a late header from Harry Maguire\'s flick, justice being done after referee Wilmar Roldan and the video assistant referee (VAR) had failed to spot him clearly being wrestled to the ground twice in the penalty area.\n\nEngland play Panama, who lost 3-0 to Belgium earlier on Monday, in their next Group G game on Sunday, which kicks off at 13:00 BST and will be shown live on the BBC.','加雷斯·索斯盖特的球队记录了英格兰自2006年世界杯击败巴拉圭以来首次在一场重大赛事的首场比赛中获胜。英格兰队长在上半场受伤的突尼斯门将穆埃兹·哈森(Mouez Hassen)抢断约翰·斯通(John Stones)的头球后，在第11分钟交出了开局，给了他们应得的奖励。但是，当突尼斯的费贾尼·萨西(Ferjani Sassi)在法赫雷丁·本·优素福(Fakhreddine Ben Youssef)的肘部被罚进罚球局后，突尼斯人费贾尼·萨西(Ferjani Sassi)从点球的点球中扳平了很多机会，他受到了惩罚。突尼斯在下半场试图挫败英格兰队，但凯恩是比赛中的赢家，哈里·马奎尔(Harry Maguire)的短发球视频助理裁判(VAR)未能清楚地发现他在禁区内两次被摔在地上。英格兰队在下周一早些时候以3比0输给比利时的巴拿马队将在周日举行的下一场G组比赛中亮相，比赛将在英国时间下午13点开始，并将在BBC现场直播。',2,1);
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
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_type`
--

LOCK TABLES `t_type` WRITE;
/*!40000 ALTER TABLE `t_type` DISABLE KEYS */;
INSERT INTO `t_type` VALUES (1,'image'),(2,'text');
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
  `f_open_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'fromUser'),(2,'oV9ko0rab2d');
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

-- Dump completed on 2018-06-19 19:42:31
