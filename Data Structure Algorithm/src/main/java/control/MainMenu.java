/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import Boundary.TutorialGroupUI;
import java.util.Scanner;
import java.util.Scanner;
import Boundary.*;
import control.TutorialGroup;
import Entity.Students;
import Entity.Groups;

/**
 *
 * @author: Francis Lee Jun Feng
 * @Student ID: 23WMR11560
 */
public class MainMenu {

    private static TutorialGroupUI tutorialUI = new TutorialGroupUI();
    static TutorialGroup tutGroup = new TutorialGroup();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        tutGroup.runProductMaintanence();
    }
}
