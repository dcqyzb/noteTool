package com.note.exception;

/**
 *
 * @author UATCD992786
 * @date 2021/4/6 17:37
 */
public class NoteException extends Exception {

    public NoteException(String message) {
        super(message);
    }

    public NoteException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoteException(Throwable cause) {
        super(cause);
    }

    public NoteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
