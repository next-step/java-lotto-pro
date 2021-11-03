# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 1단계 - 학습 테스트 실습
## 기능 요구사항
* [X] String 클래스에 대한 학습 테스트를 구현한다.
    * [X] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    * [X] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    * [X] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
    * [X] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    * [X] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    * [X] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

* [X] Set Collection에 대한 학습 테스트를 구현한다.
    * [X] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
    * [X] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현한다.
    * [X] JUnit의 ParameterizedTest를 활용해 중복 코드를 제거한다.
    * [X] @CsvSource를 사용하여 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
        * 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.

# 2단계 - 문자열 덧셈 계산기
## 기능 요구사항
* [X] 빈 문자열 또는 null 값을 입력할 경우 0을 반환한다. (예 : "" => 0, null => 0)
* [X] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : "1")
* [X] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : "1,2")
* [X] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : "1,2:3" => 6)
* [X] "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : "//;\n1;2;3" => 6)
* [X] 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : "-1,2,3")

# 3단계 - 로또(자동)
## 기능 요구사항
* [X] 로또
    * [X] 로또숫자
        * [X] 생성할 숫자가 1~45 사이가 아니면 IllegalArgumentException이 발생한다.
    * [X] 입력받은 문자열을 구분자(,)를 기준으로 나눌 수 있다.
    * [X] 로또의 로또숫자가 6개가 아니면 IllegalArgumentException이 발생한다.
    * [X] 로또의 로또숫자 중 중복된 숫자가 있으면 IllegalArgumentException이 발생한다.
    * [X] 로또 간의 같은 로또숫자의 갯수가 몇개인지 확인할 수 있다.
    * [ ] 등수
        * [ ] 같은 로또숫자의 갯수와 보너스볼 당첨 여부에 따른 등수를 반환한다.
            * [ ] 3개 미만 - MISS
            * [ ] 3개 일치 - 5등
            * [ ] 4개 일치 - 4등
            * [ ] 5개 일치, 보너스볼 미당첨 - 3등
            * [ ] 5개 일치, 보너스볼 당첨 - 2등
            * [ ] 6개 일치 - 1등
* [X] 로또들
    * [X] 로또의 개수를 구할 수 있다.
    * [X] 로또들과 로또의 로또숫자를 비교해서 같은 로또숫자의 개수들을 구할 수 있다.
* [X] 구입금액
    * [X] 구입금액이 1000원 이하일 경우 IllegalArgumentException이 발생한다.
    * [X] 구입금액에 따른 뽑기횟수를 구할 수 있다. (예 : 5000원 => 5회)
* [X] 로또머신
    * [X] 로또 생성 전략
        * [X] 중복이 없는 6개의 로또숫자를 생성한다.
    * [X] 뽑기횟수만큼 로또를 자동생성한다.
* [ ] 통계
    * [ ] 당첨로또의 숫자가 보너스볼과 중복될 경우 IllegalArgumentException이 발생한다.
    * [ ] 당첨로또, 보너스볼과 구입한 로또들을 비교해서 당첨결과를 통계낸다.
* [ ] Controller와 View단을 구현한다.
