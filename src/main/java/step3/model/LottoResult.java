package step3.model;

import step3.service.LottoScoreType;

public class LottoResult {
    private static final double TWO_POINT_POSITION = 100;

    private int threeMatchedCount;
    private int fourMatchedCount;
    private int fiveMatchedCount;
    private int sixMatchedCount;

    public LottoResult() {}
    public LottoResult(int threeMatchedCount, int fourMatchedCount, int fiveMatchedCount, int sixMatchedCount) {
        this.threeMatchedCount = threeMatchedCount;
        this.fourMatchedCount = fourMatchedCount;
        this.fiveMatchedCount = fiveMatchedCount;
        this.sixMatchedCount = sixMatchedCount;
    }

    public int getByLottoScoreType(LottoScoreType scoreType) {
        if (scoreType == null) {
            return 0;
        }

        if (LottoScoreType.THREE.equals(scoreType)) {
            return threeMatchedCount;
        }

        if (LottoScoreType.FOUR.equals(scoreType)) {
            return fourMatchedCount;
        }

        if (LottoScoreType.FIVE.equals(scoreType)) {
            return fiveMatchedCount;
        }

        if (LottoScoreType.SIX.equals(scoreType)) {
            return sixMatchedCount;
        }

        return 0;
    }

    public void addByLottoScoreType(LottoScoreType scoreType) {
        if (scoreType == null) {
            return;
        }

        if (LottoScoreType.THREE.equals(scoreType)) {
            this.threeMatchedCount++;
        }

        if (LottoScoreType.FOUR.equals(scoreType)) {
            this.fourMatchedCount++;
        }

        if (LottoScoreType.FIVE.equals(scoreType)) {
            this.fiveMatchedCount++;
        }

        if (LottoScoreType.SIX.equals(scoreType)) {
            this.sixMatchedCount++;
        }
    }

    public double getBenefitRate(int money) {
        int totalBenefit = 0;
        for (LottoScoreType scoreType : LottoScoreType.values()) {
            totalBenefit += (getByLottoScoreType(scoreType) * scoreType.getMoney());
        }

        return Math.floor(((double)totalBenefit / money * TWO_POINT_POSITION)) / TWO_POINT_POSITION;
    }
}
