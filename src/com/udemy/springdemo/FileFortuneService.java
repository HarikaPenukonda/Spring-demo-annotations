package com.udemy.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	private String fileName = "/Users/harikapenukonda/Desktop/fortune-data.txt";
	private List<String> theFortunes;
	
	// create a random generator
	private Random random = new Random();
	
	//constructor
	public FileFortuneService()
	{
		File theFile = new File(fileName);
		System.out.println("Reading fortunes from the file " + theFile);
		System.out.println("File exists: " + theFile.exists());
		
		// initialize array list
		theFortunes = new ArrayList<String>();
		
		// read fortunes from the file
		
		try(BufferedReader br = new BufferedReader(new FileReader(theFile)))
		{
			String tempLine;
			while((tempLine = br.readLine()) != null)
			{
				theFortunes.add(tempLine);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	@Override
	public String getFortune() {
		
		int index = random.nextInt(theFortunes.size());
		String tempFortune = theFortunes.get(index);
		
		return tempFortune;
	}

}
