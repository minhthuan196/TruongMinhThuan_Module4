package com.example.project_default_jsp.service;

import com.example.project_default_jsp.model.EmailSetting;
import com.example.project_default_jsp.repository.IEmailSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailSettingService implements IEmailSettingService {
    @Autowired
    private IEmailSettingRepository emailSettingRepository;

    @Override
    public EmailSetting displayEmailSetting() {
        return emailSettingRepository.displayEmailSetting();
    }

    @Override
    public List<String> displayAllLanguages() {
        return emailSettingRepository.displayAllLanguages();
    }

    @Override
    public List<Integer> displayAllPageSize() {
        return emailSettingRepository.displayAllPageSize();
    }

    @Override
    public EmailSetting updateEmailSetting(EmailSetting emailSetting) {
        return emailSettingRepository.updateEmailSetting(emailSetting);
    }
}
