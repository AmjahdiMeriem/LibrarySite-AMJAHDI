package Service;

import java.util.List;

import DAO.ILangueLivreDAO;
import DAO.LangueLivreDAOImpl;
import Model.LangueLivre;

public class LangueLivreServiceImpl implements ILangueLivreService{

	ILangueLivreDAO dao=new LangueLivreDAOImpl();
	
	@Override
	public List<LangueLivre> findLangueAll() {
		return dao.findLangueAll();
	}

	@Override
	public void addLangueLivre(LangueLivre langue) {
		dao.addLangueLivre(langue);
		
	}

	@Override
	public void removeLangueLivre(Long idLangue) {
		dao.removeLangueLivre(idLangue);
		
	}

}
