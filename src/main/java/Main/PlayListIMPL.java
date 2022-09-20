package Main;

import Dao.PlayListDao;
import Data.PlayList;
import Util.DbConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayListIMPL implements PlayListDao {
    Scanner scanner=new Scanner(System.in);

    @Override
    public List<PlayList> insertIntoPlaylist(String PLAYLIST_NAME, int USER_ID) {
        List<PlayList> playLists = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            String sql = "INSERT INTO PLAYLIST(PLAYLIST_NAME,USER_ID) VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, PLAYLIST_NAME);
            preparedStatement.setInt(2, USER_ID);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return playLists;
    }


    @Override
    public List<PlayList> searchPlayListByName(String playListName) {
        List<PlayList> playLists = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM PLAYLIST WHERE PLAYLIST_NAME ='" + playListName + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(" PLAYLIST_ID--------PLAYLIST_NAME-------USER_ID------------SONG_NAME------------DURATION------------PATH_LOCATION ");
            System.out.println(" =================================================================================================================");
            while (resultSet.next()) {
                System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s", resultSet.getString(1),
                        resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playLists;
    }

    @Override
    public List<PlayList> showAllPlayList() {
        List<PlayList> playLists = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM JUCKBOX.PLAYLIST";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(" PLAYLIST_ID--------PLAYLIST_NAME-------USER_ID------------SONG_NAME------------DURATION------------PATH_LOCATION ");
            System.out.println(" =================================================================================================================");
            while (resultSet.next()) {
                System.out.format("%-20s%-20s%-20s%-20s%-20s%-30s", resultSet.getString(1),
                        resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
                System.out.println();
                //System.out.format(resultSet.getString(1)+"\t\t"+resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return playLists;
    }

    @Override
    public List<PlayList> searchPlayListById(int userId) {
        List<PlayList> playLists = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM PLAYLIST WHERE  USER_ID ='" + userId + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(" PLAYLIST_ID--------PLAYLIST_NAME-------USER_ID------------SONG_NAME------------DURATION------------PATH_LOCATION ");
            System.out.println(" =================================================================================================================");
            while (resultSet.next()) {
                System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s", resultSet.getString(1),
                        resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
                System.out.println();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return playLists;
    }
    @Override
    public void createNewTable(String playLIstName){
        try {
            Connection connection = DbConnection.getConnection();
            String sql =String.format("CREATE TABLE %s"+ "(Play_Id int,"+"song_Name varchar(200),"+"Duration varchar(20))",playLIstName);
            //String sql1= sql.replace("$TableName",playLIstName);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //Statement statement = connection.createStatement();

        preparedStatement.execute(sql);
            System.out.println("PLAYLIST CREATED");
            BufferedReader br=new BufferedReader((new InputStreamReader(System.in)));
            int playid= Integer.parseInt(br.readLine());
            String name= br.readLine();
            String duration= br.readLine();
            String sql2=String.format("INSERT INTO %s (Play_Id,song_name,Duration)  VALUES(?,?,?)",playLIstName);
            PreparedStatement  preparedStatement1 = connection.prepareStatement(sql2);


            preparedStatement1.setInt(1,playid);
            preparedStatement1.setString(2,name);
            preparedStatement1.setString(3,duration);
            int i=preparedStatement1.executeUpdate();
            if (i>0)
            System.out.println(i+"Data inserted");
           // String sql3= sql.replace("$TABLENAME1",playLIstName);
           // preparedStatement.executeUpdate(sql2);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }


    }
}
