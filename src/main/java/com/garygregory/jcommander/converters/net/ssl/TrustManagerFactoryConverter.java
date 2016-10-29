/**
 *  Copyright (C) 2016 Gary Gregory. All rights reserved.
 *
 *  See the NOTICE.txt file distributed with this work for additional
 *  information regarding copyright ownership.
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.garygregory.jcommander.converters.net.ssl;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;

import javax.net.ssl.TrustManagerFactory;

import com.garygregory.jcommander.converters.AbstractBaseConverter;

/**
 * Converts a {@link String} into a {@link TrustManagerFactory}.
 * <p>
 * For a description of the format, see {@link TrustManagerFactory#getInstance(String)}.
 * </p>
 * <p>
 * To get a TrustManagerFactory from a specific {@link Provider}, use the syntax {@code algorithm:provider} as described
 * by {@link TrustManagerFactory#getInstance(String, String)}.
 * </p>
 * 
 * <p>
 * Example:
 * </p>
 * 
 * <pre class="prettyprint">
 * <code class="language-java">&#64;Parameter(names = { "--trustManagerFactory" }, converter = TrustManagerFactoryConverter.class)
 * private TrustManagerFactory trustManagerFactory;</code>
 * </pre>
 * <p>
 * 
 * @see TrustManagerFactory
 * @see TrustManagerFactory#getInstance(String)
 * @see TrustManagerFactory#getInstance(String, String)
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class TrustManagerFactoryConverter extends AbstractBaseConverter<TrustManagerFactory> {

    /**
     * Constructs a converter.
     * 
     * @param optionName
     *            The option name, may be null.
     */
    public TrustManagerFactoryConverter(final String optionName) {
        super(optionName, TrustManagerFactory.class);
    }

    @Override
    protected TrustManagerFactory convertImpl(final String value) throws NoSuchAlgorithmException, NoSuchProviderException {
        final String[] split = split(value);
        final String algorithm = split[0];
        return isSingle(split) ? TrustManagerFactory.getInstance(value) : TrustManagerFactory.getInstance(algorithm, split[1]);
    }

}