package controller;   
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bean.UserBean;  
import dao.UserDao;
@Controller  
public class UserController {  
    @Autowired  
    UserDao dao; 
    
    @RequestMapping("/CustLogin")  
    public String CustLoginPage(Model m){  
    	m.addAttribute("command", new UserBean());
    	return "CustLogin"; 
    }  
        
    @RequestMapping(value="/CustomerLogin",method=RequestMethod.POST)
   	public String Custlogin(UserBean u,HttpSession ses,ModelMap m)
   	{
       	List<UserBean> list=dao.Custlogin(u);
       	if(list.size()>0)
   		{	
   			for (UserBean u1 : list) 
   			{
   				ses.setAttribute("accno", u1.getAcc_no());
   				ses.setAttribute("custname", u1.getCust_name());
   				ses.setAttribute("balamnt", u1.getBal_amnt());
   			}
   			m.put("mylist", list);		
   			return "Customer";
   		}
       	else
   		{
   			JOptionPane.showMessageDialog(null, "Invalid Email or Password");
   	
   			return "CustLogin";
   		}
   	}
    
    @RequestMapping(value="/CashTrans",method = RequestMethod.POST)  
    public String Transaction(@ModelAttribute("user") UserBean user,@RequestParam double balance,@RequestParam long number){  
        int status=dao.cashtrans(user,balance,number); 
        if (status == 1) 
   			JOptionPane.showMessageDialog(null, "Cash deposited successfully");
        else if (status == 2) 
  			JOptionPane.showMessageDialog(null, "Cash withdrawn successfully");
        else if (status == 3) 
 			JOptionPane.showMessageDialog(null, "Withdrawal request rejected because of insufficient funds");
        return "redirect:/Customer";
    }
    
    @RequestMapping("/EmpLogin")  
    public String EmpLoginPage(Model m){  
    	m.addAttribute("command", new UserBean());
    	return "EmpLogin"; 
    }  
    
	@RequestMapping(value="/EmployeeLogin",method=RequestMethod.POST)
	public String Emplogin(UserBean u)
	{
						
		if(u.getEmail().equals("admin@gmail.com") && u.getPassword().equals("admin"))
		{
			return "Admin";
		}
	
		else if((u.getEmail().equals("hr@gmail.com"))&&(u.getPassword().equals("hr123")))
		{
			return "HR";
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid Email or Password");
	
			return "EmpLogin";
		}
		
	}
		  
    @RequestMapping("/CustReg")  
    public String CustomerRegistration(Model m){  
    	m.addAttribute("command", new UserBean());
    	return "CustReg"; 
    }
    
    @RequestMapping("/EmpReg")  
    public String EmployeeRegistration(Model m){  
    	m.addAttribute("command", new UserBean());
    	return "EmpReg"; 
    }  
   
    @RequestMapping(value="/SignUp",method = RequestMethod.POST)  
    public String SignUp(@ModelAttribute("user") UserBean user){  
        dao.SignUp(user);  
        return "redirect:/Customer";
    }  
    
    @RequestMapping(value="/Register",method = RequestMethod.POST)
    public String Register(@ModelAttribute("user") UserBean user,HttpSession ses) throws SQLException{  
	    List<UserBean> list=dao.Salary(user);
	    for (UserBean u2 : list) 
			{
				int salary=u2.getEmp_salary();
		        dao.Register(user,salary);  
			}
        return "redirect:/ViewEmp";
    }
    
    @RequestMapping(value="/AcctDetails")  
    public String showacctdetails(@RequestParam long number, ModelMap m){  
	    List<UserBean> list=dao.acctdetails(number);
		m.put("mylist1", list);
        return "AcctDetails";  
    }  
    
    @RequestMapping("/ViewEmp")  
    public String ViewEmp(Model m){  
        List<UserBean> list=dao.getEmployees();  
        m.addAttribute("list",list);
        return "ViewEmp";  
    } 
    
    @RequestMapping("/ViewCust")  
    public String viewcancelledemp(Model m){  
        List<UserBean> list=dao.getCustomers();  
        m.addAttribute("list",list);
        return "ViewCust";  
    }  
    
   
    
	@RequestMapping(value="/Logout")  
    public String logout(){  
		return "Index";  
    }   

}  
//@RequestMapping(value="/profile/{id}")  
//public String showprofile(@PathVariable int id, Model m){  
//    Emp emp=dao.getEmpById(id);  
//    m.addAttribute("command",emp);
//    return "profile";  
//}  