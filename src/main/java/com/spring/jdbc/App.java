package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.CSV.FileHandling.*;
import StudentDAO.DBOperations;

public class App 
{
  public static void main(String[] args) 
  {
	  System.out.println("Welcome to Student Management System");
	  System.out.println("----------------------------------------------------------------------");
	  System.out.println("Enter 1 to insert details of a student");
	  System.out.println("Enter 2 to update details of a student");
	  System.out.println("Enter 3 to delete the details of a student");
	  System.out.println("Enter 4 to display details of a student");
	  System.out.println("Enter 5 to create a csv file of all the student details");
	  System.out.println("Enter 6 to exit");
	  Scanner a=new Scanner(System.in);
	  int n;
	  n=a.nextInt();
	  a.nextLine();
	  while(n!=6)
	  {
		  switch(n)
		  {
		  
		  
		  
		  case(1):
		  {
			    System.out.println("Enter the id of the student");
			    int id=a.nextInt();
			    a.nextLine();
			    System.out.println("Enter the name of the student");
				String name=a.nextLine();
				System.out.println("Enter the mobile number of the student");
				String MobileNumber=a.nextLine();
				System.out.println("Enter the city of the student");
				String city=a.nextLine();
				Student obj=new Student(id,name,city,MobileNumber);
				ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");  
				DBOperations dao=(DBOperations)context.getBean("StudentDao");
				int res=dao.insert_details(obj);   
				System.out.println(res+"detail has been inserted");
				break;
		  }
		  case(2):
		  {
			  System.out.println("Enter the name of the column on basis of which you want to update the details");
				String col=a.nextLine();
				System.out.println("Enter the value of selected column");
				String col_value=a.nextLine();
				System.out.println("Enter the filed you want to update");
				String update_field=a.nextLine();
				System.out.println("Enter the value of the updated field");
				String new_field=a.nextLine();
				ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
				DBOperations dao=(DBOperations)context.getBean("StudentDao");
				int res=dao.update_details(col,col_value,update_field,new_field); 
				System.out.println(res+"detail has been updated");
				
			  
			  break;
		  }
		  case(3):
		  {
			  System.out.println("Enter the column name on basis of which you want to delete the details");
			  String col=a.nextLine();
			  System.out.println("Enter the value of that column");
			  String col_value=a.nextLine();
			  ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
			  DBOperations dao=(DBOperations)context.getBean("StudentDao");
			  int res=dao.delete_details(col, col_value);
			  System.out.println(res+"values have been removed");
			  
			 break; 
		  }
		  case(4):
		  {
			  int k;
			  System.out.println("Enter 1 if you want the details of one student");
			  System.out.println("Enter 2 if you want the details of particular students");
			  System.out.println("Enter 3 if you want the details of all students");
			  k=a.nextInt();
			  a.nextLine();
			  if(k==1)
			  {
				  int sid;
				  System.out.println("Enter the id of the student whose details you want to see");
				  sid=a.nextInt();
				  a.nextLine();
				  ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
				  DBOperations dao=(DBOperations)context.getBean("StudentDao");
				  Student student=dao.get_student(sid);
				  System.out.println(student);
			  }
			  else if(k==2)
			  {
				  String col,col_value;
				  System.out.println("Enter the name of the column on basis of which you want to extract the details");
				  col=a.nextLine();
				  System.out.println("Enter the value of that column");
				  col_value=a.nextLine();
				  ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
				  DBOperations dao=(DBOperations)context.getBean("StudentDao");
				  List<Student> students=dao.get_particular_student(col, col_value);
				  for(Student i:students)
				  {
					  System.out.println(i);
				  }
			  } 
			  else if(k==3)
			  {
				  ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
				  DBOperations dao=(DBOperations)context.getBean("StudentDao");
				  List<Student> students=dao.get_all_students();
				  for(Student i:students)
				  {
					  System.out.println(i);
				  }
			  }
			  break;
		  }
		  
		  case(5):
		  {
			  ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
			  DBOperations dao=(DBOperations)context.getBean("StudentDao");
			  List<Student> students=dao.get_all_students();
			  WritingIntoCsvFile.createFile();
			  for(Student i:students)
			  {
				  WritingIntoCsvFile.saveRecord(i);
			  }
			  break;
		  }
		  
		  
		  }
		  System.out.println("Welcome to Student Management System");
		  System.out.println("----------------------------------------------------------------------");
		  System.out.println("Enter 1 to insert details of a student");
		  System.out.println("Enter 2 to update details of a student");
		  System.out.println("Enter 3 to delete the details of a student");
		  System.out.println("Enter 4 to display details of a student");
		  System.out.println("Enter 5 to create a csv file of all the student details");
		  System.out.println("Enter 6 to exit");
		  n=a.nextInt();
		  a.nextLine();
	  }
	  System.out.println("Bye Bye Take Care");
	    
  }
}
