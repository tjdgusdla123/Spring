package kr.co.pk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import kr.co.pk.item.domain.Item;

public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//데이터 가져오기
		List<Item> list = (List<Item>)model.get("list");
		
		//테이블을 생성 - 앞의 숫자는 열의 수이고 뒤의 숫자는 행의 수
		Table table = new Table(3, list.size()+1);
		//패딩 설정
		table.setPadding(5);
		
		//폰트 생성 - 이 작업을 하지 않으면 한글 출력 안됨
		BaseFont bfKorean = 
			BaseFont.createFont(
				request.getServletContext().getRealPath("/font") 
				+ "/malgun.ttf",
				BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(bfKorean);
		
		//셀을 생성 - 제목 셀을 생성해서 설정
		Cell cell = new Cell(new Paragraph("상품명", font));
		cell.setHeader(true);
		table.addCell(cell);
		
		cell = new Cell(new Paragraph("상품설명", font));
		cell.setHeader(true);
		table.addCell(cell);
		
		cell = new Cell(new Paragraph("가격", font));
		cell.setHeader(true);
		table.addCell(cell);
		
		table.endHeaders();
		
		//데이터 출력
		for(Item item : list) {
			Cell imsi = new Cell(
				new Paragraph(item.getItemname(), font));
			table.addCell(imsi);
			
			imsi = new Cell(
					new Paragraph(item.getDescription(), font));
			table.addCell(imsi);
			
			imsi = new Cell(
					new Paragraph(item.getPrice() + "원", font));
			table.addCell(imsi);
		}
		//테이블을 문서에 추가
		document.add(table);

	}

}




