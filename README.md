# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 - 학습 테스트 실습
### 기능 목록
* String 클래스에 대한 학습 테스트
  * 요구사항 1 - split() 사용하기
    * [x] "1,2"을 ,를 구분자로 하여 잘 분리되는지 확인
      * assertj의 contains() 사용
      * assertj의 containsExactly() 사용
    * [x] "1"과 같이 ,가 없을 때 사이즈 1개의 배열 반환 확인
      * assertj의 containsExactly() 사용
      * assertj의 containsOnly() 사용
  * 요구사항 2 - substring() 사용하기
    * [x] "(1,2)"가 주어졌을 때 ()를 제거하고 "1,2"만 반환 확인
      * assertj의 isEqualTo() 사용
  * 요구사항 3 - charAt() 사용하기
    * [x] "abc"가 주어졌을 때 charAt()을 통해 특정 위치 문자 확인
      * assertj의 isEqualTo() 사용
    * [x] charAt() 사용 시, 문자열 길이를 벗어난 위치를 가져오고자 할 때 StringIndexOutOfBoundsException 발생 확인
      * assertThatThrownBy() 사용
      * assertThatExceptionOfType() 사용
    * [x] JUnit의 @DisplayName 활용해 테스트 메소드 의도 보일 것
* Set Collection 학습 테스트
  * [x] Set 데이터 세팅
  * 요구사항 1 - Set의 size() 사용하기
    * [x] Set 사이즈 확인
  * 요구사항 2 - Set의 contains() 사용하기
    * [x] 주어진 Set 내에 1, 2, 3의 값 존재 여부 확인
      * JUnit의 ParameterizedTest 및 ValueSource 사용
  * 요구사항 3 - Set의 contains() 사용하기
    * [x] 주어진 Set 내에 없는 값이면 false, 존재하는 값이면 true 반환 확인
      * JUnit의 ParameterizedTest 및 CsvSource 사용

## 2단계 - 문자열 덧셈 계산기
### 기능 목록
* 기본 구분자로 문자열 split
  * 기본 구분자: 쉼표(,) 또는 콜론(:)
* 커스텀 구분자로 문자열 split
  * 커스텀 구분자: 문자열 **앞부분**의 "//"와 "\n" 사이 문자를 커스텀 구분자로 사용
  ```java
  // java.util.regex 패키지의 Matcher, Pattern import
  Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
  if (m.find()) {
    String customDelimiter = m.group(1);
    String[] tokens= m.group(2).split(customDelimiter);
    // 덧셈 구현
  }
  ```
* split한 숫자들 덧셈
  * split한 문자열을 숫자로 변환하여 덧셈
  ```java
  int number = Integer.parseInt(text);
  ```
  * [x] 덧셈할 문자열이 숫자 이외의 값 또는 음수일 경우 RuntimeException 예외 throw
    * [x] 원시값 포장 및 collection 포장을 위해 PositiveNumber, PositiveNumbers 구현
    * 기본적으로 parseInt 할 때에 숫자가 아니면 NumberFormatException이 발생하여, 에러 발생 시, 메시지만 변경함
    * 음수값은 잘못된 인자가 들어온 걸로 판단하여 IllegalArgumentException 발생시킴
### 테스트 케이스
1. null
2. ""
3. "1"
4. "1,2"
5. "1,2:3"
6. "//;\n1;2;3"
8. "-1,2:3"
9. "가,2:3"