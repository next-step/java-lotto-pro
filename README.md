## 2단계 - 문자열 덧셈 계산기

### 기능 요구사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이
  값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 프로그래밍 요구사항

- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라.

### 기능 목록

1. 입력: 문자열을 입력받는다
2. 검증: 입력값을 검증한다. 숫자 이외의 값 또는 음수일 경우 RuntimeException을 발생하고 종료한다.
3. 구분자 파악: 입력값의 구분자를 파악한다. 콤마 or 콜론 or 커스텀
4. 숫자 파싱: 구분자를 통해 문자열을 파싱하여, 숫자를 추출한다.
5. 파싱한 숫자 검증: 숫자 이외의 값 또는 음수 체크
6. 연산: 숫자들을 모두 합 연산한다.

### 도메인 설계

기능(행위)를 묶어서 객체들을 생성

1. 입력기
    1. 사용자로부터 입력을 받는다.
2. Validator
    1. 사용자 입력값 검증
    2. 파싱한 숫자 및 구분자 검증
    3. 유효하지 않다면 RuntimeException 발생
3. Parser
    1. 구분자 파싱
    2. 구분자를 통한 숫자 파싱
4. 덧셈기 Adder
    1. 양의 정수들을 모두 합하고 결과값을 반환
5. 문자열 덧셈 계산기
    1. 사용자로부터 문자열을 입력받아, 파싱하여 모두 합친 값을 반환
    2. 입력기, Validator, Parser, Adder 객체를 활용하여 기능 수행

# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 참고

### TDD 과정

- 실패하는 테스트를 구현한다.
- 테스트가 성공하도록 프로덕션 코드를 구현한다.
- 프로덕션 코드와 테스트 코드를 리팩토링한다.

### TDD 원칙

- 원칙 1 - 실패하는 단위 테스트를 작성할 때까지 프로덕션 코드(production code)를 작성하지 않는다.
- 원칙 2 - 컴파일은 실패하지 않으면서 실행이 실패하는 정도로만 단위 테스트를 작성한다.
- 원칙 3 - 현재 실패하는 테스트를 통과할 정도로만 실제 코드를 작성한다.

### 프로그래밍 요구사항

- 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
- 규칙 2: else 예약어를 쓰지 않는다.
- 규칙 3: 모든 원시값과 문자열을 포장한다.
- 규칙 8: 일급 콜렉션을 쓴다.
