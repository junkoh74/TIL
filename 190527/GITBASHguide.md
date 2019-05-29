# GIT BASH

## 기본 사용법

Here is how you would do it in Windows:

1. If you don't have git installed, see [this article](https://help.github.com/articles/set-up-git) on how to set it up.
2. Open up a Windows command prompt.
3. Change into the directory where your source code is located in the command prompt.
4. First, create a new repository in this directory `git init`. This will say *"Initialized empty git repository in ....git"* (`...` is the path).
5. Now you need to tell git about your files by adding them to your repository. Do this with `git add filename`. If you want to add all your files, you can do `git add .`
   1. put your path on the folder with file to upload
   2. type **git add _____________ ** to upload a specific file
   3. type **git add .** to upload a whole folder
6. Now that you have added your files and made your changes, you need to *commit* your changes so git can track them. Type `git commit -m "adding files"`. `-m` lets you add the *commit message* in line.
   1. to finalize uploading added file
   2. type **git commit -m "adding files"** 
   3. or git commit -m .
   4. -m : allows to add the commit message

So far, the above steps is what you would do even if you were not using github. They are the normal steps to start a git repository. Remember that git is distributed (decentralized), means you don't need to have a "central server" (or even a network connection), to use git.

Now you want to push the changes to your git repository hosted with github. To you this by telling git to *add a remote location*, and you do that with this command:

```
git remote add origin https://github.com/yourusername/your-repo-name.git
```

Once you have done that, git now knows about your remote repository. You can then tell it to push (which is "upload") your commited files:

```
git push -u origin master
```