# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## 단계별 학습 요구 사항

### 1단계 - 학습 테스트 실습

1. String 클래스에 대한 학습 테스트
    1. 요구사항 1
        - [x] "1,2"를 `,`로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습테스트 구현
        - [x] "1"을 `,`로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습테스트 구현
    2. 요구사항 2
        - [x] "1,2" 값이 주어진 경우 String의 **substring()** 를 활용해 반환 값이
    3. 요구사항 3
        - [x] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
        - [x] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
          StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        - [x] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
2. Set Collection 에 대한 학습 테스트
    1. 요구사항 1
        - [x] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습 테스트를 구현한다.
    2. 요구사항 2
        - [x] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습 테스트를 구현하려 한다.
          구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
          JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
    3. 요구사항 3
        - [x] 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다.
          입력 값에 따라 결괏값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
          예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false가 반환되는 테스트를
          하나의 Test Case로 구현한다.

### 2단계 - 문자열 덧셈 계산기

1. 기능 요구사항
    - [x] 쉼표 또는 콜론을 구분자로 가지는 문자열인 경우 구분자를 기준으로 분리한 숫자의 합 반환
    - [x] 커스텀 구분자를 지정하여 "//" 와 "\n" 사이에 특정 문자가 있으면 그 문자로 숫자의 합 반환
    - [x] 문자열 계산기에 숫자 이외의 값 또는 음수 전달이 Exception 에러 throw

### 3단계 - 로또(자동)

1. 기능 요구사항
    - [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또 발급
    - [x] 로또 가격 1000원
2. 기능 목록
    - [x] 프로그램 시작 시 구매금액 입력 문구 요청
    - [x] 사용자 가격만큼 로또 구매
        - [x] 이와 관련된 유효성 처리(양의 숫자 및 1000단위로만 입력되게)
    - [x] 사용자에게 로또 출력 구매 개수 알림(해당 값은 가지고 있어야 함)
    - [x] 구매한 로또 만큼 구입 및 출력
        - [x] 로또 번호 랜덤
        - [x] 로또 번호 중복되지 않도록
    - [x] 지난 주 당첨 번호 입력 문구 추가
        - [x] 입력 값 관련 유효성 처리
    - [x] 당첨 통계 기능 추가
        - [x] 3~6개 일치하는 경우 개수 파악
        - [x] 총 수익률 관련 처리기
            - [x] 전체 로또 금액 계산
            - [x] 일치하는 숫자별 당첨금 확인
            - [x] 로또 당첨 금액 계산
3. Reference
    - [랜덤 로또 번호 구현](https://mainia.tistory.com/2318?fbclid=IwAR1jsc1EZZr9DykSocbJiEx53ZKTSKrpc1PSBHnHankbpLvO-OOc0HnHemo)
    - [스트림 관련](https://ryan-han.com/post/dev/java-stream/)
    - [테스트 코드 작성 관련](https://www.baeldung.com/parameterized-tests-junit-5)

### 4단계 - 로또(2등)

1. 기능 요구사항
    - [x] 2등을 위해 추가 번호를 하나 더 추첨
    - [x] 당첨 통계에 2등도 추가
2. 기능 목록
    - [x] 보너스 볼 기능 추가
        - [x] 입력 문구 추가
        - [x] enum에 보너스 볼 추가

### 5단계 - 로또(수동)

1. 기능 요구사항
    - [ ] 사용자가 수동으로 추첨 번호를 입력할 수 있도록 한다.
    - [ ] 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.
    - [ ] 예외 처리를 통해 에러가 발생하지 않도록 한다.
2. 기능 목록
    - [ ] 수동 로또 수 입력
        - [ ] 구입금액보다 수동으로 입력한 로또 금액이 큰 경우 오류
        - [ ] 숫자 관련 유효성 처리
    - [ ] 수동으로 구매할 번호 입력
        - [ ] 로또 수 만큼 순회하면서 입력 및 유효성 처리
        - [ ] 입력한 수동 로또 기억
    - [ ] 수동 구매 개수, 자동 구매 개수 출력
    - [ ] 사용자 입력 관련 예외 처리 시 에러가 발생하지 않도록 한다.
