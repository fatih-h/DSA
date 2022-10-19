class BubbleSort{
    /*
    Time Complexity: O(N2)
    Auxiliary Space: O(1)
    = (n-1) + (n-2) +  (n-3) + . . . 2 + 1
    = (n-1)*(n-1+1)/2  { by using sum of N natural Number formula }
    = n (n-1)/2
     */

    // Every process of sorting it gets O(n^2)
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

    // If it is sorted ascending order already best case O(n)
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



public class Main {
    public static void main(String[] args) {
        //Bubble sort tests
//        int[] array = new int[]{4,9,8,1,3};
//        int n = array.length;
//        BubbleSort bs = new BubbleSort();
//        print(array,n);
//        bs.sort(array,array.length);
//        bs.optimizedSort(array,n);
//        bs.recursiveSort(array,n);
//        print(array,n);


        int[] array = new int[]{43,12,54,23,15,33,2,72};
        int n = array.length;

    }

    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int arr[], int size){
        for(int i=0; i<size; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}