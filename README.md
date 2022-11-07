# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 - 학습 테스트 실습
### 요구사항
#### String 클래스에 대한 학습 테스트
##### 요구사항 1
* "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 테스트 구현
- 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증
* "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 테스트 구현
- 배열로 반환하는 값의 경우 asssertj의 containsExactly를 활용해 반환 값이 맞는지 검증
##### 요구사항 2
* "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환
##### 요구사항 3
* "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 테스트 구현
* String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 테스트를 구현

#### Set Collection에 대한 학습 테스트
##### 요구사항 1
* Set의 size() 메소드를 활용해 Set의 크기를 확인하는 테스트 구현
##### 요구사항 2
* Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 테스트 구현
이 때 JUnit의 ParameterizedTest를 활용히야 중복 코드를 제거하도록 구현
##### 요구사항 3
* 요구사항 2 에 추가하여 입력 값에 따라 해당 값이 존재하는지를 판단하는 테스트 구현

## 2단계 - 문자열 덧셈 계산기
### 기능 요구사항
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
* 기본 구분자(쉼표, 콜론)외에 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용 가능하도록 함
* 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외 처리

### 프로그래밍 요구사항
* indent(들여쓰기) depth를 1 이하로 함
* 메소드가 최대 10 라인을 넘지 않도록 함
* else를 사용하지 않도록 함

## 3단계 - 로또(자동)
### 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또 발급
* 로또 1장의 가격은 1000원
* 2등을 위한 보너스 볼 추첨
* 당첨 통계에도 2등 추가
* 사용자가 수동으로 추첨 번호를 입력할 수 있는 기능 추가

### 프로그래밍 요구사항
* 모든 기능을 TDD로 구현해 단위 테스트 필요 (단 UI 로직은 제외)
* 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분
* UI로직은 InputView, ResultView 의 클래스로 분리
* 상수의 경우 java enum 적용
* 일급 콜렉션 사용
* indent depth는 1까지만 허용됨
* 메소드의 길이가 15라인을 넘어가지 않도록 구현
* 메소드가 한 가지 일만 하도록 구현
* 자바 코드 컨벤션을 지키면서 구현
* else 사용하지 않고 구현

### 예외처리
* 구입금액에 숫자가 아닌 문자 타입이 들어오는 경우 IllegalArgumentException을 반환한다.
* 구입금액에 음수가 들어오는 경우 IllegalArgumentException을 반환한다.
* 로또 구입금액으로 1000원 미만의 수가 들어오는 경우 IllegalArgumentException을 반환한다.
* 입력받은 지난 주 당첨 번호가 6개의 숫자가 아닌 경우 IllegalArgumentException을 반환한다.
* 입력받은 지난 주 당첨 번호가 1~45 범위의 숫자가 아닌 경우 IllegalArguemntException을 반환한다.
* 입력받은 지난 주 당첨 번호가 ,(comma)로 구분되지 않은 경우 IllegalArguemntException을 반환한다.
* 로또 번호가 숫자가 아닌 경우 IllegalArgumentException을 반환한다.
* 추첨한 보너스 볼이 기존 당첨번호에 포함된 경우 IllegalArgumentException을 반환한다.
* 수동 로또 구매 개수가 숫자가 아닌 경우 IllegalArgumentException을 반환한다.
* 수동 로또 구매 개수가 양의 정수가 아닌 경우 IllegalArgumentException을 반환한다.
* 구입 금액 이상의 수동 로또 구매 개수가 입력되는 경우 IllegalArgumentException을 반환한다.