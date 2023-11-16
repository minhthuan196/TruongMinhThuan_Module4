package com.example.project_default_jsp.service;

import com.example.project_default_jsp.model.EmailSetting;

import java.util.List;

public interface IEmailSettingService {
    EmailSetting displayEmailSetting();

    List<String> displayAllLanguages();
    List<Integer> displayAllPageSize();
    EmailSetting updateEmailSetting(EmailSetting emailSetting);
}
