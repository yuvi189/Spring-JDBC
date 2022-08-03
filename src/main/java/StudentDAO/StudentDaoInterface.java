package StudentDAO;

import java.util.List;

import com.spring.jdbc.Student;

public interface StudentDaoInterface 
{
	public int insert_details (Student obj);
	public int update_details(String col,String col_value, String update_field, String new_field);
	public int delete_details(String col,String col_value);
	public Student get_student(int id);
	public List<Student> get_particular_student(String col,String col_value);
	public List<Student> get_all_students();
}
 