# step3 로또
## 요구 사항 분석
-  로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
-  로또 1장의 가격은 1000원이다.
-  지난 주 당첨 번호를 입력 받을 수 있어야 한다.
-  입력받은 지난 주 당첨 번호와 발급 받은 로또 번호를 가지고 통계를 낼 수 있다.
    -   통계는 발급받은 로또 번호를 지난주 로또번호와 비교하여 
        3개 , 4개 , 5개 ,6개 일치하는 로또의 개수를 파악하여 반환한다.
    - 수일률을 계산하여 반환한다.

## 개발 기능
##### 로또 번호를 나타내는 LottoNumber 클래스
- 로또 번호(1~45)를 필드로 가진 LottoNumber 클래스 생성
- 로또 번호를 받을때 1~45 사이의 값인지 체크하는 기능 제공
- 로또 번호가 숫자 문자열로 들어올 시 체크하는 기능 제공
##### 로또 번호 생성
- 로또 번호를 자동 생성하는 기능 개발
##### LottoNumber 리스트를 필드로 가진 Lotto 클래스
- 로또 번호 리스트를 가진 Lotto 클래스 생성
- 로또 번호 개수가 6개 인지 체크하는 기능 제공
##### Lottos
- Lotto 클래스를 리스트로 가지고 있는 클래스
- 당첨번호와 비교하여 상금 결과를 제공하는 기능
##### 돈 Money
- 입력 받은 금액을 가지고 있는 클래스
- 입력 받은 금액으로 로또를 살수 있는지 판별하는 기능 제공
- 입력 받은 금액으로 살수 있는 로또 개수 반환하는 기능 제공
##### LottoSeller
- 로또 판매 기능 제공
##### LottoBuyer
- 로또를 구매하는 기능 제공
- 구매한 로또와 당첨로또를 비교하여 통계 기능 제공


## step2 문자열 덧셈 계산기
### 요구사항
* 기본 구분자 (, :) 을 가지고 문자열을 분리한다
* 기본 구분자 뿐만 아니라 커스텀 구분자를 통해서도 문자열을 분리 할 수 있다.
  * 커스텀 구분자는 문자열 앞에 해당하는 “//”와 “\n” 사이에 위치하는 문자이다.
  * ex  (testCase = "//_\n1_2_3" 인 경우 구분자 _ )
* 구분자 없이 숫자문자열이 들어오면 해당 문자열에 들어있는 숫자를 반환한다.
     * ex  (testCase = "1" --> 1 , "123" --> 123)
* 빈문자열 or Null 값을 입력할 경우 0을 반환하다.
* 문자열을 구분자로 분리 후 숫자의 합을 반환한다.
    * ex   (testCase = "1,2,3" --> 6 , "1,2:3" --> 6)
* 음수를 전달할 경우 RuntimeException 발생시킨다.
* 숫자가 아닌 문자열이 들어올 경우 RuntimeException 발생시킨다.



## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

