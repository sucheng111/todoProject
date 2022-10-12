package org.example;

import com.google.common.collect.ImmutableMap;
import org.example.strategy.*;

import java.util.Map;

/**
 * @author sc.su
 */
public class Context {
    final private static Map<String, Function> FUNCTION_MAPPING = ImmutableMap.of(
            "list", new ListFunction(),
            "add", new AddFunction(),
            "done", new DoneFunction(),
            "login", new LoginFunction(),
            "logout", new LogoutFunction()
    );

    public Function matchFunction(String command) {
        String[] words = command.split(" ");
        if (words.length < 2) {
            return new Function();
        }
        String function = words[1];
        return FUNCTION_MAPPING.getOrDefault(function, new Function());
    }

}
