package dao;

import java.sql.*;   
import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import bean.UserBean;

public class UserDao {
	JdbcTemplate template;
	
public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	public List<UserBean> Custlogin(UserBean u){
		String sql="select * from Cust_reg WHERE email='"+u.getEmail()+"' AND password='"+u.getPassword()+"'";
		List<UserBean> list=template.query(sql,new ViewMapper());
	    return list;
	   }
	class ViewMapper implements RowMapper<UserBean>{
		public UserBean mapRow(ResultSet rs,int arg)throws SQLException
		{
			UserBean u=new UserBean();
			u.setAcc_no(rs.getLong("acc_no"));
			u.setCust_name(rs.getString("cust_name"));
            u.setBal_amnt(rs.getDouble("bal_amnt"));
			return u;
		}
    }
		
	public List<UserBean> Salary(UserBean u) throws SQLException{
			String s="select * from Emp_master WHERE designation='"+u.getEmp_designation()+"'";
			List<UserBean> list=template.query(s,new RowMapper<UserBean>() {
				public UserBean mapRow(ResultSet rs,int arg)throws SQLException
		    	{
		    		UserBean u=new UserBean();
			    	u.setBasic_pay(rs.getInt("basic_pay"));
				    u.setDA(rs.getInt("DA"));
	                u.setHRA(rs.getInt("HRA"));
	       		    int salary=(rs.getInt("basic_pay")*(100+rs.getInt("DA")+rs.getInt("HRA")))/100;
	                u.setEmp_salary(salary);
					return u;
				}
				
	      });
			return list;
			
	}
	
	public int Register(UserBean u, int salary) throws SQLException{
		 String sql="insert into Emp_reg(emp_name,emp_place,emp_designation,emp_age,emp_qualification,emp_salary) values('"+u.getEmp_name()+"','"+u.getEmp_place()+"','"+u.getEmp_designation()+"',"+u.getEmp_age()+",'"+u.getEmp_qualification()+"',"+salary+")";  
		 return template.update(sql);
		 
	}
	
	public int SignUp(UserBean u){
		 String sql="insert into Cust_reg(cust_name,cust_place,cust_mobileno,acc_type,email,password,bal_amnt) values('"+u.getCust_name()+"','"+u.getCust_place()+"',"+u.getCust_mobileno()+","+u.getAcc_type()+",'"+u.getEmail()+"','"+u.getPassword()+"','0')";  
		 return template.update(sql);
	}
	
	public List<UserBean>acctdetails(long number) 
	{
		return template.query("select * from Cust_reg where acc_no="+number+"",new RowMapper<UserBean>() {
			public UserBean mapRow(ResultSet rs,int arg)throws SQLException{
				UserBean ub=new UserBean();
				ub.setCust_name(rs.getString("cust_name"));
				ub.setCust_place(rs.getString("cust_place"));
				ub.setCust_mobileno(rs.getLong("cust_mobileno"));
				ub.setAcc_type(rs.getString("acc_type"));
				ub.setEmail(rs.getString("email"));
				ub.setPassword(rs.getString("password"));
				ub.setBal_amnt(rs.getDouble("bal_amnt"));
				ub.setAcc_no(rs.getLong("acc_no"));
				return ub;
			}
		});
    }
	
	public List<UserBean> getEmployees(){  
	    return template.query("select r.emp_id,r.emp_name,r.emp_place,r.emp_designation,r.emp_age,r.emp_qualification,m.basic_pay,m.DA,m.HRA,r.emp_salary from Emp_reg as r left join Emp_master as m on r.emp_designation=m.designation order by r.emp_id",new RowMapper<UserBean>(){  
	        public UserBean mapRow(ResultSet rs, int arg) throws SQLException {  
	        	UserBean ub=new UserBean();  
				ub.setEmp_id(rs.getInt("emp_id"));
				ub.setEmp_name(rs.getString("emp_name"));
				ub.setEmp_place(rs.getString("emp_place"));
				ub.setEmp_designation(rs.getString("emp_designation"));
				ub.setEmp_age(rs.getInt("emp_age"));
				ub.setEmp_qualification(rs.getString("emp_qualification"));
				ub.setEmp_salary(rs.getInt("emp_salary"));
				ub.setBasic_pay(rs.getInt("basic_pay"));
				ub.setDA(rs.getInt("DA"));
				ub.setHRA(rs.getInt("HRA"));
	            return ub;  
	        }
	    });
	}
	

	public List<UserBean>getCustomers(){  
	    return template.query("select * from Cust_reg",new RowMapper<UserBean>(){  
	        public UserBean mapRow(ResultSet rs, int arg) throws SQLException {  
	        	UserBean ub=new UserBean();  
	        	ub.setAcc_no(rs.getLong("acc_no"));
				ub.setCust_name(rs.getString("cust_name"));
				ub.setCust_place(rs.getString("cust_place"));
				ub.setCust_mobileno(rs.getLong("cust_mobileno"));
				ub.setAcc_type(rs.getString("acc_type"));
				ub.setEmail(rs.getString("email"));
				ub.setPassword(rs.getString("password"));
				ub.setBal_amnt(rs.getDouble("bal_amnt"));
	            return ub;  
	        }
	    });
	}
	
	public int cashtrans (UserBean u,double balance,long number) {
		int status=0;
			if (u.getDeposit()>0) {
				double balance1=balance+u.getDeposit();
				String s1="update Cust_reg set bal_amnt="+balance1+" where acc_no="+number+"";
				template.update(s1);
				status=1;
			}
			else if ((u.getWithdrawal()>0)&&(u.getWithdrawal()<=balance)) {
				double balance2=balance-u.getWithdrawal();
				String s2="update Cust_reg set bal_amnt="+balance2+" where acc_no="+number+"";
				template.update(s2);
				status=2;
			}
			else if ((u.getWithdrawal()>=0)&&(u.getWithdrawal()>balance)) {
			    status=3;
			}
			return status;
			}
		
}

