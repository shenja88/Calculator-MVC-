package by.voluevich.calc.aspect;

import by.voluevich.calc.dto.MathOperationDTO;
import by.voluevich.calc.dto.UserAllFieldsDTO;
import by.voluevich.calc.dto.UserEmailPassDTO;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(LogAspect.class.getSimpleName());

    @Pointcut("execution(public * by.voluevich.calc.controller.AccountController.getReg(..)) && args(userDTO, ..)")
    public void reg(UserAllFieldsDTO userDTO){
    }

    @Pointcut("execution(public * by.voluevich.calc.controller.AccountController.getSignIn(..)) && args(userDTO, ..)")
    public void signIn(UserEmailPassDTO userDTO){
    }

    @Pointcut("execution(public * by.voluevich.calc.controller.CalcController.calc(..)) && args(mathOperationDTO, ..)")
    public void calc(MathOperationDTO mathOperationDTO){
    }

    @Pointcut("execution(public * by.voluevich.calc.controller.AccountController.updateName(..)) && args(name, ..)")
    public void updName(String name){
    }

    @Pointcut("execution(public * by.voluevich.calc.controller.AccountController.updatePass(..)) && args(newPass, ..)")
    public void updPass(String newPass){
    }

    @Pointcut("execution(public * by.voluevich.calc.controller.ExceptionController.exception(..)) && args(e)")
    public void ex(Exception e){
    }

    @After(value = "reg(userDTO)", argNames = "userDTO")
    public void regLog(UserAllFieldsDTO userDTO){
        logger.info("Register new user wih email - {}", userDTO.getEmail());
    }

    @After(value = "signIn(userDTO)", argNames = "userDTO")
    public void signInLog(UserEmailPassDTO userDTO){
        logger.info("Register new user wih email - {}", userDTO.getEmail());
    }

    @After(value = "calc(mathOperationDTO)", argNames = "mathOperationDTO")
    public void calcLog(MathOperationDTO mathOperationDTO){
        logger.info("Register new operation with number - {}, {}, and type operation - {}",
                mathOperationDTO.getNumOne(),
                mathOperationDTO.getNumTwo(),
                mathOperationDTO.getType());
    }

    @After(value = "updName(name)", argNames = "name")
    public void updNameLog(String name){
        logger.info("Update name, new name - {}", name);
    }

    @After(value = "updPass(newPass)", argNames = "newPass")
    public void updPassLog(String newPass){
        logger.info("Update password, new password - {}", newPass);
    }

    @After(value = "ex(e)", argNames = "e")
    public void exceptionLog(Exception e){
        logger.error(e.getMessage());
    }
}
