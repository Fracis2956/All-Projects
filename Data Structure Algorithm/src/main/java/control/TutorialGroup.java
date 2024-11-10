/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import ADT.*;
import Entity.Students;
import Entity.Groups;
import dao.*;
import Boundary.*;
import java.util.Scanner;

/**
 *
 * @author: Francis Lee Jun Feng
 * @Student ID: 23WMR11560
 */
public class TutorialGroup {

    private HashListInterface<Groups, Students> groupList = new HashList<>();
    private static GroupDAO groupDAO = new GroupDAO();
    private static TutorialGroupUI tutorialUI = new TutorialGroupUI();
    Scanner scanner = new Scanner(System.in);

    public TutorialGroup() {
        groupList = groupDAO.retrieveFromFile();
    }

    public void runProductMaintanence() {
        int choice = 0;
        do {
            choice = tutorialUI.getMenuChoices();
            switch (choice) {
                case 0:
                    tutorialUI.DisplayExitMessage();
                    break;
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    changeGroup();
                    break;
                case 4:
                    findStudent();
                    break;
                case 5:
                    listAllStudents();
                    break;
                case 6:
                    filterGroup();
                    break;
                case 7:
                    generateReport();
                    break;
                case 8:
                    clearStudent();
                    break;

            }
        } while (choice != 0);
    }
//.trim()

    public void addStudent() {
        boolean isValid;
        do {
            isValid = false;
            int GroupNum = groupChecking();
            if (GroupNum == 0) {
                break;
            }
            Groups newGroup = tutorialUI.inputGroupName(GroupNum);
            Students newStudent = tutorialUI.inputStudentDetails();
            isValid = groupList.add(newGroup, newStudent);
            if (isValid == false) {
                tutorialUI.addDisplayErrorMessage();
            } else {
                tutorialUI.DisplayMessage();
            }
        } while (isValid == false);
        groupDAO.saveToFile(groupList);
        tutorialUI.systemPause();

    }

    public void deleteStudent() {
        boolean isValid;
        int groupSize = 0;
        String ID = "";
        String name;
        char gender;
        Students newStudent = null;

        do {
            isValid = false;
            int GroupNum = groupChecking();
            if (GroupNum == 0) {
                break;
            }
            Groups newGroup = tutorialUI.inputGroupName(GroupNum);
            groupSize = groupList.size(newGroup);
            groupSize += 1;
            tutorialUI.DisplayListAllGroup(newGroup);
            for (int i = 0; i < groupSize; i++) {
                try {
                    ID = groupList.get(newGroup, i).getID();
                    isValid = true;
                } catch (Exception ex) {
                    tutorialUI.DisplayListAllErrorMessage();
                    break;
                }
//            ID = groupList.get(newGroup, i).getID();
                name = groupList.get(newGroup, i).getName();
                gender = groupList.get(newGroup, i).getGender();
//            System.out.println(groupList.get(newGroup, i).getID() + " " + groupList.get(newGroup, i));
                tutorialUI.DisplayListAllMessage(ID, name, gender);

            }
            if (isValid == true) {
                newStudent = tutorialUI.inputID();
            }
            isValid = groupList.remove(newGroup, newStudent);
            if (isValid == false) {
                tutorialUI.removeDisplayErrorMessage();
            } else {
                tutorialUI.DisplayMessage();
            }
        } while (isValid == false);
        groupDAO.saveToFile(groupList);
        tutorialUI.systemPause();

    }

    public void changeGroup() {

        tutorialUI.DisplayChangeInitialGroupMessage();
        int GroupNum = groupChecking();
        Groups newGroup = tutorialUI.inputGroupName(GroupNum);
        Students newStudent = tutorialUI.inputStudentDetails();
        if (groupList.find(newGroup, newStudent) == true) {
            tutorialUI.DisplayChangeFinalGroupMessage();
            int newGroupNum = groupChecking();
            Groups newChangeGroup = tutorialUI.inputGroupName(newGroupNum);
            groupList.replaceKey(newGroup, newChangeGroup, newStudent);
            groupDAO.saveToFile(groupList);
        } else {
            tutorialUI.DisplayChangeGroupMessage();
        }

        tutorialUI.systemPause();

    }

