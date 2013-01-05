package com.company.application.carrental.client.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class DriverMasterVO implements Serializable {

	private static final long serialVersionUID = 3899294987247027068L;

	private Integer applicationId;
	private String applicationNo;
	private Date applicationDate;
	private Integer applicationStatusId;
	private Integer applicationStatusName;
	private String applicationRemarks;
	private Integer userId;
	private Integer userName;

	private Integer driverId;
	private String driverFullName;
	private String primaryContactNumber;
	private Integer currentAreaId;
	private char gender;
	private Date dob;
	private String maritalStatus; // bc

	private String licenceNo;
	private String licenceType;
	private Date licenceExpiryDate;

	private boolean jobPrefIndividualTemp;
	private boolean jobPrefIndividualPerm;
	private boolean jobPrefIndividualAdhoc;
	private boolean jobPrefCorporateTemp;
	private boolean jobPrefCorporatePerm;
	private boolean jobPrefCorporateAdhoc;

	private Float totalExperience;
	private Float currentSalary; // app
	private Float expectedSalary; // app

	private String medicalHistory;
	private String eyeSight;
	private String diabetes;
	private String accidentHistory;

	private Character carTypeAutomatic;
	private Character carTypeManual;

	private Integer ratingId;

	private String referenceName;
	private String referenceNumber;

	private Set<DriverContact> driverContacts;
	private Set<DriverAddress> driverAddress;
	private Set<DriverEducation> driverEducation;
	private Set<DriverEducation> driverEmployment;

	// private Set<DriverCarTypes> driverCarTypes;
	//
	// private Set<DriverDocumentsList> driverDocumentsLists;

}