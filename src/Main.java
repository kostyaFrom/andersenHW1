import java.util.Comparator;

/**
 * Main class to start program
 * Contains main method, methods for quickSort algorithm for Comparable and Comparator interfaces
 */
public class Main {

    public static void main(String[] args) {

        CustomList<String> customList = new CustomArrayList<>();
        customList.add("j");
        customList.add("a");
        customList.add("i");
        customList.add("b");
        customList.add("h");
        customList.add("c");
        customList.add("g");
        customList.add("d");
        customList.add("f");
        customList.add("e");

        System.out.println("Unsorted list " + customList);
        quickSort(customList, 0, customList.size(), String::compareTo);
        System.out.println("Sorted list " + customList);

    }

    /**
     * Method for quickSort algorithm using Comparator interface
     * Make sorting based on quick sort algorithm and uses additional method for partitioning collection
     */
    public static <T> void quickSort(CustomList<T> input, int start, int end, Comparator<T> comparator) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end, comparator);
        quickSort(input, start, pivotIndex, comparator);
        quickSort(input, pivotIndex + 1, end, comparator);
    }

    /**
     * Additional method for quickSort algorithm using Comparator interface
     * Make partitioning of a given collection also uses Comparator interface in parameter
     */
    public static <T> int partition(CustomList<T> input, int start, int end, Comparator<T> comparator) {

        T pivot = input.get(start);
        int i = start;
        int j = end;

        while (i < j) {

            // NOTE: empty loop body
            while (i < j && (comparator.compare(input.get(--j), pivot)) >= 0) ;
            if (i < j) {
                input.set(i, input.get(j));
            }

            // NOTE: empty loop body
            while (i < j && (comparator.compare(input.get(++i), pivot)) <= 0) ;
            if (i < j) {
                input.set(j, input.get(i));
            }

        }
        input.set(j, pivot);
        return j;

    }


    /**
     * Method for quickSort algorithm using Comparable interface
     * Make sorting based on quick sort algorithm and uses additional method for partitioning collection
     */
    public static <T extends Comparable<T>> void quickSort(CustomList<T> input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    /**
     * Additional method for quickSort algorithm using Comparable interface
     * Make partitioning of a given collection also uses Comparable interface
     */
    public static <T extends Comparable<T>> int partition(CustomList<T> input, int start, int end) {

        T pivot = input.get(start);
        int i = start;
        int j = end;

        while (i < j) {

            // NOTE: empty loop body
            while (i < j && (input.get(--j).compareTo(pivot)) >= 0) ;

            if (i < j) {
                input.set(i, input.get(j));
            }

            // NOTE: empty loop body
            while (i < j && (input.get(++i).compareTo(pivot)) <= 0) ;
            if (i < j) {
                input.set(j, input.get(i));
            }

        }
        input.set(j, pivot);
        return j;

    }
}