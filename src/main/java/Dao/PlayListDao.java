package Dao;

import Data.PlayList;

import java.util.List;

public interface PlayListDao {
   // public void createNewTable(String playListName);
    public List<PlayList> searchPlayListById(int userId);

    public List<PlayList> insertIntoPlaylist(String PLAYLIST_NAME, int SONG_ID);
    List<PlayList> searchPlayListByName(String playListName);
    public List<PlayList> showAllPlayList();

}
