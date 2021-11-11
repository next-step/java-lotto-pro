# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 덧셈 계산기 기능 요구사항
* CalculatorInputString 클래스
  * 빈 문자열, null을 입력하면 true 반환
  * toCalculatorNumbers를 통해 CalculatorNumbers 반환
  * 숫자가 아닌 값이 포함되어있으면 예외 발생

  * CalculatorInputStringParser 클래스
    * 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
    * 숫자 두개를 컴마 구분자로 입력할 경우 각 숫자를 구분하여 반환한다.
    * 콜론 구분자로 입력할 경우에도 각 숫자를 구분하여 반환한다.
    * "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있으며, 해당 구분자를 사용할 경우 각 숫자를 구분하여 반환한다.
    
  * CalculatorNumber 클래스
    * 음수일 경우 true 반환
    * 가지고있는 값을 반환
    
  * CalculatorNumbers 클래스
    * 음수가 포함되어 있을 경우 true 반환
    * 숫자가 하나뿐일 경우 true 반환
    * 인덱스를 지정해 해당 인덱스의 값을 반환
    * 숫자들의 합을 반환

* StringAddCalculator 클래스
  * 빈 문자열, null을 입력할 경우 0을 반환한다.
  * 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
  * 숫자 두개를 컴마 구분자로 입력할 경우 각 숫자의 합을 반환한다.
  * 콜론 구분자로 입력할 경우에도 각 숫자의 합을 반환한다.
  * "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있으며, 해당 구분자를 사용할 경우 두 숫자의 합을 반환한다.
  * 음수를 전달할 경우 RuntimeException 예외가 발생한다. (예 : "-1,2,3")

## 로또 (자동) 기능 요구사항
* InputView 클래스
  * 금액 입력 요청 문구 출력
  * 당첨번호 입력 요청 문구 출력
  * 보너스볼 입력 요청 문구 출력
  * 당첨번호 입력, 구입 금액 입력
  * 보너스볼 입력

* ResultView
  * 당첨 통계

* LottoGame 클래스
  * 번호 생성

* LottoNumberChoiceStrategy 인터페이스
  * choose
    * RandomClass

* LottoNumber
  * 숫자 주입 생성자
  * 주입된 숫자 반환 

* LottoPurchaseCount
  * 0원을 제공하면 예외 
  * 로또 산 횟수 반환
  * 처음에 소모한 비용 반환
  
* Lotto
  * List<Integer> 주입 생성자
  * LottoNumberChoiceStrategy 인터페이스 생성자
  * 생성자 예외1: 숫자가 6개가 아닌경우
  * 생성자 예외2: 주입하려는 컬렉션 안에 같은 숫자가 포함되어 있는 경우
  * 다른 로또와 비교하여 몇등인지 반환

* Lottos
  * 순회하며 몇등짜리 로또인지를 저장

* Rank
  * enum
  * 가격 매핑
  * matchingCount 매핑
  * matchingCount를 파라미터와 bonus 여부로 Rank 반환
  
* LottoResult
  * 몇개의 숫자가 맞는지 체크
  * 보너스 숫자 맞는지 체크
  * 몇개의 숫자가 맞는지를 기준으로 Rank 반환
  
* RewardCalculator
  * 무엇이 당첨되었는지 추가
  * 특정 등수가 당첨된 횟수 반환
  * 모든 등수의 상금과 횟수를 곱한 값을 반환