package com.bitcamp.mvc.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.bitcamp.mvc.model.PageRank;

@SuppressWarnings("deprecation")
public class PageRanksXlsView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			HSSFWorkbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// 1. 시트 생성
		HSSFSheet sheet = createFirstSheet(workbook);
		
		// 2. 시트의 첫 번째 행의 라벨 적성
		createColumnLabel(sheet);
		
		// 3. 데이터들을 표현할 행 생성과 셀 생성
		List<PageRank> pageRanks = (List<PageRank>)model.get("pageRanks");
		int rowNum = 1;

		for(PageRank pageRank : pageRanks) {
			createPageRankRow(sheet, pageRank, rowNum++);			
		}
	}
	//데이터 출력 행 설정
	private void createPageRankRow(HSSFSheet sheet,PageRank pageRank, int rowNum) {
		//반복해서 만들기위해 sheet 필요하고 
		//데이터가 필요 - PageRank pageRank
		//행의 순서가 필요하기 때문에 rownumber
		
		HSSFRow row = sheet.createRow(rowNum); //로우만들기
		HSSFCell cell = row.createCell(0);//셀만들기 
		cell.setCellValue(pageRank.getRank());
		
		cell = row.createCell(1);
		cell.setCellValue(pageRank.getPage());
	}
	// 컬럼 라벨 생성
	private void createColumnLabel(HSSFSheet sheet) {
		// 행 생성
		HSSFRow firstRow = sheet.createRow(0);
		
		// 셀 생성
		HSSFCell cell = firstRow.createCell(0);
		cell.setCellValue("순위");
		
		cell = firstRow.createCell(1);
		cell.setCellValue("주소");
				
		
	}
	
	
	
	// 시트생성 메서드
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		
		HSSFSheet sheet = workbook.createSheet();
		
		workbook.setSheetName(0, "포털사이트 순위");		
		sheet.setColumnWidth(1, 256*20);
		
		return sheet;
		
		
	}
	
	

}
