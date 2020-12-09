package com.project.playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

	private String name;
	private String artist;
	private songList songs;

	public Album(String name, String artist) {
		super();
		this.name = name;
		this.artist = artist;
		this.songs = new songList(); //inherits all methods from this class.
	}

	public String getArtist() {
		return artist;
	}

	public String getName() {
		return name;
	}

	public boolean addNewSong(String title, String duration) {
		return this.songs.addNewSong(new Song(title, duration));
		
	}

	public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList) {

		Song checkedSong = this.songs.findSong(trackNumber); // using method from inner class
		if(checkedSong !=null) {
			
			playList.add(checkedSong);
			return true;
			
		}

		System.out.println("This album does not have this track");
		return false;
	}

	public boolean addToPlaylist(String title, LinkedList<Song> playList) {

		Song checkedSong = this.songs.findSong(title);
		if (checkedSong != null) {

			playList.add(checkedSong);
			System.out.println(checkedSong + " has been added to your playlist");
			return true;
		}
		System.out.println("Song was not found");
		return false;

	}

	private class songList { //inner class
		private ArrayList<Song> mySongs;

		public songList() {
			super();
			this.mySongs = new ArrayList<Song>();
		}

		public ArrayList<Song> getMySongs() {
			return mySongs;

		}

		public boolean addNewSong(Song song) {
			if (mySongs.contains(song)) {
				return false;
			} else {

				this.mySongs.add(song);
				return true;
			}
		}

		private Song findSong(String title) {

			for (Song checkedSong : this.mySongs) { // for each loop. check song becomes i. what ever element we are at
													// within the arrayList checkedSong becomes that
				if (checkedSong.getTitle().equals(title)) {

					return checkedSong;

				}

			}

			return null;
		}

		public Song findSong(int trackNumber) {

			int index = trackNumber - 1;

			if ((index > 0) && (index < mySongs.size())) {
				return this.mySongs.get(index);

			}
			return null;
		}

	}

}
