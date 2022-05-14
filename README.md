# 3단계 - 로또(자동)

## 기능 요구사항 및 사전 힌트

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
Collections.sort() 메소드를 활용해 정렬 가능하다.
ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

## 프로그래밍 요구사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
 UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
 UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다.
 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
 else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 구현 요소 목록
### Lottery - 딩첨번호 일치 비교 
### Lotto - 당첨번호 지정
### LottoNumber - 로또 번호
### Lottos - Lotto 를 여러 개 구매할 경우 대응
### Vendor - 구매, 총 구매량에 대한 통계, 수익률 처리 


## 구현 요소별 TDD 로 기능을 완성해 본다. 

LottoNumber
- [ ] 1~45 사이의 범위의 숫자범위를 가진다.

Lotto
- [ ] LottoNumber를 6개 가지고 있다. 



