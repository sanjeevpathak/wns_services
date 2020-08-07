package com.wns.entity;

public class CritGU {
	String NVIC;
	String VEHCAT;
	String EFFECTIVEDATE;
	String CHANGETIMESTAMP;
	String EFFECTIVEENDDATE;
	String ENDDATETIMESTAMP;
	String  COMPANY ;
	String  ACCEPTCRIT;
	String  INTERNETJEP;
	String ADDMOD;
	public CritGU() {
		super();
		
	}
	public CritGU(String nVIC, String vEHCAT, String eFFECTIVEDATE, String cHANGETIMESTAMP, String eFFECTIVEENDDATE,
			String eNDDATETIMESTAMP, String cOMPANY, String aCCEPTCRIT, String iNTERNETJEP, String aDDMOD) {
		super();
		NVIC = nVIC;
		VEHCAT = vEHCAT;
		EFFECTIVEDATE = eFFECTIVEDATE;
		CHANGETIMESTAMP = cHANGETIMESTAMP;
		EFFECTIVEENDDATE = eFFECTIVEENDDATE;
		ENDDATETIMESTAMP = eNDDATETIMESTAMP;
		COMPANY = cOMPANY;
		ACCEPTCRIT = aCCEPTCRIT;
		INTERNETJEP = iNTERNETJEP;
		ADDMOD = aDDMOD;
	}
	public String getNVIC() {
		return NVIC;
	}
	public void setNVIC(String nVIC) {
		NVIC = nVIC;
	}
	public String getVEHCAT() {
		return VEHCAT;
	}
	public void setVEHCAT(String vEHCAT) {
		VEHCAT = vEHCAT;
	}
	public String getEFFECTIVEDATE() {
		return EFFECTIVEDATE;
	}
	public void setEFFECTIVEDATE(String eFFECTIVEDATE) {
		EFFECTIVEDATE = eFFECTIVEDATE;
	}
	public String getCHANGETIMESTAMP() {
		return CHANGETIMESTAMP;
	}
	public void setCHANGETIMESTAMP(String cHANGETIMESTAMP) {
		CHANGETIMESTAMP = cHANGETIMESTAMP;
	}
	public String getEFFECTIVEENDDATE() {
		return EFFECTIVEENDDATE;
	}
	public void setEFFECTIVEENDDATE(String eFFECTIVEENDDATE) {
		EFFECTIVEENDDATE = eFFECTIVEENDDATE;
	}
	public String getENDDATETIMESTAMP() {
		return ENDDATETIMESTAMP;
	}
	public void setENDDATETIMESTAMP(String eNDDATETIMESTAMP) {
		ENDDATETIMESTAMP = eNDDATETIMESTAMP;
	}
	public String getCOMPANY() {
		return COMPANY;
	}
	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}
	public String getACCEPTCRIT() {
		return ACCEPTCRIT;
	}
	public void setACCEPTCRIT(String aCCEPTCRIT) {
		ACCEPTCRIT = aCCEPTCRIT;
	}
	public String getINTERNETJEP() {
		return INTERNETJEP;
	}
	public void setINTERNETJEP(String iNTERNETJEP) {
		INTERNETJEP = iNTERNETJEP;
	}
	public String getADDMOD() {
		return ADDMOD;
	}
	public void setADDMOD(String aDDMOD) {
		ADDMOD = aDDMOD;
	}
}
