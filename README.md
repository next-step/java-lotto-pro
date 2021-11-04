# 3단계 - 로또(자동)

## 3단계 실습 시작

### 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

```text
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

### 힌트

- 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
- Collections.sort() 메소드를 활용해 정렬 가능하다.
- ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

### 프로그래밍 요구사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 기능 목록

> 로직  
> 1.구입 금액을 입력 받는다   
> 2.로또는 개당 1000원이므로 구입 할 수 있는 만큼 로또 번호를 자동생성한다.  
> 3.지난 주 당첨 번호를 입력 받는다   
> 4.자동생성 로또번호와 비교하여 당첨을 계산한다  
> 5.당첨 통계를 출력한다.

- InputView
    - [ ] 사용자에게 로또 구매 금액 입력받기
    - [ ] 지난 주 당첨 번호 입력 받기
- ResultView
    - [ ] 로또 번호 목록 출력
    - [ ] 당첨 통계 출력
- 로또번호 생성
    - [X] 1-45의 숫자를 가지는 로또번호 객체생성
    - [X] 로또번호를 가지는 로또티켓 객체생성(6개의 로또번호를 가짐, 중복X)
    - [X] 구입금액에 가능한 로또 최대 구매수 구하기
    - [X] 최대 구매수 만큼 로또 목록 생성하기
    - [X] 랜덤 로또 숫자 생성
    - [X] 구매후 불변객체로 수정불가 리턴하기
- 서비스
    - [X] 컨트롤러 - 도메인 연결 서비스 만들기
    - [X] 컨트롤러에서 사용할 Dto 만들기
- 결과
    - [X] 지난 주 로또 번호와 비교하여 일치 카운팅하기
    - [X] 당첨결과 당첨금액구하기
    - [X] 총 당첨금액과 구입금액에 대한 총 수익률 구하기
- 리팩토링
    - [X] 도메인 한방향으로 흐를수 있도록 개선

---
---

### 지켜야 할 컨벤션

> 커밋전 항상 아래 내용을 상기 시키며 커밋하도록 노력!

#### 코드 컨벤션

> 1. 프로그램 요구사항 미반영 검토하기 -> 모든 사항을 지킬 수 있도록 꼼꼼하게 프로그래밍하자!
> 2. RuntimeException 보다는 Exception 을 구체화 시켜 예외상황을 명확하게 정의하자.
> 3. 이름을 통해 의도를 드러내라. (불용어(Info, Data, a, an, the)를 추가하는 방식은 적절하지 못하다.)
> 4. 축약하지 마라. (의미를 들어낼 수 있다면 이름은 길어져도 괜찮다)
> 5. 개발 도구의 code format 기능을 활용
> 6. space(공백)도 convention 이다.
> 7. 불필요하게 공백 라인을 만들지 않는다.
> 8. 구현 순서도 convention 이다.
> 9. 반복하지 마라.
> 10. 들여쓰기에 space 와 tab 을 혼용하지 않는다.
> 11. 의미없는 주석을 달지 않는다. (주석보다는 의미있는 이름을 작성하도록 노력하자!)
> 12. 값을 하드코딩 하지 마라.(java 상수 개념)
      > -> 상수이름은 대문자로 정의한다.
> 13. git commit 메시지를 의미있게 작성
> 14. 기능 목록 업데이트 (한번에 완벽하게 작성 보다는, 계속 된 업데이트를 통해 살아있는 문서를 만들도록 노력한다.)
> 15. 기능 목록 구현을 재검토한다. (너무 상새하게 작성하지 않는다. 기능 정리 정도까지. 예외상황도 기능목록에 정리한다.)
> 16. README.md를 상세히 작성. (README 를 통해 어떤 프로젝트이며, 어떤 기능을 담고 있는지 기술한다.)

#### 테스트 코드

> 1. 가독성을 높이자
> 2. 테스트 당 assert 하나
> 3. 테스트 당 개념 하나
> 4. 빠르게 / 독립적으로 / 반복가능하게 / 자가검증하는 / 적시에
> 5. 테스트 비교 값은 Boolean 또는 명확성을 뛸수 있도록 노력하기
> 6. given-when-then