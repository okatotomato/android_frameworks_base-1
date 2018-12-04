/*
 * Copyright (C) 2018 The Android Open Source Project
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

package com.android.server.util;

import static android.os.Binder.getCallingUid;

import android.os.Process;

/**
 * Utility class to check calling permissions on the network stack.
 */
public final class PermissionUtil {

    /**
     * Check that the caller is allowed to communicate with the network stack.
     * @throws SecurityException The caller is not allowed to communicate with the network stack.
     */
    public static void checkNetworkStackCallingPermission() {
        // TODO: check that the calling PID is the system server.
        if (getCallingUid() != Process.SYSTEM_UID && getCallingUid() != Process.ROOT_UID) {
            throw new SecurityException("Invalid caller: " + getCallingUid());
        }
    }

    private PermissionUtil() {
        throw new UnsupportedOperationException("This class is not to be instantiated");
    }
}
