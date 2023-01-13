# Contributing to Quill

### What are patches?

---

Quill is a combination of patches/extensions for Purpur/Paper. These patches/extensions are split into 2 different directories that operate different portions of the code.

- `Quill-API` - Modifications to `Paper-API`
- `Quill-Server` - Modifications to `Paper-Server`

The entire structure is based on patches and git, A basic understanding of how to use git is required.<br>
You can find a basic tutorial here: https://git-scm.com/docs/gittutorial

__Assuming you have already forked the repository ( Quill )__<br>

Clone your fork of the project to your local computer.

- Open a terminal whether directly inside your IDE or externally then type **./gradlew applyPatches**
  - What this does is give you all the source necessary to properly contribute.
- The next step is to either run cd `Quill-Server` for Server Changes or `Quill-API` for API Changes.
  - Edit files inside these directories with care. It can break plugin compatibility somewhere...
  
`Quill-Server` and `Quill-API` are not considered git repositories in the way you know them as. ( They are mail. )
- `base` points to the unmodified source before Quill patches have been applied.
- Each commit after `base` is a patch.
---

## Adding patches
Adding patches to `Quill` is very simple.
- Modify `Quill-Server` or `Quill-API` with any changes.
- Type `git add.` inside the directory you made changes in.
- Run `git commit -m "Your commit message"`
- Run `./gradlew rebuildPatches` in the root directory to convert your commit into a new patch.
- Pull request or push ( if directly a maintainer ) the generated patch file(s) back to the repository.

Your commit will be converted into a patch that you can push or make a pull request with.

> #### Please note that if you have some specific implementation detail you'd like to document, you should do so in the patch message or in comments.
---

## Modifying Patches
Modifying previous patches is a tad bit complex but once you get the hang out of it. It is very simple, The original CONTRIBUTING.md left out some few minor details.

### Method 1

This method works by temporarily resetting your HEAD to the desired commit to edit it using `git rebase`.

> #### While in the middle of an edit, you will not be able to compile unless you also reset the opposing module(s) to a related commit. In the API's case, you must reset the Server, and reset the API if you're editing the Server. Note also that either module may not compile when doing so. This is not ideal nor intentional, but it happens. Feel free to fix this in a PR to us!
- If you have any changes you are currently working on, Type `git stash` to store them for later.
  - You can type `git stash pop` to retrieve them at any point.
- Type `git rebase -i base` inside either `Quill-Server` or `Quill-API`.
  - It should give you an output like <a href="https://gist.github.com/zachbr/21e92993cb99f62ffd7905d7b02f3159"this</ain the text editor you use.
  - If the editor you have does not have a "menu" at the bottom, You are using `vim`
- In order to edit in `vim`, You need to hit `I` which converts it to `insert` mode, You can now edit anything.
- Replace `pick` with `edit` for the commit or patch you want to modify & save the chances.
  - Only do this for **ONE** commit at a time.
  - You can save changes ( if using `vim` ) by hitting Ctrl + C then typing :wq which will save the file.
- Make the changes you want to the patch.
- Type `git add .` to add your changes.
- Type `git commit --amend` to commit.
  - Make sure to add `--amend` or else a new patch will be created which is a no no.
  - You can also modify the commit message & author here.
- Type `git rebase --continue` to finish rebasing.
- Go back to the root directory and type `./gradlew rebuildPatches`.
  - This will modify all appropriate patches based on your commits.
Pull request or push ( if directly a maintainer ) the generated patch file(s) back to the repository.

### Method 2
> #### If you are simply editing a more recent commit or your change is small, simply making the change at HEAD and then moving the commit after you have tested it may be easier.
> This method has the benefit of being able to compile to test your change without messing with your HEADs.

#### Manual method
- Make your change while at HEAD.
  - Make a temporary commit. You don't need to make a message for this.
  - Type git rebase -i base, move (cut) your temporary commit and move it under the line of the patch you wish to modify.
  - Change the `pick` to the appropriate action.
    - `f`/`fixup`: Merge your changes into the patch without touching the message.
    - `s`/`squash`: Merge your changes into the patch and use your commit message & subject.
    - Type ./gradlew rebuildPatches in the root directory.
      - This will modify the appropriate patches based on your commits.
      - Pull request or push ( if directly a maintainer ) the generated patch file(s) back to the repository.

