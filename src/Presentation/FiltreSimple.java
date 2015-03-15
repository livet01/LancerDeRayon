package Presentation;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class FiltreSimple extends FileFilter{
	//Description et extension accept�e par le filtre
	private String description;
	private String extension;
	//Constructeur � partir de la description et de l'extension accept�e
	public FiltreSimple(String description, String extension){
		if(description == null || extension ==null){
			throw new NullPointerException("La description (ou extension) ne peut �tre null.");	
		}
		this.description = description;
		this.extension = extension;
	}
	//Impl�mentation de FileFilter
	public boolean accept(File file){
		if(file.isDirectory()) { 
			return true; 
		} 
		String nomFichier = file.getName().toLowerCase(); 
		
		return nomFichier.endsWith(extension);
	}
	public String getDescription(){
		return description;
	}
	//Test
	public static void main(String[] args){
		FileFilter java = new FiltreSimple("Fichiers Java",".java");
		FileFilter classes = new FiltreSimple("Fichiers Class",".class");
		FileFilter jar = new FiltreSimple("Fichiers JAR",".jar");
		
		JFileChooser chooser = new JFileChooser(".");
		chooser.addChoosableFileFilter(java);
		chooser.addChoosableFileFilter(classes);
		chooser.addChoosableFileFilter(jar);
		chooser.showOpenDialog(null);
	}
}