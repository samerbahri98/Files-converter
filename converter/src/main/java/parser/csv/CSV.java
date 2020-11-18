package main.java.parser.csv;

import main.java.parser.*;

public class CSV extends Parser {

    public CSV(String argument){
        super(argument);
    }

    public CSV (List<Map<String, String>> tree){
        super(tree);
    }

}