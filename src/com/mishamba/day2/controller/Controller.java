package com.mishamba.day2.controller;

import com.mishamba.day2.controller.exception.ControllerException;
import com.mishamba.day2.model.CustomText;

public interface Controller {
    CustomText splitText(String text) throws ControllerException;
}
