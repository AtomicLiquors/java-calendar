# Java 사무용 캘린더
> 첫 프로젝트,   
> Java AWT/Swing 기반의 사무용 캘린더  
> DB Connection Pool을 이용한 DB연동 구현  

### 제작 기간 & 참여 인원
'22.03.17 - '22.03.31 (2주, 개발인원 3명)  

#### 담당 역할 : 
 
  - **최효빈 [팀장]**   
    화면설계, DB설계, 달력 세팅 기능 및 D-Day 구현, 회원등록/로그인/일정 등록 등 DB 연동 기능
  - **김한솔 [프론트엔드]**   
     WindowBuilder 이용 화면 구현
  - **김준승 [보조]**   
    일부 화면 및 부가기능 구현

<!--sql문에서 sched 테이블과 reply 테이블 순서 바꿀것. -->

&nbsp;  
### 사용한 기술 (기술 스택)
- Java, MySQL
<!--


6. ERD(필요할 경우)
7. 핵심 기능 : 코드로 보여주거나, 코드 링크
### **트러블슈팅 경험(중요!)** / 자랑하고 싶은 코드




앞의 항목에서 소개할 수 없는 뒷이야기 등.
-->

&nbsp;  
7. 핵심 기능 : 코드로 보여주거나, 코드 링크
- 달력 표시 기능
- MainWindow.java

&nbsp;  
### Troubleshooting
- 달력 예제 디버깅(경곗값 오류)  
  CalendarGrid.java에 구현된 달력 패널은 구글링을 통해 캘린더 예제를 변형한 것이다.  
  예제에 연도가 넘어갈 때 월이 0 이하로 감소하였다.  
  직접 코드를 분석하고, 알고리즘을 수정하여 연도가 변해도 날짜가 정상적으로 출력되게끔 하였다.  
  
- Git 업로드시 .java파일 한글 인코딩 오류 발생  
  Github Desktop을 통해 조원과 소스 파일을 공유하는 중,  
  한글이 손상되는 문제가 발생하였다.  
  조원들과 의논한 결과 Workspace 전체를 UTF-8로 바꿔서 해결하였다.  

&nbsp;  

### Class Diagram 
<img src = "https://github.com/AtomicLiquors/java-calendar/blob/main/class_diagram.png" style= "width: 40vw;">

&nbsp;  
&nbsp;  
### ER Diagram
<img src = "https://github.com/AtomicLiquors/java-calendar/blob/main/ER_Diagram.png" style= "width: 40vw;">



&nbsp;  
### 회고 / 느낀 점
- Java 객체지향 기본 문법. static, private, public. 이해가 부족한 부분은 프로젝트가 끝나고 복습하였다.
- 예제 클론 코딩 DB연결 등을
- DB 연결은 무척이나 복잡
- 병행하던 공부가 있어 빠듯한 일정 속에서 기본 문법을 충분히 숙지하지 못하고 프로젝트로 진입하였다. 
 
- 새 창을 호출할 때마다, 로그인 정보를 일일이 생성자의 매개변수로 전달하여 불편함이 있었다. 
  그 후 JSP 과정에서 Session을 배우게 되었고, Session의 편리성을 실감하였다.
- WindowBuilder 도입으로 초기 화면 구현 시간을 감축하였다.
