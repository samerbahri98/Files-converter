package main.java.model.parser.xml;

import main.java.parser.*;
import java.io.File;

public class XML extends Parser {

    public XML (List<Map<String , String>> tree, File outputFile){
        super(tree,outputFile);
    }


    public XML (File inputFile){
        super(inputFile);
    }

}