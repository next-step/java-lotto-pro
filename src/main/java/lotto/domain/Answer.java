package lotto.domain;

public class Answer {
    private final Lotto answer;
    private final Number bonus;

    public Answer(Lotto answer, Number bonus) {
        if (answer.contains(bonus)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
        this.answer = answer;
        this.bonus = bonus;
    }

    public Winning winning(Lotto lotto) {
        return Winning.from(lotto.matchCount(answer), lotto.contains(bonus));
    }
}
