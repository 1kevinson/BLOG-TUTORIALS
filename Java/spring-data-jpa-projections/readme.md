### Project Initialization Steps 

1. In order to use this project as a template correctly,
go to the pom.xml file and edit these properties to match the 
title of your project
```xml 
<!-- ... -->
<artifactId>jpa-projections</artifactId>

<name>jpa-projections</name>
<!-- ... -->
```
<br>

2. Go to File -> Project Structure -> Module and change the name
of your project to match the one in `pom.xml`
<br><br>

3. Configure your `application.yml` in the main/resources to match the config
of your production database, and the one in the test/resources to match the
config of your testcontainers database