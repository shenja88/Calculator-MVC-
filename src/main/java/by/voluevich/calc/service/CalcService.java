package by.voluevich.calc.service;

import by.voluevich.calc.entity.MathOperation;
import by.voluevich.calc.entity.User;
import by.voluevich.calc.service.operations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalcService {
    private List<Operation> operationList;
    private final List<MathOperation> mathOperationList  = new ArrayList<>();

    @Autowired
    public CalcService(List<Operation> operationList) {
        this.operationList = operationList;
    }

    public CalcService() {
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public List<MathOperation> getMathOperationList(User user) {
        return mathOperationList.stream().filter(u -> u.getUser().equals(user)).collect(Collectors.toList());
    }

    public MathOperation getResult(MathOperation mathOperation){
        for (Operation op : operationList){
            if(op.getName().equals(mathOperation.getType())){
                mathOperation.setResult(op.calculate(mathOperation.getNumOne(), mathOperation.getNumTwo()));
            }
        }
        mathOperationList.add(mathOperation);
        return mathOperation;
    }


}
