package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

// FlyweightFactory
public class CharacterFactory {
    private final Map<Character, CharacterFlyweight> characters = new HashMap<>();

    public CharacterFlyweight getCharacter(char key) {
        return characters.computeIfAbsent(key, c -> {
            System.out.println("Creating new character flyweight for: " + c);
            return new ConcreteCharacter(c);
        });
    }

    public int getFlyweightsCount() {
        return characters.size();
    }
}
