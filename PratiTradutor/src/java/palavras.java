/*
Nome do Programa Tradutor
Nome: Victor Propheta Erbano
data: 19/07/19
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class palavras {
  
    public List<String> portuingle() throws FileNotFoundException, IOException{
       List<String> listaportu;
        try (Scanner scanner = new Scanner(new FileReader("palavras.txt"))) {
            listaportu = new ArrayList<>();
            String portuingle;
            while (scanner.hasNext()) {
                portuingle = scanner.nextLine();
                listaportu.add(portuingle);
                
            }
            return listaportu; 
        }

    }    
 
}
 
