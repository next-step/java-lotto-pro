# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 목록
* main 메서드 생성
* 구매금액 입력
    - [X] 1000원 단위로 입력해야한다.
    - [X] 0 이상의 숫자 입력  
    - [X] 구매개수 출력
* 로또 번호 생성
    - [X] 로또 번호와 로또 번호 리스트를 담는 클래스 생성
      - [X] 로또 번호는 1 ~ 45까지의 숫자이다.
      - [X] 로또 번호는 6개를 가질수 있다.
      - [X] 로또 번호 리스트는 중복된 숫자는 담을 수 없다.
    - [X] 자동 번호 생성
    - [X] 생성된 번호 출력
    - [X] 구매한 로또개수만큼 자동으로 번호 생성
* 당첨번호 입력
    - [X] 숫자만 받을 수 있도록 한다.
    - [X] 중복된 숫자 입력 시 재입력
    - [X] 1 ~ 45까지의 숫자만 받을 수 있도록한다.
* 당첨 통계 처리
    - [X] 맞춘 숫자 개수에 따라 등수를 정한다.
    - [X] 당첨 결과 관리/출력
    - [X] 수익률 계산
    - [X] 수익률 출력
  
4단계 - 2등 추가

* [X] 2등을 위한 추가 당첨번호를 추가한다.
* [X] 당첨 통계에 2등을 추가한다.

5단계 - 수동 입력 추가

* [ ] 수동 개수 입력
* [ ] 수동 로또 번호 입력
* [ ] 출력시 수동도 같이 출력