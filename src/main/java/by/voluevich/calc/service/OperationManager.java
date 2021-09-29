package by.voluevich.calc.service;

import by.voluevich.calc.service.operations.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class OperationManager {
    private List<Operation> operationList;

    public OperationManager(List<Operation> operationList) {
        this.operationList = operationList;
    }

    public List<String> getNameOperations(){
        List<String> list = new ArrayList<>();
        for (Operation op: operationList){
           list.add(op.getClass().getSimpleName());
        }
        return list;
    }

    public Operation getOperation(String type){
        return operationList.stream().filter(op -> op.getClass().getSimpleName().equals(type)).findFirst().get();

    }

}
