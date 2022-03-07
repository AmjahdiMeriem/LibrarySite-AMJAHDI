package Service;

import java.util.List;

import DAO.IPannierDAO;
import DAO.PannierDAOImpl;
import Model.Livre;

public class PannierServiceImpl implements IPannierService{

	IPannierDAO dao=new PannierDAOImpl();
	
	@Override
	public void addLivrePannier(Long idUser, Long ISBN) {
		dao.addLivrePannier(idUser, ISBN);
		
	}

	@Override
	public List<Livre> findLivrePannierByIdUsr(Long idUser) {
		return dao.findLivrePannierByIdUsr(idUser);
	}


}
