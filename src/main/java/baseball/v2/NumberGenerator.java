package baseball.v2;

import java.util.*;

public class NumberGenerator {

    public int generateNumber(int max, int min) {
        Random random = new Random();

        return random.nextInt(max - min + 1) + min;
    }

    public List<Integer> generateNumberList(int listSize) {
        Set<Integer> numberSet = new HashSet<>();

        while (numberSet.size() < 3) {
            numberSet.add(generateNumber(9, 1));
        }

        return new ArrayList<>(numberSet);
    }
}
