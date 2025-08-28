package behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文 (Context)
 * <p>
 * 包含了解释器之外的一些全局信息。
 * 在这个例子中，它用于存储和获取变量的值。
 */
public class Context {
    // 使用 Map 来存储变量名和其对应的值
    private final Map<String, Integer> variables = new HashMap<>();

    /**
     * 设置一个变量的值。
     *
     * @param variable 变量名。
     * @param value    变量的值。
     */
    public void setVariable(String variable, int value) {
        System.out.println("Setting variable '" + variable + "' to " + value);
        variables.put(variable, value);
    }

    /**
     * 获取一个变量的值。
     *
     * @param variable 变量名。
     * @return 变量的值，如果变量不存在，则返回 0。
     */
    public int getVariable(String variable) {
        Integer value = variables.get(variable);
        if (value == null) {
            System.out.println("Variable '" + variable + "' not found, returning 0.");
            return 0;
        }
        return value;
    }
}
