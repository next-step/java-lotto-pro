package step3.lotto.domain;

/**
 * @author : choi-ys
 * @date : 2022/05/17 1:42 오후
 */
public enum MatchResult {
    FIRST_PLACE("6개 일치", "2000000000원"),
    SECOND_PLACE("5개 일치", "1500000원"),
    THIRD_PLACE("4개 일치", "50000원"),
    FORTH_PLACE("3개 일치", "5000원"),
    NOTHING("당첨 사항 없음", "0원");

    private final String statusDescription;
    private final String rewardDescription;

    MatchResult(String statusDescription, String rewardDescription) {
        this.statusDescription = statusDescription;
        this.rewardDescription = rewardDescription;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public String getRewardDescription() {
        return rewardDescription;
    }
}

