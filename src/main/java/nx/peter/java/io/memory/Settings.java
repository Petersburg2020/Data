package nx.peter.java.io.memory;

public interface Settings {
    Object get(CharSequence key);
    String getString(CharSequence key);
    boolean getBoolean(CharSequence key, boolean defaultValue);
    int getInt(CharSequence key, int defaultValue);
    long getLong(CharSequence key, long defaultValue);
    double getDouble(CharSequence key, double defaultValue);
    boolean set(CharSequence key, Object value);
    boolean remove(CharSequence key);
    boolean store();
}
