package main.java.parser.yaml;

import main.java.parser.*;

public class YAML extends Parser {

    public YAML(String argument){
        super(argument);
    }

    public YAML (List<Map<String, String>> tree){
        super(tree);
    }

}