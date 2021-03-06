package com.bolen.ssm.model;

public class Book {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column book.id
	 * @mbggenerated  Fri Mar 30 17:13:22 CST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column book.name
	 * @mbggenerated  Fri Mar 30 17:13:22 CST 2018
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column book.price
	 * @mbggenerated  Fri Mar 30 17:13:22 CST 2018
	 */
	private Double price;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column book.id
	 * @return  the value of book.id
	 * @mbggenerated  Fri Mar 30 17:13:22 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column book.id
	 * @param id  the value for book.id
	 * @mbggenerated  Fri Mar 30 17:13:22 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column book.name
	 * @return  the value of book.name
	 * @mbggenerated  Fri Mar 30 17:13:22 CST 2018
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column book.name
	 * @param name  the value for book.name
	 * @mbggenerated  Fri Mar 30 17:13:22 CST 2018
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column book.price
	 * @return  the value of book.price
	 * @mbggenerated  Fri Mar 30 17:13:22 CST 2018
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column book.price
	 * @param price  the value for book.price
	 * @mbggenerated  Fri Mar 30 17:13:22 CST 2018
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Book(Integer id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}