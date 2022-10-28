# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## step 2. 문자열 덧셈 계산기를 통한 TDD/리팩토링 실습
- [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환
- [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환(구분자는 컴마(,) 또는 콜론(:)을 사용 가)
- [x] “//”와 “\n” 문자 사이에 커스텀 구분자를 지정 가능(`//#\n`시 `#`이 구분자)
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외 반환 

## step 3. 로또(자동)
### UI
- [X] 로또 구입금액 입력(`구입금액을 입력해 주세요.`, `14000`)
- [X] 구입 갯수, 로또 번호 출력(`14개를 구매했습니다.`, `[8, 21, 23, 41, 42, 43]...`)
- [X] 지난 주 당첨 번호 입력(`지난 주 당첨 번호를 입력해 주세요.`, `1, 2, 3, 4, 5, 6`)
- [X] 당첨 통계 출력 (`3개 일치, 4개 일치, 5개 일치, 6개 일치`)

### DOMAIN
- 로또 컬랙션 (Lottos)
  - [X] 입력받은 구입 금액으로 로또 컬랙션 객체 생성
  - [X] 입력받은 구입 금액 숫자가 아닐경우 IllegalArgumentException
  - [X] 로또 갯수 반환
  - [X] 각 로또 번호 반환
- 로또 (Lotto)
  - [ ] 입력받은 6자리 숫자 리스트로 로또 객체 생성
  - [ ] 로또 번호 반환 
- 로또 번호 (LottoNumber)
  - [X] 1~45 번호 범위 제한
- 지난 주 당첨 번호 (WinNumbers)
  - [ ] 입력받은 6자리 숫자 리스트로 지난 주 당첨 번호 객체 생성
- 당첨 통계 (WinStatistics)
  - [ ] 로또 컬랙션(Lottos), 지난 주 당첨 번호(WinNumbers) 객체를 입력 받아 당첨 통계 객체 생성
  - [ ] 각 3,4,5개 일치 결과 반환 (MatchResult)
  - [ ] 총 수익률 결과 반환
- 난수 생성기 (RandomNumbersGenerator)
  - [ ] min~max 범위 n자리 난수 생성
