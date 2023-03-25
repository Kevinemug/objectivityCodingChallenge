import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    private ArrayList<Object> originalArray;
    private ArrayList<Object> updatedArray;
//constructor
    public ArrayModifier(Object[] originalArray, Object[] updatedArray) {
        this.originalArray = new ArrayList<>(Arrays.asList(originalArray));
        this.updatedArray = new ArrayList<>(Arrays.asList(updatedArray));
    }
    //function to detect new elements
    public ArrayList<Object> getNewElements() {
        ArrayList<Object> newElements = new ArrayList<>();
        for (Object element : updatedArray) {
            if (!originalArray.contains(element)) {
                newElements.add(element);
            }
        }
        return newElements;
    }
    //function to return removed elements

    public ArrayList<Object> getRemovedElements() {
        ArrayList<Object> removedElements = new ArrayList<>();
        for (Object element : originalArray) {
            if (!updatedArray.contains(element)) {
                removedElements.add(element);
            }
        }
        return removedElements;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the original array: ");
        int originalSize = scanner.nextInt();
        Object[] originalArray = new Object[originalSize];
        for (int i = 0; i < originalSize; i++) {
            System.out.print("Enter element " + (i+1) + " of the original array: ");
            if (scanner.hasNextInt()) {
                originalArray[i] = scanner.nextInt();
            } else if (scanner.hasNextDouble()) {
                originalArray[i] = scanner.nextDouble();
            } else {
                originalArray[i] = scanner.next();
            }
        }

        System.out.print("Enter the size of the updated array: ");
        int updatedSize = scanner.nextInt();
        Object[] updatedArray = new Object[updatedSize];
        for (int i = 0; i < updatedSize; i++) {
            System.out.print("Enter element " + (i+1) + " of the updated array: ");
            if (scanner.hasNextInt()) {
                updatedArray[i] = scanner.nextInt();
            } else if (scanner.hasNextDouble()) {
                updatedArray[i] = scanner.nextDouble();
            } else {
                updatedArray[i] = scanner.next();
            }
        }

        ArrayModifier arrayModifier = new ArrayModifier(originalArray, updatedArray);

        ArrayList<Object> newElements = arrayModifier.getNewElements();
        ArrayList<Object> removedElements = arrayModifier.getRemovedElements();

        System.out.println("New Elements: " + newElements);
        System.out.println("Removed Elements: " + removedElements);
    }
}
