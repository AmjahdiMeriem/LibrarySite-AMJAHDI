package Service;

import java.util.List;

import DAO.GenreLivreDAOImpl;
import DAO.IGenreLivreDAO;
import Model.GenreLivre;

public class GenreLivreServiceImpl implements IGenreLivreService{

	IGenreLivreDAO dao=new GenreLivreDAOImpl();
	
	@Override
	public List<GenreLivre> findGenreLivre() {
		return dao.findGenreLivre();
	}

	@Override
	public void removeGenreLivre(Long idGenreLivre) {
		dao.removeGenreLivre(idGenreLivre);
	}

	@Override
	public void addGenreLivre(GenreLivre genre) {
		dao.addGenreLivre(genre);
	}

}
