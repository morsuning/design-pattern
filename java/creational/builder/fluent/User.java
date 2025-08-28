package creational.builder.fluent;

/**
 * 产品类 - User
 * 一个具有多个属性的复杂对象。
 */
public class User {
    private final String firstName; // 必选
    private final String lastName;  // 必选
    private final int age;          // 可选
    private final String phone;     // 可选
    private final String address;   // 可选

    // 构造函数是私有的，只能通过 Builder 创建
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return "User{"
                + "firstName='" + firstName + "'"
                + ", lastName='" + lastName + "'"
                + ", age=" + age
                + ", phone='" + phone + "'"
                + ", address='" + address + "'"
                + '}'
                ;
    }

    // --- 静态内部 Builder 类 ---
    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age = 0;
        private String phone = "";
        private String address = "";

        /**
         * 构造函数包含所有必选参数。
         */
        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        /**
         * 设置可选参数 age，并返回 this 以支持链式调用。
         */
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        /**
         * 设置可选参数 phone。
         */
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        /**
         * 设置可选参数 address。
         */
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        /**
         * build() 方法返回最终构建的 User 对象。
         * 通常在这里进行参数校验。
         */
        public User build() {
            if (firstName == null || lastName == null) {
                throw new IllegalStateException("First name and last name are required.");
            }
            return new User(this);
        }
    }
}
