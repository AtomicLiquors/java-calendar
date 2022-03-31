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

-- 테이블 mydb.reply 구조 내보내기
CREATE TABLE IF NOT EXISTS `reply` (
  `mb_id` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sc_id` int DEFAULT NULL,
  `rp_id` int NOT NULL AUTO_INCREMENT,
  `rp_content` char(100) NOT NULL,
  `rp_date` date NOT NULL,
  PRIMARY KEY (`rp_id`),
  KEY `mb_id` (`mb_id`),
  KEY `sc_id` (`sc_id`),
  CONSTRAINT `reply_ibfk_1` FOREIGN KEY (`mb_id`) REFERENCES `member` (`mb_id`),
  CONSTRAINT `reply_ibfk_2` FOREIGN KEY (`sc_id`) REFERENCES `sched` (`sc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- 테이블 데이터 mydb.reply:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` (`mb_id`, `sc_id`, `rp_id`, `rp_content`, `rp_date`) VALUES
	('vadmin', 17, 1, '테스트용 코멘트입니다.', '2022-03-30'),
	('member1', 1, 4, '프로젝트가 잘 마무리되었습니다.', '2022-03-31'),
	('admin', 17, 12, '테스트용 코멘트 2입니다.', '2022-03-31');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
