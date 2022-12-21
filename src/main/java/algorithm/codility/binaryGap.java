package algorithm.codility;

public class binaryGap {
    public static void main(String[] args) {
        new binaryGap().solution(41);
    }

    public int solution(int N) {
        String binaryNumber = Integer.toBinaryString(N);
        int max = 0;
        int count = 0;
        boolean start = false;
        for (int i = 0; i < binaryNumber.length(); i++) {
            char number = binaryNumber.charAt(i);
            if (!start && number == '1') {
                start = true;
            } else if (start && number == '1') {
                max = Math.max(count, max);
                count = 0;
            } else if (start && number == '0') {
                count++;
            }
        }
        return max;
    }
}
