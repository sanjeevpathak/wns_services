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

	public List<MigrateTest> TEMP_TABLE_TEST_CRIT_1() {
		List<MigrateTest> migrated = updateMigrationData();

		List<MigrateTest> collect = migrated.stream().filter(s -> s.getVEHCAT().equals("GU"))
				.collect(Collectors.toList());
		return collect;
	}

	public List<CritGU> critGU() {
		List<MigrateTest> collect = updateMigrationData();

		List<CritGU> CRIT_GU = new ArrayList<CritGU>();
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
			CRIT_GU.add(gu);
		});

		List<CritGU> crit_gu_2 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getAPIACPT() != null && s.getAPIRULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("APIA");
			gu.setACCEPTCRIT(s.getAPIACPT());
			gu.setINTERNETJEP(s.getAPIRULE());
			crit_gu_2.add(gu);
		});

		CRIT_GU.addAll(crit_gu_2);
		List<CritGU> crit_gu_3 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getSUNACPT() != null && s.getSUNRULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("SUNCORP");
			gu.setACCEPTCRIT(s.getSUNACPT());
			gu.setINTERNETJEP(s.getSUNRULE());
			crit_gu_3.add(gu);
		});

		CRIT_GU.addAll(crit_gu_3);
		List<CritGU> crit_gu_4 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getV03ACPT() != null && s.getV03RULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("VERO3");
			gu.setACCEPTCRIT(s.getV03ACPT());
			gu.setINTERNETJEP(s.getV03RULE());
			crit_gu_4.add(gu);
		});

		CRIT_GU.addAll(crit_gu_4);

		List<CritGU> crit_gu_5 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getV05ACPT() != null && s.getV05RULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("VERO5");
			gu.setACCEPTCRIT(s.getV05ACPT());
			gu.setINTERNETJEP(s.getV05RULE());
			crit_gu_5.add(gu);
		});

		CRIT_GU.addAll(crit_gu_5);

		List<CritGU> crit_gu_6 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getGIOACPT() != null && s.getGIORULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("GIO");
			gu.setACCEPTCRIT(s.getGIOACPT());
			gu.setINTERNETJEP(s.getGIORULE());
			crit_gu_6.add(gu);
		});

		CRIT_GU.addAll(crit_gu_6);

		List<CritGU> crit_gu_7 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getESSACPT() != null && s.getESSRULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("ESSENTIALS");
			gu.setACCEPTCRIT(s.getESSACPT());
			gu.setINTERNETJEP(s.getESSRULE());
			crit_gu_7.add(gu);
		});

		CRIT_GU.addAll(crit_gu_7);

		List<CritGU> crit_gu_8 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getBINGLEACPT() != null && s.getBINGLERULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("BINGLE");
			gu.setACCEPTCRIT(s.getBINGLEACPT());
			gu.setINTERNETJEP(s.getBINGLERULE());
			crit_gu_8.add(gu);
		});

		CRIT_GU.addAll(crit_gu_8);

		List<CritGU> crit_gu_9 = new ArrayList<CritGU>();
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
			crit_gu_9.add(gu);
		});

		CRIT_GU.addAll(crit_gu_9);

		List<CritGU> crit_gu_10 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getJCIACPT() != null && s.getJCIRULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("JCI");
			gu.setACCEPTCRIT(s.getJCIACPT());
			gu.setINTERNETJEP(s.getJCIRULE());
			crit_gu_10.add(gu);
		});

		CRIT_GU.addAll(crit_gu_10);
		List<CritGU> crit_gu_11 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getSHNACPT() != null && s.getSHNRULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("SHANNONS");
			gu.setACCEPTCRIT(s.getSHNACPT());
			gu.setINTERNETJEP(s.getSHNRULE());
			crit_gu_11.add(gu);
		});

		CRIT_GU.addAll(crit_gu_11);

		List<CritGU> crit_gu_12 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getAMPACPT() != null && s.getAMPRULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("AMP");
			gu.setACCEPTCRIT(s.getAMPACPT());
			gu.setINTERNETJEP(s.getAMPRULE());
			crit_gu_12.add(gu);
		});

		CRIT_GU.addAll(crit_gu_12);

		return CRIT_GU;

	}

	public List<MigrateTest> TEMP_TABLE_TEST_CRIT_2() {
		List<MigrateTest> migrated = updateMigrationData();

		List<MigrateTest> collect = migrated.stream().filter(s -> s.getVEHCAT().equals("CI"))
				.collect(Collectors.toList());
		return collect;

	}

	public List<CritGU> critCI() {

		List<MigrateTest> collect = TEMP_TABLE_TEST_CRIT_2();
		List<CritGU> CRIT_CI = new ArrayList<CritGU>();

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
			CRIT_CI.add(gu);
		});
		return CRIT_CI;

	}

	public List<MigrateTest> TEMP_TABLE_TEST_CRIT_3() {
		List<MigrateTest> migrated = updateMigrationData();

		List<MigrateTest> collect = migrated.stream().filter(s -> s.getVEHCAT().equals("BK"))
				.collect(Collectors.toList());
		return collect;

	}

	public List<CritGU> critBK() {
		List<MigrateTest> collect = TEMP_TABLE_TEST_CRIT_3();
		List<CritGU> CRIT_BK = new ArrayList<CritGU>();
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
			CRIT_BK.add(gu);
		});
		List<CritGU> CRIT_BK_1 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getAPIACPT() != null && s.getAPIRULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("APIA");
			gu.setACCEPTCRIT(s.getAPIACPT());
			gu.setINTERNETJEP(s.getAPIRULE());
			CRIT_BK_1.add(gu);
		});

		CRIT_BK.addAll(CRIT_BK_1);

		List<CritGU> CRIT_BK_2 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getSUNACPT() != null && s.getSUNRULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("SUNCORP");
			gu.setACCEPTCRIT(s.getSUNACPT());
			gu.setINTERNETJEP(s.getSUNRULE());
			CRIT_BK_2.add(gu);
		});

		CRIT_BK.addAll(CRIT_BK_2);
		List<CritGU> CRIT_BK_3 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getGIOACPT() != null && s.getGIORULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("GIO");
			gu.setACCEPTCRIT(s.getGIOACPT());
			gu.setINTERNETJEP(s.getGIORULE());
			CRIT_BK_3.add(gu);
		});

		CRIT_BK.addAll(CRIT_BK_3);

		List<CritGU> CRIT_BK_4 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getSHNACPT() != null && s.getSHNRULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("SHANNONS");
			gu.setACCEPTCRIT(s.getSHNACPT());
			gu.setINTERNETJEP(s.getSHNRULE());
			CRIT_BK_4.add(gu);
		});

		CRIT_BK.addAll(CRIT_BK_4);

		List<CritGU> CRIT_BK_5 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getAMPACPT() != null && s.getAMPRULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("AMP");
			gu.setACCEPTCRIT(s.getAMPACPT());
			gu.setINTERNETJEP(s.getAMPRULE());
			CRIT_BK_5.add(gu);
		});

		CRIT_BK.addAll(CRIT_BK_5);

		List<CritGU> CRIT_BK_6 = new ArrayList<CritGU>();
		collect.stream().filter(s -> s.getIMRACPT() != null && s.getIMRRULE() != null).forEach(s -> {

			gu.setNVIC(s.getNVIC());
			gu.setVEHCAT(s.getVEHCAT());
			gu.setEFFECTIVEDATE(s.getEFFECTIVEDATE());
			gu.setCHANGETIMESTAMP(s.getCHANGETIMESTAMP());
			gu.setEFFECTIVEENDDATE(s.getEFFECTIVEENDDATE());
			gu.setENDDATETIMESTAMP(s.getENDDATETIMESTAMP());
			gu.setCOMPANY("IMR");
			gu.setACCEPTCRIT(s.getIMRACPT());
			gu.setINTERNETJEP(s.getIMRRULE());
			CRIT_BK_6.add(gu);
		});

		CRIT_BK.addAll(CRIT_BK_6);

		return CRIT_BK;
	}

	public List<CritGU> TEMP_TABLE_TEST_CRIT_4() {
	//	List<CritGU> 
		List<CritGU> critGU = critGU();
		critGU.addAll(critCI());
		critGU.addAll(critBK());

		return critGU;
	}

	public List<CritGU> finalCritExt() {
		List<CritGU> CRIT_EXT = TEMP_TABLE_TEST_CRIT_4();
		CRIT_EXT.stream().forEach(s -> s.setADDMOD("ADD"));

		List<CritGU> FINAL_CRIT_EXT = new ArrayList<>();

		for (CritGU critGU : CRIT_EXT) {
			if (!(critGU.getNVIC().charAt(0) =='!' && "CI".equals(critGU.getVEHCAT()))) {
				FINAL_CRIT_EXT.add(critGU);
			}

		}
		try {
			ExcelWriter.createExcelSheet(FINAL_CRIT_EXT);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return FINAL_CRIT_EXT;

	}

}
