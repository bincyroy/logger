/*
* (C) Copyright [2018] Hewlett Packard Enterprise Development LP.
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
*/

package com.niara.logger.parsers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.Exception;


public class ParserFactory {

    protected static Logger logger = LoggerFactory.getLogger(Parser.class);

    public static Parser getParser(String parserType, String log) throws Exception {
        Parser parser;
        if (parserType == null) {
            throw new Exception("Missing parser type parameter");
        }

        switch(parserType) {
            case "GrokParser":
                parser = new GrokParser(log);
                break;
            case "CsvParser":
                parser = new CsvParser(log);
                break;
            case "JsonParser":
                parser = new JsonParser(log);
                break;
            case "KeyValueParser":
                parser = new KeyValueParser(log);
                break;
            default:
                throw new Exception("Unsupported parser type: " + parserType);
        }

        return parser;
    }

}