package service.custom.impl;

import business.BoFactory;
import business.custom.BikeRiderBo;
import dto.BikeRiderDTO;
import dto.EmployeeLogInDTO;
import service.custom.BikeRiderService;

public class BikeRiderServiceImpl implements BikeRiderService {
    private static BikeRiderBo bikeRiderBo=null;

    public BikeRiderServiceImpl(){
        try {
            initializeBikeRiderBo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeBikeRiderBo() throws Exception {
        if(bikeRiderBo==null){
            bikeRiderBo= (BikeRiderBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.BIKERIDER);
        }
    }

    @Override
    public boolean addBikeRider(BikeRiderDTO bikeRiderDTO, EmployeeLogInDTO employeeLogInDTO) throws Exception {
        return bikeRiderBo.addBikeRider(bikeRiderDTO,employeeLogInDTO);
    }

    @Override
    public boolean updateBikeRider(BikeRiderDTO bikeRiderDTO) throws Exception {
        return false;
    }

    @Override
    public BikeRiderDTO searchBikeRider(String bikeRiderFirstName) throws Exception {
        return null;
    }

    @Override
    public boolean deleteBikeRider(String bikeRiderFirstName) throws Exception {
        return false;
    }
}
