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
package com.cslysy.githubgist.client.v3;

import com.cslysy.githubgist.client.api.GitHubGistClient;
import com.cslysy.githubgist.client.model.Gist;
import com.cslysy.githubgist.client.model.GitHubUser;
import com.google.common.base.Joiner;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link GitHubGistClient} implementation for GitHub API v3
 *
 * <p>
 * See<a href=https://developer.github.com/v3/">https://developer.github.com/v3/</a></p>
 *
 * @author jakubsprega
 */
public class GitHubGistClientV3 implements GitHubGistClient {
    
    private static final Logger logger = LoggerFactory.getLogger(GitHubGistClientV3.class);

    /* Base url for GitHub API */
    private final String baseUrl;

    /**
     * Default constructor
     * <p>
     * Creates client with default API URL https://api.github.com</p>
     */
    public GitHubGistClientV3() {
        this("https://api.github.com");
    }

    /**
     * Constructor
     *
     * @param baseUrl base URL for GitHub API
     */
    public GitHubGistClientV3(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public Gist getGist(String id) {
        try {
            HttpResponse httpResponse = Unirest.get(
                String.format("%s/gists/%s", baseUrl, id)
            ).asJson();

            return new Gist(id, httpResponse.getBody().toString());
        } catch (UnirestException ex) {
            logger.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Set<Gist> getGistsFor(GitHubUser gitHubUser) {
        try {
            HttpResponse httpResponse = Unirest.get(
                String.format("%s/users/%s/gists", baseUrl, gitHubUser.getUsername())
            ).asJson();

            return null;
        } catch (UnirestException ex) {
            logger.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }

}
