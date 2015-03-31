package com.cslysy.githubgist.client.model;

/**
 * Object representation of github user
 *
 * @author jakubsprega
 */
public class GitHubUser {

    private String username;

    public GitHubUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
