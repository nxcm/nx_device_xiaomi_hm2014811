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

import org.cyanogenmod.hardware.util.FileUtils;

import android.util.Log;

import java.io.File;

/**
 * Color calibration control
 */
public class DisplayColorCalibration {

    private static final String FILE_COLOR = "/sys/class/graphics/fb0/rgb";

    /**
     * Whether device supports color calibration
     *
     * @return boolean Supported devices must return always true
     */
    public static boolean isSupported() {
        return new File(FILE_COLOR).exists();
    }

    public static int getMaxValue()  {
        return 32768;
    }

    public static int getMinValue()  {
        return 255;
    }

    public static int getDefValue() {
        return getMaxValue();
    }

    /**
     * This method return the current color calibration
     *
     * @return boolean Must be false when color calibration is not supported
     * or not activated, or the operation failed while reading the status;
     * true in any other case.
     */
    public static String getCurColors()  {
        return FileUtils.readOneLine(FILE_COLOR);
    }

    /**
     * This method allows to set a new color calibration
     *
     * @param status The new color calibration
     * @return boolean Must be false if color calibration is not supported
     * or the operation failed; true in any other case.
     */
    public static boolean setColors(String colors) {
        return FileUtils.writeLine(FILE_COLOR, colors);
    }
}