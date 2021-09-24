package ru.adm123.binaryAutomate.error;

/**
 * @author Dmitry Ushakov on 24.09.21
 */
public class StateNotAvailable extends Exception {

    public StateNotAvailable(String message) {
        super(message);
    }

}
