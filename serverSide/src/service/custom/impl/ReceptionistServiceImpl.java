package service.custom.impl;

import business.BoFactory;
import business.custom.ReceptionistBo;
import dto.EmployeeLogInDTO;
import dto.ReceptionistDTO;
import entity.Receptionist;
import service.custom.ReceptionistService;

public class ReceptionistServiceImpl implements ReceptionistService {
    private static ReceptionistBo receptionistBo;

    public ReceptionistServiceImpl(){
        initializeReceptionistBo();
    }

    private void initializeReceptionistBo(){
        if(receptionistBo==null) {
            receptionistBo = (ReceptionistBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.RECEPTIONIST);
        }
    }

    @Override
    public boolean addReceptionist(ReceptionistDTO receptionistDTO, EmployeeLogInDTO employeeLogInDTO) throws Exception {
        return receptionistBo.addReceptionist(receptionistDTO,employeeLogInDTO);
    }

    @Override
    public boolean updateReceptionist(ReceptionistDTO receptionistDTO) throws Exception {
        return receptionistBo.updateReceptionist(receptionistDTO);
    }

    @Override
    public ReceptionistDTO searchReceptionist(String receptionistFirstName) throws Exception {
        Receptionist receptionist = receptionistBo.searchReceptionist(receptionistFirstName);
        ReceptionistDTO receptionistDTO=new ReceptionistDTO(receptionist.getReceptionistID_PK(),receptionist.getReceptionistF_Name(),receptionist.getReceptionistL_Name(),receptionist.getReceptionistAddress(),receptionist.getReceptionistNicNO(),receptionist.getReceptionistTel());
        return receptionistDTO;
    }

    @Override
    public boolean deleteReceptionist(String receptionistFirstName) throws Exception {
        return receptionistBo.deleteReceptionist(receptionistFirstName);
    }
}
