package trees;

import java.util.ArrayList;
import java.util.List;

public class Mock {

	private List<Trees> treesList = new ArrayList<>();

	public Mock() {
		this.treesList.add(new Trees(0, "Oak", 400, "big tree"));
		this.treesList.add(new Trees(1, "Sakura", 500, "beautiful tree"));
		this.treesList.add(new Trees(2, "Bonsai", 800, "small tree"));
	
	}
	
	public List<Trees> getTreesList() {
		return treesList;
	}

	public void setTreesList(List<Trees> treesList) {
		this.treesList = treesList;
	}


	
	
}