    public int groupChecking() {
        int checkGroupNum;
        do {
            checkGroupNum = tutorialUI.getGroupChoices();
            if (checkGroupNum == -1) {
                tutorialUI.DisplayErrorMessage();
            } else if (checkGroupNum == 0) {
                tutorialUI.DisplayExitMessage();
//                runProductMaintanence();
                break;
            }
        } while (checkGroupNum == -1);

        return checkGroupNum;
    }

    public void findStudent() {
        boolean valid;
        int groupSize;
        String name;
        do {
            int GroupNum = groupChecking();
            Groups newGroup = tutorialUI.inputGroupName(GroupNum);
            groupSize = groupList.size(newGroup);
            Students newStudent = tutorialUI.inputID();
            valid = groupList.find(newGroup, newStudent);
            if (valid == true) {
                tutorialUI.DisplayFindMessage();
                for (int i = 0; i <= groupSize; i++) {
                    if (groupList.get(newGroup, i).getID().equals(newStudent.getID())) {
                        name = groupList.get(newGroup, i).getName();
//                    System.out.println(groupList.get(newGroup, i).getName());
                        tutorialUI.DisplayFindStudentMessage(name);
                    }

                }
            } else {
                tutorialUI.DisplayInvalidFindMessage();
            }
        } while (valid == false);
        tutorialUI.systemPause();
    }

    public void listAllStudents() {
        int GroupNum = groupChecking();
        int groupSize = 0;
        String ID = "";
        String name;
        char gender;
        Groups newGroup = tutorialUI.inputGroupName(GroupNum);
        groupSize = groupList.size(newGroup);
        groupSize += 1;
        tutorialUI.DisplayListAllGroup(newGroup);
        for (int i = 0; i < groupSize; i++) {
            try {
                ID = groupList.get(newGroup, i).getID();
            } catch (Exception ex) {
                tutorialUI.DisplayListAllErrorMessage();
                break;
            }
//            ID = groupList.get(newGroup, i).getID();
            name = groupList.get(newGroup, i).getName();
            gender = groupList.get(newGroup, i).getGender();
//            System.out.println(groupList.get(newGroup, i).getID() + " " + groupList.get(newGroup, i));
            tutorialUI.DisplayListAllMessage(ID, name, gender);
        }
        tutorialUI.systemPause();
    }

    public void filterGroup() {
        int groupSize = 0;
        String name;
        String ID;
        char gender = tutorialUI.inputStudentGender();
        int groupAmount = groupList.getAllKey();
        tutorialUI.DisplayFilterTitle();
        for (int i = 0; i < groupAmount; i++) {
            Groups newGroup = groupList.getKeys(i);
            String gName = newGroup.getGroupName();
            groupSize = groupList.size(newGroup);
            groupSize += 1;

            for (int j = 0; j < groupSize; j++) {
                char newGender = groupList.get(newGroup, j).getGender();
                if (newGender == gender) {
                    name = groupList.get(newGroup, j).getName();
                    ID = groupList.get(newGroup, j).getID();
                    tutorialUI.DisplayFilter(gName, ID, name, gender);
                }
            }
        }
        tutorialUI.systemPause();
    }

    public void generateReport() {
        int groupSize = 0;
        int groupAmount = groupList.getAllKey();
        tutorialUI.DisplayReport(groupAmount);
        for (int i = 0; i < groupAmount; i++) {
            Groups newGroup = groupList.getKeys(i);
            String gName = newGroup.getGroupName();
            groupSize = groupList.size(newGroup);
            groupSize += 1;
            tutorialUI.DisplayGroupReport(gName);
            tutorialUI.DisplayStudentReport(groupSize);
            tutorialUI.displayReportInformation();
            for (int j = 0; j < groupSize; j++) {
                String ID = groupList.get(newGroup, j).getID();
                String name = groupList.get(newGroup, j).getName();
                char gender = groupList.get(newGroup, j).getGender();

                tutorialUI.DisplayListAllMessage(ID, name, gender);
            }
        }
        tutorialUI.systemPause();
    }

    public void clearStudent() {
        groupList.clear();
        groupDAO.saveToFile(groupList);
        tutorialUI.systemPause();
    }

}
