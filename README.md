# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## Step1

### String 클래스에 대한 학습 테스트

#### 요구사항1

- "1,2"를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
- "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

#### 요구사항2

- "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.

#### 요구사항3

- "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
- String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
- JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

### Set Collection에 대한 학습 테스트

#### 요구사항1

- Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.

#### 요구사항2

- Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현한다.
- JUnit의 ParameterizedTest를 활용해 중복 코드를 제거한다.

#### 요구사항3

- 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
- 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.

---

## Step2

### 문자열 덧셈 계산기

#### 요구사항

- 문자열을 구분자 기준을 분리하는 splitter 모델 구현
    - 쉼표(,)를 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한다.
    - 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한다.
    - 쉼표(,) 또는 콜론(:) 구분자가 섞여 있는 문자열을 전달하는 경우 구분자를 기준으로 분리한다.
    - "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 커스텀 구분자를 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한다.

- 분리된 문자열(숫자)의 합을 계산하는 calculator 모델 구현
    - 각 숫자의 합을 반환한다.
    - 빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.
        - 예) "" => 0, null => 0
    - 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
        - 예) "1" => 1
    - 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외을 던진다.
        - 예) "-1,2,3" => RuntimeException 발생

---

## Step3

### 로또(자동)

#### 요구사항

`1. 로또번호 및 로또 생성`

- 로또번호는 1 ~ 45 사이의 숫자를 가진다.
- 로또는 6개의 중복되지 않는 로또번호를 가진다.
- 로또 구입 금액이 입력되면 로또 1장 당 가격(기본값 1000원) 기준으로 구입할 수 있는 로또 갯수를 반환한다.
- 반환된 로또 갯수만큼 로또를 생성한다.

`2. 당첨번호 비교`

- 로또 한 장의 로또번호와 당첨번호 전체를 비교하여 일치하는 번호의 갯수를 반환한다.
- 구입한 전체 로또에서 당첨기준(3개 ~ 6개 일치)에 따라 당첨된 로또 갯수를 반환한다.

`3. 당첨 통계`

- 당첨된 로또를 통해 수익률을 계산한다.
    - 수익률 = 구입 금액 대비 당첨 금액
    - 소수 3째자리 절삭

`4. 입력 로직 구현`

- 구매 금액을 입력 받는다.
    - 유효성 검사 :  로또 한 장 가격 이상인지 확인
- 당첨번호를 입력 받는다.
    - 유효성 검사 : 1 ~ 45 사이의 숫자, 중복되지 않는 6개의 숫자

`5. 출력 로직 구현`

- 입력한 금액 대비 구입한 로또 갯수를 출력한다.
- 생성된 로또 목록을 출력한다.
    - 로또번호는 오름차순으로 정렬된다.
- 당첨 통계를 출력한다.

`6. 컨트롤러 구현`

- 로또 로직을 실행하는 역할을 담당한다.

---

## Step4

### 로또(2등)

#### 요구사항

`1. 보너스 볼 추가`

- 로또번호에 보너스 볼이 있는지 확인한다.
- 당첨번호와 보너스 볼을 고려하여 당첨결과를 계산한다.
- 당첨번호와 보너스 볼을 고려하여 수익률을 계산한다.

`2. 입력 기능 구현`

- 보너스 볼을 추가로 입력 받는다.
    - 1 ~ 45 이내의 숫자 1개
    - 당첨번호 6개와 중복되지 않는 숫자

`3. 출력 기능 구현`

- 당첨 통계 결과에 보너스 볼에 대한 일치 결과를 추가한다.
    - 예) 5개 일치, 보너스 볼 일치(30000000원) - 0개

---

## Step5

### 로또(수동)

#### 요구사항

`1. 로또 수`

- LottoCount 모델을 통해 전체 구입할 수 있는 로또 수와 수동으로 구매할 로또 수를 관리한다.
    - 수동으로 구매할 로또 수는 0 ~ 구매할 수 있는 전체 로또 수 사이이다.

`2. 로또 생성`

- 수동으로 생성한 로또와 함께 자동으로 로또를 생성한다.
    - 로또 목록은 수동 생성한 로또 -> 자동 생성한 로또 순이다.

`3. 입력 기능 구현`

- 수동으로 구매할 로또 수를 입력 받는다.
    - 수동으로 구매할 로또 수는 0 이상 ~ 구매할 수 있는 전체 로또 수 사이이다.
- 수동으로 구매할 번호를 입력 받는다.

`3. 출력 기능 구현`

- 수동 및 자동으로 몇 개를 구매했는지 메세지를 출력한다.
    - 예) 수동으로 3장, 자동으로 11개를 구매했습니다.
- 수동 및 자동으로 생성된 로또 목록을 출력한다.
    - 수동으로 구매한 로또 목록 -> 자동으로 구매한 로또 목록 순으로 출력