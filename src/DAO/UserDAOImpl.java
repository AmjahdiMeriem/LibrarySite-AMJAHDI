package DAO;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import Model.RoleUser;
import Model.User;

public class UserDAOImpl implements IUserDAO {

	@Override
	public boolean saveClient(User user) throws UnsupportedEncodingException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/AchatLivres ?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",
					"root", "");
			PreparedStatement pr = cn.prepareStatement("INSERT INTO user VALUES(NULL,?,?,?,?)");
			pr.setString(1, user.getNameUser());
			pr.setString(2, user.getEmailUser());
			pr.setString(3, user.getPasswordUser());
			pr.setLong(4, user.getIdRoleUser());
			pr.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//--------------------------------------------------------------------------------------------------------------------//
	@Override
	public void deletClient(Long idUser) {
		// TODO Auto-generated method stub

	}

	// --------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<User> findClientAll() {
		// TODO Auto-generated method stub
		return null;
	}

	// --------------------------------------------------------------------------------------------------------------------//
	@Override
	public boolean editColRole(Long idUser, RoleUser roleUser) {
		// TODO Auto-generated method stub
		return false;
	}
	// --------------------------------------------------------------------------------------------------------------------//s
}
