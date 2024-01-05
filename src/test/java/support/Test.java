package support;

import java.util.Map;
import java.util.*;

public class Test {

    public static void main(String[] args) {

        String string = "Hello world!";
        singleCharacter(string);

        int resCount = numberOfVowels(string);
        System.out.print("Number of vowels is " + resCount);

        System.out.println(countVowelsRegEx("WebDriver"));

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

        numbersUp(20);

        int[] arr = {5, 2, 9, 7, 3};
        arrayThatSwapElements(arr);

        int num3 = 5;
        printPyramid(num3);

        //Day10

        System.out.println(newReversedString("WebDriver"));

        String words = "the quick brown fox jumps over the lazy dog";
        printReversedWords(words);

        printSquareOfAtSymbols(5);

        printRightAngledTriangleOfAsterisks(5);

        printSquareOfNumbers(5);

        //Medium
        printTheFibonacciSequence();

        printReversedRightAngledTriangleOfAsterisks(5);

        printChessboardPattern(8);
        // printChessboard(8);

        //Advanced
        printDiamond(5);

        //Day11
        //Basic

        int[] arr1 = {99, 2, 3, 10, 16, 33, 42, 27, 9};

        System.out.println("\nThe max number in array is " + maxNumberInArray(arr1));

        palindromeNewString("Civic");
        palindromeNewString("Mother");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a year: ");

        int year = scanner.nextInt();

        isLeapYearOrNot(year);

        scanner.close();

        //Medium

        int [] array = {5,88,123,19,7,29,141,10};

        int [] arr2 = twoMaximumNumbersInArray(array);

        for (int number:arr2) {

            System.out.println("The maximum number in array is: " + number);
        }

       String data = "patrick feeney";

        convertNameIntoInitials(data);

        squareOfAsterisks(5);

        //Day13
        //1) Sort an array

        int [] numbers = {8,4,19,27,18,16,3,0};
        System.out.println(Arrays.toString(numbers));
        System.out.println("Sorting an array: "+ Arrays.toString(sortArray(numbers)));


        //2) Find if 2 elements of an array results in sum number
        int [] array1 = {7,0,1,3,8};
        int sum = 11;
        System.out.println("The sum of the two elements in array is equal " + sum + " = " + isSumNumberOfTwoNumbers(array1, sum));

        //3) Calculate X series of a potential equity curve in trading Y number of trades with certain trading capital Z, keeping in mind:
        // - position size % out of total trading capital
        // - success rate of a trader
        // - risk / reward ratio

        int tradeCount = 100;
        int initialTradingEquity = 1000;
        double positionSize = 0.02;
        double successRate = 0.50;
        int returnSuccess = 2;
        int seriesCount = 10;
        trades(seriesCount, tradeCount, initialTradingEquity, positionSize,successRate, returnSuccess);

        int [] array2 = {7,0,1,3,8,28};
        System.out.println("Print max number of " + Arrays.toString(array2));
        findMax(array2);

        SumOfEvenNumbers();

    }

     public static void SumOfEvenNumbers() {
        int sum = 0; // initialize sum to 0
            int count = 0; // initialize count to 0

            // loop through the first 100 even numbers
            for (int i = 2; count < 100; i += 2) {
                sum += i; // add the current even number to the sum
                count++; // increment the count
            }

            // print out the sum
            System.out.println("The sum of the first 100 even numbers is: " + sum);
        }


    static void findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1 ; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }

        }
        System.out.println(max);
    }

    //  3) Calculate X series of a potential equity curve in trading Y number of trades with certain trading capital Z, keeping in mind:
          //  - position size % out of total trading capital
