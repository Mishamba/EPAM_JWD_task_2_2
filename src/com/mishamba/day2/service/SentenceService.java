package com.mishamba.day2.service;

import com.mishamba.day2.service.exception.ServiceException;

public interface SentenceService {
    void splitText(String text) throws ServiceException;
    String recreateText();
}
