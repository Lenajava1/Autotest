package support;


import io.cucumber.plugin.event.Node;

import java.util.*;

public class Challenges {

    public static void main(String[] args) {
        System.out.println("Coding Challenges\n\n");
        System.out.println("Exercise 1");
        Integer[] arr1 = {3, 5, 1, 6, 8, 5, 1};

        String[] arr2 = {"pear", "apple", "orange"};

        System.out.println();
        Integer[] arr3 = {0, 2, 4, 7, 8, 5, 8, 10};
        Integer[] arr4 = {3, 5, 1, 6, 5, 8, 11, 0};

        printArray(arr1);
        System.out.println();
        printArray(arr2);
        System.out.println();
        printEvery3rdElement(arr3);
        System.out.println();
        printMultiplesDf3(arr4);
        System.out.println();
        printEvery3dElementV3(arr4);

        System.out.println();

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        printNumbers();
        calculateSum();
        countDown();
        squareNumbers(numbers);

        String strings = "Reverse sentence";
        reverseWords(strings);
        //multiplicationTable(9);

        int limit = 10;
        multiplicationTableTill(limit);
        System.out.println();

        int size = 8;
        printSquare(size);

        System.out.println("return factorial of a number");

        int num1 = 10;
        System.out.println("Factorial of " + num1 + " is " + factorial(num1));
        System.out.println("Factorial of " + num1 + " is " + factorialRecursive(num1));

        String string = "Hello world!";
        singleCharacter(string);

        int resCount = numberOfVowels(string);
        System.out.print("Number of vowels is " + resCount);

        String result = reverseString(string);
        System.out.println(result);

        String newString = "Success usually comes to those who are too busy looking for it";
        System.out.println(removeAllSpaces(newString));

        String str = "level";
        palindrome(str);

        String quote = "experience is a hard teacher because she gives the test first, the lesson afterwards";
        String maxWord = theLongestWordInString(quote);
        System.out.println("The longest word in a string is " + maxWord);
        System.out.println("The length of word is " + maxWord.length());

        String titleCaseString = convertToTitleCase(quote);
        System.out.println(titleCaseString);

        String occurrence = "experience";
        countOccurrencesLetter(occurrence);

        int num2 = 21;
        int num3 = 23;
        int num4 = 0;
        int num5 = 263;
        System.out.println("Find if a number " + num2 + " is prime number");
        System.out.println(isPrime(num2));
        //System.out.println(isPrime(num3));
        //System.out.println(isPrime(num4));
        //System.out.println(isPrime(num5));
        //System.out.println("Find if a number " + num3+ " is prime number");

        int n = 1000;
        System.out.println("Print all prime numbers up to the number n");
        printPrimes(n);

        int[] arr5 = {};
        int[] arr6 = {3, 1, 4, 9, 6, 1};
        //sort an array

        System.out.println(isEmpty(arr5));
        System.out.println(isEmpty(arr6));


        //Day13
        System.out.println("Sorting array: " + Arrays.toString(arr6));
        System.out.println(Arrays.toString(sort(arr6)));

        System.out.println();
        String toBeMascked1 = "1234567890464664646";
        String toBeMascked2 = "65466354543545455456";
        String toBeMascked3 = "1";
        String toBeMascked4 = "";
        System.out.println(maskify(toBeMascked1));
        System.out.println(maskify(toBeMascked2));
        System.out.println(maskify(toBeMascked3));
        System.out.println(maskify(toBeMascked4));

        String[] array = {"312432542352335325", "547547573453735", "343434", "9876"};
        for (String s : array) {
            System.out.println(maskify(s));
        }


        String str15 = "WebDriver";
        System.out.println(reverseNoExtraVar(str15));


        //Day 19
        //a) Write a program that calculates and prints out the sum of the first 100 even numbers.
        printOutSumEvenNumb();

        //b) Write a program that calculates and prints out the sum of the first 10 square numbers.

        sumOfFirstSquareNum();

        //c) Write a program that asks the user for a number and then prints out whether that number
        // is a perfect square or not. A perfect square is a number that can be expressed as the product of an integer
        // by itself or as the second exponent of an integer. For example, 25 is a perfect square because it is the product
        // of integer 5 by itself, 5 × 5 = 25. However, 21 is not a perfect square number because it cannot be expressed as
        // the product of two same integers.


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter any number: ");
        int numb = scanner.nextInt();
        isNumberPerfectSquare(numb);

        //d) Write a program that finds and prints out all the perfect numbers between 1 and 1000.
        // A perfect number is a positive integer that is equal to the sum of its proper divisors (excluding itself).

        findAllPerfectNumb();


        int [] arr = {5, 23, 53, 69, 71, 98, 99};
        int el = 23;
        System.out.println(binarySearch(arr, el));


    }

