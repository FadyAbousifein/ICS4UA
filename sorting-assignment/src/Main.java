import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        double[] array = new double[50]; 

        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to enter the array values or randomly generate an array? (Generate/Input): ");
        String input = scanner.next().toUpperCase(); 
        scanner.nextLine();
        
        if(input.equals("GENERATE")) {
            array = arrayGenerator(array); 
        } else {
            System.out.println("Input your array values (Seperated with commas):");
            String inputVal = scanner.nextLine(); 
            inputVal = inputVal.replaceAll("\\s+","");
            String[] iArray = inputVal.split(",");
            array = inputArray(iArray); 
        }

            System.out.println("Which sorting method would you like to use?");
            System.out.print("1: QuickSort\n2: Bubble Sort\n3: Selection Sort\n4: Merge sort\n(1-4): ");
            int choice = scanner.nextInt(); 

            switch(choice) {
                case 1: 
                    quickSort(array, 0, array.length - 1);
                    for(int i = 0; i < array.length; i++) {
                        if(i == 0) {
                            System.out.print("\nArray:");
                            System.out.print("\n[");
                        }
                        System.out.print(array[i] + " ");
                        if(i == 49) {
                            System.out.print("\b]\n");
                        }
                    }
                    break;
                case 2:
                    bubbleSort(array);
                    break;
                case 3:
                    selectionSort(array);
                    break;
                case 4: 
                    sort(array, 0, array.length - 1);
                    for(int i = 0; i < array.length; i++) {
                        if(i == 0) {
                            System.out.print("\nArray:");
                            System.out.print("\n[");
                        }
                        System.out.print(array[i] + " ");
                        if(i == 49) {
                            System.out.print("\b]\n");
                        }
                    }
                    break;
            }
    }

    // generates random array
    public static double[] arrayGenerator(double[] array ) {
        for(int i = 0; i < array.length; i++) {
            int n = (int)(Math.random() * 200) - 100; 
            array[i] = n; 
        }

        // prints generated array
        for(int i = 0; i < array.length; i++) {
            if(i == 0) {
                System.out.print("\nArray:");
                System.out.print("\n[");
            }
            System.out.print(array[i] + " ");
            if(i == 49) {
                System.out.print("\b]\n");
            }
        }
        return array; 
    }

    // user inputs array functionality
    public static double[] inputArray(String[] iArray) {
        double[] numerizedArray = new double[iArray.length]; 

        for(int i = 0; i < iArray.length; i++) {
            numerizedArray[i] = Double.parseDouble(iArray[i]); 
        }
        
        for(int i = 0; i < numerizedArray.length; i++) {
            if(i == 0) {
                System.out.print("\nArray:");
                System.out.print("\n[");
            }
            System.out.print(numerizedArray[i] + " ");
            if(i == 49) {

                System.out.print("\b]\n");
            }
        }
        return numerizedArray; 
    }

    // next two methods in charge of quicksort functionality
    public static int partition(double[] arr, int start, int end) {
        double pivot = arr[end];
        int pIndex = start; 
        
        for(int i = start; i < end; i++) {
            if(arr[i] <= pivot) {
                double temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        double temp = arr[pIndex];
        arr[pIndex] = arr[end];
        arr[end] = temp; 
        return pIndex;
    }

    public static void quickSort(double[] arr, int start, int end) {
        if(start < end) {
            int pIndex = partition(arr, start, end);
            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex + 1, end);
        }
    }

    // bubble sort functionality 
    public static void bubbleSort(double[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    double temp = arr[i]; 
                    arr[i] = arr[j]; 
                    arr[j] = temp; 
                }
            }
        }

        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                System.out.print("\nArray:");
                System.out.print("\n[");
            }
            System.out.print(arr[i] + " ");
            if(i == 49) {

                System.out.print("\b]\n");
            }
        }

    }

    // selection sort functionality 
    public static void selectionSort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int minI = i;
            for (int j = i+1; j < arr.length - 1; j++)
                if (arr[j] < arr[minI])
                    minI = j;
 
            double temp = arr[minI];
            arr[minI] = arr[i];
            arr[i] = temp;
        }

        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                System.out.print("\nArray:");
                System.out.print("\n[");
            }
            System.out.print(arr[i] + " ");
            if(i == 49) {

                System.out.print("\b]\n");
            }
        }

    }
    
    // next two methods are for merges sort functionality 
    public static void merge(double arr[], int left, int middle, int right) {
        int a1 = middle - left + 1;
        int a2 = right - middle;
 
        double lft[] = new double[a1];
        double rgt[] = new double[a2];
 
        for (int i = 0; i < a1; ++i)
            lft[i] = arr[left + i];
        for (int j = 0; j < a2; ++j)
            rgt[j] = arr[middle + 1 + j];
 
        int i = 0;
        int j = 0; 
        int k = left;

        while (i < a1 && j < a2) {
            if (lft[i] <= rgt[j]) {
                arr[k] = lft[i];
                i++;
            }
            else {
                arr[k] = rgt[j];
                j++;
            }
            k++;
        }
 
        while (i < a1) {
            arr[k] = lft[i];
            i++;
            k++;
        }
 
        while (j < a2) {
            arr[k] = rgt[j];
            j++;
            k++;
        }
    }
 
    public static void sort(double arr[], int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
 
            sort(arr, left, middle);
            sort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }
    // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 ,20, 21, 22, 23, 24, 25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50
}
