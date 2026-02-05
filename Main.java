// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeManager gm = new GradeManager(10); // Array can hold 10 grades

        System.out.println("=== Grade Manager ===\n");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a grade");
            System.out.println("2. Display all grades");
            System.out.println("3. Sort grades");
            System.out.println("4. Search for a grade");
            System.out.println("5. Calculate average");
            System.out.println("6. Find highest grade");
            System.out.println("7. Find lowest grade");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter a grade (0-100): ");
                        int grade = scanner.nextInt();
                        gm.addGrade(grade);
                        break;

                    case 2:
                        gm.displayGrades();
                        break;

                    case 3:
                        gm.sortGrades();
                        break;

                    case 4:
                        System.out.print("Enter the grade to search for: ");
                        int searchGrade = scanner.nextInt();
                        int index = gm.searchGrade(searchGrade);
                        if (index != -1) {
                            System.out.println("Grade " + searchGrade + " found at index: " + index);
                        } else {
                            System.out.println("Grade " + searchGrade + " not found.");
                        }
                        break;

                    case 5:
                        double avg = gm.calculateAverage();
                        System.out.println("Average grade: " + String.format("%.2f", avg));
                        break;

                    case 6:
                        int highest = gm.highestGrade();
                        System.out.println("Highest grade: " + highest);
                        break;

                    case 7:
                        int lowest = gm.lowestGrade();
                        System.out.println("Lowest grade: " + lowest);
                        break;

                    case 8:
                        running = false;
                        System.out.println("Thank you for using Grade Manager. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InvalidGradeException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
