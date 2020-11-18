package main.java.controller;

import main.java.model.parser.csv.CSV;
import main.java.model.parser.sql.SQL;

import java.io.File;

public class Controller{
    public Controller() {
        CSV source = new CSV(new File("lab/dataset.csv"));
        //SQL sink = new SQL(source.parse(),new File("lab/dataset.sql"));
        CSV sink = new CSV(source.parse(),new File("lab/dataset2.csv"));
        sink.stringify();
    }
}