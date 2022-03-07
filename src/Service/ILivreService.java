package Service;

import java.util.List;

import Model.Livre;

public interface ILivreService {
	public boolean add(Livre livre);
	public List<Livre> findBookAll(); 
	public List<Livre> findBookByLangKind(Long idGenre,Long idLangue);
	public Livre findBookByISBN(Long isbn);
	public void removeLivre(Long isbn);
}
