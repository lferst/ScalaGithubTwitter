
# Scala Github/Twitter Search 

Personal Project used to learn how to deal with Scala. It searches for projects on GitHub, then for each project found, it look up Twitter for tweets that mention it and finally as an output print a summary of each project with a short list of recent tweets, in JSON format

## Getting Started

1 - Install sbt: https://www.scala-sbt.org/1.0/docs/Setup.html

2 - Create a folder 
```
mkdir Reactive
```
3 - Get into the folder 
```
cd Reactive
```
4 - Git clone or download project to current folder
```
git clone https://github.com/lferst/ScalaGithubTwitter.git
```
5 - Edit file src/main/resources/application.conf and enter Twitter account details 

6 - Run sbt (Sbt should recognise build.sbt file in the root folder and download all dependencies) 

7 - From Sbt prompt command execute "Run".  
```
sbt:reactive> Run
```


