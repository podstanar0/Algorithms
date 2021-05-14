package algorithms;


public class MergeSort
{
    void merge(int arrMain[], int a, int b, int c)
    {
        // find sizes of two subarrays to be merged
        int n1 = b - a + 1;
        int n2 = c - b;

        // make temp arrays
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];

        // copy data to them
        for (int i = 0; i < n1; ++i)
            arr1[i] = arrMain[a + i];
        for (int j = 0; j < n2; ++j)
            arr2[j] = arrMain[b + 1 + j];

        // merge all of them
        int i = 0, j = 0;

        // initial index of merged subarray
        int k = a;
        while (i < n1 && j < n2)
        {
            if (arr1[i] <= arr2[j])
            {
                arrMain[k] = arr1[i];
                i++;
            }
            else
            {
                arrMain[k] = arr2[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of arr1[], if any
        while (i < n1)
        {
            arrMain[k] = arr1[i];
            i++, k++;
        }

        // copy remaining elements of arr2[], if any
        while (j < n2)
        {
            arrMain[k] = arr2[j];
            i++, k++;
        }
    }
    // main function that sorts arrMain[a..c] using merge()
    void sort(int arrMain[], int a, int c)
    {
        if (a < c)
        {
            // find the middle point
            int b = (a + c) / 2;

            // sort first and second halves
            sort(arrMain, a, b);
            sort(arrMain, b + 1, c);

            // merge sorted halves
            merge(arrMain, a, b, c);
        }
    }
    // utility function to print array of size n
    static void printArray(int arrMain[])
    {
        int n = arrMain.length;
        for (int i=0; i<n; ++i)
            System.out.print(arrMain[i] + " ");
    }

    // Driver code
    public static void main(String args[])
    {
        int arrMain[] = {22, 31, 16, 4, 8, 3};

        System.out.println("Unsorted Array: ");
        printArray(arrMain);

        MergeSort mSorter = new MergeSort();
        mSorter.sort(arrMain, 0, arrMain.length - 1);

        System.out.println("\nSorted array: ");
        printArray(arrMain);
    }
}
