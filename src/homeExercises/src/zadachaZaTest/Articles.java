package zadachaZaTest;

public class Articles {
	
	private String name;
	private String type;
	private String price;
	private String weight;
	private Double quantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	public Articles(String name, String type, String price, String weight, Double quantity) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.weight = weight;
		this.quantity = quantity;
	}
	
	public Articles() {
		super();
	}
	
	@Override
	public String toString() {
		return "Articles [name=" + name + ", type=" + type + ", price=" + price + ", weight=" + weight + ", quantity="
				+ quantity + "]";
	}

}
