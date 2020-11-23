package model.parser;

import java.io.File;
import java.util.*;

public abstract class Parser {
    protected String argument;
    protected String directory;
    protected String filename;
    protected String extension;
    protected File inputFile;
    protected File outputFile;

    protected List<Map<String, String>> tree;

    protected Parser(File inputFile) {
        this.inputFile = inputFile;
        String fileNameFull = this.inputFile.getName();
        this.directory = this.inputFile.getAbsoluteFile().getParent();
        this.filename=fileNameFull.replaceFirst("[.][^.]+$", "");
        this.extension=fileNameFull.replaceFirst(fileNameFull.replaceFirst("[.][^.]+$", "")+".","");
    }

    protected Parser(List<Map<String, String>> tree, File outputFile) {
        this.tree = tree;
        this.outputFile = outputFile;
        String fileNameFull = this.outputFile.getName();
        this.directory = this.outputFile.getAbsoluteFile().getParent();
        this.filename=fileNameFull.replaceFirst("[.][^.]+$", "");
        this.extension=fileNameFull.replaceFirst(fileNameFull.replaceFirst("[.][^.]+$", "")+".","");

    }

    public abstract List<Map<String, String>> parse();

    public abstract void stringify();

}