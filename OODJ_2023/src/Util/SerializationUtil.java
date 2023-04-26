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

/**
 *
 */
public class SerializationUtil {

    // deserialize to Object from given file
    public static Object readObjectFromFile(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            ois.close();
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // serialize the object and save it to file
    public static boolean writeObjectToFile(Object object, String fileName) {
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
            objectOutputStream.writeObject(object);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
