package calculator.domain;

public class Num {

    int element;

    public Num(String str) {
        this.element = Integer.parseInt(str);
    }

    public int getElement() {
        return element;
    }

}
