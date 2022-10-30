# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 - 학습 테스트 실습
### 기능 목록
* String 클래스에 대한 학습 테스트
  * 요구사항 1 - split() 사용하기
    * [x] "1,2"을 ,를 구분자로 하여 잘 분리되는지 확인
      * assertj의 contains() 사용
      * assertj의 containsExactly() 사용
    * [x] "1"과 같이 ,가 없을 때 사이즈 1개의 배열 반환 확인
      * assertj의 containsExactly() 사용
      * assertj의 containsOnly() 사용
  * 요구사항 2 - substring() 사용하기
    * [x] "(1,2)"가 주어졌을 때 ()를 제거하고 "1,2"만 반환 확인
      * assertj의 isEqualTo() 사용
  * 요구사항 3 - charAt() 사용하기
    * [x] "abc"가 주어졌을 때 charAt()을 통해 특정 위치 문자 확인
      * assertj의 isEqualTo() 사용
    * [x] charAt() 사용 시, 문자열 길이를 벗어난 위치를 가져오고자 할 때 StringIndexOutOfBoundsException 발생 확인
      * assertThatThrownBy() 사용
      * assertThatExceptionOfType() 사용
    * [x] JUnit의 @DisplayName 활용해 테스트 메소드 의도 보일 것
* Set Collection 학습 테스트
  * [x] Set 데이터 세팅
  * 요구사항 1 - Set의 size() 사용하기
    * [x] Set 사이즈 확인
  * 요구사항 2 - Set의 contains() 사용하기
    * [x] 주어진 Set 내에 1, 2, 3의 값 존재 여부 확인
      * JUnit의 ParameterizedTest 및 ValueSource 사용
  * 요구사항 3 - Set의 contains() 사용하기
    * [x] 주어진 Set 내에 없는 값이면 false, 존재하는 값이면 true 반환 확인
      * JUnit의 ParameterizedTest 및 CsvSource 사용

## 2단계 - 문자열 덧셈 계산기
### 기능 목록
* [x] 기본 구분자로 문자열 split
  * 기본 구분자: 쉼표(,) 또는 콜론(:)
* [x] 커스텀 구분자로 문자열 split
  * 커스텀 구분자: 문자열 **앞부분**의 "//"와 "\n" 사이 문자를 커스텀 구분자로 사용
  ```java
  // java.util.regex 패키지의 Matcher, Pattern import
  Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
  if (m.find()) {
    String customDelimiter = m.group(1);
    String[] tokens= m.group(2).split(customDelimiter);
    // 덧셈 구현
  }
  ```
* [x] split한 숫자들 덧셈
  * split한 문자열을 숫자로 변환하여 덧셈
  ```java
  int number = Integer.parseInt(text);
  ```
  * [x] 덧셈할 문자열이 숫자 이외의 값 또는 음수일 경우 RuntimeException 예외 throw
    * [x] 원시값 포장 및 collection 포장을 위해 PositiveNumber, PositiveNumbers 구현
    * 기본적으로 parseInt 할 때에 숫자가 아니면 NumberFormatException이 발생하여, 에러 발생 시, 메시지만 변경함
    * 음수값은 잘못된 인자가 들어온 걸로 판단하여 IllegalArgumentException 발생시킴
  * [x] 덧셈 시, 큰 int값들을 더해 결과값이 음수가 된 경우(예: 2147483645 + 123) 정상이 아니라고 판단하여, IllegalArgumentException 발생시킴
### 테스트 케이스
1. [x] null
2. [x] ""
3. [x] "1"
4. [x] "1,2"
5. [x] "1,2:3"
6. [x] "//;\n1;2;3"
7. [x] "-1,2:3"
8. [x] "가,2:3"

## 3단계 - 로또(자동)
### 기능 목록
* [x] 로또 구입 금액 입력
  * [x] 1000원 이상 입력해야 로또 구매가 가능하므로, 이보다 작은 수 입력 시, 에러 발생 후 재시도하도록 구현
* [x] 입력 값에 따른 발급 가능한 최대 로또 개수 반환
  * 입력 값 / 1000
  * [x] 돈과 관련된 기능을 나타낼 객체 생성
    * 입력값에 따른 최대 로또 개수
    * 로또 구입에 사용한 비용과 수입금에 따른 수익률 확인
* [x] 로또 자동 발급
  * [x] 1~45 사이의 서로 다른 6개의 숫자 랜덤하게 반환
    * `Collections.shuffle()` 메소드 활용
  * [x] 로또 번호들은 오름차순으로 정렬 -> 오름차순으로 출력하기 위함
    * `Collections.sort()` 메소드 활용
    * `List<LottoNumber>`를 sort하기 위해 `compareTo()` 메소드 overriding
