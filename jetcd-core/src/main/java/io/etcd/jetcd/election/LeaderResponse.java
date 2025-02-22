/*
 * Copyright 2016-2021 The jetcd authors
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

package io.etcd.jetcd.election;

import io.etcd.jetcd.AbstractResponse;
import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.KeyValue;

public class LeaderResponse extends AbstractResponse<io.etcd.jetcd.api.LeaderResponse> {
    private final KeyValue kv;

    public LeaderResponse(io.etcd.jetcd.api.LeaderResponse response, ByteSequence namespace) {
        super(response, response.getHeader());
        this.kv = new KeyValue(getResponse().getKv(), namespace);
    }

    /**
     * Returns the key-value pair representing the latest leader update.
     */
    public KeyValue getKv() {
        return kv;
    }
}
