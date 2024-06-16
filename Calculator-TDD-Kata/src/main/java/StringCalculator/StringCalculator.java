package StringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.*?)\n(.*)").matcher(numbers);
            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1));
                numbers = matcher.group(2);
            }
        }

        String[] numberArray = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String number : numberArray) {
            if (!number.isEmpty()) {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    negatives.add(num);
                }
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives.toString());
        }

        return sum;
    }
}
