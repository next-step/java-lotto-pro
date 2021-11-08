package lotto.domain;

import lotto.exception.LottoBallCountException;
import lotto.exception.LottoBallNumberConvertException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBalls {
    private List<LottoBall> lottoBalls;

    public LottoBalls(List<LottoBall> lottoBalls) {
        if (lottoBalls.size() != LottoBallRule.LOTTO_BALLS_SIZE.getNumber()) {
            throw new LottoBallCountException("로또 공 개수가 6개가 아닙니다");
        }
        this.lottoBalls = Collections.unmodifiableList(lottoBalls);
    }

    public LottoBalls(String numbersString) {
        String[] numbersSplitted = splitNumberString(numbersString);
        this.lottoBalls = Collections.unmodifiableList(createLottoBallList(numbersSplitted));
    }

    public List<LottoBall> getLottoBalls() {
        return Collections.unmodifiableList(lottoBalls);
    }

    private String[] splitNumberString(String numbersString) {
        String[] numbersSplitted = numbersString.split(",");
        if (numbersSplitted.length != LottoBallRule.LOTTO_BALLS_SIZE.getNumber()) {
            throw new LottoBallCountException("로또 공 개수가 6개가 아닙니다.");
        }
        return numbersSplitted;
    }

    private List<LottoBall> createLottoBallList(String[] numbersSplitted) {
        List<LottoBall> lottoBallList = new ArrayList<>();
        for (String numberString : numbersSplitted) {
            lottoBallList.add(new LottoBall(Integer.parseInt(numberString)));
        }
        return lottoBallList;
    }

    public int countContainingWinNumbers(LottoBalls winLottoBalls) {
        int count = 0;
        for (LottoBall winBall : winLottoBalls.lottoBalls) {
            count = lottoBalls.contains(winBall) ? count + 1 : count;
        }
        return count;
    }

    public boolean hasBonusBall(LottoBall bonusBall) {
        return lottoBalls.contains(bonusBall);
    }
}
