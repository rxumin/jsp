package dao;

import java.io.IOException;
import java.sql.SQLException;

public interface DataInputDao {
    public void ReadFile(String tableName,String filePath) throws IOException, SQLException;
}
