# Java 사무용 캘린더 :date: 
> [개발 공부 시작 후 첫 프로젝트]   
> Java AWT/Swing 기반, 공유 일정을 등록하는 사무용 캘린더  
> DB Connection Pool을 이용한 DB연동 구현  

&nbsp;  
### :clock2: 제작 기간
'22.03.17 - '22.03.31 (2주)  

&nbsp;  
### :construction_worker: 개발 인원 : 
#### [총 3명]
  - **최효빈 [팀장]**   
    화면설계, DB설계, 달력 세팅 기능 및 D-Day 구현, 회원등록/로그인/일정 등록 등 DB 연동 기능
  - **김한솔 [프론트엔드]**   
     WindowBuilder 이용 화면 구현
  - **김준승 [보조]**   
    일부 화면 및 부가기능 구현

<!--sql문에서 sched 테이블과 reply 테이블 순서 바꿀것. -->

&nbsp;  
### :books: 사용한 기술 
- Java, MySQL
- Tool : HeidiSQL, Github Desktop


&nbsp;  
___

&nbsp;  
### :wrench: 주요 기능
- **계정 기능**    
 DB에 계정 정보를 등록하고 로그인, 계정 정보 찾기, 중복확인 등 수행
 
- **일정 등록 및 댓글 기능**     
 특정 날짜에 일정을 등록합니다. 
  - 일정은 DB에 등록되고, 달력에 표시됩니다.
  - 등록된 일정에 댓글을 작성할 수 있습니다.
 
- **D-Day**    
 등록된 일정 중 하나를 지정하여 좌측 사이드바에 D-Day로 표시합니다.

&nbsp;  
### :hammer: Troubleshooting
- **달력 예제 디버깅(경곗값 오류)**   
  
  CalendarGrid.java에 구현된 달력 패널은 구글링을 통해 캘린더 예제를 변형한 것이다.  
  예제에 연도가 넘어갈 때 월이 0 이하로 감소하였다.  
  직접 코드를 분석하고, 알고리즘을 수정하여 연도가 변해도 날짜가 정상적으로 출력되게끔 하였다.  
  
- **Github 업로드시 .java파일 한글 인코딩 오류 발생**  
 
  Github Desktop을 통해 조원과 소스 파일을 공유하는 중,  
  한글이 손상되는 문제가 발생하였다.  
  조원들과 의논한 결과 Workspace 전체를 UTF-8로 바꿔서 해결하였다.  


&nbsp;  
___

&nbsp;   
### :bar_chart: 구조
#### [Class Diagram]
<img src = "https://github.com/AtomicLiquors/java-calendar/blob/main/class_diagram.png" style= "width: 60vw;">


|**클래스**|**설명**|
|--|--|
| **LoginScreen**  | **로그인 화면이며, 프로그램의 진입점입니다.**|
|**AccoutCreate** | 신규 계정을 등록하는 화면입니다.|
| **AccountSeek**  | 계정정보를 조회하는 화면입니다.|
| **MainWindow**  | **핵심 기능을 종합한 화면입니다.** |
| **CalendarPanel** | 달력이 표시되는 틀입니다. |
| **CalendarGrid**  | 달력의 월, 일을 표시합니다. <br> 일정이 등록된 날짜는 파랗게 표시합니다.|
| **Ppop, PpopDetail**  |  일정을 표시하는 팝업화면입니다. <br> [더보기] 클릭시 PpopDetail이 호출되어 팝업화면이 확장됩니다.|

&nbsp;  
&nbsp;  
#### [ER Diagram]
<img src = "https://github.com/AtomicLiquors/java-calendar/blob/main/ER_Diagram.png" style= "width: 60vw;">


|**테이블**|**설명**|
|--|--|
| **member** | 등록된 계정 정보를 저장하는 테이블입니다.|
| **sched** | 일정 정보를 저장하는 테이블입니다. |
| **todo**  | To-do list 정보를 저장하기 위해 생성한 테이블입니다. |
| **reply** | 일정에 등록된 댓글을 저장하는 테이블입니다. |
| **dday**  |  어떤 일정이 D-Day로 등록되었는지를 저장하는 테이블입니다. |

&nbsp;  
___

&nbsp;   
### :memo: 후기
- Java 객체지향 기본 문법을 숙달하는 계기가 되었다.   
 Swing 프로젝트를 진행하며 클래스 활용법과 static, private, public 등 제어자의 기능을 보다 명확히 알게 되었다.   
 이해가 부족한 부분은 별도로 시간을 들여 복습하였다.  
 
- 다소 빠듯한 일정 속에서 프로젝트를 수행할 수 있는지 충분히 확신하지 못하였다.    
 DB 연결, 달력 패널의 경우 원리를 파악하기 위해 예제를 클론 코딩하는 과정을 거쳤고,   
 복잡해 보이던 소스 코드의 구조를 이해하고, 또 직접 수정하는 과정에서 코딩에 대한 자신감을 얻게 되었다. 
 
- 새 창을 호출할 때마다, 로그인 정보를 일일이 생성자의 매개변수로 전달하여 불편함이 있었다.   
  후속 과정인 JSP 과정에서 Session을 배우게 되었고, Session의 편리성을 실감하였다.
  
- WindowBuilder 도입으로 초기 화면 구현 시간을 대폭 절감할 수 있었다.  
