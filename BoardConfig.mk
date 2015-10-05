#
# Copyright (C) 2015 The CyanogenMod Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

FORCE_32_BIT := true

-include device/cyanogen/msm8916-common/BoardConfigCommon.mk

DEVICE_PATH := device/xiaomi/hm2014811

TARGET_SPECIFIC_HEADER_PATH := $(DEVICE_PATH)/include

# Assert
TARGET_OTA_ASSERT_DEVICE := HM2014811,HM2014812,HM2014813,HM2014814,HM2014815,HM2014816,HM2014817,HM2014818,HM2014819,HM2014820,HM2014821

# Kernel
TARGET_KERNEL_CONFIG := cyanogenmod_hm2014811_defconfig
TARGET_KERNEL_SOURCE := kernel/xiaomi/msm8916

# Audio
AUDIO_FEATURE_ENABLED_NEW_SAMPLE_RATE := true

# Bluetooth
BOARD_BLUETOOTH_BDROID_BUILDCFG_INCLUDE_DIR := $(DEVICE_PATH)/bluetooth

# Camera
BOARD_CAMERA_SENSORS := \
    ov2680_5987fhq \
    ov2680_skuhf \
    ov8865_q8v18a
TARGET_USE_VENDOR_CAMERA_EXT := true
USE_DEVICE_SPECIFIC_CAMERA := true

# CMHW
BOARD_HARDWARE_CLASS += $(DEVICE_PATH)/cmhw

# CPU
TARGET_CPU_CORTEX_A53 := true

# GPS
TARGET_GPS_HAL_PATH := $(DEVICE_PATH)/gps
TARGET_NO_RPC := true

# Init
TARGET_LIBINIT_DEFINES_FILE := $(DEVICE_PATH)/init/init_hm2014811.c
TARGET_UNIFIED_DEVICE := true

# Lights
TARGET_PROVIDES_LIBLIGHT := true

# Partitions
BOARD_FLASH_BLOCK_SIZE := 131072
BOARD_BOOTIMAGE_PARTITION_SIZE := 33554432
BOARD_CACHEIMAGE_FILE_SYSTEM_TYPE := ext4
BOARD_CACHEIMAGE_PARTITION_SIZE := 335544320
BOARD_PERSISTIMAGE_PARTITION_SIZE := 33554432
BOARD_RECOVERYIMAGE_PARTITION_SIZE := 33554432
BOARD_SYSTEMIMAGE_PARTITION_SIZE := 1073741824
BOARD_USERDATAIMAGE_PARTITION_SIZE := 5939100672 # 5939117056 - 16384

# Recovery
TARGET_RECOVERY_FSTAB := $(DEVICE_PATH)/rootdir/etc/fstab.qcom

# SELinux
BOARD_SEPOLICY_DIRS += \
    $(DEVICE_PATH)/sepolicy

BOARD_SEPOLICY_UNION += \
    file.te \
    irsc_util.te \
    mm-qcamerad.te \
    system_server.te \
    file_contexts

TARGET_SYSTEM_PROP += $(DEVICE_PATH)/system.prop

# inherit from the proprietary version
-include vendor/xiaomi/hm2014811/BoardConfigVendor.mk
