## 학습 테스트 실습

### String 클래스 테스트 
#### 요구 사항1
- String 입력 값이 주어질때 split 메소드를 이용하여 "," 기준으로 값을 분리
- 결과 값은  "," 의 갯수 + 1 을 가진 String 배열 값을 가진다.
- String 입력 값 안에 "," 이 없는 경우 사이즈가 1이고 배열 값은 String 입력 만 갖는다.

#### 요구 사항2
- substring 을 이용하여 입력값에서 "(" 와 ")" 를 제외한 값을 확인한다.
- "(" or ")" 인 경우에는 하나만 제거하고 값을 반환한다.
- "(" 와 ")" 이 둘다 없는 경우에는 입력값 과 같은 값을 반환한다.

#### 요구 사항3
- String 값이 주어질때 charAt 메소드를 이용하여 특정 위치의 문자를 가져온다.
- 특정 위치의 값은 String 길이보다 작으며, 큰 값을 입력시 StringIndexOutOfBoundsException 이 발생


### Set Collection 테스트
#### 요구 사항1
- Set 의 size 메소드를 활용해 크기를 확인 

#### 요구 사항2
- contains 메소드로 Set 의 값을 다 확인하면 중복된 코드가 발생
- ParameterizedTest 를 이용하여 중복을 제거 해라

#### 요구 사항3
- contains 메소드를 사용하여 내부값이 아닌 경우에도 false 를 반환
- 내부 값인 경우에는 true 를 반환

---------

## STEP 2
### 문자열 덧셈 계산기
### 기능 요구 사항 
- 쉼표(,), 콜론(:), 커스텀 으로 구분자를 구별 한다.
- 입력 값을 구분자 기준으로 분리하여 숫자의 합을 반환 한다.
- 커스텀 구분자는 "//" 와 "\n" 사이에 있어야 한다.
- 숫자 이외의 값 또는 음수 전달시 ***RuntimeException*** 예외를 throw 한다.

### 프로그래밍 요구 사항
- depth 는 1 이다.
- 메소드는 10 라인 안으로 작성 한다.
- method 는 한가지 역할만 한다.
- no else 이다.

### class 역할
- Separator
  - static class 이며 differentiate 함수를 통하여 입력 값을 구분자로 구별하여 String 배열 값을 반환한다.
  - 입력값이 null 이거나 size 가 0 이면 RuntimeException 예외를 발생시킨다.

- StringAddCalculator
    - static class 이며 splitAndSum 함수를 가지고 있으며 String 값을 인수로 받아서 int 값을 반환한다.

- WholeNumber
  - VO 이며 , 정수 값만 가질수 있다.
  - 정수 가 아닌 다른 값이 입력으로 들어오면 RuntimeException 예외를 throw 한다.
  - add 메소드를 통해서 WholeNumber 끼리 더하기를 할수 있다.
  - of 메소드를 통해서 int 값으로 변환할수 있다.

- WholeNumbers 
  - sum 메소드를 통해서 WholeNumber 들을 계산하여 int 값을 반환한다.

-----

## STEP 3
### 로또(자동)
### 기본 정보 
- 사용자는 로또 구입 금액을 입력 해야 하며, 금액 만큼 로또가 자동 구매된다.
- 로또 1장 가격은 1000 원이다.
- 로또 자동 생성은 Collections.shuffle() 메소드를 활용

### 프로그래밍 요구 사항
- TDD 로 구현
- depth 는 1 이다.
- 함수는 15 라인 안으로 구현 하고 한가지 역할만 한다.
- else 사용 금지

### class 역할
- Presenter 
  - 입력과 출력을 담당한다.
  - 입력은 로또 구매 금액 , 지난 주 당첨 번호 
  - 출력은 입력 멘트 , 금액에 따른 로또 장수, 구매한 로또 번호 , 지난 주 당첨 번호 멘트, 당첨 통계 정보

- LottoNumber
  - LottoNumber 는 VO 객체이며, 1 ~ 45 까지 정수 값만 가진다.
  - 음수 등 잘못된 값이 입력되면 RuntimeException 예외가 발생한다.
  - LottoNumber 는 비교 할수 있다.

- Lotto
  - 로또는 LottoNumber 숫자 6개 를 가지며, 6개가 아니면 RuntimeException 을 발생한다.
  - 로또는 입력한 LottoNumber 숫자들이 정렬 한 후 저장한다.
  - 로또는 check 메소드는 당첨 번호 Lotto 를 입력으로 받고 입력된 값을 통해서 일치한 갯수를 반환한다.

- Hit
  - Enum 으로써 일치한 갯수 값과 그에 맞는 금액 정보를 가진다.
  - Hit 의 일치한 갯수 값은 0 과 6 사이 값을 가진다.
  - 비교 메소드를 통해서 값을 비교할수 있다.
  - 동일한 당첨금에 갯수를 입력 시 당첨금 * 갯수 에 대한 금액을 반환한다. 
  
- LottoResult
  - HitList 입력을 받고 earningRate 메소드를 통해서 EarningsRate 를 반환한다.
  - Total 은 Hit 의 THREE 부터 정보를 저장한다.

- LottoPaper
  - 일급 객체로써 LottoList 를 입력 받는다.
  - checkAll 메소드를 통해서 총 당청금을 반환한다.

- EarningsRate
  - rate 정보를 멤버 변수로 가진다.

- LottoVendingMachine
  - 사용자가 로또 구매할 금액을 입력하면 LottoPaper 를 반환한다.
  - 사용자가 구매한 금액만큼 Lotto 가 발급된다.

- LottoGenerator
  - 로또를 자동과 수동 모드를 제공한다.

- LottoNumbers
  - 로또 숫자 1부터 45까지 정보를 가지고 있다.
  - 섞는 방법을 입력하여 로또를 추출한다.
  
- LottoMoney
  - 사용자가 로또 구매할 금액을 가지고 있다.
  - 총 당청금액을 입력하면 총 수익률을 반환한다.

------------

## STEP 4
### 로또(2등)
### 기본 정보 
- 2등을 위해서 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.

### class 역할
- LottoPaper
  - check all 함수에서 보너스 번호를 추가로 입력받아서 5개 일치인 경우 보너스 번호를 확인한다.
- Hit
  - 보너스 정보를 추가한다.
  - 2등 (5개 맞고 보너스가 맞는 경우) 를 위한 당첨금을 추가한다.
- Presenter
  - 보너스 정보를 입력 받도록 한다.

- LottoAnswer
  - 당첨 번호 로또 6자리 를 가지고 보너스 숫자도 가지고 있다.
  - 사용자의 로또 paper 를 입력받으면 결과값을 반환한다.
