package effectiveJava.builder;

public class User {
    private final String name;
    private final int age;
    private final int height;
    private final int weight;
    private final String address;

    private User(Builder builder) {
        name = builder.name;
        age = builder.age;
        height = builder.height;
        weight = builder.weight;
        address = builder.address;
    }

    static class Builder {
        private final String name;
        private final int age;
        private int height;
        private int weight;
        private String address;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }
    }
}
