#### Maven集成Soa Plugin
修改maven的主配置文件（${MAVEN_HOME}/conf/settings.xml文件或者 ~/.m2/settings.xml文件），添加如下配置：

```
<pluginGroups>
    <pluginGroup>com.isuwang</pluginGroup>
  </pluginGroups>
```

#### Maven运行

```
mvn compile com.isuwang:isuwangsoa-maven-plugin:1.0-SNAPSHOT:run
```