/*
 * Copyright 2016 OpenMarket Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.matrix.androidsdk.sync;

import org.matrix.androidsdk.rest.model.Sync.SyncResponse;

/**
 * Interface to implement to listen to the event thread.
 */
public interface EventsThreadListener {
    /**
     * Call when a sync request has been performed with the API V2.
     * @param response the response (can be null)
     * @param isInitialSync true if the response is triggered by an initial sync
     */
    void onSyncResponse(SyncResponse response, boolean isInitialSync);

    /**
     * the server returns an invalid token error
     */
    void onInvalidToken();
}
