# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 로또 기능 정의
* 로또
    * 로또의 번호는 6개 이다.
    * 로또의 번호에 중복은 없다.
    * 로또의 번호는 정렬되어 있다.
    * 로또의 번호와 승리번호의 일치 갯수 확인.
    

* 로또 번호
    * 로또의 번호는 1부터 45까지 이다.
    * 로또 번호 목록을 생성한다.
    * 로또 번호를 생성한다.

* 순위
    * 순위 번호는 갯수별로 정해진다
        * 3개면 4등
        * 4개면 3등
        * 5개면 2등
        * 6개면 1등
    * 순위 별 가격을 합산하여 통계를 구한다.
        * 4등은 5천원
        * 3등은 5만원
        * 2등은 150만원
        * 1등은 20억
