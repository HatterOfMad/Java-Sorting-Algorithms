import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    private static void printArray(ArrayList<Integer> arr) {
        System.out.println(Arrays.toString(arr.toArray()));
    }


    private static void BinarySort() {
        System.out.println("Using Binary Sort:");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter amount of numbers:");
        int size = in.nextInt();
        System.out.println("You can now enter your numbers:");
        ArrayList<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int e = in.nextInt();
            if (i == 0) {
                sorted.add(e);
            } else {
                if (e < sorted.get(0)) {
                    sorted.add(0, e);
                } else {
                    if (e > sorted.get(i - 1)) {
                        sorted.add(e);
                    } else {
                        boolean fit = false;
                        int left = 0;
                        int right = i;
                        int middle = i / 2;
                        while (!fit) {
//                            System.out.println("new loop");
                            if (e == sorted.get(middle)) {
                                sorted.add(middle, e);
                                fit = true;
//                                System.out.println("fits");
                            } else {
                                if (e < sorted.get(middle)) {
//                                    System.out.println("smaller");
                                    if (e > sorted.get(middle - 1)) {
                                        sorted.add(middle, e);
                                        fit = true;
                                    } else {
                                        right = middle;
                                        middle = (left + right) / 2;
                                    }
                                } else {
                                    if (e < sorted.get(middle + 1)) {
//                                        System.out.println("bigger");
                                        sorted.add(middle + 1, e);
                                    } else {
                                        left = middle;
                                        middle = (left + right) / 2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            printArray(sorted);
        }
    }

    private static void InsertionSort() {
        System.out.println("Using Insertion Sort:");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter amount of numbers:");
        int amount = in.nextInt();
        System.out.println("You can now enter your numbers:");
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int n = in.nextInt();
            if (i == 0) {
                arr.add(n);
            } else {
                for (int i2 = 0; i2 <= arr.size(); i2++) {
                    if (i2 == arr.size()) {
                        arr.add(n);
                        break;
                    } else if (arr.get(i2) > n) {
                        arr.add(i2, n);
                        break;
                    }
                }
            }
            printArray(arr);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean chosen = false;
        long startTime = 0;

        while (!chosen) {
            System.out.println("Choose a sort mode");
            System.out.println("1 : Binary Sort");
            System.out.println("2 : Insertion Sort");

            int sortmode = in.nextInt();
            if (sortmode == 1) {
                chosen = true;
                startTime = System.currentTimeMillis();
                BinarySort();
            } else if (sortmode == 2) {
                chosen = true;
                startTime = System.currentTimeMillis();
                InsertionSort();
            } else {
                System.out.println("Choose a valid sort mode!");
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Sort finished and took " + (endTime - startTime) + " milliseconds");

    }

}

// example numbers 5 12 11 13 5 6
