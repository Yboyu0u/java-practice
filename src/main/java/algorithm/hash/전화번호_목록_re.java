package algorithm.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 전화번호_목록_re {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        Set<Object> set = new HashSet<>();
        for (String phone : phone_book) {
            for (int i = 1; i <= phone.length(); i++) {
                if (set.isEmpty()) {
                    break;
                }
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
            set.add(phone);
        }
        return true;
    }
}
