package com.database;

import java.io.*;
import java.util.HashMap;



public class Data_Store_Operations{

    private HashMap<String,String> map = new HashMap<>();
    File file;
    String location = "";

    public Data_Store_Operations(String location) {
        this.location = location;
    }

    public void addData(String key, String val) throws IOException, ClassNotFoundException {

        if(map.containsKey(key)){
            System.out.println("Key already Exists. Enter other key name");
        }
        else {
            if(key.length() <= 32 &&  key.matches("^[a-zA-Z]*$")){
                map.put(key, val);
                storeInFile();
                System.out.println("Key : "+key+" Value : "+val+" is added");
            }
            else
                System.out.println("Error: Invalid key!! key must " +
                        "contain only alphabets and no special characters or numbers");
        }
    }

    public String readData(String key) throws IOException, ClassNotFoundException {

        if(!key.isEmpty() && map.containsKey(key)){
            storeInFile();
            return map.get(key);
        }
        else {
            return "Key is Invalid";
        }
    }

    public void deleteData(String key) throws IOException, ClassNotFoundException {

        if(key!=null && map.containsKey(key)){
            System.out.println(key + " deleted. ");
            map.remove(key);
            storeInFile();
        }
        else {
            System.out.println("Entered key is Invalid");
        }
    }

    public void storeInFile()throws IOException{
        file = new File(location+"file.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(map);
        oos.flush();
        oos.close();
        fos.close();
    }



}
