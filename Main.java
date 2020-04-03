import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] array = {1, 0, 0, 1};
        //System.out.println(findTheBiggest(array));
        //System.out.println(findTheSmallest(array));
        //System.out.println(sum67v2(array));
        //System.out.println(bigDiff(array));
        //System.out.println(sum13(array));
        //System.out.println(Arrays.toString(tenRun(array)));
        //System.out.println(sameEnds(array, 2));
        System.out.println(" -> " + Arrays.toString(zeroFront(array)));


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
        int[] outputList = new int[n];
        for (int i = 0; i < outputList.length; i++)
            outputList[i] = i;
        return outputList;
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

    //Given a number n, create and return a new string array of length n, containing the strings "0", "1" "2" .. through n-1.
    private static String[] fizzArray2(int n) {
        if (n <= 0) return new String[0];;
        String[] outputList = new String[n];
        for (int i = 0; i < n; i++)
            outputList[i] = String.valueOf(i);
        return outputList;
    }

    //Given an array of ints, return true if the array contains either 3 even or 3 odd values all next to each other.
    private static boolean modThree(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if ((nums[i] % 2 == 0 && nums[i + 1] % 2 == 0 && nums[i + 2] % 2 == 0) || (nums[i] % 2 != 0 && nums[i + 1] % 2 != 0 && nums[i + 2] % 2 != 0))
                return true;
        }
        return false;
    }

    //Return true if the group of N numbers at the start and end of the array are the same.
    //For example, with {5, 6, 45, 99, 13, 5, 6}, the ends are the same for n=0 and n=2, and false for n=1 and n=3.
    private static boolean sameEnds(int[] nums, int len) { //(*)
        int frontSum = 0;
        int endSum = 0;
        for (int i = 0; i < len; i++)
            frontSum = frontSum + nums[i];
        for (int i = nums.length - 1; i >= nums.length - len; i--)
            endSum = endSum + nums[i];

        System.out.println(frontSum);
        System.out.println(endSum);
        return frontSum == endSum;
    }

//    public boolean sameEnds(int[] nums, int len) {
//        for(int i = 0; i < len; i++) {
//            if(nums[i] != nums[nums.length - len + i])
//                return false;
//        }
//
//        return true;
//    }

    //Return a version of the given array where all the 10's have been removed.
    //The remaining elements should shift left towards the start of the array as needed, and the empty spaces a the end of the array should be 0. So {1, 10, 10, 2} yields {1, 2, 0, 0}.
    private static int[] withoutTen(int[] nums) { //(*)
        List<Integer> outputList = new ArrayList<>();
        List<Integer> no10Indexes = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for (Integer num : nums)
            numsList.add(num);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 10)
                no10Indexes.add(i);
        }

        for (int i = 0; i < numsList.size(); i++) {
            if (i < no10Indexes.size())
                outputList.add(numsList.get(no10Indexes.get(i)));
            else
                outputList.add(0);
        }

        return outputList.stream().mapToInt(i->i).toArray();
    }

