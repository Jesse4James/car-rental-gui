package com.company.application.carrental.server.transformUtil;

import java.util.ArrayList;
import java.util.List;

import com.company.application.carrental.client.model.vo.DriverMasterClientDto;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationInput;
import com.company.carrental.data.pojo.DriverMaster;
import com.company.carrental.services.core.dto.DriverMasterDto;


public class DriverServiceClientTransformUtil{
 

    public static List<DriverMasterDto> transformToDriverMasterDtoList(List<DriverMaster> driverMasterList){
        List<DriverMasterDto> driverMasterDtoList = new ArrayList<DriverMasterDto>();
        for(DriverMaster driverMaster : driverMasterList){
//            driverMasterDtoList.add(transformToDriverMasterDto(driverMaster));
        }
        
        return driverMasterDtoList;
        
    }
       
    public static DriverMasterDto transformToDriverMasterDto(SaveDriverApplicationInput saveDriverApplicationInput){        
        if(saveDriverApplicationInput == null){
            return null;
        }
        DriverMasterClientDto driverMasterClientDto = saveDriverApplicationInput.getDriverMasterClientDto();
        
        DriverMasterDto driverMasterDto = new DriverMasterDto();
        driverMasterDto.setDriverId(driverMasterClientDto.getDriverId());
        driverMasterDto.setDriverFullName(driverMasterClientDto.getDriverFullName());
        driverMasterDto.setGender(driverMasterClientDto.getGender());
        driverMasterDto.setDob(driverMasterClientDto.getDob());
        driverMasterDto.setTotalExperience(driverMasterClientDto.getTotalExperience());
        driverMasterDto.setPrimaryContactNumber(driverMasterClientDto.getPrimaryContactNumber());
        driverMasterDto.setCurrentAreaId(driverMasterClientDto.getCurrentAreaId());
        driverMasterDto.setLicenceNo(driverMasterClientDto.getLicenceNo());
        driverMasterDto.setLicenceType(driverMasterClientDto.getLicenceType());
        driverMasterDto.setLicenceExpiryDate(driverMasterClientDto.getLicenceExpiryDate());
//        driverMasterDto.setJobPrefIndividual(driverMaster.get);
        driverMasterDto.setCarTypeAutomatic(driverMasterClientDto.getCarTypeAutomatic());
        driverMasterDto.setCarTypeManual(driverMasterClientDto.getCarTypeManual());
        driverMasterDto.setRatingId(driverMasterClientDto.getRatingId());
        driverMasterDto.setReferenceName(driverMasterClientDto.getReferenceName());
        driverMasterDto.setReferenceNumber(driverMasterClientDto.getReferenceNumber());
        driverMasterDto.setMedicalHistory(driverMasterClientDto.getMedicalHistory());
        driverMasterDto.setAccidentHistory(driverMasterClientDto.getAccidentHistory());

        
        return driverMasterDto;
    }
    
    public static List<DriverMaster> transformToDriverMasterList(List<DriverMasterDto> driverMasterDtoList){
        List<DriverMaster> driverMasterList = new ArrayList<DriverMaster>();
        for(DriverMasterDto driverMasterDto : driverMasterDtoList){
            driverMasterList.add(transformToDriverMaster(driverMasterDto));
        }
        
        return driverMasterList;
        
    }
    
    public static DriverMaster transformToDriverMaster(DriverMasterDto driverMasterDto){        
        if(driverMasterDto == null){
            return null;
        }
        
        DriverMaster driverMaster = new DriverMaster();
        driverMaster.setDriverId(driverMasterDto.getDriverId());
        driverMaster.setDriverFullName(driverMasterDto.getDriverFullName());
        driverMaster.setGender(driverMasterDto.getGender());
        driverMaster.setDob(driverMasterDto.getDob());
        driverMaster.setTotalExperience(driverMasterDto.getTotalExperience());
        driverMaster.setPrimaryContactNumber(driverMasterDto.getPrimaryContactNumber());
        driverMaster.setCurrentAreaId(driverMasterDto.getCurrentAreaId());
        driverMaster.setLicenceNo(driverMasterDto.getLicenceNo());
        driverMaster.setLicenceType(driverMasterDto.getLicenceType());
        driverMaster.setLicenceExpiryDate(driverMasterDto.getLicenceExpiryDate());
//        driverMasterDto.setJobPrefIndividual(driverMaster.get);
        driverMaster.setCarTypeAutomatic(driverMasterDto.getCarTypeAutomatic());
        driverMaster.setCarTypeManual(driverMasterDto.getCarTypeManual());
        driverMaster.setRatingId(driverMasterDto.getRatingId());
        driverMaster.setReferenceName(driverMasterDto.getReferenceName());
        driverMaster.setReferenceNumber(driverMasterDto.getReferenceNumber());
        driverMaster.setMedicalHistory(driverMasterDto.getMedicalHistory());
        driverMaster.setAccidentHistory(driverMasterDto.getAccidentHistory());

        
        return driverMaster;
    }
    
}