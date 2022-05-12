# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## 1단계 - 학습 테스트 실습
### String 클래스에 대한 학습 테스트
- [x] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
- [x] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
- [x] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
- [x] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
- [x] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
- [x] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
### Set Collection에 대한 학습 테스트
- [x] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
- [x] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현한다.
- [x] JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.

## 2단계 - 문자열 덧셈 계산기
### 기능 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
### 기능 목록 도출
#### 기본 문자열 분리
- [x] 쉼표(,) 또는 콜론(:) 을 기본 구분자로 정의하고 이를 정규표현식으로 처리한다.
- [x] 기본 구분자를 이용해 문자열을 분리한다.
#### 커스텀 문자열 분리
- [x] 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 정의하고 이를 정규표현식으로 처리한다.
- [x] 커스텀 구분자를 이용해 문자열을 분리한다.
#### 분리된 문자에 대한 계산 구현
- [x] String을 받아서 split된 String 배열로 변환한다.
- [x] 특정 String 형태의 값을 Integer 값으로 파싱하여 반환한다.
    - [x] 이때 빈 문자열과 null 값은 0으로 반환한다.
- [x] 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
- [x] 파싱된 숫자를 모두 합하여 결과를 반환한다.

## 3단계 - 로또(자동)
### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
### 기능 목록 도출
#### 금액 입력 및 구매처리
- [ ] 사용자로부터 구매금액을 입력받는다.
  - [ ] 구매금액은 1000원이상이다.
  - [ ] 구매금액은 empty, null, 음수의 값을 허용하지 않는다.
  - [ ] 구매금액은 1000 * n 원이다.
- [ ] 구매금액으로부터 구매 횟수를 구한다.
- [ ] 구매횟수를 출력한다.
- [ ] 생성된 로또 번호를 출력한다.
#### 로또 번호 생성
- [ ] 1 ~ 45 사이의 숫자로 이루어진 6개의 번호를 생성한다. `Collection.shuffle()`을 사용한다.
- [ ] 생성된 로또번호는 오름차순으로 관리한다. `Collection.sort()`를 사용한다.
  - [ ]  생성된 로또번호는 중복을 허용하지 않으며, 그 길이는 6이어야 한다.
- [ ] 로또 번호 도메인 VO를 구현한다.
- [ ] 로또 번호 도메인을 가지는 1급 컬랙션을 구현한다.
#### 지난 주 당첨번호 입력 및 로또 번호 생성
- [ ] 사용자로부터 지난 주 당첨번호를 입력받는다.
- [ ] 문자열 입력시 콤마(,) 기준으로 문자열을 분리한다.
  - [ ] 전체 문자열 앞뒤의 공백과 의미없는 콤마(,)가 들어왔을 때 해당 문자를 replace 한다.
  - [ ] 입력받은 문자열의 유효성 검사의 책임은 로또 번호에게 넘긴다. (로또 번호 도메인이 오류를 반환할 수 있도록)
  - [ ] 분리된 문자열은 앞뒤로 공백이 없게끔 한다.
#### 생성된 로또 번호와 입력받은 지난 주 당첨번호 비교 및 통계 출력
- [ ] 생성된 로또 번호와 입력받은 지난 주 당첨번호를 비교한다.
- [ ] 비교한 결과를 기반으로 통계를 출력한다.
- [ ] 총 수익률을 계산하고 출력한다.
