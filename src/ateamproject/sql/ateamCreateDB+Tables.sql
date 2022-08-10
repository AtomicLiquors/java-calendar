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


-- mydb 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;

-- 테이블 mydb.dday 구조 내보내기
CREATE TABLE IF NOT EXISTS `dday` (
  `sc_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 mydb.dday:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `dday` DISABLE KEYS */;
INSERT INTO `dday` (`sc_id`) VALUES
	(17);
/*!40000 ALTER TABLE `dday` ENABLE KEYS */;

-- 테이블 mydb.member 구조 내보내기
CREATE TABLE IF NOT EXISTS `member` (
  `mb_id` char(8) NOT NULL,
  `mb_pwd` char(10) NOT NULL,
  `mb_joindate` date NOT NULL,
  `mb_realname` char(10) NOT NULL,
  `mb_birthdate` date DEFAULT NULL,
  `mb_email` char(30) DEFAULT NULL,
  PRIMARY KEY (`mb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 mydb.member:~9 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` (`mb_id`, `mb_pwd`, `mb_joindate`, `mb_realname`, `mb_birthdate`, `mb_email`) VALUES
	('admin', '1234', '2022-03-29', '관리자', '2022-01-01', 'admin@blank.com'),
	('kangfil', '1234', '2022-03-30', '장강필', '2016-01-01', 'kangfil@naver.com'),
	('kwangfil', '1111', '2022-03-30', '김광필', '2022-01-01', 'blank@naver.com'),
	('mbrkim', '1234', '2022-03-30', '김회원', '2014-01-01', 'mbrkim@naver.com'),
	('member', '1234', '2022-03-29', '김홍도', '2022-01-01', 'hongdo@naver.com'),
	('member1', '1111', '2022-03-30', '회원', '2010-05-06', 'member@naver.com'),
	('newbie', '1111', '2022-03-31', '김신입', '1999-01-01', 'newbie@naver.com'),
	('philip', '1111', '2022-03-30', '김필립', '2022-01-01', 'philipkim@naver.com'),
	('vadmin', '1234', '2022-03-24', '부관리자 이름', '2022-03-24', 'viceadmin@blank.com');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;

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

-- 테이블 데이터 mydb.reply:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` (`mb_id`, `sc_id`, `rp_id`, `rp_content`, `rp_date`) VALUES
	('vadmin', 17, 1, '테스트용 코멘트입니다.', '2022-03-30'),
	('member1', 1, 4, '프로젝트가 잘 마무리되었습니다.', '2022-03-31'),
	('admin', 17, 12, '테스트용 코멘트 2입니다.', '2022-03-31');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;

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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- 테이블 데이터 mydb.sched:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `sched` DISABLE KEYS */;
INSERT INTO `sched` (`sc_id`, `sc_startdate`, `sc_title`, `sc_enddate`, `sc_content`, `sc_isdone`, `sc_privacy`, `sc_priority`, `sc_color`) VALUES
	(1, '2022-03-25', '3월 프로젝트 완성', '2022-03-30', '이번 달의 프로젝트를 수행하는 기간입니다.', NULL, NULL, NULL, NULL),
	(17, '2022-04-01', '만우절', '2022-04-01', '4월 1일은 만우절입니다.', 0, NULL, 0, NULL);
/*!40000 ALTER TABLE `sched` ENABLE KEYS */;

-- 테이블 mydb.todo 구조 내보내기
CREATE TABLE IF NOT EXISTS `todo` (
  `td_id` int NOT NULL AUTO_INCREMENT,
  `mb_id` char(1) DEFAULT NULL,
  `td` char(30) DEFAULT NULL,
  PRIMARY KEY (`td_id`),
  KEY `mb_id` (`mb_id`),
  CONSTRAINT `todo_ibfk_1` FOREIGN KEY (`mb_id`) REFERENCES `member` (`mb_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 mydb.todo:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `todo` DISABLE KEYS */;
/*!40000 ALTER TABLE `todo` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
