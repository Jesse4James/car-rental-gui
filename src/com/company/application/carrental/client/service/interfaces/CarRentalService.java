package com.company.application.carrental.client.service.interfaces;

import com.company.application.carrental.client.model.vo.MasterDataVO;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationInput;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationOutput;
import com.company.application.carrental.client.model.vo.SearchDriverInput;
import com.company.application.carrental.client.model.vo.SearchDriverOutput;
import com.google.gwt.user.client.rpc.RemoteService;

public interface CarRentalService extends RemoteService {

	MasterDataVO getMasterData() throws Throwable;

	SaveDriverApplicationOutput saveDriverApplication(SaveDriverApplicationInput input);

	SearchDriverOutput searchDriver(SearchDriverInput input);
}
