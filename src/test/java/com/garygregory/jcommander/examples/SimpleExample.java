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
package com.garygregory.jcommander.examples;

import java.time.LocalDate;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.garygregory.jcommander.converters.time.LocalDateConverter;

public class SimpleExample {

    @Parameter(names = { "--dob",
            "-d" }, converter = LocalDateConverter.class, required = true, description = "Birthday in the format YYYY-MM-DD, for example 2007-12-03")
    LocalDate localDate;

    public static void main(String... args) {
        SimpleExample main = new SimpleExample();
        new JCommander(main, args);
        main.run();
    }

    public void run() {
        System.out.printf("You were born on a %s.", localDate.getDayOfWeek());
    }

}