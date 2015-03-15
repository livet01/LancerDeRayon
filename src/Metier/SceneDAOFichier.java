package Metier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SceneDAOFichier {
	
	public static void storeScene(Scene s, File f) throws RayonException {
		try {
			FileOutputStream fichier = new FileOutputStream(f.getName());
			ObjectOutputStream oos = new ObjectOutputStream(fichier);
			oos.writeObject(s);
			oos.close();
		}
		catch (IOException e) { // Si une erreur est survenu pendant la sérialisation
			throw new RayonException(e.getMessage());
		}
	}
	
	public static Scene findScene(File f) throws RayonException {
		Scene maScene = null;
		
		if(f.exists())
		{	
			// Récupération des données dans le fichier cabMedPersonne.data
			try {
				FileInputStream fic = new FileInputStream(f.getName());
				ObjectInputStream ois = new ObjectInputStream(fic);
				maScene = (Scene) ois.readObject();
				ois.close();
			}
			catch (IOException e) { // Si un problème est survenu pendant la désérialisation
				throw new RayonException(e.getMessage());
			}
			catch (ClassNotFoundException e) { // Si les classes ne correspondent pas
				throw new RayonException(e.getMessage());
			}
			
			// Dans le cas ou la désérialisation n'aurais pas marcher on renvoi un ArrayList
			if(maScene == null) 
				maScene = new Scene();
			
			return maScene;
		}
		else
			return new Scene();
	}
}
