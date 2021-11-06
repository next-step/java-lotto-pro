package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBalls {
    private List<LottoBall> lottoBalls;

    public LottoBalls(List<LottoBall> lottoBalls) {
        if (lottoBalls.size() != LottoBallEnum.LOTTO_BALLS_SIZE.getNumber()) {
            throw new IllegalArgumentException("로또 공 개수가 6개가 아닙니다");
        }
        this.lottoBalls = lottoBalls;
    }

    public LottoBalls(String numbersString) {
        String[] numbersSplitted = splitNumberString(numbersString);
        this.lottoBalls = createLottoBallList(numbersSplitted);
    }

    private String[] splitNumberString(String numbersString) {
        String[] numbersSplitted = numbersString.split(",");
        if (numbersSplitted.length != LottoBallEnum.LOTTO_BALLS_SIZE.getNumber()) {
            throw new IllegalArgumentException("로또 공 개수가 6개가 아닙니다.");
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


    @Override
    public String toString() {
        return lottoBalls.stream()
                .map(LottoBall::toString)
                .reduce((d1, d2) -> String.join(",", d1, d2))
                .orElseThrow(() -> new IllegalArgumentException("로또 번호 문자열 변환 실패"));
    }

}