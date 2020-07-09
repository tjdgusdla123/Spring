package kr.co.pk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import kr.co.pk.item.domain.Item;

public class ExcelView extends AbstractXlsView {

	//workbook은 출력할 엑셀 파일
	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//출력할 데이터 가져오기
		List<Item> list = (List<Item>)model.get("list");
		//시트를 생성
		Sheet sheet = workbook.createSheet("ITEM");
		
		//열 너비 설정
		sheet.setColumnWidth(1, 256*20);
		sheet.setColumnWidth(2, 256*40);
		sheet.setColumnWidth(3, 256*20);
		
		//제목 셀 생성
		
		//0번 행 생성
		Row firstRow = sheet.createRow(0);
		
		//셀 생성
		Cell cell = firstRow.createCell(0);
		cell.setCellValue("상품명");
		
		cell = firstRow.createCell(1);
		cell.setCellValue("상품 설명");
		
		cell = firstRow.createCell(2);
		cell.setCellValue("가격");
		
		//데이터 출력
		
		//행번호를 저장할 변수
		int rowNum = 1;
		for(Item item : list) {
			//행을 생성
			Row row = sheet.createRow(rowNum++);
			//셀을 생성해서 출력
			Cell c = row.createCell(0);
			c.setCellValue(item.getItemname());
			
			c = row.createCell(1);
			c.setCellValue(item.getDescription());
			
			c = row.createCell(2);
			c.setCellValue(item.getPrice() + "원");
		}
		
	}

}


