package com.wns.service;

import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayway.jsonpath.Predicate;
import com.wns.entity.CritGU;
import com.wns.entity.MigrateTest;
import com.wns.repository.WNSRepository;

@Service
public class WNSMigrateService {

	@Autowired
	WNSRepository repository;

	public List<MigrateTest> updateMigrationData() {

		List<MigrateTest> migrated = new ArrayList<MigrateTest>();

		DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("yyyy/MM");

		repository.findAll().forEach(s -> {
			s.setEFFECTIVEDATE(YearMonth.now().minusMonths(24).format(monthYearFormatter) + "01");
			s.setCHANGETIMESTAMP(YearMonth.now().minusMonths(24).format(monthYearFormatter) + "01000000");
			s.setEFFECTIVEENDDATE("99991231");
			s.setENDDATETIMESTAMP("99991231000000");
			migrated.add(s);
		});

		return migrated;
	}

	public List<MigrateTest> tempTableTestCrit1() {
		List<MigrateTest> migrated = updateMigrationData();

		List<MigrateTest> collect = migrated.stream().filter(s -> s.getVEHCAT().equals("GU"))
				.collect(Collectors.toList());
		return collect;
	}

	public List<CritGU> critGU() {
		List<MigrateTest> collect = updateMigrationData();

		List<CritGU> critGuData = new ArrayList<CritGU>();
		CritGU gu = new CritGU();

		collect.stream().filter(s -> s.getAAMACPT() != null && s.getAAMRULE() != null).forEach(s -> {
			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("AAMI");
			gu.setACCEPTCRIT(s.getAAMACPT());
			gu.setINTERNETJEP(s.getAAMRULE());
			critGuData.add(gu);
		});

		List<CritGU> critGuData2 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getAPIACPT() != null && s.getAPIRULE() != null).forEach(s -> {

			gu.setCOMPANY("APIA");
			gu.setACCEPTCRIT(s.getAPIACPT());
			gu.setINTERNETJEP(s.getAPIRULE());
			critGuData2.add(gu);
		});

