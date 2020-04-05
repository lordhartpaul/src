
import java.applet.Applet;
import java.applet.AudioClip;

public class BackgroundPlay extends Applet {

    AudioClip clip;
    String soundURL;
    boolean loop;

    public void init() {
        super.init();
        loop = getParameter("loop").equals("yes");
        soundURL = getParameter("soundURL");
        clip = getAudioClip(getDocumentBase(), soundURL);
        if(clip != null) {
            if(loop) {
                clip.loop();
                return;
            }
            clip.play();
        }
    }

    public void stop() {
        if(clip != null)
            clip.stop();
    }

    public BackgroundPlay() {
    }
}
