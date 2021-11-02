# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## 1단계-학습 테스트 실습
### 1. String 클래스에 대한 학습 테스트
#### 요구사항
- JUnit의 @DisplayName을통해 테스트의 의도가 드러나게된다.
- "1,2"을 `,`로 split했을 때 1과 2로 분리된다.
- "1"을 `,`로 split했을 때 1만 포함된 배열이 반환된다.
- "(1,2)"가 주어졌을 때 String의 substring()메소드를 통해 ()가 제거된 "1,2"가 반환된다.
- "abc"값이 주어졌을 때 String의 chatAt()메소드를 통해 특정 문자를 가져오게된다.
- 임의 문자열에대해 String의 chatAt()메소드를 통해 특정 위치의 문자를 가져올 때 위치를 벗어나면 StringIndexOutOfBoundsException이 발생된다.
### 2. Set Collection에 대한 학습 테스트
#### 테스트 데이터
``` java
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
}
```
위와 같은 Set 데이터가 주어진다.
#### 요구사항
- Set의 size()메소드를 통해 Set의 크기가 확인된다.
- Set의 Contains()메소드를 활용해 1,2,3의 값이 존재하는지 확인된다.
  - JUnit의 ParameterizedTest를 통해 테스트내 중복 코드가 제거된다.
- 1, 2, 3값은 Contains()메소드의 결과값이 true, 4, 5값은 Contains()메소드 값이 false가 반환된다.
  - 테스트는 1개의 Test Case로 구현된다.

## 2단계-문자열 덧셈 계산기
### 요구사항
- 문자열 덧셈 계산기는 ,또는 :를 기본구분자로 사용된다.
- 커스텀 구분자는 기본구분자 이외의 값을 사용할 수 있으며 문자열 앞부분의 "//"와 "\n" 사이에 위치된다.
- 문자열 덧셈 계산기는 구분자를 혼합하여 사용할 수 있으며 문자열이 구분자를 가질경우 구분자를 기준으로 분리한 각 숫자의 합이 반환된다.
- 예외는 문자열 계산기에 숫자 이외의 값 또는 음수가 전달될 경우 RuntimeException를 발생된다.
