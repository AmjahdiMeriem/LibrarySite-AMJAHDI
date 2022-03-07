package Service;

import java.util.List;

import Model.GenreLivre;

public interface IGenreLivreService {

	public List<GenreLivre> findGenreLivre();

	public void addGenreLivre(GenreLivre genre);

	public void removeGenreLivre(Long idGenreLivre);

}
