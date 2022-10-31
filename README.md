# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Step 3

* 로또 자동 기능 명세서

- [x] 뷰어 로직 개발
    - [x] 사용자 입력 뷰어 : InputView
    - [x] 결과 출력 뷰어 : OutputView
- [x] 로또 머신 기능 개발
    - [x] 금액에 따라 몇개의 로또티켓을 줄지 확인하는 기능 : Money, TicketMachine
    - [x] n 개의 로또티켓(Tickets)을 로또생성기로 생성하여 출력해주는 기능 : TicketMachine
    - [x] 자동 로또 생성기 : ShuffleTicketGenerator
      - [x] 6개의 1~45 사이의 중복되지 않는 숫자 리스트 생성 : Ticket
- [x] 당첨 번호 기능 : Lotto
    - [x] 당첨 번호 생성
      - [x] 중복되지 않은지 검증
      - [x] 1~45 사이의 숫자인지 검증
      - [x] 6개인지 검증
    - [x] 당첨 번호와 일치하는지 확인
- [x] 결과 기능 : Result, Results
    - [x] n개의 로또 중 일치하는 수에 따라 결과값 (일치수, 가격, 총 몇개) 리턴하는 기능
    - [x] 수익률 계산 기능