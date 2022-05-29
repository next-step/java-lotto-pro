package lottoauto.wrapper;

public class TryTime {
    private int tryTimes;
    private int manualTryTimes;

    private TryTime(int tryTimes) {
        this.tryTimes = tryTimes;
    }


    public void makeManualTryTimes(String input) {
        try {
            this.manualTryTimes = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }

        if (this.manualTryTimes > this.tryTimes) {
            throw new RuntimeException("수동으로 구매할 로또는 총 구매할 로또 수보다 작아야 합니다.");
        }

        this.tryTimes = this.tryTimes - this.manualTryTimes;
    }


    public int getTryTimes() {
        return tryTimes;
    }

    public int getManualTryTimes() {
        return manualTryTimes;
    }

    public static TryTime of(int price, int divide) {
        return new TryTime(price / divide);
    }
}
