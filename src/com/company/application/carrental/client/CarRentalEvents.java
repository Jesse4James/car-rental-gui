package com.company.application.carrental.client;

public class CarRentalEvents {

	public static final String STARTUP = "startupParent";

	public static final String LOAD_MASTER_DATA = "loadMasterData";
	public static final String LOAD_MASTER_DATA_SUCCESSFUL = "loadMasterDataSuccessful";
	public static final String LOAD_MASTER_DATA_FAILED = "loadMasterDataFailed";

	public static final String DISPLAY = "display";
	public static final String DISPLAY_MAIN_SCREEN = "displayMainScreen";
	public static final String DISPLAY_DRIVER_SCREEN = "displayDriverScreen";

	public static final String SAVE_DRIVER_APPLICATION = "saveDriverApplication";
	public static final String SAVE_DRIVER_APPLICATION_SUCCESSFUL = "saveDriverApplicationSuccessful";
	public static final String SAVE_DRIVER_APPLICATION_FAILED = "saveDriverApplicationFailed";

	public static final String SEARCH_DRIVER = "searchDriverApplication";
	public static final String SEARCH_DRIVER_SUCCESSFUL = "searchDriverSuccessful";
	public static final String SEARCH_DRIVER_FAILED = "searchDriverFailed";
}