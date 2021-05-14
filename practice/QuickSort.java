package algorithms;


public class QuickSort
{
    int prtion(int arr[], int low, int high) 
    {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) 
        {
            // if current ele <= pivot
            if (arr[j] <= pivot) 
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /* 
    The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    low  --> Starting index,
    high  --> Ending index 
    */
    void sort(int arr[], int low, int high) 
    {
        if (low < high) 
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = prtion(arr, low, high);

            // Recursively sort elements before
            // prtion and after prtion
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    // utility to print array of size n
    static void printArray(int arr[]) 
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[]) 
    {
        int arr[] = {11, 5, 9, 14, 6, 21};
        int n = arr.length;

        QuickSort qSorter = new QuickSort();
        qSorter.sort(arr, 0, n - 1);

        System.out.println("Sorted array: ");
        printArray(arr);
    }
}