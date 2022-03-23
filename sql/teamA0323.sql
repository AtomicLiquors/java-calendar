CREATE TABLE member(
mb_id CHAR(8) PRIMARY KEY, 
mb_pwd CHAR(10) NOT NULL,
mb_username CHAR(10) NOT NULL,
mb_date DATE NOT null
)

CREATE TABLE sched(
sc_id int(8) AUTO_INCREMENT PRIMARY KEY NOT NULL,
sc_startdate DATE NOT NULL,
sc_title CHAR(30) NOT NULL,

sc_enddate DATE,
sc_content CHAR(200),
sc_isdone BOOLEAN,
sc_privacy CHAR(10), 
sc_priority INT(1)
)

CREATE TABLE todo(
mb_id CHAR, 
FOREIGN KEY (mb_id) REFERENCES member(mb_id) ON UPDATE CASCADE,
td_1 CHAR(30),
td_2 CHAR(30),
td_3 CHAR(30),
td_4 CHAR(30),
td_5 CHAR(30)
)

CREATE TABLE reply(
mb_id CHAR, 
sc_id int, 
FOREIGN KEY (mb_id) REFERENCES member (mb_id) ON UPDATE CASCADE,
FOREIGN KEY (sc_id) REFERENCES sched (sc_id) ON UPDATE CASCADE,
rp_id INT(8) AUTO_INCREMENT PRIMARY KEY NOT NULL,
rp_content CHAR(100) NOT NULL,
rp_date DATE NOT NULL
)