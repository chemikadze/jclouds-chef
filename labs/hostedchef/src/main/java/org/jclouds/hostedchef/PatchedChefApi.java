/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.hostedchef;

import java.util.concurrent.TimeUnit;

import org.jclouds.chef.ChefApi;
import org.jclouds.concurrent.Timeout;

/**
 * Private chef api seems to miss support for HEAD method in the node resource.
 * This class overrides the {@link ChefApi#nodeExists(String)} method to use GET
 * instead of HEAD.
 * 
 * @author Ignasi Barrera
 */
@Timeout(duration = 30, timeUnit = TimeUnit.SECONDS)
public interface PatchedChefApi extends ChefApi {
   /**
    * Check if there exists a node with the given name.
    * 
    * @return <code>true</code> if the specified node name exists.
    */
   @Override
   boolean nodeExists(String name);
}