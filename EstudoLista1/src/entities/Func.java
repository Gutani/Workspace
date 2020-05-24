package entities;

public class Func {
	private String name;
	private int id;
	private double salary;
	public Func(String name, int id, double salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}

	public void increaseSalary(double percent) {
		this.salary = salary+(salary*percent/100);
	}
	@Override
	public String toString() {
		return "Func [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}
	
	
}
