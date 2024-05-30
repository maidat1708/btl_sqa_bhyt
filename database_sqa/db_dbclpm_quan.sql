-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: db_dbclpm
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `quan`
--

DROP TABLE IF EXISTS `quan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idBHYT` varchar(45) NOT NULL,
  `ten` varchar(45) NOT NULL,
  `mucDong` double DEFAULT NULL,
  `daDong` double DEFAULT NULL,
  `conNo` double DEFAULT NULL,
  `soLuong` int DEFAULT NULL,
  `tuNgay` date DEFAULT NULL,
  `denNgay` date DEFAULT NULL,
  `listPhuong` json NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quan`
--

LOCK TABLES `quan` WRITE;
/*!40000 ALTER TABLE `quan` DISABLE KEYS */;
INSERT INTO `quan` VALUES (1,'Q001','Quận Hai Bà Trưng',318038400,318038400,0,480,'2024-01-01','2025-01-01','[\"P065\", \"P066\", \"P067\", \"P068\", \"P069\", \"P070\", \"P071\", \"P072\"]'),(2,'Q002','Quận Tây Hồ',324383400,324383400,0,480,'2024-01-01','2025-01-01','[\"P073\", \"P074\", \"P075\", \"P076\", \"P077\", \"P078\", \"P079\", \"P080\"]'),(3,'Q003','Quận Nam Từ Liêm',316058400,316058400,0,480,'2024-01-01','2025-01-01','[\"P081\", \"P082\", \"P083\", \"P084\", \"P085\", \"P086\", \"P087\", \"P088\"]'),(4,'Q004','Quận Cầu Giấy',323933400,323933400,0,480,'2024-01-01','2025-01-01','[\"P089\", \"P090\", \"P091\", \"P092\", \"P093\", \"P094\", \"P095\", \"P096\"]'),(5,'Q005','Huyện Sóc Sơn',325328400,325328400,0,480,'2024-01-01','2025-01-01','[\"P097\", \"P098\", \"P099\", \"P100\", \"P101\", \"P102\", \"P103\", \"P104\"]'),(8,'Q006','Huyện Thường Tín',317228400,317228400,0,480,'2024-01-01','2025-01-01','[\"P105\", \"P106\", \"P107\", \"P108\", \"P109\", \"P110\", \"P111\", \"P112\"]'),(9,'Q007','Huyện Mê Linh',0,0,0,0,'2024-01-01','2025-01-01','[\"P113\", \"P114\", \"P115\", \"P116\", \"P117\", \"P118\", \"P119\", \"P120\"]'),(10,'Q008','Huyện Hoài Đức',0,0,0,0,'2024-01-01','2025-01-01','[\"P121\", \"P122\", \"P123\", \"P124\", \"P125\", \"P126\", \"P127\", \"P128\"]'),(11,'Q009','Quận Hà Đông',328613400,328613400,0,480,'2024-01-01','2025-01-01','[\"P001\", \"P002\", \"P003\", \"P004\", \"P005\", \"P006\", \"P007\", \"P008\"]'),(12,'Q010','Quận Hoàn Kiếm',327308400,327308400,0,480,'2024-01-01','2025-01-01','[\"P009\", \"P010\", \"P011\", \"P012\", \"P013\", \"P014\", \"P015\", \"P016\"]'),(13,'Q011','Huyện Gia Lâm',317543400,317543400,0,480,'2024-01-01','2025-01-01','[\"P017\", \"P018\", \"P019\", \"P020\", \"P021\", \"P022\", \"P023\", \"P024\"]'),(14,'Q012','Thị Xã Sơn Tây',322043400,322043400,0,480,'2024-01-01','2025-01-01','[\"P025\", \"P026\", \"P027\", \"P028\", \"P029\", \"P030\", \"P031\", \"P032\"]'),(15,'Q013','Huyện Phúc Thọ',325058400,325058400,0,480,'2024-01-01','2025-01-01','[\"P033\", \"P034\", \"P035\", \"P036\", \"P037\", \"P038\", \"P039\", \"P040\"]'),(16,'Q014','Quận Ba Đình',340898400,340898400,0,480,'2024-01-01','2025-01-01','[\"P041\", \"P042\", \"P043\", \"P044\", \"P045\", \"P046\", \"P047\", \"P048\"]'),(17,'Q015','Quận Đống Đa',648941400,648941400,0,960,'2024-01-01','2025-01-01','[\"P049\", \"P050\", \"P051\", \"P052\", \"P053\", \"P054\", \"P055\", \"P056\"]'),(18,'Q016','Huyện Đan Phượng',650291400,650291400,0,960,'2024-01-01','2025-01-01','[\"P057\", \"P058\", \"P059\", \"P060\", \"P061\", \"P062\", \"P063\", \"P064\"]'),(19,'Q017','Quận Bắc Từ Liêm',322808400,322808400,0,480,'2024-01-01','2025-01-01','[\"P129\", \"P130\", \"P131\", \"P132\", \"P133\", \"P134\", \"P135\", \"P136\"]'),(20,'Q018','Quận Thanh Xuân',324113400,324113400,0,480,'2024-01-01','2025-01-01','[\"P137\", \"P138\", \"P139\", \"P140\", \"P141\", \"P142\", \"P143\", \"P144\"]'),(21,'Q019','Huyện Đông Anh​',322313400,322313400,0,480,'2024-01-01','2025-01-01','[\"P145\", \"P146\", \"P147\", \"P148\", \"P149\", \"P150\", \"P151\", \"P152\"]'),(22,'Q020','Huyện Thanh Trì',326633400,326633400,0,480,'2024-01-01','2025-01-01','[\"P153\", \"P154\", \"P155\", \"P156\", \"P157\", \"P158\", \"P159\", \"P160\"]');
/*!40000 ALTER TABLE `quan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-30 23:27:54
