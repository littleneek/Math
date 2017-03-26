import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class Median {
    private static void insertNumberIntoSorted(int number, List<Integer> sortedList) {
        if (sortedList.size() == 0) {
            sortedList.add(number);
            return;
        }

        for (int i=0; i<sortedList.size(); ++i) {
            if (sortedList.get(i) > number) {
                // insert
                sortedList.add(i, number);
                return;
            }
        }

        // insert number at last
        sortedList.add(number);
    }

    private static double calculateMedian(List<Integer> sortedList){
        if (sortedList.size() == 0) {
            return 0;
        }


        if (sortedList.size() % 2 == 0) {
            // even number
            int i2 = sortedList.size()/2;
            int i1 = i2 - 1;

            // calculate the average of the two
            return (double)(sortedList.get(i1) + sortedList.get(i2)) / 2.0;
        }
        else {
            // odd number
            int middleIndex = sortedList.size() / 2;
            return sortedList.get(middleIndex);
        }
    }

    private static void print(List<Integer> array) {
        for (Integer number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> array = new ArrayList<Integer>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            insertNumberIntoSorted(Integer.valueOf(line), array);
            System.out.print("Numbers: ");
            print(array);

            double median = calculateMedian(array);
            System.out.println("Median: " + median);
        }
    }
}
