/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.kafka.common.network;

import org.apache.kafka.common.protocol.Errors;
import org.apache.kafka.common.security.auth.KafkaPrincipal;

import java.io.Closeable;
import java.io.IOException;

/**
 * Authentication for Channel
 */
public interface Authenticator extends Closeable {
    /**
     * Implements any authentication mechanism. Use transportLayer to read or write tokens.
     * If no further authentication needs to be done returns.
     */
    void authenticate() throws IOException;

    /**
     * Returns the first error encountered during authentication
     * @return authentication error if authentication failed, Errors.NONE otherwise
     */
    Errors error();

    /**
     * Returns Principal using PrincipalBuilder
     */
    KafkaPrincipal principal();

    /**
     * returns true if authentication is complete otherwise returns false;
     */
    boolean complete();

}
