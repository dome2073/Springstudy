package com.bitcamp.mvc.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.bitcamp.mvc.model.PageRank;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class PageRanksPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
List<PageRank> pageRanks = (List<PageRank>)model.get("pageRanks");
		
		//테이블 생성
		Table table = new Table(2,pageRanks.size()+1);
		table.setPadding(5);
		
		//사용자 폰트 등록
		BaseFont bf = BaseFont.createFont("c:\\windows\\fonts\\batang.ttc,0", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(bf); //폰트 등록
		
		//테이블에 셀을 만들어서 넣어줌
		//첫번째 셀
		Cell cell = new Cell(new Paragraph("순위",font));
		cell.setHeader(true);
		//테이블에 셀등록
		table.addCell(cell);
		
		//두번째 셀
		cell = new Cell(new Paragraph("페이지",font));
		//테이블에 셀등록
		table.addCell(cell);
		table.endHeaders();
		
		
		for(PageRank rank : pageRanks) {
			table.addCell(Integer.toString(rank.getRank()));
			table.addCell(rank.getPage());
		}
		document.add(table);
	}

	
	
}
