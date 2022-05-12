# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 - 학습 테스트 실습
* String 클래스 학습
  * split()
  * contains()
  * containsExactly()
  * substring()
  * charAt()
  * StringIndexOutOfBoundsException
  * Junit @DisplayName 활용
    

* Set Collection 학습
  * size()
  * contains()
  * Junit ParameterizedTest 활용

## 2단계 - 문자열 덧셈 계산기
* [X] TDD/리팩토링 실습
  * [X] 프로그래밍 요구사항
    * [X] intent depth 1단계
    * [X] 메소드 라인 10 이하로 작성
      * [X] 메소드가 한 가지 일만 하도록 처리
    * [X] else 사용 금지
  * [X] 기능 요구사항
    * [X] 빈문자열, null일 경우 0 반환
      * (예 : “” => 0, null => 0)
    * [X] 숫자하나를 문자열로 입력받으면 그대로 반환
      * (예 : “1”)
    * [X] 숫자 두 개를 컴마(,) 또는 콜론(:)을 구분자로 입력받으면 두 숫자 합 반환'
      * (예 : “1,2:3” => 6)
    * [X] "//" 와 "\n" 문자 사이 커스텀 구분자 
      * (예 : “//;\n1;2;3” => 6)
    * [X] 예외처리
      * [X] 음수
      * [X] 숫자 외의 문자
