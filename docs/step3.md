# 3단계 - 로또(자동)

---

## 요구사항 정리

 - 로또 구입 금액 입력값에 따라 알맞은 개수의 로또를 자동으로 발급한다.
 - 로또 1장의 가격은 1000원
 - 당첨 번호 입력 값에 따라 통계치를 계산한다.
 - 통계치는 맞춘 개수에 따른 당첨 횟수, 수익률을 표시한다.

## 객체

 - Model
   - Money
   - LottoNumber
   - WinningLotto
   - LottoAutoFactory
   - PurchasedLotto
   - PurchasedLottos
   - LottoStatistics
 - Controller
   - LottoMachine
 - View
   - InputView
   - OutputView
