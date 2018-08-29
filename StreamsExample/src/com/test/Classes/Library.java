package com.test.Classes;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Album> albums;
	
	public Library() {
		
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	
	public void addAlbum(Album theAlbum) {
		if(albums == null) {
			albums = new ArrayList<Album>();
		}
		albums.add(theAlbum);
	}
	
	
}
