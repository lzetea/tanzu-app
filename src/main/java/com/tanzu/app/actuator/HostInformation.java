package com.tanzu.app.actuator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-application-info-custom
@Component
public class HostInformation implements InfoContributor {

    private static final Logger LOG = LoggerFactory.getLogger(HostInformation.class);

    @Override
    public void contribute(Info.Builder builder) {

        StringBuilder sb = new StringBuilder();
        try {

            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("openssl version -a");

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line;
            int i = 0;

            while((line=input.readLine()) != null) {
                // Keep only first 3 lines of output
                if(i < 3){
                    sb.append(line).append(" ");
                }
                i++;
            }

            int exitVal = pr.waitFor();
        } catch(Exception e) {
            LOG.warn("An error occurred while retrieving Openssl version", e);
        }

        builder.withDetail("openssl", sb.toString());
    }
}
