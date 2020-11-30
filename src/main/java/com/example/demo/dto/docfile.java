package com.example.demo.dto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class docfile {
	public static List<String> ar=new ArrayList<>();
	public String readFile() {
		  String aa="";
		 try {
		     //BÆ°á»›c 1: Táº¡o Ä‘á»‘i tÆ°á»£ng luá»“ng vÃ  liÃªn káº¿t nguá»“n dá»¯ liá»‡u
		     File f = new File("E:\\data1.txt");
		     FileReader fr = new FileReader(f);
		     //BÆ°á»›c 2: Ä�á»�c dá»¯ liá»‡u
		     BufferedReader br = new BufferedReader(fr);
		    
		     String line;
		     while ((line = br.readLine()) != null){
		       ar.add(line);
		    	// aa=aa+line;
		     }
		     //BÆ°á»›c 3: Ä�Ã³ng luá»“ng
		     fr.close();
		     br.close();
		    } catch (Exception ex) {
		      System.out.println("Loi doc file: "+ex);
		  }
		 return aa;
	}
	public static void main(String [] args) {
		
		docfile a=new docfile();
		a.readFile();
		String q="\"a\"=>\"\",";
		System.out.println("hoan thanh"+ar.size()+"  "+ar.get(0)+"  "+ar.get(10)+"  "+ar.get(20));
		for(int i=0;i<ar.size();i++) {
			if(q.equals(ar.get(i))) {
				System.out.println("okooo");
			}
		}
	}
}
