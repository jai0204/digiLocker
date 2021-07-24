package com.company;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class DigiLocker {
    private final File directory;

    public DigiLocker(String directoryName) {
        directory = new File(directoryName);
    }

    public void printFileNamesInAscendingOrder() {
        System.out.println("\nFile Names in Ascending Order:");
        System.out.println("------------------------------");
        try {
            String[] files = directory.list();
            if (files.length > 0) {
                Arrays.sort(files);
            } else {
                throw new NullPointerException();
            }
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i]);
            }
        } catch (NullPointerException e) {
            System.out.println(">>>There are No files in the directory!!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void displayOptions() {
        do {
            System.out.println("\nPlease select a File Operation:");
            System.out.println("-------------------------------");
            System.out.println("1. Add a file");
            System.out.println("2. Delete a file");
            System.out.println("3. Search a file");
            System.out.println("4. Return to Main Menu");
            System.out.print("\n>>Enter the option number: ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            if (option == 1) {
                addFile();
            } else if (option == 2) {
                deleteFile();
            } else if (option == 3) {
                searchFile();
            } else if (option == 4) {
                break;
            } else {
                System.out.println("\n>>>Please enter a valid option!!");
            }
        } while (true);
    }

    private void addFile() {
        System.out.println("\nAdding New File");
        System.out.println("---------------");
        System.out.print("\nEnter file name: ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        try {
            File newFile = new File(directory + File.separator + fileName);
            if (newFile.createNewFile()) {
                System.out.println("\n>>>" + fileName + " created successfully in " + directory);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void deleteFile() {
        System.out.println("\nDeleting a File");
        System.out.println("---------------");
        System.out.print("\nEnter file name: ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        try {
            File deleteFile = new File(directory + File.separator + fileName);
            if (deleteFile.delete()) {
                System.out.println("\n>>>" + fileName + " deleted successfully!!");
            } else {
                System.out.println("\n>>>Failed to delete the file " + fileName);
                System.out.println(">>>Please verify file name(case sensitive) and your access to the directory/file!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void searchFile() {
        System.out.println("\nSearching a File");
        System.out.println("---------------");
        System.out.print("\nEnter file name: ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        try {
            boolean fileFound = false;
            String[] files = directory.list();
            for (int i = 0; i < files.length; i++) {
                if (files[i].equals(fileName)) {
                    fileFound = true;
                    System.out.println("\n>>>" + fileName + " found in the directory!!");
                    break;
                }
            }
            if (!fileFound)
                System.out.println("\n>>>File Not Found!!");

        } catch (NullPointerException e) {
            System.out.println("\n>>>There are no files to search for!!");
        }
    }
}
