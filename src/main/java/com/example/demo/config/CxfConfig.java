package com.example.demo.config;

import com.example.demo.services.HelloWorld;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @author CaoLongHui
 * @since 2024/6/29 12:52
 */
@Configuration
public class CxfConfig {

    @Autowired
    private HelloWorld helloWorld;

    @Autowired
    SpringBus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, helloWorld);
        endpoint.publish("/HelloWorld");
        return endpoint;
    }

    @Bean
    public ServletRegistrationBean disServlet() {
        return new ServletRegistrationBean(new CXFServlet(),"/soap/*");
    }
}
