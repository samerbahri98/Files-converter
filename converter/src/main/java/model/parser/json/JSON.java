package main.java.model.parser.json;

import main.java.parser.*;
import java.io.File;

public class JSON extends Parser {

    public JSON(List<Map<String, String>> tree, File outputFile) {
        super(tree, outputFile);
    }

    public JSON(File inputFile) {
        super(inputFile);
    }

}