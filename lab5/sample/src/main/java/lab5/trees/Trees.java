package lab5.trees;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

	/**
	 * 
	 */

	@Entity
	@Table(name="trees1")
	public class Trees  {
		@Id
		@GeneratedValue
	private int id;
	private String title;
	private int age;
	private String info;
	
	
	
	public Trees(int id,String title, int age, String info) {
		super();
		this.id = id;
		this.title = title;
		this.age = age;
		this.info = info;
	}
	
	
	
	
	public Trees() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "{\"id\": \""+id+"\",\"title\":\""+title+"\",\"age\":"+age+", \"info\":\""+info+"\"}";
	}
}
