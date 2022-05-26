package service.Impl;

import dao.DataInputDao;
import dao.Impl.DataInputDaoImpl;
import service.DataInputService;

import java.io.IOException;
import java.sql.SQLException;

public class DataInputServiceImpl implements DataInputService {
    DataInputDao dataInputDao = new DataInputDaoImpl();
    @Override
    public void ReadFile(String tableName, String filePath) {
        try {
            dataInputDao.ReadFile(tableName,filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
