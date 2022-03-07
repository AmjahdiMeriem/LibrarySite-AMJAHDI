package Service;

import java.util.List;

import DAO.ILivreDAO;
import DAO.LivreDAOImpl;
import Model.Livre;

public class LivreServiceImpl implements ILivreService{
//-------------------------------------------------------------------------------------------------------------------------------//	
	ILivreDAO dao=new LivreDAOImpl(); 
	
	@Override
	public boolean add(Livre livre) {
		return dao.add(livre);
	}
//-------------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Livre> findBookAll() {
		return dao.findBookAll();
	}
//-------------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Livre> findBookByLangKind(Long idGenre, Long idLangue) {
		return dao.findBookByLangKind(idGenre, idLangue);
	}
//-------------------------------------------------------------------------------------------------------------------------------//
	@Override
	public Livre findBookByISBN(Long isbn) {
		return dao.findBookByISBN(isbn);
	}
//-------------------------------------------------------------------------------------------------------------------------------//
	@Override
	public void removeLivre(Long isbn) {
		dao.removeLivre(isbn);
	}

}
