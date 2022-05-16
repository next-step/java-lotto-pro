package lotto;

public class Rank {
    private final int key;
    int price;
    int count;

    public Rank(int key, int price, int count) {
        this.key = key;
        this.price = price;
        this.count = count;
    }

    public void addCount() {
        count++;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public int calculateTotalPrice() {
        return price * count;
    }

    public void printRank() {
        System.out.println(key + "개 일치 (" + price + "원)- " + count + "개");
    }
}