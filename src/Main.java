import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //Variable declaration
        int n = 70;
        int arrayLength = 50000;
        Integer[] array = new Integer[arrayLength];
        long[] fibonacci = new long[n];
        Set<Integer> set = new HashSet<>();
        //Getting random number array
        for (int i = 0; i < arrayLength; i++) {
            array[i] = (int) (Math.random() * 100000);
        }
        set.addAll(Arrays.asList(array)); //remove duplicates from an array around 1/5 of provided length
        arrayLength = set.size();
        set.toArray(array); //convert list back to array, without duplicates, to iterate easier.


        //Fibonacci
        long firstTerm = 0, secondTerm = 1;
        for (int i = 1; i < n; ++i) {
            // compute the next term
            long nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
            fibonacci[i] = firstTerm;
        }

        //looping through our random array and fibonacci to find the common values
        long answer = 0;
        long numberOne = 0, numberTwo = 0;
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 1; j < arrayLength; j++) {
                long currentValue = (long) array[i] * array[j];
                for (int k = 39; k > 0; k--) {
                    if (currentValue == fibonacci[k]) {
                        if (currentValue > answer) {
                            answer = currentValue;
                            numberOne = array[i];
                            numberTwo = array[j];
                        }
                        System.out.println("I have found fibonacci " + currentValue + " being product from nr1: " + array[i] + " nr2: " + array[j]);
                    }
                }
            }
        }
        System.out.println("The answer is: " + answer + " ,the product between: " + numberOne + " and " + numberTwo);
    }
}

//Acest program ruleaza in jur de 2 min din cauza marimii sirului si a valorilor mari.
// Pentru a optimiza procesul am exclus din sirul de numere toate duplicatele(care reprezinta 1/5),
// acest lucru a scazut timpul de rulare a programului cu aproximativ  30 sec.