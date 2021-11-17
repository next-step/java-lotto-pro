# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

### 3단계 - 로또 (자동) 기능 목록

- `가격` (Money)
    - price 값이 유효한지 확인 (0 이상)


- `로또 구매 금액` (LottoTicketPrice)
    - 구매금액(Money) -> 로또 티켓 갯수 도출


- `로또 당첨 이율` (LottoWinningProfit)
    - 로또 수익률 계산 기능


- `로또 숫자 매치 결과` (LottoMatchResult)
    - 매치 케이스(LottoMatchEnum) 별 count 보유
    - 매치 결과 기반 당첨금 계산 


- `로또 티켓 목록` (LottoTickets)
    - 로또 티켓, 로또 티켓 수 -> 로또 티켓 목록 구성
    - 티켓 매치 결과 도출


- `로또 티켓` (LottoTicket)
    - 로또 티켓 랜덤 생성 기능 (6자리 숫자로)
    - 로또 숫자(당첨 번호)와 보너스 번호를 입력 받았을 시, 입력이 유효한지 확인 (6개의 숫자인지, 번호 목록이 unique 한 지)


- `로또 숫자` (LottoNumber)
    - 숫자가 유효한지 (1~45) 검증 기능