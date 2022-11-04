package common.vo;

public class Count {

    private int number;

    public Count(int number) {
        this.number = number;
    }

    public void plus() {
        this.number++;
    }

    public int getNumber() {
        return this.number;
    }
}
