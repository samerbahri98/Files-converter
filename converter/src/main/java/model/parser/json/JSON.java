package model.parser.json;

import model.parser.Parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JSON extends Parser {

    public JSON(List<Map<String, String>> tree, File outputFile) {
        super(tree, outputFile);
    }

    public JSON(File inputFile) {
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
        List<String> Objects = new ArrayList<String>();
        for (Map<String, String> map : this.tree) {
            String current = "{";
            Set set = map.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry) iterator.next();
                current = current + "\"" + mentry.getKey().toString() + "\":\"" + mentry.getValue().toString() + "\",";
            }

            current = current.substring(0,current.length()-1) + "}";
            
            Objects.add(current);
        }
        this.argument = "[" + String.join(",", Objects) + "]";
        try {
            FileWriter nWriter = new FileWriter(outputFile.getAbsolutePath());
            nWriter.write(this.argument);
            nWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}