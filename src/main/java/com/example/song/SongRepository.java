// Write your code here
package com.example.song;

import java.util.*;

public interface SongRepository{
    ArrayList<Song> getSongs();
    Song addsong(Song song);
    Song getsong(int id);
    Song updatesong(int id,Song song);
    void deletesong(int id);
}