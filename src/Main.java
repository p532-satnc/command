import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // RemoteController for Fan
        Fan fan = new Fan();
        RemoteController fanController = new RemoteController(fan::startRotate, fan::stopRotate);

        fanController.on();
        fanController.off();

        System.out.println();

        // RemoteController for Light
        Light light = new Light();
        RemoteController lightController = new RemoteController(light::turnOn, light::turnOff);

        lightController.on();
        lightController.off();

        System.out.println();


        List<String> words = Arrays.asList("apple", "banana", "cherry", "apricot", "blueberry");

        RegexIterable filteredWords = new RegexIterable(words, "^a"); // words starting with 'a'

        for (String word : filteredWords) {
            System.out.println(word);
        }
    }
}
