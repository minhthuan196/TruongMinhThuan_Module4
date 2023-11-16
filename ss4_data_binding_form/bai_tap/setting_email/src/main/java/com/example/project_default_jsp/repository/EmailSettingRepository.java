package com.example.project_default_jsp.repository;

import com.example.project_default_jsp.model.EmailSetting;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class EmailSettingRepository implements IEmailSettingRepository {
    private static EmailSetting emailSetting = new EmailSetting("English", 5, true, "Thuan");
    private static List<String> languages = new ArrayList<>();
    private static List<Integer> pageSize = new ArrayList<>();

    static {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
    }

    @Override
    public EmailSetting displayEmailSetting() {
        return emailSetting;
    }

    @Override
    public List<String> displayAllLanguages() {
        return languages;
    }

    @Override
    public List<Integer> displayAllPageSize() {
        return pageSize;
    }

    @Override
    public EmailSetting updateEmailSetting(EmailSetting emailSetting1) {
        emailSetting.setLanguages(emailSetting1.getLanguages());
        emailSetting.setSignature(emailSetting1.getSignature());
        emailSetting.setPageSize(emailSetting1.getPageSize());
        emailSetting.setSpamsFilter(emailSetting1.getSpamsFilter());
        return emailSetting;
    }
}
