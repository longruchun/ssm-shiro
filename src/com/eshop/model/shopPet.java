package com.eshop.model;

import java.util.Date;

public class shopPet {
    private Integer id;

    private String name;

    private String typename;

    private Integer health;

    private Integer love;

    private String birthday;

    private Integer ownerId;

    private Integer storeId;

    private Double price;

    private String photo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getLove() {
        return love;
    }

    public void setLove(Integer love) {
        this.love = love;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

	/**
	 * @param id
	 * @param name
	 * @param typename
	 * @param health
	 * @param love
	 * @param birthday
	 * @param ownerId
	 * @param storeId
	 * @param price
	 * @param photo
	 */
	public shopPet(Integer id, String name, String typename, Integer health, Integer love, String birthday,
			Integer ownerId, Integer storeId, Double price, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.typename = typename;
		this.health = health;
		this.love = love;
		this.birthday = birthday;
		this.ownerId = ownerId;
		this.storeId = storeId;
		this.price = price;
		this.photo = photo;
	}

	/**
	 * @param name
	 * @param typename
	 * @param health
	 * @param love
	 * @param birthday
	 * @param ownerId
	 * @param storeId
	 * @param price
	 * @param photo
	 */
	public shopPet(String name, String typename, Integer health, Integer love, String birthday, Integer ownerId,
			Integer storeId, Double price, String photo) {
		super();
		this.name = name;
		this.typename = typename;
		this.health = health;
		this.love = love;
		this.birthday = birthday;
		this.ownerId = ownerId;
		this.storeId = storeId;
		this.price = price;
		this.photo = photo;
	}

	/**
	 * @param name
	 * @param typename
	 * @param health
	 * @param love
	 * @param birthday
	 * @param ownerId
	 * @param storeId
	 * @param price
	 */
	public shopPet(String name, String typename, Integer health, Integer love, String birthday, Integer ownerId,
			Integer storeId, Double price) {
		super();
		this.name = name;
		this.typename = typename;
		this.health = health;
		this.love = love;
		this.birthday = birthday;
		this.ownerId = ownerId;
		this.storeId = storeId;
		this.price = price;
	}

	/**
	 * 
	 */
	public shopPet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "shopPet [id=" + id + ", name=" + name + ", typename=" + typename + ", health=" + health + ", love="
				+ love + ", birthday=" + birthday + ", ownerId=" + ownerId + ", storeId=" + storeId + ", price=" + price
				+ ", photo=" + photo + "]";
	}
    
	
    
}