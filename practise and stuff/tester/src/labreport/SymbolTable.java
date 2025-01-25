package labreport;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, String> table;

    public SymbolTable() {
        table = new HashMap<>();
    }

    public void addSymbol(String key, String value) {
        table.put(key, value);
    }

    public void printSymbolTable() {
        System.out.println("Symbol Table :");
        for (Map.Entry<String, String> entry : table.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addSymbol("x", "10");
        symbolTable.addSymbol("y", "20");
        symbolTable.addSymbol("z", "30");
        symbolTable.printSymbolTable();
    }
}