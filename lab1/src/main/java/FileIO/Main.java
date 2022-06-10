package FileIO;

import trees.Trees;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trees trees = new Trees("Mock1", 23,"qwerty");
		FileIOInterface fio = new FileIO();
		fio.saveToFile(trees);
		System.out.println((Trees)fio.loadFromFile());

	}

}
