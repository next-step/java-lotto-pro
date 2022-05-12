package lottoauto.wrapper;

import java.util.Scanner;

public class Price {
    private String input;
    private int price;
    private int count;


    public void setInput() {
        lottoScanner();
        this.price = getPrice();
        setCount();
    }

    public void setInput(String input) {
        this.price = getPrice(input);
        setCount();
    }

    private void lottoScanner() {
        Scanner sc = new Scanner(System.in);
        this.input = sc.nextLine();
    }

    private int getPrice() {
        try {
            return Integer.parseInt(this.input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }
    }

    private int getPrice(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }
    }


    private void setCount() {
        if(this.price < 0) {
            throw new NumberFormatException("양수만 입력 가능합니다.");
        }
        this.count = this.price / 1000;
    }

    public int getCount() {
        return count;
    }
}
