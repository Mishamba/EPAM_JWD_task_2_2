package com.mishamba.day2.dao.impl;

import com.mishamba.day2.dao.FileDAO;
import com.mishamba.day2.dao.exception.DAOException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDAOImpl implements FileDAO {
    private final Logger logger = Logger.getRootLogger();

    private static class FileDAOHolder {
        private FileDAOHolder() {
        }

        private static final FileDAOImpl HOLDER_INSTANCE = new FileDAOImpl();
    }

    public static FileDAOImpl getInstance() {
        return FileDAOHolder.HOLDER_INSTANCE;
    }

    @Override
    public String readFile(String path) throws DAOException {
        try {
            logger.info("dao: reading the file");
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch(IOException exception) {
            logger.error("dao: reading error");
            throw new DAOException(exception);
        }
    }
}
