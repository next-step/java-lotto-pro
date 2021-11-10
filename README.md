# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## 3단계 - 로또(자동)
### 기능 목록
- [x] 로또 발급 시작
- [x] 로또 구입 금액 입력받기
  - [x] 구입 금액은 양수
- [x] 구입 금액으로 구매할 수 있는 로또 최대 장수 구매
  - [x] 로또 1장 가격은 1,000원
- [x] 구매한 로또 1장당 로또 번호 6개 자동 생성 후 출력
  - [x] 로또 번호는 1~45까지의 정수
  - [x] 로또 1장에 중복된 번호는 존재하지 않음
  - [x] 자동 생성된 로또 번호는 오름차순 정렬
- [x] 지난주 당첨 번호 입력받기
  - [x] 1~45까지 정수에서 중복되지 않은 6개 번호
- [x] 당첨 통계 출력
  - [x] 3~6개 일치한 로또 장수
- [x] 총수익률 출력
  - [x] 수익률 기준은 1

---

## 4단계 - 로또(2등)
### 기능 목록
- [x] 보너스 볼 입력받기
  - [x] 보너스 볼은 당첨 번호 5개와 중복되지 않고, 1~45까지 정수이다.
- [] 당첨 통계에 2등 추가
  - [] 2등은 당첨 번호 5개를 맞추고, 보너스 볼까지 맞아야 한다.