* [x] 당첨 번호 입력
  * [x] 당첨 번호 입력 시, 중복된 값 validation 필요
    * 관련 지정된 요구사항이 없으므로, 임의로 try ~ catch 통해 다시 입력 받도록 구현
* [x] 구매한 로또 번호와 당첨 번호 간 일치 개수 확인
  ```java
  3개 일치 (5000원)
  4개 일치 (50000원)
  5개 일치 (1500000원)
  6개 일치 (2000000000원)
  ```
* 당첨 개수에 따른 수익금 확인
  * ENUM으로 복권 일치 개수와 그에 따른 수익금 매핑
  ```java   
  public enum LottoPrize {
    NO_PRIZE(0, 0, "0~2개 일치 (0원)"),
    FOURTH(3, 5000, "3개 일치 (5000원)"),
    THIRD(4, 50000, "4개 일치 (50000원)"),
    SECOND(5, 1500000, "5개 일치 (1500000원)"),
    FIRST(6, 2000000000, "6개 일치 (2000000000원)")
    ;
  
    private final int matchCount;
    private final int lottoPrizeMoney;
    private final String lottoPrizeMessage;
  
    LottoPrize(int matchCount, int lottoPrizeMoney, String lottoPrizeMessage) {
      this.matchCount = matchCount;
      this.lottoPrizeMoney = lottoPrizeMoney;
      this.lottoPrizeMessage = lottoPrizeMessage;
    }

    public static LottoPrize findLottoPrize(int matchCount) {
        return Arrays.stream(LottoPrize.values()).filter(prize -> prize.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NO_PRIZE);
    }

    public int getMatchCount() {
        return matchCount;
    }
      
    public int getLottoPrizeMoney() {
      return lottoPrizeMoney;
    }
  }
  ```
* [x] 수익금과 로또를 사는데 들인 비용(구입금액) 비교
  * 구입 금액 대비 수익금 비율 확인(예: 5000/14000 = 0.357... = 0.35) -> 소숫점 셋째자리 버림

### 테스트 케이스
1. 로또의 숫자 1개 생성 테스트(1로 생성하면 1이 들어가야 하고, 45로 생성하면 45가 들어가야 한다)
2. 로또의 각 숫자는 1 ~ 45 사이의 숫자여야 한다.
3. 로또는 6개의 서로 다른 숫자로 이루어진다.
4. 입력된 돈을 1000으로 나눈 몫을 로또 구매 가능 개수로 반환한다.
5. 입력된 돈이 1000보다 작을 경우 에러 발생한다.
6. 당첨 번호와 구매한 로또 번호 비교 후 일치한 개수 반환한다.
7. 주어진 돈으로 구매한 로또 비용을 반환한다.
8. 당첨금과 로또 구매 비용간 비율을 반환한다.
9. 로또 각 숫자간 크기 비교 테스트한다.
   * compareTo() 메소드를 override한 부분 테스트
10. 로또 수행 결과 당첨금 합을 테스트한다.
11. 돈 금액 비교 테스트한다.
    * 인자로 넘긴 돈보다 주어진 돈이 작으면 true 반환 테스트

## 4단계 - 로또(2등)
* 추가 번호 추첨
  * [x] 추가 번호 입력 시, 기존에 입력한 로또 당첨 번호에 속하지 않아야 함
* 구매한 로또 번호와 당첨 번호 간 일치 개수 확인 시, 추가 번호도 확인
  * [x] Lottos의 createLottoResults() 메소드 변경
  * 5개 당첨일 때에만 보너스볼 당첨 여부 확인 추가
  ```java
  public enum LottoPrize {
    NO_PRIZE(0, 0, "0~2개 일치 (0원)"),
    FIFTH(3, 5000, "3개 일치 (5000원)"),
    FOURTH(4, 50000, "4개 일치 (50000원)"),
    THIRD(5, 1500000, "5개 일치 (1500000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치(30000000원)"),
    FIRST(6, 2000000000, "6개 일치 (2000000000원)")
    ;
  ```
  * [x] LottoPrize의 findLottoPrize() 메소드 변경

### 테스트 케이스
1. 로또 당첨이 4개이면서, 보너스 숫자를 맞춘 경우 4등이다.
2. 로또 당첨이 5개이면서, 보너스 숫자를 맞춘 경우 2등이다.
3. 로또 당첨이 5개이면서, 보너스 숫자를 맞추지 못한 경우 3등이다.
4. 당첨 로또에 존재하는 로또번호를 보너스 숫자로 입력하면 에러 발생한다.
  * [ERROR] 보너스 볼은 당첨 로또의 각 숫자와 일치할 수 없습니다.
5. 당첨 로또에 존재하지 않는 로또번호를 보너스 숫자로 입력하면 정상 작동한다.