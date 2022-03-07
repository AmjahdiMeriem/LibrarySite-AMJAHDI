package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.User;

public class LoginDAOImpl implements ILoginDAO{

	@Override
	public User checkLogin(User user) {
		User u=new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/achatlivres ?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root","");
			PreparedStatement pr=cn.prepareStatement("SELECT * FROM user WHERE EmailUser=? and PasswordUser=?");
			pr.setString(1, user.getEmailUser());
			pr.setString(2, user.getPasswordUser());
			ResultSet results=pr.executeQuery();
			while(results.next()) {
				u.setIdUser(results.getLong(1));
				u.setNameUser(results.getString(2));
				u.setEmailUser(results.getString(3));
				u.setPasswordUser(results.getString(4));
				u.setIdRoleUser(results.getLong(5));
				return u;
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
