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

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import com.garygregory.jcommander.converters.AbstractBaseConverter;

/**
 * Converts a {@link String} into a SQL {@link Cipher}.
 * <p>
 * For a description of the format, see {@link Cipher#getInstance(String)}.
 * </p>
 * 
 * @see Cipher
 * @see Cipher#getInstance(String)
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class CipherConverter extends AbstractBaseConverter<Cipher> {

    /**
     * Constructs a converter.
     */
    public CipherConverter() {
        super(null, Cipher.class);
    }

    @Override
    protected Cipher convertImpl(final String value) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return Cipher.getInstance(value);
    }

}