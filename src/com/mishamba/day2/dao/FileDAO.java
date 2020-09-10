package com.mishamba.day2.dao;

import com.mishamba.day2.dao.exception.DAOException;

import java.io.File;

public interface FileDAO {
    String readFile(String path) throws DAOException;
}
