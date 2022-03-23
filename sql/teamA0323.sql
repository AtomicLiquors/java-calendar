CREATE TABLE member(
/* ======== 회원 데이터 ======== */

mb_id CHAR(8) PRIMARY KEY, 
/*아이디*/

mb_pwd CHAR(10) NOT NULL,
/*패스워드*/

mb_joindate DATE NOT NULL,
/*가입일자*/



/* ======== 회원 인적사항 ========  */

mb_realname CHAR(10) NOT NULL,
/*실제 이름*/

mb_birthdate DATE NOT NULL,
/*생년월일*/

mb_email CHAR(30) NOT NULL
/*이메일*/


/* ======== 기타 ========  */

/*mb_username CHAR(10) NOT NULL,*/
/*이용자명, 따로 지정하는 게 필요하면 추가*/

);

CREATE TABLE sched(
sc_id int(8) AUTO_INCREMENT PRIMARY KEY NOT NULL,
sc_startdate DATE NOT NULL,
sc_title CHAR(30) NOT NULL,

sc_enddate DATE,
sc_content CHAR(200),
sc_isdone BOOLEAN,
sc_privacy CHAR(10), 
sc_priority INT(1)
);

CREATE TABLE todo(
mb_id CHAR, 
FOREIGN KEY (mb_id) REFERENCES member(mb_id) ON UPDATE CASCADE,
td_1 CHAR(30),
td_2 CHAR(30),
td_3 CHAR(30),
td_4 CHAR(30),
td_5 CHAR(30)
);

CREATE TABLE reply(
mb_id CHAR, 
sc_id INT, 
FOREIGN KEY (mb_id) REFERENCES member (mb_id) ON UPDATE CASCADE,
FOREIGN KEY (sc_id) REFERENCES sched (sc_id) ON UPDATE CASCADE,
rp_id INT(8) AUTO_INCREMENT PRIMARY KEY NOT NULL,
rp_content CHAR(100) NOT NULL,
rp_date DATE NOT NULL
)