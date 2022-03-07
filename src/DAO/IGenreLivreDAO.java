package DAO;

import java.util.List;

import Model.GenreLivre;

public interface IGenreLivreDAO {
	
	public List<GenreLivre>  findGenreLivre();
	
	public void addGenreLivre(GenreLivre genre);
	
	public void removeGenreLivre(Long idGenreLivre);

}
