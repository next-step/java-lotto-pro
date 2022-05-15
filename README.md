# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.




---
### 1단계 - 학습테스트 실습
- **String 클래스에 대한 학습 테스트**
    * 요구사항 1
        - [X] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        - [X] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
            - _assertj의 contains()와 containsExactly() 활용_

    * 요구사항 2
        - [X] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.

    * 요구사항 3
        - [X] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
            - String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
            - JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.


- **Set Collection에 대한 학습 테스트**
    * 요구사항 1
        - [X] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.

    * 요구사항 2
        - [X] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
            * JUnit의 ParameterizedTest를 활용해 중복 코드를 제거 해본다.

    * 요구사항 3
        - [X] contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
            * 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.
---  

### 2단계 - 문자열 덧셈 계산기를 통한 TDD/리팩토링 실습
* 기능 요구사항
    - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
      > ex) “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
        - [X] 문자열이 빈문자열 일 경우 0을 반환 한다.
        - [X] 구분자로 분리한 숫자의 합을 구한다.
        - [X] 구분자는 "," 또는 (:)을 구분자로 가진다.

    - 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
      > ex) "//;\n1;2;3"   
      구분자 : ";"  
      합계 :  6
        - [X] “//”와 “\n” 사이의 문자열로 구분자를 구해 합을 구한다.

    - 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
      > ex) -1,2,3 => -1가 음수 임으로 RuntimeException
        - [X] 문자열이 숫자가 아닐경우 RuntimeException 발생시킨다.
        - [X] 문자열이 음수 일 경우 RuntimeException 발생시킨다.

* 프로그램 요구 사항
    - indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
    - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
    - 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    - method가 한 가지 일만 하도록 최대한 작게 만들어라.
    - else를 사용하지 마라.


--- 

### 3단계 - 로또(자동)

**기능 요구 사항**
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

* 출력 화면
  ![로또(자동)출력이미지.png](로또(자동)출력이미지.png)

* **기능목록**
    - **도메인**
        - 로또
            - [X] 로또 번호가 맞는지 체크 하는 기능
              >  3개 일치 5000원 보상  
              4개 일치 50000원 보상  
              5개 일치 150000원 보상  
              6개 일치 2000000000원 보상
            - [X] 로또 숫자를 랜덤으로 선택하는 기능

        - 로또 숫자
            - [X] 로또 숫자는 로또 번호는 1 ~ 45사이의 숫자만 가질 수 있다.
            - [X] 6개의 숫자로 이루어져 있다.
            - [X] 중복된 숫자가 없어야 한다
            - [X] 로또숫자는 정렬 되어 있다.

        - 유저
            - [X] 유저가 금액에 따라 로또를 구입하는 기능
                - 로또 1장의 가격은 1000원이다.
                - 유저가 나누어 떨어지는 만큼 구입한다.  
                  예시 : 14500 => 14장 구매

        - 통계
            - [X] 갯수 별 당첨 수
            - [X] 수익률 (당첨금 / 구매 금액)을 구한다

        - 화면
            - [X] 플레이어가 구매한 로또 수 만큼 로또번호 출력 기능
            - [X] 당첨 번호를 입력하는 기능
            - [X] 당첨별 통계를 출력하는 기능
                - 당첨별 현황
                - 수익률





**프로그래밍 요구 사항**
* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
    * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
    * 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    * 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
    * else 예약어를 쓰지 않는다.
    * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.












## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)