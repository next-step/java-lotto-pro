package lottoauto.wrapper;

import lottoauto.view.OutputViewer;

public class Price {
    int price;

    public Price() {
    }

    public Price(String input, int divide) {
        try {
            this.price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(divide+"이상의 숫자만 입력 가능합니다");
        }

        if (this.price < 1000) {
            throw new NumberFormatException(divide+"이하의 숫자 또는 음수를 입력할 수는 없습니다.");
        }
    }

    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                '}';
    }


    public int getPrice() {
        return price;
    }
}
