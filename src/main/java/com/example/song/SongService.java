/*

 * You can use the following import statements
  
 * import org.springframework.http.HttpStatus;
 * import org.springframework.web.server.ResponseStatusException;

 */

package com.example.song;

import java.util.*;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.song.Song;
import com.example.song.SongRepository;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();
    int uniqueId=6;

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    // Don't modify the above code

    // Write your code here

    @Override
    public ArrayList<Song> getSongs(){
        ArrayList<Song> songs=new ArrayList<>(playlist.values());
        return songs;
    }

    @Override
    public Song addsong(Song song){
        song.setSongId(uniqueId);
        playlist.put(uniqueId,song);
        return song;
    }

    @Override
    public Song getsong(int id){
        if(playlist.get(id)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return playlist.get(id);
    }

    @Override
    public Song updatesong(int id,Song song){
        if(playlist.get(id)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Song existingsong=playlist.get(id);
        if(song.getSongName()!=null){
            existingsong.setSongName(song.getSongName());
        }
        if(song.getLyricist()!=null){
            existingsong.setLyricist(song.getLyricist());
        }
        if(song.getSinger()!=null){
            existingsong.setSinger(song.getSinger());
        }
        if(song.getMusicDirector()!=null){
            existingsong.setMusicDirector(song.getMusicDirector());
        }
        return existingsong;
    }

    @Override
    public void deletesong(int id){
        if(playlist.get(id)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            playlist.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}