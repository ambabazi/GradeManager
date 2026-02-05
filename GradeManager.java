import java.util.Arrays;

// Custom exception for invalid grade input
class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}

public class GradeManager {
    private int[] grades;
    private int count;

    // Constructor
    public GradeManager(int size) {
        grades = new int[size];
        count = 0;
    }

    // Add a grade
    public void addGrade(int grade) throws InvalidGradeException {
        if (grade < 0 || grade > 100) {
            throw new InvalidGradeException("Grade must be between 0 and 100.");
        }
        if (count >= grades.length) {
            throw new ArrayIndexOutOfBoundsException("Cannot add more grades; array is full.");
        }
        grades[count] = grade;
        count++;
        System.out.println("Added grade: " + grade);
    }

    // Display all grades
    public void displayGrades() {
        if (count == 0) {
            System.out.println("No grades added yet.");
        } else {
            System.out.println("Current grades (" + count + " total): " + Arrays.toString(Arrays.copyOf(grades, count)));
        }
    }

    // Sort grades
    public void sortGrades() {
        if (count == 0) {
            System.out.println("No grades to sort.");
            return;
        }
        Arrays.sort(grades, 0, count);
        System.out.println("Grades sorted: " + Arrays.toString(Arrays.copyOf(grades, count)));
    }

    // Search for a grade
    public int searchGrade(int grade) {
        if (count == 0) {
            System.out.println("No grades to search.");
            return -1;
        }
        for (int i = 0; i < count; i++) {
            if (grades[i] == grade) {
                return i;
            }
        }
        return -1;
    }

    // Calculate average
    public double calculateAverage() {
        if (count == 0) {
            System.out.println("No grades to calculate average.");
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += grades[i];
        }
        return (double) sum / count;
    }

    // Find highest grade
    public int highestGrade() {
        if (count == 0) {
            System.out.println("No grades to find highest.");
            return -1;
        }
        int max = grades[0];
        for (int i = 1; i < count; i++) {
            if (grades[i] > max) max = grades[i];
        }
        return max;
    }

    // Find lowest grade
    public int lowestGrade() {
        if (count == 0) {
            System.out.println("No grades to find lowest.");
            return -1;
        }
        int min = grades[0];
        for (int i = 1; i < count; i++) {
            if (grades[i] < min) min = grades[i];
        }
        return min;
    }
}
