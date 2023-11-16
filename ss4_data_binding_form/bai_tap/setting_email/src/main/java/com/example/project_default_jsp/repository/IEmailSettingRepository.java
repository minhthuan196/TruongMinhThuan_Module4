package com.example.project_default_jsp.repository;

import com.example.project_default_jsp.model.EmailSetting;

import java.util.List;

public interface IEmailSettingRepository {
    EmailSetting displayEmailSetting();

    List<String> displayAllLanguages();

    List<Integer> displayAllPageSize();

    EmailSetting updateEmailSetting(EmailSetting emailSetting);
}
