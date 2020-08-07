package com.wns.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.wns.entity.CritGU;
import com.wns.utils.CSVUtils;

public class CSVWriter {

	public static void createExcelSheet(List<CritGU> crit) throws IOException, InvalidFormatException {
		String csvFile = "FINAL_CRIT_EXT.csv";
		FileWriter writer = new FileWriter(csvFile);

		CSVUtils.writeLine(writer, Arrays.asList("NVIC", "VEHCAT", "COMPANY", "EFFECTIVEDATE", "CHANGETIMESTAMP",
				"EFFECTIVEENDDATE", "ENDDATETIMESTAMP", "ACCEPTCRIT", "INTERNETJEP", "ADDMOD"));

		for (CritGU string : crit) {
			List<String> list = new ArrayList<>();
			list.add(string.getNVIC());
			list.add(string.getVEHCAT());
			list.add(string.getCOMPANY());
			list.add(string.getEFFECTIVEDATE());
			list.add(string.getCHANGETIMESTAMP());
			list.add(string.getEFFECTIVEENDDATE());
			list.add(string.getENDDATETIMESTAMP());
			list.add(string.getACCEPTCRIT());
			list.add(string.getINTERNETJEP());
			list.add(string.getADDMOD());
			CSVUtils.writeLine(writer, list);
		}
		writer.flush();
		writer.close();

	}
}
