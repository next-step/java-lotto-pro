package lotto.model;

import java.util.Objects;

public class LottoPaper {

    private final int gameCount;

    public LottoPaper(int gameCount) {
        this.gameCount = gameCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPaper that = (LottoPaper) o;
        return gameCount == that.gameCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameCount);
    }
}
