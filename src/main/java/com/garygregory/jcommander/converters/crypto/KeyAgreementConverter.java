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

import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;

import com.garygregory.jcommander.converters.AbstractBaseConverter;

/**
 * Converts a {@link String} into a {@link KeyAgreement}.
 * <p>
 * For a description of the transformation parameter format, see {@link KeyAgreement#getInstance(String)}.
 * </p>
 * <p>
 * To get a KeyAgreement from a specific {@link Provider}, use the syntax {@code transformation:provider} as
 * described by {@link KeyAgreement#getInstance(String, String)}.
 * </p>
 * 
 * @see KeyAgreement
 * @see KeyAgreement#getInstance(String)
 * @see KeyAgreement#getInstance(String, String)
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class KeyAgreementConverter extends AbstractBaseConverter<KeyAgreement> {

    /**
     * Constructs a converter.
     * 
     * @param optionName
     *            The option name, may be null.
     */
    public KeyAgreementConverter(final String optionName) {
        super(optionName, KeyAgreement.class);
    }

    @Override
    protected KeyAgreement convertImpl(final String value)
            throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {
        final String[] split = split(value);
        final String transformation = split[0];
        return isSingle(split) ? KeyAgreement.getInstance(value) : KeyAgreement.getInstance(transformation, split[1]);
    }

}