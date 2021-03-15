package com.leandroyabut.weekendassignment.lambdas;

public class Lambdas {

    public PerformOperation isOdd() {
        return i -> i % 2 != 0;
    }

    public PerformOperation isPrime() {
        return n -> {
            if(n == 0 || n == 1) return false;
            else {
                for(int i = 2; i <= n/2; i++) {
                    if(n % i == 0) return false;
                }
            }
            return true;
        };
    }

    public PerformOperation isPalindrome() {
        return i -> Integer.toString(i).equals(new StringBuilder().append(i).reverse().toString());
    }

    // Program
    public static void main(String[] args) {
        Lambdas lambdas = new Lambdas();

        try (InputReader reader = new InputReader("resources/weekendassignment/lambdas/input")) {

            int[][] cases = reader.getCases();

            for (int[] aCase : cases) {
                int operation = aCase[0];
                int number = aCase[1];

                switch (operation) {
                    case 1:
                        System.out.println(check(lambdas.isOdd(), number) ? "ODD" : "EVEN");
                        break;
                    case 2:
                        System.out.println(check(lambdas.isPrime(), number) ? "PRIME" : "COMPOSITE");
                        break;
                    case 3:
                        System.out.println(check(lambdas.isPalindrome(), number) ? "PALINDROME" : "NOT PALINDROME");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Input not found...");
        }
    }

    private static boolean check(PerformOperation performOperation, int num) {
        return performOperation.isCorrect(num);
    }

}
