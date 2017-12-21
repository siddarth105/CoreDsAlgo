package CmptrNCmpble;

public class Person implements Comparable<Person>{
	
	private String Name;
	private Integer age;
	private Integer hieght;
	
	public String getName() {
		return Name;
	}
	public Integer getAge() {
		return age;
	}
	public Integer getHieght() {
		return hieght;
	}
	public Person(String name, Integer age, Integer hieght) {
		super();
		Name = name;
		this.age = age;
		this.hieght = hieght;
	}
	
	/*@Override
	public int compareTo(Object obj) {
		Person per = (Person) obj;
		return this.Name.compareTo(per.getName());
	}*/
	
	
	@Override
	public int compareTo(Person per) {
		if(this.age < per.getAge()) {
			return 1;
		} else if (this.age > per.getAge()) {
			return -1;
		} else  {
			return 0;
		}
	}
}
