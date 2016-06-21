package p1;

import com.opensymphony.xwork2.ActionSupport;

public class Mainpage extends ActionSupport{

	private static final long serialVersionUID = 1L;
	public String execute(){
		return SUCCESS;
	}
	
	public String getHome(){
		return "home";	
	}
	public String getAboutus(){
		return "aboutus";
	}
	public String getTA(){
		return "ta";
	}
	public String getHelp(){
		return "help";
	}
	public String getContactus(){
		return "contactus";
	}
}
