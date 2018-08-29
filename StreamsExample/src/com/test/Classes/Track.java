package com.test.Classes;

public class Track {
	private String name;
	private String artist;
	private int rating;
	
	public Track() {
		
	}
	
	public Track(String name, String artist, int rating) {
		this.name = name;
		this.artist = artist;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Track [name=" + name + ", artist=" + artist + ", rating=" + rating + "]";
	}
	
	
	
	
}
