package p1;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class plane extends ActionSupport {
	private static final long serialVersionUID = 1L;
	String company;
	String from;
	String to;
	static String c="-";
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}


	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public void validate()
	{
	String s=getFrom();
	String ss=getTo();
	
	//validate that the from date and to date are not same	
	}
	public String execute() throws Exception
	{
		System.out.println("in execute");
		CreateChart chart=new CreateChart();
		DisplayData data=new DisplayData();
		HttpSession s=ServletActionContext.getRequest().getSession();
		s.setAttribute("name", company);
		if(getCompany().equals("IBM")&& getFrom().equals("")&& getTo().equals("")){
			data.DisplayDefaultData("IBM_DETAILS");
		}
		else if(getCompany().equals("IBM")){
			chart.createXYChart("IBM_DETAILS", getFrom(), getTo());
			chart.createBarChart("IBM_DETAILS", getFrom(), getTo());
			chart.createSMAChart("IBM_DETAILS");
			chart.createCandlestickChart("IBM_DETAILS", getFrom(), getTo());
			data.DisplayDefaultData("IBM_DETAILS");
		}
		
		else if(getCompany().equals("Amazon")&& getFrom().equals("")&& getTo().equals("")){
			data.DisplayDefaultData("Amazon_DETAILS");
		}
		else if(getCompany().equals("Amazon")){
			chart.createXYChart("Amazon_DETAILS", getFrom(), getTo());
			chart.createBarChart("Amazon_DETAILS", getFrom(), getTo());
			chart.createSMAChart("Amazon_DETAILS");
			chart.createCandlestickChart("Amazon_DETAILS", getFrom(), getTo());
			data.DisplayDefaultData("Amazon_DETAILS");
		}
		
		
		else if(getCompany().equals("Dell")&& getFrom().equals("")&& getTo().equals("")){
			data.DisplayDefaultData("DELL_DETAILS");
		}
		else if(getCompany().equals("Dell")){
			chart.createXYChart("DELL_DETAILS", getFrom(), getTo());
			chart.createBarChart("DELL_DETAILS", getFrom(), getTo());
			chart.createSMAChart("DELL_DETAILS");
			chart.createCandlestickChart("DELL_DETAILS", getFrom(), getTo());
			data.DisplayDefaultData("DELL_DETAILS");
		}
		else if(getCompany().equals("hp")&& getFrom().equals("")&& getTo().equals("")){
			data.DisplayDefaultData("hp_DETAILS");
		}
		else if(getCompany().equals("hp")){
			chart.createXYChart("hp_DETAILS", getFrom(), getTo());
			chart.createBarChart("hp_DETAILS", getFrom(), getTo());
			chart.createSMAChart("hp_DETAILS");
			chart.createCandlestickChart("hp_DETAILS", getFrom(), getTo());
			data.DisplayDefaultData("hp_DETAILS");
		}
		else if(getCompany().equals("Oracle")&& getFrom().equals("")&& getTo().equals("")){
			data.DisplayDefaultData("ORACLE_DETAILS");
		}
		else if(getCompany().equals("Oracle")){
			chart.createXYChart("ORACLE_DETAILS", getFrom(), getTo());
			chart.createBarChart("ORACLE_DETAILS", getFrom(), getTo());
			chart.createSMAChart("ORACLE_DETAILS");
			chart.createCandlestickChart("ORACLE_DETAILS", getFrom(), getTo());
			data.DisplayDefaultData("ORACLE_DETAILS");
		}
		else{
			return ERROR;
		}
		return SUCCESS;
	}
	

}
