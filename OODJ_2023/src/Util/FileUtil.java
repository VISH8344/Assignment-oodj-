/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 */
public class FileUtil {

    public static boolean createFile(String filePath) {
        File file = new File(filePath);
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<String[]> ReadFile(String fileName) {
        String filePath = "data/" + fileName;
        ArrayList<String[]> fileRecords = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("file with this path: " + filePath + "isn't found. creating file...");
            } catch (IOException e) {
                System.out.println("err occured when creating file: " + e.getMessage());
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String fileContents = br.readLine();
            while (fileContents != null) {
                String[] eachLine = fileContents.split(";");
                fileRecords.add(eachLine);
            }
        } catch (IOException e) {
            System.out.println("err occured when reading this file " + filePath + "\nerr: " + e.getMessage());
        }
        return fileRecords;
    }

    public static void WriteToFile(String fileName, ArrayList<String> contents) {
        String filePath = "data/" + fileName;
        boolean isFileExist = new File(filePath).isFile();
        if (!isFileExist) {
            FileUtil.createFile(filePath);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : contents) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("err occured when writing to this file:  " + filePath + "\nerr: " + e.getMessage());
        }
    }
}
