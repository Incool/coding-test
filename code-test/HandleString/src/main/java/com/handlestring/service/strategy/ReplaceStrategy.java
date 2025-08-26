package com.handlestring.service.strategy;

/**
 * 高级替换策略.
 *
 * @author Incool
 */
public class ReplaceStrategy implements HandleStrategy {

    @Override
    public String handle(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder sb = new StringBuilder(input);
        boolean isChange = true;
        while (isChange) {
            isChange = false;
            for (int i = 0; i < sb.length(); i++) {
                int j = i + 1;
                while (j < sb.length() && sb.charAt(j) == sb.charAt(i)) {
                    j++;
                }

                if (j - i >= 3) {
                    char current = sb.charAt(i);
                    char replacement = current == 'a' ? ' ' : (char)(current - 1);
                    sb.replace(i, j, String.valueOf(replacement));
                    isChange = true;
                    i = i - 1;
                } else {
                    i = j - 1;
                }
            }
        }

        return sb.toString().replace(" ", "");
    }
}
