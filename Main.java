import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] array = {2, 10, 3, 4, 20, 5};
        //System.out.println(findTheBiggest(array));
        //System.out.println(findTheSmallest(array));
        //System.out.println(sum67v2(array));
        //System.out.println(bigDiff(array));
        //System.out.println(sum13(array));
        System.out.println(Arrays.toString(tenRun(array)));


    }

    //Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.
    private static int countEvens(int[] nums) {
        if (nums == null) throw new NullPointerException();
        int numberOfEvens = 0;
        for (int i = 0; i < nums.length; i++) { //for (int num : nums) if (num % 2 == 0) numberOfEvens++;
            if (nums[i] % 2 == 0)
                numberOfEvens++;
        }
        return numberOfEvens;
    }

    //Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array.
    private static int bigDiff(int[] nums) {
        if (nums == null) throw new NullPointerException();

        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        return max - min;
    }

    private static int findTheBiggest(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > max)
                max = nums[i + 1];
        }
        return max;
    }

    private static int findTheSmallest(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < min)
                min = nums[i + 1];
        }
        return min;
    }

    //Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 13 is very unlucky, so it does not count and numbers that come immediately after a 13 also do not count.
    private static int sum13(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 13) {
                sum = sum + nums[i];
                i++;
            } else
                i = i + 2;
        }
        return sum;
    }

    //Return the "centered" average of an array of ints, which we'll say is the mean average of the values, except ignoring the largest and smallest values in the array.
    //If there are multiple copies of the smallest value, ignore just one copy, and likewise for the largest value. Use int division to produce the final average.
    private static int centeredAverage(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int max = findTheBiggest(nums);
        int min = findTheSmallest(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            //min = Math.min(min, nums[i]);
            //max = Math.max(max, nums[i]);
        }
        return (sum - max - min) / (nums.length - 2);
    }

    private static int sum67v2(int[] nums) {
        List<Integer> indexes6 = new ArrayList<>();
        List<Integer> indexes7 = new ArrayList<>();
        int sum = 0;
        int sumToDelete = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 6)
                indexes6.add(i);
            if (nums[i] == 7)
                indexes7.add(i);
        }

        sum = sumOfRange(nums, 0, nums.length);

        for (int j = 0; j < Math.min(indexes6.size(), indexes7.size()); j++)
            sumToDelete = sumToDelete + sumOfRange(nums, indexes6.get(j), indexes7.get(j) + 1);

        return sum - sumToDelete;
    }

    //Return the sum of the numbers in the array, except ignore sections of numbers starting with a 6 and extending to the next 7 (every 6 will be followed by at least one 7).
    private static int sum67(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        boolean badSection = false; // 6 ... 7
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 6)
                badSection = true;

            if (!badSection)
                sum = sum + nums[i];

            if (badSection && nums[i] == 7)
                badSection = false;
        }
        return sum;
    }

    private static int sumOfRange(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    //Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
    private static boolean has22(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2)
                return true;
        }
        return false;
    }

    //Given an array of ints, return true if the array contains no 1's and no 3's.
    private static boolean lucky13(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 || nums[i] == 3)
                return false;
        }
        return true;
    }

    //Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.
    private static boolean sum28(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int sum = 0;
        for (int num : nums) {
            if (num == 2)
                sum = sum + num;
        }
        return sum == 8;
    }

    //Given an array of ints, return true if the number of 1's is greater than the number of 4's
    private static boolean more14(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int amountOf1 = 0;
        int amountOf4 = 0;
        for (int num : nums) {
            if (num == 1)
                amountOf1++;
            if (num == 4)
                amountOf4++;
        }
        return amountOf1 > amountOf4;
    }

    //Given a number n, create and return a new int array of length n, containing the numbers 0, 1, 2, ... n-1.
    private static int[] fizzArray(int n) {
        if (n == 0) return new int[0];
        int[] output = new int[n];
        for (int i = 0; i < output.length; i++)
            output[i] = i;
        return output;
    }

    //Given an array of ints, return true if every element is a 1 or a 4.
    private static boolean only14(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        for (int num : nums) {
            if (num != 1 && num != 4)
                return false;
        }
        return true;
    }

    //Return true if the array contains, somewhere, three increasing adjacent numbers like .... 4, 5, 6, ... or 23, 24, 25.
    private static boolean tripleUp(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] - 1 && nums[i + 1] == nums[i + 2] - 1)
                return true;
        }
        return false;
    }

    //For each multiple of 10 in the given array, change all the values following it to be that multiple of 10, until encountering another multiple of 10.
    private static int[] tenRun(int[] nums) {


        return nums;
    }

    //We'll say that an element in an array is "alone" if there are values before and after it, and those values are different from it.
    //Return a version of the given array where every instance of the given value which is alone is replaced by whichever value to its left or right is larger.
    private static int[] notAlone(int[] nums, int val) {
        if (nums.length <= 2) return nums;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == val) {
                if (nums[i - 1] != nums[i] && nums[i + 1] != nums[i])
                    nums[i] = Math.max(nums[i + 1], nums[i - 1]);
            }
        }
        return nums;
    }

    //We'll say that a value is "everywhere" in an array if for every pair of adjacent elements in the array, at least one of the pair is that value.
    //Return true if the given value is everywhere in the array.
    private static boolean isEverywhere(int[] nums, int val) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != val && nums[i + 1] != val)
                return false;
        }
        return true;
    }

    //Given an array of ints, return true if the value 3 appears in the array exactly 3 times, and no 3's are next to each other.
    private static boolean haveThree(int[] nums) {
        int amountOf3 = 0;
        for (int num : nums) {
            if (num == 3)
                amountOf3++;
        }
        if (amountOf3 != 3) return false;
//        for (int i = 1; i < nums.length - 1; i++) {
//            if (nums[i] == 3 && (nums[i - 1] == 3 || nums[i + 1] == 3))
//                return false;
//        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 3 && nums[i + 1] == 3) return false;
        }
        return true;
    }

    //Given an array of ints, return true if every 2 that appears in the array is next to another 2.
    private static boolean twoTwo(int[] nums) {
        if (nums.length == 0) return true;
        if (nums.length == 1 && nums[0] == 2) return false;
        if (nums[nums.length - 1] == 2 && nums[nums.length - 2] != 2) return false;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i - 1] != 2 && nums[i + 1] != 2)
                return false;
        }
        return true;
    }

    //Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}.
    //You may modify and return the given array, or return a new array.
    private static int[] shiftLeft(int[] nums) {
        if (nums.length <= 1) return nums;
        int first = nums[0];
        for (int i = 1; i < nums.length; i++) //System.arraycopy(nums, 1, nums, 0, nums.length - 1);
            nums[i - 1] = nums[i];

        nums[nums.length - 1] = first;
        return nums;
    }
}




