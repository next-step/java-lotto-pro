# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 기능 요구사항

* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.
* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.

## 기능 구현 목록 TODO-list

[x] 유저로부터, 로또 구입 금액을 입력 받을 수 있다.
- [x] 로또 구입 금액이, Null인 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [x] 로또 구입 금액이, Empty인 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [x] 로또 구입 금액이, Non-Numeric한 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [x] 로또 구입 금액이, 0보다 작을 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.

[x] 입력 받은 금액을 토대로, 구입 가능한 만큼 로또를 생성 할 수 있다.

[x] 발급한 로또 개수를, 유저에게 표시 할 수 있다.

[x] 발급한 로또 번호들을, 유저에게 표시 할 수 있다.

[x] 유저로부터, 지난 주 당첨 번호를 쉼표 구분으로 입력 받을 수 있다.
- [x] 지난 주 당첨 로또번호가, Null인 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [x] 지난 주 당첨 로또번호가, Empty인 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [x] 지난 주 당첨 로또번호를, 쉼표로 구분할 수 없는 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [x] 쉼표로 구분한 로또번호 개수가, 6개가 아닌 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [x] 쉼표로 구분한 로또번호중, 1~45번이 아닌 번호가 섞여있는 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [x] 쉼표로 구분한 로또번호중, 중복되는 번호가 존재 하는 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.

[x] 유저로부터, 지난 주 당첨 보너스 볼을 입력 받을 수 있다.
- [ ] 보너스 볼이 1~45 범위의 숫자가  아닌  경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.

[ ] 발행한 로또와, 지난 주 당첨 번호 + 보너스 볼을 조회하여, 당첨 통계를 계산할 수 있다.

[x] 발행한 로또와, 지난 주 당첨 번호를 조회하여, 총 수익률을 계산할 수 있다.

[x] 계산한 당첨 통계와, 총 수익률을, 유저에게 출력 후, 프로그램을 종료 할 수 있다.

### Domain Models

[x] Money - 구입금액을 나타내는 value object

[x] LottoCusomter - 로또 구매자를 나타내는 domain model
- [x] 가진 금액으로, 구입 가능한 만큼 로또를  구입 할 수 있다.
- [x] 가진 금액이 로또 가격보다 적다면 로또를 구입 할 수 없다.
- [x] 지난주 당첨 번호를 이용하여, 당첨 통계를 계산할 수 있다.
- [x] 지난주 당첨 번호를 이용하여, 총 수익률을 계산할 수 있다

[x] LottoStore - 로또 상점을 나타내는 domain model
- [x] 로또번호를 생성하여, 로또 구매자에게 팔 수 있다.

[x] LottoNumber - 하나의 로또번호를 나타내는 value object
- [x] 1부터 45까지중 하나의 번호를 골라, 로또번호를 만들 수 있다.
- [x] 주어진 번호가, 1부터 45까지의 범위에 존재 하지 않는 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [x] 메모리 효율을 높이기 위해, 로또번호는 캐시되어, 매번 새롭게 개체 생성을 하지 않을 수 있다.
- [x] 같은 로또번호를 가질 경우, 같은 개체라고 판단한다.

[x] Lotto - 6개의 중복되지 않는 로또번호를 나타내는 value object
- [x] 1부터 45까지의 중복되지 않는 6개의 로또번호로, 로또를 생성 할 수 있다.
- [x] 주어진 로또번호가 6개이지 않은 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [x] 주어진 로또번호중 중복되는 번호가 존재하는 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [x] 다른 로또와 비교하여, 얼마나 번호가 일치하는지 알 수 있다.

### Views

[ ] InputView
- [x] 유저로부터, 로또 구입 금액을 입력 받을 수 있다.
- [x] 유저로부터, 지난 주 당첨 번호를 쉼표 구분으로 입력 받을 수 있다.
- [ ] 유저로부터, 보너스 볼을 입력 받을 수 있다.

[x] ResultView
- [x] 생성된 로또번호 목록을 출력 할 수 있다.
- [x] 당첨 통계를 출력 할 수 있다.
- [x] 총 수익률을 출력 할 수 있다.

## Hints

* 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
* Collections.sort() 메소드를 활용해 정렬 가능하다.
* ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.


## TODO
- [x] refactor : LottoTicket에서, LottoNumbers에 관련한 로직 분리.
- [x] LottoTicket은 단지, Fee와 LottoNumber를 가지고 있는 컨테이너로 분리


## Notes

- Q : 너무 로또 도메인 세부사항에 묶여있지 않나? 무언가 더 추상화 할 것은 없나?
- Learned : How to divide BigDecimal 
	- https://www.baeldung.com/java-bigdecimal-biginteger
- Q : 로또 당첨 통계 계산 책임은 누구에게 주어야 하나? 
	- 로또상점? 로또고객자신?
- Q : 로또 당첨 상금과 당첨 정책은 자주 바뀌지 않을까?
	- 일단 Enum으로 분리하고, 정책이 바뀔것같으면 Interface화.
- Q : Maintain Order in Map => TreeMap? SortedMap? ProsCons?
- Q : Enum compareTo default behavior?
	- A : The natural order implemented by this method is the order in which the constants are declared.
	- https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html#compareTo-E-
- Learned : Java 8에서 도입된 SummaryStatistics.
	- count, min, max, sum average 등의 statistics 정보를 계산해주는 클래스. 
	- 스트림과 함께 사용 가능.
	- IntSummaryStatistics, LongSummaryStatistics, DoubleSummaryStatistics
- Q : How to repeat vim ‘f’ command?
	- A : The command to repeat an f is ; (semicolon)
- Q : List Comparator?
- Q : List equals?
	- A :  two lists are defined to be equal if they contain the same elements in the same order.
	- https://docs.oracle.com/javase/8/docs/api/java/util/List.html#equals-java.lang.Object-
- Q : Enum에 너무 의존하지 있지 않나? Enum값을 그대로 쓰는게 아니라, 메시지전달을 통해서 해야 하나?
	- A : 디미터 법칙 적용하여, Enum자체를 뷰에서는 쓰지 않는 방식으로 개선