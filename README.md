# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 목록
- [x] LottoNumber는 1 이상 45 이하이다.
  - [x] 1이상 45이하가 아니라면 예외를 던진다.
- [ ] LottoNumbers는 6개의 LottoNumber로 구성된다.
- [ ] LottoNumberGenerator는 6개의 숫자를 만든다.
- [ ] LottoMachine은 사용자에게 금액을 입력받는다.
  - [ ] 1~9를 제외한 문자가 입려되면 예외를 던진다.
- [ ] LottoCalculator는 금액에 따른 갯수를 계산한다.
- [ ] LottoStatics는 금액 별 당첨 갯수를 계산한다.
  - [ ] 총 수익률을 계산한다.