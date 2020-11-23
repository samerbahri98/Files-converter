package controller;

import model.parser.csv.CSV;
import model.parser.xml.XML;
import model.parser.sql.SQL;
import model.parser.json.JSON;
import model.parser.yaml.YAML;

import java.io.File;

public class Controller{
    public Controller() {
        YAML source = new YAML(new File("lab/dataset2.yaml"));
        //SQL sink = new SQL(source.parse(),new File("lab/dataset.sql"));
        CSV sink = new CSV(source.parse(),new File("lab/dataset3.csv"));
        sink.stringify();
    }
}