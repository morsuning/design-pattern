package structural.flyweight;

// Flyweight
public interface CharacterFlyweight {
    // extrinsicState: 外部状态 (字体, 大小等)
    void display(String font, int size);
}
