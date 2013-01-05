package com.company.application.carrental.client.service.proxy;

import com.company.application.carrental.client.model.vo.MasterDataVO;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationInput;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationOutput;
import com.company.application.carrental.client.model.vo.SearchDriverInput;
import com.company.application.carrental.client.model.vo.SearchDriverOutput;
import com.company.application.carrental.client.service.interfaces.CarRentalService;
import com.company.application.carrental.client.service.interfaces.CarRentalServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public final class CarRentalServiceProxy {

	public static final String SERVICE_NAME = "car-rental-service";
	private static CarRentalServiceProxy instance;
	private CarRentalServiceAsync proxy;

	/**
	 * Proxy instantiation
	 */
	private CarRentalServiceProxy() {
		proxy = (CarRentalServiceAsync) GWT.create(CarRentalService.class);
		((ServiceDefTarget) proxy).setServiceEntryPoint(GWT.getModuleBaseURL() + SERVICE_NAME);
	}

	public static synchronized CarRentalServiceProxy getInstance() {
		if (instance == null) {
			instance = new CarRentalServiceProxy();
		}

		return instance;
	}

	public void getMasterData(AsyncCallback<MasterDataVO> callback) {
		proxy.getMasterData(callback);
	}

	public void saveDriverApplication(SaveDriverApplicationInput input, AsyncCallback<SaveDriverApplicationOutput> callback) {
		proxy.saveDriverApplication(input, callback);
	}

	public void searchDriver(SearchDriverInput input, AsyncCallback<SearchDriverOutput> callback) {
		proxy.searchDriver(input, callback);
	}
}