// - success rate of a trader
// - risk / reward ratio


    static  void trades(int seriesCount, int tradesCount, int initialTradingEquity, double positionSize, double successRate, int returnSuccess){

        for (int series = 1; series <= seriesCount; series++){
            double tradingEquity = initialTradingEquity;
            for (int trade =1; trade<= tradesCount; trade++){
                double moneyInTrade = tradingEquity * positionSize;
                tradingEquity -= moneyInTrade;
                if(Math.random() < successRate){
                    tradingEquity += moneyInTrade * returnSuccess;
                }
            }
            System.out.println("Serie: " + series + ": " + Math.round(tradingEquity));
        }

    }
  static boolean isSumNumberOfTwoNumbers(int[] ar, int s) {


        for (int i = 0; i < ar.length-1; i++){
            for (int j = i + 1; j < ar.length; j++) {
                int resultSum = ar[i] + ar[j];
                if (resultSum == s) {
                    return true;
                }
            }

        }

        return false;

    }

    //Day13
    //Sort an array
    static int [] sortArray(int[] numb){

        int temp;

        for (int i = 0 ; i < numb.length-1; i++){
            for (int j = i + 1; j < numb.length; j++){
                if (numb[i] > numb[j]){
                    temp = numb[i];
                    numb[i]=numb[j];
                    numb[j] = temp;
                }
            }
        }

        return numb;
    }

      //Day11
    //Basic
    //1) Write a function to find max number in array

    static int maxNumberInArray(int[] arr) {

        int max = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }

        }
        return max;
    }

    //2) Find if a string a palindrome

    static void palindromeNewString(String word) {

        String reversedString = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversedString = reversedString + word.charAt(i);
        }

        if (word.equalsIgnoreCase(reversedString)) {

            System.out.println(word + " is a palindrome word");
        } else {

            System.out.println(word + " is not a palindrome word");
        }

    }

    //3) Write a Java program that prompts the user to enter a year and then prints whether the year is a leap year or not.
    //(hint for requesting data from user:
    //Scanner scanner = new Scanner(System.in);
    //int year = scanner.nextInt();
    //)
    //Leap Years are any year that can be exactly divided by 4 (such as 2016, 2020, 2024, etc)
    //except if it can be exactly divided by 100, then it isn't (such as 2100, 2200, etc)
    //except if it can be exactly divided by 400, then it is (such as 2000, 2400)


    static void isLeapYearOrNot(int year1) {

        boolean isLeapYear = false;

        if (year1 % 4 == 0) {
            isLeapYear = true;
        }
        if (year1 % 400 == 0) {
            isLeapYear = true;
        } else if (year1 % 100 == 0) {
            isLeapYear = false;
        }

        if (isLeapYear) {
            System.out.println(year1 + " is a leap year");
        } else {
            System.out.println(year1 + " is not a leap year");
        }
    }

    //4) Write a function to find two max numbers in array.


    static int [] twoMaximumNumbersInArray(int[] array1) {

        int max = 0;
        int max2 = 0;

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] > max) {
                max2 = max;
                max = array1[i];
            }
        }

        return new int[]{max,max2};

    }

    //5) Name to initial
    //   Write a function to convert a name into initials. Strictly takes two words with one space in between them.
    //   The output should be two capital letters with a dot separating them.
    //   It should look like this:
    //   Sam Harris => S.H
    //   patrick feeney => P.F
    static void convertNameIntoInitials(String data1) {

        String[] res = data1.split(" ");

        String data2 = data1.charAt(0) + ".";

        for (int i = 1; i < res.length; i++) {
            data2 = data2 + res[i].charAt(0);

        }

        System.out.println(data1 + " => " + data2.toUpperCase());

    }

    //Advanced
    //6) Print a follow square of asterisks
    //* * * * *
    //*       *
    //*       *
    //*       *
    //* * * * *

    static void squareOfAsterisks(int size) {

        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print("* ");
        }
        System.out.println();


        for (int i = 2; i < size; i++) {
            System.out.print("* ");
            for (int j = 2; j < size; j++) {
                System.out.print("  ");
            }
            System.out.println("* ");
        }


        for (int i = 0; i < size; i++) {
            System.out.print("* ");
        }
        System.out.println();

    }




    //Day10
    //Basic
    //1) Write a function that returns reversed string (do it again without looking at previous solution) Param - "Webdriver"
    static String newReversedString(String webDriver) {

        System.out.println();

        char[] chars = webDriver.toCharArray();

        String result = "";

        for (int i = chars.length - 1; i >= 0; i--) {

            result = result + chars[i];

        }

        return result;
    }

    //2) Print reversed words in a sentence (use sentence.split(" ")). Param -"the quick brown fox jumps over the lazy dog"

    static void printReversedWords(String words1) {

        String[] result = words1.split(" ");

        for (int i = result.length - 1; i >= 0; i--) {

            System.out.print(result[i] + " ");
        }
        System.out.println();

    }

    //3) Print a square of at symbols (@) (refer to the square of asterisks we did in class)
    //Example for size 5:
    //@ @ @ @ @
    //@ @ @ @ @
    //@ @ @ @ @
    //@ @ @ @ @
    //@ @ @ @ @

    static void printSquareOfAtSymbols(int size) {

        System.out.println();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                System.out.print("@ ");
            }

            System.out.println();
        }
    }


    //4) Print right-angled triangle of asterisks
    //example for size 5
    //*
    //* *
    //* * *
    //* * * *
    //* * * * *

    static void printRightAngledTriangleOfAsterisks(int n) {

        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {

                System.out.print("* ");
            }

            System.out.println();
        }

    }


    //5) Print a square of numbers with certain size
    //example for size 5:
    //1 1 1 1 1
    //2 2 2 2 2
    //3 3 3 3 3
    //4 4 4 4 4
    //5 5 5 5 5

    static void printSquareOfNumbers(int num) {

        System.out.println();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {

                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    //Medium
    //6) Print the Fibonacci sequence up to a given limit
    // (in Fibonacci sequence each number is the sum of the two preceding ones, example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144)

    static void printTheFibonacciSequence() {

        System.out.println();

        int first = 0;
        int second = 1;
        int sum;

        System.out.print(first + " ");

        for (int i = 0; i < 12; i++) {

            sum = first + second;
            first = second;
            second = sum;

            System.out.print(first + " ");
        }
    }

    //7) Print a reverse right-angled triangle of asterisks:
    //Example for size 5:
    //* * * * *
    //* * * *
    //* * *
    //* *
    //*


    static void printReversedRightAngledTriangleOfAsterisks(int num1) {

        System.out.println("\n");

        for (int i = num1; i >= 0; i--) {
            for (int j = i; j > 0; j--) {

                System.out.print("* ");
            }

            System.out.println();
        }


    }

    //8) Print chessboard pattern (remember % for even / odd switch)
    //Example:
    //X O X O X O X O
    //O X O X O X O X
    //X O X O X O X O
    //O X O X O X O X
    //X O X O X O X O
    //O X O X O X O X
    //X O X O X O X O
    //O X O X O X O X

    static void printChessboardPattern(int num2) {

        int f = 1;

        for (int i = 1; i <= num2; i++) {
            for (int j = 1; j <= num2; j++) {
                if (f == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("0 ");
                }
                f *= -1;

            }
            if (num2 % 2 == 0) {
                f *= -1;
            }
            System.out.println();
        }

    }


    static void printChessboard(int num3) {

        System.out.println();

        for (int i = 0; i < num3; i++) {
            for (int j = 0; j < num3; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("X ");
                } else {
                    System.out.print("0 ");
                }

            }

            System.out.println();
        }

    }

//Advanced

    //11) Print diamond of asterisks.
    static void printDiamond(int size) {

        //int size = 5; // Set the size of the diamond
        int spaces = size - 1;
        int stars = 1;

        System.out.println();

        // Print the top half of the diamond
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            System.out.println();
            spaces--;
            stars += 2;
        }

        // Print the bottom half of the diamond
        spaces = 1;
        stars = size * 2 - 3;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            System.out.println();
            spaces++;
            stars -= 2;
        }
    }


       /* 7) Write a function, accepts integer argument
    It should print all the numbers up to the argument
    BUT:
            if number is multiple of 3, it should print Fizz instead of number
if number is multiple of 5, it should print Buzz instead of number
if it is multiple of both 3 and 5, it should print FizzBuzz instead of number
    Result for 20:
            1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz

        */

    // Write a program that prints a pyramid made of asterisks to the console.
    // The program should prompt the user for the height of the pyramid and then use a for loop to print the pyramid.
    // For example, if the user enters a height of 5, the program should print the following pyramid:


    static void printPyramid(int num) {

        System.out.println();

        int c = 0;

        for (int i = 1; i <= num; ++i, c = 0) {
            for (int j = 1; j <= num - i; ++j) {
                System.out.print(" ");
            }

            while (c != 2 * i - 1) {
                System.out.print("*");
                ++c;
            }
            System.out.println();
        }

        //System.out.println();

    }

    public static void numbersUp(int n) {

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Buzz ");
            } else if (i % 5 == 0) {
                System.out.print("Fizz ");
            } else {
                System.out.print(i + " ");
            }
        }

    }


    // Basic:
    // 1) Print every second character in a string on a single line using a for loop (hint - use str.charAt(i))

    public static void singleCharacter(String string1) {

        System.out.println();

        for (int i = 1; i < string1.length(); i = i + 2) {
            System.out.println(string1.charAt(i) + " ");
        }

    }


    //2) Write a function that counts the number of vowels (a, e, i, o, u) in a string using a for loop and returns the value

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

    static int countVowelsRegEx(String string2) {

        String vowels = string2.replaceAll("[^aeiou]", "");
        System.out.println(vowels);
        return vowels.length();
    }

    //3) Write a function that reverses a string using a for loop and returns the value

    public static String reverseString(String string3) {
        System.out.println();

        char[] chars = string3.toCharArray();

        String res = " ";

        for (int i = chars.length - 1; i >= 0; i--) {
            res = res + chars[i];
        }
        return res;
    }


    //4) Remove all spaces from a string using a for loop and return the value
    public static String removeAllSpaces(String str) {

        String res = " ";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                res = res + str.charAt(i);
            }
        }
        return res;

    }


    //Medium:

    // 5) Check if a string is a palindrome using a for loop (palindrome is a word that read the same forward and backward, like racecar, mam, noon, etc.)

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


    // 6) Find the longest word in a string using a for loop

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

    //7) Convert a sentence to title case using a for loop

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


    //8) Count the occurrences of each letter in a string using a for loop (hint - character range from a to z is (ch >= 'a' && ch <= 'z'). Use char primitive type (same type returned by charAt())

    private static void countOccurrencesLetter(String str) {

        // Creating a HashMap containing char
        // as a key and occurrences as  a value
        Map<Character, Integer> charCountMap

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

    public static void arrayThatSwapElements(int[] arr1) {

        System.out.println();

        // int[] arr = {5, 2, 9, 7, 3};
        int temp = 0;

        for (int i = 0; i < arr1.length; i++) {

            temp = arr1[2];
            arr1[2] = arr1[4];
            arr1[4] = temp;

            System.out.print(arr1[i] + " ");

        }
    }
}
