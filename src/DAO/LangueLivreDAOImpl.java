package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.LangueLivre;

public class LangueLivreDAOImpl implements ILangueLivreDAO {
//--------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<LangueLivre> findLangueAll() {
		LangueLivre langue = new LangueLivre();
		List<LangueLivre> langues = new ArrayList<LangueLivre>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/AchatLivres ?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",
					"root", "");
			PreparedStatement pr = cn.prepareStatement("SELECT * FROM languelivre");
			ResultSet r = pr.executeQuery();
			while (r.next()) {
				langue.setIdLangueLivre(r.getLong(1));
				langue.setNomLangueLivre(r.getString(2));

				langues.add(langue);
				langue = new LangueLivre();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return langues;
	}

//--------------------------------------------------------------------------------------------------------------------//
	@Override
	public void addLangueLivre(LangueLivre langue) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3308/AchatLivres ?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",
					"root", "");
			PreparedStatement pr = cn.prepareStatement("INSERT INTO langueLivre VALUES(NULL,?)");
			pr.setString(1, langue.getNomLangueLivre());
			pr.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//--------------------------------------------------------------------------------------------------------------------//
	@Override
	public void removeLangueLivre(Long idLangue) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3308/AchatLivres ?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",
					"root", "");

			PreparedStatement pr = cn.prepareStatement("DELETE FROM languelivre WHERE idLangueLivre=?");

			pr.setLong(1, idLangue);
			pr.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//--------------------------------------------------------------------------------------------------------------------//
}
