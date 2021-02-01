/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisar;
import java.io.*;
import java.util.Scanner;

public class Cisar {

    
   public static  char letters[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static String folder = System.getProperty("user.home");
   public static String absolutePath;
   static String File_Name ;
   static String line="";
   
   public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrer le nombre  de decalage k");
     int k=sc.nextInt();
    
    System.out.println(" Entrer  votre  plain text ");
    
 String text=sc.nextLine();
 while (text.equals("")) {
  text=sc.nextLine();
 }
 File_Name = "A.txt";
write(File_Name,text);
       System.out.println("Fichier A.TXT avant le cryptage 'plain text'= "+ read(File_Name));
 
crypt(k);
 decrypt(k);  
    }
   
   
    // ecrire un  contenue dans un fichier
    public static  void write(String File_Name,String content) {
        absolutePath = folder + File.separator +File_Name;
    try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) {
    String fileContent = content;
    bufferedWriter.write(fileContent);
    
} catch (IOException e) {
    // Exception handling
}
    }
   
   
    // lire le contenue d'un fichier
    public static  String read(String File_Name) {
        absolutePath = folder + File.separator +File_Name;
      String content="";
    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
    line = bufferedReader.readLine();
   
    while(line != null) {
       
         content=line;
        line = bufferedReader.readLine();
        
    }
    
} catch (FileNotFoundException e) {
    // Exception handling
} catch (IOException e) {
    // Exception handling
}
        return content;
    }
    //crypter le contenue de  A.txt  puis le sauvgarder dans  B.TXT
    public static void crypt(int k){
    //e(x)=(x+k) mod 26.
    String cr="";
     String plain_text;
    
     
     plain_text=read("A.txt").toLowerCase();
     
    
    
          for (char i:plain_text.toCharArray()) {
              for (int position = 0; position< letters.length;position++) {
                  if (i==letters[position]) {
                   
                    int newposition =(position+k) % 26;
                    cr=cr+letters[newposition];
                  }
              }
          
         }
   
   
 File_Name = "B.txt";
 write("B.txt",cr);
 System.out.println("Fichier B.TXT 'crypted text'= "+ read(File_Name));
        
      
     
    }
    //decrypter le contenue de  B.txt  puis le sauvgarder dans  A.TXT
     public static void decrypt(int k){
       //e(x)=(x-k) mod 26  
       String crypt_text=read("B.txt");
               String pl="";
   
 for (char i:crypt_text.toCharArray()) {
              for (int position = 0; position< letters.length;position++) {
                  if (i==letters[position]) {
                   
                    int newposition =(position-k) % 26;
                      if (newposition<0) {
                        newposition=newposition+26;  
                      }
                    pl=pl+letters[newposition];
                  }
              }
           
         }
      
    
    File_Name = "A.txt";
write(File_Name,pl);
System.out.println("Fichier A.TXT 'decrypted text'= "+ read(File_Name));
     
     }
}
