package kr.co.pk.item.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(XmlAccessType.FIELD)
//전체 태그를 설정
@XmlRootElement(name="ITEMLIST")
public class ItemReport {
	//DTO 1개만 출력될 태그 설정
	@XmlElement(name="ITEM")
	private List<Item> list;

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}
}
