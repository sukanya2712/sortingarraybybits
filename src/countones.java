import java.util.Arrays;
import java.util.Comparator;

public class countones {
    public static void main(String[] args) {
        Integer[] nums = {0,1,2,3,4,5,6,7,8};

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String binaryA = Integer.toBinaryString(a);
                String binaryB = Integer.toBinaryString(b);
                int countA = countOnes(binaryA);
                int countB = countOnes(binaryB);
                if (countA != countB) {
                    return Integer.compare(countA, countB);
                } else {
                    return Integer.compare(a, b);
                }
            }
        });

        System.out.println(Arrays.toString(nums));
    }

    public static int countOnes(String binary) {
        int count = 0;

        char[] binaryChars = binary.toCharArray();

        for (int i = 0; i < binaryChars.length; i++) {
            if (binaryChars[i] == '1') {
                count++;
            }
        }

        return count;
    }

}