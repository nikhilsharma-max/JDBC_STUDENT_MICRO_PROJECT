package org.dnm;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        int choice;

        do {
            System.out.println();
            System.out.println("============ STUDENT MANAGEMENT SYSTEM ============");

            System.out.println("1. Add Student");
            System.out.println("2. View All Student");
            System.out.println("3. Search Student by id");
            System.out.println("4. Update Student by id");
            System.out.println("5. Delete Student by id");
            System.out.println("6. Exit system");

            System.out.println("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.println("Enter course name: ");
                    String course = scanner.nextLine();

                    System.out.println("Enter marks: ");
                    double marks = scanner.nextDouble();

                    System.out.println();

                    Student student = new Student(id, name, email, course, marks);
                    studentService.addStudent(student);
                    break;

                case 2:
                    studentService.viewAllStudent();
                    break;

                case 3:
                    System.out.println();
                    System.out.println("Enter id: ");
                    int idx = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println();
                    studentService.searchStudent(idx);
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Enter student id to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter new name: ");
                    String updatedName = scanner.nextLine();

                    System.out.println("Enter new email: ");
                    String updatedEmail = scanner.nextLine();

                    System.out.println("Enter new course name: ");
                    String updatedCourse = scanner.nextLine();

                    System.out.println("Enter new marks: ");
                    double updatedMarks = scanner.nextDouble();

                    Student updatedStudent = new Student(
                            updatedName,
                            updatedEmail,
                            updatedCourse,
                            updatedMarks
                    );

                    studentService.updateStudent(updateId, updatedStudent);
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Enter id: ");
                    int idxt = scanner.nextInt();
                    scanner.nextLine();

                    studentService.deleteStudent(idxt);
                    break;

                case 6:
                    System.out.println("Application closed");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        scanner.close();
    }
}

