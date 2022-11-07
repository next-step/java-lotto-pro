# 소프트웨어 설계, 구성

## MVC 패턴

### MVC 패턴이란?
- 소프트웨어 디자인 패턴

### 사용하는 이유
- 프로그램이 커지면 복잡도가 올라가고, 복잡도가 높으면 개발 및 유지보수에 어려움이 있음
- 기능별로 구분하여 아래와 같은 장점 취할 수 있음
  - 수정, 보수가 필요한 지점 쉽게 찾을 수 있음
  - 각 부분의 복잡도 낮아짐
  - 각 계층이 독립적임 (-> 동시에 여럿이 개발 가능)

### M, V, C
- Model : 어플리케이션의 데이터와 로직을 담당
- View : 사용자에게 보여지는 부분을 담당 (User Interface)
- Controller : 사용자 요청을 받아 model과 view 사이에서의 중개자 역할 담당
  <br>(프로그램이 커져 복잡해지면 controller와 service로 나누어 구성)

<br>

## 현대의 디자인 패턴 (Layer 구성)
- Presentation Layer
- Control Layer
- Business Layer (Service, Domain)
- Persistence Layer
- Domain Model Layer

<br>

## 도메인 모델 설계
- 다양한 방법으로 설계 가능
  - 예1) 객체를 이용한 도메인 모델링
  - 예2) 상태다이어그램을 이용한 모델링
- 결국 도메인을 이해하는 것이 목적
- 편한 방법으로 충분히 도메인이 파악될 때까지 다양한 방법으로 모델링해본다