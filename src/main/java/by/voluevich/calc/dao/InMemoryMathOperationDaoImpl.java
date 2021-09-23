package by.voluevich.calc.dao;

import by.voluevich.calc.entity.MathOperation;
import by.voluevich.calc.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InMemoryMathOperationDaoImpl implements MathOperationDao{
    private static final List<MathOperation> OPERATIONS = new ArrayList<>();

    @Override
    public void save(MathOperation mathOperation) {
    OPERATIONS.add(mathOperation);
    }

    @Override
    public List<MathOperation> getBySession(User user) {
        return OPERATIONS.stream().filter(m -> m.getUser().equals(user)).collect(Collectors.toList());
    }
}
