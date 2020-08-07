package com.wns.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.wns.entity.CritGU;

public class ExcelWriter {
	private static String[] columns = { "NVIC", "VEHCAT", "COMPANY", "EFFECTIVEDATE", "CHANGETIMESTAMP",
			"EFFECTIVEENDDATE", "ENDDATETIMESTAMP", "ACCEPTCRIT", "INTERNETJEP","ADDMOD" };
	// private static List<Employee> employees = new ArrayList<>();

	// Initializing employees data to insert into the excel file

	public static void createExcelSheet(List<CritGU> crit) throws IOException, InvalidFormatException {
		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		/*
		 * CreationHelper helps us create instances of various things like DataFormat,
		 * Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way
		 */
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Employee");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (CritGU critData : crit) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(critData.getNVIC());

			row.createCell(1).setCellValue(critData.getVEHCAT());

			Cell dateOfBirthCell = row.createCell(2);
			dateOfBirthCell.setCellValue(critData.getEFFECTIVEDATE());
			dateOfBirthCell.setCellStyle(dateCellStyle);

			row.createCell(3).setCellValue(critData.getCHANGETIMESTAMP());
			row.createCell(4).setCellValue(critData.getEFFECTIVEENDDATE());
			row.createCell(5).setCellValue(critData.getENDDATETIMESTAMP());
			row.createCell(6).setCellValue(critData.getCOMPANY());
			row.createCell(7).setCellValue(critData.getACCEPTCRIT());
			row.createCell(8).setCellValue(critData.getINTERNETJEP());
			row.createCell(9).setCellValue(critData.getADDMOD());
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("WNS_Final_outPut.xlsx");
		workbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		workbook.close();
	}
}
