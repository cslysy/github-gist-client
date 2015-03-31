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

import com.cslysy.githubgist.client.model.Gist;
import org.junit.Test;

/**
 * Test for {@link GitHubGistClientV3}
 * 
 * @author jakubsprega
 */
public class GitHubGistClientV3Test {

    @Test
    public void testSomeMethod() {
        GitHubGistClientV3 gitHubGistClientV3 = new GitHubGistClientV3();
        Gist gist = gitHubGistClientV3.getGist("1ec42d0c86f3d445739f");
        System.out.println(gist);
    }
}
