package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Animal;
import pages.Cat;
import pages.Dog;

import java.util.*;

import static support.TestContext.getDriver;

public class JavaStepsDefs {

    @Given("I say hello world")
    public void iSayHelloWorld() {
        System.out.println("Hello World!");

        String str1 = "Hello there";
        String name = "John";
        System.out.println(str1 + " " + name);
    }

    @And("I say {string}")
    public void iSay(String str) {
        System.out.println(str + " John");

        System.out.println(str.getClass());
        System.out.println(str.length());
        System.out.println(str.toUpperCase());
        System.out.println(str);
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {

        // 1) Print those variables into console as they are

        //str1 = "Execute Java autotest!";
        //str2 = "Java";
        System.out.println(str1 + " " + str2);

        //2) Print those variables uppercase into console

        String s = str1.toUpperCase();
        String s1 = str2.toUpperCase();
        System.out.println(s);
        System.out.println(s1);

        //3) Print those variables length into console

        System.out.println("The length of first phrase is " + s.length());
        System.out.println("The length of second phrase is " + s1.length());
        System.out.println(str1.equals(str2));
        System.out.println("str1 == str2: " + (str1 == str2));

        //4) Print result of exact comparison of those variables into console

        int res = s.compareTo(s1);

        System.out.println("The result of exact comparison is " + res);

        //5) Print result of exact comparison ignoring cases of those variables into console

        System.out.println(str1.toUpperCase().equals(str2.toUpperCase()));

        boolean r = str1.equalsIgnoreCase(str2);

        System.out.println("The result of exact comparison ignoring cases " + r);

        //6) Print result of partial comparison of those variables into console – if first
        //variable contains second


        if (str1.contains(str2)) {
            System.out.println("Is the first variable contains second? Result: Yes");
        } else {
            System.out.println("Is the first variable contains second? Result: No");
        }
    }

    @And("How many people live on the Earth now?")
    public void howManyPeopleLiveOnTheEarthNow() {

        String s, s1, s2;
        s = "How many people";
        s1 = "live on";
        s2 = "the Earth now?";

        System.out.println(s + " " + s1 + " " + s2);

    }

    @Then("the answer is {string}")
    public void theAnswerIs(String arg0) {

        int q = 8;
        String a = "billion";

        System.out.println(q + " " + a);

    }

    @Given("I create new sentence {string}")
    public void iCreateNew(String arg0) {

        String s = "a good day!";
        String res = s.replaceAll("good", "nice");
        System.out.println("Have " + res);

    }

    @Given("I work with numbers")
    public void iWorkWithNumbers() {
        int i = 5;
        double price = 5.5;
        price = price - 0.5;

        System.out.println(i);
        System.out.println(price);
        System.out.println(i == price);

        Double priceInDouble = 5.5;

        Integer inInteger = 5;
        Integer anInteger = 5;

        System.out.println(inInteger == anInteger);
        System.out.println(inInteger.equals(priceInDouble));
        System.out.println(10 / 3.);
        System.out.println(10 / 3.0f);

        //23, 3, 235, 6326, 263
        //5,263
        //3,235,263

        System.out.println(10 % 3);

    }

    @Given("I work with conditions")
    public void iWorkWithConditions() {
        int i = 5;
        int j = 2;

        if (i < 2) {
            System.out.println("variable is less than 2");
        } else if (i == 2) {
            System.out.println("variable equals 2");
        } else {
            System.out.println("variable larger than 2");
        }

        String city = "New York";

        if (city.equals("New York")) {
            System.out.println("I'm live in New York");
        } else if (city.equals("Chicago")) {
            System.out.println("I'm live in Chicago");
        } else if (city.equals("San Francisco")) {
            System.out.println("Unknown city!");
        }

        switch (city) {
            case "New York":
                System.out.println("I'm in New York");
                break;
            case "Chicago":
                System.out.println("I'm live in Chicago");
                break;
            case "San Francisco":
                System.out.println("I'm live in Chicago");
                break;
            default:
                System.out.println("Unknown city!");
        }
    }

    @Given("I print url for {string} page")
    public void iPrintUrlForPage(String site) {

        switch (site) {
            case "ecosia":
                System.out.println("https://www.ecosia.org");
                break;
            case "google":
                System.out.println("https://www.google.com");
                break;
            case "sample":
                System.out.println("https://skryabin.com/webdriver/html/sample.html");
                break;
            case "bing":
            case "yahoo":
            case "quote":
                System.out.println("https://www." + site + ".com");
                break;
            default:
                System.out.println("Undefined");
        }
        if (site.contains("quote")) {
            System.out.println("https://skryabin.com/webdriver/html/sample.html");
        } else if (site.equals("google") || (site.equals("bing"))) {
            System.out.println("https://www." + site + ".com");
        } else {
            System.out.println("Unknown site");
        }

    }

    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int arg0) {

        if (arg0 > 0) {
            System.out.println("Number is positive");
        } else if (arg0 < 0) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Number is 0");
        }

    }

    @And("I print {int} day of week")
    public void iPrintThDayOfWeek(int seq) {

        switch (seq) {
            case 1 -> System.out.println("Sunday");
            case 2 -> System.out.println("Monday");
            case 3 -> System.out.println("Tuesday");
            case 4 -> System.out.println("Wednesday");
            case 5 -> System.out.println("Thursday");
            case 6 -> System.out.println("Friday");
            case 7 -> System.out.println("Saturday");
            default -> System.out.println("Incorrect entry. need 1 to 7");

        }
    }

    @And("I work with arrays")
    public void iWorkWithArrays() {
        System.out.println("int array:");
        int a = 5;
        int[] nums;
        nums = new int[]{2, 9, 5, 3, 5, 8, 12};
        nums[0] = 3;
        int arrayLength = nums.length;
        System.out.println("Length is " + arrayLength);
        System.out.println("last element of an array is " + nums[arrayLength - 1]);


        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int i = 0; i < arrayLength; i++) {
            //nums[i]=0;
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("String array:");
        String[] fruits = {"apple", "pear", "plum"};
        fruits[0] = "qiwi";
        System.out.println(fruits[0]);
        System.out.println(fruits[fruits.length - 1]);
        for (String str : fruits) {
            System.out.print(str + " ");
        }
        System.out.println("\n---------------");
        for (int i = 0; i < fruits.length; i++) {
            System.out.print(fruits[i] + " ");
        }
        System.out.println();
        System.out.println("\n");

        List<String> fruitslist = new ArrayList<String>();
        //Arrays.asList("apple","pear","plum");
        fruitslist.add(0, "pineapple");
        fruitslist.add(1, "orange");
        fruitslist.add(2, "pear");
        fruitslist.set(0, "kiwi");
        fruitslist.add(3, "apple");
        System.out.println(fruitslist.get(0));
        System.out.println(fruitslist.get(fruitslist.size() - 1));
        for (String fruit : fruitslist) {
            System.out.println();
            System.out.print(fruit + " ");
        }

        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(4);
        list.add(7);
        list.set(1, 9);
        System.out.println();
        System.out.println("Size of list is " + list.get(list.size() - 1));
        for (Integer iItem : list) {
            System.out.print(iItem + " ");
        }


    }

    @Given("I solve coding challenges")
    public void iSolveCodingChallenges() {

        System.out.println("Coding challenges");

    }

    @And("I write a function that prints all numbers from {int} up to {int}")
    public void iWriteAFunctionThatPrintsAllNumbersFromUpTo(int n, int n1) {

        //1) Write a function that prints all numbers from 0 up to n

        int[] num = new int[n1+1];

        for (int i = 0; i < num.length; i++) {
            num[i] = i;
        }

        for (Integer number : num) {
            System.out.print(number + " ");
        }
    }

    @And("I write a function that supports also negative numbers")
    public void iWriteAFunctionThatSupportsAlsoNegativeNumbers() {

        // 2) Write a function that supports also negative numbers

        int[] num = {-2, -1, -5, -6, -7, -12, -15};

        System.out.println("This function supports negative numbers");

        for (Integer number : num) {
            System.out.print(number + " ");
        }
    }

    @And("I write a function that prints all integer array")
    public void iWriteAFunctionThatPrintsAllIntegerArray() {
        int[] num = {8, 3, 2, 1, 16};

        System.out.println("\nThis function prints all integer array");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }

    @And("I write a function that prints all even numbers from integer array")
    public void iWriteAFunctionThatPrintsAllEvenNumbersFromIntegerArray() {

        int[] num = {0, 13, 7, 2, 8, 16, 47, 6, 9};

        System.out.println("This function prints all even numbers from integer array");

        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                System.out.print(num[i] + " ");
            }
        }
        System.out.println();
    }

    @And("I write a function that checks if array is empty")
    public void iWriteAFunctionThatChecksIfArrayIsEmpty() {

       List<String> str = new ArrayList<>();

        //str.add("blueberry");
        System.out.println();

            if (str.isEmpty()) {
                System.out.println("This array is empty");
        }else{
                System.out.println("The array is not empty");
            }
        System.out.println();
    }

    @And("I write a function that checks if array contains another element")
    public void iWriteAFunctionThatChecksIfArrayContainsAnotherElement() {

        int [] intArray = {3,4, 6,7};
        int el = 7;

        for (int i=0 ; i <intArray.length; i++){
            if (intArray[i]==el){
                System.out.println("array contains another element");
            }else {
                System.out.println("array is not contain another element");
            }
        }

        List <String> str = new ArrayList<>();

        str.add(0,"one");
        str.add(1,"three");
        str.add(2,"five");

        String str1 = "abcd";
        System.out.println(str1.length());
        System.out.println(str1.charAt(0));
        System.out.println(str1.length()-1);

        List<Integer> intList1 = new ArrayList<>();
        LinkedList <Integer> linklist = new LinkedList<>();

        for (int i = 0; i < str.size()-1; i++) {
            if (str.contains("five")) {
                System.out.println("Array contains another element");
            }else{
                System.out.println("Array is not contain another element");
            }
            break;
        }
        System.out.println();
    }


    @And("I work with maps")
    public void iWorkWithMaps() {
        Map<String,String> user1 = new HashMap<>();

        user1.put("username","jdoe");
        user1.put("firstname","Jhon Djode");
        user1.put("address","123 Main st");
        user1.put("phone","123-456-789");
        user1.put("email","jdoe@test.com");

        Map<String,String> user2 = new LinkedHashMap<>();

        user2.put("username","jdoe");
        user2.put("firstname","Jhon Djode");
        user2.put("address","123 Main st");
        user2.put("phone","123-456-789");
        user2.put("email","jdoe@test.com");

        Set<String> set = new LinkedHashSet<>(); // all values unic
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("two");
        for (String value:set){
            System.out.println(value+ " ");
        }

        //for (String data:user){
           // System.out.println(data + " ");
       // }
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user1.get("username"));
        System.out.println(user1.get(user1.size()-1)); // last element

        Set<String> userKeys = user1.keySet();
        Set<String> userKeys2 = user2.keySet();

        System.out.println(userKeys);
        System.out.println(userKeys2);

        for (String value: user1.values()){
            System.out.println(value + " ");
        }
       // Map <String, List<String> > map1 = new HashMap<>();

        WebDriver driver = new ChromeDriver();
        //driver.get();
        getDriver().getTitle();
        getDriver().getCurrentUrl();
        getDriver().getPageSource();
        getDriver().close();
        getDriver().quit();

    }

   @Given("array that swap elements")
        public void arrayThatSwapElements(){

        int[] arr = {5, 2, 9, 7, 3};
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {

            temp = arr[2];
            arr[2] = arr[4];
            arr[4] = temp;

            System.out.print(arr[i] + " ");

        }
    }

    @And("I write a function that accepts integer number and prints")
    public void iWriteAFunctionThatAcceptsIntegerNumberAndPrints() {

        int [] arr1 = {6,7,21,4,12,10,16,24};

        System.out.println();

        for (int i=0; i<arr1.length;i++){
            if (arr1[i] % 3 ==0 && arr1[i] % 4 !=0){
                System.out.println(arr1[i] + " divisible by 3");
            } if (arr1[i] % 4 ==0 && arr1[i] % 3!=0) {
                System.out.println(arr1[i] + " divisible by 4");
            } if (arr1[i] % 3 ==0 && arr1[i] % 4 ==0) {
                System.out.println(arr1[i] + " divisible by 3 and 4");
            } else if (arr1[i] % 3 !=0 && arr1[i] % 4 !=0) {
                System.out.println(arr1[i]+ " do not divisible by 3 and 4");

            }

        }
    }

    @And("I write a function to find the largest element in an array")
    public void iWriteAFunctionToFindTheLargestElementInAnArray() {

        int [] arr2 = {13,7,2,39,12,5};
        int max=arr2[arr2.length-1];

        for (int i=0;i<arr2.length;i++){
            if (arr2[i]>=max){
                max=arr2[i];
                }
        }
        System.out.println("Max is "+ max);
    }

    @And("I write a function that reverses string")
    public void iWriteAFunctionThatReversesString() {

   String str = "Function that reverses String";
   char[] chars = str.toCharArray();

        System.out.println();

        String result = " ";

        for (int i=chars.length-1; i>=0; i--){
            result = result + chars[i];

        }

       System.out.println();

        System.out.println(result);
      
    }

    @And("I work with class")
    public void iWorkWithClass() {
        //Cat cat1 = new Cat("Smoky");
        Animal cat1 = new Cat("Smoky");
        cat1.walk();
        cat1.sleep();
        cat1.eat("meat");
        cat1.speak();


        Animal cat2 = new Cat();
        cat2.setName("Charlie111");
        cat2.walk();
        cat2.sleep();
        cat2.eat("fish");

        System.out.println(Cat.isCat(cat1));
        System.out.println(Cat.isCat(cat2));

        Animal dog1 = new Dog("Cooper");
        dog1.speak();
        dog1.eat("meat");

        List<Animal> listCat = new ArrayList<>();
        listCat.add(cat1);
        listCat.add(cat2);

        List <Animal> listDog = new ArrayList<>();
        listDog.add(dog1);

        printNames(listCat);
        printNames(listDog);



    }

    void printNames(List<Animal> animals){
        System.out.println("Names below: ");
        for (Animal animal:animals) {
            System.out.println(animal.getName());
            animal.speak();

            }
        }
}



