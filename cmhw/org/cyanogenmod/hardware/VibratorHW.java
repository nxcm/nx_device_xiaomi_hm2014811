/*
 * Copyright (C) 2015 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cyanogenmod.hardware;

import java.io.File;
import org.cyanogenmod.hardware.util.FileUtils;

public class VibratorHW {
    private static final String VTG_MAX_FILE = "/sys/class/timed_output/vibrator/vtg_max";
    private static final String VTG_MIN_FILE = "/sys/class/timed_output/vibrator/vtg_min";
    private static final String VTG_LVL_FILE = "/sys/class/timed_output/vibrator/vtg_level";

    public static boolean isSupported() {
        File f = new File(VTG_LVL_FILE);
        return f.exists();
    }

    public static int getMaxIntensity()  {
        return Integer.parseInt(FileUtils.readOneLine(VTG_MAX_FILE));
    }

    public static int getMinIntensity()  {
        return Integer.parseInt(FileUtils.readOneLine(VTG_MIN_FILE));
    }

    public static int getWarningThreshold()  {
        return getMaxIntensity();
    }

    public static int getCurIntensity()  {
        return Integer.parseInt(FileUtils.readOneLine(VTG_LVL_FILE));
    }

    public static int getDefaultIntensity()  {
        return getMaxIntensity();
    }

    public static boolean setIntensity(int intensity)  {
        return FileUtils.writeLine(VTG_LVL_FILE, String.valueOf(intensity));
    }
}
