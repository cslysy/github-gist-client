/*
 * Copyright 2015 jakubsprega.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cslysy.githubgist.client.api;

import java.util.Set;

import com.cslysy.githubgist.client.model.Gist;
import com.cslysy.githubgist.client.model.GitHubUser;

/**
 * GitHub gist client
 * <p> See <a href="https://gist.github.com/">https://gist.github.com/</a></p>
 *
 * @author jakubsprega
 */
public interface GitHubGistClient {

    /**
     * Return {@link Gist} for the given id
     * 
     * @param id gist id
     * @return gist for the given id
     */
    public Gist getGist(String id);
    
     /**
     * Return {@link Gist} list for the given {@link GitHubUser}
     * 
     * @param gitHubUser
     * @return Set of gists for the given id
     */
    public Set<Gist> getGistsFor(GitHubUser gitHubUser);
}
