package com.CSV.FileHandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.spring.jdbc.Student;

public class WritingIntoCsvFile 
{
	public static void createFile()
	{
		try 
		{
			FileWriter fw =new FileWriter("student.csv");
			BufferedWriter bw= new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			pw.println("id,name,city,MobileNumber");
			pw.flush();
			pw.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getStackTrace());
		}
	}
	public static void saveRecord(Student student)
	{
		try 
		{
			FileWriter fw =new FileWriter("student.csv",true);
			BufferedWriter bw= new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			pw.println(student.getId()+","+student.getName()+","+student.getCity()+","+student.getMobileNumber());
			pw.flush();
			pw.close();
			
		} 
		catch (Exception e) 
		{
			System.out.println(e.getStackTrace());
		}
	}
}
