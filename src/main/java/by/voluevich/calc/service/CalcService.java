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

    public CalcService(MathOperationDao mathOperationDao) {
        this.mathOperationDao = mathOperationDao;
    }

    public MathOperationDao getMathOperationDao() {
        return mathOperationDao;
    }

    public List<MathOperation> getHistory(User user) {
        return mathOperationDao.getBySession(user);
    }

    public MathOperation getResult(MathOperation mathOperation, User user){
        mathOperation.setUser(user);
        Operation operation = OperationManager.getOperation(mathOperation.getType());

        mathOperation.setResult(operation.calculate(mathOperation.getNumOne(), mathOperation.getNumTwo()));
        mathOperationDao.save(mathOperation);
        return mathOperation;
    }
}
