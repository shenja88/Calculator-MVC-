package by.voluevich.calc.service;

import by.voluevich.calc.service.operations.*;

import java.util.*;

public class OperationManager {
    private static final Map<String, Operation> OPERATIONS = new HashMap<>();

    static {
        OPERATIONS.put(Addition.class.getName(), new Addition());
        OPERATIONS.put(Division.class.getName(), new Division());
        OPERATIONS.put(Modulo.class.getName(), new Modulo());
        OPERATIONS.put(Multiplication.class.getName(), new Multiplication());
        OPERATIONS.put(Subtraction.class.getName(), new Subtraction());
    }

    public static Set<String> getNameOperations(){
        return OPERATIONS.keySet();
    }

    public static Operation getOperation(String type){
        return OPERATIONS.get(type);
    }

}
