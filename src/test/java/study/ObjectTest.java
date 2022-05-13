package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ObjectTest {

    List<CustomObject> objects;

    @BeforeEach
    public void init() {
        objects = new ArrayList<>();
        objects.add(new CustomObject("object1", 3.6f));
        objects.add(new CustomObject("object2", 4.6f));
    }

    @Test
    @DisplayName("같은 값의 Object Equal Test")
    public void equalObject() {
        CustomObject copyObject = new CustomObject("object1", 3.6f);
        assertThat(objects.get(0) == copyObject)
            .isFalse();
        assertThat(objects.get(0))
            .isEqualToComparingFieldByFieldRecursively(copyObject);
    }

    @Test
    @DisplayName("object의 name들을 체크해보자")
    public void testObjectNames() {
        assertThat(objects)
            .extracting("name")
            .containsExactly("object1", "object2");
    }

    @Test
    @DisplayName("객체가 Interface인지 아닌지")
    public void checkIsInterface() {
        assertThat(CustomObject.class)
            .isNotInterface();
    }

    @Test
    @DisplayName("List 테스트")
    public void listTest() {
        List<String> lists = Arrays.asList("1", "2", "3");

        assertThat(lists)
            .isNotEmpty()
            .contains("1")
            .containsExactly("1", "2", "3")
            .doesNotContainNull()
            .doesNotContain("4", "5", "6")
            .startsWith("1")
            .endsWith("3");
    }

    @Test
    @DisplayName("Map 테스트")
    public void mapTest() {
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        assertThat(map)
            .isNotEmpty()
            .doesNotContainKey("d")
            .containsKey("c")
            .contains(entry("a", "1"))
            .containsEntry("b", "2");


    }

    class CustomObject {

        private String name;
        private Float weight;

        public CustomObject(String name, Float weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public Float getWeight() {
            return weight;
        }
    }
}
