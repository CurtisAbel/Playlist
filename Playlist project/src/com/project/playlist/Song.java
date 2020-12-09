package com.project.playlist;
public class Song implements Comparable<Song> {
	private String title;
	private String duration;
	public Song(String title, String duration) {
		super();
		this.title = title;
		this.duration = duration;
	}
	public String getTitle() {
		return title;
	}
	public String getDuration() {
		return duration;
	}
	@Override
	public String toString() {
		return "Song name: " + this.title + ". duration: " + duration;
	}
	@Override
	public int compareTo(Song song) {
	
		return this.title.compareToIgnoreCase(song.getTitle()) ;
	} 
	
	
}
