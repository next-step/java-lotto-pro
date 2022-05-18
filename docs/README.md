학습 테스트 실습
===

# 실습 환경 구축
```
git clone -b choi-ys --single-branch https://github.com/choi-ys/java-lotto-pro
git checkout -b step1
```
---

# step1 학습 테스트 실습
- [Introduction to AssertJ](https://www.baeldung.com/introduction-to-assertj) 문서를 참고해 assertj의 다양한 활용법 익힌다.

## String Class에 대한 학습 테스트

> ### split()
> #### 요구사항
> - "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
> - "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
> #### 구현 기능 목록
> | 구분자를 기준으로 주어진 문자열을 분리하여 반환된 배열의 원소 포함/일치 여부 검증
>  - [x] "1, 2"를 ','를 기준으로 split 하여 분리되는 배열의 원소 검증 TC 작성
>  - [x] "1"을 ','를 기준으로 split 하여 분리되는 배열의 원소 검증 TC 작성
> #### 힌트
> - assertj의 contains()를 활용하여 반환된 배열의 원소 포함 여부를 검증한다.
> - assertj의 containsExactly()를 활용하여 반횐된 배열의 전체 원소 일치 여부를 검증한다.

> ### substring()
> #### 요구사항
> - "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
> #### 구현 기능 목록
> | 문자열의 index를 기준으로 자른 문자열 검증
> - [x] "(1,2)" 문자열의 index 범위 내에서, 시작 index와 종료 index로 substring 하는 TC 작성
> - [x] 유효하지 못한 substring 범위인 경우 발생하는 예외 검증 TC 작성

> ### chatAt()
> #### 요구사항
> - "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
> - String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 IndexOutOfBoundsException 발생하는 부분에 대한 학습 테스트를 구현한다.
> - JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
> #### 구현 기능 목록
> - [x] "abc" 문자열의 index 범위 내에서 문자를 반환하는 TC 작성
> - [x] 유효하지 못한 chatAt() 범위인 경우 발생하는 예외 검증 TC 작성
> #### 힌트
> - [AssertJ Exception Assertions](https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#exception-assertion) 문서 참고
---

## Set Collection에 대한 학습 테스트
- 다음과 같은 Set 데이터가 주어졌을 때 요구사항을 만족해야 한다.
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
> ### size()
> #### 요구사항
> - Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
> #### 구현 기능 목록
> - [x] set에 포함된 원소의 개수를 검증하는 TC 작성

> ### contains()
> #### 요구사항
> - Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
> - 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
> - JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
> #### 구현 기능 목록
> - [x] set에 포함된 원소의 포함/미포함 여부를 검증하는 TC 작성
> #### 힌트
> - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

> ### @ParameterizedTest @CsvSource
> #### 요구사항
> #### 구현 기능 목록
> - [ ]
> #### 힌트
> - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5) 문서에서 @CsvSource를 활용한다.
---
