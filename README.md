# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 덧셈 계산기
### 기능 구현 목록
- 빈 문자열 또는 null 값을 입력할 경우 0을 반환
- 숫자 하나로 이루어진 문자열(e.g. "1")인 경우 해당 숫자 반환  
- ',:' 를 구분자로 문자열 분리
- 커스텀 구분자에 의한 문자열 분리
- 분리된 문자열 sum
- 예외 처리
- 테스트 케이스

## 로또(자동)
### 기능 구현 목록
- 사용자 Input을 위한 InputView 클래스를 생성한다.
  - readline을 하기 위한 Console 클래스
  - 사용자 input 클래스
- 상수, 메세지 관리를 위한 클래스 생성
- 로또 도메인 클래스 생성
  - 6개의 숫자를 관리하는 하나의 로또 클래스
  - 일급 컬렉션
  - 숫자 자동 생성
  - 테스트 케이스 작성
- 로또 자동 생성 클래스를 생성한다.
  - 구입 금액 만큼 로또 클래스 생성
  - 당첨 결과 확인 메서드 작성
  - 테스트 케이스 작성
- 당첨 번호 클래스를 생성한다.
  - 당첨번호 input 클래스 생성
  - 당첨 번호 input 시 1~45까지의 숫자만 입력 가능 & 6까지만 입력 가능, delimiter = , 지정
  - 테스트 케이스 작성
- 당첨 결과 클래스 생성
  - 자동 생성된 로또 번호 통계
  - 수익률 계산
- 결과에 대한 ResultView 클래스를 생성한다.
- Main 메서드 클래스 생성

### 결과 확인
LottoMain 클래스의 main 메서드를 활용한다.


## 로또 ( 2등)
### 기능 구현 목록
- [x] 보너스 볼 입력 받기
  - [x] InputView 클래스에 보너스 볼 입력 받기 추가
  - [x] 보너스볼 input 클래스 생성
- [x] Rank enum 클래스 활용
  - [x] 기존 상수로 사용했던 WINNING_AMOUNT_MAP 을 enum 클래스로 변경
- [x] Winning, ResultView 클래스에 2등에 대한 통계 추가
- [x] 사용자 입력 오류 시 다시 입력 받도록 수정


## 로또 리팩토링 + 로또 (수동)
### 기능 구현 목록


- [x] 사용자 Input 처리
  - [x] 사용자 Input을 담당하는 클래스 생성
  - [x] Scanner.readline
  - [x] 구입금액 입력 메서드
  - [x] 당첨번호 입력 메서드
  - [x] 보너스볼 입력 메서드
  - [x] 수동 구매 수 입력 메서드
  - [x] 수동 구매 로또 번호 입력 메서드

- [ ] 결과 처리
  - [x] 사용자에게 결과를 보여주는 output을 담당하는 클래스 생성
  - [x] System.out.println
  - [ ] 구매결과 메서드 (몇개 구매했는지와 로또 리스트) + 수동 구매
  - [ ] 당첨 통계 결과 메서드

- [x] 구입 금액 클래스
  - [x] 금액, 수량 -> 원시값 포장 클래스 생성
  - [x] 1000원 단위
  - [x] 1000이상
- [x] Custom Exception 클래스 생성

- [x] 로또 번호 클래스
  - [x] int 포장 클래스
  - [x] 1~45 사이의 양의 숫자인지 체크

- [x] 로또 번호 리스트 클래스 & 당첨번호 리스트 클래스
  - [x] 6개의 중복되지 않는 로또 번호 생성
  - [x] 당첨번호를 카운트 할 수 있는 메서드 생성 -> compare
  - [x] 로또 번호 클래스를 리스트로 관리하는 일급 컬렉션
  - [x] 사용자 입력 로또 클래스 생성자 -> 숫자와 ,만 입력 가능 입력 가능, 6개입력, 1~45까지의 숫자만 입력, 중복되면 안됨

- [x] 로또 리스트 클래스
  - [x] 구입 수량만큼 로또번호 리스트 생성
  - [x] 수동 구매 수량만큼 수동 로또 생성

- [ ] 보너스 볼 클래스
  - [ ] 로또 번호를 인수로 가진다.
  - [ ] 사용자 input validate 처리 -> 1~45 사이의 양의 숫자만 입력 가능.
  - [ ] 로또 번호 클래스가 보너스볼과 매치되는 지 체크

- [ ] 순위 enum 클래스
  - [ ] 순위와 순위별 금액을 enum으로 관리
  - [ ] valueOf 메서드 완성 -> 맞힌 숫자와 보너스볼 입력받아 해당하는 순위 반환
  - [ ] 결과 보여주는 testing override

- [ ] 사용자 입력 로또 번호 리스트 클래스
  - [ ] 로또 번호 리스트 클래스를 인수로 가진다.
  - [ ] 사용자 input validation. -> 1~45의 양의 숫자와 delimiter(,)만 입력 가능, 중복되지 않아야 함. 6개의 숫자만 입력 가능.

- [ ] 당첨 관리 클래스
  - [ ] 로또 리스트 클래스와 당첨 번호 클래스를 인수로 가진다.
  - [ ] 순위(Rank enum 클래스)별로 당첨갯수를 관리한다.
  - [ ] total 금액을 계산한다.
  - [ ] 수익률을 계산한다. (구입금액을 인수로)

- [ ] main method를 가지는 클래스
  - [ ] exception 시 다시 입력 받을 수 있어야 한다.
  - [ ] 전체 게임 진행 메서드

