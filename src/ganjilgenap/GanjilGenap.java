package ganjilgenap;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Agun
 */
public class GanjilGenap {
    
    static final String TEXT_RED = "\033[1;31m";
    static final String TEXT_GREEN = "\033[1;32m";
    static final String TEXT_RESET = "\033[1;0m ";
            
    static final String GENAP = "Genap";
    static final String GANJIL = "Ganjil";
    static final String INVALID_CHOICE = "Invalid";
    static final String INVALID_INPUT = "Invalid input!!";
    
    static void print(String str) {
        System.out.print(str);
    }
    
    static int inpInt() {
        Scanner scanInt = new Scanner(System.in);
        return scanInt.nextInt();
    }
    
    static String inpStr() {
        Scanner scanStr = new Scanner(System.in);
        return scanStr.next();
    }
    
    static String cekGanjilGenap(int input) {
        return input % 2 == 0 ? GENAP : GANJIL;
    }
    
    static void printGanjilGenap(int limit) {
        printGanjilGenap(limit, null);
    }
    
    static void printGanjilGenap(int limit, String pilihan) {
        
        if (limit > 0 && pilihan == null) {
            
            String result = cekGanjilGenap(limit);
            
            print(
                    String.format("%s%s%s \n", TEXT_GREEN, result, TEXT_RESET)
            );
        } else if (limit < 1) {
            print(
                    String.format("%s%s%s \n", TEXT_RED, INVALID_INPUT, TEXT_RESET)
            );
        } else if (pilihan == null || !Arrays.asList(new String[] {GANJIL, GENAP}).contains(pilihan)) {
            print(
                    String.format("%s%s%s \n", TEXT_RED, INVALID_CHOICE, TEXT_RESET)
            );
            
        } else {
            
            String ganjil = "";
            String genap = "";
            String addSpace = "";
            
            for (int i = 1; i <= limit; i++) {
                
                if (i != 1) {
                    addSpace = " ";
                }
                
                if (cekGanjilGenap(i).equals(GENAP)) {
                    genap += addSpace + i;
                } else {
                    ganjil += addSpace + i;
                }
                
            }
            
            if (pilihan.equalsIgnoreCase(GENAP)) {
                print(
                        String.format("%s%s%s \n", TEXT_GREEN, genap, TEXT_RESET)
                );
            } else {
                print(
                        String.format("%s%s%s \n", TEXT_GREEN, ganjil, TEXT_RESET)
                );
            }
            
        }
        
    }
    
    static void chooseMenu(int menu) {
        
        switch (menu) {
            case 1:
                print("Masukan Bilangan Yang Ingin Dicek: ");
                int inp = inpInt();
                printGanjilGenap(inp);
                break;
            case 2:
                
                print("Pilih (Ganjil/Genap) : ");
                String pilihan = inpStr();
                        
                print("Masukan Limit : ");
                int limit = inpInt();
                
                printGanjilGenap(limit, pilihan);
                
                break;
            case 3:
                break; // exit
            default:
                break;
        }
        
        print("========================\n\n\n");
        
    }
    
    static void menu() {
        
        do {            
            print("========================\n");
            print("Menu Ganjil Genap\n");
            print("1. Cek Ganjil Genap\n");
            print("2. Print Genap / Genap ( dgn limit )\n");
            print("3. Exit\n");
            print("Pilihan : "); 

            int menu = inpInt();

            chooseMenu(menu);
        } while (true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
        menu();
    }
}
