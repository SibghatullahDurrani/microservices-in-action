package com.optimagrowth.licensingservice.service;

import com.optimagrowth.licensingservice.model.License;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
public class LicenseService {

    private final MessageSource messageSource;
    private DefaultMessageSourceResolvable messageSourceResolvable;

    private String responseMessage;

    public LicenseService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public License getLicense(String licenseId, String organizationId){
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");
        return license;
    }
    public String createLicense(License license, String organizationId, Locale locale){
        responseMessage = null;
        if(license != null) {
            license.setOrganizationId(organizationId);
            messageSourceResolvable = new DefaultMessageSourceResolvable("license.create.message");
            responseMessage = String.format(messageSource.getMessage(messageSourceResolvable, locale), license.toString());
        }
        return responseMessage;
    }
    public String updateLicense(License license, String organizationId, Locale locale){
        responseMessage = null;
        if(license != null) {
            license.setOrganizationId(organizationId);
            messageSourceResolvable = new DefaultMessageSourceResolvable("license.update.message");
            responseMessage = String.format(messageSource.getMessage(messageSourceResolvable, locale), license.toString());
        }
        return responseMessage;
    }
    public String deleteLicense(String licenseId, String organizationId, Locale locale){
        responseMessage = null;
        messageSourceResolvable = new DefaultMessageSourceResolvable("license.delete.message");
        responseMessage = String.format(messageSource.getMessage(messageSourceResolvable, locale), licenseId, organizationId);
        return responseMessage;
    }
}


