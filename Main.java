import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	private static ArrayList<Album> albums = new ArrayList<Album>();
	
	
	public static void main(String[] args) {
		
		Album album = new Album("Take Care", "Drake");
		
		album.addNewSong("take care", "3.14");
		album.addNewSong("shot for me", "2.31");
		album.addNewSong("cameras/good ones go", "4.14");
		album.addNewSong("crew love", "4.34");
		album.addNewSong("make me proud", "5.14");
		album.addNewSong("practice", "3.05");
		album.addNewSong("doing it wrong", "3.34");
		album.addNewSong("the real her", "3.23");
		albums.add(album); //adding album to arrayList
		
		
		album = new Album("Wunna", "Gunna");
		album.addNewSong("Met gala", "2.34");
		album.addNewSong("Argentina", "3.14");
		album.addNewSong("Nasty girl/on camera", "3.05");
		album.addNewSong("skybox", "2.34");
		album.addNewSong("i'm on some", "2.23");
	
		albums.add(album);
		
		LinkedList<Song>playList = new LinkedList<Song>();
		
		albums.get(0).addToPlaylist("Met gala", playList);
		albums.get(0).addToPlaylist("shot for me", playList);
		albums.get(0).addToPlaylist("the real her", playList);
		albums.get(0).addToPlaylist(3, playList);
		albums.get(1).addToPlaylist("Argentina", playList);
		albums.get(1).addToPlaylist("skybox", playList);
		albums.get(1).addToPlaylist(5, playList);
		
		play(playList);
	}
	private static void play(LinkedList<Song> playList) {
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		printMenu();
		boolean goingForward=true;
		ListIterator<Song> i = playList.listIterator();
		
		if(playList.isEmpty()) {
			System.out.println("No songs in playlist");
			return;
			
		}else {
			System.out.println("Currently playing: " + i.next().toString());
			
		}
		while(!quit) {
			
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch(action) {
			
			case 0:
				System.out.println("Exiting Playlist");
				quit=true;
				break;
				
			case 1: //go to next node
			if(!goingForward) {
				if(i.hasNext()) {
				i.next();
				
				
			}
			goingForward=true;//if there is a next node, then we can go forward
			}
			
			if(i.hasNext()) {
				System.out.println("currently playing: " + i.next().toString());
				
				
			}else {
				
				System.out.println("End of playlist");
				goingForward= false; //reaching end of linkedList
			}
			
			break;
				
			case 2: //go to previous node
				if(goingForward) {
					if(i.hasPrevious()) {
						
						i.previous();
						
					}
					goingForward=false; //if we go back to the previous node, we are no going forward anymore, making it false
				}
					if(i.hasPrevious()) {
						
						System.out.println("Currently playing: " + i.previous().toString());
						
					}
					else {
					System.out.println("Start of playlist");
					goingForward=true;
				}
				break;
				
			case 3:
				if(goingForward) { //stay at or replay current node
					if(i.hasPrevious()) {
						
						System.out.println("now replaying: " + i.previous().toString());
						goingForward=false;
					
					}else {
						System.out.println("we are are the start of the playlist");
					}
						
					}else {
						if(i.hasNext()) {
							System.out.println("now replaying: " + i.next().toString());
						
							goingForward=true;
							
							}else {
							
							System.out.println("end of playlist");
							
							}
					
					
				}
				break;
				
			case 4: //print linkedList
				printList(playList);
				break;
				
			case 5: //removing song from linkedList
				if(playList.size()>0) {
					
					i.remove();
					if(i.hasNext()) {
						System.out.println("now playing: "+ i.next());
					}else if(i.hasPrevious()) {
						System.out.println("now playing: " + i.next());
					}
					
				}
				break;
				
			case 6:
				printMenu();
				break;
				
				
				
				
			
			
			
			}
			
			
		}
	}
	public static void printMenu() { // \n means new line
		System.out.println("");
		System.out.println("Type in one of the Available options:\n"+ 
	"press option 0 - quit playlist\n" + "press option 1 - play next song\n"+
				"press option 2 - play previous song\n"+
	"press option 3 - to replay song current song\n" +
				"press option 4 - to display pLaylist\n"+
				"press option 5 - remove song from playlist\n"+
		"press option 6 - show options again");
		
	
		
		
	}
	
	private static void printList(LinkedList<Song> playList) {
		
		Iterator<Song> iterator = playList.iterator();
		System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
		System.out.println("Current songs in playlist");
		while(iterator.hasNext()) {
			
			System.out.println(iterator.next().toString());
			
		}
		System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
	}
	
	
	
	
	

}
