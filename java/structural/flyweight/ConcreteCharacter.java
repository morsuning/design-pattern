package structural.flyweight;

// ConcreteFlyweight
public class ConcreteCharacter implements CharacterFlyweight {
    // intrinsicState: 内部状态 (字符本身)
    private final char character;

    public ConcreteCharacter(char character) {
        this.character = character;
    }

    @Override
    public void display(String font, int size) {
        System.out.println("Character: " + character + " (Font: " + font + ", Size: " + size + ")");
    }
}
