package org.example;

import org.example.strategy.Function;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sc.su
 */
public class Main {


    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Context context = new Context();

        while (true) {
            String command = input.nextLine();
            if ("quit".equals(command)) {
                return;
            }
            Function matchedFunction = context.matchFunction(command);
            matchedFunction.execute(command);
        }
    }

}