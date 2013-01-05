package com.company.application.carrental.client.model.vo.properties;

import java.util.Date;

import com.company.application.carrental.client.model.vo.DriverEmployment;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface DriverEmploymentProperties extends PropertyAccess<DriverEmployment> {

	@Path("id")
	ModelKeyProvider<DriverEmployment> key();

	@Path("name")
	LabelProvider<DriverEmployment> nameLabel();

	ValueProvider<DriverEmployment, String> employmentType();

	ValueProvider<DriverEmployment, Date> beginDate();

	ValueProvider<DriverEmployment, Date> endDate();

	ValueProvider<DriverEmployment, String> employerName();

	ValueProvider<DriverEmployment, String> companyName();

	ValueProvider<DriverEmployment, String> employerAddress();

	ValueProvider<DriverEmployment, String> employerContactNo();

	ValueProvider<DriverEmployment, String> reasonForLeaving();

	ValueProvider<DriverEmployment, Double> salary();

	ValueProvider<DriverEmployment, Character> referenceAllowed();
}