		critGuData.addAll(critGuData2);
		List<CritGU> critGuData3 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getSUNACPT() != null && s.getSUNRULE() != null).forEach(s -> {

			gu.setCOMPANY("SUNCORP");
			gu.setACCEPTCRIT(s.getSUNACPT());
			gu.setINTERNETJEP(s.getSUNRULE());
			critGuData3.add(gu);
		});

		critGuData.addAll(critGuData3);
		List<CritGU> critGuData4 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getV03ACPT() != null && s.getV03RULE() != null).forEach(s -> {

			gu.setCOMPANY("VERO3");
			gu.setACCEPTCRIT(s.getV03ACPT());
			gu.setINTERNETJEP(s.getV03RULE());
			critGuData4.add(gu);
		});

		critGuData.addAll(critGuData4);

		List<CritGU> critGuData5 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getV05ACPT() != null && s.getV05RULE() != null).forEach(s -> {

			gu.setCOMPANY("VERO5");
			gu.setACCEPTCRIT(s.getV05ACPT());
			gu.setINTERNETJEP(s.getV05RULE());
			critGuData5.add(gu);
		});

		critGuData.addAll(critGuData5);

		List<CritGU> critGuData6 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getGIOACPT() != null && s.getGIORULE() != null).forEach(s -> {

			gu.setCOMPANY("GIO");
			gu.setACCEPTCRIT(s.getGIOACPT());
			gu.setINTERNETJEP(s.getGIORULE());
			critGuData6.add(gu);
		});

		critGuData.addAll(critGuData6);

		List<CritGU> critGuData7 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getESSACPT() != null && s.getESSRULE() != null).forEach(s -> {

			gu.setCOMPANY("ESSENTIALS");
			gu.setACCEPTCRIT(s.getESSACPT());
			gu.setINTERNETJEP(s.getESSRULE());
			critGuData7.add(gu);
		});

		critGuData.addAll(critGuData7);

		List<CritGU> critGuData8 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getBINGLEACPT() != null && s.getBINGLERULE() != null).forEach(s -> {

			gu.setCOMPANY("BINGLE");
			gu.setACCEPTCRIT(s.getBINGLEACPT());
			gu.setINTERNETJEP(s.getBINGLERULE());
			critGuData8.add(gu);
		});

		critGuData.addAll(critGuData8);

		List<CritGU> critGuData9 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getGIOCIACPT() != null && s.getGIOCIRULE() != null).forEach(s -> {

			gu.setCOMPANY("GIOCI");
			gu.setACCEPTCRIT(s.getGIOCIACPT());
			gu.setINTERNETJEP(s.getGIOCIRULE());
			critGuData9.add(gu);
		});

		critGuData.addAll(critGuData9);

		List<CritGU> critGuData10 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getJCIACPT() != null && s.getJCIRULE() != null).forEach(s -> {

			gu.setCOMPANY("JCI");
			gu.setACCEPTCRIT(s.getJCIACPT());
			gu.setINTERNETJEP(s.getJCIRULE());
			critGuData10.add(gu);
		});

		critGuData.addAll(critGuData10);
		List<CritGU> critGuData11 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getSHNACPT() != null && s.getSHNRULE() != null).forEach(s -> {

			gu.setCOMPANY("SHANNONS");
			gu.setACCEPTCRIT(s.getSHNACPT());
			gu.setINTERNETJEP(s.getSHNRULE());
			critGuData11.add(gu);
		});

		critGuData.addAll(critGuData11);

		List<CritGU> critGuData12 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getAMPACPT() != null && s.getAMPRULE() != null).forEach(s -> {

			gu.setCOMPANY("AMP");
			gu.setACCEPTCRIT(s.getAMPACPT());
			gu.setINTERNETJEP(s.getAMPRULE());
			critGuData12.add(gu);
		});

		critGuData.addAll(critGuData12);

		return critGuData;

	}

	public List<MigrateTest> tempTableTestCrit2() {

		List<MigrateTest> migrated = updateMigrationData();

		List<MigrateTest> collect = migrated.stream().filter(s -> s.getVEHCAT().equals("CI"))
				.collect(Collectors.toList());
		return collect;

	}

	public List<CritGU> critCI() {

		List<MigrateTest> collect = tempTableTestCrit2();
		List<CritGU> critCiData = new ArrayList<CritGU>();

		CritGU gu = new CritGU();
		collect.stream().filter(s -> s.getGIOCIACPT() != null && s.getGIOCIRULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("GIOCI");
			gu.setACCEPTCRIT(s.getGIOCIACPT());
			gu.setINTERNETJEP(s.getGIOCIRULE());
			critCiData.add(gu);
		});
		return critCiData;

	}

	public List<MigrateTest> tempTableTestCrit3() {

		List<MigrateTest> migrated = updateMigrationData();

		List<MigrateTest> collect = migrated.stream().filter(s -> s.getVEHCAT().equals("BK"))
				.collect(Collectors.toList());
		return collect;

	}

	public List<CritGU> critBK() {
		List<MigrateTest> collect = tempTableTestCrit3();
		List<CritGU> critBk = new ArrayList<CritGU>();
		CritGU gu = new CritGU();
		collect.stream().filter(s -> s.getAAMACPT() != null && s.getAAMRULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("AAMI");
			gu.setACCEPTCRIT(s.getAAMACPT());
			gu.setINTERNETJEP(s.getAAMRULE());
			critBk.add(gu);
		});
		List<CritGU> critBk1 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getAPIACPT() != null && s.getAPIRULE() != null).forEach(s -> {

			gu.setCOMPANY("APIA");
			gu.setACCEPTCRIT(s.getAPIACPT());
			gu.setINTERNETJEP(s.getAPIRULE());
			critBk1.add(gu);
		});

		critBk.addAll(critBk1);

		List<CritGU> critBk2 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getSUNACPT() != null && s.getSUNRULE() != null).forEach(s -> {

			gu.setCOMPANY("SUNCORP");
			gu.setACCEPTCRIT(s.getSUNACPT());
			gu.setINTERNETJEP(s.getSUNRULE());
			critBk2.add(gu);
		});

		critBk.addAll(critBk2);
		List<CritGU> critBk3 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getGIOACPT() != null && s.getGIORULE() != null).forEach(s -> {

			gu.setCOMPANY("GIO");
			gu.setACCEPTCRIT(s.getGIOACPT());
			gu.setINTERNETJEP(s.getGIORULE());
			critBk3.add(gu);
		});

		critBk.addAll(critBk3);

		List<CritGU> critBk4 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getSHNACPT() != null && s.getSHNRULE() != null).forEach(s -> {

			gu.setCOMPANY("SHANNONS");
			gu.setACCEPTCRIT(s.getSHNACPT());
			gu.setINTERNETJEP(s.getSHNRULE());
			critBk4.add(gu);
		});

		critBk.addAll(critBk4);

		List<CritGU> critBk5 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getAMPACPT() != null && s.getAMPRULE() != null).forEach(s -> {

			gu.setCOMPANY("AMP");
			gu.setACCEPTCRIT(s.getAMPACPT());
			gu.setINTERNETJEP(s.getAMPRULE());
			critBk5.add(gu);
		});

		critBk.addAll(critBk5);

		List<CritGU> critBk6 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getIMRACPT() != null && s.getIMRRULE() != null).forEach(s -> {

			gu.setCOMPANY("IMR");
			gu.setACCEPTCRIT(s.getIMRACPT());
			gu.setINTERNETJEP(s.getIMRRULE());
			critBk6.add(gu);
		});

		critBk.addAll(critBk6);

		return critBk;
	}

	public List<CritGU> tempTableTestCrit4() {

		List<CritGU> critGU = critGU();
		critGU.addAll(critCI());
		critGU.addAll(critBK());

		return critGU;
	}

	public List<CritGU> finalCritExt() {
		List<CritGU> critExt = tempTableTestCrit4();
		critExt.stream().forEach(s -> s.setADDMOD("ADD"));

		List<CritGU> finalCritExt = new ArrayList<>();

		for (CritGU critGU : critExt) {
			if (!(critGU.getNVIC().charAt(0) == '!' && "CI".equals(critGU.getVEHCAT()))) {
				finalCritExt.add(critGU);
			}

		}
		try {
			CSVWriter.createExcelSheet(finalCritExt);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return finalCritExt;

	}

}
