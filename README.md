# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 2단계 - 문자열 덧셈 계산기 

### 구현할 기능 목록
- [x] 쉼표(,) 또는 콜론(:) 을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
- [x] 커스텀 구분자, 문자열 앞부분의 "//" 와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.
- [x] 빈 문자열 또는 null 을 전달하는 경우 0 반환
- [x] 숫자 하나를 입력할 경우 해당 숫자를 반환한다.

## 3단계 - 로또(자동)

### 구현할 기능 목록

#### Domain
- [x] 구매 금액
    - [x] 조건  
        - [x] 숫자만 가능
        - [x] 1000원 이상
        - [x] 1000원 단위로 입력 가능
    - [x] 구매 금액으로 살 수 있는 로또 갯수
- [x] 로또 번호 생성 기능 (자동)
    - [x] 1~45 사이의 6개의 숫자
    - [x] 중복되지 않아야 함
    - [x] 정렬이 되어야 함
- [x] 로또 티켓
    - [x] 1~45 사이의 6개의 숫자 
    - [x] 중복되지 않아야 함
    - [x] 정렬이 되어야 함
    - [x] 추첨 확인
- [x] 당첨 번호 입력
    - [x] 1~45 사이의 6개의 숫자
    - [x] 중복되지 않아야 함
    - [x] , 로 구분
- [x] 당첨 결과
    - [x] 등수별 count
    - [x] 총 수익률 (기준은 1)
        - [x] 수익률은 소수점 2자리까지만 표시 나머지는 버림 
- [x] 당첨 금액
    - [x] 총합

#### UI
- [x] 구매 금액 입력 UI
    - [x] 예외 발생시 다시 시도
- [x] 지난주 당첨번호 입력 UI
    - [x] 예외 발생시 다시 시도
- [x] 구매 내역 출력 UI
- [x] 당첨 통계 출력 UI
