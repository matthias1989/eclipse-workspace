package com.test.Classes;

import java.util.List;
import java.util.ArrayList;

public class Album {
	private String title;
	private List<Track> tracks;
	
	public Album() {
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Track> getTracks() {
		return tracks;
	}
	
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
	public void addTrack(Track theTrack) {
		if(tracks == null) {
			tracks = new ArrayList<Track>();
		}
		tracks.add(theTrack);
	}
	
	
	
	
	
}
