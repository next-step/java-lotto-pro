#3단계 - 로또(자동)

## 도메인 설계
### LottoNumber
- [x] 정수 하나를 가진다.
- [x] 1 ~ 45 중의 숫자인지 체크

### LottoNumbers
- [x] LottoNumber가 6개 인지 체크
- [x] 6개 LottoNumber 중에 중복이 있는지 체크
- [x] LottoNumbers에 입력한 LottoNumber 하나가 존재 하는지 확인
- [x] LottoNumbers 끼리 몇개의 숫자가 일치 하는 지 확인

### NumberGenerateStrategy
- [x] 전략 패턴을 사용하여 LottoNumbers 외부에서 숫자 리스트를 주입 하기 위해 사용
- [x] 구현체 LottoRandomNumberGenerateStrategy -> Random으로 6개의 숫자를 발생

### LottoVendingMachine
- [x] 입력한 금액에 따라 로또 매수 산정
- [x] 구입한 로또 매수 만큼 LottoNumbers 를 생성 하여 LottoTickets에 add

### Money
- [x] 음수 체크
- [x] 정수로 나눌수 있다.

### LottoRank
- [x] 맞은 숫자 개수에 따라서 등수 & 포상금 책정

### PurchasedLottoTickets
- [x] LottoVendingMachine에서 구입한 만큼의 LottoNumbers 리스트를 가지고 있다.
- [x] 우승 로또 번호를 입력 하여 구입한 로또들로 당첨된 LottoRank 리스트를 만들 수 있다.(구입한 로또들을 이용하여 우승 로또와 비교 해보기 때문)

### LottoWinningResults
- [x] LottoRank 리스트를 가짐
- [x] 구입한 LottoTickets로 부터 등수 별 개수 결과를 구한다.
- [x] 우승 상금을 구할 수 있다.
- [x] 수익률을 구할 수 있다.


