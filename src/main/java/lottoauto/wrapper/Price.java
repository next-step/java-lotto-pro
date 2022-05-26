package lottoauto.wrapper;

import lottoauto.view.OutputViewer;

public class Price {
    int price;
    int tryTimes;
    int manualTryTimes;


    public Price(int price, int tryTimes, int manualTryTimes) {
        this.price = price;
        this.tryTimes = tryTimes;
        this.manualTryTimes = manualTryTimes;
    }

    public Price() {
    }

    public void makeNewTryTimes(String input) {
        try {
            this.price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("1000이상의 숫자만 입력 가능합니다");
        }

        if (this.price < 1000) {
            throw new NumberFormatException("1000이하의 숫자 또는 음수를 입력할 수는 없습니다.");
        }

        this.tryTimes = this.price / 1000;
    }

    public void makeManualTryTimes(String input) {
        try {
            this.manualTryTimes = Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }

        if(this.manualTryTimes > this.price) {
            throw new RuntimeException("수동으로 구매할 로또는 총 구매할 로또 수보다 작아야 합니다.");
        }

        this.tryTimes = this.tryTimes - this.manualTryTimes;
    }


    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                ", tryTimes=" + tryTimes +
                '}';
    }

    public int getTryTimes() {
        return tryTimes;
    }

    public int getManualTryTimes() {
        return manualTryTimes;
    }

    public int getPrice() {
        return price;
    }
}
