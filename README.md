# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/ne t-step/ne tstep-docs/tree/master/codereview)

## 기능 요구사항

- 입력
    - [x] 구입 금액을 입력한다.
    - [x] 지난 주 당첨 번호를 입력한다.
    - [x] 보너스 번호를 입력한다.

- 출력
    - [x] 구입 금액에 따라 구매 장수를 출력한다.
    - [x] 구매한 로또 티켓의 번호를 출력한다.
    - [x] 딩첨 여부(당첨 번호와 일치하는 개수)를 출력한다.
    - [x] 총 수익률을 출력한다.

- 구입 금액
    - [x] 구입 금액은 1000원 단위의 정수값이다.
        - [x] 음수일 경우 예외가 발생한다.
        - [x] 1000원 단위가 아닐 경우 예외가 발생한다.
    - [x] 구입 금액으로 티켓 장수를 계산한다.

- 티켓 장수
    - [x] 구입 금액에 따라 티켓 장수를 가진다.

- 로또 번호
    - [x] 1 ~ 45 사이의 값으로 로또 번호를 생성한다.
        - [x] 로또 번호가 1 ~ 45 사이의 값이 아닐 경우 예외가 발생한다.

- 로또 티켓
    - [x] 6개의 로또 번호를 가진다.
        - [x] 로또 번호가 6개 보다 작거나 많은 경우 예외가 발생한다.
        - [x] 로또 번호가 중복될 경우 예외가 발생한다.

- 로또 티켓 머신
    - [x] 티켓 장수 만큼 자동으로 로또 티켓을 생성한다.

- 당첨 번호
    - [x] 1 ~ 45 사이의 값을 입력 받아 당첨 번호를 생성한다.
        - [x] 당첨 번호가 6개 보다 작거나 많은 경우 예외가 발생한다.
        - [x] 당첨 번호가 중복될 경우 예외가 발생한다.
    - [x] 당첨 번호와 일치하는 로또 번호 개수를 반환한다.

- 보너스 번호
    - [x] 1 ~ 45 사이의 값으로 보너스 번호를 생성한다.
        - [x] 당첨 번호와 중복될 경우 예외가 발생한다.
        - [x] 보너스 번호가 1 ~ 45 사이의 값이 아닐 경우 예외가 발생한다.

- 당첨 결과
    - [x] 당첨 순위별로 당첨된 로또 티켓 개수를 조회한다.

- 당첨 순위
    - [x] 로또 당첨 번호 일치 개수 따라 로또 당첨 순위를 조회한다.
        - [x] 당첨 번호 일치 개수가 5개인 경우 보너스 번호가 일치하면 2등으로 계산한다.
    - [x] 로또 당첨 순위에 따라 상금을 조회한다.

- 당첨 통계
    - [x] 총 수익률을 계산한다.