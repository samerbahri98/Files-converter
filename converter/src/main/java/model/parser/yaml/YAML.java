package main.java.model.parser.yaml;

import main.java.parser.*;
import java.io.File;

public class YAML extends Parser {

    public YAML (List<Map<String , String>> tree, File outputFile){
        super(tree,outputFile);
    }

    public YAML(File inputFile){ 
        super(inputFile);
    }

} 