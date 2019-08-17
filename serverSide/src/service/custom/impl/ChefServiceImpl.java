package service.custom.impl;

import business.BoFactory;
import business.custom.ChefBo;
import dto.ChefDTO;
import dto.EmployeeLogInDTO;
import entity.Chef;
import service.custom.ChefService;

public class ChefServiceImpl implements ChefService {
    private static ChefBo chefBo;

    public ChefServiceImpl(){
        initializeReceptionistBo();
    }

    private void initializeReceptionistBo(){
        if(chefBo==null) {
            chefBo = (ChefBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.CHEF);
        }
    }

    @Override
    public boolean addChef(ChefDTO chefDTO, EmployeeLogInDTO employeeLogInDTO) throws Exception {
        return chefBo.addChef(chefDTO,employeeLogInDTO);
    }

    @Override
    public boolean updateChef(ChefDTO chefDTO) throws Exception {
        return chefBo.updateChef(chefDTO);
    }

    @Override
    public ChefDTO searchChef(String chefFirstName) throws Exception {
        Chef chef = chefBo.searchChef(chefFirstName);
        ChefDTO chefDTO=new ChefDTO(chef.getChefID_PK(),chef.getChefF_Name(),chef.getChefL_Name(),chef.getChefAddress(),chef.getChef_NicNO(),chef.getChefTel());
        return chefDTO;
    }

    @Override
    public boolean deleteChef(String chefFirstName) throws Exception {
        return chefBo.deleteChef(chefFirstName);
    }
}
