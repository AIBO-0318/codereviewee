목차

1. 프로젝트 선정 이유
2. 개발 환경
3. 요구사항 명세서
4. 패키지 구조
5. 유스케이스 다이어그램
6. 클래스 다이어그램
7. 시연 영상
8. 코드 리뷰
9. 후기

---

프로젝트 선정 이유

본 프로젝트는 자바의 객체지향 프로그래밍 학습을 위해 Service, DAO, VO 등 계층 구조를 갖춘 콘솔 기반 음반 대여·판매 시스템을 직접 구현해보는 것을 목표로 하였습니다. 단순한 상거래 시스템을 넘어서, 특정 아티스트나 레이블을 구독하고 팬들이 포토카드를 교환하며 소통할 수 있는 팬덤을 위한 커뮤니티 중심 플랫폼을 지향하였으며, 이를 통해 실제 사용자 중심 서비스가 어떻게 동작하는지를 구조적으로 이해하고 설계하는 경험을 쌓고자 이 주제를 선정하였습니다.

---

프로젝트 개발 환경

Java 17
Eclipse
Windows 10

---

프로젝트 실행환경

JDK 17 이상
콘솔 환경 (CLI 기반)
실행 파일: 

---

요구사항 명세서


기능
![요구사항 명세](images/화면%20캡처%202025-06-29%20142929.png)

---


음반
![요구사항 명세](images/화면%20캡처%202025-06-29%20143020.png)

---


사용자
![요구사항 명세](images/화면%20캡처%202025-06-29%20143120.png)

---


주문
![요구사항 명세](images/화면%20캡처%202025-06-29%20143144.png)

---


장바구니
![요구사항 명세](images/화면%20캡처%202025-06-29%20143203.png)

---


데이터
![요구사항 명세](images/화면%20캡처%202025-06-29%20143237.png)

---


시스템 환경
![요구사항 명세](images/화면%20캡처%202025-06-29%20143303.png)


---

패키지 구조




┣ 📁 app
┃ ┣ 📄 MyAppReader.java
┃ ┗ 📄 RecordMartConsoleApp.java
┣ 📁 cart
┃ ┣ 📄 CartDAO.java
┃ ┣ 📄 CartItemVO.java
┃ ┣ 📄 CartService.java
┃ ┣ 📄 CartServiceImpl.java
┃ ┗ 📄 HashMapCartDAO.java
┣ 📁 member
┃ ┣ 📄 FileMemberDB.java
┃ ┣ 📄 HashMapMemberDAO.java
┃ ┣ 📄 HJMemberService.java
┃ ┣ 📄 MemberDAO.java
┃ ┣ 📄 MemberService.java
┃ ┣ 📄 MemberServiceImpl.java
┃ ┣ 📄 MemberVO.java
┃ ┗ 📄 ObjFileHashMapMemberDAO.java
┣ 📁 member.file
┃ ┗ 📄 TextFileHashMapMemberDAO.java
┣ 📁 order
┃ ┣ 📄 ObjFileHashMapOrderDAO.java
┃ ┣ 📄 OrderDAO.java
┃ ┣ 📄 OrderItemVO.java
┃ ┣ 📄 OrderService.java
┃ ┣ 📄 OrderServiceImpl.java
┃ ┗ 📄 OrderVO.java
┣ 📁 record
┃ ┣ 📄 HashMapRecordDAO.java
┃ ┣ 📄 ListRecordDAO.java
┃ ┣ 📄 RecordDAO.java
┃ ┣ 📄 RecordService.java
┃ ┣ 📄 RecordServiceImpl.java
┃ ┗ 📄 RecordVO.java
┣ 📁 record.file
┃ ┣ 📄 FileRecordDB.java
┃ ┣ 📄 ObjFileHashMapRecordDAO.java
┃ ┗ 📄 TextFileHashMapRecordDAO.java
┣ 📁 rent
┃ ┣ 📄 HashMapRentDAO.java
┃ ┣ 📄 RentDAO.java
┃ ┣ 📄 RentService.java
┃ ┣ 📄 RentServiceImpl.java
┃ ┗ 📄 RentVO.java
┣ 📁 rent.file
┃ ┗ 📄 ObjFileHashMapRentDAO.java




---

유스케이스 다이어그램

![유스케이스](images/화면%20캡처%202025-06-29%20145042.png)
