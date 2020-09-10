package com.mishamba.day2.service;

import com.mishamba.day2.model.CustomText;
import com.mishamba.day2.service.exception.ServiceException;

import java.util.ArrayList;

public interface SentenceService {
    CustomText splitText(String text) throws ServiceException;
    String recreateText(CustomText text) throws ServiceException;
    CustomText sortByWordsCount(String text) throws ServiceException;
    CustomText deleteWordsStartsWithVowels(String text) throws ServiceException;
    String findPalindrome(String text) throws ServiceException;
}
