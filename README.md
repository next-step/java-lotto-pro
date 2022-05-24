# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## Step2. 문자열 덧셈 계산기 ➕

### 기능 요구사항

**문자열 쪼개기**

- [x] 기본 구분자(쉼표, 콜론)를 통해 문자열을 쪼개는 기능
- [x] 문자열 앞에 주어지는 커스텀 구분자(`//커스텀구분자\n`)를 통해 문자열을 쪼개는 기능

**덧셈 계산기**

- [x] 문자열 덧셈을 하는 기능
- [x] empty string이나 null일 경우 0을 반환하는 기능
- [x] 음수 혹은 숫자가 아닐 경우 RuntimeException 발생시키는 기능

---

## Step3. 로또(자동) 🎲

### 기능 요구사항

**입출력**

- [x] 구매금액 입출력 기능
    - [x] 정상 입출력 메시지 출력
    - [x] 1장보다 작을 경우 오류메시지 출력
- [x] 구매 개수 및 자동 생성된 번호 출력 기능
- [x] 지난주 당첨 번호 입출력 기능
    - [x] 6개가 아닐 경우 오류 메시지 출력
    - [x] 유효한 숫자 범위가 아닐 경우 오류 메시지 출력
    - [x] 중복일 경우 오류 메시지 출력
- [x] 당첨 통계 출력 기능

**핵심기능**

- [x] 구매금액 유효성 검증
    - [x] 1장 가격(1000원)보다 작을 경우 예외처리
- [x] 지난주 당첨번호 유효성 검증
    - [x] 6개가 아닐 경우 오류 발생
    - [x] 유효한 숫자 범위(1~45)가 아니거나 다른 문자가 입력될 경우 오류 발생
    - [x] 중복이 있을 경우 오류 발생
- [x] 로또번호 랜덤 생성 기능
    - [x] 1장 생성 기능
    - [x] 입력 값에 따라 N장 생성 기능
- [x] 당첨 통계 생성 기능
    - [x] 3~6개 일치하는 번호가 있는지 측정하는 기능
    - [x] 수익률 측정 기능

---

## Step4. 로또(2등) 🎲

### 기능 요구사항

**입출력**

- [x] 보너스볼 입력 기능
- [x] 2등을 위한 당첨통계 추가
    - [x] 5개 일치 + 보너스볼 일치 시 2등 출력 구문 추가

---

## Step5. 로또(수동) 🎲

### 기능 요구사항

**입출력**

- [x] 수동 구매 개수 입력 기능
- [ ] 수동으로 구매할 로또 번호 입력 기능
- [ ] 수동/자동으로 구매한 모든 로또번호 출력 기능

**핵심기능**

- [ ] 수동 구매 개수, 자동 구매 개수를 판별하는 기능
- [ ] 예외처리
    - [ ] 사용자가 입력한 모든 input 값에 대하여, 유효하지 않을 경우 재입력받는 기능 추가
    - [ ] 수동 구매 개수가 0보다 작거나, 입력한 돈보다 많을 경우 예외처리
    - [ ] 수동 구매 번호가 유효하지 않을 경우 예외처리(잘못된 입력부터 다시 입력받도록)
- [ ] java8에 추가된 Optional을 적용해 NullPointerException이 발생하지 않도록 