package com.cslysy.githubgist.client;

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
     * Return {@link Gist} for the given {@link GitHubUser}
     * 
     * @param gitHubUser
     * @return Set of gists for the given id
     */
    public Set<Gist> getGistFor(GitHubUser gitHubUser);
}
