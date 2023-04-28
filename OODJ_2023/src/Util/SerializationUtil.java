/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 */
public class SerializationUtil {
    
    // deserialize to Object from given file
    public static ArrayList<?> readObjectFromFile(String fileName) {
        String filePath = "data/" + fileName;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
             ArrayList<?> objects  =(ArrayList) ois.readObject();
            ois.close();
            return objects;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // serialize the object and save it to file
    public static boolean writeObjectToFile(ArrayList<?> objects, String fileName) {
        String filePath = "data/" + fileName;
        boolean isFileExist = new File(filePath).isFile();
        if(!isFileExist){
            FileUtil.createFile(filePath);
        }
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(filePath); 
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
            )
        {
            objectOutputStream.writeObject(objects);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
