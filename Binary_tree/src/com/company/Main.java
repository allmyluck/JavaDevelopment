package com.company;

import BinaryTree.BinaryTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        String text, value;
        BigInteger current;
        try {
            while (true) {
                text = in.nextLine();
                switch (text) {
                    case "add":
                        value = in.nextLine();
                        current = in.nextBigInteger();
                        tree.Add(current,value);
                        break;
                    case  "delete":
                        current = in.nextBigInteger();
                        tree.Delete(current);
                        break;
                    case  "deleteAll":
                        tree.DeleteTree();
                        break;
                    case "print":
                        // maybe need to do PrintTree with tabs;
                        tree.PrintTree();
                        break;
                    case "sort":
                        tree.PrintSortTree();
                        break;
                    case "find":
                        current = in.nextBigInteger();
                        tree.Find(current);
                        break;

                    case "read":
                        value = in.nextLine();
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new FileReader(value));
                            tree.ReadFromFile(bufferedReader);
                        } catch (IOException e) {
                            System.out.println("Error:" + e);
                        }
                        break;
                    case "write":
                        value = in.nextLine();
                        try {
                            File file = new File(value);
                            if(!file.exists()) {
                                file.createNewFile();
                            }
                            tree.WriteFromFile(file);
                        } catch (IOException e) {
                            System.out.println("Error:" + e);
                        }
                        break;
                }
            }
        }  catch (Exception e) {
            System.out.println("Something do wrong:" + e);
        }
    }
}

