package org.example;

import org.example.strategy.*;

import java.util.HashMap;
import java.util.Map;

public class Context {
    static Map<String, Function> functionMapping = new HashMap<>();

    static {
        functionMapping.put("add", new AddFunction());
        functionMapping.put("done", new DoneFunction());
        functionMapping.put("list", new ListFunction());
        functionMapping.put("login", new LoginFunction());
        functionMapping.put("logout", new LogoutFunction());
    }


    public Function matchFunction(String command) {
        String[] words = command.split(" ");
        if (words.length < 2)
            return new Function();
        String function = words[1];
        return functionMapping.getOrDefault(function, new Function());
    }

}
