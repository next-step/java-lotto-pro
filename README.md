## 로또(자동)
### 기능 목록
* LottoNumber
  * 1 ~ 45 사이의 숫자 6개를 가지는 클래스
* WinningNumber
  * 사용자로부터 입력 받은 6개의 지난주 당첨 번호
* AutoLottoNumberGenerator
  * 1 ~ 45 사이의 숫자 중에 6개를 반환하는 클래스
* LottoGame
  * 입력 받은 구매 금액에 따라 구매 횟수 계산
  * 구매 횟수 만큼 로또 번호 생성
* LottoGameMain
  * InputView, ResultView, LottoGame을 가져와서 조합
* View
  * InputView
    * 구매 금액 입력
    * 당첨 번호 입력
    * 각 입력에 대한 유효성 검사
  * ResultView
    * 구매 횟수 출력
    * 구매한 로또 번호 출력
    * 당첨 통계 출력
* Statistic
  * 입력 받은 당첨 번호로 로또 당첨 통계를 집계
    * 등수따라 각 개수
    * 총수익, 총수익률
* Spliter
  * 사용자로부터 입력받은 문자열을 잘라서 숫자로 변환
* Validate
  * 구매 금액 입력
    * ""(null)을 입력한 경우
      * IllegalArgumentException
    * 입력 금액이 로또 1장 비용보다 적은 경우
      * IllegalArgumentException
    * 입력 받은 금액이 숫자가 아닌 경우
      * IllegalArgumentException
    * 입력 받은 당첨 번호가 1 ~ 45 범위의 숫자가 아닌 경우
      * IllegalArgumentException
  * 당첨 번호 입력
    * ""(null)을 입력한 경우
      * IllegalArgumentException
    * 입력 받은 금액이 숫자가 아닌 경우
      * IllegalArgumentException
    * 입력 받은 당첨 번호가 1 ~ 45 범위의 숫자가 아닌 경우
      * IllegalArgumentException
    * 입력한 번호 개수가 6개가 아닌 경우
      * IllegalArgumentException
* Constant
  * 고정값
    * 번호를 맞춘 개수 ex) 3, 4, 5, 6
  * 금액
    * 로또 1장 금액 ex) 1000원
  * 출력 문구
    * 구입금액을 입력해 주세요.
    * 지난 주 당첨 번호를 입력해 주세요.
    * n개를 구매했습니다.
    * 당첨 통계
  * 에러 메세지
    * 숫자만 입력할 수 있습니다.
    * 숫자는 1 ~ 45까지 입력할 수 있습니다.
    * 로또 복권 1장의 구입 가격 1000원 입니다.
* Prize
  * 맞춘 개수, 보상 금액

* * *
## 로또(2등)
### 기능 목록
* 4단계 미션 문서에 enum Rank 소스에 따라 Prize 소스 수정
* View
  * Input View
    * 보너스 볼 입력
      * "보너스 볼을 입력해 주세요." 추가
  * Result View
    * 당첨 통계
      * "5개 일치, 보너스 볼 일치(30000000원) - X개" 추가
* LottoNumber
  * 보너스볼 번호 변수 추가
  * 보너스볼 번호 포함 여부 메소드 추가
* Statistic
  * prize 변수 key값을 Integer 타입에서 Rank 타입으로 변경
* Validate
  * 지난주 당첨 번호 중에 중복된 번호가 있는지 검사
    * "로또 번호는 중복될 수 없습니다." 추가
    * IllegalArgumentException
  * 지난주 당첨 번호에 입력했던 번호 입력 불가
    * "입력하신 보너스 번호는 지난주 당첨 번호에 이미 있는 번호입니다." 추가 
    * IllegalArgumentException

* * *
## 로또(수동)
### 기능 목록
* 정적 팩토리 메소드 적용
  * LottoNumber
* 인스턴스 캐싱 적용
  * LottoNumber
* 일급 컬렉션
  * List\<LottoNumbers\> -> PurchaseLottoNumbers
  * totalMoney
  * balance
  * manualPurchaseCount
  * autoPurchaseCount
* Constant
  * "수동으로 X장, 자동으로 XX개를 구매했습니다." 추가
* View
  * InputView
    * "수동으로 구매할 로또 수를 입력해주세요." 추가
      * 입력받은 금액과 비교해서 입력한 수 만큼 구매할 수 있는지 유효성 검사 
    * "수동으로 구매할 번호를 입력해주세요." 추가
      * 1 - 45 범위 안의 숫자인지 유효성 검사
* Validate
  * 지난주 당첨 번호만 검증하던 메소드가 수동 번호 입력도 검증해야 해서 메소드 명 변경
    * validateWinningNumber~ -> validateLottoNumber~
  * 수동으로 구매할 로또의 금액이 지불한 총금액보다 크면 예외 처리
  * 수동으로 구매할 로또의 금액이 현재 가진 금액을 초과할 경우 예외 처리
* LottoNumberGenerator
  * 인터페이스 -> 클래스로 수정
  * 수동 번호 생성 메소드 추가
  * 번호 입력시 1 - 45 범위 안의 숫자인지 유효성 검사
  * 사용자가 잘못된 값을 입력했을 Optional을 적용해 NullPointerException이 발생하지 않도록 한다.