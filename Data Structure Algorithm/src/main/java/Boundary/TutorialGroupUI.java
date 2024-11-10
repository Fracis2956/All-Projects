/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Boundary;

import ADT.HashList;
import ADT.HashListInterface;
import Entity.Students;
import Entity.Groups;
import java.util.Scanner;
import control.*;
import Utility.*;

/**
 *
 * @author: Francis Lee Jun Feng
 * @Student ID: 23WMR11560
 */
public class TutorialGroupUI {

    private HashListInterface<Groups, Students> groupList = new HashList<>();
    static TutorialGroup tutorialGroup = new TutorialGroup();
    static MessageUI messageUI = new MessageUI();
    Scanner scanner = new Scanner(System.in);
    private final static String GROUPNAME = "Group";

    public int getMenuChoices() {
        int choice;
        System.out.println("\nMain Menu");
        System.out.println("---------------------------------------");
        System.out.println("0. Exit");
        System.out.println("1. Add Student to Tutorial Group");
        System.out.println("2. Remove Student from Tutorial Group");
        System.out.println("3. Change Group for Student");
        System.out.println("4. Find Student");
        System.out.println("5. List All Students");
        System.out.println("6. Filter Tutorial Groups");
        System.out.println("7. Generate Reports");
        System.out.println("8. Clear All");
        System.out.print("\nSelect Your Choices: ");

        try {
            choice = scanner.nextInt();

        } catch (Exception ex) {
            choice = -1;
            messageUI.displayInvalidChoiceMessage();

        } finally {
            scanner.nextLine();
        }
        return choice;
    }

    public int getGroupChoices() {
        int groupChoice;

        System.out.print("Enter Your Group Number (e.g. 1, 2, 3 ...) [Press 0 to Exit] : ");
        try {
            groupChoice = scanner.nextInt();
        } catch (Exception ex) {
            groupChoice = -1;
            scanner.nextLine();

        }
//        String newID = String.format("%s%d", GROUPNAME, groupChoice);

        return groupChoice;
    }

    public String inputStudentName() {
        scanner.nextLine();
        System.out.print("Please Enter The Student Name: ");
        String name = scanner.nextLine();
        return name;
    }

    public String inputStudentID() {
        System.out.print("Please Enter The Student ID: ");
        String ID = scanner.nextLine();
        return ID;
    }

    public char inputStudentGender() {
        char gender;
        do {
            System.out.print("Please Enter The Gender (M for Male & F for Female): ");
            gender = scanner.next().charAt(0);
            gender = Character.toUpperCase(gender);
            if (gender != 'M' && gender != 'F') {
                System.out.println("Please Try Again!");
            }

        } while (gender != 'M' && gender != 'F');
        return gender;
    }

    public Groups inputGroupName(int groupNum) {

        String groupName = String.format("%s%d", GROUPNAME, groupNum);

        return new Groups(groupName);
    }

    public Students inputStudentDetails() {
        String studentName = inputStudentName();
        String studentID = inputStudentID();
        char gender = inputStudentGender();

        return new Students(studentName, studentID, gender);
    }

    public Students inputID() {
        scanner.nextLine();
        String studentID = inputStudentID();
        return new Students(studentID);
    }

    public Students inputGender() {
        scanner.nextLine();
        char gender = inputStudentGender();
        return new Students(gender);
    }

    public void addDisplayErrorMessage() {
        System.err.println("The Data That You Input Is Exist! Please Try Again!\n");
    }

    public void removeDisplayErrorMessage() {
        System.err.println("\nRemove Fail!\nThe Data is Not Exist! Please Try Again!\n");
    }

    public void DisplayErrorMessage() {
        System.err.println("Errors Is Found! Please Try Again!");
    }

    public void DisplayChangeGroupMessage() {
        System.err.println("The Data Is Not Exist");
    }

    public void DisplayChangeInitialGroupMessage() {
        System.out.println("\nPlease Select Your Initial Group:");
    }

    public void DisplayChangeFinalGroupMessage() {
        System.out.println("\nPlease Select The Group You Wish To Change:");
    }

    public void DisplayListAllErrorMessage() {
        System.err.println("There Is No Any Students In This Group!");
    }

    public void DisplayMessage() {
        System.out.println("\nIt Is Successfully Done!");
    }

    public void DisplayExitMessage() {
        System.out.println("\nYou Have Exit Successfully From This Section!");
    }

    public void DisplayFindMessage() {
        System.out.println("\nThis Student Is Exist.");
    }

    public void DisplayFindStudentMessage(String name) {
        System.out.println("Student Name: " + name);
    }

    public void DisplayInvalidFindMessage() {
        System.out.println("The Student Cannot Be Find");
    }

    public void DisplayListAllGroup(Groups gName) {
        System.out.println("\n" + gName + ": ");
        System.out.println("----------------------------------");
    }

    public void DisplayFilterTitle() {
        System.out.printf("\n%-10s%10s%15s%10s\n", "Group", "Student ID", "Student Name", "Gender");
        System.out.println("-----------------------------------------------------------");
    }

    public void DisplayFilter(String gName, String ID, String name, char gender) {
        System.out.print(gName + ": ");
        System.out.printf("%12s%15s%10c\n", ID, name, gender);
    }

    public void DisplayReport(int groupAmount) {
        System.out.println("It have " + groupAmount + " of groups");
    }

    public void DisplayGroupReport(String groupName) {
        System.out.print("\n" + groupName + " consist of ");
    }

    public void DisplayStudentReport(int size) {
        System.out.println(size + " number of students\n");
    }

    public void displayReportInformation() {
        System.out.printf("%-10s%15s%10s", "Student ID", "Student Name", "Gender");
        System.out.println("\n-----------------------------------------------");
    }

    public void DisplayListAllMessage(String ID, String name, char gender) {
        System.out.printf("%-10s%15s%10c\n", ID, name, gender);
    }

    public void systemPause() {
        System.out.print("\nPress Enter To Continue[Click Once or Twice].");
        scanner.nextLine();
        scanner.nextLine();
    }
}
