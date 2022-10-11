package org.example;

import org.example.strategy.Function;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String loginUser = null;
    static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Context context = new Context();

        while (true) {
            String command = input.nextLine();
            if (command.equals("quit"))
                return;
            Function matchFunction = context.matchFunction(command);
            matchFunction.execute(command, tasks);
        }
    }

}