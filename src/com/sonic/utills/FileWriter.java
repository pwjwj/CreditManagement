package com.sonic.utills;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.sonic.pojo.StuBase;
import com.sonic.service.BaseInfoService;

public class FileWriter {
	boolean isWriteSuccess=false;
	private BaseInfoService userService;
	
	public FileWriter(BaseInfoService userService) {
		this.userService = userService;
	}

	/*public boolean writeToDataBase(){
		isWriteSuccess=false;
		try {
			
			File file=new File(ServletActionContext.getServletContext().getRealPath("/")
					+"templeate.xls");
			Workbook wb = Workbook.getWorkbook(file);
			//System.out.println("wb.getSheet(0).getRows()  "+wb.getSheet(0).getRows());
			
			for (int i = 1; i < wb.getSheet(0).getRows()-1; i++) {
				Cell[] cell = wb.getSheet(0).getRow(i);
				userService.saveStuBaseOrUpdate(new StuBase(Integer
						.parseInt(cell[0].getContents()),
						cell[1].getContents(), cell[2].getContents(), cell[3]
								.getContents(), cell[4].getContents(), Integer
								.parseInt(cell[5].getContents())));
				System.out.println(cell[1].getContents());
			}
			isWriteSuccess=true;
			wb.close();
			// 在这里应该还有一个删除的操作
			file.delete();
			return isWriteSuccess;

		} catch (Exception e) {
			e.printStackTrace();
			return isWriteSuccess;
		}
	}*/
	public boolean writeToDataBase(){
		isWriteSuccess=false;
		try {
			
			File file=new File(ServletActionContext.getServletContext().getRealPath("/")
					+"templeate.xls");
			FileInputStream fileInputStream = new FileInputStream(file);
			HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);
			//System.out.println("wb.getSheet(0).getRows()  "+wb.getSheet(0).getRows());
			int numberOfSheets=wb.getNumberOfSheets();
			String content="";
			for(int i=0;i<numberOfSheets;i++){
				HSSFSheet sheet = wb.getSheetAt(i);
				Iterator<HSSFRow> rowIterator = sheet.rowIterator();
				int rowCount=0;
				while(rowIterator.hasNext()){
					HSSFRow next = rowIterator.next();
					Iterator<HSSFCell> cellIterator = next.cellIterator();
					if(rowCount==0){
						rowCount++;
						continue;
					}
					while(cellIterator.hasNext()){
						HSSFCell cell=cellIterator.next();
						switch(cell.getCellType()){
						case HSSFCell.CELL_TYPE_STRING:
							System.out.println("string "+cell.getStringCellValue());
							content+=cell.getStringCellValue()+",";
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							System.out.println("numberic  "+cell.getNumericCellValue());
							content+=String.valueOf(cell.getNumericCellValue())+",";
						}
						
					}
					if(!content.equals("")){
						System.out.println("content  "+content);
						String[] split = content.split(",");
						BigDecimal db = new BigDecimal(split[0]);
						//System.out.println((split[2].split("."))[0]);
						userService.saveStuBaseOrUpdate(new StuBase(Integer
								.parseInt(db.toPlainString()),
								split[1], String.valueOf(Double.valueOf(split[2]).intValue()), split[3],split[4], Double.valueOf(split[5]).intValue()));
						content="";
					}
					
					
				}
			}
			isWriteSuccess=true;
			// 在这里应该还有一个删除的操作
			file.delete();
			return isWriteSuccess;
		} catch (Exception e) {
			e.printStackTrace();
			return isWriteSuccess;
		}
	}
}
