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

## 로또(자동)
### 기능 목록
* 4단계 미션 문서에 enum Rank 소스에 따라 Prize 소스 수정
* View
  * Input View
    * 보너스 볼 입력
      * 보너스 볼을 입력해 주세요.
  * Result View
    * 당첨 통계
      * "5개 일치, 보너스 볼 일치(30000000원) - X개" 추가
* LottoNumber
  * 보너스볼 번호 변수
  * 보너스볼 번호 포함 여부 메소드
* Validate
  * 지난주 당첨 번호에 입력했던 번호 입력 불가
    * IllegalArgumentException
