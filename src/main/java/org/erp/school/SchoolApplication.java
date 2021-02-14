package org.erp.school;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.vaadin.artur.helpers.LaunchUtil;

@SpringBootApplication
@PWA(name = "Cloud ERP School", shortName = "Cloud ERP School", offlineResources = {"images/logo.png"})
public class SchoolApplication extends SpringBootServletInitializer implements AppShellConfigurator {

    public static void main(String[] args) {
        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(SchoolApplication.class, args));
    }
}
