package dao;

import org.springframework.stereotype.Repository;

import domain.Good;

//bean�� �ڵ������� �޶�� �ϴ� ������̼�
@Repository
public class GoodDao {
	//�޼ҵ�
	//�󼼺��⸦ ���� �޼ҵ�
	//�⺻Ű�� �Ű������� �޾Ƽ� �ϳ��� DTO�� �����ؼ� ����
	public Good detail(int num) {
		Good good = new Good();
		good.setNum(1);
		good.setName("����");
		return good;
	}
}
