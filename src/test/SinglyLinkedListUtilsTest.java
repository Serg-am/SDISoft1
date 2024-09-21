import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;

public class SinglyLinkedListUtilsTest {

    private SinglyLinkedList<Integer> list;
    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
        list.add(5);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(-5);
        list.add(9);
        list.add(-2);
        list.add(0);
    }

    @Test
    void testFindTopNElements() {
        List<Integer> topThree = SinglyLinkedListUtils.findTopNElements(list, 2);
        assertEquals(Arrays.asList(9, 5), topThree);
    }
}
