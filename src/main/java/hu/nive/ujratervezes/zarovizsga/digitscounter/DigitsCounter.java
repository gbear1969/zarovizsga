package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {
    public int getCountOfDigits(String s) {
        if (s==null) return 0;
        Set<Character> numbers = new HashSet<>();
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers.add(c);
            }
        }
        return numbers.size();
    }
}
