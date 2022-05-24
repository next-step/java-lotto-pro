package lotto.model;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, false, 2000000000) {
        String detail(int count) {
            return String.format("%d개 일치 (%d원)- %d개", condition(), prize(), count);
        }
    },
    SECOND(5, true, 30000000) {
        String detail(int count) {
            return String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개", condition(), prize(), count);
        }
    },
    THIRD(5, false, 1500000) {
        String detail(int count) {
            return String.format("%d개 일치 (%d원)- %d개", condition(), prize(), count);
        }
    },
    FOURTH(4, false, 50000) {
        String detail(int count) {
            return String.format("%d개 일치 (%d원)- %d개", condition(), prize(), count);
        }
    },
    FIFTH(3, false, 5000) {
        String detail(int count) {
            return String.format("%d개 일치 (%d원)- %d개", condition(), prize(), count);
        }
    },
    MISS(0, false, 0) {
        String detail(int match) {
            return "꽝입니다";
        }
    };

    private final int condition;
    private final boolean bonus;
    private final int prize;

    Rank(int condition, boolean bonus, int prize) {
        this.condition = condition;
        this.bonus = bonus;
        this.prize = prize;
    }

    public int condition() {
        return condition;
    }

    public int prize() {
        return prize;
    }

    public static Rank valueOf(int count, boolean bonus) {
        Optional<Rank> find = Stream.of(values())
                                    .filter(rank -> rank.condition == count && rank.bonus == bonus)
                                    .findFirst();
        return find.orElse(MISS);
    }

    public static Rank[] reverseValues() {
        Rank[] forward = values();
        Rank[] reverse = new Rank[forward.length];
        for (int src = forward.length - 1, dest = 0; src >= 0; src--, dest++) {
            reverse[dest] = forward[src];
        }
        return reverse;
    }

    abstract String detail(int count);
}
