package com.wns.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
//(name="MIGRATE_TEST")
public class MigrateTest {
	@Id
	@Column 
	Integer id ;
	@Column 
	String NVIC;
	@Column 
	String VEHCAT;
	@Column 
	String AMPACPT;
	@Column 
	String AAMACPT;
	@Column 
	String APIACPT;
	@Column 
	String GIOACPT;
	@Column 
	String SUNACPT;
	@Column 
	String SHNACPT;
	@Column 
	String GIOCIACPT;
	@Column 
	String JCIACPT;
	@Column 
	String BINGLEACPT;
	@Column 
	String ESSACPT;
	@Column 
	String V03ACPT;
	@Column 
	String V05ACPT;
	@Column 
	String AAMRULE;
	@Column 
	String AMPRULE;
	@Column 
	String APIRULE;
	@Column 
	String GIORULE;
	@Column 
	String SUNRULE;
	@Column 
	String SHNRULE;
	@Column 
	String ESSRULE;
	@Column 
	String V03RULE;
	@Column 
	String V05RULE;
	@Column 
	String JCIRULE;
	@Column 
	String GIOCIRULE;
	@Column 
	String BINGLERULE;
	@Column 
	String IMRACPT;
	@Column 
	String IMRRULE;
	@Transient
	String EFFECTIVEDATE;
	@Transient
	String CHANGETIMESTAMP;
	@Transient
	String EFFECTIVEENDDATE;
	@Transient
	String ENDDATETIMESTAMP;

	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getAMPACPT() {
		return AMPACPT;
	}
	public void setAMPACPT(String aMPACPT) {
		AMPACPT = aMPACPT;
	}
	public String getAAMACPT() {
		return AAMACPT;
	}
	public void setAAMACPT(String aAMACPT) {
		AAMACPT = aAMACPT;
	}
	public String getAPIACPT() {
		return APIACPT;
	}
	public void setAPIACPT(String aPIACPT) {
		APIACPT = aPIACPT;
	}
	public String getGIOACPT() {
		return GIOACPT;
	}
	public void setGIOACPT(String gIOACPT) {
		GIOACPT = gIOACPT;
	}
	public String getSUNACPT() {
		return SUNACPT;
	}
	public void setSUNACPT(String sUNACPT) {
		SUNACPT = sUNACPT;
	}
	public String getSHNACPT() {
		return SHNACPT;
	}
	public void setSHNACPT(String sHNACPT) {
		SHNACPT = sHNACPT;
	}
	public String getGIOCIACPT() {
		return GIOCIACPT;
	}
	public void setGIOCIACPT(String gIOCIACPT) {
		GIOCIACPT = gIOCIACPT;
	}
	public String getJCIACPT() {
		return JCIACPT;
	}
	public void setJCIACPT(String jCIACPT) {
		JCIACPT = jCIACPT;
	}
	public String getBINGLEACPT() {
		return BINGLEACPT;
	}
	public void setBINGLEACPT(String bINGLEACPT) {
		BINGLEACPT = bINGLEACPT;
	}
	public String getESSACPT() {
		return ESSACPT;
	}
	public void setESSACPT(String eSSACPT) {
		ESSACPT = eSSACPT;
	}
	public String getV03ACPT() {
		return V03ACPT;
	}
	public void setV03ACPT(String v03acpt) {
		V03ACPT = v03acpt;
	}
	public String getV05ACPT() {
		return V05ACPT;
	}
	public void setV05ACPT(String v05acpt) {
		V05ACPT = v05acpt;
	}
	public String getAAMRULE() {
		return AAMRULE;
	}
	public void setAAMRULE(String aAMRULE) {
		AAMRULE = aAMRULE;
	}
	public String getAMPRULE() {
		return AMPRULE;
	}
	public void setAMPRULE(String aMPRULE) {
		AMPRULE = aMPRULE;
	}
	public String getAPIRULE() {
		return APIRULE;
	}
	public void setAPIRULE(String aPIRULE) {
		APIRULE = aPIRULE;
	}
	public String getGIORULE() {
		return GIORULE;
	}
	public void setGIORULE(String gIORULE) {
		GIORULE = gIORULE;
	}
	public String getSUNRULE() {
		return SUNRULE;
	}
	public void setSUNRULE(String sUNRULE) {
		SUNRULE = sUNRULE;
	}
	public String getSHNRULE() {
		return SHNRULE;
	}
	public void setSHNRULE(String sHNRULE) {
		SHNRULE = sHNRULE;
	}
	public String getESSRULE() {
		return ESSRULE;
	}
	public void setESSRULE(String eSSRULE) {
		ESSRULE = eSSRULE;
	}
	public String getV03RULE() {
		return V03RULE;
	}
	public void setV03RULE(String v03rule) {
		V03RULE = v03rule;
	}
	public String getV05RULE() {
		return V05RULE;
	}
	public void setV05RULE(String v05rule) {
		V05RULE = v05rule;
	}
	public String getJCIRULE() {
		return JCIRULE;
	}
	public void setJCIRULE(String jCIRULE) {
		JCIRULE = jCIRULE;
	}
	public String getGIOCIRULE() {
		return GIOCIRULE;
	}
	public void setGIOCIRULE(String gIOCIRULE) {
		GIOCIRULE = gIOCIRULE;
	}
	public String getBINGLERULE() {
		return BINGLERULE;
	}
	public void setBINGLERULE(String bINGLERULE) {
		BINGLERULE = bINGLERULE;
	}
	public String getIMRACPT() {
		return IMRACPT;
	}
	public void setIMRACPT(String iMRACPT) {
		IMRACPT = iMRACPT;
	}
	public String getIMRRULE() {
		return IMRRULE;
	}
	public void setIMRRULE(String iMRRULE) {
		IMRRULE = iMRRULE;
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
}
