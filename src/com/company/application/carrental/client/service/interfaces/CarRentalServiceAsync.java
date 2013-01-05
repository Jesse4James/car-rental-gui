package com.company.application.carrental.client.service.interfaces;

import com.company.application.carrental.client.model.vo.MasterDataVO;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationInput;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationOutput;
import com.company.application.carrental.client.model.vo.SearchDriverInput;
import com.company.application.carrental.client.model.vo.SearchDriverOutput;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CarRentalServiceAsync {

	public void getMasterData(AsyncCallback<MasterDataVO> callback);

	public void saveDriverApplication(SaveDriverApplicationInput input, AsyncCallback<SaveDriverApplicationOutput> callback);

	public void searchDriver(SearchDriverInput input, AsyncCallback<SearchDriverOutput> callback);
}