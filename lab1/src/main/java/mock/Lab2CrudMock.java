package mock;

import crud.Lab2CrudInterface;
import trees.Trees;

public class Lab2CrudMock implements Lab2CrudInterface {

	@Override
	public Trees readBirds() {
		// TODO Auto-generated method stub
		return new Trees("Mock1", 23, "qwerty");
	}

	@Override
	public void updateBirds(Trees trees) {
		// TODO Auto-generated method stub

	}

}