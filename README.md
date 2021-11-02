# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## TODOs

- `StringAdditionCalculator`
    - [ ] 문자열로부터 `Delimiter`와 `Remainder`를 추출한다.
    - [ ] `Splitter`를 사용해 `Remainder`를 `Delimiter` 기준으로 분리한다.
    - [ ] 분리된 `NaturalNumber`들을 더한다.
- `Splitter`
    - [ ] `Delimiter`를 기준으로 분리한 `NaturalNumber`들을 반환한다.
- `Delimiter`
    - [ ] 문자열을 분리할 때 쓰이는 값이다.
    - [ ] 기본 값은 `,` 또는 `:`이다.
    - [ ] 커스텀 값을 지정할 수 있다.
- `NaturalNumber`
    - [ ] `0`과 같거나 큰 정수이다.
    - [ ] 숫자 이외의 값 또는 음수가 주어진 경우 `RuntimeException` 예외를 던진다.
    - [ ] `NaturalNumber`끼리 더할 수 있다.
