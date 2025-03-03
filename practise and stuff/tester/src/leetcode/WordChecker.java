package leetcode;

import java.io.*;
import java.util.*;

public class WordChecker {
    static HashSet<String> dictionary = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        loadDictionary("C:\\Users\\Balyan\\Documents\\Vault\\Vault\\practise and stuff\\tester\\src\\leetcode\\words.txt");  // Load dictionary once

        ArrayList<String> all = new ArrayList<>();
        char[] og = new char[]{'T','?','D','N','I','S','R','E'};
        for (int i = 0; i <26 ; i++) {
            char r = (char)('A'+i);
            og[1]=r;
            all.addAll(helperr(og));
        }
        for (String s : all) {
            if (dictionary.contains(s.toLowerCase())) {
                System.out.println(s);
            }
        }
    }

    public static void loadDictionary(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            dictionary.add(line.trim().toLowerCase());
        }
        reader.close();
    }
    public static ArrayList<String> helperr(char[] og){
        ArrayList<String> all = new ArrayList<>();
        for (int i = 0; i <og.length ; i++) {
            StringBuilder s = new StringBuilder();
            StringBuilder p = new StringBuilder();
            p.append(og[i]);
            s.append(og[i]);
            int j =i+1;
            int k =i-1;
            while(j!=i&&k!=i){
                if(k==-1){k=og.length-1;}
                if(j==og.length){j=0;}
                s.append(og[j]);
                p.append(og[k]);
                k--;
                j++;
            }
            all.add(s.toString());
            all.add(p.toString());
        }
        return all;
    }
}
