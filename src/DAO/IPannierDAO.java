package DAO;

import java.util.List;

import Model.Livre;

public interface IPannierDAO {
	
	public void addLivrePannier(Long idUser,Long ISBN);
	public List<Livre> findLivrePannierByIdUsr(Long idUser);

}
