# 설계
## 입력값 = expression
## expression = custom delimiter part + numbers part
- //로 시작하면 custom delimiter part가 있는 걸로 판단할 수 있다.

## Delimiter를 생성하는 역할
- 디폴트 Delimiter는 ",|:" 로 한다.

## 숫자를 계산하는 역할 
- 양수만 계산 가능(음수를 받은 경우 RuntimeException을 던진다.)

---

# 기능목록
- [X] 빈 문자열 또는 null 값을 입력할 경우 0을 반환
- [X] 표현식해석기 추가
- [X] 숫자 계산 기능 추가

--- 

# 리뷰 반영
- [X] 한가지 기능은 테스트 한개로 테스트(ParameterizedTest 사용)
- [X] IntStream을 통해 sum 기능 리팩토링
- [X] customDelimiter Matcher 중복 제거, 상수화 작업 
- [X] 클래스명 변경 (StringSplitter -> StringSplitter)
- [X] 메서드명 변경 (isEmptyExpression -> isEmpty)
- [X] StringSplitter를 유틸성 클래스로 변경 