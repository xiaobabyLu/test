package cn.tuniu.dao.vo;
/**
 * 表数据设计，需要操作的实例表及其相关的字段
 * @author luyufeng2
 *
 */
public class Emp {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	private int id;
	private String name;
	private String product;
	

}
