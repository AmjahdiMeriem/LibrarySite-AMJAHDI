package Service;

import java.util.List;

import Model.Livre;

public interface IPannierService {

	void addLivrePannier(Long idUser,Long ISBN);
	public List<Livre> findLivrePannierByIdUsr(Long idUser);

}
