package com.clipboard.ui.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ShareDetails {
    private String parentWindow;

    public String getParentWindow() {
        return parentWindow;
    }

    public void setParentWindow(String parentWindow) {
        this.parentWindow = parentWindow;
    }

}
