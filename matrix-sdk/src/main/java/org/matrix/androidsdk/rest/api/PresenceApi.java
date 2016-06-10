/*
 * Copyright 2014 OpenMarket Ltd
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
package org.matrix.androidsdk.rest.api;

import org.matrix.androidsdk.rest.model.Event;
import org.matrix.androidsdk.rest.model.PresenceListParams;
import org.matrix.androidsdk.rest.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * The presence REST API.
 */
public interface PresenceApi {

    /**
     * Set this user's presence state.
     * @param userId the user id
     * @param userPresence a User object with possibly the presence and statusMsg fields
     * @param callback the asynchronous callback called when finished
     */
    @PUT("/presence/{userId}/status")
    void presenceStatus(@Path("userId") String userId, @Body User userPresence, Callback<Void> callback);

    /**
     * Get a user's presence state.
     * @param userId the user id
     * @param callback the asynchronous callback called with the response
     */
    @GET("/presence/{userId}/status")
    void presenceStatus(@Path("userId") String userId, Callback<User> callback);

    /**
     * Adds or removes users from this presence list.
     * @param userId the user id
     * @param param the list of users to invite/drop
     * @param callback the asynchronous callback called with the response
     */
    @POST("/presence/list/{userId}")
    void modifyPresenceList(@Path("userId") String userId, @Body PresenceListParams param, Callback<Void> callback);

    /**
     * Retrieve a list of presence events for every user on this list.
     * @param userId the user id
     * @param callback the asynchronous callback called with the response
     */
    @GET("/presence/list/{userId}")
    void presenceList(@Path("userId") String userId, Callback<List<Event>> callback);
}
