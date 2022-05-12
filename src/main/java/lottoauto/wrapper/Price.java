package lottoauto.wrapper;

public class Price {
    int tryTimes;

    public Price(String input) {
        try {
            tryTimes = (Integer.parseInt(input) / 1000);
        } catch(NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }

        if(tryTimes < 1) {
            throw new NumberFormatException("양수만 입력 가능합니다.");
        }

    }

    public int getTryTimes() {
        return tryTimes;
    }
}
