import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class countones1 {
    public static void main(String[] args) {
        //int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt();
        int[] nums = new int[length];
        System.out.println("Enter " + length + " numbers:");
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }

        Integer[] numsWrapper = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsWrapper[i] = nums[i];
        }

        Arrays.sort(numsWrapper, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String binaryA = Integer.toBinaryString(a);
                String binaryB = Integer.toBinaryString(b);
                int countA = countOnes1(binaryA);
                int countB = countOnes1(binaryB);
                if (countA != countB) {
                    return Integer.compare(countA, countB);
                } else {
                    return Integer.compare(a, b);
                }
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsWrapper[i];
        }

        System.out.println("output is :" + Arrays.toString(nums));

    }



    public static int countOnes1(String binary) {
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
