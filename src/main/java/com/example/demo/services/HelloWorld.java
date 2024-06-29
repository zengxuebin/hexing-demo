package com.example.demo.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author CaoLongHui
 * @since 2024/6/29 12:49
 */

@WebService(name="HelloWorld", targetNamespace = "webservice.cxf.com")
public interface HelloWorld {

    @WebMethod(operationName = "say")
    String say(@WebParam(name = "str") String str);
}
