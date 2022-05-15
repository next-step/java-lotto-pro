# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 문자열 덧셈 계산기
## 요구사항
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달할 경우 구분자를 기준으로 분리한 숫자의 합 반환
* 쉼표, 콜론 이외 커스텀 구분자 지정 가능("//와 \n사이에 위치하는 문자)
* 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw

## 기능목록
* null 또는 빈 문자를 입력값으로 받으면 0을 리턴한다.
* 구분자를 포함한 문자인지 확인한다.
* 구분자가 없다면, 숫자 하나를 문자열로 입력하였는지 확인한다.
* 구분자로 split 한 값의 합을 반환한다.

# 로또(자동)
## 기능 목록
### 구매
* [x] 구입 금액 입력 기능
* [x] 구입 금액에 따른 로또 구매 장 수 계산 기능

### 로또
* [x] 지난주 당첨 번호 입력 기능
* [x] 로또 번호 발급 기능
* [x] 로또 구매 개수 계산 기능
* [x] 3개 번호가 일치하는 로또 개수 계산
* [x] 4개 번호가 일치하는 로또 개수 계산
* [x] 5개 번호가 일치하는 로또 개수 계산
* [ ] 6개 번호가 일치하는 로또 개수 계산
* [ ] 총 수익률 계산

### 출력
* [x] 로또 구매 장 수 출력 기능
* [ ] 로또 번호를 구매 개수 만큼 출력하는 기능
* [ ] 당첨 통계 출력 기능
* [ ] 3개 번호가 일치하는 로또 개수 출력 기능
* [ ] 4개 번호가 일치하는 로또 개수 출력 기능
* [ ] 5개 번호가 일치하는 로또 개수 출력 기능
* [ ] 6개 번호가 일치하는 로또 개수 출력 기능
* [ ] 총 수익률 출력 기능