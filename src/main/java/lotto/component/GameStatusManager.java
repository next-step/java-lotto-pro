package lotto.component;

import java.util.Objects;
import lotto.enums.GameStatus;

public final class GameStatusManager implements GameStatusChangeable {

    private static GameStatus gameStatus;

    @Override
    public void start() {
        gameStatus = GameStatus.START;
    }

    @Override
    public void end() {
        gameStatus = GameStatus.END;
    }

    @Override
    public boolean isStart() {
        return Objects.equals(GameStatus.START, gameStatus);
    }

    @Override
    public boolean isEnd() {
        return Objects.equals(GameStatus.END, gameStatus);
    }
}
