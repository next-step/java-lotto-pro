# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## TODOs

### 문자열 덧셈 계산기

- `StringAddCalculator`
    - [x] `Parser`가 문자열을 분석해 `Delimiter`와 `Remainder`를 얻는다.
    - [x] `Splitter`를 사용해 `Remainder`를 `Delimiter` 기준으로 분리한다.
    - [x] 분리된 `NaturalNumber`들을 더한다.
- `Parser`
    - [x] 문자열을 분석해 `Delimiter`와 `Remainder`를 얻는다.
- `Splitter`
    - [x] `Delimiter`를 기준으로 `Remainder`를 분리하여 반환한다.
- `Delimiter`
    - [x] 문자열을 분리할 때 쓰이는 값이다.
    - [x] 기본 값은 `,` 또는 `:`이다.
    - [x] 커스텀 값을 지정할 수 있다.
- `Remainder`
    - [x] 문자열에서 `Delimiter`를 제외한 값이다.
- `NaturalNumber`
    - [x] `0`과 같거나 큰 정수이다.
    - [x] 숫자 이외의 값 또는 음수가 주어진 경우 `RuntimeException` 예외를 던진다.
    - [x] `NaturalNumber`끼리 더할 수 있다.

### 로또

- [x] `LottoGame`
    - [x] `LottoGame`의 가격은 1000원이다.
    - [x] `LottoGame`은 `LottoNumbers`를 갖는다.
    - [x] `LottoNumbers`는 `NumbersGenerator`로 생성된다.
- [x] `NumbersGenerator`
    - [x] 번호들을 생성한다.
- [x] `RandomNumbersGenerator`
    - [x] 랜덤으로 중복되지 않은 6개의 번호들을 생성한다.
- [x] `LottoNumber`
    - [x] 1부터 45까지의 숫자 중 하나이다.
- [x] `LottoNumbers`
    - [x] 중복되지 않는 오름차순의 6개 `LottoNumber`를 갖는다.
    - [x] `LottoNumbers`끼리 비교해서 맞힌 갯수를 반환할 수 있다.
- [x] `LottoRank`
    - [x] 숫자를 맞힌 수와 우승 상금 금액을 갖는다.
    - [x] 숫자를 맞힌 수로부터 순위를 알 수 있다.
    - [ ] 순위
        - [x] 1등 : 6개 일치 
        - [ ] 2등 : 5개 일치, 보너스 볼 일치
        - [x] 3등 : 5개 일치
        - [x] 4등 : 4개 일치
        - [x] 5등 : 3개 일치
        - [x] 미당첨 : 그 외
