package nx.peter.java.io;

import nx.peter.java.io.memory.Settings;
import nx.peter.java.util.data.Texts;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controls how memory/temporary files are used for
 * buffering streams etc.
 */
public final class MemoryUsageSetting {
    public static final String TEMP_PATH = File.FILES_FOLDER + "files/";
    public static final String TEMP_FILE = "memory_usage_settings.json";

    public static final String USE_MAIN_MEMORY = "useMainMemory";
    public static final String USE_TEMP_MEMORY = "useTempMemory";
    public static final String MAX_MAIN_MEMORY_BYTES = "maxMainMemoryBytes";
    public static final String MAX_STORAGE_BYTES = "maxStorageBytes";
    public static final String TEMP_FILE_PATH = "tempDir";


    private final boolean useMainMemory;
    private final boolean useTempFile;


    /**
     * maximum number of main-memory bytes allowed to be used;
     * <code>-1</code> means 'unrestricted'
     */
    private final long maxMainMemoryBytes;

    /**
     * maximum number of bytes allowed for storage at all (main-memory+file);
     * <code>-1</code> means 'unrestricted'
     */
    private final long maxStorageBytes;

    /**
     * directory to be used for scratch file
     */
    private File tempDir;

    /**
     * Private constructor for setup buffering memory usage called by one of the setup methods.
     *
     * @param useMainMemory      if <code>true</code> main memory usage is enabled; in case of
     *                           <code>false</code> and <code>useTempFile</code> is <code>false</code> too
     *                           we set this to <code>true</code>
     * @param useTempFile        if <code>true</code> using of temporary file(s) is enabled
     * @param maxMainMemoryBytes maximum number of main-memory to be used;
     *                           if <code>-1</code> means 'unrestricted';
     *                           if <code>0</code> we only use temporary file if <code>useTempFile</code>
     *                           is <code>true</code> otherwise main-memory usage will have restriction
     *                           defined by maxStorageBytes
     * @param maxStorageBytes    maximum size the main-memory and temporary file(s) may have all together;
     *                           <code>0</code>  or less will be ignored; if it is less than
     *                           maxMainMemoryBytes we use maxMainMemoryBytes value instead
     */
    private MemoryUsageSetting(boolean useMainMemory, boolean useTempFile, long maxMainMemoryBytes, long maxStorageBytes) {
        // do some checks; adjust values as needed to get consistent setting
        boolean locUseMainMemory = !useTempFile || useMainMemory;
        long locMaxMainMemoryBytes = useMainMemory ? maxMainMemoryBytes : -1;
        long locMaxStorageBytes = maxStorageBytes > 0 ? maxStorageBytes : -1;

        if (locMaxMainMemoryBytes < -1) locMaxMainMemoryBytes = -1;

        if (locUseMainMemory && (locMaxMainMemoryBytes == 0)) {
            if (useTempFile) locUseMainMemory = false;
            else locMaxMainMemoryBytes = locMaxStorageBytes;
        }

        if (locUseMainMemory && (locMaxStorageBytes > -1) && ((locMaxMainMemoryBytes == -1) || (locMaxMainMemoryBytes > locMaxStorageBytes)))
            locMaxStorageBytes = locMaxMainMemoryBytes;


        this.useMainMemory = locUseMainMemory;
        this.useTempFile = useTempFile;
        this.maxMainMemoryBytes = locMaxMainMemoryBytes;
        this.maxStorageBytes = locMaxStorageBytes;
    }

    /**
     * Setups buffering memory usage to only use main-memory (no temporary file)
     * which is not restricted in size.
     */
    public static MemoryUsageSetting setupMainMemoryOnly() {
        return setupMainMemoryOnly(-1);
    }

    /**
     * Setups buffering memory usage to only use main-memory with the defined maximum.
     *
     * @param maxMainMemoryBytes maximum number of main-memory to be used;
     *                           <code>-1</code> for no restriction;
     *                           <code>0</code> will also be interpreted here as no restriction
     */
    public static MemoryUsageSetting setupMainMemoryOnly(long maxMainMemoryBytes) {
        return new MemoryUsageSetting(true, false, maxMainMemoryBytes, maxMainMemoryBytes);
    }

    /**
     * Setups buffering memory usage to only use temporary file(s) (no main-memory)
     * with not restricted size.
     */
    public static MemoryUsageSetting setupTempFileOnly() {
        return setupTempFileOnly(-1);
    }

