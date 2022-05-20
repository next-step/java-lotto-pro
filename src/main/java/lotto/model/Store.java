package lotto.model;

public class Store {
    private final int createCount;

    public Store(int count) {
        this.createCount = count;
    }

    public int giveCount() {
        return this.createCount;
    }

    public Lottos giveLotto() {
        return new Lottos(this.createCount);
    }
}
