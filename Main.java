package com.database;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        Data_Store_Operations db = new Data_Store_Operations("");

        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                try {
                    db.addData("ab","India");
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };



        t1.run();
        System.out.println(""+db.readData("ab"));

    }
}
