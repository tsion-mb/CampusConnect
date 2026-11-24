import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Jmain{
    // Rules are checked from top to bottom; the first match wins.
    private static final String[][] RULES = {
            {"\\b(help|commands)\\b", "Try: hello, how are you, what is your name, "
                    + "what is Java, tell me a joke, or thanks. Type bye, exit, or quit to leave."},
            {"\\b(your name|who are you)\\b", "I'm ChatbotJ, a simple rule-based Java chatbot."},
            {"\\bhow are you\\b", "I'm ready to chat! How can I help you?"},
            {"\\b(what can you do|how do you work)\\b", "I match your message against predefined "
                    + "rules and return a fixed response. I do not learn. Type help for examples."},
            {"\\bjava\\b", "Java is a programming language used to build applications. "
                    + "This chatbot is written in Java!"},
            {"\\b(joke|jokes)\\b", "Why do programmers prefer dark mode? Because light attracts bugs!"},
            {"\\b(thanks|thank you)\\b", "You're welcome!"},
            {"\\b(hello|hi|hey)\\b", "Hello! What would you like to talk about?"}
    };

    private static final Pattern[] PATTERNS = new Pattern[RULES.length];
    static {
        for (int i = 0; i < RULES.length; i++) {
            PATTERNS[i] = Pattern.compile(RULES[i][0]);
        }
    }

    // Normalize input once so matching ignores case, punctuation and extra spaces.
    private static String normalize(String input) {
        return input.toLowerCase(Locale.ROOT)
                .replaceAll("[^\\p{L}\\p{N}\\s]", " ")
                .trim().replaceAll("\\s+", " ");
    }

    private static boolean isExit(String message) {
        // Only standalone commands end the conversation.
        return message.matches("bye|goodbye|exit|quit");
    }

    public static String getResponse(String input) {
        String message = normalize(input);
        if (message.isEmpty()) {
            return "Please type a message, or type help for suggestions.";
        }
        if (isExit(message)) {
            return "Goodbye! Thanks for chatting.";
        }
        for (int i = 0; i < RULES.length; i++) {
            if (PATTERNS[i].matcher(message).find()) {
                return RULES[i][1];
            }
        }
        return "I don't have a rule for that yet. Type help to see what I understand.";
    }

    public static void main(String[] args) {
        System.out.println("ChatbotJ: Hello! Type help for examples or exit to leave.");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("You: ");
                if (!scanner.hasNextLine()) {
                    System.out.println("\nChatbotJ: Goodbye!");
                    break;
                }
                String input = scanner.nextLine();
                System.out.println("ChatbotJ: " + getResponse(input));
                if (isExit(normalize(input))) {
                    break;
                }
            }
        }
    }
}
