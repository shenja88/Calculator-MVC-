package by.voluevich.calc.utils;

import by.voluevich.calc.dto.MathOperationDTO;
import by.voluevich.calc.dto.UserAllFieldsDTO;
import by.voluevich.calc.dto.UserEmailPassDTO;
import by.voluevich.calc.entity.MathOperation;
import by.voluevich.calc.entity.User;

public class DTOConverter {

    public static User getUserAllField(UserAllFieldsDTO userAllFieldsDTO){
        return new User(userAllFieldsDTO.getName(), userAllFieldsDTO.getEmail(), userAllFieldsDTO.getPassword());
    }

    public static User getUserEmailPassFields(UserEmailPassDTO userAllFieldsDTO){
        return new User(userAllFieldsDTO.getEmail(), userAllFieldsDTO.getPassword());
    }

    public static MathOperation getMathOperationNumAndTypeOp(MathOperationDTO mathOperationDTO){
        return new MathOperation(mathOperationDTO.getNumOne(), mathOperationDTO.getNumTwo(), mathOperationDTO.getType());
    }
}
