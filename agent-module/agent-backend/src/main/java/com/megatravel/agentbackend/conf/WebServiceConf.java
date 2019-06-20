package com.megatravel.agentbackend.conf;

import com.megatravel.agentbackend.client.MegaTravelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

@Configuration
public class WebServiceConf extends WsConfigurerAdapter {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.megatravel.agentbackend.ws");
        marshaller.setSupportDtd(false);
        marshaller.setProcessExternalEntities(false);
        return marshaller;
    }

    @Bean
    public MegaTravelClient megaTravelClientClient(Jaxb2Marshaller marshaller) {
        MegaTravelClient client = new MegaTravelClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }




}
