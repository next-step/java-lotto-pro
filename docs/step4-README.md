4단계-로또(2등)
===
# 미션 설명
### 기능 요구 사항
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.
- 프로그램 실행 예시 
    ```
    구입금액을 입력해 주세요.
    14000
    14개를 구매했습니다.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [23, 25, 33, 36, 39, 41]
    [1, 3, 5, 14, 22, 45]
    [5, 9, 38, 41, 43, 44]
    [2, 8, 9, 18, 19, 21]
    [13, 14, 18, 21, 23, 35]
    [17, 21, 29, 37, 42, 45]
    [3, 8, 27, 30, 35, 44]
    
    지난 주 당첨 번호를 입력해 주세요.
    1, 2, 3, 4, 5, 6
    보너스 볼을 입력해 주세요.
    7
    
    당첨 통계
    ---------
    3개 일치 (5000원)- 1개
    4개 일치 (50000원)- 0개
    5개 일치 (1500000원)- 0개
    5개 일치, 보너스 볼 일치 (30000000원)- 0개
    6개 일치 (2000000000원)- 0개
    총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
    ```

### 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- java enum을 적용해 프로그래밍을 구현한다.
- 규칙 8: 일급 콜렉션을 쓴다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- else 예약어를 쓰지 않는다.

### 힌트
- 일급 콜렉션을 쓴다.
  - 6개의 숫자 값을 가지는 java collection을 감싸는 객체를 추가해 구현해 본다.
- 하드 코딩을 하지 않기 위해 상수 값을 사용하면 많은 상수 값이 발생한다. 자바의 enum을 활용해 상수 값을 제거한다.
  (즉, enum을 활용해 일치하는 수를 로또 등수로 변경해 본다.)
```java
public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
		
    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        return null;
    }
}
```

