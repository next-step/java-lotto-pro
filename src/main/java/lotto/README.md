#4단계 - 로또(2등)

##요구 사항 정리

## 요구 사항 정리

- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 2등은 로또번호가 5개이며 보너스번호를 맞추어야 한다.
- [ ] 보너스볼은 당첨 로또에 중복 되어서는 안된다.

#3단계 - 로또(자동)

## 요구 사항 정리
- 로또는 1 ~ 45 사이의 숫자로 이루어져 있다.
- 로또 한게임은 중복되지 않은 6자의 숫자를 선택 하여야 한다.
- 자동 게임은 구입한 로또 게임수 만큼 임의의 숫자가 생성된다.
- 자판기는 구매금액을 입력하면 살수 있는 최대의 매수를 로또게임을 만들어 준다.
- 모든 게임이 끝나면 우승 상금과 로또 금액 대비 수익률을 알려준다.

## 도메인 설계
### LottoNumber
- [x] 정수 하나를 가진다.
- [x] 1 ~ 45 중의 숫자인지 체크

### LottoNumbers
- [x] LottoNumber가 6개 인지 체크
- [x] 6개 LottoNumber 중에 중복이 있는지 체크
- [x] LottoNumbers에 입력한 LottoNumber 하나가 존재 하는지 확인
- [x] LottoNumbers 끼리 몇개의 숫자가 일치 하는 지 확인

### LottoNumbersGenerateStrategy
- [x] 전략 패턴을 사용하여 LottoNumbers 외부에서 숫자 리스트를 주입 하기 위해 사용
- [x] 구현체 RandomLottoNumberGenerateStrategy -> Random으로 6개의 숫자를 발생

### LottoVendingMachine
- [x] 구입한 로또 매수 만큼 LottoNumbers 를 가지는 PurchasedLottoTickets 생성

### Money
- [x] 음수 체크
- [x] 입력한 금액에 따라 로또 매수 산정

### LottoRank
- [x] 맞은 숫자 개수에 따라서 등수 & 포상금 책정

### WinningLotto
- [x] 당첨 로또는 LottoNumbers와 당첨 여부를 판단 한다.

### PurchasedLottoTickets
- [x] LottoVendingMachine에서 구입한 만큼의 LottoNumbers 리스트를 가지고 있다.

### LottoWinningResults
- [x] 상금을 받는 LottoRank 리스트를 가짐
- [x] 구입한 LottoTickets로 부터 등수 별 개수 결과를 구한다.
- [x] 우승 상금을 구할 수 있다.
- [x] 수익률을 구할 수 있다.


