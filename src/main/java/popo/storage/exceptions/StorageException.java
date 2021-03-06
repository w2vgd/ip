package popo.storage.exceptions;

/**
 * Signals an error writing to file.
 */
public class StorageException extends Exception {
    public StorageException(String errorMessage) {
        super(errorMessage);
    }
}
