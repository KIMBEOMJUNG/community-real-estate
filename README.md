# callbuslab-assignment

콜버스랩 백엔드 개발자 사전 과제 입니다.(과제. 커뮤니티 REST API 서버 만들기)


#### Back-end : Spring Boot 2.7
#### Front-end : Jsp, Jqurey
#### DB : Mysql 5.5

------------
* ### 실행방법
  로컬에서 실행시 http://localhost:8080/login 로 접속하여 로그인 및 외부사용자로 접속할 수 있습니다.  
  하단의 회원목록의 닉네임을 입력 후 로그인하실 수 있습니다.(외부사용자 로그인 시 외부방문자 버튼을 클릭해주세요.)
  
------------

* ### 구현방식
  MVC 방식을 사용하여 백엔드를 구현하였으며, 프론트의 axios를 사용하여 백엔드와 비동기 통신 또한 구현하였습니다.  
  jdbc를 사용하여 DB와 연결하였고, mybatis를 사용하여 XML 쿼리문을 작성하였습니다.

------------

* ### SQL 파일
  https://drive.google.com/file/d/1NkrAlAibUQJB0u4sCLFSwoT3W79omVvN/view?usp=sharing
------------

* ### 회원목록

  닉네임 | 계정 타입
  ---|---
  공인중개인1 | 공인중개인(REALTOR)
  공인중개인2 | 공인중개인(REALTOR)
  임대인1 | 임대인(Lessor)
  임대인2 | 임대인(Lessor)
  임차인1 | 임차인(Lessee)
  임차인2 | 임차인(Lessee)
  
  
