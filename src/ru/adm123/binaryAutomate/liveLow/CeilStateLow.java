package ru.adm123.binaryAutomate.liveLow;

import ru.adm123.binaryAutomate.error.StateNotAvailable;

/**
 * @author Dmitry Ushakov on 23.09.21
 */
public interface CeilStateLow {

   int getCeilNewState(int ceilEnvironmentState,
                        int ceilStateCount) throws StateNotAvailable;

   void printCeil(int ceilState);

}
