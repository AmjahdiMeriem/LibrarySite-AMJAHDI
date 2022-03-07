package Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import Model.RoleUser;
import Model.User;

public interface IUserService {
	
	public boolean saveClient(User user) throws UnsupportedEncodingException;
	
	public void deletClient(Long idUser);
	
	public List<User> findClientAll();
	
	public boolean editColRole(Long idUser,RoleUser roleUser);
}
