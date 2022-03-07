package Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import DAO.IUserDAO;
import DAO.UserDAOImpl;
import Model.RoleUser;
import Model.User;

public class UserServiceImpl implements IUserService{
	
	private IUserDAO dao=new UserDAOImpl();
	
	@Override
	public boolean saveClient(User user) throws UnsupportedEncodingException {
		return dao.saveClient(user);
	}

	@Override
	public void deletClient(Long idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findClientAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editColRole(Long idUser, RoleUser roleUser) {
		// TODO Auto-generated method stub
		return false;
	}

}
