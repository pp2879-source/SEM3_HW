import java.util.Arrays;

public class PlaylistDemo {

    static class Playlist {
        private final String[] songs;
        private int songCount;

        public Playlist(int maxSize) {
            this.songs = new String[maxSize];
            this.songCount = 0;
        }

        public void addSong(String title) {
            if (songCount >= songs.length) {
                System.out.println("Cannot add song: playlist is full");
                return;
            }
            songs[songCount] = title;
            songCount++;
        }

        public String[] getSongs() {
            return Arrays.copyOf(songs, songCount);
        }

        public int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Playlist contents: " + Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}
