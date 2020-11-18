package main.java.model.parser.csv;

import main.java.model.parser.Parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CSV extends Parser {

    public CSV(List<Map<String, String>> tree, File outputFile) {
        super(tree, outputFile);
    }

    public CSV(File inputFile) {
        super(inputFile);
    };

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
            String[] keys = rows[0].split(",");

            for (int i = 1; i < rows.length; i++) {
                String[] values = rows[i].split(",");
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
        List<String> keys = new ArrayList<String>();
        boolean isNotSet = true;
        for (Map<String, String> map : this.tree) {
            Set set = map.entrySet();
            Iterator iterator = set.iterator();
            List<String> values = new ArrayList<String>();

            while (iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry) iterator.next();
                if (isNotSet)
                    keys.add(mentry.getKey().toString());

                values.add(mentry.getValue().toString());
            }
            this.argument = this.argument + String.join(",", values) + "\n";
            isNotSet = false;
        }
        this.argument = String.join(",", keys) + "\n" + this.argument;
        try {
            FileWriter nWriter = new FileWriter(outputFile.getAbsolutePath());
            nWriter.write(this.argument);
            nWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}