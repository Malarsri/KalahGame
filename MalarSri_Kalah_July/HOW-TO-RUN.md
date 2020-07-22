# How to Run
This is a step-by-step guide how to build and run the Kalah game using Docker-compose.

* docker-compose.yml:
This is the simplest version providing the Mancala Game implementation.

## Installation

* The Game is implemented in Java. See
   https://www.java.com/en/download/help/download_options.xml . The
   examples need to be compiled so you need to install a JDK (Java
   Development Kit). A JRE (Java Runtime Environment) is not
   sufficient. After the installation you should be able to execute
   `java` and `javac` on the command line.

* The application run in Docker Containers. You need to install Docker
  Community Edition, see https://www.docker.com/community-edition/
  . You should be able to run `docker` after the installation.


* After installing Docker you should also be able to run
  `docker-compose`. If this is not possible, you might need to install
  it separately. See https://docs.docker.com/compose/install/ .

## Build

Change to the directory `kalah` and run `./mvnw clean
install` or `mvnw.cmd clean install` (Windows). This will take a while to download the dependencies and build  
microservice developed for this game: `kalah-api`:

A complete should look like this: [build log](build.log)  

```
/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/bin/java -Dmaven.multiModuleProjectDirectory=/Users/xp49ux/Downloads/kalah -Dmaven.home=/Applications/apache_maven -Dclassworlds.conf=/Applications/apache_maven/bin/m2.conf "-Dmaven.ext.class.path=/Applications/IntelliJ IDEA 2.app/Contents/plugins/maven/lib/maven-event-listener.jar" "-javaagent:/Applications/IntelliJ IDEA 2.app/Contents/lib/idea_rt.jar=62045:/Applications/IntelliJ IDEA 2.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Applications/apache_maven/boot/plexus-classworlds-2.5.2.jar org.codehaus.classworlds.Launcher -Didea.version2020.1.3 -s /Users/xp49ux/Developer/settings.xml -Dmaven.repo.local=/Users/xp49ux/.m2/custom/repository clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building kalah 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ kalah ---
[INFO] Deleting /Users/xp49ux/Downloads/kalah/target
[INFO] 
[INFO] --- maven-resources-plugin:3.1.0:resources (default-resources) @ kalah ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ kalah ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 20 source files to /Users/xp49ux/Downloads/kalah/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:3.1.0:testResources (default-testResources) @ kalah ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 3 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ kalah ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 7 source files to /Users/xp49ux/Downloads/kalah/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ kalah ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.game.util.LinksTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.387 s - in com.game.util.LinksTest
[INFO] Running com.game.service.KalahGameServiceImplTest
04:31:21.227 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating CacheAwareContextLoaderDelegate from class [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
04:31:21.233 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating BootstrapContext using constructor [public org.springframework.test.context.support.DefaultBootstrapContext(java.lang.Class,org.springframework.test.context.CacheAwareContextLoaderDelegate)]
04:31:21.242 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating TestContextBootstrapper for test class [com.game.service.KalahGameServiceImplTest] from class [org.springframework.boot.test.context.SpringBootTestContextBootstrapper]
04:31:21.256 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.game.service.KalahGameServiceImplTest], using SpringBootContextLoader
04:31:21.257 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.game.service.KalahGameServiceImplTest]: class path resource [com/game/service/KalahGameServiceImplTest-context.xml] does not exist
04:31:21.258 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.game.service.KalahGameServiceImplTest]: class path resource [com/game/service/KalahGameServiceImplTestContext.groovy] does not exist
04:31:21.258 [main] INFO org.springframework.test.context.support.AbstractContextLoader - Could not detect default resource locations for test class [com.game.service.KalahGameServiceImplTest]: no resource found for suffixes {-context.xml, Context.groovy}.
04:31:21.259 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils - Could not detect default configuration classes for test class [com.game.service.KalahGameServiceImplTest]: KalahGameServiceImplTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
04:31:21.282 [main] DEBUG org.springframework.test.context.support.ActiveProfilesUtils - Could not find an 'annotation declaring class' for annotation type [org.springframework.test.context.ActiveProfiles] and class [com.game.service.KalahGameServiceImplTest]
04:31:21.364 [main] DEBUG org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider - Identified candidate component class: file [/Users/xp49ux/Downloads/kalah/target/classes/com/game/KalahApplication.class]
04:31:21.365 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Found @SpringBootConfiguration com.game.KalahApplication for test class com.game.service.KalahGameServiceImplTest
04:31:21.403 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - @TestExecutionListeners is not present for class [com.game.service.KalahGameServiceImplTest]: using defaults.
04:31:21.404 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener, org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPublishingTestExecutionListener]
04:31:21.413 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Skipping candidate TestExecutionListener [org.springframework.test.context.transaction.TransactionalTestExecutionListener] due to a missing dependency. Specify custom listener classes or make the default listener classes and their required dependencies available. Offending class: [org/springframework/transaction/interceptor/TransactionAttributeSource]
04:31:21.414 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Skipping candidate TestExecutionListener [org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener] due to a missing dependency. Specify custom listener classes or make the default listener classes and their required dependencies available. Offending class: [org/springframework/transaction/interceptor/TransactionAttribute]
04:31:21.414 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@4f3bbf68, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@5be46f9d, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@3f91b517, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@68702e03, org.springframework.test.context.support.DirtiesContextTestExecutionListener@7a220c9a, org.springframework.test.context.event.EventPublishingTestExecutionListener@2421cc4, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@30c93896, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener@59a008ba, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@338c99c8, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@21ba0741, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@58ce9668, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener@172b013]
04:31:21.416 [main] DEBUG org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener - Before test class: context [DefaultTestContext@2c78d320 testClass = KalahGameServiceImplTest, testInstance = [null], testMethod = [null], testException = [null], mergedContextConfiguration = [WebMergedContextConfiguration@132e0cc testClass = KalahGameServiceImplTest, locations = '{}', classes = '{class com.game.KalahApplication}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true}', contextCustomizers = set[org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@1a5a4e19, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@3e78b6a5, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.client.TestRestTemplateContextCustomizer@68746f22, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@638ef7ed, org.springframework.boot.test.context.SpringBootTestArgs@1], resourceBasePath = 'src/main/webapp', contextLoader = 'org.springframework.boot.test.context.SpringBootContextLoader', parent = [null]], attributes = map['org.springframework.test.context.web.ServletTestExecutionListener.activateListener' -> true]], class annotated with @DirtiesContext [true] with mode [AFTER_CLASS].
04:31:21.435 [main] DEBUG org.springframework.test.context.support.TestPropertySourceUtils - Adding inlined properties to environment: {spring.jmx.enabled=false, org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true}

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.1.RELEASE)

2020-07-22 04:31:21.670  INFO 20750 --- [           main] c.game.service.KalahGameServiceImplTest  : Starting KalahGameServiceImplTest on APM3LC02SH1F9G8WP with PID 20750 (started by xp49ux in /Users/xp49ux/Downloads/kalah)
2020-07-22 04:31:21.672  INFO 20750 --- [           main] c.game.service.KalahGameServiceImplTest  : No active profile set, falling back to default profiles: default
2020-07-22 04:31:23.009  INFO 20750 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-07-22 04:31:24.004  INFO 20750 --- [           main] c.game.service.KalahGameServiceImplTest  : Started KalahGameServiceImplTest in 2.559 seconds (JVM running for 3.691)
2020-07-22 04:31:24.258  INFO 20750 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.011 s - in com.game.service.KalahGameServiceImplTest
[INFO] Running com.game.service.KalahGameExecutorServiceImplTest
2020-07-22 04:31:24.261  INFO 20750 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.game.service.KalahGameExecutorServiceImplTest], using SpringBootContextLoader
2020-07-22 04:31:24.261  INFO 20750 --- [           main] o.s.t.c.support.AbstractContextLoader    : Could not detect default resource locations for test class [com.game.service.KalahGameExecutorServiceImplTest]: no resource found for suffixes {-context.xml, Context.groovy}.
2020-07-22 04:31:24.261  INFO 20750 --- [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [com.game.service.KalahGameExecutorServiceImplTest]: KalahGameExecutorServiceImplTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2020-07-22 04:31:24.263  INFO 20750 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration com.game.KalahApplication for test class com.game.service.KalahGameExecutorServiceImplTest
2020-07-22 04:31:24.265  INFO 20750 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener, org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPublishingTestExecutionListener]
2020-07-22 04:31:24.266  INFO 20750 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@6f2e1024, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@536d97f8, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@3c50ad4b, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@37496720, org.springframework.test.context.support.DirtiesContextTestExecutionListener@28f9fedd, org.springframework.test.context.event.EventPublishingTestExecutionListener@17947e6d, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@2e17a321, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener@521bb1a4, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@35f3a22c, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@1a0c5e9, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@123d7057, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener@1d247525]

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.1.RELEASE)

2020-07-22 04:31:24.301  INFO 20750 --- [           main] c.g.s.KalahGameExecutorServiceImplTest   : Starting KalahGameExecutorServiceImplTest on APM3LC02SH1F9G8WP with PID 20750 (started by xp49ux in /Users/xp49ux/Downloads/kalah)
2020-07-22 04:31:24.302  INFO 20750 --- [           main] c.g.s.KalahGameExecutorServiceImplTest   : No active profile set, falling back to default profiles: default
2020-07-22 04:31:24.659  INFO 20750 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-07-22 04:31:25.031  INFO 20750 --- [           main] c.g.s.KalahGameExecutorServiceImplTest   : Started KalahGameExecutorServiceImplTest in 0.763 seconds (JVM running for 4.719)
2020-07-22 04:31:25.067  INFO 20750 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.803 s - in com.game.service.KalahGameExecutorServiceImplTest
[INFO] Running com.game.entities.kalah.PitIdTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 s - in com.game.entities.kalah.PitIdTest
[INFO] Running com.game.entities.kalah.PlayerTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 s - in com.game.entities.kalah.PlayerTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 14, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-jar-plugin:3.2.0:jar (default-jar) @ kalah ---
[INFO] Building jar: /Users/xp49ux/Downloads/kalah/target/kalah-0.0.1-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ kalah ---
[INFO] Installing /Users/xp49ux/Downloads/kalah/target/kalah-0.0.1-SNAPSHOT.jar to /Users/xp49ux/.m2/custom/repository/com/malar/game/kalah/0.0.1-SNAPSHOT/kalah-0.0.1-SNAPSHOT.jar
[INFO] Installing /Users/xp49ux/Downloads/kalah/pom.xml to /Users/xp49ux/.m2/custom/repository/com/malar/game/kalah/0.0.1-SNAPSHOT/kalah-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 10.768 s
[INFO] Finished at: 2020-07-22T04:31:25+02:00
[INFO] Final Memory: 43M/412M
[INFO] ------------------------------------------------------------------------


If this does not work:

* Ensure that `settings.xml` in the directory `.m2` in your home
directory contains no configuration for a specific Maven repo. If in
doubt: delete the file.

* The tests use some ports on the local machine. Make sure that no
server runs in the background.

* Skip the tests: `./mvnw clean package -Dmaven.test.skip=true` or
  `mvnw.cmd clean package -Dmaven.test.skip=true` (Windows).

* In rare cases dependencies might not be downloaded correctly. In
  that case: Remove the directory `repository` in the directory `.m2`
  in your home directory. Note that this means all dependencies will
  be downloaded again.


Before start building the images, please make sure you have allocated at least `4GB Memory` and `4 CPU cores` to your Docker Desktop.

First you need to build the Docker images. Change to the directory
`docker` and run `docker-compose` command as below. This will download some base
images, install software into Docker images and will therefore take
its time:

```

```


Now you can start the containers using `docker-compose` command. The
`-d` option means that the containers will be started in the
background and won't output their stdout to the command line:

```
<your-directory>docker-compose -f docker-compose.yml up -d

```

Now, you can open <http://localhost> page and play the game!
   
You can terminate all containers and deletes their respective images using `docker-compose  -f docker-compose.yml down --rmi all`.
```
```

