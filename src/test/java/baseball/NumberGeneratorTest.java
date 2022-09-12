package baseball;

import baseball.v2.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumberGeneratorTest {

    @Test
    @DisplayName("정수_생성")
    void 정수_생성() {
        NumberGenerator numberGenerator = new NumberGenerator();
        int result = numberGenerator.generateNumber(9 ,1);

        assertTrue(result > 0 && result < 10);
    }

    @Test
    @DisplayName("번호_리스트_생성")
    void 번호_리스트_생성() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = numberGenerator.generateNumberList(3);

        assertAll(
            () -> assertEquals(3, numbers.size()),
            () -> assertTrue(numbers.get(0) > 0 && numbers.get(0) < 10),
            () -> assertTrue(numbers.get(1) > 0 && numbers.get(1) < 10),
            () -> assertTrue(numbers.get(2) > 0 && numbers.get(2) < 10)
        );

    }
}
