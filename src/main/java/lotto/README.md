## 3단계 - 로또(자동)

-- --

### 기능 요구사항

* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다
* 로또 1장의 가격은 1000원 이다
* **힌트**
    * 로또 자동 생성은 Collections.shuffle() 메서드를 활용한다
    * Collections.sort() 메서드로 정렬이 가능하다
    * ArrayList의 contains() 메서드를 활용하면 어떤 값이 존재하는지 판단할 수 있다
* 입력 값
    * 입력 값은 InputView로 구현한다
    * 구매 금액
        * 구매 금액은 숫자여야 한다
    * 당첨 번호
        * 당첨 번호는 6자리 숫자이며 쉼표(,)로 구분해야 한다
        * 중복 된 값이 입력되어선 안된다
* 출력 값
* 출력 값은 ResultView로 구현한다
* 수익률은 소숫점 둘째 자리까지 표시한다
* UI 로직은 정적인 메서드를 활용한다

### 프로그래밍 요구 사항

* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다 (UI 로직 제외)
* indent depth는 1단계 유지
* UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 메소드 크기 15라인 이내
    * 하나의 메소드가 한 가지 일을 하도록 최대한 작게 만들기
* else 사용 금지
* 자바 컨베션을 지키며 프로그래밍한다
    * [참고문서](https://google.github.io/styleguide/javaguide.html)
    * [참고문서 한글](https://myeonguni.tistory.com/1596)

### 기능 목록 및 commit 로그 요구사항

* 기능 구현 전에 README에 기능 목록을 먼저 작성한다
* [commit convention](AngularJS Commit Message Conventions) 을 지키며 기능 목록 단위로 commit 한다

```
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain) 
```

### 기능 목록

* **구매자**
    * 현재는 고려하지 않는다
* **금액**
    * 속성
        * 금액 값
    * 역할
        * 금액 마이너스
        * 더 큰 금액 체크
* **로또 번호 생성기**
    * 역할 (static)
        * 중복되지 않은 난수 목록 생성
* **로또 번호 목록**
    * 속성
        * 번호 목록
    * 역할
        * 당첨 번호 일치 카운트 제공
* **로또**
    * 속성
        * 로또 번호 목록
    * 역할
        * 당첨 결과 제공
* **로또 발급기**
    * 역할
        * 로또 목록 생성
        * 당첨 번호 입력 및 생성
* **로또 상점**
    * 역할
        * 구매 금액 입력
        * 당첨 번호 입력
* **당첨 결과**
    * 상수
        * 꽝
        * 1개 일치
        * 2개 일치
        * 3개 일치
        * 4개 일치
        * 5개 일치
        * 6개 일치
            * 속성
                * 일치 카운트
    * 역할 (static)
        * 일치하는 카운트로 상수 값을 반환
* **당첨 결과 목록**
    * 속성
        * 당첨 결과 목록
    * 역할
        * 당첨 결과 목록 일치 카운트 제공
        * 수익률 제공
* **입력 결과(view)**
    * 역할 (static)
        * 로또를 인자로 받아서 로또 번호를 출력
* **당첨 통계(view)**
    * 역할 (static)
        * 당첨 결과 목록을 인자로 받아서 당첨 통계를 출력