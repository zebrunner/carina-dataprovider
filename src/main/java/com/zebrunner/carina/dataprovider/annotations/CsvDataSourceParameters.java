/*******************************************************************************
 * Copyright 2020-2022 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.dataprovider.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CsvDataSourceParameters {

    /**
     * Define data provider instance
     *
     * @return String
     */
    String className() default "com.zebrunner.carina.dataprovider.core.impl.CsvDataProvider";

    /**
     * Define column separator for parsing
     *
     * @return char
     */
    char separator() default ',';

    /**
     * The character to use for quoted elements when parsing
     *
     * @return char
     */
    char quote() default '"';

    /**
     * Path to data source file
     *
     * @return String
     */
    String path() default "";

    /**
     * Column names that need to be inserted into test from row. Several arguments should be split by ",".
     * If empty, per row will be created hashMap with all data source columns as keys and row data as values.
     *
     * @return String
     */
    String dsArgs() default "";

    /**
     * Column name with unique test identifiers. Several name arguments should be split by ",".
     *
     * @return String
     */
    String dsUid() default "";

    /**
     * Column name which rows determines whether to execute test or not
     *
     * @return String
     */
    String executeColumn() default "Execute";

    /**
     * Defines to execute test or not.
     * If executeValue equalsIgnoreCase to value from executeColumn test will be added to run.
     *
     * @return String
     */
    String executeValue() default "y";

    /**
     * Gets value from testNG suite by defined static arguments name.
     * The same argument will present in every test
     *
     * @return String
     */
    String staticArgs() default "";

    /**
     * Name of the column, by which will be performed grouping.
     * If used, test will receive {@code ArrayList<HashMap<String,String>} argument,
     * where data grouped by lists depending on groupColumn values.
     *
     * @return String
     */
    String groupColumn() default "";

    /**
     * Column name, which contains values for test name overriding
     * If used with groupColumn parameter, test will be overridden by first occurrence in group
     *
     * @return String
     */
    String testMethodColumn() default "";

    /**
     * @deprecated Reason: not implemented
     *
     * @return String
     */
    @Deprecated(forRemoval = true, since = "1.0.0")
    String testRailColumn() default "";

    /**
     * @deprecated Reason: not implemented
     *
     * @return String
     */
    @Deprecated(forRemoval = true, since = "1.0.0")
    String qTestColumn() default "";

    /**
     * @deprecated Reason: not implemented
     *
     * @return String
     */
    @Deprecated(forRemoval = true, since = "1.0.0")
    String testMethodOwnerColumn() default "";

    /**
     * @deprecated Reason: not implemented
     *
     * @return String
     */
    @Deprecated(forRemoval = true, since = "1.0.0")
    String bugColumn() default "";

    /**
     * @deprecated Reason: not implemented
     *
     * @return String[]
     */
    @Deprecated(forRemoval = true, since = "1.0.0")
    String[] doNotRunTestNames() default {};
}
