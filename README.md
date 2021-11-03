# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

# 1단계 : 학습 테스트 실습

### 1. String 클래스에 대한 학습 테스트
- [X] (공통)JUnit 의 @DisplayName 을 활용해 테스트 메소드의 의도를 드러낸다.
- [X] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
- [X] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
- [X] "(1,2)" 값이 주어졌을 때 String 의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
- [X] "abc" 값이 주어졌을 때 String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
- [X] String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생하는 부분에 대한 학습 테스트를 구현한다.

### 2. Set Collection 에 대한 학습 테스트
- [X] Set 의 size() 메소드를 활용해 Set 의 크기를 확인하는 학습테스트를 구현한다.
- [X] Set 의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현한다.
    - [X] JUnit 의 ParameterizedTest 를 활용해 중복 코드를 제거한다.
- [X] 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
    - [X] 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case 로 구현한다.

---

# 2단계 : 문자열 덧셈 계산기를 통한 TDD/리팩토링 실습

### 1. 쉼표(,) or 콘론(:) 을 구분자로 문자열 분리
- [X] 쉼표(,) or 콘론(:) 을 기본 구분자로 정규표현식 정의
- [X] 기본 구분자("," or ":")로 문자열 분리

### 2. 커스텀 구분자로 문자열 분리
- [X] 입력된 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 정규표현식 정의
- [X] 커스텀 구분자로 문자열 분리

### 3. 문자열 덧셈 계산기 구현
- [X] (예외처리) 입력값이 null 또는 빈 문자열("") 이면, 0 반환
- [X] 입력된 문자열을 기본 or 커스텀 구분자로 분리

### 4. 분리된 문자열을 숫자로 파싱
- [X] (유효성 체크) 분리된 문자열이 0 이상의 숫자로만 구성되어있지 않으면 RuntimeException 예외 throw
- [X] 유효성 체크를 통과하면, 분리된 문자열들을 각각 숫자로 파싱

### 5. 파싱된 숫자들의 합 반환
- [X] (예외처리) 파싱된 숫자 목록의 크기가 0 이면, 0 반환
- [X] 파싱된 숫자들의 합 계산
- [X] 최종 합산된 결과값 반환

---

# 3단계 : 문자열 덧셈 계산기를 통한 TDD/리팩토링 실습

### 1. 로또 자동 생성
- [X] Collections.shuffle() 이용하여 랜덤한 숫자 6개 자동 생성
- [X] 로또 자동 생성 후 Collections.sort() 이용하여 오름차순으로 정렬
- [X] 도메인 클래스를 값 객체(Value Object), 1급 컬렉션 사용
- [X] (유효성 체크) 로또 숫자는 1 ~ 45 사이의 서로 중복되지 않는 6개의 숫자로 구성
  - [X] 1 ~ 45 사이로 구성
  - [X] 서로 중복되지 않는 6개로 구성

### 2. 지난 주 당첨 번호 생성
- [X] 문자열 입력 시, 콤마(,) 를 구분자로 문자열 분리
- [X] 분리된 문자열 파싱 : String -> Integer
- [ ] (유효성 체크) 1 ~ 45 사이의 서로 중복되지 않는 6개의 숫자로 구성
  - [ ] 1 ~ 45 사이로 구성
  - [ ] 서로 중복되지 않는 6개로 구성

### 3. 당첨 여부 확인
- [ ] 지난 주 당첨 번호와 비교하여 자동 생성된 로또가 당첨되었는지 확인

### 4. (View) 로또 구입 금액 입력
- [ ] (유효성 체크) 0 이상의 양수가 아닌 경우 Exception 발생
  - [ ] 예외가 발생하면 안내 문구 출력 후 다시 로또 구입 금액 입력 받음

### 5. 로또 구매 수량 계산
- [ ] 로또 1개 가격 1000 으로 설정
- [ ] 구입 금액으로부터 로또 구매 수량 계산
- [ ] (View) 구매 수량 출력

### 6. 구매 수량만큼 로또 자동 생성
- [ ] 산출된 구매 수량만큼 로또 자동 생성
- [ ] (View) 자동 생성된 로또 목록 출력

### 7. (View) 지난 주 당첨 번호 입력
- [ ] (유효성 체크) 잘못된 값을 입력한 경우 Exception 발생
  - [ ] 예외가 발생하면 안내 문구 출력 후 다시 지난 주 당첨 번호 입력 받음
  
### 8. 당첨 통계 계산
- [ ] 숫자가 3개 일치한 로또 통계 계산
- [ ] 숫자가 4개 일치한 로또 통계 계산
- [ ] 숫자가 5개 일치한 로또 통계 계산
- [ ] 숫자가 6개 일치한 로또 통계 계산
- [ ] 숫자률 계산(소수 셋째 자리에서 반올림)

### 9. (View) 당첨 통계 출력
- [ ] 일치 숫자 별 당첨 개수 출력
- [ ] 총 수익률 출력