package effectiveJava.builder;

import effectiveJava.builder.User.Builder;

public class Main {
    public static void main(String[] args) {
        new User.Builder("잉", 26)
                .weight(65)
                .height(173)
                .address("NY");

        new Builder("잉", 26)
                .weight(65)
                .height(173)
                .address("NY");
    }
}
