package Main;

import Data.PlayList;
import Data.SongLists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class PlayListIMPLTest {
    PlayListIMPL  playListIMPL = null;
    PlayList playList;

    @BeforeEach
    void setUp() {
        playListIMPL = new PlayListIMPL();
        playList = new PlayList("PLAYLIST_NAME","USER_ID","SONG_NAME","DURATION","PATH_LOCATION");


    }

    @AfterEach
    void tearDown() {
        playList = null;
        playListIMPL = null;
    }


    @Test
    void searchPlayListByName() {
        List<PlayList> output = playListIMPL.searchPlayListByName("Wav_25mb.wav");
        assertEquals(0,output.size());
    }

    @Test
    void showAllPlayList() {
        List<PlayList> output =playListIMPL.showAllPlayList();
        assertEquals(0,output.size());
    }

    @Test
    void searchPlayListById() {
        List<PlayList> output = playListIMPL.searchPlayListById(1);
        assertEquals(0,output.size());

    }

    @Test
    void createNewTable() {
    }
}