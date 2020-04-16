package com.company;

import BinaryTree.BinaryTree;

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
                        tree.Add(value, current);
                        break;
                    case  "delete":
                        current = in.nextBigInteger();
                        tree.Delete(current);
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
                    /*
                    case "read":
                       //
                        break;
                    case "write":
                        //
                        break;
                     */
                }
            }
        }  catch (Exception e) {
            System.out.println("Something do wrong");
        }
    }
}