    /**
     * Setups buffering memory usage to only use temporary file(s) (no main-memory)
     * with the specified maximum size.
     *
     * @param maxStorageBytes maximum size the temporary file(s) may have all together;
     *                        <code>-1</code> for no restriction;
     *                        <code>0</code> will also be interpreted here as no restriction
     */
    public static MemoryUsageSetting setupTempFileOnly(long maxStorageBytes) {
        return new MemoryUsageSetting(false, true, 0, maxStorageBytes);
    }

    /**
     * Setups buffering memory usage to use a portion of main-memory and additionally
     * temporary file(s) in case the specified portion is exceeded.
     *
     * @param maxMainMemoryBytes maximum number of main-memory to be used;
     *                           if <code>-1</code> this is the same as {@link #setupMainMemoryOnly()};
     *                           if <code>0</code> this is the same as {@link #setupTempFileOnly()}
     */
    public static MemoryUsageSetting setupMixed(long maxMainMemoryBytes) {
        return setupMixed(maxMainMemoryBytes, -1);
    }

    /**
     * Setups buffering memory usage to use a portion of main-memory and additionally
     * temporary file(s) in case the specified portion is exceeded.
     *
     * @param maxMainMemoryBytes maximum number of main-memory to be used;
     *                           if <code>-1</code> this is the same as {@link #setupMainMemoryOnly()};
     *                           if <code>0</code> this is the same as {@link #setupTempFileOnly()}
     * @param maxStorageBytes    maximum size the main-memory and temporary file(s) may have all together;
     *                           <code>0</code>  or less will be ignored; if it is less than
     *                           maxMainMemoryBytes we use maxMainMemoryBytes value instead
     */
    public static MemoryUsageSetting setupMixed(long maxMainMemoryBytes, long maxStorageBytes) {
        return new MemoryUsageSetting(true, true, maxMainMemoryBytes, maxStorageBytes);
    }

    /**
     * Returns a copy of this instance with the maximum memory/storage restriction
     * divided by the provided number of parallel uses.
     *
     * @param parallelUseCount specifies the number of parallel usages for the setting to
     *                         be returned
     * @return a copy from this instance with the maximum memory/storage restrictions
     * adjusted to the multiple usage
     */
    public MemoryUsageSetting getPartitionedCopy(int parallelUseCount) {
        long newMaxMainMemoryBytes = maxMainMemoryBytes <= 0 ? maxMainMemoryBytes :
                maxMainMemoryBytes / parallelUseCount;
        long newMaxStorageBytes = maxStorageBytes <= 0 ? maxStorageBytes :
                maxStorageBytes / parallelUseCount;

        MemoryUsageSetting copy = new MemoryUsageSetting(useMainMemory, useTempFile,
                newMaxMainMemoryBytes, newMaxStorageBytes);
        copy.tempDir = tempDir;

        return copy;
    }

    /**
     * Sets directory to be used for temporary files.
     *
     * @param tempDir directory for temporary files
     * @return this instance
     */
    public MemoryUsageSetting setTempDir(File tempDir) {
        this.tempDir = tempDir;
        return this;
    }

    /**
     * Sets directory to be used for temporary files.
     *
     * @param tempDir directory for temporary files
     * @return this instance
     */
    public MemoryUsageSetting setTempDir(CharSequence tempDir) {
        return setTempDir(new File(tempDir));
    }

    /**
     * Sets directory to be used for temporary files.
     *
     * @param tempName directory name for temporary files
     * @return this instance
     */
    public MemoryUsageSetting setTempDirWithDefault(CharSequence tempName) {
        if (tempName != null) {
            tempName = new File(tempName).getName();
            String name = TEMP_PATH + tempName + TEMP_FILE;
            return setTempDir(name);
        }
        return this;
    }

    /**
     * Returns <code>true</code> if main-memory is to be used.
     *
     * <p>If this returns <code>false</code> it is ensured {@link #useTempFile()}
     * returns <code>true</code>.</p>
     */
    public boolean useMainMemory() {
        return useMainMemory;
    }

    /**
     * Returns <code>true</code> if temporary file is to be used.
     *
     * <p>If this returns <code>false</code> it is ensured {@link #useMainMemory}
     * returns <code>true</code>.</p>
     */
    public boolean useTempFile() {
        return useTempFile;
    }

