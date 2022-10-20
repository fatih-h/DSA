class BubbleSort{
    /*
    Time Complexity: O(N2)
    Auxiliary Space: O(1)
    = (n-1) + (n-2) +  (n-3) + . . . 2 + 1
    = (n-1)*(n-1+1)/2  { by using sum of N natural Number formula }
    = n (n-1)/2
     */

    // Every process of sorting it gets O(N2)
    void sort(int arr[], int n){
        int i,j,temp;
        for(i=0; i<n-1;i++){
            for(j=0; j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    Main.swap(arr,j,j+1);
                }
            }
        }
    }

    // If it is sorted ascending order already best case O(N)
    void optimizedSort(int arr[], int n){

        boolean swapped;
        int i,j,temp;
        for(i=0; i<n-1;i++){
            swapped=false;
            for(j=0; j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    Main.swap(arr,j,j+1);
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }

    void recursiveSort(int arr[], int n){
        if(n == 0 || n == 1){
            return;
        }
        int i,temp;
        for(i=0; i<n-1; i++){
            if(arr[i] > arr[i+1]){
                Main.swap(arr,i,i+1);
            }
        }
        recursiveSort(arr, n-1);
    }

}
class SelectionSort{
    /*
    Time Complexity: O(N2)
    Auxiliary Space: O(1)
    for n=5  there is n-1 loops will happen
    1--->4 compare n-1
    2--->3 compare n-2
    3--->2 compare n-3
    4--->1 compare n-4 or 1
    = (n-1) + (n-2) +  (n-3) + . . . 2 + 1
    = (n-1)*(n-1+1)/2  { by using sum of N natural Number formula }
    = n (n-1)/2
    */
    void sort(int arr[], int n){
        int i,j,min_index;
        for(i=0;i<n-1;i++){
            min_index = i;
            for(j=i+1; j<n; j++){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            Main.swap(arr,i,min_index);
        }
    }
}

class InsertionSort{
    /*
    Time Complexity: O(N2)
    Auxiliary Space: O(1)
    Insertion sort takes maximum time to sort if elements are sorted in reverse order.
    And it takes minimum time (Order of n) when elements are already sorted.
    */
    void sort(int arr[], int n){
        int i,j,key;
        for(i=1; i<n; i++){
            key = arr[i];
            j = i-1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
            // 2 3 4 1 5
        }
    }
}

class MergeSort{
    //Based on Divide and Conquer Paradigm
    /*
    Time Complexity: O(N log(N))
    Auxiliary Space: O(n)
    Merge Sort is a recursive algorithm and time complexity
    can be expressed as following recurrence relation.
    T(n) = 2T(n/2) + θ(n)
    2T(n/2) corresponds to the time required to sort the sub-arrays,
    and θ(n) is the time to merge the entire array.
    */

    //There are log N levels and in each level, we perform O(N) work
    void sort(int arr[], int left, int right){
        if(left < right){
            // Find the middle point
            int mid = left + (right-left) / 2;
            // Recursive comes here
            sort(arr, left, mid);
            sort(arr, mid+1, right);

            //Merge the sorted halves
            merge(arr,left,mid,right);
        }
    }

    void merge(int arr[], int left, int mid, int right){
        int n1 = mid-left+1;
        int n2 = right-mid;

        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];


        for(int i=0; i<n1; i++){
            leftArr[i] = arr[left+i];
        }
        for(int j=0; j<n2; j++){
            rightArr[j] = arr[mid+j+1];
        }

        /* Merge the temp arrays */

        int i=0,j=0;
        int key = left;
        while(i<n1 && j<n2){
            if(leftArr[i] <= rightArr[j]){
                arr[key] = leftArr[i];
                i++;
            }else{
                arr[key] = rightArr[j];
                j++;
            }
            key++;
        }


        while (i < n1) {
            arr[key] = leftArr[i];
            i++;
            key++;
        }
        while (j < n2) {
            arr[key] = rightArr[j];
            j++;
            key++;
        }

    }
}

class QuickSort{

}


public class Main {
    public static void main(String[] args) {
        /*Bubble sort test case
        int[] array = new int[]{4,9,8,1,3};
        int n = array.length;
        BubbleSort bs = new BubbleSort();
        print(array,n);
        bs.sort(array,array.length);
        bs.optimizedSort(array,n);
        bs.recursiveSort(array,n);
        print(array,n);
        */

        /*Selection Sort test case
        int[] array = new int[]{43,12,54,23,15,33,2,72};
        int n = array.length;
        SelectionSort ss = new SelectionSort();
        print(array, n);
        ss.sort(array, n);
        print(array, n);
         */

        /*Insertion Sort test case
        int[] array = new int[]{52,12,86,45,62,3,6,61,12};
        int n = array.length;
        InsertionSort is = new InsertionSort();
        print(array, n);
        is.sort(array, n);
        print(array,n);
         */

        /*Merge Sort test case
        int[] array = new int[]{21,35,89,95,12,45,64,23,1,2,76};
        int n = array.length;
        MergeSort ms = new MergeSort();
        print(array, n);
        ms.sort(array,0,n-1);
        print(array, n);
         */



    }

    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int arr[], int size){
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}