# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

로또 - TDD
## Step2 - 문자열 덧셈 계산기 기능 목록
- [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : "1", "30", "500", "7000")
- [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2” => 3)
- [x] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
- [x] “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
- [x] 숫자 이외의 값 또는 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
- [x] 입력문자 split 기능 클래스 분리
- [x] 숫자 이외의 값 또는 음수를 전달할 경우 예외처리 클래스 분리
## Step2 리뷰를 통한 리팩토링
- [x] Pattern 클래스를 미리 생성해두고 재사용하기
- [x] CUSTOM_DELIMITER_PATTERN 상수 중복을 제거
- [x] 한라인도 괄호로 감싸주기
- [x] 클래스와 메소드 이름에서 역할이 명확히 나타나도록 이름 변경

## Step3 - 로또(자동) 기능 목록
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또 티켓 수 계산
- [x] 로또 번호 6자리를 자동 생성
  - [x] Collections.shuffle() 메소드 활용
  - [x] Collections.sort() 메소드를 활용
- [x] 로또 티켓의 로또 번호에 당첨 번호가 몇개 있는지 세기
- [x] 구매 로또 티켓 리스트에서 당첨 번호와 3개, 4개, 5개, 6개 일치하는 티켓 수 계산 
- [x] 구입금액과 상금으로 수익률을 계산

## Step4 - 로또(2등) 기능 목록
- [X] 당첨 통계에 2등 추가(보너스 번호 추가)
- [x] 보너스 번호가 당첨 번호에 존재하는 번호이면 에러 발생
- [X] 로또 티켓 번호에 보너스 번호 매치 여부 확인
- [X] 구매한 전체 로또 티켓에서 등수별 티켓 수 확인(보너스 번호 추가)
- [] 2등 추가로 인한 로또 상금 계산 결과식 변경