    /**
     * Returns <code>true</code> if maximum main memory is restricted to a specific
     * number of bytes.
     */
    public boolean isMainMemoryRestricted() {
        return maxMainMemoryBytes >= 0;
    }

    /**
     * Returns <code>true</code> if maximum amount of storage is restricted to a specific
     * number of bytes.
     */
    public boolean isStorageRestricted() {
        return maxStorageBytes > 0;
    }

    /**
     * Returns maximum size of main-memory in bytes to be used.
     */
    public long getMaxMainMemoryBytes() {
        return maxMainMemoryBytes;
    }

    /**
     * Returns maximum size of storage bytes to be used
     * (main-memory in temporary files all together).
     */
    public long getMaxStorageBytes() {
        return maxStorageBytes;
    }

    /**
     * Returns directory to be used for temporary files or <code>null</code>
     * if it was not set.
     *
     * @return The directory of temporary files
     */
    public File getTempDir() {
        return tempDir;
    }

    /**
     * Returns an instance of settings
     *
     * @return an instance of Settings that contains all settings information
     */
    public Settings getSettings() {
        Map<String, Object> settings = new LinkedHashMap<>();

        // Setting up the values
        settings.put(TEMP_FILE_PATH, TEMP_PATH + tempDir.getName());
        settings.put(USE_MAIN_MEMORY, useMainMemory);
        settings.put(USE_TEMP_MEMORY, useTempFile);
        settings.put(MAX_MAIN_MEMORY_BYTES, maxMainMemoryBytes);
        settings.put(MAX_STORAGE_BYTES, maxStorageBytes);

        return new ISettings(tempDir, settings);
    }

    public void close() {
        if (tempDir != null) {
            tempDir.delete();
            tempDir = null;
        }
    }

    @Override
    public String toString() {
        return useMainMemory ?
                (useTempFile ? "Mixed mode with max. of " + maxMainMemoryBytes + " main memory bytes" +
                        (isStorageRestricted() ? " and max. of " + maxStorageBytes + " storage bytes" :
                                " and unrestricted scratch file size") :
                        (isMainMemoryRestricted() ? "Main memory only with max. of " + maxMainMemoryBytes + " bytes" :
                                "Main memory only with no size restriction")) :
                (isStorageRestricted() ? "Scratch file only with max. of " + maxStorageBytes + " bytes" :
                        "Scratch file only with no size restriction");
    }


    protected static class ISettings implements Settings {
        Map<String, Object> settings;
        File path;

        public ISettings(File path, Map<String, Object> settings) {
            this.path = path;
            this.settings = settings;
        }

        @Override
        public Object get(CharSequence key) {
            return key != null ? settings.get(key.toString()) : null;
        }

        @Override
        public String getString(CharSequence key) {
            Object value = get(key);
            return value instanceof String ? (String) value : null;
        }

        @Override
        public boolean getBoolean(CharSequence key, boolean defaultValue) {
            Object value = get(key);
            return value instanceof Boolean ? (Boolean) value : defaultValue;
        }

        @Override
        public int getInt(CharSequence key, int defaultValue) {
            Object value = get(key);
            return value instanceof Integer ? (int) value : defaultValue;
        }

        @Override
        public long getLong(CharSequence key, long defaultValue) {
            Object value = get(key);
            return value instanceof Long ? (long) value : defaultValue;
        }

        @Override
        public double getDouble(CharSequence key, double defaultValue) {
            Object value = get(key);
            return value instanceof Double ? (double) value : defaultValue;
        }

        @Override
        public boolean set(CharSequence key, Object value) {
            boolean contains = false;
            if (key != null) {
                contains = !settings.containsKey(key.toString());
                if (value != null)
                    settings.put(key.toString(), value);
            }
            return contains;
        }

        @Override
        public boolean remove(CharSequence key) {
            return key != null && settings.remove(key.toString()) != null;
        }

        @Override
        public boolean store() {
            return path != null && path.write(toString(), false);
        }


        int count;

        @Override
        public String toString() {
            count = 0;
            return "{\n" + settings.entrySet().stream().map(entry -> {
                String key = entry.getKey();
                String value = value(entry.getValue());
                count++;
                return "\t\"" + key + "\": " + value + (count < settings.size() ? "," : "") + "\n";
            }).collect(Collectors.joining()) + "}";
        }

        String value(Object value) {
            return value instanceof String ? "\"" + new Texts(value.toString()).replace("\n", "/n").get() + "\"" : value.toString();
        }

    }


}
