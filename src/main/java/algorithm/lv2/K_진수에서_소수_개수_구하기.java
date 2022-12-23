package algorithm.lv2;

public class K_진수에서_소수_개수_구하기 {
    public static void main(String[] args) {
        new K_진수에서_소수_개수_구하기().solution(110011, 10);
    }

    public int solution(int n, int k) {
        String kNumber = Long.toString(n, k);
        if (!kNumber.contains("0")) {
            if (isPrime(kNumber)) {
                return 1;
            }
            return 0;
        }

        int answer = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < kNumber.length(); i++) {
            if (kNumber.charAt(i) == '0') {
                if (str.length() != 0 && isPrime(str.toString())) {
                    answer++;
                }
                str.delete(0, str.length());
                continue;
            }
            str.append(kNumber.charAt(i));
        }
        if (str.length() != 0 && isPrime(str.toString())) {
            answer++;
        }
        return answer;
    }

    private boolean isPrime(String strNumber) {
        long number = Long.parseLong(strNumber);
        if (number == 1 || number == 0) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
