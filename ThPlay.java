import javazoom.jl.player.advanced.*;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ThPlay extends Thread{

    Map<Integer, String> playList = new HashMap<Integer, String>();
    FileInputStream fis;
    public AdvancedPlayer playMP3;
    int pauseOnFrame = 0;
    boolean pause;

    public ThPlay(){
        playList.put(0, "C:\\Users\\Admin\\Desktop\\Pagagnini.mp3");
        playList.put(1, "C:\\Users\\Admin\\Desktop\\TiAmo.mp3");
        playList.put(2, "C:\\Users\\Admin\\Desktop\\ReturnTo.mp3");
        playList.put(3, "C:\\Users\\Admin\\Desktop\\Regrets.mp3");
    }

    public void setFile(int k){
        pause = false;
        try {
            fis = new FileInputStream(playList.get(k));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try {
            playMP3 = new AdvancedPlayer(fis);
            playMP3.setPlayBackListener(new PlaybackListener() {
                @Override
                public void playbackFinished(PlaybackEvent evt) {
                    pauseOnFrame = evt.getFrame();
                }
            });
            playMP3.play();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void Stop(){
        playMP3.stop();
    }

}
