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

package com.garygregory.jcommander.converters.crypto;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;

import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;

import com.garygregory.jcommander.converters.AbstractBaseConverter;

/**
 * Converts a {@link String} into a {@link Mac}.
 * <p>
 * For a description of the transformation parameter format, see {@link Mac#getInstance(String)}.
 * </p>
 * <p>
 * To get a Mac from a specific {@link Provider}, use the syntax {@code algorithm:provider} as described by
 * {@link Mac#getInstance(String, String)}.
 * </p>
 * 
 * <p>
 * Example:
 * </p>
 * 
 * <pre class="prettyprint">
 * <code class="language-java">&#64;Parameter(names = { "--paramname" }, converter = MacConverter.class)
 * private Mac paramname;</code>
 * </pre>
 * <p>
 * 
 * @see Mac
 * @see Mac#getInstance(String)
 * @see Mac#getInstance(String, String)
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class MacConverter extends AbstractBaseConverter<Mac> {

    /**
     * Constructs a converter.
     * 
     * @param optionName
     *            The option name, may be null.
     */
    public MacConverter(final String optionName) {
        super(optionName, Mac.class);
    }

    @Override
    protected Mac convertImpl(final String value) throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {
        final String[] split = split(value);
        final String algorithm = split[0];
        return isSingle(split) ? Mac.getInstance(value) : Mac.getInstance(algorithm, split[1]);
    }

}