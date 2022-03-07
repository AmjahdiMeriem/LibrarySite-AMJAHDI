package DAO;

import java.util.List;

import Model.Livre;

public interface ILivreDAO {

	public boolean add(Livre livre);

	public List<Livre> findBookAll();

	public List<Livre> findBookByLangKind(Long idGenre, Long idLangue);

	public Livre findBookByISBN(Long isbn);
	
	public void removeLivre(Long ISBN);
}
