# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 요구사항
구입금액 (`Money`)
`Money`는 `price`를 가진다
`Money`는 음수가 될 수 없다
`Money`는 생성할 수 있는 로또의 개수를 반환한다

로또 (`Lotto`)
`Lotto`는 6개의 `LottoNumber`를 가진다
`Lotto`는 `LottoNumber`는 중복되지 않는다
`Lotto`는 `Lotto` 와 비교하여 당첨번호 개수를 반환한다
`Lotto`는 6자리의 숫자 문자열을 받아 생성한다
`Lotto`는 보너스 숫자를 가지는지 확인한다

로또들 (`Lottos`)
`Lottos`는 `RandomNumbers`를 가진다
`Lottos`는 로또 개수(`count`)를 받아 로또들을 반환한다
`Lottos`는 당첨 로또와 비교하여 `Rank`들을 반환한다

로또 번호 (`LottoNumber`)
`LottoNumber`는 `number`를 가진다
`LottoNumber`는 1부터 45까지의 숫자를 가진다

랭크(`Rank`)
`Rank`는 당첨번호 개수 `count`를 가진다
`Rank`는 당첨번호 금액 `price`를 가진다
`Rank`는 당첨번호 개수와 보너스 번호를 받아 `Rank`를 반환한다

결과(`Result`)
`Result`는 `Rank`들을 가진다
`Result`는 `Purchase`를 가진다
`Result`는 수익률((당첨번호 금액 * 당첨된 로또 개수)의 합 / 구입금액 )을 계산할 수 있다

랜덤 숫자(`RandomNumber`)
`RandomNumber`는 1에서 45까지 랜덤한 숫자들을 생성한다

랜덤 숫자들(`RandomNumbers`)
`RandomNumbers`는 1에서 45까지 랜덤한 숫자들을 생성한다
`RandomNumbers`는 6자리의 숫자를 생성한다
`RandomNumbers`는 숫자들은 중복되지 않는다

보너스(`Bonus`)
`Bonus`는 보너스 숫자를 가진다

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)