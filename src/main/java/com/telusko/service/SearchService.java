package com.telusko.service;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.opencsv.CSVReader;

public class SearchService {
	
	String color;
	String size;
	String gender;
	String outPutPref;
	String path;
	File f;
	String [] csvFiles; 
	
	public boolean doesThisResultMatch(String tempResult)
	{
		String [] s = tempResult.split("\\|");
		if(s[2].equalsIgnoreCase(color) && s[3].equalsIgnoreCase(gender) && s[4].equalsIgnoreCase(size) && s[7].equalsIgnoreCase("y"))
		{
			return true;
		}
		return false;
	}
	
	public ArrayList<String> readCsv()
	{
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<csvFiles.length; i++)
		{
			String csvPath = path+"\\"+f.list()[i];
			
			try
			{
				FileReader fileReader = new FileReader(csvPath);
				CSVReader reader = new CSVReader(fileReader);
				
				LinkedList<String[]> subList = new LinkedList<String[]>();
				subList = (LinkedList<String[]>) reader.readAll();
				
			    int size = subList.size();
			    int i1 = 1;
				while(i1<size)
				{
					String temp = subList.get(i1)[0];
					
					if(doesThisResultMatch(temp))
						{
							list.add(temp);
						}
					i1++;
				}
			}
				
				
				
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		return list;
		
	}

	// Main Method
	
	public List<String> getMatchingResult(String color, String gender, String size, String outPutpref)
	{
		
		this.color = color;
		this.size = size;
		this.gender = gender;
		this.outPutPref = outPutpref;
		this.path = "C:\\Users\\samde\\Downloads\\AssigmentLinks";
		this.f = new File(path);
		csvFiles = f.list();
		
	
		ArrayList<String> ans = (ArrayList<String>) readCsv();
		
		
		
		if(outPutpref.equalsIgnoreCase("price"))
			ans.sort((l1, l2) -> 
			((Double)Double.parseDouble(l1.split("\\|")[5])).compareTo((Double)Double.parseDouble(l2.split("\\|")[5])));
		

		ans.sort((l1, l2) -> 
		((Double)Double.parseDouble(l1.split("\\|")[6])).compareTo((Double)Double.parseDouble(l2.split("\\|")[6])));
		for(String a : ans)
		{
			System.out.println(a);
		}
		
		return ans;
		
	}
}
