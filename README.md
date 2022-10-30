# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 - 학습 테스트 실습

---

### String 클래스에 대한 학습 테스트

#### 요구사항 1
- "1,2"을 `,`로 `split` 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현
- "1"을 `,`로 `split` 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현

#### 요구사항 2
- "(1,2)" 값이 주어졌을 때 `String`의 `substring()` 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현

#### 요구사항 3
- "abc" 값이 주어졌을 때 `String`의 `charAt()` 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현
- `String`의 `charAt()` 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현
- `JUnit`의 `@DisplayName`을 활용해 테스트 메소드의 의도를 드러낸다.

### Set Collection에 대한 학습 테스트

#### 요구사항 1
- `Set`의 `size()` 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.

#### 요구사항 2
- `Set`의 `contains()` 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인
- `JUnit`의 `ParameterizedTest`를 활용해 중복 코드를 제거

#### 요구사항 3
- 요구사항 2는 `contains` 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현
- 예를 들어 1,2,3 값은 `contains` 메소드 실행결과 true, 4,5 값을 넣으면 false가 반환되는 테스트를 하나의 Test Case로 구현

## 2단계 - 문자열 덧셈 계산기

---

### 기능 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
> “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
- 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치~하는 문자를 커스텀 구분자로 사용한다.
> “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 프로그래밍 요구사항
- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
  - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  - method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라.

### 구현 목록
- [X] null이 입력될 경우 0을 반환
- [X] 빈 문자가 입력될 경우 0을 반환
- [X] 숫자 하나가 입력될 경우 해당 숫자를 반환
- [X] 구분자(,)를 가지는 문자열의 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
- [X] 구분자(,|:)를 가지는 문자열의 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
- [X] //와\n사이의 구분자는 커스텀 구분자로 해당 구분자를 기준으로 분리한 각 숫자의 합을 반환
- [X] 음수를 전달하는 경우 RuntimeException 예외를 throw
- [X] 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw

## 3단계 - 로또(자동)

---

### 기능 요구사항
- 로또 구입 금액을 입력한다.
- 입력된 구입 금액에 해당하는 로또를 발급한다.
- 로또 1장의 가격은 1000원이다.

### 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- else 예약어를 쓰지 않는다.

### 구현 목록

#### InputView
- [x] 구입 금액을 입력한다.
- [x] 지난 주 당첨 번호를 입력한다.
#### LottoPurchaseAmount
- [x] 구입 금액
  - [x] 구입 금액은 숫자이다.
  - [x] 구입 금액은 1000단위여야 한다.
  - [x] 구입 금액은 양수만 입력 가능하다.
#### LottoPurchaseQuantity
- [x] 구매 갯수를 출력한다.
#### AutoNumberGenerator
- [x] 로또 번호를 6개 생성한다.
#### LottoNumber
- [x] 로또 번호는 1 ~ 45 사이의 숫자이다.
- [x] 로또 번호는 정렬되어야 한다.
#### LottoNumbers
  - [x] 구매 내역 출력 포맷 `[8, 21, 23, 41, 42, 43]`
#### LottoLottery
- [x] 구매 갯수만큼 로또 복권을 생성한다.
- [x] 구매 내역(로또 번호)을 생성한다.
#### ManualNumberGenerator
- [x] 지난 주 당첨 번호를 생성한다. 
  - [x] 로또 번호는 중복되지 않는다.
#### WinningNumbers
- [x] 지난 주 당첨 번호
- [x] 당첨 여부를 확인한다.
#### WinningRank
- [x] 당첨 숫자 개수, 금액, 화면 노출 여부를 정의
#### WinningRanks
- [x] 당첨 통계를 계산한다.
- [x] 수익률을 계산한다.
 - [x] 수익률 = 당첨금액 / 구입금액 (소수점 2자리 버림)
#### OutputView
- [x] 구매 내역(로또 번호)을 출력한다.
- [x] 당첨 통계를 출력한다.
- [x] 수익률을 출력한다.
