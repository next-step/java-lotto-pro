# 프로그래밍 요구사항 
1. indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
2. 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
3. else를 사요하지 마라

## Step 2. 문자열 덧셈 계산기

### 2-1. 요구사항 정의서
1. `쉼표(,) 또는 콜론(:)`을 구분자로 가지는 문자열을 전달하는 경우
   + 구분자를 기준으로 분리한 각 숫자의 합을 반환
   

2. `구분자(쉼표, 콜론),커스텀 구분자`를 지정할 수 있다. 
   + 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.

   
3. 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 
   + `RuntimeException 예외를 throw`한다.

### 2-2 기능 정의서 
1. StringValidation
   + 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
   + 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)

2. DefaultSpliter
   + 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)   
   + 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)

3. PatternSpliter
   + “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)   
 


### 클래스 명세서
| 클래스명 | 용도 | 
|:---:|:---:| 
|StringValidation | 빈 문자열 또는 null 값을 입력할 경우 0을 반환, 음수 입력시 `RuntimeException`|
|SpliterManager| Spliter를 구현한 클래스를 리턴|
|PatternSpliter| 정규식을 통한 split|
|PatternSpliter| 콤마(,) 또는 콜론(:)으로 split|
|StringCalculator| 분리된 문자열을 합을구하는 클래스|
   