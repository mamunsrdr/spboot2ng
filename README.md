# Spring boot 2 Ng 6 [![Build Status](https://travis-ci.org/mamunsrdr/spboot2ng.svg?branch=master)](https://travis-ci.org/mamunsrdr/spboot2ng)
A **Spring boot 2** and **angular 6** starter project<br>

### What's included
* spring boot 2.0.5
* angular: 6.1.0

### Project structure
Angular app is placed under `src/main/resources/static` directory with following modification on `angular.json`:
```
"outputPath": "src/main/resources/static",

//moved environment under app
"replace": "src/app/environments/environment.ts",
"with": "src/app/environments/environment.prod.ts"
```
Also added template resolver config to resolve `index.html` view from static folder
```
@Bean
public ITemplateResolver clientTemplateResolver() {
    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    resolver.setPrefix("classpath:/static/");
    resolver.setSuffix(".html");
    resolver.setTemplateMode(TemplateMode.HTML);
    resolver.setCacheable(false);
    resolver.setOrder(1);
    return resolver;
}

@Bean
public TemplateEngine appTemplateEngine() {
    ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
    resolver.setSuffix(".html");
    resolver.setCharacterEncoding("UTF-8");
    resolver.setTemplateMode(TemplateMode.HTML);
    TemplateEngine templateEngine = new TemplateEngine();
    templateEngine.setTemplateResolver(resolver);
    return templateEngine;
}
```

### Gradle plugin and tasks
```
buildscript {
    // ... other configs ...
    dependencies {
        // ... other classpath dependencies ...
        classpath "com.moowork.gradle:gradle-node-plugin:1.2.0"
    }
}
// apply plugin
apply plugin: "com.moowork.node"
```
```
node {
    version = "10.8.0"
    npmVersion = '6.2.0'
    download = true
}

task buildApp(type: NpmTask, dependsOn: 'npmInstall') {
    group = 'build'
    args = ['run', 'build']
}

task buildWatch(type: NpmTask, dependsOn: 'npmInstall') {
    group = 'application'
    args = ['run', 'buildWatch']
}

clean {
    def ft = fileTree('src/main/resources/static')
    ft.visit { FileVisitDetails fvd ->
        delete fvd.file
    }
}

war {
    dependsOn 'buildApp'
}

```


### Sample command
```
// to build war with angular app
# gradlew bootRun

// run this watcher task
# ./gradlew buildWatch
// or for win
# gradlew buildWatch

// build war file as usual
# gradlew assemble
```
Personally in IntelliJ idea I like to run debug window and terminal (`gradlew buildWatch`) side by side like this:
![Screenshot](https://i.imgur.com/mKwBdef.png)
