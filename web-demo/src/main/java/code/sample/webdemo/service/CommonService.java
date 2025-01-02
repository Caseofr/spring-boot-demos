package code.sample.webdemo.service;

import code.sample.webdemo.dto.User;

import org.springframework.stereotype.Service;

@Service
public class CommonService {
    public String concatUserAttributes(User user) {
        return "User ID: " + user.getId() + ", Name: " + user.getName();
    }
}
