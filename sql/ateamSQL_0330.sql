-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        8.0.21 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 테이블 mydb.sched 구조 내보내기
CREATE TABLE IF NOT EXISTS `sched` (
  `sc_id` int NOT NULL AUTO_INCREMENT,
  `sc_startdate` date NOT NULL,
  `sc_title` char(30) NOT NULL,
  `sc_enddate` date DEFAULT NULL,
  `sc_content` char(200) DEFAULT NULL,
  `sc_isdone` tinyint(1) DEFAULT NULL,
  `sc_privacy` char(10) DEFAULT NULL,
  `sc_priority` int DEFAULT NULL,
  `sc_color` char(10) DEFAULT NULL,
  PRIMARY KEY (`sc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- 테이블 데이터 mydb.sched:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `sched` DISABLE KEYS */;
INSERT INTO `sched` (`sc_id`, `sc_startdate`, `sc_title`, `sc_enddate`, `sc_content`, `sc_isdone`, `sc_privacy`, `sc_priority`, `sc_color`) VALUES
	(1, '2022-03-23', '일정 제목', '2022-03-24', '일정 내용', NULL, NULL, NULL, NULL),
	(2, '2022-03-24', '제목', '2022-03-28', '일정 내용2', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `sched` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
