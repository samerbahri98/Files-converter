package main.java.model.parser.sql;

import main.java.model.parser.Parser;
import java.io.File;
import java.io.FileNotFoundException;
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

    public List<Map<String, String>> parse() {
        this.argument = "";
        List<Map<String, String>> myMap = new ArrayList<Map<String, String>>();
        try {
            Scanner myReader = new Scanner(this.inputFile);
            while (myReader.hasNextLine()) {
                this.argument = this.argument + myReader.nextLine() + "\n";
            }
            myReader.close();
            String[] rows = this.argument.split("\n");

            for (int i = 0; i < rows.length; i++) {
                String[] row = rows[i].split("(?i)INSERT INTO.*?\\(|\\).*?VALUES.*?\\(|\\).*;");
                String[] keys = row[1].replaceAll("\\s", "").split(",");
                String[] values = row[2].replaceAll("\\s", "").replaceAll("\"", "").split(",");

                Map<String, String> myMap1 = new HashMap<String, String>();
                for (int j = 0; j < keys.length; j++) {
                    myMap1.put(keys[j], values[j]);
                }
                myMap.add(0, myMap1);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return myMap;
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
            this.argument = this.argument + " ( " + String.join(" , ", keys) + " ) VALUES ( "
                    + String.join(" , ", values) + " );\n";
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