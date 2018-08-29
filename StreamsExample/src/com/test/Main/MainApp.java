package com.test.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.test.Classes.Album;
import com.test.Classes.Library;
import com.test.Classes.Track;

public class MainApp {

	public static void main(String[] args) {
		Library library = new Library();
		List<Album> favoriteAlbums = new ArrayList<Album>();
		
		for(Album album : library.getAlbums()) {
			Boolean hasFavorite = false;
			for(Track track : album.getTracks()) {
				if(track.getRating()>=4) {
					hasFavorite = true;
					break;
				}
			}
			if(hasFavorite)
				favoriteAlbums.add(album);
		}
		
		Collections.sort(favoriteAlbums, new Comparator<Album>() {
			public int compare(Album a1, Album a2) {
				return a1.getTitle().compareTo(a2.getTitle());
			}
		});

	}

}
