package rallakis.nicholas.atakesgr;

public class Sound {

    private int mResourceId;
    private String mName;

    public Sound(String name, int resourceId) {
        mName = name;
        mResourceId = resourceId;
    }

    public int getResourceId() {
        return mResourceId;
    }

    public String getName() {
        return mName;
    }
}
