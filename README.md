GitAnt
======

Ant task library for accessing Git repositories.

Currently supported tasks include:

1.  **Clone** - clone a repository for building with Ant
2.  **Tag** - tag a repository
3.  **Push** - to push the tag back to the origin so others can get it

To create the GitAnt jar... **Build process under construction**

To use the Git tasks in an Ant script add the following to your build.xml file:

```xml
<project name="Test Build for Git Ant tasks" default="run-build" basedir=".">

  <!-- This puts the git ant task implementation jar             -->
  <!-- on the classpath so ant can find the task implementations -->
  <!-- ######################################################### --> 

  <path id="gitant.classpath">
    <fileset dir="<path to gitant jar>/gitant-0.1/lib">
      <include name="**/*.jar" />
    </fileset>
  </path>

  <!-- This makes sure all the ant definition defined in the  -->
  <!-- gitantlib.xml file are available to and known by ant   -->
  <!-- ###################################################### -->

  <typedef resource="gitantlib.xml"
    classpathref="gitant.classpath" />

  <!-- at this point the git ant tasks are now available for use! -->
  <!-- ########################################################## -->

  <target name="run-build">
    <git>
      <clone url="https://<repository url>.git"
          to="./work/m2m-build" />
      <clone url="https://<repository url>.git"
          to="./work/bcrypt" />

      <tag repo="./work/bcrypt" label="v0.6" />
      <tag repo="./work/m2m-build" label="v0.6" />

      <push repo="./work/bcrypt" tag="v0.6" />
      <push repo="./work/m2m-build" tag="v0.6" />
    </git>
  </target>
</project>
```xml

There's obviuosly a lot more work that needs to be done.  Working on it in my spare time, we'll get it sorted soon.
Check back from time to time.



 

