/* Copyright (c) 2019 Expedia Group.
 * All rights reserved.  http://www.homeaway.com

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.homeaway.datapullclient.input;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Migration {
    @JsonProperty("source")
    private Source source;

    @JsonProperty("sources")
    private Set<Source> sources;

    @JsonProperty("destination")
    private Destination destination;

    public boolean isSingleSource(){
        return source != null ?  true : false;
    }

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    @JsonAnyGetter
    public Map<String, Object> otherFields() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setOtherField(String name, Object value) {
        additionalProperties.put(name, value);
    }

}
