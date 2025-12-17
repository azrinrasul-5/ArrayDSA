class ArrayOperations<T> {
    private T[] arr;  // Generic array
    private int size; // Current number of elements

    public ArrayOperations(int capacity) {
        arr = (T[]) new Object[capacity];
        size = 0;
    }

    // Add initial elements to the array
    public void initializeArray(T[] elements) {
        for (int i = 0; i < elements.length; i++) {
            arr[i] = elements[i];
        }
        size = elements.length;
    }

    // Access an element at a specific index
    public T accessElement(int index) {
        if (index >= size || index < 0) {
            System.out.println("Access failed: Index out of bounds.");
            return null;
        }
        return arr[index];
    }

    // Update an element at a specific index
    public void updateElement(int index, T value) {
        if (index >= size || index < 0) {
            System.out.println("Update failed: Index out of bounds.");
            return;
        }
        arr[index] = value;
    }

    // Traverse the array
    public void traverseArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Insert an element at a specific index
    public void insertElement(T element, int index) {
        if (size >= arr.length) {
            System.out.println("Insertion failed: Array is full.");
            return;
        }
        if (index > size || index < 0) {
            System.out.println("Insertion failed: Index out of bounds.");
            return;
        }
        // Shift elements to the right
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        size++;
    }

    // Delete an element by index
    public void deleteElementByIndex(int index) {
        if (index >= size || index < 0) {
            System.out.println("Deletion failed: Index out of bounds.");
            return;
        }
        // Shift elements to the left
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null; // Optional: Clear the last element
        size--;
    }

    // Delete an element by value
    public void deleteElementByValue(T element) {
        int index = -1;
        // Find the index of the element
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(element)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Deletion failed: Element not found.");
            return;
        }

        // Shift elements to the left
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null; // Optional: Clear the last element
        size--;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of ArrayOperations with capacity 10 for Integer type
        ArrayOperations<String> myArray = new ArrayOperations<>(10);

        // Initialize the array with some elements
        String[] initialElements = {"ABC", "XYZ", "ZZZ", "wyz", "Def"};
        myArray.initializeArray(initialElements);

        System.out.println("Original Array:");
        myArray.traverseArray();

        System.out.println("\nInsert Element at Index 3:");
        myArray.insertElement("QRS", 3);
        myArray.traverseArray();

        System.out.println("\nUpdate Element at Index 3:");
        myArray.updateElement(3, "Def");
        myArray.traverseArray();

        // Delete an element by index
        System.out.println("\nDelete Element at Index 3:");
        myArray.deleteElementByIndex(3);
        myArray.traverseArray();

        // Delete an element by value
        System.out.println("\nDelete Element with Value 30:");
        myArray.deleteElementByValue("Def");
        myArray.traverseArray();

        // Try deleting an element that does not exist
        System.out.println("\nAttempt to Delete Element with Value 100:");
        myArray.deleteElementByValue("pp");
        myArray.traverseArray();

    }
}