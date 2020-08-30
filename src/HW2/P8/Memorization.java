package HW2.P8;

import java.util.HashMap;

/**
 * @author <Bofeng Ding>
 * @version 1.0
 * @date 2020-08-29 19:29
 */
public class Memorization {
     public static void main(String[] args) {
         fibonacci(5);
         System.out.println("\nMemorize Fibonacci");
         memorizeFibonacci(5);
     }

     private static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("");
        }
        if (n == 0 || n == 1) {
            return n;
        }
        System.out.printf("Computing fib(%d)\n", n);
        return fibonacci(n - 1) + fibonacci(n - 2);
     }

     private static int memorizeFibonacci(int n) {
         HashMap<Integer, Integer> map = new HashMap<>();
         return memorizeFibonacciHelper(n, map);
     }

     private static int memorizeFibonacciHelper(int n, HashMap<Integer, Integer> map) {
         if (n < 0) {
             throw new IllegalArgumentException("");
         }
         if (n == 0 || n == 1) {
             return n;
         }

         if (map.containsKey(n)) {
             System.out.printf("Memorized fib(%d)\n", n);
             return map.get(n);
         }

         System.out.printf("Computing fib(%d)\n", n);
         int result = memorizeFibonacciHelper(n - 1, map) + memorizeFibonacciHelper(n - 2, map);
         map.put(n, result);

         return result;
     }
}
