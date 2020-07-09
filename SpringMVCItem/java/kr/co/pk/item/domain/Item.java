package kr.co.pk.item.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
//출력할 속성과 순서를 설정
@XmlType(name = "", propOrder= {"itemid", "itemname", 
		"price", "description", "pictureurl"})
public class Item {
	//숫자 데이터의 경우 null 이 될 가능성이 있는 경우는 Wrapper 클래스 사용
	private Integer itemid;
	private String itemname;
	private Integer price;
	private String description;
	private String pictureurl;
	
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPictureurl() {
		return pictureurl;
	}
	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}
	
	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", itemname=" + itemname + ", price=" + price + ", description=" + description
				+ ", pictureurl=" + pictureurl + "]";
	}

}
