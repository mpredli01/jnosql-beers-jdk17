# Craft Beer Database Application
## Version 1.0.5 Complete Changelog
## Based on Jakarta NoSQL 1.0.0-b5

### pom.xml file

* Bump `<maven.compiler.source>17</maven.compiler.source>` to `<maven.compiler.source>17</maven.compiler.source>`
* Bump `<maven.compiler.target>17</maven.compiler.target>` to `<maven.compiler.target>17</maven.compiler.target>`
* Bump `<jakarta.nosql.version>1.0.0-b4</jakarta.nosql.version>` to `<jakarta.nosql.version>1.0.0-b5</jakarta.nosql.version>`
* Bump `<microprofile.config.version>3.0.1</microprofile.config.version>` to `<microprofile.config.version>3.0.2</microprofile.config.version>`                                                             
* Bump `<smallrye.config.version>2.8.1</smallrye.config.version>` to `<smallrye.config.version>2.12.1</smallrye.config.version>`
* Bump `<jboss.weld.se.version>3.1.8.Final</jboss.weld.se.version>` to `<jboss.weld.se.version>3.1.9.Final</jboss.weld.se.version>`
* Change `<artifactId>mongodb-driver</artifactId>` to `<artifactId>jnosql-mongodb-driver</artifactId>`
* Change `<artifactId>mapping-document</artifactId>` to `<artifactId>jnosql-mapping-document</artifactId>`
* Downgrade `<yasson.version>2.0.3</yasson.version>` to `<yasson.version>1.0.11</yasson.version>`
* Remove `<jakartaee.version>8.0.0</jakartaee.version>`

### ManagerProducer.java

* Remove `ManagerProducer.java`
* Supplying the properties are sufficient. A Manager class is no longer required.

### beans.xml

* Update to Jakarta EE annotations
