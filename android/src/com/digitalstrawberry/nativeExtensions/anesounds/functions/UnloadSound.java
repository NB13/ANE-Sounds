package com.digitalstrawberry.nativeExtensions.anesounds.functions;

import android.util.Log;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.digitalstrawberry.nativeExtensions.anesounds.ANESoundsContext;

public class UnloadSound implements FREFunction {

    @Override
    public FREObject call(FREContext context, FREObject[] args) {
        ANESoundsContext soundsContext = (ANESoundsContext) context;
        int soundId;

        try
        {
            soundId = args[0].getAsInt();

            soundsContext.soundToStream.remove(soundId);

            return FREObject.newObject(soundsContext.soundPool.unload(soundId));
        }
        catch(Exception e)
        {
            Log.e("ANESounds", "Failed to unload sound: " + e.getLocalizedMessage());
        }

        return null;
    }

}

