package Service;

import java.util.List;

import Model.LangueLivre;

public interface ILangueLivreService {

	public List<LangueLivre> findLangueAll();

	public void addLangueLivre(LangueLivre langue);

	public void removeLangueLivre(Long idLangue);

}
