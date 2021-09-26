package by.voluevich.calc.service;

import by.voluevich.calc.service.operations.*;

import java.util.*;

public class OperationManager {
    private static final Map<String, Operation> OPERATIONS = new HashMap<>();

    static {
        OPERATIONS.put(Addition.class.getSimpleName(), new Addition());
        OPERATIONS.put(Division.class.getSimpleName(), new Division());
        OPERATIONS.put(Modulo.class.getSimpleName(), new Modulo());
        OPERATIONS.put(Multiplication.class.getSimpleName(), new Multiplication());
        OPERATIONS.put(Subtraction.class.getSimpleName(), new Subtraction());
    }

    public static Set<String> getNameOperations(){
        return OPERATIONS.keySet();
    }

    public static Operation getOperation(String type){
        return OPERATIONS.get(type);
    }

}
