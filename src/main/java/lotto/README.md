# 3단계 - 로또(자동)

## 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 구입 금액에 해당하는 수량의 만큼의 로또 번호 생성해야 한다.
- 당천 번호를 제공해야 한다.
- 당첨 통계를 제공해야 한다.

## 프로그래밍 요구사항

- **모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외**
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  -
  참고문서: [https://google.github.io/styleguide/javaguide.html](https://google.github.io/styleguide/javaguide.html)
  또는 [https://myeonguni.tistory.com/1596](https://myeonguni.tistory.com/1596)
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 기능 목록 및 commit 로그 요구사항

- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
  -
  참고문서: [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

## 기능 목록 TO-DO 리스트

- [X] 모델 구현
    - [X] 카운터 (Counter) 모델
        - [X] 사용자로부터 금액을 입력받고, 금액에 맞는 로또를 반환해주는 기능.
        - [X] 사용자가 입력한 금액에 대한 validation 하는 기능.
    - [X] 로또 (Lotto) 모델
        - [X] 6 자리의 숫자 리스트를 가지고 있는 로또 모델.
        - [X] 로또 생성 유틸리티 (LottoGenerator)
            - [X] 1~45 의 범위에서 랜덤한 6 개의 숫자를 생성.
    - [X] 로또리스트 (LottoList) 일급 컬랙션 모델.
    - [X] 당첨 로또 (Winning Lotto) 모델.
    - [X] 로또 결과 (LottoResult) 모델.
        - [X] 로또 등수별 결과 구하는 기능.
        - [X] 로또 당첨 결과를 통해 수익률 구하는 기능.

- [X] 뷰 구현
    - [X] 입력 값 (InputView)에 대한 뷰
    - [X] 출력 값 (OutputView)에 대한 뷰

- [X] 컨트롤러 구현
    - [X] 로또 게임 진행 기능

--- 

# step4 - 로또 (2등)

## 기능 목록 TO-DO 리스트

- [X] 모델 구현
    - [X] 당첨 로또 (Winning Lotto) 모델.
        - [X] 보너스 볼을 생성하는 기능
        - [X] 보너스 볼을 비교하는 기능
    - [X] 로또 결과 (LottoResult) 모델
        - [X] 보너스 볼 당첨결과를 통해 2등을 구하는 기능
    - [X] 로또 등수 (RankCode) 모델
        - [X] 2등 값 추가
- [X] 뷰 구현
    - [X] 입력 값 (InputView)에 대한 뷰
    - [X] 출력 값 (OutputView)에 대한 뷰
- [X] 컨트롤러 구현
    - [X] 로또 게임 진행 기능

### STEP 5

- [ ] 모델 구현
    - [ ] 수동으로 생성할 수 있는 로또 추가
    - [ ] 수동으로 생성한 로또와 함께 LottoResult 제공
- [ ] 뷰 구현
- [ ] 컨트롤러 구현
    