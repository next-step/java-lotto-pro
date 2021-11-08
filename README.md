# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 2단계 - 문자열 덧셈 계산기
 - 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.
 - 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
 - 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
 - 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
 - “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
   - Pattern과 Matcher 그리고 정규식을 이용하여 값을 구한다.
 - 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)

## 3단계 - 로또(자동)
- 로또
  - 로또 숫자 
      - [X] 1 ~ 45까지 숫자 중 랜덤하게 뽑는다.
      - [X] 1 ~ 45사이의 숫자가 아닌 값이 나오면 예외 처리 한다.
  - [X] 지난주 당첨번호 입력 검증한다.
  - [X] 숫자형 문자열 입력 시 ','로 구분하여서 작성시 처리
  - [X] 그외는 예외 처리 한다.
  - [X] 로또 번호와 우승 로또 번호와 비교하여 매치되는 수를 처리한다.
- 지불금액
  - [X] 로또 구입 금액 입력 검증한다.
  - [X] 숫자가 아닐 경우 메세지 출력 후 다시 입력 처리한다.
  - [X] 한 장 당 구입 금액(1000원)의 대하여 총 구매장수를 계산 처리한다.
- 로또들
  - [X] 구입 금액 장수만큼 로또(6자리) 생성한다.
  - [X] 구입한 로또 리스트와 당첨 우승 로또와 비교 처리한다.
- 당첨결과
  - [X] 당첨 결과 체크 후 통계 정보 출력한다.
  - [X] 각 등수별로 당첨된 갯수를 구한다.
- 등수확인
  - [X] 3개 일치할 경우 5000원
  - [X] 4개 일치할 경우 50000원
  - [X] 5개 일치할 경우 1500000원
  - [X] 6개 일치할 경우 2000000000원
  - [X] 당첨결과를 토대로 수익률 계산한다. 계산식은 (당첨금액합산 / 구입금액) 으로 한다.
- 자동생성로또
  - [X] `로또 숫자` 객체를 이용하여 6자리로 이루어진 로또 번호 생성한다.

## 4단 - 로또(2등)
- 로또
  - 보너스볼
    - [ ] 1 ~ 45까지 숫자 중 보너스 볼을 입력한다.
    - [ ] 1 ~ 45사이의 숫자가 아닌 값이 나오면 예외 처리 한다.
- 당첨결과
  - [ ] 당첨 결과 체크 시 5개 일치, 보너스 볼을 출력한다.
  - [ ] 5개 일치, 보너스 볼 당첨된 갯수를 구한다.
- 등수확인
  - [ ] 5개 일치, 보너스 볼 일치할 경우 30000000원
  - [ ] 당첨결과를 토대로 수익률 계산한다. 계산식은 (당첨금액합산 / 구입금액) 으로 한다.
