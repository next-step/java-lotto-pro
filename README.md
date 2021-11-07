# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## step5 - 기능 요구 사항
* 사용자는 수동으로 로또를 구매할 수 있다
* 수동으로 구매할 로또 수를 입력 받는다
  * 숫자만 입력 가능하다
  * 수동 구매 로또의 수는 전체 구입 가능한 로또보다 많을 수 없다
* 수동으로 구매하는 로또 번호를 입력 받는다
  * 입력받은 숫자는 중복되지 않는 숫자로 6개
  * 1~45 사이의 숫자

## step4 - 기능 요구 사항
* 2등을 위한 보너스 볼 추가
* 보너스 볼 숫자를 입력 받는다
* 당첨 통계에서도 보너스 볼 결과를 확인할 수 있다

## step3 - 기능 요구 사항
* 구입 금액에 해당하는 구매 가능한 로또 개수 구하기
* 중복되지 않는 6개의 숫자 발급
* 지난 주 당첨 번호와 일치한 숫자 개수 구하기
* 수익률 계산
* 구매 수량만큼 로또 구매
* 구입한 전체 로또에서 당첨 결과구하기
* UI 입출력 구현
  * 사용자는 구매 금액을 입력할 수 있다
  * 사용자는 구매 개수와 구매한 로또 번호를 볼 수 있다.
  * 사용자는 지난 주 당첨 번호를 입력할 수 있다.
  * 사용자는 당첨 통계를 볼 수 있다.

## step2 - 기능 요구 사항
* 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
* 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
* 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
* 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
* “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
* 숫자 이외의 값 또는 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)