#### Automatic method

- Make your change while at HEAD;
   - Make a fixup commit. `git commit -a --fixup <hashOfPatchToFix`;
      - You can also use `--squash` instead of `--fixup` if you want the commit
        message to also be changed.
      - You can get the hash by looking at `git log` or `git blame`; your IDE can
        assist you too.
      - Alternatively, If you only know the name of the patch, you can do
        `git commit -a --fixup "Subject of Patch name"`.
  - Rebase with autosquash: `git rebase --autosquash -i base`.
    This will automatically move your fixup commit to the right place, and you just
    need to "save" the changes.
  - Type `./gradlew rebuildPatches` in the root directory;
       - This will modify the appropriate patches based on your commits.
  - Pull request or push ( if directly a maintainer ) the generated patch file(s) back to the repository.
---

## Rebasing Pull Requests

> #### Steps to rebase a Pull Request to include the latest changes from `main`.  
> These steps assume the `origin` remote is your fork of this repository and `upstream` is the official Quill repository.

- Pull the latest changes from upstreams master: `git checkout main && git pull upstream main`.
- Checkout feature/fix branch and rebase on master: `git checkout patch-branch && git rebase main`.
- Apply updated patches: `./gradlew applyPatches`.
- If there are conflicts, fix them.
- If your Pull Request creates new patches instead of modifying exist ones, In both the `Quill-Server` and `Quill-API` directories, Ensure your newly-created patch is the last commit by either:
   * Renaming the patch file with a large 4-digit number in front (e.g. 9999-Patch-to-add-some-new-stuff.patch), and re-applying patches.
   * Running `git rebase --interactive base` and moving the commits to the end.
- Rebuild patches: `./gradlew rebuildPatches`.
- Commit modified patches.
- Force push changes: `git push --force`.
---

## Pull Request Policy

