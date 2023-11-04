import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch{
    public static void main(String[] args){
        int[] elementArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};


        System.out.println("Numbers: " + Arrays.toString(elementArray));
        Scanner sysIn = new Scanner(System.in);
        System.out.println("Type the number you want to search: ");

        int searchKey = sysIn.nextInt();
        int iterations = binarySearch(elementArray, searchKey);

        if(iterations > 0){
            System.out.println("Found the number " + searchKey + " in " + iterations + " iterations.");
        }
        else{
            System.out.println("The number " + searchKey + " is not included in the list.");
        }
        
        sysIn.close();
    }

    public static int binarySearch(int[] array, int searchKey){
        int start = 0, end = array.length - 1;
        int n, pivot = 0, pivotOffset = 0;
        int iterationCounter = 0;
        boolean foundElement = false;

        while(!foundElement){
            n = end - start;    
            pivot = n / 2 + pivotOffset;

            
            iterationCounter += 1;
            
            if(array[pivot] == searchKey){
                foundElement = true;
                return iterationCounter;
            }
            else{
                if(n == 0){
                    return 0;
                }

                if(array[pivot] < searchKey){
                    start = pivot + 1;
                    pivotOffset = start;
                }
                else{
                    end = pivot -1;
                }
            }
        }
        return 0;
    }
}