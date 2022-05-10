# 2단계 - 문자열 덧셈 계산기
## 🚀 기능 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
    - 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다
    - 예: "//;\n1;2;3" => 6 (구분자는 세미콜론(;)이며, 결과 값은 6이다.)
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 구현 기능 목록

### Separator
- delimiter에 따라 text를 split하는 기능

### StringPattern
- text가 fixed, custom, nothing으로 나뉘어짐

### StringPatternRegex
- text가 fixed인지 custom인지 구별하는 Regex를 모아둠

### StringAddCalculator
- string list의 요소들을 sum하는 기능
- string pattern을 판별하는 기능
- text가 빈문자 혹은 null인지 판별하는 기능