We'll accept changes that make sense. You should be able to justify their
existence, along with any maintenance costs that come with them. Using
[obfuscation helpers](#obfuscation-helpers) aids in the maintenance costs.
Remember that these changes will affect everyone who runs Quill, not just you
and your server.

While we will fix minor formatting issues, you should stick to the guide below
when making and submitting changes.
---

## Formatting

All modifications to non-Quill files should be marked.

- Multi-line changes start with `// Quill start` and end with `// Quill end`;
- You can put a comment with an explanation if it isn't obvious, like this:
 `// Quillstart - reason`.
   - The comments should generally be about the reason the change was made, what
     it was before, or what the change is.
   - Multi-line messages should start with `// Quill start` and use `/* Multi
     line message here */` for the message itself.
- One-line changes should have `// Quill` or `// Quill - reason`.

Here's an example of how to mark changes by Quill:

```java
entity.getWorld().dontbeStupid(); // Quill - was beStupid() which is bad
entity.getFriends().forEach(Entity::explode);
entity.a();
entity.b();
// Quill start - use plugin-set spawn
// entity.getWorld().explode(entity.getWorld().getSpawn());
Location spawnLocation = ((CraftWorld)entity.getWorld()).getSpawnLocation();
entity.getWorld().explode(new BlockPosition(spawnLocation.getX(), spawnLocation.getY(), spawnLocation.getZ()));
// Quill end
```

We generally follow usual Java style (aka. Oracle style), or what is programmed
into most IDEs and formatters by default. There are a few notes, however:
- It is fine to go over 80 lines as long as it doesn't hurt readability.  
 -  There are exceptions, especially in Spigot-related files
- When in doubt or the code around your change is in a clearly different style, Use the same style as the surrounding code.
---

## Patch Notes

When submitting patches to Quill, We may ask you to add notes to the patch
header. While we do not require it for all changes, You should add patch notes
when the changes you're making are technical, complex, or require an explanation
of some kind. It is very likely that your patch will remain long after we've all
forgotten about the details of your PR; patch notes will help us maintain it
without having to dig back through GitHub history looking for your Pull Request.

These notes should express the intent of your patch, as well as any pertinent
technical details we should keep in mind long-term. Ultimately, they exist to
make it easier for us to maintain the patch across major version changes.

If you add a message to your commit in the `Quill-Server`/`Quill-API`
directories, the rebuild patches script will handle these patch notes
automatically as part of generating the patch file. If you are not
extremely careful, You should always just `squash` or `amend` a patch (see the
above sections on modifying patches) and rebuild.

Editing messages and patches by hand is possible, but you should patch and
rebuild afterwards to make sure you did it correctly. This is slower than just
modifying the patches properly after a few times, so you will not really gain
anything but headaches from doing it by hand.

### Underneath is an example patch header/note:

```patch
From 02abc033533f70ef3165a97bfda3f5c2fa58633a Mon Sep 17 00:00:00 2001
From: Shane Freeder <theboyetronic@gmail.com
Date: Sun, 15 Oct 2017 00:29:07 +0100
Subject: [PATCH] revert serverside behavior of keepalives

This patch intends to bump up the time that a client has to reply to the
server back to 30 seconds as per pre 1.12.2, which allowed clients
more than enough time to reply, potentially allowing them to be less
temperamental due to lag spikes on the network thread, e.g. that caused
by plugins that are interacting with netty.

We also add a system property to allow people to tweak how long the server
will wait for a reply. There is a compromise here between lower and higher
values, lower values will mean that dead connections can be closed sooner,
whereas higher values will make this less sensitive to issues such as spikes
from networking or during connections flood of chunk packets on slower clients,
at the cost of dead connections being kept open for longer.

diff --git a/src/main/java/net/minecraft/server/PlayerConnection.java b/src/main/java/net/minecraft/server/PlayerConnection.java
index a92bf8967..d0ab87d0f 100644
--- a/src/main/java/net/minecraft/server/PlayerConnection.java
+++ b/src/main/java/net/minecraft/server/PlayerConnection.java
```

## Obfuscation Helpers

While rarely needed, obfuscation helpers are sometimes useful when it comes
to unmapped local variables, or poorly named method parameters. In an effort
to make future updates easier on ourselves, Quill tries to use obfuscation
helpers wherever it makes sense. The purpose of these helpers is to make the
code more readable and maintainable. These helpers should be made easy to
inline by the JVM wherever possible.

An example of an obfuscation helper for a local variable:
```java
double d0 = entity.getX(); final double fromX = d0; // Quill - OBFHELPER
// ...   
this.someMethod(fromX); // Quill
```

While they may not always be done in exactly the same way, the general goal is
always to improve readability and maintainability. Use your best judgment and do
what fits best in your situation.

## Configuration files

To use a configurable value in your patch, add a new entry in either the
`QuillConfig` or `QuillWorldConfig` classes. Use `QuillConfig` if a value
must remain the same throughout all worlds, or the latter if it can change
between worlds. World-specific configuration options are preferred whenever
possible.

### QuillConfig example

```java
public static boolean saveEmptyScoreboardTeams = false;
private static void saveEmptyScoreboardTeams() {
    // This is called automatically!
    // The name also doesn't matter.
    saveEmptyScoreboardTeams = getBoolean("settings.save-empty-scoreboard-teams", false);
}
```

Notice that the field is always public, but the setter is always private. This
is important to the way the configuration generation system works. To access
this value, reference it as you would any other static value:

```java
if (!QuillConfig.saveEmptyScoreboardTeams) {
```

It is often preferred that you use the fully qualified name for the
configuration class when accessing it, like so:
`io.quillmc.quill.QuillConfig.valueHere`.  
If this is not done, A developer for Quill might fix that for you before
merging, but it's always nice if you make it a habit where you only need 1-2
lines changed.

### QuillWorldConfig example

```java
public boolean useInhabitedTime = true;
private void useInhabitedTime() {
    // This is called automatically!
    // The name also doesn't matter.
    useInhabitedTime = getBoolean("use-chunk-inhabited-timer", true);
}
```

Again, notice that the field is always public, but the setter is always private.
To access this value, you'll need an instance of the `net.minecraft.world.level.Level`
object:

```java
return this.level.quillConfig.useInhabitedTime ? this.inhabitedTime : 0;
```

## Testing API changes

### Using the Quill Test Plugin

The Quill project has a `test-plugin` module for easily testing out API changes
and additions. To use the test plugin, enable it in `test-plugin.settings.gradle.kts`,
which will be generated after running Gradle at least once. After this, you can edit
the test plugin, and run a server with the plugin using `./gradlew runDev` (or any
of the other Quill run tasks).

### Publishing to Maven local (use in external plugins)

To build and install the Quill APIs and Server to your local Maven repository, do the following:

- Run `./gradlew publishToMavenLocal` in the base directory.

If you use Gradle to build your plugin:
- Add `mavenLocal()` as a repository. Gradle checks repositories in the order they are declared,
  so if you also have the Quill repository added, put the local repository above Quill's.
- Make sure to remove `mavenLocal()` when you are done testing, see the [Gradle docs](https://docs.gradle.org/current/userguide/declaring_repositories.html#sec:case-for-maven-local)
  for more details.

If you use Maven to build your plugin:
- If you later need to use the Quill-API, You might want to remove the jar from your local Maven repository.  
  If you use Windows and don't usually build using WSL, You might not need to do this.
---
## FAQ
- __I am confused on what I am doing.__
  - Think of it like a mailbox, The mail-box is your patch. Quill-API for example is the mail & by running ./gradlew rebuildPatches in the root directory. You have put mail in the mailbox!

- __I cannot find the NMS file I need!__
  - By default, Quill (and upstream) only import files we make changes to. If you
      would like to make changes to a file that isn't present in `Quill-Server`'s
      source directory, you just need to add it to our import script ran during the
      patching process.
    - Save (rebuild) any patches you are in the middle of working on! Progress will be lost if you do not.
    - Identify the name(s) of the file(s) you want to import.
      - A complete list of all possible file names can be found at
          `./Quill-Server/.gradle/caches/paperweight/mc-dev-sources/net/minecraft/`. You might find
          [MiniMappingViewer] useful if you need to translate between Mojang and Spigot mapped names.
    - Open the file at `./build-data/dev-imports.txt` and add the name of your file to
        the script. Follow the instructions there.
    - Re-patch the server `./gradlew applyPatches`.
    - Edit away!
  - ❗This change is temporary! **DO NOT COMMIT CHANGES TO THIS FILE!**
  - Once you have made your changes to the new file, and rebuilt patches, You may undo your changes to `dev-imports.txt`.
  - Any file modified in a patch file gets automatically imported, so you only need
     this temporarily to import it to create the first patch.
  - To undo your changes to the file, type `git checkout build-data/dev-imports.txt`.

- __My commit doesn't need a build, What do I do?__
  - You add `[ci-skip]` to the start of your commit.
    - [ci-skip] My awesome commit.

- __Patching and building is very slow, What can I do?__
  - This only applies to Windows, If you're running a prior Windows release, either update to Windows 10 or move to macOS/Linux/BSD.
  - In order to speed up patching process on Windows, it's recommended you get WSL.
    - This is available in Windows 10 v2004, build 19041 or higher. (You can check
        your version by running `winver` in the run window (Windows key + R)). If you're
        out of date, update your system with the
        [Windows Update Assistant](https://www.microsoft.com/en-us/software-download/windows10).
  - To set up WSL 2, follow the information here:
      <https://docs.microsoft.com/en-us/windows/wsl/install-win10

You will most likely want to use the Ubuntu apps. Once it's set up, install the
required tools with `sudo apt-get update && sudo apt-get install $TOOL_NAMES
-y`. Replace `$TOOL_NAMES` with the packages found in the
[requirements](#requirements). You can now clone the repository and do
everything like usual.
 
❗Do not use the `/mnt/` directory in WSL! Instead, mount the WSL directories in Windows like described here:
<https://www.howtogeek.com/426749/how-to-access-your-linux-wsl-files-in-windows-10/

[MiniMappingViewer]: https://minidigger.github.io/MiniMappingViewer/