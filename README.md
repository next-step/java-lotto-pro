# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 요구사항
### String 클래스에 대한 학습 테스트
#### 요구사항 1
* "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 테스트 구현
- 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증
* "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 테스트 구현
- 배열로 반환하는 값의 경우 asssertj의 containsExactly를 활용해 반환 값이 맞는지 검증
#### 요구사항 2
* "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환
#### 요구사항 3
* "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 테스트 구현
* String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 테스트를 구현

### Set Collection에 대한 학습 테스트
#### 요구사항 1
* Set의 size() 메소드를 활용해 Set의 크기를 확인하는 테스트 구현
#### 요구사항 2
* Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 테스트 구현
이 때 JUnit의 ParameterizedTest를 활용히야 중복 코드를 제거하도록 구현
#### 요구사항 3
* 요구사항 2 에 추가하여 입력 값에 따라 해당 값이 존재하는지를 판단하는 테스트 구현