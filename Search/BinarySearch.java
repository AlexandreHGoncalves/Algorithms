/*
 * The idea of this algorithm is to reduce the complexity of the array, and by doing so, it'll be easier and more efficient to search for an element inside. 
 * It divides the array in half, using the element in the middle to decide which side to discard, and keeps repeating that, until it finds the element  it's 
 * searching for.
 */

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch{
    public static void main(String[] args){
        int[] elementArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91}; //The array needs to be sorted in ascending order first in order to work properly.


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
        int start = 0, end = array.length - 1; //These sets the boundaries of the array, so that we don't need to split the array many times.
        int n, pivot = 0, pivotOffset = 0;
        int iterationCounter = 0;
        boolean foundElement = false;

        while(!foundElement){
            n = end - start; //Receives the number of elements in the current bounds of the array    
            pivot = n / 2 + pivotOffset; //Receives the middle element of the current bounds of the array, plus an offset, in case the boundaries are past halfpoint.

            
            iterationCounter += 1;
            
            if(array[pivot] == searchKey){ //If the pivot is the number we're searching for, we've found it.
                foundElement = true;
                return iterationCounter;
            }
            else{
                if(n == 0){ //If there's only one element in the boundaries, and it's not the number we're searching for, it means that it's not in the array.
                    return 0;
                }

                if(array[pivot] < searchKey){ //If the number we're searching for is higher than the pivot, we move the start of the boundary ahead of the pivot, and change the offset.
                    start = pivot + 1;
                    pivotOffset = start;
                }
                else{ //If the number we're searching for is lower than the pivot, we move the end of the boundary behind the pivot, no need to change the offset in this case.
                    end = pivot -1;
                }
            }
        }
        return 0;
    }
}