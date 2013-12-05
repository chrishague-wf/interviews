We are building a media player with the following requirements:
- Play, pause, and stop playback states need to be available
- Playlist navigation via next, and previous
- Items from the library should be able to be added to the playlist

Some of the functionality has already been completed:

```java
import fake.system.media.MetaData;
import java.text.ParseException;

public class Media {

    private String sourceUri = null;
    private MetaData metaData = null;

    public Media(sourceUri) throws ParseException {
        this.sourceUri = sourceUri;
        this.metaData = MetaData.parseMedia(this.sourceUri);
        if (this.metaData == null) {
            throw new ParseException("unable to parse media MetaData");
        }
    }
    
    public MetaData getMetaData() {
        return this.metaData;
    }

    public String getSourceUri() {
        return this.sourceUri;
    }
    
    public boolean isAudio() {
        String mimeType = this.metaData.mimeType;
        return mimeType.contains("audio");
    }
    
    public boolean isVideo() {
        String mimeType = this.metaData.mimeType;
        return mimeType.contains("video");
    }

}
```

```java
import fake.system.media.stream.Audio;
import fake.system.media.Constants;
import fake.system.media.IPlayerSubSystem;
import fake.system.media.PlayerSubSystem;
import fake.system.media.stream.Video;

public class MediaPlayer {

    private static MediaPlayer singleInstance = null;
    
    private PlayerSubSystem systemControl = null;

    private MediaPlayer() {
        systemControl = new PlayerSubSystem();
        systemControl.setLooping(false);
        systemControl.setStreamType(Constants.STREAM_AUDIO);
    }
    
    public static MediaPlayer getInstance() {
        if (singleInstance == null) {
            singleInstance = new MediaPlayer();
        }
        return singleInstance;
    }
    
    public boolean play(Media theMedia) {
        //TODO support Video.getStream
        return systemControl.play(Audio.getStream(theMedia.getSourceUri()));
    }
    
    public boolean pause(Media theMedia) {
        return systemControl.pause(Audio.getStream(theMedia.getSourceUri()));
    }
    
    //TODO: implement stop
    
}
```

Stub out the playlist functionality: 1) items should be able to be added,
and the caller should be able to navigate to 2) previous or 3) upcoming items,
with playback starting immediately.

Also, please add support for `Video` streams.

***

Unfortunately, we work with poor planner Peter who failed to do sufficient discovery.
The requirements have changed:
- There should be a single play/pause toggle button
- The `MediaPlayer` needs to support mobile devices, which use a different version of the `IPlayerSubSystem` located at `fake.mobile.media.PlayerSubSystem`.
