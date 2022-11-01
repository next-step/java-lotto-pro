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

## 기능 구현 목록 TODO-list

[] 유저로부터, 로또 구입 금액을 입력 받을 수 있다.

- [] 로또 구입 금액이, Null인 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [] 로또 구입 금액이, Empty인 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [] 로또 구입 금액이, Non-Numeric한 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [] 로또 구입 금액이, 로또 1장의 가격보다 작을 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.

[] 입력 받은 금액을 토대로, 구입 가능한 만큼 로또를 생성 할 수 있다.

[] 발급한 로또 개수를, 유저에게 표시 할 수 있다.

[] 발급한 로또 번호들을, 유저에게 표시 할 수 있다.

[] 유저로부터, 지난 주 당첨 번호를 쉼표 구분으로 입력 받을 수 있다.

- [] 지난 주 당첨 로또번호가, Null인 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [] 지난 주 당첨 로또번호가, Empty인 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [] 지난 주 당첨 로또번호를, 쉼표로 구분할 수 없는 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [] 쉼표로 구분한 로또번호 개수가, 6개가 아닌 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [] 쉼표로 구분한 로또번호중, 1~45번이 아닌 번호가 섞여있는 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [] 쉼표로 구분한 로또번호중, 중복되는 번호가 존재 하는 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.

[] 발행한 로또와, 지난 주 당첨 번호를 조회하여, 당첨 통계를 계산할 수 있다.

[] 발행한 로또와, 지난 주 당첨 번호를 조회하여, 총 수익률을 계산할 수 있다.

[] 계산한 당첨 통계와, 총 수익률을, 유저에게 출력 후, 프로그램을 종료 할 수 있다.

### Domain Models

[X] LottoNumber

- [X] 1부터 45까지중 하나의 번호를 골라, 로또번호를 만들 수 있다.
- [X] 주어진 번호가, 1부터 45까지의 범위에 존재 하지 않는 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [X] 메모리 효율을 높이기 위해, 로또번호는 캐시되어, 매번 새롭게 개체 생성을 하지 않을 수 있다.
- [X] 같은 로또번호를 가질 경우, 같은 개체라고 판단한다.

[X] Lotto:

- [X] 1부터 45까지의 중복되지 않는 6개의 로또번호로, 로또를 생성 할 수 있다.
- [X] 주어진 로또번호가 6개이지 않은 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [X] 주어진 로또번호중 중복되는 번호가 존재하는 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.

## Hints

* 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
* Collections.sort() 메소드를 활용해 정렬 가능하다.
* ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.