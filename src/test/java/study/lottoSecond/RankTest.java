package study.lottoSecond;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void rankTest() {
        System.out.println(Rank.FIFTH);
        int i =0;
        for(Rank rank : Rank.values()) {
            System.out.println(rank.getCountOfMatch());
            System.out.println(rank.getWinningMoney());
            System.out.println(rank.name());
            System.out.println(rank.ordinal());
            Rank value = Rank.values()[i++];
            System.out.println(value.compareTo(rank));
            System.out.println(rank.compareTo(Rank.valueOf(rank.name())));
            System.out.println(Rank.valueOf(Rank.class, "FIRST").name());
            Rank.valueOf(5, true);
            System.out.println("--------------");
        }



    }

}