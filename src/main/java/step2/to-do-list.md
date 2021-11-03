# 문자열 계산기
## 기능 요구 사항
* 빈 문자열 또는 null 값이 들어올 경우 0을 반환
* 숫자 하나를 문자열로 입력할 경우 숫자를 그대로 반환
  * 숫자가 아닌 경우 RuntimeException 발생
* 숫자 2개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환
  * 숫자가 아닌 경우 RuntimeException 발생
* 구분자를 컴마(,) 이외에 콜론(:)도 사용 가능하도록 하기
  * 컴마(,)와 콜론(:) 이외의 값으로 구분자가 들어오면 RuntimeException 발생
  * 숫자가 아닌 경우 RuntimeException 발생
* "//"와 "\n" 문자 사이에 커스텀 구분자를 지정가능 하도록 하기
  * 숫자가 아닌 경우 RuntimeException 발생
* 음수를 전달한 경우 RuntimeException 발생