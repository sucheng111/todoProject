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
    public static String loginUser = null;
    static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Task task = new Task("1", false, 2);
        Scanner input = new Scanner(System.in);
        Context context = new Context();

        while (true) {
            String command = input.nextLine();
            if (command.equals("quit")) {
                return;
            }
            Function matchedFunction = context.matchFunction(command);
            matchedFunction.execute(command, tasks);
        }
    }

}