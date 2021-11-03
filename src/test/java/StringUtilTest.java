import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringUtilTest {
    @Test
    public void splitStringTestTwoString(){
        assertThat(StringUtil.splitString("1,2")).contains("1", "2");
    }

    @Test
    public void splitStringTestOnlyOneString(){
        //assertThat(StringUtil.splitString("1")).containsOnly("1");
        assertThat(StringUtil.splitString("1")).containsExactly("1");
    }

    @Test
    public void removeParenthesisTest(){
        assertThat(StringUtil.removeParenthesis("(1,2)")).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자 가져오기 테스트")
    public void findCharUseIndexTest(){
        assertThat(StringUtil.findCharUseIndex(0)).isEqualTo("a");
        assertThatThrownBy(() -> {
            StringUtil.findCharUseIndex(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("range: 4");
    }
}
