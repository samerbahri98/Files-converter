package main.java.parser.sql;

import main.java.parser.*;

public class SQL extends Parser {

    public SQL(String argument){
        super(argument);
    }

    public SQL (List<Map<String, String>> tree){
        super(tree);
    }

}