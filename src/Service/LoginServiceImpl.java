package Service;

import java.io.UnsupportedEncodingException;

import DAO.ILoginDAO;
import DAO.LoginDAOImpl;
import Model.User;

public class LoginServiceImpl implements ILoginService{
	
	private ILoginDAO dao=new LoginDAOImpl();
	@Override
	public User checkLogin(User user) throws UnsupportedEncodingException {
		return dao.checkLogin(user);
	}

}
