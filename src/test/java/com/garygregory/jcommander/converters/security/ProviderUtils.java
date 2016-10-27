package com.garygregory.jcommander.converters.security;

import java.security.Provider;

import com.garygregory.jcommander.converters.ConverterConstants;

public class ProviderUtils {

    public static String toArguments(final String arg0, final Provider expectedProvider) {
        return arg0 + ConverterConstants.VALUE_SEPARATOR + expectedProvider.getName();
    }

}
