package by.voluevich.calc.service;

import by.voluevich.calc.dao.MathOperationDao;
import by.voluevich.calc.entity.MathOperation;
import by.voluevich.calc.entity.User;
import by.voluevich.calc.service.operations.Operation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcService {
    private final MathOperationDao mathOperationDao;
    private final OperationManager operationManager;

    public CalcService(MathOperationDao mathOperationDao, OperationManager operationManager) {
        this.mathOperationDao = mathOperationDao;
        this.operationManager = operationManager;
    }

    public MathOperationDao getMathOperationDao() {
        return mathOperationDao;
    }

    public OperationManager getOperationManager() {
        return operationManager;
    }

    public List<MathOperation> getHistory(User user) {
        return mathOperationDao.getBySession(user);
    }

    public MathOperation getResult(MathOperation mathOperation, User user){
        mathOperation.setUser(user);
        Operation operation = operationManager.getOperation(mathOperation.getType());

        mathOperation.setResult(operation.calculate(mathOperation.getNumOne(), mathOperation.getNumTwo()));
        mathOperationDao.save(mathOperation);
        return mathOperation;
    }
}
