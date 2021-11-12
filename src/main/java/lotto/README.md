# 🚀 3단계 - 로또(자동)

## 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

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
    - 참고문서: [https://google.github.io/styleguide/javaguide.html](https://google.github.io/styleguide/javaguide.html)
      또는 [https://myeonguni.tistory.com/1596](https://myeonguni.tistory.com/1596)
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 기능 목록 및 commit 로그 요구사항

- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    - 참고문서: [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

## 기능 목록 TO-DO 리스트

### STEP 3

- [X] 모델 구현
    - [X] 로또 번호 (LottoNumber) 모델
        - [X] 1~45 의 숫자를 가져야한다. 아닐시 예외발생
        - [X] 1~45 의 숫자를 랜덤하게 생성하는 유틸 추가
    - [X] 로또 번호 일급 콜렉션(LottoNumbers) 모델
        - [X] 중복되지 않는 6개의 로또 번호 생성
    - [X] 당첨 번호 일급 콜렉션(WinningLottoNumbers) 모델
        - [X] ,(콤마)를 기준으로 6개의 중복 되지 않는 입력 값으로 로또 번호 생성, 중복시 예외발생
    - [X] 로또 생성기 (LottoGenerator) 모델
        - [X] 입력된 구입 금액이 null이거나 1000원 이하일 경우 예외발
        - [X] 구입 금액으로 로또 구입 매수를 구하는 기능
        - [X] 구입 매수만큼 로또 번호를 생성하는 기능
    - [X] 로또 결과 (LottoResult) 모델
        - [X] 당첨 번호와 로또 번호를 비교해주는 기능
        - [X] 일치 결과를 통해 로또 등수를 구하는 기능
        - [X] 당첨 결과를 통해 수익률을 구하는 기능
- [X] 뷰 구현
    - [X] 입력 값 (InputView)에 대한 뷰
    - [X] 출력 값 (OutputView)에 대한 뷰
- [X] 컨트롤러 구현
    - [X] 로또 게임 진행 기능

-------------

### STEP 4

- [X] 모델 구현
    - [X] 각 모델 생성자에 부여된 로직 제거
    - [X] 당첨 번호 일급 콜렉션(WinningLottoNumbers) 모델
        - [X] 보너스 볼을 생성하는 기능
        - [X] 보너스 볼을 비교하는 기능
    - [X] 로또 결과 (LottoResult) 모델
        - [X] 보너스 볼 당첨결과를 통해 2등을 구하는 기능
    - [X] 로또 등수 (LottoRank) 모델
        - [X] 2등 값 추가
        - [X] 금액 (Money)를 사용하도록 리팩토링
    - [X] 금액 (Money) 모델
        - [X] 당첨금액 계산 기능
        - [X] 수익률 계산 기능
    - [X] 로또 (Lottos) 모델
        - [X] 생성된 로또들을 관리하는 일급 콜렉션
        - [X] 생성된 로또들을 반환하는 기능
        - [X] 생성된 로또들과 로또 번호를 비교하는 기능
        - [X] 로또 생성기 (LottoGenerator)에 대한 의존성 제거 리팩토링
- [X] 뷰 구현
    - [X] 입력 값 (InputView)에 대한 뷰
    - [X] 출력 값 (OutputView)에 대한 뷰
- [X] 컨트롤러 구현
    - [X] 로또 게임 진행 기능

-----------

### STEP 5

- [X] 모델 구현
    - [X] 로또 번호 일급 콜렉션(LottoNumbers) 모델
        - [X] Random 외부 분리
    - [X] 로또 생성기 (LottoGenerator) 모델
        - [X] Random Set으로 랜덤 로또번호 생성 기능
        - [X] 수동 로또 생성 기능
        - [X] 수동 + 자동 로또 생성 기능
    - [X] 금액 (Money) 모델
        - [X] double(float) 자료형 -> BigDecimal로 리팩토링
- [X] 뷰 구현
    - [X] 입력 값 (InputView)에 대한 뷰
        - [X] 수동 로또 갯수 입력 뷰
        - [X] 수동 로또 입력 받는 뷰
    - [X] 출력 값 (OutputView)에 대한 뷰
        - [X] 수동 로또 출력 뷰
- [X] 컨트롤러 구현
    - [X] 로또 게임 진행 기능
        - [X] 수동 로또 갯수를 입력받는 기능