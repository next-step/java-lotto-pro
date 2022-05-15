# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


---

# 로또 (자동)

## 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

## 프로그래밍 요구사항
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

### 🔖 TDD를 위한 기능 목록 List
- [x] 구입 금액이 NULL & EMPTY 값이면 예외를 던진다.
- [x] 구입 금액이 숫자가 아닌 값이면 예외를 던진다.
- [x] 구입 금액이 음수 값이면 예외를 던진다.
- [x] 구입 금액이 로또 금액보다 작으면 예외를 던진다.
- [x] 구입 금액이 정상 값이면 로또 가격으로 나눈 값을 반환한다. 
- [x] 자동으로 중복되지 않도록 로또 숫자 6개(한 세트)를 뽑는다.
- [x] 한 세트의 숫자를 정렬한다.
- [x] 한 세트를 N번 뽑는다.
- [x] 로또 두 세트 비교한다.
  - [x] 0~2개 일치시 당첨금액은 0원이다.
  - [x] 3개 일치시 당첨금액은 5000원이다.
  - [x] 4개 일치시 당첨금액은 50000원이다.
  - [x] 5개 일치시 당첨금액은 1500000원이다.
  - [x] 6개 일치시 당첨금액은 2000000000원이다.
- [x] 지난 주 당첨 번호가 올바르지 않는 값이면 예외를 던진다.
- [x] 지난 주 당첨 번호와 구매한 한 개 세트를 비교해 등수를 반환한다.
- [x] 지난 주 당첨 번호와 구매한 N 개 세트를 비교해 등수를 반환한다.
- [x] 구매한 금액/당첨 번호를 입력받고 당첨내역을 출력한다.
- [x] 수익률을 출력한다. 

### 👍 처리하면 더 좋은 TODO List
- [x] 화면 출력시 금액에 대한 부분은 자릿수 처리한다.
- [x] 예외 던지면 재입력을 받도록 구현한다.
- [x] 인터페이스에 있는 List 처리 고민해보기 -> LottoNumber 클래스로 처리

---

# 로또 (2등)

## 기능 요구사항
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.

## 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- java enum을 적용해 프로그래밍을 구현한다.
- 규칙 8: 일급 콜렉션을 쓴다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- else 예약어를 쓰지 않는다.

### 🔖 TDD를 위한 기능 목록 List
- 로또 번호 생성기(LottoNumberGenerator) 리팩토링
  - [x] 로또 번호(LottoNumber) 객체 반환이 아닌 List<Number>로 반환 수정
- 지난주 당첨 번호(WinningLottoNumber) 클래스 추가
  - [x] 당첨 번호 입력 받기
  - [x] 보너스 번호를 입력 받기
  - [x] 보너스 번호가 당첨 번호와 중복되어 있는지 확인
- 로또 등수(LottoRank) ENUM 클래스 수정
  - [x] 보너스 번호를 가진 등수로 인한 상수값 변경
  - [x] 로또 등수 산정 방식 findByHits 변경
- 로또 번호(LottoNumber) 수정
  - [x] 로또 등수를 반환하는 resultLottoRank 메소드 삭제 
  - [x] 로또 번호를 비교하는 countMatchLottoNumber 메소드 추가
- 로또 번호 일급 컬렉션(LottoNumbers) 수정
  - [x] 로또 등수들을 반환하는 resultLottoRanks 메소드 수정

---

# 로또 (수동)

## 기능 요구사항
- 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

## 프로그래밍 요구사항
- 규칙 3: 모든 원시값과 문자열을 포장한다.
- 규칙 5: 줄여쓰지 않는다(축약 금지).
- 예외 처리를 통해 에러가 발생하지 않도록 한다.
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- java enum을 적용해 프로그래밍을 구현한다.
- 규칙 8: 일급 콜렉션을 쓴다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- else 예약어를 쓰지 않는다.

### 힌트
- 규칙 3: 모든 원시값과 문자열을 포장한다.
  - 로또 숫자 하나는 int 타입이다. 이 숫자 하나를 추상화한 LottoNo 객체를 추가해 구현한다.
- 예외 처리를 통해 에러가 발생하지 않도록 한다.
  - 사용자가 잘못된 값을 입력했을 때 java exception으로 에러 처리를 한다.
  - java8에 추가된 Optional을 적용해 NullPointerException이 발생하지 않도록 한다.

### 🔖 TDD를 위한 기능 목록 List
- 사용자로부터 수동으로 구매할 로또 수, 번호 입력 받기
  - [x] 시도 횟수인 Count 객체 추가
  - [ ] 입력받은 개수 구매 가능여부 isAvailableBuyingCount 메소드 추가
  - [ ] 로또 수 입력받는 InputView 분리
  - [ ] 로또 갯수만큼 로또 번호 입력
  - [ ] 수동으로 생성한 로또 번호들 넘겨 받는 inputManualLottoNumber 메소드 추가
