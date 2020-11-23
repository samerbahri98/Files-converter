package model.parser.yaml;

import model.parser.Parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class YAML extends Parser {

    public YAML(List<Map<String, String>> tree, File outputFile) {
        super(tree, outputFile);
    }

    public YAML(File inputFile) {
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
            String[] rows = Arrays.copyOfRange(this.argument.split("(- )|( - )"),1,this.argument.split("(- )|( - )").length);

            for (int i = 0; i < rows.length; i++) {
                String[] row = rows[i].split("\n");
                Map<String, String> myMap1 = new HashMap<String, String>();
                String[] keys = Stream.of(row).map(elem -> elem.replaceAll("\\s|$", "").split(":")[0]).toArray(String[]::new);
                String[] values = Stream.of(row).map(elem -> elem.replaceAll("\\s|$", "").split(":")[1]).toArray(String[]::new);
                for (int j = 0; j < row.length; j++) {
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
        this.argument = "---\n";
        List<String> Objects = new ArrayList<String>();
        for (Map<String, String> map : this.tree) {
            String current = "";
            Set set = map.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry) iterator.next();
                current = current+"  " + mentry.getKey().toString() + ": " + mentry.getValue().toString() + "\n";
            }

            current = "-" + current.substring(1, current.length());

            Objects.add(current);
        }
        this.argument = this.argument + String.join("", Objects);
        try {
            FileWriter nWriter = new FileWriter(outputFile.getAbsolutePath());
            nWriter.write(this.argument);
            nWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}