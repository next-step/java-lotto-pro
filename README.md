# 로또
## 기능목록
- domain
  - [x] 로또 기계 도메인 클래스 구현 (LottoMachine)
    - [x] 금액에 따른 로또를 발급한다.
  - [x] 로또 도메인 클래스 구현 (Lotto)
    - [x] 로또 번호를 자동 생성한다.
  - [x] 로또 구매자 도메인 클래스 구현 (LottoResult)
    - [x] 로또 묶음 중 3/4/5/6개 번호가 일치했는지 계산한다.
    - [x] 수익률을 계산한다.
    - [x] 보너스볼 추가
  - [ ] 로또 묶음 일등컬렉션 구현 (Lottos)
- view
  - [x] 입력을 받는 view 구현 (InputView)
    - [x] 보너스볼 입력 추가
  - [x] 결과를 출력하는 view 구현 (ResultView)
    - [x] 보너스볼이 일치한 2등 당첨 결과 출력 추가
- controller
  - [x] view와 domain을 연결 (LottoController)
