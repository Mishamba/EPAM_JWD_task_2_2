package com.mishamba.day2.service;

import com.mishamba.day2.model.CustomText;
import com.mishamba.day2.service.exception.ServiceException;

public interface SentenceService {
    CustomText splitText(String text) throws ServiceException;
    String recreateText();
}
