# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

# 2단계 문자열 덧셈기 요구사항 정리

---

* 숫자로 작성된 문자열을 입력한다.
* 입력받은 문자열을 분리한다.
* 분리한 문자열을 숫자로 변경한다.
* 변경된 숫자의 합을 구한다.
* 입력값이 빈값이 들어올경우 0을 반환한다.
* 기본 구분자는 (,) (;)
* 커스텀 구분자는 문자열 앞에 `//` 와 `\n`사이에 위치하는 구분자를 지정 할 수 있다.
* 숫자 혹은 음수가 입렵된 경우 RuntimeException 발생해야한다.


### to-do

- [x] 입력 값을 분할하는 객체를 추가한다.
- [x] 문자열을 숫자로 변경하는 객체를 추가한다.
- [x] 양의 정수 객체를 추가한다.
- [x] 문자열 숫자를 더하는 기능을 추가한다.

---

# 3단계 로또(자동) 요구사항 정리

---

* 로또 한장 가격은 1000원 이다.
* 로또 구입 금액을 입력 받고 금액에 맞게 로또를 발급해준다.
* 로또 지난주 당첨 번호를 입력한다.
* 당첨 통계 합산하여 보여준다.
* 총 수익률을 계산하여 준다.


### to-do

- [x] 금액을 담당하는 값 객체를 추가한다.
  - [x] 원 기준으로 계산 메소드를 추가한다.
- [X] 로또 발급기를 객체를 추가한다.
  - [X] 구입 금액에 따라 로또를 발급해준다.
- [X] 로또 객체를 추가한다.
  - [X] 로또 는 로또 번호를 6개를 포함한다.
  - [X] 로또 한개의 가격은 1000원 이다.
  - [X] 로또 번호 6개를 자동을 선택한다.
- [X] 구입한 전체 로또 객체를 추가한다.
  - [X] 해당 회차의 구입한 모든 로또를 포함한다.  
- [x] 로또 번호 객체를 추가한다.
  - [x] 로또 번호는 1 ~ 45 이다.
- [X] 전체 로또 번호 객체를 추가한다.
  - [X] 로또 번호들 객체는 랜덤으로 6개를 뽑을 수 있다.
  - [X] 로또 번호들 객체는 비교하여 같은 번호 갯수를 반환한다.
- [X] 로또 회차 객체를 추가한다.
  - [X] 회차별 당첨 번호가 있다.
  - [X] 구입한 전체 로또를 포함한다.
  - [X] 회차 당첨통계 정보를 포함한다.
- [X] 로또 당첨 판별기 객체를 추가한다.
  - [X] 로또 당첨 규칙 및 당첨금이 있다.
  - [X] 당첨번호와 발급 사용자의 로또 번호를 비교하여 같은 갯수를 찾는다.
- [X] 당첨총계 객체를 추가한다.
  - [X] 수익률 계산을 한다.
- [X] UI 로직을 담당하는 InputView, ResultView 를 추가한다.


---

# 4단계 로또(2등) 요구사항 정리

* 2등 추첨을 위해 추가번로를 추첨한다.
* 당첨 통계에도 2등을 추가한다.

### to-do

- [X] 보너스 추가 번호를 추가한다.
- [] 당첨번호 입력시 보너스 번호 입력을 추가한다.
- [] 당첨 결과에 2등을 수정한다.
- [ ] 통계 출력시 2등을 수정한다.