     static void findAllPerfectNumb() {

        for (int i = 1 ; i <=1000; i++){
            int sum = 0;
            for (int j = 1 ; j <= i/2; j++){
                if (i % j == 0){
                    sum+=j;
                }
            }
            if (sum == i){
                System.out.println(i + " ");
            }
        }



    }


    static void isNumberPerfectSquare(int n) {

        int square = (int) Math.sqrt(n);

        if (square * square == n) {
            System.out.println("The number " + n + " is a Perfect Square");
        } else {
            System.out.println("The number " + n + " is not a Perfect Square");
        }

    }

    //b) Write a program that calculates and prints out the sum of the first 10 square numbers.
    private static void sumOfFirstSquareNum() {

        int sum = 0;
        int count = 0;

        for (int i = 1; i <= 10; i++) {
            int square = i * i;
            sum += square;
            count++;
        }

        System.out.println("The sum of first " + count + " square numbers is: " + sum);

    }


    //a) Write a program that calculates and prints out the sum of the first 100 even numbers.
    private static void printOutSumEvenNumb() {

        int sum = 0;
        int count = 0;

        for (int i = 2; count < 100; i += 2) {
            sum += i;
            count++;
        }
        System.out.println("The sum of first " + count + " even numbers is: " + sum);
    }

    static String reverseNoExtraVar(String str) {
        // String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            str += str.charAt(i);
        }
        return str.substring(str.length() / 2);
    }

    static String maskify(String str) {
        if (str.length() < 4) {
            return str;
        }
        String result = "";
        for (int i = 0; i < str.length() - 4; i++) {
            result += "#";
        }
        result += str.substring(str.length() - 4);

        return result;
    }

    static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    static void printSquare(int size) {

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }


    static void multiplicationTableTill(int limit) {

        //int num = 5;

        for (int i = 1; i <= limit; i++) {

            for (int j = 1; j <= 10; j++) {
                System.out.print(i + " x " + j + " = " + i * j + "\t\t");

            }
            System.out.println();
        }
    }

    static void printPrimes(int limit) {

        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    static boolean isPrime(int num) {

        System.out.println("Find if a number " + num + " is prime number");
        if (num < 2) {
            return false;
        }
        if (num != 2 && num % 2 == 0) {
            return false;
        }

        for (int i = 3; i < Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;

            }

        }
        return true;
    }

    //Count the occurrences of each letter in a string using a for loop (hint - character range from a to z is (ch >= 'a' && ch <= 'z'). Use char primitive type (same type returned by charAt())
    private static void countOccurrencesLetter(String str) {

        // Creating a HashMap containing char
        // as a key and occurrences as  a value
        HashMap<Character, Integer> charCountMap
                = new HashMap<Character, Integer>();

        // Converting given string to char array

        char[] strArray = str.toCharArray();

        // checking each char of strArray
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {

                // If char is present in charCountMap,
                // incrementing it's count by 1
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {

                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                charCountMap.put(c, 1);
            }
        }

        // Printing the charCountMap
        for (Map.Entry entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    //Convert a sentence to title case using a for loop
    public static String convertToTitleCase(String s) {

        String[] words = s.split(" ");
        String[] words1 = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            words1[i] = words[i].toUpperCase();
        }

        for (int i = 0; i < words1.length; i++) {

            words1[i] = words1[i].charAt(0) + words1[i].substring(1).toLowerCase();

        }
        String res = String.join(" ", words1);

        return res;
    }

    //Find the longest word in a string using a for loop
    public static String theLongestWordInString(String string) {

        String[] words = string.split(" ");

        String result = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > result.length()) {
                result = words[i];

            }
        }
        return result;
    }

    //Check if a string is a palindrome using a for loop (palindrome is a word that read the same forward and backward, like racecar, mam, noon, etc.)
    public static void palindrome(String str) {

        String res = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i);

        }

        if (str.equals(res)) {
            System.out.println("The string " + str + " is a palindrome");
        } else {
            System.out.println("The string " + str + " is not a palindrome");
        }

    }

    //Remove all spaces from a string using a for loop and return the value
    public static String removeAllSpaces(String str) {

        String res = " ";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                res = res + str.charAt(i);
            }
        }
        return res;

    }

    //Write a function that reverses a string using a for loop and returns the value
    public static String reverseString(String string3) {
        System.out.println();

        char[] chars = string3.toCharArray();

        String res = " ";

        for (int i = chars.length - 1; i >= 0; i--) {
            res = res + chars[i];
        }
        return res;
    }

    //Write a function that counts the number of vowels (a, e, i, o, u) in a string using a for loop and returns the value
    public static int numberOfVowels(String string2) {

        System.out.println();

        int count = 0;

        for (int i = 0; i < string2.length(); i++) {
            if (string2.charAt(i) == 'e' || string2.charAt(i) == 'o' || string2.charAt(i) == 'i' || string2.charAt(i) == 'u' || string2.charAt(i) == 'y') {
                count++;
                System.out.println(string2.charAt(i));
            }
        }

        return count;

    }

    // Print every second character in a string on a single line using a for loop (hint - use str.charAt(i))
    public static void singleCharacter(String string1) {

        System.out.println();

        for (int i = 1; i < string1.length(); i = i + 2) {
            System.out.println(string1.charAt(i) + " ");
        }

    }

    public static void printArray(Object[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void printEvery3rdElement(Object[] arr) {
        for (int i = 2; i < arr.length; i = i + 3) {
            //if ((i+1) % 3 == 0) {
            System.out.print(arr[i] + " ");
            //}
        }
    }

    static void printMultiplesDf3(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 3 == 0 && arr[i] != 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    static void printEvery3dElementV3(Integer[] arr) {
        for (int i = 2; i < arr.length; i = i + 3) {
            //if (arr[i] % 3 == 0 && arr[i]!=0) {
            System.out.print(arr[i] + " ");
            //}
        }
        System.out.println();
    }

    //1) Print numbers from 2 to 20 using a for loop with a step 2
    public static void printNumbers() {

        for (int i = 1; i <= 20; i = i + 2) {

            System.out.print(i + " ");
        }

    }

    //2) Calculate the sum of the numbers from 1 to 100 using a for loop
    public static void calculateSum() {

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println();
        System.out.print("Sum of the numbers from 1 to 100 is " + sum + " ");
        System.out.println();
    }

    //3) Print the numbers from 10 down to 1 using a for loop
    public static void countDown() {

        for (int i = 10; i > 0; i--) {

            System.out.print(i + " ");

        }

    }

    //4) Print the first 10 square numbers using a for loop
    public static void squareNumbers(Integer[] numbers) {

        System.out.println();
        int res = 1;
        for (int i = 0; i < numbers.length / 2; i++) {
            res = numbers[i] * 2;
            System.out.print(res + " ");
        }

    }

    //5) Write a function that reverses words in a sentence
    public static void reverseWords(String strings) {
        System.out.println();
        StringBuilder stringBuilder = new StringBuilder(strings);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }

    //6) Print the multiplication table for a given number using a for loop
    public static void multiplicationTable(int n1) {

        System.out.println();

        for (int i = 1; i <= 10; i++) {
            System.out.println(n1 + " * " + i + " = " + (n1 * i));
        }
    }

    //5! =1*2*3*4*5
    //0! =1
    //n! = n*(n-1)..*1

    static int factorial(int num) {

        int factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    static int factorialRecursive(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorialRecursive(num - 1);

    }

    static boolean isEmpty(int[] arr) {
        if (arr != null && arr.length > 0) {
            return false;
        } else {
            return true;
        }
    }

    static boolean binarySearch(int [] arr, int el) {

        System.out.println("\nArray length " + arr.length);
        int low = 0;
        int high = arr.length - 1;
        for (int i = 1; low <= high; i++) {
            //while (low <= high) {
            System.out.println("iteration " + i);
            int mid = (low + high) / 2;

            if (el == arr[mid]) {
                return true;
            } else if (el > arr[mid]) {
                low = mid + 1;
            } else if (el <= arr[mid]) {
                high = mid - 1;
            }
        }
        return false;
    }




}
