package StudentDAO;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.Student;


public class DBOperations implements StudentDaoInterface
{
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int update_details(String col,String col_value,String update_field,String new_field) 
	{
		if(col.equals("id"))
		{
			if(update_field.equals("id"))
			{
				String query="UPDATE student SET " + update_field +"="+ Integer.parseInt(new_field) + " WHERE " + col + "="+ Integer.parseInt(col_value);
				int result=this.jdbcTemplate.update(query);
				return result; 
			}
			else
			{
				String query="UPDATE student SET " + update_field +"=? WHERE " + col + "="+ Integer.parseInt(col_value);
				int result=this.jdbcTemplate.update(query,new_field);
				return result; 
			}
		}
		else 
		{
			if(update_field.equals("id"))
			{
				String query="UPDATE student SET " + update_field + "="+ Integer.parseInt(new_field)+ " WHERE " + col + "=?";
				int result=this.jdbcTemplate.update(query,col_value);
				return result; 
			}
			else
			{
				String query="UPDATE student SET " + update_field + "=? WHERE " + col + "=?";
				int result=this.jdbcTemplate.update(query,new_field,col_value);
				return result;  
			}
			
		}

	}
	
	@Override
	public  int insert_details (Student obj)
	{
		String query= "insert into student(id,name,city,MobileNumber) values(?,?,?,?)";
		int result=this.jdbcTemplate.update(query,obj.getId(),obj.getName(),obj.getCity(),obj.getMobileNumber());
		return result; 
	}
	@Override
	public int delete_details(String col, String col_value) 
	{
		if(col.equals("id"))
		{
			String query="DELETE FROM student WHERE id="+col_value;
			int result=this.jdbcTemplate.update(query);
			return result;
		}
		else
		{
			String query="DELETE FROM student WHERE "+col+"=?";
			int result=this.jdbcTemplate.update(query,col_value); 
			return result;
		}
	}

	@Override
	public Student get_student(int id) 
	{
		String query="select * from student where id="+id;  
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query,rowMapper);
		return student;
	}

	@Override
	public List<Student> get_all_students()  
	{
		String query="select * from student";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		List<Student> students=this.jdbcTemplate.query(query,rowMapper); 
		return students; 
	}
	@Override
	public List<Student> get_particular_student(String col,String col_value) 
	{
		String query="select * from student where "+col+"=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		List<Student> students=this.jdbcTemplate.query(query,rowMapper,col_value); 
		return students;
	}

	public JdbcTemplate getJdbcTemplate() 
	{
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) 
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	

	 



	
	

}
  