package structural.flyweight;

/**
 * 享元模式 (Flyweight)
 *
 * 目的:
 * 运用共享技术有效地支持大量细粒度的对象。
 * 通过分离内部状态（Intrinsic State，可共享）和外部状态（Extrinsic State，不可共享），
 * 来减少内存中相似对象的数量。
 *
 * 使用场景 (更具体的例子):
 * 1.  **文本编辑器**: 如本例所示，一篇文档中可能有成千上万个字符。如果每个字符都创建一个对象，
 *     内存开销会非常大。使用享元模式，26个字母、10个数字和一些标点符号可以被所有地方共享。
 *     字符本身是内部状态，而其位置、字体、颜色等是外部状态。
 * 2.  **游戏开发**: 在一个场景中有大量的树木、岩石等环境对象。这些对象的模型、贴图等可以作为内部状态共享，
 *     而它们在地图上的位置、大小、旋转角度则是外部状态。
 * 3.  **Java中的应用**: `java.lang.Integer.valueOf(int)`。在-128到127之间的整数，
 *     `valueOf` 会返回一个缓存的 `Integer` 对象，而不是每次都创建一个新的。
 *     `String` 类的字符串常量池也是享元模式的一种体现。
 */
public class Client {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        String document = "AABBCAB";
        String font = "Arial";
        int size = 12;

        System.out.println("--- Displaying document ---");
        for (char c : document.toCharArray()) {
            CharacterFlyweight character = factory.getCharacter(c);
            character.display(font, size);
            // 我们可以改变外部状态
            size++;
        }

        System.out.println("\n--- Verification ---");
        System.out.println("Total flyweight objects created: " + factory.getFlyweightsCount());
    }
}
