package by.voluevich.calc.dao;

import by.voluevich.calc.entity.MathOperation;
import by.voluevich.calc.entity.User;

import java.util.List;

public interface MathOperationDao {

    void save(MathOperation mathOperation);

    List<MathOperation> getBySession(User user);
}
