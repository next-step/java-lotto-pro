package lotto.component;

public interface GameStatusChangeable {

    void start();

    void end();

    boolean isStart();

    boolean isEnd();
}
