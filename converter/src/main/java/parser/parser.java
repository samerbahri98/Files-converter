package main.java.parser;

public abstract class Parser {
    protected String argument;
    protected List<Map<String, String>> tree;

    protected Parser(String argument) {
        this.argument = argument;
    }

    protected Parser(List<Map<String, String>> tree) {
        this.tree.addAll(tree);
    }

    public abstract void parse();

    public abstract String stringify();

}