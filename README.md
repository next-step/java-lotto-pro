# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 요구사항
### controller
- [X] 컨트롤러 클래스(LottoController)

### domain
- [X] 숫자를 표현하는 추상 클래스(Number)
- [X] 로또번호 하나를 표현하는 클래스(LottoNumber)
- [X] 로또번호와 당첨번호와 일치하는 개수를 표현하는 클래스(MatchedCount)
- [X] 돈을 표현하는 클래스(Money)
  - [X] 상금계산 위한 곱하기  
- [X] 구입 금액을 표현하는 클래스(Payment)
  - [X] 구입 가능 표 개수 구하기 

- [X] 당첨 등수를 표현하는 열거 클래스(Rank)
  - [X] 등급과 당첨 표의 개수로 총 상금 계산
  - [X] 당첨된 등급의 개수 구하기
- [X] 당첨 통계 정보를 표현하는 클래스(Result)
  - [X] 티켓정보와 당첨번호정보로 초기화
  - [X] 수익률 계산

- [X] 로또번호 6개를 표현하는 일급콜렉션 클래스(LottoNumbers)
  - [X] 로또번호 하나 포함 여부
- [X] LottoNumbers를 포함한 로또 티켓를 표현하는 클래스(Ticket)
  - [X] 당첨번호와 로또번호 일치 개수 구하기
- [X] 로또 티켓를 만드는 생성기 클래스(TicketGenerator)
  - [X] 로또 티켓 여러개를 만들기
  - [X] 로또 티멧 콜렉션을 DTO로 반환하기

### dto
- [X] 로또번호 일급콜렉션 객체 전달용 클래스(LottoNumbersDto)

### exception
- [X] 범위를 벗어 났음을 표현하는 예외클래스(OutOfBoundException)

### view
- [X] 입력 기능 클래스(InputView)
  - [X] 금액 입력
  - [X] 당첨 번호 입력
- [X] 출력 기능 클래스(ResultView)
  - [X] 티켓 출력
  - [X] 통계 출력
