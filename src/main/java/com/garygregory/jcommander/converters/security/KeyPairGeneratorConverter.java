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

package com.garygregory.jcommander.converters.security;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import com.garygregory.jcommander.converters.AbstractBaseConverter;

/**
 * Converts a {@link String} into a {@link KeyPairGenerator}.
 * <p>
 * For a description of the format, see {@link KeyPairGenerator#getInstance(String)}.
 * </p>
 * 
 * @see KeyPairGenerator
 * @see KeyPairGenerator#getInstance(String)
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class KeyPairGeneratorConverter extends AbstractBaseConverter<KeyPairGenerator> {

    /**
     * Constructs a converter.
     * 
     * @param optionName
     *            The option name, may be null.
     */
    public KeyPairGeneratorConverter(final String optionName) {
        super(optionName, KeyPairGenerator.class);
    }

    @Override
    protected KeyPairGenerator convertImpl(final String value) throws NoSuchAlgorithmException, NoSuchProviderException {
        final String[] split = split(value);
        final String algorithm = split[0];
        return isSingle(split) ? KeyPairGenerator.getInstance(value) : KeyPairGenerator.getInstance(algorithm, split[1]);
    }

}