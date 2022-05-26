package dao.Impl;

import dao.DataInputDao;
import utils.JDBCTools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataInputDaoImpl implements DataInputDao {
    //读取文件类ReadFile的构造方法
    public void ReadFile(String tableName,String filePath) throws IOException, SQLException {

        Connection conn= JDBCTools.getConnection();

        String sql="insert into "+tableName+"(id,name,sex,major,hometown) values(?,?,?,?,?)";

        File file=new File(filePath);
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        String line;
        int count=0;
        String id = null;
        String name = null;
        String sex = null;
        String major = null;
        String hometown = null;
        while((line = br.readLine()) !=null){
            System.out.println(line);
//            String[] res = line.split("\n");
            switch (count){
                case 0:
                    id=line.substring(line.indexOf('=')+1);
                    break;
                case 1:
                    name=line.substring(line.indexOf('=')+1);
                    break;
                case 2:
                    sex=line.substring(line.indexOf('=')+1);
                    break;
                case 3:
                    major=line.substring(line.indexOf('=')+1);
                    break;
                case 4:
                    hometown=line.substring(line.indexOf('=')+1);
                    break;
            }
            count++;
            System.out.println(id + name + sex + major + hometown);
            int i = 0;
            if(count % 5 == 0){
                PreparedStatement pstmt=conn.prepareStatement(sql);
                pstmt.setString(1, id);
                pstmt.setString(2, name);
                pstmt.setString(3, sex);
                pstmt.setString(4, major);
                pstmt.setString(5, hometown);
                pstmt.executeUpdate();
                count = 0;
            }




        }

//        System.out.println("向数据库中添加了"+count+"条数据");
    }
}
