package com.company.application.carrental.client.ui;

import java.util.Date;

import com.sencha.gxt.widget.core.client.form.DateTimePropertyEditor;

public class CarRentalConstants {

	protected CarRentalConstants() {
		super();
	}

	public static final String ALL = "ALL";

	public static final Integer GRID_RECORDS_PER_PAGE = 10;

	public static final String NEW_LINE = "<br>";
	public static final String HORIZONTAL_LINE = "<hr>";

	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final DateTimePropertyEditor DATE_TIME_PROPERTY_EDITOR = new DateTimePropertyEditor(
			DATE_FORMAT);

	public static final Date MIN_DATE = new Date(2012 - 1900, 00, 01);
	public static final String MIN_DATE_STRING = DATE_TIME_PROPERTY_EDITOR
			.render(MIN_DATE);
	public static final Date MAX_DATE = new Date(2022 - 1900, 11, 31);
	public static final String MAX_DATE_STRING = DATE_TIME_PROPERTY_EDITOR
			.render(MAX_DATE);

	public static final Integer MIN_YEAR = 2012;
	public static final Integer MAX_YEAR = 2022;

	public static final String KPLUS_DB = "kplus";
	public static final String BRANCHES_TABLE = "Branches";
	public static final String PORTFOLIOS_TABLE = "Portfolios";
	public static final String FOLDERS_TABLE = "Folders";
	public static final String FOLDERS_GRP_TABLE = "FoldersGrp";
	public static final String TYPEOFINSTR_TABLE = "TypeOfInstr";

	public static final String DEAL_DATA = "dealData";
	public static final String MARGIN_DATA = "marginData";

	// DealModelDto constants
	public static final String DEAL_ID = "dealData.dealId";
	public static final String TRADE_DATE = "dealData.tradeDate";
	public static final String VALUE_DATE = "dealData.valueDate";
	public static final String MATURITY_DATE = "dealData.maturityDate";
	public static final String AMOUNT = "dealData.amount";
	public static final String DAY_NUMBER = "dealData.dayNumber";
	public static final String TREASURY_RATE = "dealData.treasuryRate";
	public static final String LIQUIDITY_MARGIN = "dealData.liquidityMargin";
	public static final String MIN_COMMERCIAL_MARGIN = "dealData.minCommercialMargin";
	public static final String CLIENT_RATE = "dealData.clientRate";
	public static final String BOR_RATE = "dealData.borRate";
	public static final String FTP = "dealData.ftp";
	public static final String RM_RATE = "dealData.rmRate";

	// MarginModelDto constants
	public static final String AVERAGE_AMOUNT = "marginData.averageAmount";
	public static final String HARD_MARGIN_BP = "marginData.hardMarginBp";
	public static final String LIQUIDITY_MARGIN_BP = "marginData.liquidityMarginBp";
	public static final String COMMERCIAL_MARGIN_BP = "marginData.minCommercialMarginBp";
	public static final String MARGIN_TO_BOR_BP = "marginData.marginToBORBp";
	public static final String TOTAL_MARGIN_BP = "marginData.totalMarginBp";
	public static final String TRESO_TO_BOR_MARGIN_BP = "marginData.tresoToBorMarginBp";

	public static final String HARD_MARGIN_AMT = "marginData.hardMarginAmount";
	public static final String LIQUIDITY_MARGIN_AMT = "marginData.liquidityMarginAmount";
	public static final String COMMERCIAL_MARGIN_AMT = "marginData.minCommercialMarginAmount";
	public static final String MARGIN_TO_BOR_AMT = "marginData.marginToBORAmount";
	public static final String TOTAL_MARGIN_AMT = "marginData.totalMarginAmount";
	public static final String TRESO_TO_BOR_MARGIN_AMT = "marginData.tresoToBorMarginAmount";

}