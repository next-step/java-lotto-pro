# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 1단계 - 학습 테스트 실습
## String 클래스에 대한 학습 테스트
### 요구사항 1
- [x] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
- [x] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

### 요구사항 2
- [x] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.

### 요구사항 3
- [x] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
- [x] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
- [x] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

## Set Collection에 대한 학습 테스트
다음과 같은 Set 데이터가 주어졌을 때 요구사항을 만족해야 한다.

```java
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
    
    // Test Case 구현
}
```

### 요구사항 1
- [x] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.

### 요구사항 2
- [x] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
- [x] 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
- [x] JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
```java
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }
```

### 요구사항 3
- [x] 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
- 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다.
- 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.

Introduction to AssertJ 문서 참고해 assertj의 다양한 활용법 익힌다.

# 2단계 - 문자열 덧셈 계산기
### 문자열 덧셈 계산기를 통한 TDD/리팩토링 실습
### 기능 요구사항
- [x] Null 또는 빈 문자열을 전달할 경우 0을 반환한다.
- [x] 숫자하나를 전달할 경우 숫자를 그대로 반환한다
- [x] 숫자 두 개가 쉼표 구분자로 입력할 경우 두 숫자를 분리하여 더한다.
- [x] 숫자 두 개가 콜론 구분자로 입력할 경우 두 숫자를 분리하여 더한다.
- [ ] 숫자 세 개 이상을 구분자와 입력할 경우 숫자를 분리하여 더한다. 
- [ ] 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- [ ] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
### 프로그래밍 요구사항
- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라.

