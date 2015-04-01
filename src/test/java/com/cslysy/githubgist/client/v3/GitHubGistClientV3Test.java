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

import com.cslysy.githubgist.client.model.GitHubUser;
import static com.xebialabs.restito.builder.verify.VerifyHttp.verifyHttp;
import static com.xebialabs.restito.semantics.Condition.method;
import static com.xebialabs.restito.semantics.Condition.uri;
import com.xebialabs.restito.server.StubServer;
import org.glassfish.grizzly.http.Method;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link GitHubGistClientV3}
 *
 * @author jakubsprega
 */
public class GitHubGistClientV3Test {

    private StubServer restioServer;
    private int restioServerPort;

    @Before
    public void start() {
        restioServer = new StubServer().run();
        restioServerPort = restioServer.getPort();
    }
    
    @After
    public void stop() {
        restioServer.stop();
    }

    /**
     * Test if GitHubGistClientV3 use correct path to retrieve single gist
     */
    @Test
    public void shouldUseCorrectSingleGistPath() {
        //given
        GitHubGistClientV3 gitHubGistClientV3 = new GitHubGistClientV3(getGitHubBaseUrl());
        //when
        gitHubGistClientV3.getGist("123");
        //then
        verifyHttp(restioServer).once(
            method(Method.GET), uri("/gists/123")
        );   
    }
    
    /**
     * Test if GitHubGistClientV3 use correct path to retrieve all gists for the
     * given user
     */
    @Test
    public void shouldUseCorrectUserGistsPath() {
        //given
        GitHubGistClientV3 gitHubGistClientV3 = new GitHubGistClientV3(getGitHubBaseUrl());
        //when
        gitHubGistClientV3.getGistsFor(new GitHubUser("githubusername"));
        //then
        verifyHttp(restioServer).once(
            method(Method.GET), uri("/users/githubusername/gists")
        );   
    }
    
    /**
     * Prepare GitHub API mock URL
     * 
     * @return mock URL
     */
    private String getGitHubBaseUrl(){
        return String.format("http://localhost:%s", restioServerPort);
    }
}
