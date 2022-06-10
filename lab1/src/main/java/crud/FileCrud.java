package crud;

import FileIO.FileIO;
import FileIO.FileIOInterface;
import trees.Trees;

public class FileCrud implements Lab2CrudInterface {
	
	FileIOInterface fio;

	public FileCrud() {
	this.fio = new FileIO();
	}

	@Override
	public Trees readTrees() {
		// TODO Auto-generated method stub
		return (Trees) fio.loadFromFile();
	}

	@Override
	public void updateTrees(Trees trees) {
		// TODO Auto-generated method stub
		fio.saveToFile(trees);

	}
}