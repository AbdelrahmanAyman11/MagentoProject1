package utils;

public class InputValidator {
    public static void validateNoScript(String input) {
        if (input != null && input.toLowerCase().contains("<script>")) {
            throw new IllegalArgumentException("XSS attempt detected in input: " + input);
        }
    }
}