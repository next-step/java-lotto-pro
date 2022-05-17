package lottoauto.wrapper;

import lottoauto.view.OutputViewer;

public class Price {
    int price;
    int tryTimes;


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
        OutputViewer.printTryTimes(this.tryTimes);
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

    public int getPrice() {
        return price;
    }
}
