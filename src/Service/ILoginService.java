package Service;

import java.io.UnsupportedEncodingException;

import Model.User;

public interface ILoginService {
	
	public User checkLogin(User user) throws UnsupportedEncodingException;

}
