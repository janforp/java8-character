package com.janita.java8.chapter3_lambda;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Janita on 2017-05-30 16:01
 */
public class ExecuteAround {

    public static String processFile() throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader("E:\\track-log.txt"))){
            return br.readLine();
        }
    }

    public static String processFile(BufferedReader reader,ReadFile readFile){
        return readFile.read(reader);
    }

    public static void main(String[] args) throws Exception {

//        try(Scanner in = new Scanner(new FileInputStream("E:\\haha.txt")); PrintWriter out = new PrintWriter("E:\\hehe.txt")) {
//            while(in.hasNext()) {
//                out.println(in.next().toUpperCase());
//            }
//        }


        try (BufferedReader br = new BufferedReader(new FileReader("E:\\track-log.txt"))){

            String result = processFile(br, (BufferedReader bufferedReader) -> {
                try {
                    return br.readLine() + br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            });

            System.out.println(result);
        }


    }
}
