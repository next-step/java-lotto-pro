# 로또

## 기능 요구사항

- 입력
    * [x] 구입 금액을 입력받는다
        - 숫자로만 입력을 받고, 그 외의 값을 입력시 에러를 발생한다.
        - 에러 발생 시, 재입력을 받을 수 있도록 한다.

    * [x] 당첨 번호를 입력받는다.
        - 숫자 6자리를 ,로 구분하여 입력받는다.
            - , 로 구분이 안될 시 에러
            - 숫자가 아닌 것이 있을 경우 에러
            - 6자리가 넘을 경우 에러
            - 에러 발생 시 재입력을 받을 수 있도록 한다.
    * [x] 보너스 볼을 입력 받는다. (당첨 로또 생성)
        * [x] 숫자 1자리를 입력받는다.
            - 당첨 번호와 중복일 경우 에러
            - 숫자가 아닐 경우 에러
            - 1 ~ 45 사이의 숫자가 아닌 경우 에러
    * [x] 수동으로 구매할 로또의 수를 입력 받는다.
        * 숫자 1자리 입력 받는다
        * 숫자가 아닐 경우 에러
    * [x] 수동으로 구매할 로또 번호를 입력 받는다.
        * 숫자 6자리를 입력 받는다
        * 숫자가 아닐 경우 에러
        * 중복이 있는 경우 에러
- 출력
    * [x] 구입한 로또의 번호를 출력한다.
        - 번호는 오름차순으로 출력한다.
    * [x] 당첨 통계를 출력한다. - 구매한 로또와 당첨 번호를 비교하여 통계를 수집한다. - 로또 번호가 3개가 일치하면 5000원, 4개가 일치하면 50000원, 5개가
      일치하면 1500000원, 6개가 일치하면 2000000000을 받는다
    * [x] 2등은 로또 번호 5개와 보너스 볼이 일치한 경우 30000000원
        - 전체 로또 구매를 돌면서 일치된 경우에 대한 카운트를 한다.
        - 3개 일치 부터 차례대로 모두 출력을 한다. * [x]총 수익률을 계산하여 출력한다. - 총 수익률은 총 당첨금액을 구입 금액으로 나눈다. - 소숫점 이하
          2자리까지 수익률을 보여준다.
- 로또
    * [x] 6개의 랜덤 숫자를 가진다
        - 숫자는 중복이 없고, 1부터 45까지의 숫자를 갖는다
        - 로또는 자동으로 번호를 생성한다.
            * [x] 수동으로 구매한 수를 제외한 만큼을 자동으로 생성한다

            - 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
            - Collections.sort() 메소드를 활용해 정렬 가능하다.
            - ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

