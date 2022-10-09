package org.example;

import java.io.IOException;
import java.util.*;

public class Main {
    static List<Task> tasks;

    static {
        try {
            System.out.println("现在有的todo项");
            tasks = SerializeUtils.readFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        while(true){
            String command = input.nextLine();
            if( command.startsWith("todo add") ) {
                addTask(command);
            }else if( command.startsWith("todo list") ){
               listTask(command);
            }else if( command.startsWith("todo done") ){
                doneTask(command);
            }else if (command.equals("quit")){
                return;
            }else{
                System.out.println("输入格式不正确！请重试！");
            }
        }
    }

    public static boolean isNullItem(String item){
        if( item.length() == 0 ){
            System.out.println("item为空，请重新输入");
            return false;
        }
        return true;
    }

    public static void addTask(String command) throws IOException {
        String item = command.substring(8);
        if (isNullItem(item)) {
            Task task = new Task(item, false, tasks.size() + 1);
            tasks.add(task);
            System.out.println(task);
            System.out.println();
            System.out.println("Item " + tasks.size() + " added");
            SerializeUtils.writeFile(tasks);
        }
    }

    public static void listTask(String command) throws IOException {
        if( tasks.size() == 0 ){
            System.out.println("现在为空，请添加之后重试");
            return;
        }
//        todoList = SerializeUtils.readFile();
        if( command.equals("todo list --all")){
            tasks.forEach(System.out::println);
            System.out.println("Total " + tasks.size());
        }else{
            tasks.stream().filter((a)->!a.isDone).forEach(System.out::println);
            long count = tasks.stream().filter((a)->!a.isDone).count();
            System.out.println("Total " + count);
        }
    }

    public static void doneTask(String command) throws IOException {
        String item = command.substring(9);
        if(isNullItem(item)){
            Optional<Task> taskOptional = tasks.stream().filter((a)-> Objects.equals(a.getItem(), item)).findFirst();
            if( taskOptional.isPresent() ){
                Task task = taskOptional.get();
                task.setDone(true);
                System.out.println("Item"+task.item+" done");
                SerializeUtils.writeFile(tasks);
            }
        }
    }



}