package com.mishamba.day2.util.restorer;

import com.mishamba.day2.model.CustomText;
import com.mishamba.day2.util.exception.UtilException;

public interface Restorer {
    String restore(CustomText text) throws UtilException;
}
