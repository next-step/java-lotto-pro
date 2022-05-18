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
- [ ] 지난주 당첨 번호 도메인
    > 보너스 번호를 이용한 2등 당첨 요구사항 추가에 따라 6자리 당첨 번호와 보너스 번호를 속성으로 하는 '지난주 로또 당첨 번호' 도메인 설계
  - 지난주 당첨 번호 도메인은 다음과 같은 속성을 가진다.
    - [ ] 6개의 지난주 당첨 번호 목록 : 일급 컬렉션
    - [ ] 1개의 보너스 번호 : 원시 타입 포장 객체
      - [ ] 보너스 번호가 지난주 당첨 번호 목록에 포함되는지 여부 판별 

- [ ] 당첨 결과 객체 수정 
  - [ ] 지난주 당첨 번호 중 5개가 일치하고, 보너스 번호 1개가 일치하는 2등을 표현하는 상태 추가 및 기존 상태 수정
    - FIRST_PLACE : 6개 모두 당첨 번호와 일치하는 경우
    - SECOND_PLACE : 5개의 당첨 번호가 일치하고, 보너스 번호가 일치하는 경우
    - THIRD_PLACE : 5개의 당첨 번호가 일치하는 경우
    - FORTH_PLACE : 4개의 당첨 번호가 일치하는 경우
    - FIFTH_PLACE : 3개의 당첨 번호가 일치하는 경우
    - NOTHING : 3개 미만으로 일치하는 경우

- [ ] 당첨 여부 판별 로직 수정
  - [ ] 지난주 당첨 번호 중 5개가 일치하고, 보너스 번호 1개가 일치하는 2등에 대한 판별 추가
  - [ ] 금액만큼 발행된 Lottos 도메인에서 일치하는 수를 이용하여 당첨 결과로 판별한 결과를 반환하는 기능을 MatchResult 객체의 valueOf로 변경
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
  
- [ ] 당첨 통계 객체 수정 
  - [ ] 2등 당첨 수에 대한 통계 항목 추가

- [ ] 출력 부
  - [ ] 2등 당첨 수에 대한 통계
    
- [ ] 입력 부
  - [ ] 로또 2등 당첨 판별을 위한 보너스 번호 입력 추가
---

# 고민 사항
---

# step4 미션 진행에 대한 회고
---
