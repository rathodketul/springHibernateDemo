package com.SpringHibernate.util;

public class Constant {
	public static final String MAIL_BODY = "<table width=600px border=0 cellpadding=5 style=border:1px solid #ccc;text-align:center; cellspacing=0>"
			+ "<tr bgcolor=#ccc><td height=20></td></tr>"
			+ "<tr bgcolor=#E5E5E5 align=center><td style=border-bottom:1px solid #ccc;height:200px;><a href=http://www.go4cabs.com><img src=http://www.go4cabs.com/img/logo.png align=center  /></a></td></tr>"
			+ "<tr bgcolor=#E5E5E5 align=center><td style=font-size:14px;line-height:25px;font-family:Tahoma, Geneva, sans-serif;>Thank you for registering with GO4Cabs.com </td></tr>"
			+ "<tr bgcolor=#E5E5E5 align=center><td style=font-size:14px;line-height:25px;font-family:Tahoma, Geneva, sans-serif;>We shall revert back to you at the earliest.</td></tr>"
			+ "<tr bgcolor=#E5E5E5><td height=30></td></tr>"
			+ "<tr bgcolor=#ccc><td height=20 align=right style=font-size:14px;line-height:25px;font-family:Tahoma, Geneva, sans-serif;color:#666;>&copy;GO Technolusion Pvt. Ltd.</td></tr>"
			+ "</table>";
	public static final String SMTP_HOST_NAME = "smtp.gmail.com";
    public static final int SMTP_HOST_PORT = 587;
    public static final String SMTP_AUTH_USER = "registration@go4cabs.com";
    public static final String SMTP_AUTH_PWD = "go4cabs.com";
    public static final String MAIL_ALIANCE="Go4Cabs";
    
    
    public static final String ALL_FIELD_ERROR_MSG="* All Fields are mandatory";
    public static final String MAILID_ERROR_MSG="* Invalid eMail ID";
    public static final String CONTACT_ERROR_MSG="* Enter Valid Mobile Number";
    public static final String PINCODE_ERROR_MSG="* Enter Valid Pin Code";
    public static final String LOGIN_FAILURE="Invalid eMail ID and Password";
    
    public static final String LOGIN_SUCCESS="SUCCESS";
    public static final int SUCCESS_CODE=1;
    public static final int ERROR_CODE=0;
}
