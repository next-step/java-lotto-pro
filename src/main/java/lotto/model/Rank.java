package lotto.model;

public enum Rank {
    FIRST(6, 2000000000) {
        String payPrize(int count) {
            return String.format("%d개 일치 (%d원)- %d개", condition(), prize(), count);
        }
    },
    SECOND(5, 30000000) {
        String payPrize(int count) {
            return String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개", condition(), prize(), count);
        }
    },
    THIRD(5, 1500000) {
        String payPrize(int count) {
            return String.format("%d개 일치 (%d원)- %d개", condition(), prize(), count);
        }
    },
    FOURTH(4, 50000) {
        String payPrize(int count) {
            return String.format("%d개 일치 (%d원)- %d개", condition(), prize(), count);
        }
    },
    FIFTH(3, 5000) {
        String payPrize(int count) {
            return String.format("%d개 일치 (%d원)- %d개", condition(), prize(), count);
        }
    },
    MISS(0, 0) {
        String payPrize(int match) {
            return "꽝입니다";
        }
    };

    private final int condition;
    private final int prize;

    Rank(int condition, int prize) {
        this.condition = condition;
        this.prize = prize;
    }

    public int condition() {
        return condition;
    }

    public int prize() {
        return prize;
    }

    public static Rank valueOf(int count, boolean bonus) {
        if (count == 5 && bonus) {
            return SECOND;
        }
        for (Rank rank : values()) {
            if (rank == SECOND) {
                continue;
            }
            if (rank.condition == count) {
                return rank;
            }
        }
        return Rank.MISS;
    }

    public static Rank[] reverseValues() {
        Rank[] forward = values();
        Rank[] reverse = new Rank[forward.length];
        for (int src = forward.length - 1, dest = 0; src >= 0; src--, dest++) {
            reverse[dest] = forward[src];
        }
        return reverse;
    }

    abstract String payPrize(int count);
}
