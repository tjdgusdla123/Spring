package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GoodDao;

//bean�� �ڵ������� �ٶ�� �ϴ� ������̼�
@Service
public class GoodServiceImpl implements GoodService {
    //DAO ������ ����
	//setter�� ������ִ� ��ɰ� ������ �ڷ����� bean�� ���Թ޾��ִ� ������̼�
	@Autowired
	private GoodDao goodDao;

	@Override
	public void detail() {
		System.out.println(goodDao.detail(1));

	}

}