### 기능 목록 및 commit 로그 요구사항
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
  - 참고문서 : [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
  
---

# 미션 진행
### 구현 목표
> 다음과 같은 목표를 달성하기 위해 구현 기능 목록을 산출한다.
> - 1번의 로또 게임을 생성하고, 지난주 당첨 번호와 비교하여 결과를 출력한다.
> - N번의 로또 게임을 생성하고, 지난주 당첨 번호와 비교하여 결과를 출력한다.
> - `new` N번의 로또 게임을 생성하고, 지난주 당첨 번호와 `보너스 번호`를 이용하여 당첨 결과를 출력한다.

### 구현 기능 목록 : TODO List
- [x] 당첨 번호 도메인
    > 보너스 번호를 이용한 2등 당첨 요구사항 추가에 따라 6자리 당첨 번호와 보너스 번호를 속성으로 하는 '지난주 로또 당첨 번호' 도메인 설계
  - 지난주 당첨 번호 도메인은 다음과 같은 속성을 가진다.
    - [x] 6개의 지난주 당첨 번호 목록 : 일급 컬렉션
    - [x] 1개의 보너스 번호 : 원시 타입 포장 객체
      - [x] 보너스 번호가 지난주 당첨 번호 목록에 포함되는지 여부 판별 

- [x] 당첨 결과 객체 수정 및 당첨 여부 판별 로직 수정
  - [x] 지난주 당첨 번호 중 5개가 일치하고, 보너스 번호 1개가 일치하는 2등을 표현하는 상태 추가 및 기존 상태 수정
    - FIRST_PLACE : 6개 모두 당첨 번호와 일치하는 경우
    - SECOND_PLACE : 5개의 당첨 번호가 일치하고, 보너스 번호가 일치하는 경우
    - THIRD_PLACE : 5개의 당첨 번호가 일치하는 경우
    - FORTH_PLACE : 4개의 당첨 번호가 일치하는 경우
    - FIFTH_PLACE : 3개의 당첨 번호가 일치하는 경우
    - NOTHING : 3개 미만으로 일치하는 경우
  - [x] 금액만큼 발행된 Lottos 도메인에서 일치하는 수를 이용하여 당첨 결과로 판별한 결과를 반환하는 기능을 MatchResult 객체의 valueOf로 변경
    - AS-IS
      ```
            private MatchResult matchResult(int matchCount) {
                if (matchCount == 3) {
                    return MatchResult.FORTH_PLACE;
                }
                if (matchCount == 4) {
                    return MatchResult.THIRD_PLACE;
                }
                if (matchCount == 5) {
                    return MatchResult.SECOND_PLACE;
                }
                if (matchCount == 6) {
                    return MatchResult.FIRST_PLACE;
                }
                return MatchResult.NOTHING;
            }
      ```
    - TO-BE
      ```
        public enum MatchResult {
            FIRST_PLACE(6, 2_000_000_000),
            SECOND_PLACE(5, 30_000_000),
            THIRD_PLACE(5, 1_500_000),
            FORTH_PLACE(4, 50_000),
            FIFTH_PLACE(3, 5_000),
            NOTHING(0, 0);
                
            public static MatchResult valueOf(int countOfMatch, boolean matchBonus) {
                // TODO 일치하는 수를 이용하여 당첨 결과로 판별한 결과를 반환
                return null;
            }
        }
      ```
  - [x] 지난주 당첨 번호 중 5개가 일치하고, 보너스 번호 1개가 일치하는 2등에 대한 판별 추가
  
- [x] 당첨 통계 객체 수정
  - [x] 2등 당첨 수에 대한 통계 항목 추가

- [x] 입력 부
  - [x] 로또 2등 당첨 판별을 위한 보너스 번호 입력 안내 메세지 출력 부 추가
  - [x] 로또 2등 당첨 판별을 위한 보너스 번호 입력 부 추가
  
- [x] 출력 부
  - [x] 2등 당첨 수에 대한 집계 출력 양식 추가
  - [x] 2등 당첨 수에 대한 집계 출력 부 추가
---

# step4 미션 진행에 대한 회고
---
```
이번 미션은 기존 설계에 추가된 요구사항을 반영하는 미션으로
초반 설계에 대한 고민이 많았던 탓에 로또 도메인에 어느 정도 이해도가 생겨 
변경된 요구사항에 대한 TODO List를 문서화하고 로직 변경을 진행함에 별다른 어려움과 큰 고민이 없었다.

첫 번째 미션이지만 2번의 프리코스를 포함하여 TDD 전체 미션 중에서 가장 몰입감 있게 진행할 수 있었고 어느 정도 성취감도 느낄 수 있었다.
코드 리뷰에서 피드백받은 내용을 따로 정리하여 설계와 구현 시점에 한번 더 확인하는 습관을 들여 앞으로 미션 진행함에 있어 자연스럽게 적용할 수 있도록 해서
추가적으로 발생하는 피드백이 쌓여서 학습효과가 없는 일이 없도록 하자.

한주에 하나의 미션이라고 생각하여 좀 여유 있게 진행한 감이 있는 듯하다. 슬렉에 올라오는 알림을 보며 점점 압박을 느끼기 시작한다.
로또 미션만 해도 step1을 제외하면 4개의 step으로 이루어져 있으므로 사실상 하루~이틀 간격으로 PR을 요청해야 겨우 한주차 미션을 겨우 완료할 수 있다.
고민하고 구현하고 피드백을 받는 것 또한 중요하지만 수료 역시 중요한 부분임을 인지하고 진행하자.

반복적으로 혹은 미처 의식하지 못했던 리뷰어님의 피드백 사항들
- 도메인과 결합도가 높은 로직이(e.g. 유효성 검증), 이후 여러 도메인과 같은 관심사를 가지는 경우 별도 클래스로(e.g. *Validator) 분리할 수 있는지
- TDD 싸이클을 반복적으로 진행하며 기능을 구체화
- 더 좋은 코드 구성이 없는지 고민되는 경우(e.g. 케이스 추가에 따른 if 분기 추가) 설계 변경을(e.g. 다른 자료구조를 고려) 통해 해결할 수 있는지 고민
- 숫자 표현 시 '_'를 이용한 자릿수 표현을 통해 가독성을 높일 수 있는지
- 무의식적으로 IDE에서 지원하는 자동완성을 이용하여 코드 통일성을 해치지는 않는지
- Test 코드 작성 시 검증해야 하는 부분이 실 코드에서 사용되는 꼭 필요한 아웃풋인지
```

# 영상 피드백
### 강의 : 로또 TDD 강의 및 일급 콜렉션 적용 리팩토링
```
- 리팩토링 시 객체지향 생활 체조 원칙, 클린코드 원칙을 참고해 리팩토링
  - 문자열과 원시타입 포장 객체의 활용
  - 일급 컬렉션의 활용
  - 메서드 인자 수 관련 리팩토링에 대한 클린 코드 내용 중 정량적인 참고 사항
    - 메서드 인자 수는 없는 것이 가장 좋음, 다음으로는 1개, 그 다음은 2개인 경우, 3개인 경우는 지양, 그 이상은 절대 불가
```
리팩토링 내용
- Lotto 객체 리펙토링
  - Lotto 객체 생성 TC의 검증 방식 변경
    - Lotto 객체 생성 Test를 위해 구현한 실 코드에서 참조가 없는 size 메서드 삭제
    - Lotto 객체 생성 시 검증 항목을 size를 이용한 검증에서 equasl(), hashcode() 구현 후, 객체 동등성을 이용한 검증으로 변경

  - 비효율적으로 구현된 contains 메소드 개선
    - AS-IS
      ```
        public boolean contains(LottoNumber winningsLottoNumber) {
            Set<Boolean> compareEqualsSet = new HashSet();
            for (LottoNumber lottoNumber : lottoNumbers) {
                compareEqualsSet.add(lottoNumber.equals(winningsLottoNumber));
            }
            return compareEqualsSet.contains(true);
        }
      ```
    - TO-BE
      ```
        public boolean contains(LottoNumber winningsLottoNumber) {
            return lottoNumbers.contains(winningsLottoNumber);
        }
      ```
      
  - Lotto 객체 필드의 자료구조 변경
    - 변경 내용 :
      - AS-IS : List<Integer> lotto
      - TO-BE : Set<Integer> lotto
    - 변경 사유 : List로 이루어진 6개의 로또 번호의 중복 여부 확인을 위해 Set으로 변경 후 size를 체크 후, 다시 List로 구성된 필드에 값을 할당하는 비효율적인 작업 개선
    - 변경 효과 : 자료구조 변경에 따른 예외 처리 로직 통합
      - AI-IS
        - List 타입 인자의 size가 6인지 여부 검증
        - List 타입 인자를 Set으로 변경하여 중복 포함 여부 검증
      - TO-BE
        - Set 타입 인자의 size가 6인지 여부 검증
    - 리팩토링에 따른 코드 변경 :
      - 자료구조 변경에 따른 Lotto 객체 생성 시 예외 처리 TC 통합
      - UI를 위한 정렬 로직 제거
      
  - UI를 위한 로또 번호 정렬 로직 수정
    - Lotto 객체 필드의 자료구조 변경에 따른 정렬 처리 추가
      - Lotto 객체의 List<LottoNumber> 반환 시, Comparable을 이용하여 정렬 후 반환
      - 정렬 처리 추가에 따른 Test Case 추가
      
    - 로또 번호 정렬 로직 위치 변경
      - AS-IS : Lotto 객체 생성 시점
      - TO-BE : 정렬 후 반환하는 별도의 메소드 제공

### 강의 : private method에 대한 테스트 및 리팩토링
```
private 메서드에 대한 Test 여부를 고민하는 경우 아래 사항을 먼저 고민
- 해당 위치에서 private 하게 구성하는게 올바른 설계인지 먼저 고민
- private 메소드에 대한 접근제한자를 변경하는 방법 등을 통해 Test 여부를 고민

메서드 오버라이딩을 통해 안전한 리팩토링을 진행
- 리팩토링 대상 메서드에 대한 참조가 많은 경우, 한번에 진행 하기보다는 일정 과도기를 가지고 점진적으로(안정적으로) 진행
```    
리팩토링 내용
- 당첨 여부를 판별하는 메서드의 위치 변경
   - 변경 사유 : Lottos 객체에서 당첨 여부 판별을 위해, 인자로 받은 WinningsLotto 객체의 필드 접근을 위한 get 메서드 제거
   - 변경 내용 : Lottos 객체의 match 메서드를 WinningsLotto 객체로 이동
   - 변경 효과 : 
     - get 메서드 사용 없이 변경 전과 동일한 기능 제공
     - WinningsLotto 객체 필드 접근을 위해 구현한 get 메서드 삭제
   - 리팩토링에 따른 코드 변경 : Lottos 객체의 match 메서드에 대한 TC를 WinningsLotto 객체의 Test Class로 이동
---
