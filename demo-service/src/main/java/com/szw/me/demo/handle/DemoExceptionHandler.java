package com.szw.me.demo.handle;

import com.szw.me.demo.enums.DemoResultEnum;
import com.szw.me.demo.exception.DemoException;
import com.szw.me.framework.util.ResultVOUtil;
import com.szw.me.framework.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class DemoExceptionHandler {

    /**
     * Validated注解抛出参数异常处理
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVO handleArgException(MethodArgumentNotValidException e) {
        StringBuffer sb = new StringBuffer();
        List<ObjectError> list = e.getBindingResult().getAllErrors();
        for (ObjectError error : list) {
            sb.append(error.getDefaultMessage()).append(";");
        }
        sb.deleteCharAt(sb.length() - 1);
        return ResultVOUtil.error(DemoResultEnum.FAILED.getCode(), sb.toString());
    }

    /**
     * SQLIntegrityConstraintViolationException处理
     */
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        e.printStackTrace();
        return ResultVOUtil.error(DemoResultEnum.DUP_KEY.getCode(), DemoResultEnum.DUP_KEY.getMessage());
    }

    /**
     * 业务异常处理
     */
    @ExceptionHandler(value = DemoException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO handleDemoException(DemoException e) {
        e.printStackTrace();
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }
}
