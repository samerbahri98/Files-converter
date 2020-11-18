package main.java.model.parser.sql;

import main.java.model.parser.Parser;
import java.io.File;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class SQL extends Parser {

    public SQL(List<Map<String, String>> tree, File outputFile) {
        super(tree, outputFile);
    }

    public SQL(File inputFile) {
        super(inputFile);
    }

    public void stringify() {
        this.argument = "";
        for (Map<String, String> map : this.tree) {
            this.argument = this.argument + "INSERT INTO " + this.filename;
            Set set = map.entrySet();
            Iterator iterator = set.iterator();
            List<String> keys = new ArrayList<String>();
            List<String> values = new ArrayList<String>();
            while (iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry) iterator.next();
                keys.add(mentry.getKey().toString());
                values.add("\"" + mentry.getValue().toString() + "\"");
            }
            this.argument = this.argument + " ( " + String.join(" , ",keys) + " ) VALUES ( " +  String.join(" , ",values) + " );\n";
        }
        try {
            FileWriter nWriter = new FileWriter(outputFile.getAbsolutePath());
            nWriter.write(this.argument);
            nWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}