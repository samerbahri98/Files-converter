package main.java.parser.json;

import main.java.parser.*;

public class JSON extends Parser {

    public JSON(String argument){
        super(argument);
    }

    public JSON (List<Map<String, String>> tree){
        super(tree);
    }

}