//    public int[] withoutTen(int[] nums) {
//        int i = 0;
//
//        while(i < nums.length && nums[i] != 10)
//            i++;
//
//        for(int j = i + 1; j < nums.length; j++) {
//            if(nums[j] != 10) {
//                nums[i] = nums[j];
//                nums[j] = 10;
//                i++;
//            }
//        }
//
//        for( ; i < nums.length; i++)
//            nums[i] = 0;
//
//        return nums;
//    }

    //Given a non-empty array of ints, return a new array containing the elements from the original array that come before the first 4 in the original array.
    //The original array will contain at least one 4.
    private static int[] pre4(int[] nums) {
        if (nums.length == 0) return new int[0];

        int outputLength = 0;
        boolean first4Appearance = false;

        for (int num : nums) {
            if (!first4Appearance && num != 4)
                outputLength++;
            else
                first4Appearance = true;
        }

        if (!first4Appearance) return new int[0];

        int[] output = new int[outputLength];
        for (int i = 0; i < outputLength; i++)
            output[i] = nums[i]; //System.arraycopy(nums, 0, output, 0, outputLength);

        return output;
    }

    //Given a non-empty array of ints, return a new array containing the elements from the original array that come after the last 4 in the original array.
    //The original array will contain at least one 4.
    private static int[] post4(int[] nums) {
        int last4Index = 0;
        boolean last4Appearance = false;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if (!last4Appearance && nums[i] == 4) {
                last4Index = i;
                last4Appearance = true;
            }
        }
        int[] output = new int[nums.length - last4Index - 1];
        for (int i = 0; i < nums.length - last4Index - 1; i++) {
            output[i] = nums[i + last4Index + 1];
        }
        return output;
    }

    //Return an array that contains the exact same numbers as the given array, but rearranged so that all the zeros are grouped at the start of the array.
    private static int[] zeroFront(int[] nums) {
        int[] output = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num == 0) {
                output[index] = 0;
                index++;
            }
        }
        for (int num : nums) {
            for (int j = index; j < output.length; j++) {
                if (num != 0)
                    output[j] = num;
            }
        }
        return output;
    }

    //Given arrays nums1 and nums2 of the same length, for every element in nums1, consider the corresponding element in nums2 (at the same index).
    //Return the count of the number of times that the two elements differ by 2 or less, but are not equal.
    private static int matchUp(int[] nums1, int[] nums2) {
        int counter = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i] && Math.abs(nums1[i] - nums2[i]) <= 2)
                counter++;
        }
        return counter;
    }

    //Given an array of ints, return true if it contains no 1's or it contains no 4's.
    private static boolean no14(int[] nums) {
        boolean has1 = false;
        boolean has4 = false;
        for (int num : nums) {
            if (num == 1)
                has1 = true;
            if (num == 4)
                has4 = true;
        }
        return !has1 || !has4;
    }

    //Given an array of ints, return true if the array contains a 2 next to a 2 or a 4 next to a 4, but not both.
    private static boolean either24(int[] nums) {
        boolean has22 = false;
        boolean has44 = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2)
                has22 = true;
            else if (nums[i] == 4 && nums[i + 1] == 4)
                has44 = true;
        }
        return has22 != has44; //(has22 || has44) && !(has22 && has44);
    }

    //Given an array of ints, return true if the array contains two 7's next to each other, or there are two 7's separated by one element, such as with {7, 1, 7}.
    private static boolean has77(int[] nums) {
        boolean hasTwo7 = false;
        boolean hasTwoSeparated7 = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 7 && nums[i + 1] == 7)
                hasTwo7 = true;
        }
        for (int i = 0; i < nums.length -2; i++) {
            if (nums[i] == 7 && nums[i + 2] == 7)
                hasTwoSeparated7 = true;
        }
        return hasTwo7 || hasTwoSeparated7;
    }

    //Given an array of ints, return true if there is a 1 in the array with a 2 somewhere later in the array.
    private static boolean has12(int[] nums) {
        int oneIndex = -1;
        int twoIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                oneIndex = i;
            if (nums[i] == 2)
                twoIndex = i;
        }
        return oneIndex != -1 && twoIndex != -1 && oneIndex < twoIndex;
    }

    private static boolean has12V2(int[] nums) {
        boolean found1 = false;
        for (int num : nums) {
            if (num == 1)
                found1 = true;
            if (found1 && num == 2)
                return true;
        }
        return false;
    }

    //Given start and end numbers, return a new array containing the sequence of integers from start up to but not including end, so start=5 and end=10 yields {5, 6, 7, 8, 9}.
    private static int[] fizzArray3(int start, int end) {
        if (start >= end) return new int[0];
        int[] output = new int[end - start];
        int index = 0;
        for (int i = start; i < end; i++) {
            output[index] = i; //output[i - start] = i
            index++;
        }
        return output;
    }

    //Return an array that contains the exact same numbers as the given array, but rearranged so that all the even numbers come before all the odd numbers.
    private static int[] evenOdd(int[] nums) {
        //if (nums.length == 0) return new int[0];
        int[] output = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num  % 2 == 0) {
                output[index] = num;
                index++;
            }
        }
        for (int num : nums) {
            if (num % 2 != 0) {
                output[index] = num;
                index++;
            }
        }
        return output;
    }

    //Consider the series of numbers beginning at start and running up to but not including end, so for example start=1 and end=5 gives the series 1, 2, 3, 4.
    //Return a new String[] array containing the string form of these numbers, except for multiples of 3, use "Fizz" instead of the number, for multiples of 5 use "Buzz", and for multiples of both 3 and 5 use "FizzBuzz".
    private static String[] fizzBuzz(int start, int end) {
        if (start >= end) return new String[0];
        String[] output = new String[end - start];
        for (int i = start; i < end; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                output[i - start] = "FizzBuzz";
            else if (i % 3 == 0)
                output[i - start] = "Fizz";
            else if (i % 5 == 0)
                output[i - start] = "Buzz";
            else
                output[i - start] = String.valueOf(i);
        }
        return output;
    }


}