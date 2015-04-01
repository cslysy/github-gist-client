[![Build Status](https://travis-ci.org/cslysy/github-gist-client.svg)](https://travis-ci.org/cslysy/github-gist-client)

# GitHubGist Java client

Java client for [http://gist.github.com](http://gist.github.com)

##Usage

Get a single public gist:
```java
GitHubGistClient gitHubGistClient = new GitHubGistClientV3();
Gist gist = gitHubGistClient.getGist("123");
```
List a user public gists:
```java
GitHubGistClient gitHubGistClient = new GitHubGistClientV3();
Set<Gist> gists = gitHubGistClient.getGistsFor(new GitHubUser("githubusername"));
```
