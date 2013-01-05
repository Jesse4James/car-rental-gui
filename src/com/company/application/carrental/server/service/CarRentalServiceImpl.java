package com.company.application.carrental.server.service;

import org.apache.log4j.Logger;

import com.company.application.carrental.client.model.vo.MasterDataVO;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationInput;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationOutput;
import com.company.application.carrental.client.model.vo.SearchDriverInput;
import com.company.application.carrental.client.model.vo.SearchDriverOutput;
import com.company.application.carrental.client.service.interfaces.CarRentalService;
import com.company.application.carrental.server.transformUtil.DriverServiceClientTransformUtil;
import com.company.carrental.services.api.service.DriverService;
import com.company.carrental.services.api.service.generic.CarRentalServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CarRentalServiceImpl extends RemoteServiceServlet implements CarRentalService {

    private static final long serialVersionUID = 7030418212489596688L;
    private static final Logger LOG = Logger.getLogger(CarRentalServiceImpl.class);
    private DriverService driverService = (DriverService) CarRentalServiceFactory.getDriverService();

    public MasterDataVO getMasterData() throws Throwable {
        MasterDataVO masterDataVO = new MasterDataVO();

        return masterDataVO;
    }

    public SaveDriverApplicationOutput saveDriverApplication(SaveDriverApplicationInput input) {
        SaveDriverApplicationOutput output = new SaveDriverApplicationOutput();

        driverService.saveDriver(DriverServiceClientTransformUtil.transformToDriverMasterDto(input));
        // CarRentalServiceFactory.getDriverService().saveDriver(driverMasterDto);
        return output;
    }

    public SearchDriverOutput searchDriver(SearchDriverInput input) {
        SearchDriverOutput output = new SearchDriverOutput();

        return output;
    }
}