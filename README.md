# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Step 1

### String

* 요구사항 1
```
"1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
"1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
```
  
* 요구사항 2
```
"(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
```
  
* 요구사항 3
```
"abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
```
  
### Set

* 요구사항 1
```
Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
```
  
* 요구사항 2
```
Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
```


## Step 2 

*  요구사항

*[x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
*[x] 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
*[x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## Step 3

* 기능 명세서

- [x] 화면 출력 뷰어 추가 
  - [x] 초기 화면 출력 뷰어 추가
  - [x] 결과 화면 출력 뷰어 추가
- [x] 랜덤 로또 생성기 추가
  - [x] 고유한 값을 가진 6개의 1~45 숫자 생성
- [x] 로또 머신 추가 
  - [x] 특정 금액에 따라 로또 구매 기능 추가 
  - [x] 랜덤 로또 입력 받기 추가
    - [x] 오름차순으로 정렬
  - [x] 당첨번호 6 자리 숫자 리스트 받기 추가  
    - [x] 고유한 수 또는 1~45의 수가 들어오지않으면 에러 발생
    - [x] 각 일치하는 갯수만큼 리스트결과값 생성
  - [x] n 번일치하는 수를 입력받을때 일치하는 갯수 리턴
  - [x] 수익률 계산하는 메소드 추가 
    