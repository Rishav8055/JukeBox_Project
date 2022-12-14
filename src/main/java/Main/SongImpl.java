package Main;

import Dao.SongListDao;
import Data.PlayList;
import Data.SongLists;
import Util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongImpl implements SongListDao {
    @Override
    public List<SongLists> searchBySongName(String SONG_NAME) throws SQLException {
        List<SongLists> songLists = new ArrayList<>();
            Connection connection = DbConnection.getConnection();
            //Statement statement =connection.createStatement();
            String sql = "SELECT * FROM SONG_LIST where SONG_NAME=? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,SONG_NAME);

            //song
            ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("SONG_ID---SONG_NAME-------------------------------ARTIST_NAME---------GENRE---------------DURATION------------PATH_LOCATION-----------------------------------");
        System.out.println("==============================================================================================================================================================");
        while (resultSet.next()){
            System.out.format("%-10d%-40s%-20s%-20s%-20s%-20s",resultSet.getInt(1),resultSet.getString("SONG_NAME"),
                    resultSet.getString("ARTIST_NAME"),
                    resultSet.getString("GENRE"),resultSet.getString("DURATION"),
                    resultSet.getString("PATH_LOCATION"));
            System.out.println();

               // System.out.println(resultSet.getString(1)+"\t\t"+resultSet.getString(2)
                      //  +"\t\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4)
                       // +"\t\t"+resultSet.getString(5)+"\t\t"+resultSet.getString(6));

                //songLists.add(new SongLists(resultSet.getString(1),resultSet.getString(2),
                        //resultSet.getString(3),resultSet.getString(4),
                        //resultSet.getString(5),resultSet.getString(6)));



            }


        return songLists;
    }
    @Override
    public List<SongLists> searchByArtistName(String artistName) {
        List<SongLists> songLists2 = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            String sql = "SELECT * FROM SONG_LIST WHERE ARTIST_NAME LIKE '%" + artistName + "%'";
            Statement statement =connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("SONG_ID---SONG_NAME-------------------------------ARTIST_NAME---------GENRE---------------DURATION------------PATH_LOCATION-----------------------------------");
            System.out.println("==============================================================================================================================================================");
            while (resultSet.next()){
                System.out.format("%-10d%-40s%-20s%-20s%-20s%-20s",resultSet.getInt(1),resultSet.getString("SONG_NAME"),
                        resultSet.getString("ARTIST_NAME"),
                        resultSet.getString("GENRE"),resultSet.getString("DURATION"),
                        resultSet.getString("PATH_LOCATION"));
                System.out.println();

               // songLists2.add(new SongLists(resultSet.getString(1),resultSet.getString(2),
                        //resultSet.getString(3),resultSet.getString(4),
                        //resultSet.getString(5),resultSet.getString(6)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return songLists2;
    }

    @Override
    public List<SongLists> searchByGenre(String GENRE) {
        List<SongLists> songLists3 = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            //Statement statement = connection.createStatement();
            String sql ="SELECT * FROM SONG_LIST WHERE GENRE=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,GENRE);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("SONG_ID---SONG_NAME-------------------------------ARTIST_NAME---------GENRE---------------DURATION------------PATH_LOCATION-----------------------------------");
            System.out.println("==============================================================================================================================================================");
            while (resultSet.next()){
                System.out.format("%-10d%-40s%-20s%-20s%-20s%-20s",resultSet.getInt(1),resultSet.getString("SONG_NAME"),
                        resultSet.getString("ARTIST_NAME"),
                        resultSet.getString("GENRE"),resultSet.getString("DURATION"),
                        resultSet.getString("PATH_LOCATION"));
                System.out.println();


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songLists3;
    }

    @Override
    public List<SongLists> getAllSong() {
    List<SongLists>songLists1=new ArrayList<>();
    try {
        Connection connection = DbConnection.getConnection();
        Statement statement =connection.createStatement();
        String sql="SELECT * FROM SONG_LIST ORDER BY SONG_NAME ";
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("SONG_ID---SONG_NAME-------------------------------ARTIST_NAME---------GENRE---------------DURATION------------PATH_LOCATION-----------------------------------");
        System.out.println("==============================================================================================================================================================");
        while (resultSet.next()){
            System.out.format("%-10d%-40s%-20s%-20s%-20s%-20s",resultSet.getInt(1),resultSet.getString("SONG_NAME"),
                    resultSet.getString("ARTIST_NAME"),
                    resultSet.getString("GENRE"),resultSet.getString("DURATION"),
                    resultSet.getString("PATH_LOCATION"));
            System.out.println();
           /* System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println(resultSet.getString(5));
            System.out.println(resultSet.getString(6));*/
        }

    } catch (SQLException e) {
        e.printStackTrace();

    }
        return songLists1;
    }

}
